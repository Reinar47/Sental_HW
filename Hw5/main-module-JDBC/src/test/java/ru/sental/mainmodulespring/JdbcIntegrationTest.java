package ru.sental.mainmodulespring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.sental.mainmodulespring.dto.request.UserAccountRequest;
import ru.sental.mainmodulespring.exception.ResourceNotFoundException;
import ru.sental.mainmodulespring.service.UserService;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JdbcIntegrationTest {

    @Autowired
    private UserService userService;

    @Test
    void crudWorks() {
        UserAccountRequest req = new UserAccountRequest(
                "Иван", "Иван", "sental", "pass", "PLAYER", "sent@mail.ru");
        var created = userService.create(req);
        assertNotNull(created.getUserId());

        var found = userService.getById(created.getUserId());
        assertEquals("sental", found.getNickName());

        req.setNickName("updated");
        userService.update(created.getUserId(), req);
        assertEquals("updated", userService.getById(created.getUserId()).getNickName());

        userService.delete(created.getUserId());
        assertThrows(ResourceNotFoundException.class, () -> userService.getById(created.getUserId()));
    }

    @Test
    void concurrentThreadsGetSeparateConnections() throws InterruptedException {
        int threads = 5;
        ExecutorService pool = Executors.newFixedThreadPool(threads);
        CountDownLatch latch = new CountDownLatch(threads);

        for (int i = 0; i < threads; i++) {
            final int idx = i;
            pool.submit(() -> {
                try {
                    UserAccountRequest req = new UserAccountRequest(
                            "firstName" + idx,
                            "lastName" + idx,
                            "nickName" + idx,
                            "password",
                            "PLAYER",
                            idx + "someEmail@.ru");
                    var created = userService.create(req);
                    assertNotNull(created.getUserId());
                } finally {
                    latch.countDown();
                }
            });
        }
        assertTrue(latch.await(10, TimeUnit.SECONDS));
        pool.shutdown();
        assertTrue(pool.awaitTermination(5, TimeUnit.SECONDS));
    }
}