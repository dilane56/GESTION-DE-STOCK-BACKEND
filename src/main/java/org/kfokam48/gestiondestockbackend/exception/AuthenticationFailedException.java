package org.kfokam48.gestiondestockbackend.exception;

public class AuthenticationFailedException extends RuntimeException{
    public AuthenticationFailedException(String message) {
        super(message);
    }

}
