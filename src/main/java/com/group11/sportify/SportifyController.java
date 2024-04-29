package com.group11.sportify;

import java.time.LocalDate;

import com.group11.sportify.users.User;
import com.group11.sportify.users.UserController;

public class SportifyController {
    private UserController userController;

    public User getUserWithMostActivities(){
        return userController.getAllUsers().stream().max((u1, u2) -> u1.getActivities().size() - u2.getActivities().size()).orElse(null);
    }

    public User getUserWithMostActivitiesBetweenDates(LocalDate startDate, LocalDate endDate){
        return userController.getAllUsers().stream().max((u1, u2) -> u1.getActivitiesBetweenDates(startDate, endDate).size() - u2.getActivitiesBetweenDates(startDate, endDate).size()).orElse(null);
    }
}
