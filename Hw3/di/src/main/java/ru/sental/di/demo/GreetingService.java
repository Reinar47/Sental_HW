package ru.sental.di.demo;

import ru.sental.di.annotation.Autowired;
import ru.sental.di.annotation.Component;
import ru.sental.di.annotation.Value;

@Component
public class GreetingService {

    @Value("app.name")
    private String appName;

    @Value("app.version")
    private String version;

    @Value("jpa.properties.hibernate.format_sql")
    private String jpa;

    private AppConfig config;


    @Autowired
    public void setConfig(AppConfig config) {
        this.config = config;
    }

    public String greet() {
        return "Hello from " + appName + " version " + version
                + " (port = " + config.getPort() + ", db = "
                + config.getDbUrl() + ")";
    }

    public String jpa() {
        return "jpa.properties.hibernate.format_sql = " + jpa;
    }
}