package com.group11.sportify;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import com.group11.sportify.activities.Activity;
import com.group11.sportify.activities.ActivityController;
import com.group11.sportify.users.User;
import com.group11.sportify.users.UserController;

/*
 * Controller class for the Sportify application data.
 */
public class SportifyController {
    private UserController userController;
    private ActivityController activitiesController;

    /**
     * Returns the user with the most activities in the sportiy application.
     * 
     * @return The user with most activities or null if there is none.
     */
    public User getUserWithMostActivities(){
        return userController.getAllUsers().stream().max((u1, u2) -> u1.getActivities().size() - u2.getActivities().size()).orElse(null);
    }

    /*
     * Returns the user with the most activities between two dates.
     * 
     * @param startDate The start date.
     * @param endDate The end date.
     * 
     * @return The user with most activities between the two dates or null if there is none.
     */
    public User getUserWithMostActivitiesBetweenDates(LocalDateTime startDate, LocalDateTime endDate){
        int topUserCode = activitiesController.getActivitiesBetweenDates(startDate, endDate).stream().collect(Collectors.groupingBy(Activity::getUserCode)).entrySet().stream().max((e1, e2) -> e1.getValue().size() - e2.getValue().size()).get().getKey();
        try {
            return userController.getUser(topUserCode);
        } catch (Exception e) {
            return null;
        }
    }
}
