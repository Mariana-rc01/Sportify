package com.group11.sportify.activities;

import com.group11.sportify.activities.SeriesReps.*;
import com.group11.sportify.activities.exceptions.ActivityDoesntExitException;
import com.group11.sportify.users.User;
import com.group11.sportify.users.UserController;
import com.group11.sportify.users.exceptions.UserDoesntExistException;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controller class for managing activities.
 */
public class ActivityController {

    /**
     * Map to store activities with their unique codes as keys.
     */
    private Map<Integer, Activity> activities;

    /**
    * This needs to be here because we have to check if there is a user created on userController to add an activity.
    */
    private UserController userController;

    /**
     * Constructor for ActivityController class.
     * Initializes the activities map.
     */
    public ActivityController(UserController userController){
        this.activities = new HashMap<>();
        this.userController = userController;
    }

    /**
     * Retrieves a list of all activities.
     *
     * @return A list containing all activities.
     */
    public List<Activity> getAllActivities() {
        return this.activities.values().stream().map(Activity::clone).toList();
    }

    /**
     * Retrieves an activity by its unique code.
     *
     * @param code The unique code of the activity to retrieve.
     * @return The activity corresponding to the given code.
     * @throws ActivityDoesntExitException If no activity with the given code exists.
     */
    public Activity getActivity(int code) throws ActivityDoesntExitException {
        if(this.activities.containsKey(code)){
            return this.activities.get(code).clone();
        }
        throw new ActivityDoesntExitException();
    }

    /**
     * Inserts a new Burpee activity into the system.
     *
     * @param description The description of the activity.
     * @param timeSpentMinutes The time spent on the activity in minutes.
     * @param averageHeartRate The average heart rate during the activity.
     * @param date The date of the activity.
     * @param repetitions The number of repetitions for the activity.
     * @param user_code The user code of the user associated with this activity.
     * @return The newly inserted Burpee activity.
     */
    public Activity insertActivityBurpee(String description, int timeSpentMinutes, int averageHeartRate, LocalDate date, int repetitions, int user_code) throws UserDoesntExistException {
        User user = userController.getUser(user_code);
        int code = this.activities.size();
        Activity activity = new Burpee(code,description,timeSpentMinutes,averageHeartRate,date,repetitions, user);
        this.activities.put(code,activity);
        return activity;
    }

    /**
     * Inserts a new Jumping Jack activity into the system.
     *
     * @param description The description of the activity.
     * @param timeSpentMinutes The time spent on the activity in minutes.
     * @param averageHeartRate The average heart rate during the activity.
     * @param date The date of the activity.
     * @param repetitions The number of repetitions for the activity.
     * @param user_code The user code of the user associated with this activity.
     * @return The newly inserted Jumping Jack activity.
     */
    public Activity insertActivityJumpingJack(String description, int timeSpentMinutes, int averageHeartRate, LocalDate date, int repetitions, int user_code) throws UserDoesntExistException {
        User user = userController.getUser(user_code);
        int code = this.activities.size();
        Activity activity = new JumpingJack(code,description,timeSpentMinutes,averageHeartRate,date,repetitions, user);
        this.activities.put(code,activity);
        return activity;
    }

    /**
     * Inserts a new Push-Up activity into the system.
     *
     * @param description The description of the activity.
     * @param timeSpentMinutes The time spent on the activity in minutes.
     * @param averageHeartRate The average heart rate during the activity.
     * @param date The date of the activity.
     * @param repetitions The number of repetitions for the activity.
     * @param user_code The user code of the user associated with this activity.
     * @return The newly inserted Push Up activity.
     */
    public Activity insertActivityPushUp(String description, int timeSpentMinutes, int averageHeartRate, LocalDate date, int repetitions, int user_code) throws UserDoesntExistException {
        User user = userController.getUser(user_code);
        int code = this.activities.size();
        Activity activity = new PushUp(code,description,timeSpentMinutes,averageHeartRate,date,repetitions, user);
        this.activities.put(code,activity);
        return activity;
    }

    /**
     * Inserts a new Sit-Up activity into the system.
     *
     * @param description The description of the activity.
     * @param timeSpentMinutes The time spent on the activity in minutes.
     * @param averageHeartRate The average heart rate during the activity.
     * @param date The date of the activity.
     * @param repetitions The number of repetitions for the activity.
     * @param user_code The user code of the user associated with this activity.
     * @return The newly inserted Sit Up activity.
     */
    public Activity insertActivitySitUp(String description, int timeSpentMinutes, int averageHeartRate, LocalDate date, int repetitions, int user_code) throws UserDoesntExistException {
        User user = userController.getUser(user_code);
        int code = this.activities.size();
        Activity activity = new SitUp(code,description,timeSpentMinutes,averageHeartRate,date,repetitions, user);
        this.activities.put(code,activity);
        return activity;
    }

    /**
     * Inserts a new Stretch activity into the system.
     *
     * @param description The description of the activity.
     * @param timeSpentMinutes The time spent on the activity in minutes.
     * @param averageHeartRate The average heart rate during the activity.
     * @param date The date of the activity.
     * @param repetitions The number of repetitions for the activity.
     * @param user_code The user code of the user associated with this activity.
     * @return The newly inserted Stretch activity.
     */
    public Activity insertActivityStretch(String description, int timeSpentMinutes, int averageHeartRate, LocalDate date, int repetitions, int user_code) throws UserDoesntExistException {
        User user = userController.getUser(user_code);
        int code = this.activities.size();
        Activity activity = new Stretch(code,description,timeSpentMinutes,averageHeartRate,date,repetitions,user);
        this.activities.put(code,activity);
        return activity;
    }

    // Colocar aqui as restantes atividades
}
