package br.com.guiareze.persons.infrastructure.exception;

public class IntegrationException extends RuntimeException{

    public IntegrationException(String message, Throwable cause) {
        super(message, cause);
    }

}
