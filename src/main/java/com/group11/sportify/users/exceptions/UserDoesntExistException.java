package com.group11.sportify.users.exceptions;

public class UserDoesntExistException extends Exception{
    public UserDoesntExistException() {
        super();
    }

    public UserDoesntExistException(String msg){
        super(msg);
    }
}
