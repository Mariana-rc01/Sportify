package com.group11.sportify.activities.distance.altitude;

import java.time.LocalDate;

import com.group11.sportify.activities.Activity;
import com.group11.sportify.activities.distance.ActivityDistance;
import com.group11.sportify.users.User;

public class TrailRunning extends ActivityDistanceAltitude{
    
    /*
    * Default constructor for the TrailRunning class.
    */
    public TrailRunning(){
        super();
    }

    /**
    * Constructor for the TrailRunning class.
    * @param code The code of the exercise.
    * @param description The description of the exercise.
    * @param time The time spent performing the exercise in minutes.
    * @param averageHeartRate The average heart rate during the activity.
    * @param date The date of the activity.
    * @param distance The distance covered during the activity.
    * @param altitude The altitude covered during the activity.
    * @param user the user associated with this activity.
    */
    public TrailRunning(int code, String description, int time, int averageHeartRate, LocalDate date, double distance, double altitude, User user){
        super(code, description, time, averageHeartRate, date, distance, altitude, user);
    }

    /**
     * Constructor for the TrailRunning class.
     * @param a The activity to copy.
     * @param distance The distance covered during the activity.
     * @param altitude The altitude covered during the activity.
     */
    public TrailRunning(Activity a, double distance, double altitude){
        super(a, distance, altitude);
    }

    /**
    * Constructor for the TrailRunning class.
    * @param a The activity to copy.
    * @param altitude The altitude covered during the activity.
    */
    public TrailRunning(ActivityDistance a, double altitude){
        super(a, altitude);
    }

    /**
    * Constructor for the TrailRunning class.
    * @param r The activity to copy.
    */
    public TrailRunning(TrailRunning r){
        super(r);
    }

    /**
     * Clones the TrailRunning object.
     * @return A new instance of TrailRunning object with the same attributes as the original.
     */
    public TrailRunning clone(){
        return new TrailRunning(this);
    }

    /**
     * Returns a string representation of the TrailRunning object.
     * @return A string representation of the TrailRunning object.
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append("Trail Running\n");

        return sb.toString();
    }

    /**
     * Calculates the total calories burned running based on the user's characteristics.
     *
     * @param user The user running.
     * @return The total calories burned during running.
     */
    public double calculateCaloriesConsume(User user) {
        double distance = this.getDistance();
        double altitude = this.getAltitude();
        double userFactor = user.calculateCaloriesFactor();
        int heartRate = user.getAverageHeartRate() + (int) (1/userFactor)*35;
        this.setAverageHeartRateDuringActivity(heartRate);
        double energyExpenditurePerKm = 0.1;
        double energyExpenditureForAltitude = 0.2;
        double caloriesBurned = (distance * energyExpenditurePerKm) + (altitude * energyExpenditureForAltitude);
        return caloriesBurned * userFactor;
    }
}
