package com.group11.sportify.activities.SeriesReps;

import com.group11.sportify.activities.Activity;
import com.group11.sportify.users.User;

/**
 * This class represents the Stretch exercise as a series of repetitions.
 * It extends the SeriesReps class.
 */
public class Stretch extends SeriesReps {

    /**
     * Default constructor for the Stretch class.
     */
    public Stretch() {
        super();
    }

    /**
     * Constructor for the Stretch class.
     * @param name The name of the exercise.
     * @param time The time spent performing the exercise in minutes.
     * @param repetitions The number of repetitions of the exercise.
     */
    public Stretch(String name, int time, int averageHeartRate, int repetitions) {
        super(name, time, averageHeartRate, repetitions);
    }

    /**
     * Constructor for the Stretch class.
     * @param a The activity to copy.
     * @param repetitions The number of repetitions of the exercise.
     */
    public Stretch(Activity a, int repetitions) {
        super(a, repetitions);
    }

    /**
     * Constructor for the Stretch class.
     * @param s The series of repetitions to copy.
     */
    public Stretch(SeriesReps s) {
        super(s);
    }

    /**
     * Clones the Stretch object.
     * @return A new instance of Stretch object with the same attributes as the original.
     */
    public Stretch clone(){
        return new Stretch(this);
    }

    /**
     * Returns a string representation of the Stretch object.
     * @return A string representation of the Stretch object, including information from the superclass and indication of Stretch type.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append("Strech\n");

        return sb.toString();
    }

    /**
     * Calculates the total calories burned during stretches based on the user's characteristics.
     *
     * @param user The user performing the stretches.
     * @return The total calories burned during stretches.
     */
    public double calculateCaloriesConsume(User user) {
        double caloriesPerStretch = 0.1;
        int reps = this.getRepetitions();
        double userFactor = user.calculateCaloriesFactor();
        int heartRate;
        heartRate = user.getAverageHeartRate() + (int) (1/userFactor)*5;
        this.setAverageHeartRateDuringActivity(heartRate);
        return caloriesPerStretch * this.getRepetitions() * userFactor;
    }
}
