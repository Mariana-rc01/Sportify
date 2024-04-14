package com.group11.sportify.activities.SeriesReps;

import com.group11.sportify.activities.Activity;
import com.group11.sportify.users.User;

/**
 * This class represents the Stretch exercise as a series of repetitions.
 * It extends the SeriesReps class.
 */
public class StretcheR extends SeriesReps {

    /**
     * Default constructor for the StretcheR class.
     */
    public StretcheR() {
        super();
    }

    /**
     * Constructor for the StretcheR class.
     * @param name The name of the exercise.
     * @param isHard Indicates if the exercise is hard or not.
     * @param time The time spent performing the exercise in minutes.
     * @param repetitions The number of repetitions of the exercise.
     */
    public StretcheR(String name, boolean isHard, int time, int repetitions) {
        super(name, isHard, time, repetitions);
    }

    /**
     * Constructor for the StretcheR class.
     * @param a The activity to copy.
     * @param repetitions The number of repetitions of the exercise.
     */
    public StretcheR(Activity a, int repetitions) {
        super(a, repetitions);
    }

    /**
     * Constructor for the StretcheR class.
     * @param s The series of repetitions to copy.
     */
    public StretcheR(SeriesReps s) {
        super(s);
    }

    /**
     * Clones the StretcheR object.
     * @return A new instance of StretcheR object with the same attributes as the original.
     */
    public StretcheR clone(){
        return new StretcheR(this);
    }

    /**
     * Returns a string representation of the StretcheR object.
     * @return A string representation of the StretcheR object, including information from the superclass and indication of StretcheR type.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append("Strecher\n");

        return sb.toString();
    }

    public double calculateCaloriesConsume(User user) {
        return 0;
    }
}
