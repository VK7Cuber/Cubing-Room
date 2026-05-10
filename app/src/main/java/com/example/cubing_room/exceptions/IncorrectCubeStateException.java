package com.example.cubing_room.exceptions;

public class IncorrectCubeStateException extends Exception{
    private String exceptionMessage;

    IncorrectCubeStateException(){
        super();
    }

    public IncorrectCubeStateException(String message){
        super(message);
        exceptionMessage = message;
    }

    public String getExceptionMessage(){
        return exceptionMessage;
    }
}
