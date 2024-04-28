package com.group11.sportify.activities.distance;

import com.group11.sportify.activities.Activity;
import com.group11.sportify.activities.Hard;
import com.group11.sportify.users.User;

import java.time.LocalDate;

public class IceSkating extends ActivityDistance implements Hard {

    /*
     * Default constructor for the IceSkating class.
     */
    public IceSkating(){
        super();
    }

    /**
     * Constructor for the IceSkating class.
     * @param code The code of the exercise.
     * @param description The description of the exercise.
     * @param time The time spent performing the exercise in minutes.
     * @param averageHeartRate The average heart rate during the activity.
     * @param date The date of the activity.
     * @param distance The distance covered during the activity.
     * @param user the user associated with this activity.
     */
    public IceSkating(int code, String description, int time, int averageHeartRate, LocalDate date, double distance, User user){
        super(code, description, time, averageHeartRate, date, distance, user);
    }

    /**
     * Constructor for the IceSkating class.
     * @param a The activity to copy.
     * @param distance The distance covered during the activity.
     */
    public IceSkating(Activity a, double distance){
        super(a, distance);
    }

    /**
     * Constructor for the IceSkating class.
     * @param c The activity to copy.
     */
    public IceSkating(IceSkating c){
        super(c);
    }

    /**
     * Clones the IceSkating object.
     * @return A new instance of IceSkating object with the same attributes as the original.
     */
    public IceSkating clone(){
        return new IceSkating(this);
    }

    /**
     * Returns a string representation of the IceSkating object.
     * @return A string representation of the IceSkating object.
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append("Ice Skating\n");

        return sb.toString();
    }

    /**
     * Calculates the total calories burned during ice skating based on the user's characteristics.
     *
     * @param user The user ice skating.
     * @return The total calories burned during ice skating.
     */
    public double calculateCaloriesConsume(User user) {
        double distance = this.getDistance();
        double userFactor = user.calculateCaloriesFactor();
        int heartRate = user.getAverageHeartRate() + (int) (3/userFactor)*20;
        double energyExpenditurePerKm = 0.1;
        this.setAverageHeartRateDuringActivity(heartRate);
        double caloriesBurned = (0.75 * distance * energyExpenditurePerKm);
        return caloriesBurned * userFactor;
    }

    public boolean isHard() {
        return true;
    }
}
