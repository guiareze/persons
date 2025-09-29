package br.com.guiareze.persons.infrastructure.exception;

public class GatewayException extends RuntimeException{

    public GatewayException(String message, Throwable cause) {
        super(message, cause);
    }

}
