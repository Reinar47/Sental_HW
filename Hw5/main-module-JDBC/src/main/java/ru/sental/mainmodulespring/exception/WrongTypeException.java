package ru.sental.mainmodulespring.exception;

import lombok.Getter;

@Getter
public class WrongTypeException extends RuntimeException {

    public WrongTypeException(String message) {
        super(message);
    }
}
