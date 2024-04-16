package com.group11.sportify.activities.SeriesReps;

import com.group11.sportify.activities.Activity;
import com.group11.sportify.users.User;

/**
 * This class represents the Burpee exercise as a series of repetitions.
 * It extends the SeriesReps class.
 */
public class BurpeeR extends SeriesReps {

    /**
     * Default constructor for the BurpeeR class.
     */
    public BurpeeR(){
        super();
    }

    /**
     * Constructor for the BurpeeR class.
     * @param name The name of the exercise.
     * @param isHard Indicates if the exercise is hard or not.
     * @param time The time spent performing the exercise in minutes.
     * @param repetitions The number of repetitions of the exercise.
     */
    public BurpeeR(String name, boolean isHard, int time, int repetitions) {
        super(name, isHard, time, repetitions);
    }

    /**
     * Constructor for the BurpeeR class.
     * @param a The activity to copy.
     * @param repetitions The number of repetitions of the exercise.
     */
    public BurpeeR(Activity a, int repetitions) {
        super(a, repetitions);
    }

    /**
     * Constructor for the BurpeeR class.
     * @param s The series of repetitions to copy.
     */
    public BurpeeR(SeriesReps s) {
        super(s);
    }

    /**
     * Clones the BurpeeR object.
     * @return A new instance of BurpeeR object with the same attributes as the original.
     */
    public BurpeeR clone(){
        return new BurpeeR(this);
    }

    /**
     * Returns a string representation of the BurpeeR object.
     * @return A string representation of the BurpeeR object.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append("Burpee\n");

        return sb.toString();
    }

    public double calculateCaloriesConsume(User user) {
        return 0;
    }
}
