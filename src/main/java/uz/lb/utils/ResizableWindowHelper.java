package uz.lb.utils;                                // Paket nomi, util klasslar shu yerda saqlanadi

import javafx.scene.Cursor;                         // Cursor klassi (sichqoncha kursori turini boshqarish uchun)
import javafx.scene.Scene;                          // Scene – sahna, unda barcha UI elementlar joylashadi
import javafx.stage.Stage;                          // Stage – asosiy oyna

public class ResizableWindowHelper {                // Oynani (Stage) resize qilishga yordam beruvchi util klass
    private static final int EDGE_MARGIN = 8;       // Yon tomondan resize zonasi (chap/o‘ng/tepaga/pastga)
    private static final int CORNER_MARGIN = 12;    // Burchaklarda resize zonasi, biroz kattaroq bo‘lishi uchun

    private static double startX;                   // Resize boshlangan paytdagi sichqonchaning ekrandagi X koordinatasi
    private static double startY;                   // Resize boshlangan paytdagi sichqonchaning ekrandagi Y koordinatasi
    private static double startWidth;               // Resize boshlangandagi oynaning eni
    private static double startHeight;              // Resize boshlangandagi oynaning balandligi
    private static double windowX;                  // Resize boshlangandagi oynaning X koordinatasi
    private static double windowY;                  // Resize boshlangandagi oynaning Y koordinatasi

    public static void makeResizable(Stage stage) { // Stage'ni resize qilinadigan qilish uchun static metod
        Scene scene = stage.getScene();             // Stage ichidagi hozirgi sahnani olamiz
        if (scene == null) {                        // Agar sahna hali biriktirilmagan bo‘lsa
            throw new IllegalStateException(        // IllegalStateException tashlaymiz
                    "Stage must have a Scene before calling makeResizable" // Xabar: makeResizable chaqirishdan oldin Scene o‘rnatilishi kerak
            );
        }

        // === MOUSE PRESSED (bosilganda) ===
        scene.setOnMousePressed(e -> {              // Sichqoncha tugmasi bosilganda shu lambda ishlaydi
            Cursor cursor = scene.getCursor();      // Hozirgi cursor turini olamiz
            if (cursor == null || cursor == Cursor.DEFAULT)
                return; // Agar cursor default bo‘lsa – resize emas, hech narsa qilmaymiz

            startX = e.getScreenX();               // Sichqonchaning ekrandagi X koordinatasini saqlaymiz (boshlangan nuqta)
            startY = e.getScreenY();               // Sichqonchaning ekrandagi Y koordinatasini saqlaymiz

            startWidth = stage.getWidth();         // Resize boshlangandagi oynaning enini saqlaymiz
            startHeight = stage.getHeight();       // Resize boshlangandagi oynaning balandligini saqlaymiz

            windowX = stage.getX();                // Oynaning boshlang‘ich X joylashuvini saqlaymiz
            windowY = stage.getY();                // Oynaning boshlang‘ich Y joylashuvini saqlaymiz
        });

        // === MOUSE DRAGGED (sudralganda) ===
        scene.setOnMouseDragged(e -> {             // Sichqoncha bosilgan holda harakatlanganda shu lambda ishlaydi
            Cursor cursor = scene.getCursor();      // Hozirgi cursor turini olamiz
            if (cursor == null || cursor == Cursor.DEFAULT)
                return; // Agar cursor default bo‘lsa – resize emas, qaytamiz

            double dx = e.getScreenX() - startX;    // Sichqoncha qancha X bo‘yicha siljiganini hisoblaymiz
            double dy = e.getScreenY() - startY;    // Sichqoncha qancha Y bo‘yicha siljiganini hisoblaymiz

            double newX = windowX;                  // Yangi oyna X pozitsiyasi (default holat – eski pozitsiya)
            double newY = windowY;                  // Yangi oyna Y pozitsiyasi
            double newWidth = startWidth;           // Yangi eni (default – eski eni)
            double newHeight = startHeight;         // Yangi balandlik (default – eski balandlik)

            // === GORIZONTAL TOMON BO‘YICHA RESIZE ===
            if (cursor == Cursor.E_RESIZE          // Agar sichqoncha o‘ng tomondan resize holatda bo‘lsa
                    || cursor == Cursor.SE_RESIZE  // yoki past-o‘ng burchakda bo‘lsa
                    || cursor == Cursor.NE_RESIZE) // yoki yuqori-o‘ng burchakda bo‘lsa
            {
                newWidth += dx;                    // Oyna enini sichqoncha siljishiga qarab kattalashtiramiz
            } else if (cursor == Cursor.W_RESIZE   // Agar chap tomondan resize qilinayotgan bo‘lsa
                    || cursor == Cursor.SW_RESIZE  // yoki past-chap burchak
                    || cursor == Cursor.NW_RESIZE) // yoki yuqori-chap burchak bo‘lsa
            {
                newWidth -= dx;                    // Oyna enini kamaytiramiz (chapga tortilsa, eni kamayadi)
                newX += dx;                        // Oynaning X koordinatasini sichqoncha tomonga suramiz
            }

            // === VERTIKAL TOMON BO‘YICHA RESIZE ===
            if (cursor == Cursor.S_RESIZE          // Agar pastdan resize bo‘layotgan bo‘lsa
                    || cursor == Cursor.SE_RESIZE  // yoki past-o‘ng burchak
                    || cursor == Cursor.SW_RESIZE) // yoki past-chap burchak bo‘lsa
            {
                newHeight += dy;                   // Balandlikni sichqoncha siljishiga qarab oshiramiz
            } else if (cursor == Cursor.N_RESIZE   // Agar yuqoridan resize qilinayotgan bo‘lsa
                    || cursor == Cursor.NE_RESIZE  // yoki yuqori-o‘ng burchak
                    || cursor == Cursor.NW_RESIZE) // yoki yuqori-chap burchak bo‘lsa
            {
                newHeight -= dy;                   // Balandlikni kamaytiramiz (yuqoriga tortilsa)
                newY += dy;                        // Oynaning Y koordinatasini sichqoncha tomonga suramiz
            }

            // === ENGA CHEK QO‘YISH (minWidth) ===
            if (newWidth >= stage.getMinWidth()) { // Agar yangi eni minimumdan kichik bo‘lmasa
                stage.setWidth(newWidth);          // Oynaning enini yangilaymiz
                stage.setX(newX);                  // Zarur bo‘lsa X pozitsiyasini ham yangilaymiz
            }

            // === BALANDLIKKA CHEK QO‘YISH (minHeight) ===
            if (newHeight >= stage.getMinHeight()) { // Agar yangi balandlik minimumdan kichik bo‘lmasa
                stage.setHeight(newHeight);          // Oynaning balandligini yangilaymiz
                stage.setY(newY);                    // Zarur bo‘lsa Y pozitsiyasini ham yangilaymiz
            }
        });

        // === MOUSE MOVED (faqat harakat, bosilmagan holat) ===
        scene.setOnMouseMoved(e ->                          // Sichqoncha harakatlanganda (bosilmagan holat)
                updateCursor(scene, e.getSceneX(), e.getSceneY()) // Cursorni yangilash uchun yordamchi metodni chaqiramiz
        );

        // === MOUSE RELEASED (tugma qo‘yib yuborilganda) ===
        scene.setOnMouseReleased(e ->                       // Sichqoncha tugmasi qo‘yib yuborilganda
                updateCursor(scene, e.getSceneX(), e.getSceneY()) // Cursorni yana yangilab qo‘yamiz (DEFAULT ga qaytishi uchun)
        );

    }

    // Cursorni yangilash uchun yordamchi metod
    private static void updateCursor(Scene scene, double mouseX, double mouseY) {

        double width = scene.getWidth();            // Sahnaning joriy eni
        double height = scene.getHeight();          // Sahnaning joriy balandligi

        Cursor cursor = Cursor.DEFAULT;            // Default bo‘lib, oddiy cursor bilan boshlaymiz

        // === QIRRALAR ZONASI (EDGE) ===
        boolean left = mouseX >= 0 && mouseX < EDGE_MARGIN;               // Sichqoncha chap tomonga yaqin turibdimi?
        boolean right = mouseX <= width && mouseX > width - EDGE_MARGIN;  // Sichqoncha o‘ng tomonga yaqinmi?
        boolean top = mouseY >= 0 && mouseY < EDGE_MARGIN;                // Sichqoncha yuqori tomonga yaqinmi?
        boolean bottom = mouseY <= height && mouseY > height - EDGE_MARGIN; // Sichqoncha past tomonga yaqinmi?

        // === Burchaklar zonasi (CORNER) – biroz kattaroq radius bilan ===
        boolean inLeftCorner = mouseX < CORNER_MARGIN;                    // Sichqoncha chap tomonga juda yaqin (burchakka yaqin)
        boolean inRightCorner = mouseX > width - CORNER_MARGIN;           // Sichqoncha o‘ng tomonga juda yaqin
        boolean inTopCorner = mouseY < CORNER_MARGIN;                     // Sichqoncha yuqori chetga juda yaqin
        boolean inBottomCorner = mouseY > height - CORNER_MARGIN;         // Sichqoncha pastki chetga juda yaqin

        // === Avval burchaklarni tekshiramiz ===
        if (inLeftCorner && inTopCorner) {                // Agar chap-ustki burchakda bo‘lsa
            cursor = Cursor.NW_RESIZE;                    // NW (North-West) resize cursorni ko‘rsatamiz
        } else if (inLeftCorner && inBottomCorner) {      // Agar chap-pastki burchakda bo‘lsa
            cursor = Cursor.SW_RESIZE;                    // SW (South-West) cursor
        } else if (inRightCorner && inTopCorner) {        // O‘ng-ustki burchakda bo‘lsa
            cursor = Cursor.NE_RESIZE;                    // NE (North-East) cursor
        } else if (inRightCorner && inBottomCorner) {     // O‘ng-pastki burchakda bo‘lsa
            cursor = Cursor.SE_RESIZE;                    // SE (South-East) cursor
        }
        // === Keyin qirralarni (yon tomonlarni) tekshiramiz ===
        else if (left) {                                  // Faqat chap tomonga yaqin bo‘lsa
            cursor = Cursor.W_RESIZE;                     // Gorizontal chap tomondan resize cursor
        } else if (right) {                               // Faqat o‘ng tomonga yaqin bo‘lsa
            cursor = Cursor.E_RESIZE;                     // Gorizontal o‘ng tomondan resize cursor
        } else if (top) {                                 // Faqat yuqoriga yaqin bo‘lsa
            cursor = Cursor.N_RESIZE;                     // Vertikal yuqoridan resize cursor
        } else if (bottom) {                              // Faqat pastki tomonga yaqin bo‘lsa
            cursor = Cursor.S_RESIZE;                     // Vertikal pastdan resize cursor
        }

        scene.setCursor(cursor);                          // Hisoblangan cursorni sahnaga qo‘llaymiz
    }
}