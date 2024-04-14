package com.group11.sportify.activities.SeriesReps;

import com.group11.sportify.activities.Activity;
import com.group11.sportify.users.User;

/**
 * This class represents the Push-up exercise as a series of repetitions.
 * It extends the SeriesReps class.
 */
public class PushUpR extends SeriesReps {

    /**
     * Default constructor for the PushUpR class.
     */
    public PushUpR() {
        super();
    }

    /**
     * Constructor for the PushUpR class.
     * @param name The name of the exercise.
     * @param isHard Indicates if the exercise is hard or not.
     * @param time The time spent performing the exercise in minutes.
     * @param repetitions The number of repetitions of the exercise.
     */
    public PushUpR(String name, boolean isHard, int time, int repetitions) {
        super(name, isHard, time, repetitions);
    }

    /**
     * Constructor for the PushUpR class.
     * @param a The activity to copy.
     * @param repetitions The number of repetitions of the exercise.
     */
    public PushUpR(Activity a, int repetitions) {
        super(a, repetitions);
    }

    /**
     * Constructor for the PushUpR class.
     * @param s The series of repetitions to copy.
     */
    public PushUpR(SeriesReps s) {
        super(s);
    }

    /**
     * Clones the PushUpR object.
     * @return A new instance of PushUpR object with the same attributes as the original.
     */
    public PushUpR clone(){
        return new PushUpR(this);
    }

    /**
     * Returns a string representation of the PushUpR object.
     * @return A string representation of the PushUpR object, including information from the superclass and indication of Push Up type.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append("Push Up\n");

        return sb.toString();
    }


    public double calculateCaloriesConsume(User user) {
        return 0;
    }
}
