package com.group11.sportify;

import java.time.LocalDate;
import java.util.stream.Collectors;

import com.group11.sportify.activities.Activity;
import com.group11.sportify.activities.ActivityController;
import com.group11.sportify.users.User;
import com.group11.sportify.users.UserController;

public class SportifyController {
    private UserController userController;
    private ActivityController activitiesController;

    public User getUserWithMostActivities(){
        return userController.getAllUsers().stream().max((u1, u2) -> u1.getActivities().size() - u2.getActivities().size()).orElse(null);
    }

    public User getUserWithMostActivitiesBetweenDates(LocalDate startDate, LocalDate endDate){
        int topUserCode = activitiesController.getActivitiesBetweenDates(startDate, endDate).stream().collect(Collectors.groupingBy(Activity::getUserCode)).entrySet().stream().max((e1, e2) -> e1.getValue().size() - e2.getValue().size()).get().getKey();
        try {
            return userController.getUser(topUserCode);
        } catch (Exception e) {
            return null;
        }
    }
}
