package com.group11.sportify.activities.distance;

import com.group11.sportify.activities.Activity;
import com.group11.sportify.users.User;

import java.time.LocalDateTime;

public class Rowing extends ActivityDistance {

    /*
     * Default constructor for the Rowing class.
     */
    public Rowing(){
        super();
    }

    /**
     * Constructor for the Rowing class.
     * @param code The code of the exercise.
     * @param description The description of the exercise.
     * @param time The time spent performing the exercise in minutes.
     * @param averageHeartRate The average heart rate during the activity.
     * @param date The date of the activity.
     * @param distance The distance covered during the activity.
     * @param userCode the code of the user associated with this activity.
     */
    public Rowing(int code, String description, int time, int averageHeartRate, LocalDateTime date, double distance, int userCode){
        super(code, description, time, averageHeartRate, date, distance, userCode);
    }

    /**
     * Constructor for the Rowing class.
     * @param a The activity to copy.
     * @param distance The distance covered during the activity.
     */
    public Rowing(Activity a, double distance){
        super(a, distance);
    }

    /**
     * Constructor for the Rowing class.
     * @param c The activity to copy.
     */
    public Rowing(Rowing c){
        super(c);
    }

    /**
     * Clones the Rowing object.
     * @return A new instance of Rowing object with the same attributes as the original.
     */
    public Rowing clone(){
        return new Rowing(this);
    }

    /**
     * Returns a string representation of the Rowing object.
     * @return A string representation of the Rowing object.
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append("Rowing\n");

        return sb.toString();
    }

    /**
     * Calculates the total calories burned during rowing based on the user's characteristics.
     *
     * @param user The user rowing.
     * @return The total calories burned during rowing.
     */
    public double calculateCaloriesConsume(User user) {
        double distance = this.getDistance();
        double userFactor = user.calculateCaloriesFactor();
        int heartRate = user.getAverageHeartRate() + (int) (2/userFactor)*35;
        double energyExpenditurePerKm = 0.3;
        this.setAverageHeartRateDuringActivity(heartRate);
        double caloriesBurned = (1.25 * distance * energyExpenditurePerKm);
        return caloriesBurned * userFactor;
    }
}