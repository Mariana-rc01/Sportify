package com.group11.sportify.users;

import com.group11.sportify.users.exceptions.UserDoesntExistException;
import com.group11.sportify.users.exceptions.UserTypeDoesntExistException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserController {

    private Map<Integer, User> users;

    public UserController(){
        this.users = new HashMap<>();
    }

    public List<User> getAllUsers() {
        return this.users.values().stream().map(User::clone).toList();
    }

    public User getUser(int code) throws UserDoesntExistException {
        if(this.users.containsKey(code)){
            return this.users.get(code).clone();
        }
        throw new UserDoesntExistException();
    }

    //eventualmente tem de retornar o user
    public void insertUser(String name, String address, String email, int averageHeartRate, double weight, double height, int type) throws UserTypeDoesntExistException {
        int code = this.users.size();
        switch (type) {
            case 0:
                //amateur
                break;
            case 1:
                //casual
                break;
            case 2:
                //professional
                break;
            default:
                throw new UserTypeDoesntExistException();
        }
    }
}
