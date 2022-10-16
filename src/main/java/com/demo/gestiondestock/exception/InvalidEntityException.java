package com.demo.gestiondestock.exception;

import lombok.Getter;

import java.util.List;

//exception lever lorsque l'on essaye d'envoyer un element dans la bdd et que cette entité n'est pas valide (lors de
// l'enregistrement ou la mise à jour de la bdd
//Création des exceptions personnalisés
public class InvalidEntityException extends RuntimeException{

    @Getter
    private ErrorCodes errorCodes;

    @Getter
    private List<String> errors;

    public InvalidEntityException(String message) {
        super(message);
    }

    public InvalidEntityException(String message, Throwable cause) {

        super(message, cause);
    }

    public InvalidEntityException(String message, Throwable cause, ErrorCodes errorCodes) {
        super(message,cause);
        this.errorCodes = errorCodes;
    }

    public InvalidEntityException(String message, ErrorCodes errorCodes) {
        super(message);
        this.errorCodes = errorCodes;
    }

    public InvalidEntityException(String message, ErrorCodes errorCodes, List<String> errors){
        super(message);
        this.errorCodes = errorCodes;
        this.errors = errors;
    }
}
