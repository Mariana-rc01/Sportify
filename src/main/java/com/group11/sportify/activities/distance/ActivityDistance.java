package com.group11.sportify.activities.distance;

import java.time.LocalDate;

import com.group11.sportify.activities.Activity;
import com.group11.sportify.users.User;

public abstract class ActivityDistance extends Activity {
    private double distance;

    /**
     * Default constructor for the ActivityDistance class.
     */
    public ActivityDistance() {
        super();
        this.distance = 0;
    }

    /**
     * Constructor for the ActivityDistance class.
     * @param code The code of the exercise.
     * @param description The description of the exercise.
     * @param time The time spent performing the exercise in minutes.
     * @param averageHeartRate The average heart rate during the activity.
     * @param date The date of the activity.
     * @param distance The distance covered during the activity.
     * @param user the user associated with this activity.
     */
    public ActivityDistance(int code, String description, int time, int averageHeartRate, LocalDate date, double distance, User user) {
        super(code, description, time, averageHeartRate, date, user);
        this.distance = distance;
    }

    /**
     * Constructor for the ActivityDistance class.
     * @param a The activity to copy.
     * @param distance The distance covered during the activity.
     */
    public ActivityDistance(Activity a, double distance) {
        super(a);
        this.distance = distance;
    }

    /**
     * Constructor for the ActivityDistance class.
     * @param s The activity to copy.
     */
    public ActivityDistance(ActivityDistance s) {
        super(s);
        this.distance = s.getDistance();
    }

    /**
     * Gets the distance covered during the activity.
     * @return The distance covered during the activity.
     */
    public double getDistance() {
        return this.distance;
    }

    /**
     * Sets the distance covered during the activity.
     * @param distance The distance covered during the activity.
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    /**
     * Returns a string representation of the ActivityDistance object.
     * @return A string representation of the ActivityDistance object, including information from the superclass and the distance covered.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append("Activity with distance: \n");
        sb.append("Distance = ");
        sb.append(distance).append("\n");

        return sb.toString();
    }

    /**
     * Compares the ActivityDistance object with another object.
     * @param o The object to compare with.
     * @return True if the objects are equal, false otherwise.
     */
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof ActivityDistance that)) return false;
        if(!super.equals(o)) return false;
        return getDistance() == that.getDistance();
    }

    public abstract double calculateCaloriesConsume(User user);
}
