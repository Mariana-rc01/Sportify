package com.group11.sportify.activities.repeating.weight;

import com.group11.sportify.activities.Activity;
import com.group11.sportify.activities.Hard;
import com.group11.sportify.activities.repeating.ActivityRepetitions;
import com.group11.sportify.users.User;

import java.time.LocalDateTime;

public class Weightlifting extends ActivityRepetitionsWeight implements Hard {

    /*
     * Default constructor for the Weightlifting class.
     */
    public Weightlifting(){
        super();
    }

    /**
     * Constructor for the Weightlifting class.
     * @param code The code of the exercise.
     * @param description The description of the exercise.
     * @param time The time spent performing the exercise in minutes.
     * @param averageHeartRate The average heart rate during the activity.
     * @param date The date of the activity.
     * @param repetitions The number of repetitions of the activity.
     * @param weight The weight used during the activity.
     * @param userCode the code of the user associated with this activity.
     */
    public Weightlifting(int code, String description, int time, int averageHeartRate, LocalDateTime date, int repetitions, double weight, int userCode){
        super(code, description, time, averageHeartRate, date, repetitions, weight, userCode);
    }

    /**
     * Constructor for the Weightlifting class.
     * @param a The activity to copy.
     * @param repetitions The number of repetitions of the activity.
     * @param weight The weight used during the activity.
     */
    public Weightlifting(Activity a, int repetitions, double weight){
        super(a, repetitions, weight);
    }

    /**
     * Constructor for the Weightlifting class.
     * @param a The activity to copy.
     * @param weight The weight used during the activity.
     */
    public Weightlifting(ActivityRepetitions a, double weight){
        super(a, weight);
    }

    /**
     * Constructor for the Weightlifting class.
     * @param c The activity to copy.
     */
    public Weightlifting(Weightlifting c){
        super(c);
    }

    /**
     * Clones the Weightlifting object.
     * @return A new instance of Weightlifting object with the same attributes as the original.
     */
    public Weightlifting clone(){
        return new Weightlifting(this);
    }

    /**
     * Returns a string representation of the Weightlifting object.
     * @return A string representation of the Weightlifting object.
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.insert(0, "Weightlifting\n");

        return sb.toString();
    }

    /**
     * Calculates the total calories burned during weightlifting based on the user's characteristics.
     *
     * @param user The user weightlifting.
     * @return The total calories burned during weightlifting.
     */
    public double calculateCaloriesConsume(User user) {
        int reps = this.getRepetitions();
        double weight = this.getWeight();
        double userFactor = user.calculateCaloriesFactor();
        int heartRate = user.getAverageHeartRate() + (int) (1/userFactor)*60;
        double energyExpenditurePerRep = 0.1;
        double energyExpenditureForWeight = 0.3;
        this.setAverageHeartRateDuringActivity(heartRate);
        double caloriesBurned = (reps * energyExpenditurePerRep) + (weight * energyExpenditureForWeight);
        return caloriesBurned * userFactor;
    }

    public boolean isHard() {
        return true;
    }
}
