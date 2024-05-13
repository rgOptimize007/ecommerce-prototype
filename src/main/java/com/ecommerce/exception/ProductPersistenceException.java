package com.ecommerce.exception;

public class ProductPersistenceException extends RuntimeException{
    public ProductPersistenceException(String message){
        super(message);
    }
}
