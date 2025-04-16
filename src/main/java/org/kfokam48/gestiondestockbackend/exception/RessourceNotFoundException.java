package org.kfokam48.gestiondestockbackend.exception;

public class RessourceNotFoundException extends  RuntimeException {
    public RessourceNotFoundException(String message) {
        super(message);
    }
}
