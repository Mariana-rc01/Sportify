package com.group11.sportify.activities.SeriesReps;

import com.group11.sportify.activities.Activity;
import com.group11.sportify.activities.Hard;
import com.group11.sportify.users.User;

/**
 * This class represents the Sit-up exercise as a series of repetitions.
 * It extends the SeriesReps class.
 */
public class SitUp extends SeriesReps implements Hard {

    /**
     * Default constructor for the SitUp class.
     */
    public SitUp() {
        super();
    }

    /**
     * Constructor for the SitUp class.
     * @param name The name of the exercise.
     * @param time The time spent performing the exercise in minutes.
     * @param repetitions The number of repetitions of the exercise.
     */
    public SitUp(String name, int time, int repetitions) {
        super(name, time, repetitions);
    }

    /**
     * Constructor for the SitUp class.
     * @param a The activity to copy.
     * @param repetitions The number of repetitions of the exercise.
     */
    public SitUp(Activity a, int repetitions) {
        super(a, repetitions);
    }

    /**
     * Constructor for the SitUp class.
     * @param s The series of repetitions to copy.
     */
    public SitUp(SeriesReps s) {
        super(s);
    }

    /**
     * Clones the SitUp object.
     * @return A new instance of SitUp object with the same attributes as the original.
     */
    public SitUp clone(){
        return new SitUp(this);
    }

    /**
     * Returns a string representation of the SitUp object.
     * Overrides the toString method in the superclass.
     * @return A string representation of the SitUp object, including information from the superclass and indication of Sit Up type.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append("Sit Up\n");

        return sb.toString();
    }

    public boolean isHard() {
        return true;
    }

    public double calculateCaloriesConsume(User user) {
        return 0;
    }

}
