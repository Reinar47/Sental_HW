package ru.sental.mainmodulespring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.sental.mainmodulespring.controller.UserController;
import ru.sental.mainmodulespring.dto.request.UserAccountRequest;


@SpringBootApplication
public class MainModuleSpringApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(MainModuleSpringApplication.class, args);
        UserController controller = ctx.getBean(UserController.class);

        // 1) создать 2 записи
        String created1 = controller.create(new UserAccountRequest(
                "Иван", "Петров", "sental", "secret", "PLAYER", "sental@mail.ru"));
        String created2 = controller.create(new UserAccountRequest(
                "Мария", "Петрова", "mary_master", "pass", "GAME_MASTER", "mary@mail.ru"));
        System.out.println("=== CREATE 1 ===\n" + created1);
        System.out.println("=== CREATE 2 ===\n" + created2);

        // 2) прочитать первую
        System.out.println("=== READ 1 ===\n" + controller.getById(1L));

        // 3) удалить вторую
        System.out.println("=== DELETE 2 ===\n" + controller.delete(2L));

        // 4) обновить первую
        String updated = controller.update(1L, new UserAccountRequest(
                "Иван_Изменённый", "Петров_не_тот_а_другой", "very_unic_name", "newpass", "GAME_MASTER", "new@mail.ru"));
        System.out.println("=== UPDATE 1 ===\n" + updated);

        // 5) повторно прочитать
        System.out.println("=== READ 1 AFTER UPDATE ===\n" + controller.getById(1L));

        // 6) все
        System.out.println("=== FIND ALL ===\n" + controller.findAll());

        ctx.close();
    }
}
