package com.example.cubing_room.exceptions;

public class IncorrectStateColorException extends Exception{
    private String exceptionMessage;

    IncorrectStateColorException(){
        super();
    }

    public IncorrectStateColorException(String message){
        super(message);
        exceptionMessage = message;
    }

    public String getExceptionMessage(){
        return exceptionMessage;
    }
}
