
import org.junit.jupiter.api.Test;
import ru.sental.di.IocContainer;
import ru.sental.di.demo.AppConfig;
import ru.sental.di.demo.ConstructorInjectedBean;
import ru.sental.di.demo.FieldInjectedBean;
import ru.sental.di.demo.SetterInjectedBean;

import static org.junit.jupiter.api.Assertions.*;

class IocContainerTest {

    @Test
    void allInjectionTypesWork() {
        IocContainer.init("ru.sental.di", "application.yml");

        assertTrue(IocContainer.getBean(FieldInjectedBean.class).run().startsWith("Field:"));
        assertTrue(IocContainer.getBean(SetterInjectedBean.class).run().contains("featureEnabled = true"));
        assertTrue(IocContainer.getBean(ConstructorInjectedBean.class).run().startsWith("Constructor:"));
    }

    @Test
    void valueInjectionWorks() {
        IocContainer.init("ru.sental.di", "application.yml");
        AppConfig cfg = IocContainer.getBean(AppConfig.class);
        assertEquals(8080, cfg.getPort());
        assertEquals("jdbc:postgresql://localhost:5432/demo", cfg.getDbUrl());
        assertTrue(cfg.isFeatureEnabled());
    }
}