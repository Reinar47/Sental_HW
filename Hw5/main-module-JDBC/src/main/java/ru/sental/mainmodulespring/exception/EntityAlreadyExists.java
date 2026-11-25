package ru.sental.mainmodulespring.exception;

import lombok.Getter;

@Getter
public class EntityAlreadyExists extends RuntimeException {

    public EntityAlreadyExists(String message) {
        super(message);
    }
}
