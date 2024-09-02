package com.victorhugo.crudjavareact.exception;

public class GenericApplicationException extends RuntimeException{
    public GenericApplicationException(String errorMessage){
        super(errorMessage);
    }
    public GenericApplicationException(String errorMessage, Throwable errorCause){
        super(errorMessage, errorCause);
    }
}
