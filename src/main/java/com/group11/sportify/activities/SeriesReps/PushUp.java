package com.group11.sportify.activities.SeriesReps;

import com.group11.sportify.activities.Activity;
import com.group11.sportify.activities.Hard;
import com.group11.sportify.users.User;

/**
 * This class represents the Push-up exercise as a series of repetitions.
 * It extends the SeriesReps class.
 */
public class PushUp extends SeriesReps implements Hard {

    /**
     * Default constructor for the PushUp class.
     */
    public PushUp() {
        super();
    }

    /**
     * Constructor for the PushUp class.
     * @param name The name of the exercise.
     * @param time The time spent performing the exercise in minutes.
     * @param repetitions The number of repetitions of the exercise.
     */
    public PushUp(String name, int time, int repetitions) {
        super(name, time, repetitions);
    }

    /**
     * Constructor for the PushUp class.
     * @param a The activity to copy.
     * @param repetitions The number of repetitions of the exercise.
     */
    public PushUp(Activity a, int repetitions) {
        super(a, repetitions);
    }

    /**
     * Constructor for the PushUp class.
     * @param s The series of repetitions to copy.
     */
    public PushUp(SeriesReps s) {
        super(s);
    }

    /**
     * Clones the PushUp object.
     * @return A new instance of PushUp object with the same attributes as the original.
     */
    public PushUp clone(){
        return new PushUp(this);
    }

    /**
     * Returns a string representation of the PushUp object.
     * @return A string representation of the PushUp object, including information from the superclass and indication of Push Up type.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append("Push Up\n");

        return sb.toString();
    }

    /**
     * Checks if the Push Up exercise is hard.
     * @return Always returns true, as Push Up is considered a hard activity.
     */
    public boolean isHard() {
        return true;
    }

    public double calculateCaloriesConsume(User user) {
        return 0;
    }
}
