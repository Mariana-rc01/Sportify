package com.group11.sportify.activities;

import com.group11.sportify.users.User;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Abstract class representing a generic activity.
 */
public abstract class Activity {

    private int code;
    private String description;
    private int timeSpentMinutes;
    private int averageHeartRateDuringActivity;
    private LocalDate date;
    private int userCode;

    /**
     * Default constructor.
     */
    public Activity(){
        this.code = 0;
        this.description = "";
        this.timeSpentMinutes = 0;
        this.averageHeartRateDuringActivity = 0;
        this.date = LocalDate.EPOCH;
    }

    /**
     * Constructor with parameters.
     * @param code Unique code of the activity.
     * @param description Description of the activity.
     * @param time The time of the activity.
     * @param averageHeartRate The average heart rate during the activity.
     * @param date Date of the activity.
     * @param user the user associated with this activity.
     */
    public Activity(int code, String description, int time, int averageHeartRate, LocalDate date, int userCode){
        this.code = code;
        this.description = description;
        this.timeSpentMinutes = time;
        this.averageHeartRateDuringActivity = averageHeartRate;
        this.date = date;
        this.userCode = userCode;
    }

    /**
     * Copy constructor.
     * @param a The activity to copy.
     */
    public Activity(Activity a){
        this.code = a.getCode();
        this.description = a.getDescription();
        this.timeSpentMinutes = a.getTimeSpentMinutes();
        this.averageHeartRateDuringActivity = a.getAverageHeartRateDuringActivity();
        this.userCode = a.getUserCode();
    }

    /**
     * Get the code of the activity.
     * @return The code of the activity.
     */
    public int getCode() {
        return this.code;
    }

    /**
     * Set the code of the activity.
     * @param code The code of the activity.
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Get the description of the activity.
     * @return The description of the activity.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Set the description of the activity.
     * @param description The code of the activity.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the time spent on the activity.
     * @return The time spent on the activity.
     */
    public int getTimeSpentMinutes() {
        return this.timeSpentMinutes;
    }

    /**
     * Set the time spent on the activity.
     * @param timeSpentMinutes The time spent on the activity.
     */
    public void setTimeSpentMinutes(int timeSpentMinutes) {
        this.timeSpentMinutes = timeSpentMinutes;
    }

    /**
     * Get the date of the activity.
     * @return Date of the activity.
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Set the date of the activity.
     * @param date Date of the activity.
     */
    public void setDate(LocalDate date) {
        this.date = date;
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
     * Returns the code of the user associated with this activity.
     *
     * @return Code of the user associated with this activity.
     */
    public int getUserCode() {
        return this.userCode;
    }

    /**
     * Compare the activity with another object.
     * @param o The object to compare with.
     * @return True if the objects are equal, false otherwise.
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Activity activity)) return false;
        return getCode() == activity.getCode() && getTimeSpentMinutes() == activity.getTimeSpentMinutes() &&
                getAverageHeartRateDuringActivity() == activity.getAverageHeartRateDuringActivity() &&
                Objects.equals(getDescription(), activity.getDescription()) && Objects.equals(getDate(), activity.getDate()) &&
                Objects.equals(getUserCode(), activity.getUserCode());
    }

    public abstract Activity clone();

    /**
     * Convert the activity to a string.
     * @return The string of the activity.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Activity: \n");
        sb.append("Code = ");
        sb.append(code).append("\n");
        sb.append("Description = ");
        sb.append(description).append("\n");
        sb.append("Time spent = ");
        sb.append(timeSpentMinutes).append("\n");
        sb.append("Average Heart Rate = ");
        sb.append(averageHeartRateDuringActivity).append("\n");
        sb.append("Date = ");
        sb.append(date).append("\n");
        return sb.toString();
    }

    public abstract double calculateCaloriesConsume(User user);
}
