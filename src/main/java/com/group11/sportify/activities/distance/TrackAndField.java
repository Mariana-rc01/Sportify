package com.group11.sportify.activities.distance;

import com.group11.sportify.activities.Activity;
import com.group11.sportify.users.User;

import java.time.LocalDateTime;

public class TrackAndField extends ActivityDistance {

    /*
     * Default constructor for the TrackAndField class.
     */
    public TrackAndField(){
        super();
    }

    /**
     * Constructor for the TrackAndField class.
     * @param code The code of the exercise.
     * @param description The description of the exercise.
     * @param time The time spent performing the exercise in minutes.
     * @param averageHeartRate The average heart rate during the activity.
     * @param date The date of the activity.
     * @param distance The distance covered during the activity.
     * @param userCode the code of the user associated with this activity.
     */
    public TrackAndField(int code, String description, int time, int averageHeartRate, LocalDateTime date, double distance, int userCode){
        super(code, description, time, averageHeartRate, date, distance, userCode);
    }

    /**
     * Constructor for the TrackAndField class.
     * @param a The activity to copy.
     * @param distance The distance covered during the activity.
     */
    public TrackAndField(Activity a, double distance){
        super(a, distance);
    }

    /**
     * Constructor for the TrackAndField class.
     * @param c The activity to copy.
     */
    public TrackAndField(TrackAndField c){
        super(c);
    }

    /**
     * Clones the TrackAndField object.
     * @return A new instance of TrackAndField object with the same attributes as the original.
     */
    public TrackAndField clone(){
        return new TrackAndField(this);
    }

    /**
     * Returns a string representation of the TrackAndField object.
     * @return A string representation of the TrackAndField object.
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append("Track and Field\n");

        return sb.toString();
    }

    /**
     * Calculates the total calories burned during track And field based on the user's characteristics.
     *
     * @param user The user doing track and field.
     * @return The total calories burned during track and field.
     */
    public double calculateCaloriesConsume(User user) {
        double distance = this.getDistance();
        double userFactor = user.calculateCaloriesFactor();
        int heartRate = user.getAverageHeartRate() + (int) (2/userFactor)*25;
        double energyExpenditurePerKm = 0.2;
        this.setAverageHeartRateDuringActivity(heartRate);
        double caloriesBurned = (1.1 * distance * energyExpenditurePerKm);
        return caloriesBurned * userFactor;
    }
}
