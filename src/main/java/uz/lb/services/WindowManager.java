package uz.lb.services;

import javafx.animation.*;                             // Animatsiya uchun JavaFX Timeline, KeyFrame, KeyValue va hokazo
import javafx.beans.property.*;                        // Property (DoubleProperty, ObjectProperty va hokazo)
import javafx.geometry.Rectangle2D;                    // Ekran chegaralari (x, y, width, height)
import javafx.scene.Scene;                             // JavaFX sahna (Stage ichidagi root)
import javafx.scene.input.*;                           // Klaviatura va sichqoncha eventlari
import javafx.scene.layout.Pane;                       // Drag qilinadigan panel (title bar)
import javafx.stage.Screen;                            // Monitorlar haqida ma'lumot (multi-monitor uchun)
import javafx.stage.Stage;                             // Oynaning o'zi (Window)
import javafx.util.Duration;                           // Animatsiya davomiyligi birligi
import uz.lb.enums.WindowState;                        // Oynaning holati enum (NORMAL, MAXIMIZED, SNAP)

/**
 * WindowManager:
 * - Bitta joyda oynaning barcha xatti-harakatlarini boshqaradi (singleton)
 * - Fullscreen (maximized) / restore
 * - Drag / snap (chap-o'ng-yuqori)
 * - Multi-monitorni hisobga oladi
 * - Tepaga tekkizganda animatsiyasiz fullscreen bo'ladi
 */
public class WindowManager {

    // ===== SINGLETON QISMI =====

    private WindowManager() {                          // Private konstruktor – tashqaridan new WindowManager() qilishni cheklash
    }

    private static final WindowManager INSTANCE = new WindowManager(); // Bitta statik instansiya (singleton)

    public static WindowManager getInstance() {        // Tashqaridan foydalanish uchun getter
        return INSTANCE;                               // Bitta instansiyani qaytaramiz
    }

    // ===== ASOSIY FIELDLAR =====

    private Stage stage;                               // Asosiy oyna (Stage)
    private Pane dragPane;                             // Drag qilinadigan title panel

    private final DoubleProperty dragX = new SimpleDoubleProperty();  // Drag boshlangan paytdagi kursor va oynaning X ofseti
    private final DoubleProperty dragY = new SimpleDoubleProperty();  // Drag boshlangan paytdagi kursor va oynaning Y ofseti

    private double savedX, savedY, savedWidth, savedHeight;           // NORMAL holatdan oldingi saqlangan koordinata va o'lchamlar
    private boolean hasSavedBounds = false;                           // Yuqoridagi qiymatlar saqlangan-saqlanmagan flag

    private boolean draggingFromDocked = false;                       // MAXIMIZED yoki SNAP holatdan drag boshlangan flag
    private double dragRatioX = 0.0;                                  // Ekranga nisbatan kursorning gorizontal ulushi (0..1)

    private DoubleProperty animX, animY, animW;                       // Animatsiya uchun X, Y va Width property'lar
    private Timeline smoothMover;                                     // Animatsiyani boshqaruvchi Timeline

    private static final int SNAP_THRESHOLD = 25;                      // Snap zonasi (piksel bo'yicha chetga yaqinlik chegarasi)

    // Oynaning holatini kuzatish uchun property (NORMAL, MAXIMIZED, SNAP)
    private final SimpleObjectProperty<WindowState> windowState =
            new SimpleObjectProperty<>(WindowState.NORMAL);           // Dastlab NORMAL holatda

    public ReadOnlyObjectProperty<WindowState> windowStateProperty() { // Tashqaridan listener ulash uchun property getter
        return windowState;                                            // ReadOnly sifatida qaytaramiz
    }

    public WindowState getWindowState() {                             // Joriy holatni oddiy o'qish uchun getter
        return windowState.get();                                     // Enum qiymatni qaytaradi
    }

    private double lastMouseX = 0;                                    // Oxirgi qayd etilgan sichqonchaning ekrandagi X koordinatasi
    private double lastMouseY = 0;                                    // Oxirgi qayd etilgan sichqonchaning ekrandagi Y koordinatasi

    // ===== INIT METODI =====

    /**
     * WindowManager'ni boshlang'ich sozlash:
     * - Stage va dragPane ni biriktirish
     * - Animatsiya propertylarini ulash
     * - Drag va klaviatura handlerlarini o'rnatish
     */
    public void init(Stage stage, Pane dragPane) {
        this.stage = stage;                                           // Kirib kelgan Stage'ni saqlaymiz
        this.dragPane = dragPane;                                     // Drag qilinadigan panelni saqlaymiz

        animX = new SimpleDoubleProperty(stage.getX());               // animX boshlang'ich qiymati - oynaning hozirgi X koordinatasi
        animY = new SimpleDoubleProperty(stage.getY());               // animY boshlang'ich qiymati - hozirgi Y koordinatasi
        animW = new SimpleDoubleProperty(stage.getWidth());           // animW boshlang'ich qiymati - hozirgi eni

        animX.addListener((o, ov, nv) -> stage.setX(nv.doubleValue()));   // animX o'zgarsa, Stage X koordinatasi ham o'zgaradi
        animY.addListener((o, ov, nv) -> stage.setY(nv.doubleValue()));   // animY o'zgarsa, Stage Y koordinatasi ham o'zgaradi
        animW.addListener((o, ov, nv) -> stage.setWidth(nv.doubleValue())); // animW o'zgarsa, Stage eni ham o'zgaradi

        setupDragHandlers();                                          // Drag bilan bog'liq eventlarni sozlaymiz
        setupShortcuts();                                             // F11 kabi klaviatura qisqa tugmalarini sozlaymiz
    }

    // ===== KLAVIATURA SHORTCUTLAR (F11) =====

    /**
     * F11 tugmasini FULLSCREEN togglega bog'laymiz.
     */
    private void setupShortcuts() {
        Scene scene = stage.getScene();                               // Stage'dan sahnani olamiz
        if (scene == null)
            return;                                    // Agar scene hali null bo'lsa, hech narsa qilmaymiz

        scene.addEventHandler(KeyEvent.KEY_PRESSED, e -> {            // Har bir tugma bosilishiga handler qo'shamiz
            if (e.getCode() == KeyCode.F11) {                         // F11 bosilganini tekshiramiz
                toggleFullScreen();                                   // Fullscreen holatini almashtiramiz
                e.consume();                                          // Eventni boshqa handlerlarga yubormaymiz
            }
        });
    }

    // ===== PUBLIC ACTIONLAR (FULLSCREEN, MINIMIZE, CLOSE) =====

    /**
     * Fullscreen holatini toggel qilish:
     * - Agar NORMAL bo'lsa → MAXIMIZED qilamiz
     * - Aks holda → restore (oldingi holatga qaytamiz)
     */
    public void toggleFullScreen() {
        if (windowState.get() == WindowState.NORMAL)                  // Agar hozir NORMAL bo'lsa
            maximize();                                               // Full ekran qilamiz
        else
            restore();                                                // Aks holda - eski o'lchamga qaytaramiz
    }

    /**
     * Oynani minimize qilish (taskbarga tushirish).
     */
    public void minimize() {
        stage.setIconified(true);                                     // Iconified true → oyna minimize bo'ladi
    }

    /**
     * Oynani butunlay yopish.
     */
    public void close() {
        stage.close();                                                // Stage ni yopamiz
    }

    // ===== MAXIMIZE / RESTORE =====

    /**
     * Fullscreen (maximize) qilish:
     * - Cursor qaysi ekranda turgan bo'lsa, o'sha ekranga to'liq joylashtiriladi.
     * - Agar hozir NORMAL yoki SNAP bo'lsa, eski holatni saqlab qo'yamiz.
     */
    private void maximize() {
        if (windowState.get() == WindowState.NORMAL                   // Agar NORMAL holatda turgan bo'lsa
                || windowState.get() == WindowState.SNAP) {           // yoki SNAP holatda bo'lsa
            saveBounds();                                             // Eski (NORMAL) holatni saqlab qolamiz
        }

        Screen screen = getScreenForCursor();                         // Sichqoncha qaysi ekranda turganini topamiz
        Rectangle2D b = screen.getVisualBounds();                     // O'sha ekranning ishlatiladigan hududi (taskbarsiz)

        stage.setX(b.getMinX());                                      // Oynaning X sini ekranning chap tomoniga qo'yamiz
        stage.setY(b.getMinY());                                      // Y ni ekranning yuqori tomoniga qo'yamiz
        stage.setWidth(b.getWidth());                                 // Enini ekranning eniga teng qilamiz
        stage.setHeight(b.getHeight());                               // Balandligini ekranning balandligiga teng qilamiz

        windowState.set(WindowState.MAXIMIZED);                       // Holatni MAXIMIZED deb belgilaymiz
    }

    /**
     * Eski saqlangan holatga qaytarish.
     */
    private void restore() {
        if (hasSavedBounds) {                                         // Agar oldin bounds saqlangan bo'lsa
            stage.setX(savedX);                                       // Eski X ga qaytamiz
            stage.setY(savedY);                                       // Eski Y ga qaytamiz
            stage.setWidth(savedWidth);                               // Eski eniga qaytamiz
            stage.setHeight(savedHeight);                             // Eski balandligiga qaytamiz
        }
        windowState.set(WindowState.NORMAL);                          // Holatni NORMAL deb belgilaymiz
    }

    /**
     * Eski (NORMAL) holatdagi koordinata va o'lchamlarni saqlab qo'yish.
     */
    private void saveBounds() {
        if (windowState.get() == WindowState.NORMAL) {                // Faqat NORMAL holatda saqlaymiz
            savedX = stage.getX();                                    // Hozirgi X koordinatasini saqlaymiz
            savedY = stage.getY() >= 0.0 ? stage.getY() : 0.0;                                   // Hozirgi Y koordinatasini saqlaymiz (endi 0 ga kesmaymiz)
            savedWidth = stage.getWidth();                            // Hozirgi enini saqlaymiz
            savedHeight = stage.getHeight();                          // Hozirgi balandligini saqlaymiz
            hasSavedBounds = true;                                    // Saqlanganini belgilaymiz
        }
    }

    // ===== DRAG LOGIKA (MOUSE) =====

    /**
     * Title panel uchun sichqoncha handlerlarini sozlaymiz:
     * - harakatlanishida (moved)
     * - bosilishida (pressed)
     * - sudrashida (dragged)
     * - qo'yib yuborishda (released)
     */
    private void setupDragHandlers() {

        dragPane.setOnMouseMoved(e -> {                               // Sichqoncha panel ustida harakatlanganda
            lastMouseX = e.getScreenX();                              // Ekrandagi X koordinatasini saqlaymiz
            lastMouseY = e.getScreenY();                              // Ekrandagi Y koordinatasini saqlaymiz
        });

        dragPane.setOnMousePressed(e -> {                             // Sichqoncha bosilganda
            lastMouseX = e.getScreenX();                              // Oxirgi X ni yangilaymiz
            lastMouseY = e.getScreenY();                              // Oxirgi Y ni yangilaymiz
            handlePress(e);                                           // Ichki press handlerni chaqiramiz
        });

        dragPane.setOnMouseDragged(e -> {                             // Sichqoncha sudralganda
            lastMouseX = e.getScreenX();                              // Oxirgi X ni yangilaymiz
            lastMouseY = e.getScreenY();                              // Oxirgi Y ni yangilaymiz
            handleDrag(e);                                            // Ichki drag handlerni chaqiramiz
        });

        dragPane.setOnMouseReleased(this::handleRelease);             // Qo'yib yuborilganda releaseni chaqiramiz
    }

    /**
     * Drag boshlangan paytdagi logika.
     */
    private void handlePress(MouseEvent e) {
        if (smoothMover != null)
            smoothMover.stop();                  // Agar animatsiya ishlayotgan bo'lsa, uni to'xtatamiz

        WindowState state = windowState.get();                        // Hozirgi holatni olib olamiz

        if (state != WindowState.NORMAL) {                            // Agar oyna MAXIMIZED yoki SNAP bo'lsa
            draggingFromDocked = true;                                // Docked holatdan ajratish boshlangan deb belgilaymiz

            Screen screen = getScreenForPoint(e.getScreenX(), e.getScreenY()); // Sichqoncha qaysi ekranda turganini topamiz
            Rectangle2D b = screen.getVisualBounds();                 // O'sha ekranning vizual chegaralarini olamiz

            dragRatioX = (e.getScreenX() - b.getMinX()) / b.getWidth(); // Sichqonchaning ekranga nisbatan gorizontal ulushi (0..1)
        } else {                                                      // Agar NORMAL holatda bo'lsa
            draggingFromDocked = false;                               // Docked emas, oddiy drag
            dragX.set(e.getScreenX() - stage.getX());                 // Kursor va oynaning X ofsetini saqlaymiz
            dragY.set(e.getScreenY() - stage.getY());                 // Kursor va oynaning Y ofsetini saqlaymiz
        }
    }

    /**
     * Drag davomida ishlaydigan logika.
     */
    private void handleDrag(MouseEvent e) {
        if (draggingFromDocked) {                                     // Agar MAXIMIZED yoki SNAP holatdan drag boshlangan bo'lsa

            draggingFromDocked = false;                               // Bu flag faqat birinchi drag event uchun edi

            if (hasSavedBounds) {                                     // Agar eski NORMAL holat saqlangan bo'lsa
                stage.setWidth(savedWidth);                           // Eski enini tiklaymiz
                stage.setHeight(savedHeight);                         // Eski balandligini tiklaymiz

                double newX = e.getScreenX() - dragRatioX * savedWidth; // Sichqoncha ulushiga qarab yangi X ni hisoblaymiz
                stage.setX(newX);                                     // Oynaning X koordinatasini shu qiymatga o'rnatamiz
            }

            dragX.set(e.getScreenX() - stage.getX());                 // Endi oddiy drag uchun yangi X ofset
            dragY.set(e.getScreenY() - stage.getY());                 // Yangi Y ofset

            windowState.set(WindowState.NORMAL);                      // Holatni NORMAL deb yangilaymiz
        }

        stage.setX(e.getScreenX() - dragX.get());                     // Har drag eventda oynani kursor bo'yicha X ga ko'chiramiz
        stage.setY(e.getScreenY() - dragY.get());                     // Har drag eventda oynani kursor bo'yicha Y ga ko'chiramiz
    }

    // ===== SNAP & RELEASE =====

    /**
     * Sichqoncha qo'yib yuborilgandagi logika:
     * - Tepaga tekkizilsa → animatsiyasiz FULLSCREEN
     * - Chap chetga tekkizilsa → chap SNAP (½ ekran)
     * - O'ng chetga tekkizilsa → o'ng SNAP (½ ekran)
     * - Aks holda → kichik smoothing animatsiya
     */
    private void handleRelease(MouseEvent e) {

        double sx = e.getScreenX();                                   // Sichqonchaning ekrandagi X koordinatasi
        double sy = e.getScreenY();                                   // Sichqonchaning ekrandagi Y koordinatasi
        Screen screen = getScreenForPoint(sx, sy);                    // Sichqoncha turgan ekranni topamiz
        Rectangle2D b = screen.getVisualBounds();                     // Shu ekranning vizual chegarasi

        double finalX = stage.getX();                                 // Yakuniy X (agar snap bo'lmasa, hozirgi X)
        double finalY = stage.getY();                                 // Yakuniy Y
        double finalW = stage.getWidth();                             // Yakuniy eni
        double finalH = stage.getHeight();                            // Yakuniy balandligi

        WindowState current = windowState.get();                      // Hozirgi oynaning holati
        WindowState target = WindowState.NORMAL;                      // Maqsad holat (default NORMAL)

        // 1) TEPAGA TEKKIZISH → FULLSCREEN (ANIMATSIYASIZ)
        if (sy <= b.getMinY() + SNAP_THRESHOLD) {                     // Agar sichqoncha ekranning yuqori chetiga yaqin bo'lsa

            if (current == WindowState.NORMAL) {                      // Agar hozir NORMAL bo'lsa
                saveBounds();                                         // Eski holatni saqlab qo'yamiz
            }

            stage.setX(b.getMinX());                                  // Oynani ekranning chap tomonga qo'yamiz
            stage.setY(b.getMinY());                                  // Oynani ekranning yuqori chetiga qo'yamiz
            stage.setWidth(b.getWidth());                             // Enini butun ekranga teng qilamiz
            stage.setHeight(b.getHeight());                           // Balandligini ham butun ekranga teng qilamiz

            windowState.set(WindowState.MAXIMIZED);                   // Holatni MAXIMIZED deb belgilaymiz
            return;                                                   // Bu yerda animatsiya qilmaymiz, darhol qaytamiz
        }

        // 2) CHAP SNAP (½ ekran)
        else if (sx <= b.getMinX() + SNAP_THRESHOLD) {                // Agar sichqoncha chap chetga yaqin bo'lsa
            finalX = b.getMinX();                                     // Oynaning X i ekranning chap tomoni
            finalY = b.getMinY();                                     // Y i ekranning yuqori tomoni
            finalW = b.getWidth() / 2;                                // Ekranning yarmi enida
            finalH = b.getHeight();                                   // Balandligi butun ekranga teng
            target = WindowState.SNAP;                                // Holat SNAP bo'ladi
        }

        // 3) O'NG SNAP (½ ekran)
        else if (sx >= b.getMaxX() - SNAP_THRESHOLD) {                // Agar sichqoncha o'ng chetga yaqin bo'lsa
            finalX = b.getMinX() + b.getWidth() / 2;                  // X ni ekranning o'ng yarmidan boshlaymiz
            finalY = b.getMinY();                                     // Y i yuqori chetda
            finalW = b.getWidth() / 2;                                // Enini yarim ekran
            finalH = b.getHeight();                                   // Balandlik butun ekranga teng
            target = WindowState.SNAP;                                // Holat SNAP
        }

        // --- QAROR QISMI ---

        if (target != WindowState.NORMAL) {                           // Agar SNAP yoki MAXIMIZED bo'layotgan bo'lsa

            if (current == WindowState.NORMAL)                        // Faqat NORMAL holatdan chiqayotgan bo'lsak
                saveBounds();                                         // Eski NORMAL holatni saqlaymiz

            windowState.set(target);                                  // Holatni target ga tenglaymiz (SNAP)
            animateTo(finalX, finalY, finalW, finalH, 140);           // Chap/o'ng SNAP uchun yumshoq animatsiya qilamiz

        } else {                                                      // SNAP yoki MAXIMIZED bo'lmasa (oddiy qo'yib yuborish holati)

            if (current == WindowState.SNAP && hasSavedBounds) {      // Agar oldingi holat SNAP bo'lsa
                animateTo(savedX, savedY, savedWidth, savedHeight, 140); // Eski NORMAL o'lchamga qaytaramiz (animatsiya bilan)
                windowState.set(WindowState.NORMAL);                  // Holatni NORMAL qilamiz
            } else {
                animateTo(stage.getX(), stage.getY(),                 // Aks holda faqat kichik smoothing (ko'p farq bo'lmasa ham)
                        stage.getWidth(), stage.getHeight(), 60);
            }
        }
    }

    // ===== ANIMATSIYA =====

    /**
     * Oynani berilgan x, y, w, h ga berilgan ms davomida yumshoq harakatlantirish.
     */
    private void animateTo(double x, double y, double w, double h, int ms) {

        if (smoothMover != null) smoothMover.stop();                  // Agar eski animatsiya bo'lsa, uni to'xtatamiz

        animX.set(stage.getX());                                      // Boshlang'ich X qiymatini o'rnatamiz
        animY.set(stage.getY());                                      // Boshlang'ich Y qiymatini o'rnatamiz
        animW.set(stage.getWidth());                                  // Boshlang'ich enini o'rnatamiz

        smoothMover = new Timeline(                                   // Yangi Timeline yaratamiz
                new KeyFrame(Duration.millis(ms),                      // ms millisekund davomida
                        new KeyValue(animX, x, Interpolator.EASE_BOTH),// animX ni x ga EASE_BOTH bilan o'zgartiramiz
                        new KeyValue(animY, y, Interpolator.EASE_BOTH),// animY ni y ga EASE_BOTH bilan o'zgartiramiz
                        new KeyValue(animW, w, Interpolator.EASE_BOTH) // animW ni w ga EASE_BOTH bilan o'zgartiramiz
                )
        );

        smoothMover.setOnFinished(ev -> {                             // Animatsiya tugaganda
            stage.setX(x);                                            // X ni yakuniy qiymatga tenglaymiz
            stage.setY(y);                                            // Y ni yakuniy qiymatga tenglaymiz
            stage.setWidth(w);                                        // Enini yakuniy qiymatga tenglaymiz
            stage.setHeight(h);                                       // Balandligini yakuniy qiymatga tenglaymiz
        });

        smoothMover.play();                                           // Animatsiyani ishga tushiramiz
    }

    // ===== EKRAN TANLASH YORDAMCHI METODLARI =====

    /**
     * Oxirgi qayd etilgan sichqoncha koordinatasiga qarab qaysi ekranda turganini qaytaradi.
     */
    private Screen getScreenForCursor() {
        return getScreenForPoint(lastMouseX, lastMouseY);             // Oxirgi mouse X/Y orqali ekran tanlaymiz
    }

    /**
     * Berilgan (x, y) nuqta qaysi ekranga tegishli ekanini aniqlaydi.
     */
    private Screen getScreenForPoint(double x, double y) {
        for (Screen s : Screen.getScreens()) {                        // Barcha monitorlarni aylanib chiqamiz
            if (s.getVisualBounds().contains(x, y))                   // Agar (x, y) shu ekranning chegarasida bo'lsa
                return s;                                             // O'sha ekranni qaytaramiz
        }
        return Screen.getPrimary();                                   // Agar topilmasa, primary ekranni qaytaramiz
    }
}
