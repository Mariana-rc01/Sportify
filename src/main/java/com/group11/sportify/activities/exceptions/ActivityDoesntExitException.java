package com.group11.sportify.activities.exceptions;

public class ActivityDoesntExitException extends Exception{
    public ActivityDoesntExitException() {
        super();
    }

    public ActivityDoesntExitException(String msg) {
        super(msg);
    }
}
