package org.example.exceptions;

public class InsuficcientMoneyException extends RuntimeException{
    public String message;

    public InsuficcientMoneyException(String message){
        super(message);
    }
}
