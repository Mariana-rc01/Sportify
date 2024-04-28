package com.group11.sportify.activities.distance.altitude;

import com.group11.sportify.activities.Activity;
import com.group11.sportify.activities.distance.ActivityDistance;
import com.group11.sportify.users.User;

import java.time.LocalDate;

/**
 * This abstract class represents an exercise envolving distance and altitude.
 * It extends the Activity class.
 */
public abstract class ActivityDistanceAltitude extends ActivityDistance {
    private double altitude;

    /**
     * Default constructor for the ActivityDistanceAltitude class.
     */
    public ActivityDistanceAltitude() {
        super();
        this.altitude = 0;
    }

    /**
     * Constructor for the ActivityDistanceAltitude class.
     * @param code The code of the exercise.
     * @param description The description of the exercise.
     * @param time The time spent performing the exercise in minutes.
     * @param averageHeartRate The average heart rate during the activity.
     * @param date The date of the activity.
     * @param distance The distance covered during the activity.
     * @param altitude The altitude covered during the activity.
     * @param user the user associated with this activity.
     */
    public ActivityDistanceAltitude(int code, String description, int time, int averageHeartRate, LocalDate date, double distance, double altitude, User user) {
        super(code, description, time, averageHeartRate, date, distance, user);
        this.altitude = altitude;
    }

    /**
     * Constructor for the ActivityDistanceAltitude class.
     * @param a The activity to copy.
     * @param altitude The altitude covered during the activity.
     */
    public ActivityDistanceAltitude(ActivityDistance a, double altitude) {
        super(a);
        this.altitude = altitude;
    }

    /**
     * Constructor for the ActivityDistanceAltitude class.
     * @param a The activity to copy.
     * @param distance The distance covered during the activity.
     * @param altitude The altitude covered during the activity.
     */
    public ActivityDistanceAltitude(Activity a, double distance, double altitude) {
        super(a, distance);
        this.altitude = altitude;
    }

    /**
     * Constructor for the ActivityDistanceAltitude class.
     * @param s The activity to copy.
     */
    public ActivityDistanceAltitude(ActivityDistanceAltitude s) {
        super(s);
        this.altitude = s.getAltitude();
    }

    /**
     * Gets the altitude covered during the activity.
     * @return The altitude covered during the activity.
     */
    public double getAltitude() {
        return this.altitude;
    }

    /**
     * Sets the altitude covered during the activity.
     * @param altitude The altitude covered during the activity.
     */
    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    /**
     * Returns a string representation of the ActivityDistanceAltitude object.
     * @return A string representation of the ActivityDistanceAltitude object, including information from the superclass and the distance covered.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append("Activity with altitude: \n");
        sb.append("Altitude = ");
        sb.append(altitude).append("\n");

        return sb.toString();
    }

    public abstract double calculateCaloriesConsume(User user);
}