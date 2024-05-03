package com.group11.sportify.activities.repeating.weight;

import com.group11.sportify.activities.Activity;
import com.group11.sportify.activities.repeating.ActivityRepetitions;
import com.group11.sportify.users.User;

import java.time.LocalDateTime;

public class LegExtension extends ActivityRepetitionsWeight{

    /*
     * Default constructor for the LegExtension class.
     */
    public LegExtension(){
        super();
    }

    /**
     * Constructor for the LegExtension class.
     * @param code The code of the exercise.
     * @param description The description of the exercise.
     * @param time The time spent performing the exercise in minutes.
     * @param averageHeartRate The average heart rate during the activity.
     * @param date The date of the activity.
     * @param repetitions The number of repetitions of the activity.
     * @param weight The weight used during the activity.
     * @param userCode the user code associated with this activity.
     */
    public LegExtension(int code, String description, int time, int averageHeartRate, LocalDateTime date, int repetitions, double weight, int userCode){
        super(code, description, time, averageHeartRate, date, repetitions, weight, userCode);
    }

    /**
     * Constructor for the LegExtension class.
     * @param a The activity to copy.
     * @param repetitions The number of repetitions of the activity.
     * @param weight The weight used during the activity.
     */
    public LegExtension(Activity a, int repetitions, double weight){
        super(a, repetitions, weight);
    }

    /**
     * Constructor for the LegExtension class.
     * @param a The activity to copy.
     * @param weight The weight used during the activity.
     */
    public LegExtension(ActivityRepetitions a, double weight){
        super(a, weight);
    }

    /**
     * Constructor for the LegExtension class.
     * @param c The activity to copy.
     */
    public LegExtension(LegExtension c){
        super(c);
    }

    /**
     * Clones the LegExtension object.
     * @return A new instance of LegExtension object with the same attributes as the original.
     */
    public LegExtension clone(){
        return new LegExtension(this);
    }

    /**
     * Returns a string representation of the LegExtension object.
     * @return A string representation of the LegExtension object.
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.insert(0, "Leg Extension\n");

        return sb.toString();
    }

    /**
     * Calculates the total calories burned during leg extensions based on the user's characteristics.
     *
     * @param user The user doing leg extensions.
     * @return The total calories burned during leg extensions.
     */
    public double calculateCaloriesConsume(User user) {
        int reps = this.getRepetitions();
        double weight = this.getWeight();
        double userFactor = user.calculateCaloriesFactor();
        int heartRate = user.getAverageHeartRate() + (int) (1/userFactor)*50;
        double energyExpenditurePerRep = 0.1;
        double energyExpenditureForWeight = 0.25;
        this.setAverageHeartRateDuringActivity(heartRate);
        double caloriesBurned = (reps * energyExpenditurePerRep) + (weight * energyExpenditureForWeight);
        return caloriesBurned * userFactor;
    }
}
