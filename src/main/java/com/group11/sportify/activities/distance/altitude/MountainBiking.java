package com.group11.sportify.activities.distance.altitude;

import java.time.LocalDateTime;

import com.group11.sportify.activities.Activity;
import com.group11.sportify.activities.distance.ActivityDistance;
import com.group11.sportify.users.User;

public class MountainBiking extends ActivityDistanceAltitude{

    /*
     * Default constructor for the MountainBiking class.
     */
    public MountainBiking(){
        super();
    }

    /**
     * Constructor for the MountainBiking class.
     * @param code The code of the exercise.
     * @param description The description of the exercise.
     * @param time The time spent performing the exercise in minutes.
     * @param averageHeartRate The average heart rate during the activity.
     * @param date The date of the activity.
     * @param distance The distance covered during the activity.
     * @param altitude The altitude covered during the activity.
     * @param userCode the code of the user associated with this activity.
     */
    public MountainBiking(int code, String description, int time, int averageHeartRate, LocalDateTime date, double distance, double altitude, int userCode){
        super(code, description, time, averageHeartRate, date, distance, altitude, userCode);
    }

    /**
     * Constructor for the MountainBiking class.
     * @param a The activity to copy.
     * @param distance The distance covered during the activity.
     * @param altitude The altitude covered during the activity.
     */
    public MountainBiking(Activity a, double distance, double altitude){
        super(a, distance, altitude);
    }

    /**
     * Constructor for the MountainBiking class.
     * @param a The activity to copy.
     * @param altitude The altitude covered during the activity.
     */
    public MountainBiking(ActivityDistance a, double altitude){
        super(a, altitude);
    }

    /**
     * Constructor for the MountainBiking class.
     * @param c The activity to copy.
     */
    public MountainBiking(MountainBiking c){
        super(c);
    }

    /**
     * Clones the MountainBiking object.
     * @return A new instance of MountainBiking object with the same attributes as the original.
     */
    public MountainBiking clone(){
        return new MountainBiking(this);
    }

    /**
     * Returns a string representation of the MountainBiking object.
     * @return A string representation of the MountainBiking object.
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append("Mountain Biking\n");

        return sb.toString();
    }

    /**
     * Calculates the total calories burned during cycling based on the user's characteristics.
     *
     * @param user The user cycling.
     * @return The total calories burned during cycling.
     */
    public double calculateCaloriesConsume(User user) {
        double distance = this.getDistance();
        double altitude = this.getAltitude();
        double userFactor = user.calculateCaloriesFactor();
        int heartRate = user.getAverageHeartRate() + (int) (1/userFactor)*45;
        double energyExpenditurePerKm = 0.1;
        double energyExpenditureForAltitude = 0.15;
        this.setAverageHeartRateDuringActivity(heartRate);
        double caloriesBurned = (distance * energyExpenditurePerKm) + (altitude * energyExpenditureForAltitude);
        return caloriesBurned * userFactor;
    }
}
