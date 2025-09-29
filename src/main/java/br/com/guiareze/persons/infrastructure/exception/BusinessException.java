package br.com.guiareze.persons.infrastructure.exception;

public class BusinessException extends RuntimeException{

    public BusinessException(String message) {
        super(message);
    }

}
