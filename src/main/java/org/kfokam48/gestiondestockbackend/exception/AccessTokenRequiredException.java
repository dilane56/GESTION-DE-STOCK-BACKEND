package org.kfokam48.gestiondestockbackend.exception;

public class AccessTokenRequiredException extends RuntimeException{
    public AccessTokenRequiredException(String message) {
        super(message);
    }

}
