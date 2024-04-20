package com.group11.sportify.activities;

import com.group11.sportify.users.User;

import java.util.Objects;

/**
 * Abstract class representing a generic activity.
 */
public abstract class Activity {
    private String name;
    private int timeSpentMinutes;
    private int averageHeartRateDuringActivity;

    /**
     * Default constructor.
     */
    public Activity(){
        this.name = "";
        this.timeSpentMinutes = 0;
        this.averageHeartRateDuringActivity = 0;
    }

    /**
     * Constructor with parameters.
     * @param name The name of the activity.
     * @param time The time of the activity.
     * @param h The average heart rate during the activity.
     */
    public Activity(String name, int time, int h){
        this.name = name;
        this.timeSpentMinutes = time;
        this.averageHeartRateDuringActivity = h;
    }

    /**
     * Copy constructor.
     * @param a The activity to copy.
     */
    public Activity(Activity a){
        this.name = a.getName();
        this.timeSpentMinutes = a.getTime();
        this.averageHeartRateDuringActivity = a.getAverageHeartRateDuringActivity();
    }

    /**
     * Get the name of the activity.
     * @return The name of the activity.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set the name of the activity.
     * @param name The name of the activity.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the time spent on the activity.
     * @return The time spent on the activity.
     */
    public int getTime() {
        return this.timeSpentMinutes;
    }

    /**
     * Set the time spent on the activity.
     * @param time The time spent on the activity.
     */
    public void setTime(int time) {
        this.timeSpentMinutes = time;
    }

    /**
     * Get the average heart rate during the activity.
     * @return The average heart rate during the activity.
     */
    public int getAverageHeartRateDuringActivity() {
        return averageHeartRateDuringActivity;
    }

    /**
     * Set the average heart rate during the activity.
     * @param averageHeartRateDuringActivity The average heart rate during the activity.
     */
    public void setAverageHeartRateDuringActivity(int averageHeartRateDuringActivity) {
        this.averageHeartRateDuringActivity = averageHeartRateDuringActivity;
    }

    /**
     * Compare the activity with another object.
     * @param o The object to compare with.
     * @return True if the objects are equal, false otherwise.
     */
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Activity activity = (Activity) o;
        return Objects.equals(this.name, activity.getName()) && this.timeSpentMinutes == activity.getTime()
                && this.averageHeartRateDuringActivity == activity.getAverageHeartRateDuringActivity();
    }

    /**
     * Convert the activity to a string.
     * @return The string of the activity.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Activity: \n");
        sb.append("Name= ");
        sb.append(name).append("\n");
        sb.append("isHard= ");
        sb.append("Time spent= ");
        sb.append(timeSpentMinutes).append("\n");
        sb.append("Average Heart Rate= ");
        sb.append(averageHeartRateDuringActivity).append("\n");

        return sb.toString();
    }

    public abstract double calculateCaloriesConsume(User user);
}
