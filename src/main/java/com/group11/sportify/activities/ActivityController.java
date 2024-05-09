package com.group11.sportify.activities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.group11.sportify.activities.exceptions.ActivityDoesntExistException;
import com.group11.sportify.activities.repeating.ActivityRepetitions;

/**
 * Controller class for managing activities.
 */
public class ActivityController implements Serializable {

    /**
     * Map to store activities with their unique codes as keys.
     */
    private Map<Integer, Activity> activities;

    /**
     * Constructor for ActivityController class.
     * Initializes the activities map.
     */
    public ActivityController() {
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
     * @throws ActivityDoesntExistException If no activity with the given code
     *                                      exists.
     */
    public Activity getActivity(int code) throws ActivityDoesntExistException {
        if (this.activities.containsKey(code)) {
            return this.activities.get(code).clone();
        }
        throw new ActivityDoesntExistException();
    }

    /**
     * Inserts a new activity with repetitions into the system.
     *
     * @param type             The class of the activity.
     * @param description      The description of the activity.
     * @param timeSpentMinutes The time spent on the activity in minutes.
     * @param averageHeartRate The average heart rate during the activity.
     * @param date             The date of the activity.
     * @param repetitions      The number of repetitions for the activity.
     * @param userCode         The code of the user associated with this activity.
     * @return The newly inserted activity.
     */
    public Activity insertActivity(Class<? extends Activity> type, String description, int timeSpentMinutes,
            int averageHeartRate, LocalDateTime date, int repetitions, int userCode) {
        int code = this.activities.size();
        Activity activity = null;
        try {
            activity = type
                    .getConstructor(int.class, String.class, int.class, int.class, LocalDateTime.class, int.class,
                            int.class)
                    .newInstance(code, description, timeSpentMinutes, averageHeartRate, date, repetitions, userCode);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.activities.put(code, activity);
        return activity;
    }

    /**
     * Inserts a new activity with repetitions and weights into the system.
     *
     * @param type             The class of the activity.
     * @param description      The description of the activity.
     * @param timeSpentMinutes The time spent on the activity in minutes.
     * @param averageHeartRate The average heart rate during the activity.
     * @param date             The date of the activity.
     * @param repetitions      The number of repetitions for the activity.
     * @param weight           The weight used during the activity.
     * @param userCode         The code of the user associated with this activity.
     * @return The newly inserted activity.
     */
    public Activity insertActivity(Class<? extends Activity> type, String description, int timeSpentMinutes,
            int averageHeartRate, LocalDateTime date, int repetitions, double weight, int userCode) {
        int code = this.activities.size();
        Activity activity = null;
        try {
            activity = type
                    .getConstructor(int.class, String.class, int.class, int.class, LocalDateTime.class, int.class,
                            double.class, int.class)
                    .newInstance(code, description, timeSpentMinutes, averageHeartRate, date, repetitions, weight,
                            userCode);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.activities.put(code, activity);
        return activity;
    }

    /**
     * Inserts a new activity with distance into the system.
     *
     * @param type             The class of the activity.
     * @param description      The description of the activity.
     * @param timeSpentMinutes The time spent on the activity in minutes.
     * @param averageHeartRate The average heart rate during the activity.
     * @param date             The date of the activity.
     * @param distance         The distance covered in the activity.
     * @param userCode         The code of the user associated with this activity.
     * @return The newly inserted activity.
     */
    public Activity insertActivity(Class<? extends Activity> type, String description, int timeSpentMinutes,
            int averageHeartRate, LocalDateTime date, double distance, int userCode) {
        int code = this.activities.size();
        Activity activity = null;
        try {
            activity = type
                    .getConstructor(int.class, String.class, int.class, int.class, LocalDateTime.class, double.class,
                            int.class)
                    .newInstance(code, description, timeSpentMinutes, averageHeartRate, date, distance, userCode);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.activities.put(code, activity);
        return activity;
    }

    /**
     * Inserts a new activity with distance and altitude into the system.
     *
     * @param type             The class of the activity.
     * @param description      The description of the activity.
     * @param timeSpentMinutes The time spent on the activity in minutes.
     * @param averageHeartRate The average heart rate during the activity.
     * @param date             The date of the activity.
     * @param distance         The distance covered in the activity.
     * @param altitude         The altitude covered in the activity.
     * @param userCode         The code of the user associated with this activity.
     * @return The newly inserted activity.
     */
    public Activity insertActivity(Class<? extends Activity> type, String description, int timeSpentMinutes,
            int averageHeartRate, LocalDateTime date, double distance, double altitude, int userCode) {
        int code = this.activities.size();
        Activity activity = null;
        try {
            activity = type
                    .getConstructor(int.class, String.class, int.class, int.class, LocalDateTime.class, double.class,
                            double.class, int.class)
                    .newInstance(code, description, timeSpentMinutes, averageHeartRate, date, distance, altitude,
                            userCode);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.activities.put(code, activity);
        return activity;
    }

    /**
     * Gets all activities between two dates.
     * 
     * @param startDate
     * @param endDate
     * @return The list of activities between the specified dates.
     */
    public List<Activity> getActivitiesBetweenDates(LocalDateTime startDate, LocalDateTime endDate) {
        return this.activities.values().stream()
                .filter(activity -> activity.getDate().isAfter(startDate) && activity.getDate().isBefore(endDate))
                .map(Activity::clone)
                .toList();
    }

    /**
     * Gets all activities belonging to a user.
     *
     * @param userCode The code of the user to get the activities from.
     * @return The list of activities belonging to the specified user.
     */
    public List<Activity> getUserActivities(int userCode) {
        return this.activities.values().stream()
                .filter(activity -> activity.getUserCode() == userCode)
                .map(Activity::clone)
                .toList();
    }

    // Colocar aqui as restantes atividades

    /**
     * Updates an activity with the specified code with the provided new values.
     *
     * @param code             The unique code of the activity to update.
     * @param description      The new description of the activity (empty string to
     *                         keep unchanged).
     * @param time             The new time spent on the activity in minutes (0 to
     *                         keep unchanged).
     * @param averageHeartRate The new average heart rate during the activity (0 to
     *                         keep unchanged).
     * @param date             The new date of the activity (null to keep
     *                         unchanged).
     * @param repetitions      The new number of repetitions for the activity (0 to
     *                         keep unchanged).
     * @return The updated activity.
     * @throws ActivityDoesntExistException If no activity with the given code
     *                                      exists.
     */
    public Activity updateActivitySeriesReps(int code, String description, int time, int averageHeartRate,
            LocalDateTime date, int repetitions) throws ActivityDoesntExistException {
        if (activities.containsKey(code)) {
            Activity activity = activities.get(code);

            if (!description.isEmpty())
                activity.setDescription(description);
            if (time != 0)
                activity.setTimeSpentMinutes(time);
            if (averageHeartRate != 0)
                activity.setAverageHeartRateDuringActivity(averageHeartRate);
            if (date != null)
                activity.setDate(date);

            ActivityRepetitions seriesReps = (ActivityRepetitions) activity;
            if (repetitions != 0)
                seriesReps.setRepetitions(repetitions);

            activities.put(code, activity);

            return activity;
        } else {
            throw new ActivityDoesntExistException();
        }
    }

    /**
     * Clears all activity data from the ActivityController.
     */
    public void clearActivities() {
        activities.clear();
    }
}
