package uz.lb.caches.windowParametrCaches; // Paket nomi

import javafx.animation.Interpolator;      // Animatsiya uchun interpolator
import javafx.animation.KeyFrame;          // Timeline ichidagi asosiy kadr
import javafx.animation.KeyValue;          // Property + target qiymat juftligi
import javafx.animation.Timeline;          // Vaqt bo'yicha animatsiya
import javafx.beans.property.DoubleProperty; // Double tipidagi property (binding uchun)
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty; // DoubleProperty ning oddiy implementatsiyasi
import javafx.geometry.Rectangle2D;        // To'rtburchak koordinatalari (ekran chegaralari)
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;      // Sichqoncha hodisalari
import javafx.scene.layout.Pane;           // Drag qilinadigan panel (title panel vb.)
import javafx.stage.Screen;                // Ekran ma'lumotlari (multi-monitor uchun)
import javafx.stage.Stage;                 // JavaFX oynasi
import javafx.util.Duration;               // Animatsiya davomiyligi uchun class

/**
 * WindowManager:
 * - Drag ishlashi (har bir dragda darhol yangilash, Timeline ishlatmasdan)
 * - Sichqoncha qo'yib yuborganda (release) yumshoq animatsiya bilan joylashtirish
 * - Multi-monitorni hisobga oladi
 * - Chap/o'ng snap, tepaga tekkizganda fullscreen (maximized)
 * - Maximize/restore, maximize'dan drag qilish va qayta kichraytirish
 */
public class WindowManager {

    private WindowManager() {
        // Private constructor: tashqaridan new WindowManager() qilmaslik uchun
    }

    private static final WindowManager INSTANCE = new WindowManager(); // Singletonning yagona instansiyasi

    public static WindowManager getInstance() {
        return INSTANCE; // Singleton instansiyasini qaytaradi
    }

    private Stage stage;     // Asosiy Stage (oyna)
    private Pane dragPane;   // Drag qilinadigan panel (title panel)

    private final DoubleProperty dragX = new SimpleDoubleProperty(); // Drag paytida kursor va oyna orasidagi X ofset
    private final DoubleProperty dragY = new SimpleDoubleProperty(); // Drag paytida kursor va oyna orasidagi Y ofset

    private double savedX, savedY, savedWidth, savedHeight; // Maximize bo'lishidan oldingi oyna koordinatalari va o'lchami
    private boolean hasSavedBounds = false;                 // Yuqoridagi qiymatlar saqlanganmi yo'qmi flag

    private boolean draggingFromMaximized = false; // Drag boshlanganida oyna MAXIMIZED holatida bo'lganini belgilovchi flag
    private double dragXRatio = 0.0;               // (Hozir ishlatilmayapti, lekin kelajak uchun kursorning nisbiy joyi)

    // Animatsiya uchun property'lar (X, Y, Width)
    private DoubleProperty animX; // Animatsiya orqali X koordinata
    private DoubleProperty animY; // Animatsiya orqali Y koordinata
    private DoubleProperty animW; // Animatsiya orqali Width (eni)

    private Timeline smoothMover;  // Joylashuv animatsiyasi uchun Timeline

    private static final int SNAP_THRESHOLD = 25; // Snap zonasi uchun piksel chegarasi (chap/o'ng/tepaga yaqinlashish masofasi)

    private enum WindowState {NORMAL, MAXIMIZED} // Oynaning holati: oddiy yoki maksimal (fullscreen uslubida)

    private WindowState state = WindowState.NORMAL; // Dastlabki holat NORMAL (maximal emas)

    // Oynaning fullscreen holatini kuzatish uchun property (Controller bilan bog'lash uchun)
    private final SimpleBooleanProperty fullScreenProperty = new SimpleBooleanProperty(false);

    // Tashqaridan faqat o'qish uchun getter (listener ulash uchun)
    public SimpleBooleanProperty fullScreenProperty() {
        return fullScreenProperty;
    }

    public void init(Stage stage, Pane dragPane) {
        this.stage = stage;         // Kirib kelgan Stage'ni saqlab qo'yamiz
        this.dragPane = dragPane;   // DragPanelni (title panel) saqlab qo'yamiz

        animX = new SimpleDoubleProperty(stage.getX()); // animX boshlang'ich qiymati - oynaning hozirgi X koordinatasi
        animX.addListener((obs, oldV, newV) -> stage.setX(newV.doubleValue())); // animX o'zgarsa, Stage X koordinatasini yangilaydi

        animY = new SimpleDoubleProperty(stage.getY()); // animY boshlang'ich qiymati - oynaning hozirgi Y koordinatasi
        animY.addListener((obs, oldV, newV) -> stage.setY(newV.doubleValue())); // animY o'zgarsa, Stage Y koordinatasini yangilaydi

        animW = new SimpleDoubleProperty(stage.getWidth()); // animW boshlang'ich qiymati - oynaning hozirgi eni
        animW.addListener((obs, oldV, newV) -> stage.setWidth(newV.doubleValue())); // animW o'zgarsa, Stage enini yangilaydi

        setupDragHandlers(); // Drag uchun event handlerlarni sozlaymiz
        setupShortcuts();
    }
    /**
     * Klaviatura shortcudari (masalan F11 orqali fullscreen) ni sozlaydigan metod.
     */
    private void setupShortcuts() {
        if (stage == null) return;              // Stage yo'q bo'lsa, hech narsa qilmaymiz

        Scene scene = stage.getScene();         // Hozirgi sahnani olamiz
        if (scene == null) return;              // Agar scene hali o'rnatilmagan bo'lsa, chiqib ketamiz

        // F11 tugmasi bosilganda fullscreenni yoqib/o'chirish
        scene.addEventFilter(KeyEvent.KEY_PRESSED, e -> {
            if (e.getCode() == KeyCode.F11) {   // Agar bosilgan tugma F11 bo'lsa
                toggleFullScreen();             // WindowManager ichidagi fullscreen toggle metodini chaqiramiz
                e.consume();                    // Voqeani "yeb yuboramiz", boshqa handlerlarga o'tkazmaymiz (ixtiyoriy)
            }
        });
    }
    public void minimize() {
        if (stage != null) stage.setIconified(true); // Stage'ni taskbarga minimize qiladi
    }

    public void toggleFullScreen() {
        if (state == WindowState.NORMAL) maximize(); // Agar hozir NORMAL bo'lsa - MAXIMIZED qilamiz
        else restore();                              // Aks holda - oldingi holatga qaytaramiz
    }

    public void close() {
        if (stage != null) stage.close(); // Oynani yopadi
    }

    public boolean isFullScreen() {
        return state == WindowState.MAXIMIZED; // Hozirgi holat MAXIMIZED bo'lsa true qaytaradi
    }

    public static void minimizeWindow() {
        INSTANCE.minimize(); // Singleton orqali minimize
    }

    public static void toggleFullScreenWindow() {
        INSTANCE.toggleFullScreen(); // Singleton orqali fullscreen toggle
    }

    public static void closeWindow() {
        INSTANCE.close(); // Singleton orqali close
    }

    public static boolean isWindowFullScreen() {
        return INSTANCE.isFullScreen(); // Singleton orqali fullscreen holatini tekshirish
    }

    private void maximize() {
        if (stage == null) return; // Agar stage yo'q bo'lsa, hech nima qilmaymiz
        saveBounds();              // Hozirgi oyna o'lcham va pozitsiyasini saqlaymiz
        Screen curScreen = getCurrentScreen();        // Hozirgi oynaning qaysi ekranda turganini topamiz (multi-monitor uchun)
        Rectangle2D bounds = curScreen.getVisualBounds(); // O'sha ekraning ko'rinadigan (taskbarni hisobga olgan) chegaralari

        stage.setX(bounds.getMinX());           // Oynani ekraning chap tomoniga joylashtiramiz
        stage.setY(bounds.getMinY());           // Oynani ekraning yuqori tomoniga joylashtiramiz
        stage.setWidth(bounds.getWidth());      // Oynaning enini ekranga teng qilamiz
        stage.setHeight(bounds.getHeight());    // Oynaning balandligini ekranga teng qilamiz

        state = WindowState.MAXIMIZED;          // Holatni MAXIMIZED deb belgilaymiz
        fullScreenProperty.set(true);
    }

    private void restore() {
        if (stage == null) return;      // Stage bo'lmasa, chiqib ketamiz
        if (hasSavedBounds) {           // Agar oldin savedBounds bor bo'lsa
            stage.setX(savedX);         // Oynani eski X koordinatasiga qaytaramiz
            stage.setY(savedY);         // Oynani eski Y koordinatasiga qaytaramiz
            stage.setWidth(savedWidth); // Eski enini qaytaramiz
            stage.setHeight(savedHeight);// Eski balandligini qaytaramiz
        }
        state = WindowState.NORMAL;     // Holatni NORMAL deb belgilaymiz
    }

    private void saveBounds() {
        if (stage == null) return;          // Stage bo'lmasa, hech narsa qilmaymiz
        savedX = stage.getX() >= 0.0 ? stage.getX() : 0.0;              // Hozirgi X koordinatasini saqlaymiz
        savedY = stage.getY() >= 0.0 ? stage.getY() : 0.0;              // Hozirgi Y koordinatasini saqlaymiz
        savedWidth = stage.getWidth();      // Hozirgi enini saqlaymiz
        savedHeight = stage.getHeight();    // Hozirgi balandligini saqlaymiz
        hasSavedBounds = true;              // Endi savedBounds bor deb belgilaymiz
    }

    private void setupDragHandlers() {
        if (dragPane == null) return; // Agar dragPane berilmagan bo'lsa, hech nima qilmaymiz

        dragPane.setOnMousePressed(this::handlePress);    // Sichqoncha bosilganda handlePress chaqiriladi
        dragPane.setOnMouseDragged(this::handleDrag);     // Sudraganda handleDrag chaqiriladi
        dragPane.setOnMouseReleased(this::handleRelease); // Qo'yib yuborganda handleRelease chaqiriladi
    }

    private void handlePress(MouseEvent e) {
        if (stage == null) return;          // Stage bo'lmasa, chiqib ketamiz

        if (smoothMover != null) smoothMover.stop(); // Agar avvalgi animatsiya bor bo'lsa, uni to'xtatamiz

        if (state == WindowState.MAXIMIZED) {       // Agar hozir oyna MAXIMIZED bo'lsa
            draggingFromMaximized = true;           // Drag MAXIMIZED holatdan boshlanganini bilib olamiz
            dragXRatio = e.getX() / stage.getWidth(); // Hozircha ishlatilmayapti, lekin kursor nisbiy X joylashuvi (0..1)
        } else {
            draggingFromMaximized = false;          // Aks holda oddiy drag
            dragX.set(e.getScreenX() - stage.getX()); // Kursor va oynaning X ofsetini saqlaymiz
            dragY.set(e.getScreenY() - stage.getY()); // Kursor va oynaning Y ofsetini saqlaymiz
        }
    }

    private void handleDrag(MouseEvent e) {
        if (stage == null) return; // Stage bo'lmasa, hech narsa qilmaymiz

        if (draggingFromMaximized) {           // Agar MAXIMIZED holatdan drag boshlangan bo'lsa

            draggingFromMaximized = false;     // Endi birinchi dragni qayta ishlaganimiz uchun false qilamiz

            // Sichqoncha qaysi ekranda turganini yana olamiz
            Screen screen = getScreenForPoint(e.getScreenX(), e.getScreenY());
            Rectangle2D bounds = screen.getVisualBounds();

            // MAXIMIZED holatdan NORMAL holatga qaytamiz
            if (hasSavedBounds) {
                double width = stage.getWidth();

                // Agar oldingi o'lchamlar saqlangan bo'lsa
                stage.setWidth(savedWidth);    // Eski eniga qaytaramiz
                stage.setHeight(savedHeight);  // Eski balandligiga qaytaramiz

                // Sichqonchaning ekranga nisbatan nisbati dragXRatio edi,
                // endi shu nisbatni yangi oynaga qo'llaymiz:
                double newX = e.getScreenX() - dragXRatio * savedWidth;
                stage.setX(newX);
                // Agar y=0 bo'lsin desang:
                // stage.setY(bounds.getMinY());
            }

            dragX.set(e.getScreenX() - stage.getX()); // Endi oddiy drag uchun yangi ofset X (kursor - oyna X)
            dragY.set(e.getScreenY() - stage.getY()); // Endi oddiy drag uchun yangi ofset Y

            state = WindowState.NORMAL;        // Holat NORMAL ga o'zgartiriladi
            // return qilmasak ham bo'ladi, chunki pastdagi kod endi yangi ofset bilan ishlaydi
        }

        // Oddiy drag logikasi (har doim shu qism ishlaydi)
        double targetX = e.getScreenX() - dragX.get(); // Kursor pozitsiyasidan ofsetni ayirib, oynaning yangi X ni topamiz
        double targetY = e.getScreenY() - dragY.get(); // Kursor pozitsiyasidan ofsetni ayirib, oynaning yangi Y ni topamiz

        if (smoothMover != null) {     // Agar avvalgi animatsiya ishlayotgan bo'lsa
            smoothMover.stop();        // Uni to'xtatamiz
            smoothMover = null;        // Null qilib qo'yamiz
        }

        stage.setX(targetX);           // Oynani yangi X ga ko'chiramiz
        stage.setY(targetY);           // Oynani yangi Y ga ko'chiramiz
    }

    /**
     * Ushbu metod sichqonchaning ekrandagi (screenX, screenY) koordinatasiga qarab,
     * qaysi monitor (Screen) ustida turganini aniqlaydi.
     * Snap (chap/o‘ng/tepaga) bo‘yicha aynan shu ekranga joylashtirish uchun ishlatiladi.
     */
    private Screen getScreenForPoint(double screenX, double screenY) {
        // Barcha ekranlarni aylanib chiqamiz
        for (Screen s : Screen.getScreens()) {
            Rectangle2D b = s.getVisualBounds(); // Ekranning ko‘rinadigan (taskbarsiz) chegaralari
            if (b.contains(screenX, screenY)) {  // Agar berilgan nuqta shu ekranning ichida bo‘lsa
                return s;                        // O‘sha ekranni qaytaramiz
            }
        }
        // Agar hech biriga tushmasa (noaniq holat) bo‘lsa – primary ekranni qaytaramiz
        return Screen.getPrimary();
    }

    private void handleRelease(MouseEvent e) {
        if (stage == null) return; // Stage bo'lmasa, chiqib ketamiz

        double screenX = e.getScreenX(); // Sichqonchaning ekrandagi X koordinatasi
        double screenY = e.getScreenY(); // Sichqonchaning ekrandagi Y koordinatasi

        // ENDi ekranni oynaga emas, sichqoncha nuqtasiga qarab tanlaymiz 👇
        Screen screen = getScreenForPoint(screenX, screenY);
        Rectangle2D bounds = screen.getVisualBounds(); // Shu ekranning ko'rinadigan chegaralari

        double finalX = stage.getX();       // Yakuniy X (agar snap bo'lmasa, hozirgi X qoladi)
        double finalY = stage.getY();       // Yakuniy Y
        double finalW = stage.getWidth();   // Yakuniy eni
        double finalH = stage.getHeight();  // Yakuniy balandlik

        boolean snapped = false;           // Snap bo'ldimi-yo'qmi flag
        boolean snappedToTop = false;      // Aynan tepaga (fullscreen) snap bo'lganini bilish uchun flag

        // 1) Tepaga tekkizsak FULLSCREEN bo'lsin (dragPane display tepasiga tegsa)
        if (screenY <= bounds.getMinY() + SNAP_THRESHOLD) { // Ekranning yuqori chetiga juda yaqin bo'lsa
            finalX = bounds.getMinX();          // Oynani ekranning chap yuqori burchagiga qo'yamiz
            finalY = bounds.getMinY();          // Y ham ekranning yuqori chegarasiga
            finalW = bounds.getWidth();         // Enini butun ekranga teng qilamiz
            finalH = bounds.getHeight();        // Balandligini ham butun ekranga teng qilamiz
            snapped = true;                     // Snap bo'ldi
            snappedToTop = true;                // Bu top-snap (fullscreen) ekanini belgilaymiz
            fullScreenProperty.set(true);    // <-- TOP SNAP orqali fullscreen
        }
        // 2) Agar tepaga snap bo'lmagan bo'lsa, chapga snap tekshiramiz
        else if (screenX <= bounds.getMinX() + SNAP_THRESHOLD) { // Sichqoncha ekranning chap chetiga yaqin bo'lsa
            finalX = bounds.getMinX();             // Oyna chap tomondan boshlanadi
            finalY = bounds.getMinY();             // Yuqori chetga teng
            finalW = bounds.getWidth() / 2;        // Ekranning yarmi enida bo'ladi
            finalH = bounds.getHeight();           // Balandlik butun ekranga teng
            snapped = true;                        // Snap bo'ldi
        }
        // 3) O'ngga snap tekshiramiz
        else if (screenX >= bounds.getMaxX() - SNAP_THRESHOLD) { // Sichqoncha ekranning o'ng chetiga yaqin bo'lsa
            finalX = bounds.getMinX() + bounds.getWidth() / 2; // O'ng yarmi uchun X
            finalY = bounds.getMinY();                        // Yuqori chet
            finalW = bounds.getWidth() / 2;                   // Ekranning yarmi enida
            finalH = bounds.getHeight();                      // Balandlik butun ekranga teng
            snapped = true;                                   // Snap bo'ldi
        }

        if (snapped) { // Agar chap/o'ng/tepaga snap bo'lgan bo'lsa
            saveBounds(); // Hozirgi holatni (snapdan oldingi) saqlab qo'yamiz, keyinchalik restore qilish uchun
            animateTo(finalX, finalY, finalW, finalH, 140); // Oynani maqsad kordinata va o'lchamga yumshoq harakatlantiramiz

            if (snappedToTop) {           // Agar tepaga (fullscreen) snap bo'lgan bo'lsa
                state = WindowState.MAXIMIZED; // Holat MAXIMIZED bo'ladi
                fullScreenProperty.set(true);
            } else {
                state = WindowState.NORMAL;    // Chap/o'ng yarim snap - bu oddiy NORMAL holat deb qabul qilamiz
                fullScreenProperty.set(false);   // <-- Half-snap – fullscreen emas
            }
        } else {
            // Snap bo'lmasa, faqat kichik yumshoq animatsiya (juda oz siljigan bo'lsa ham smooth ko'rinishi uchun)
            animateTo(stage.getX(), stage.getY(), stage.getWidth(), stage.getHeight(), 80);
        }
    }

    private void animateTo(double toX, double toY, double toW, double toH, int durationMs) {
        if (stage == null) return; // Stage yo'q bo'lsa, hech nima qilmaymiz

        if (smoothMover != null) smoothMover.stop(); // Eski animatsiya bo'lsa, uni to'xtatamiz
        animW.set(stage.getWidth()); // animW ning start qiymati - hozirgi eni
        animX.set(stage.getX()); // animX ning start qiymati - hozirgi X
        animY.set(stage.getY()); // animY ning start qiymati - hozirgi Y

        KeyValue kvW = new KeyValue(animW, toW, Interpolator.EASE_BOTH); // animW ni toW ga EASE_BOTH bilan animatsiya qilamiz
        KeyValue kvX = new KeyValue(animX, toX, Interpolator.EASE_BOTH); // animX ni toX ga EASE_BOTH bilan animatsiya qilamiz
        KeyValue kvY = new KeyValue(animY, toY, Interpolator.EASE_BOTH); // animY ni toY ga EASE_BOTH bilan animatsiya qilamiz


        KeyFrame kf = new KeyFrame(Duration.millis(durationMs), kvX, kvY, kvW); // durationMs ms davomida ushbu 3 ta property'ni animatsiya qilamiz
        smoothMover = new Timeline(kf); // Yangi Timeline yaratamiz
        smoothMover.setOnFinished(ev -> {          // Animatsiya tugaganda
            stage.setX(toX);                       // Stage X ni aniq toX ga qo'yamiz (aniqlik uchun)
            stage.setY(toY);                       // Stage Y ni aniq toY ga qo'yamiz
            stage.setWidth(toW);                   // Stage eni toW bo'lishini kafolatlaymiz
            stage.setHeight(toH);                  // Stage balandligi toH bo'lishini kafolatlaymiz
        });
        smoothMover.play(); // Animatsiyani ishga tushiramiz
    }

    private Screen getCurrentScreen() {
        if (stage == null) return Screen.getPrimary(); // Stage bo'lmasa, default primary ekran qaytariladi

        Rectangle2D windowRect = new Rectangle2D(
                stage.getX(),                          // Oynaning X koordinatasi
                stage.getY(),                          // Oynaning Y koordinatasi
                Math.max(1, stage.getWidth()),         // Enini 0 bo'lib qolmasligi uchun kamida 1 qilamiz
                Math.max(1, stage.getHeight()));       // Balandlikni ham kamida 1 qilamiz

        return Screen.getScreensForRectangle(windowRect) // Oynani o'z ichiga oladigan ekran(lar) ro'yxatini olamiz
                .stream()                               // Stream'ga aylantiramiz
                .findFirst()                            // Birinchi mos ekranni olamiz
                .orElse(Screen.getPrimary());           // Agar topilmasa, primary ekranni qaytaramiz
    }
}
