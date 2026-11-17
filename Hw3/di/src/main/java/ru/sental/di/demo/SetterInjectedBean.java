package ru.sental.di.demo;

import ru.sental.di.annotation.Autowired;
import ru.sental.di.annotation.Component;

@Component
public class SetterInjectedBean {

    private AppConfig config;

    @Autowired
    public void setConfig(AppConfig config) {
        this.config = config;
    }

    public String run() {
        return "Setter: featureEnabled = " + config.isFeatureEnabled();
    }
}