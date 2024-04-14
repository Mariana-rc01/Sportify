package com.group11.sportify.activities;

import com.group11.sportify.users.User;

import java.util.Objects;

/**
 * Abstract class representing a generic activity.
 */
public abstract class Activity {
    private String name;
    private boolean isHard;
    private int timeSpentMinutes;

    /**
     * Default constructor.
     */
    public Activity(){
        this.name = "";
        this.isHard = false;
        this.timeSpentMinutes = 0;
    }

    /**
     * Constructor with parameters.
     * @param name The name of the activity.
     * @param isHard Indicates if the activity is hard or not.
     */
    public Activity(String name, boolean isHard, int time){
        this.name = name;
        this.isHard = isHard;
        this.timeSpentMinutes = time;
    }

    /**
     * Copy constructor.
     * @param a The activity to copy.
     */
    public Activity(Activity a){
        this.name = a.getName();
        this.isHard = a.isHard();
        this.timeSpentMinutes = a.getTime();
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
     * Check if the activity is hard.
     * @return True if the activity is hard, false otherwise.
     */
    public boolean isHard() {
        return this.isHard;
    }

    /**
     * Set if the activity is hard or not.
     * @param hard True if the activity is hard, false otherwise.
     */
    public void setHard(boolean hard) {
        this.isHard = hard;
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
     * Compare the activity with another object.
     * @param o The object to compare with.
     * @return True if the objects are equal, false otherwise.
     */
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Activity activity = (Activity) o;
        return this.isHard == activity.isHard() && Objects.equals(this.name, activity.getName()) && this.timeSpentMinutes == activity.getTime();
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
        sb.append(isHard).append("\n");
        sb.append("Time spent= ");
        sb.append(timeSpentMinutes).append("\n");

        return sb.toString();
    }

    public abstract double calculateCaloriesConsume(User user);
}
