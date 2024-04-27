package com.group11.sportify.activities.exceptions;

public class ActivityDoesntExistException extends Exception{
    public ActivityDoesntExistException() {
        super();
    }

    public ActivityDoesntExistException(String msg) {
        super(msg);
    }
}
