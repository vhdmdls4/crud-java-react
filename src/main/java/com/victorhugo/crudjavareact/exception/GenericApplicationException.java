package com.victorhugo.crudjavareact.exception;

public class GenericApplicationException extends RuntimeException{
    public GenericApplicationException(String errorMessage){
        super(errorMessage);
    }
}
