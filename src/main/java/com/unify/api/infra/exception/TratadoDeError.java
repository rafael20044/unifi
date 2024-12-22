package com.unify.api.infra.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadoDeError {

    @ExceptionHandler(NoEncontrada.class)
    public ResponseEntity<String> ErrorNoEncontrado(NoEncontrada e){
        return ResponseEntity.status(404).body(e.getMessage());
    }

    @ExceptionHandler(CorreoRepetido.class)
    public ResponseEntity<String> correoRepetido(CorreoRepetido e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
