package uz.lb.services.implement;

import org.junit.platform.commons.logging.LoggerFactory;
import uz.lb.services.IDashboardService;

import java.util.logging.Logger;

public class DashboardService implements IDashboardService {
    private final LogService logger = LogService.getInstance();

    // Masalan, barcha chatlarni olish
//    public List<Chat> getAllChats() {
//        // Bu yerda ma'lumotlar bazasidan yoki tarmoqdan ma'lumot olish lozim
//        // Hozircha dummy data qaytamiz
//        return List.of(
//                new Chat("Chat 1"),
//                new Chat("Chat 2")
//        );
//    }
//
//    // Foydalanuvchi profili
//    public User getUserProfile() {
//        // real holatda bazadan olingan user ma'lumotlari
//        return new User("John Doe", "profile.jpg");
//    }
//
//    // Yangi xabarlar sonini olish
//    public int getNewMessagesCount() {
//        // masalan, so'rov yoki hisoblash
//        return 5;
//    }
}
