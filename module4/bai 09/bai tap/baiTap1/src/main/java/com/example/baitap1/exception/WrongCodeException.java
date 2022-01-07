package com.example.baitap1.exception;

public class WrongCodeException extends Exception{
    @Override
    public String getMessage() {
        return "Your code is invalid";
    }
}
