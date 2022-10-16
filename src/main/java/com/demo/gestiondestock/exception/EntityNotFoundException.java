package com.demo.gestiondestock.exception;

import lombok.Getter;
//lever si une entity ou quelque chose que l'on cherche dans la bdd et sa n'existe pas
public class EntityNotFoundException extends RuntimeException{

    @Getter
    private ErrorCodes errorCodes;

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String message, Throwable cause) {

        super(message, cause);
    }

    public EntityNotFoundException(String message, Throwable cause, ErrorCodes errorCodes) {
        super(message,cause);
        this.errorCodes = errorCodes;
    }

    public EntityNotFoundException(String message, ErrorCodes errorCodes) {
        super(message);
        this.errorCodes = errorCodes;
    }
}
