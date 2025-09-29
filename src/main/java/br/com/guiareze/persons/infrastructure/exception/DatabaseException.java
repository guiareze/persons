package br.com.guiareze.persons.infrastructure.exception;

public class DatabaseException extends RuntimeException{

    public DatabaseException(String message) {
        super(message);
    }

}
