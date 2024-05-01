package com.group11.sportify.activities.distance.altitude;

import java.time.LocalDateTime;

import com.group11.sportify.activities.Activity;
import com.group11.sportify.activities.distance.ActivityDistance;
import com.group11.sportify.users.User;

public class RoadRunning extends ActivityDistanceAltitude{
    
    /*
    * Default constructor for the RoadRunning class.
    */
    public RoadRunning(){
        super();
    }

    /**
    * Constructor for the RoadRunning class.
    * @param code The code of the exercise.
    * @param description The description of the exercise.
    * @param time The time spent performing the exercise in minutes.
    * @param averageHeartRate The average heart rate during the activity.
    * @param date The date of the activity.
    * @param distance The distance covered during the activity.
    * @param altitude The altitude covered during the activity.
    * @param userCode the code of the user associated with this activity.
    */
    public RoadRunning(int code, String description, int time, int averageHeartRate, LocalDateTime date, double distance, double altitude, int userCode){
        super(code, description, time, averageHeartRate, date, distance, altitude, userCode);
    }

    /**
     * Constructor for the RoadRunning class.
     * @param a The activity to copy.
     * @param distance The distance covered during the activity.
     * @param altitude The altitude covered during the activity.
     */
    public RoadRunning(Activity a, double distance, double altitude){
        super(a, distance, altitude);
    }

    /**
    * Constructor for the RoadRunning class.
    * @param a The activity to copy.
    * @param altitude The altitude covered during the activity.
    */
    public RoadRunning(ActivityDistance a, double altitude){
        super(a, altitude);
    }

    /**
    * Constructor for the RoadRunning class.
    * @param r The activity to copy.
    */
    public RoadRunning(RoadRunning r){
        super(r);
    }

    /**
     * Clones the RoadRunning object.
     * @return A new instance of RoadRunning object with the same attributes as the original.
     */
    public RoadRunning clone(){
        return new RoadRunning(this);
    }

    /**
     * Returns a string representation of the RoadRunning object.
     * @return A string representation of the RoadRunning object.
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.insert(0, "Road Running\n");

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
        int heartRate = user.getAverageHeartRate() + (int) (1/userFactor)*30;
        this.setAverageHeartRateDuringActivity(heartRate);
        double energyExpenditurePerKm = 0.1;
        double energyExpenditureForAltitude = 0.3;
        double caloriesBurned = (distance * energyExpenditurePerKm) + (altitude * energyExpenditureForAltitude);
        return caloriesBurned * userFactor;
    }
}
