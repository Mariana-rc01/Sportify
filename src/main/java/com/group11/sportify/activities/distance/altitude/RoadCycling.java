package com.group11.sportify.activities.distance.altitude;

import java.time.LocalDateTime;

import com.group11.sportify.activities.Activity;
import com.group11.sportify.activities.distance.ActivityDistance;
import com.group11.sportify.users.User;

public class RoadCycling extends ActivityDistanceAltitude{

    /*
     * Default constructor for the RoadCycling class.
     */
    public RoadCycling(){
        super();
    }

    /**
     * Constructor for the RoadCycling class.
     * @param code The code of the exercise.
     * @param description The description of the exercise.
     * @param time The time spent performing the exercise in minutes.
     * @param averageHeartRate The average heart rate during the activity.
     * @param date The date of the activity.
     * @param distance The distance covered during the activity.
     * @param altitude The altitude covered during the activity.
     * @param userCode the code of the user associated with this activity.
     */
    public RoadCycling(int code, String description, int time, int averageHeartRate, LocalDateTime date, double distance, double altitude, int userCode){
        super(code, description, time, averageHeartRate, date, distance, altitude, userCode);
    }

    /**
     * Constructor for the RoadCycling class.
     * @param a The activity to copy.
     * @param distance The distance covered during the activity.
     * @param altitude The altitude covered during the activity.
     */
    public RoadCycling(Activity a, double distance, double altitude){
        super(a, distance, altitude);
    }

    /**
     * Constructor for the RoadCycling class.
     * @param a The activity to copy.
     * @param altitude The altitude covered during the activity.
     */
    public RoadCycling(ActivityDistance a, double altitude){
        super(a, altitude);
    }

    /**
     * Constructor for the RoadCycling class.
     * @param c The activity to copy.
     */
    public RoadCycling(RoadCycling c){
        super(c);
    }

    /**
     * Clones the RoadCycling object.
     * @return A new instance of RoadCycling object with the same attributes as the original.
     */
    public RoadCycling clone(){
        return new RoadCycling(this);
    }

    /**
     * Returns a string representation of the RoadCycling object.
     * @return A string representation of the RoadCycling object.
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append("Road Cycling\n");

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
        int heartRate = user.getAverageHeartRate() + (int) (1/userFactor)*35;
        double energyExpenditurePerKm = 0.05;
        double energyExpenditureForAltitude = 0.1;
        this.setAverageHeartRateDuringActivity(heartRate);
        double caloriesBurned = (distance * energyExpenditurePerKm) + (altitude * energyExpenditureForAltitude);
        return caloriesBurned * userFactor;
    }
}
