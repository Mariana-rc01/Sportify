package com.group11.sportify.activities;

import com.group11.sportify.activities.SeriesReps.*;
import com.group11.sportify.activities.exceptions.ActivityDoesntExistException;
import com.group11.sportify.users.User;

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
     * Constructor for ActivityController class.
     * Initializes the activities map.
     */
    public ActivityController(){
        this.activities = new HashMap<>();
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
     * @throws ActivityDoesntExistException If no activity with the given code exists.
     */
    public Activity getActivity(int code) throws ActivityDoesntExistException {
        if(this.activities.containsKey(code)){
            return this.activities.get(code).clone();
        }
        throw new ActivityDoesntExistException();
    }

    /**
     * Inserts a new Burpee activity into the system.
     *
     * @param description The description of the activity.
     * @param timeSpentMinutes The time spent on the activity in minutes.
     * @param averageHeartRate The average heart rate during the activity.
     * @param date The date of the activity.
     * @param repetitions The number of repetitions for the activity.
     * @param user The user associated with this activity.
     * @return The newly inserted Burpee activity.
     */
    public Activity insertActivityBurpee(String description, int timeSpentMinutes, int averageHeartRate, LocalDate date, int repetitions, User user){
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
     * @param user The user associated with this activity.
     * @return The newly inserted Jumping Jack activity.
     */
    public Activity insertActivityJumpingJack(String description, int timeSpentMinutes, int averageHeartRate, LocalDate date, int repetitions, User user){
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
     * @param user The user associated with this activity.
     * @return The newly inserted Push Up activity.
     */
    public Activity insertActivityPushUp(String description, int timeSpentMinutes, int averageHeartRate, LocalDate date, int repetitions, User user){
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
     * @param user The user associated with this activity.
     * @return The newly inserted Sit Up activity.
     */
    public Activity insertActivitySitUp(String description, int timeSpentMinutes, int averageHeartRate, LocalDate date, int repetitions, User user){
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
     * @param user The user associated with this activity.
     * @return The newly inserted Stretch activity.
     */
    public Activity insertActivityStretch(String description, int timeSpentMinutes, int averageHeartRate, LocalDate date, int repetitions, User user){
        int code = this.activities.size();
        Activity activity = new Stretch(code,description,timeSpentMinutes,averageHeartRate,date,repetitions,user);
        this.activities.put(code,activity);
        return activity;
    }

    // Colocar aqui as restantes atividades

    /**
     * Updates an activity with the specified code with the provided new values.
     *
     * @param code The unique code of the activity to update.
     * @param description The new description of the activity (empty string to keep unchanged).
     * @param time The new time spent on the activity in minutes (0 to keep unchanged).
     * @param averageHeartRate The new average heart rate during the activity (0 to keep unchanged).
     * @param date The new date of the activity (null to keep unchanged).
     * @param repetitions The new number of repetitions for the activity (0 to keep unchanged).
     * @return The updated activity.
     * @throws ActivityDoesntExistException If no activity with the given code exists.
     */
    public Activity updateActivitySeriesReps(int code, String description, int time, int averageHeartRate, LocalDate date, int repetitions) throws ActivityDoesntExistException {
        if (activities.containsKey(code)) {
            Activity activity = activities.get(code);

            if (!description.isEmpty()) activity.setDescription(description);
            if (time != 0) activity.setTimeSpentMinutes(time);
            if (averageHeartRate != 0) activity.setAverageHeartRateDuringActivity(averageHeartRate);
            if (date != null) activity.setDate(date);

            SeriesReps seriesReps = (SeriesReps) activity;
            if (repetitions != 0) seriesReps.setRepetitions(repetitions);

            activities.put(code, activity);

            return activity;
        } else {
            throw new ActivityDoesntExistException();
        }
    }
}
