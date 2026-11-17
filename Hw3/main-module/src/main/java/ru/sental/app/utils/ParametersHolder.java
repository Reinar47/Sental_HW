package ru.sental.app.utils;

import ru.sental.di.annotation.Component;
import ru.sental.di.annotation.Value;

@Component
public class ParametersHolder {

    @Value("my.param.db")
    private String someText;

    public String getSomeText() {
        if (someText == null) {
            throw new IllegalStateException(
                    "Property 'my.param.db' was not injected into " + getClass().getName());
        }
        return someText;
    }
}
