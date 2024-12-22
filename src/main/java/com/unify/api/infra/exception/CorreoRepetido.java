package com.unify.api.infra.exception;

public class CorreoRepetido extends RuntimeException {
    public CorreoRepetido(String message) {
        super(message);
    }
}
