package com.group11.sportify.users.exceptions;

import com.group11.sportify.users.UserController;

public class UserDoesntExistException extends Exception{
    public UserDoesntExistException() {
        super();
    }

    public UserDoesntExistException(String msg){
        super(msg);
    }
}
