package ru.sental.mainmodulespring.config;

import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import ru.sental.mainmodulespring.jdbc.ConnectionHolder;

@Configuration
@RequiredArgsConstructor
public class ShutdownConfig {

    private final ConnectionHolder connectionHolder;

    @PreDestroy
    public void onShutdown() {
        connectionHolder.closeAll();
    }
}
