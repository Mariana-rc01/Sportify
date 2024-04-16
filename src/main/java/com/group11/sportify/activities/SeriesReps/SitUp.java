package com.group11.sportify.activities.SeriesReps;

import com.group11.sportify.activities.Activity;
import com.group11.sportify.users.User;

/**
 * This class represents the Sit-up exercise as a series of repetitions.
 * It extends the SeriesReps class.
 */
public class SitUpR extends SeriesReps {

    /**
     * Default constructor for the SitUpR class.
     */
    public SitUpR() {
        super();
    }

    /**
     * Constructor for the SitUpR class.
     * @param name The name of the exercise.
     * @param isHard Indicates if the exercise is hard or not.
     * @param time The time spent performing the exercise in minutes.
     * @param repetitions The number of repetitions of the exercise.
     */
    public SitUpR(String name, boolean isHard, int time, int repetitions) {
        super(name, isHard, time, repetitions);
    }

    /**
     * Constructor for the SitUpR class.
     * @param a The activity to copy.
     * @param repetitions The number of repetitions of the exercise.
     */
    public SitUpR(Activity a, int repetitions) {
        super(a, repetitions);
    }

    /**
     * Constructor for the SitUpR class.
     * @param s The series of repetitions to copy.
     */
    public SitUpR(SeriesReps s) {
        super(s);
    }

    /**
     * Clones the SitUpR object.
     * @return A new instance of SitUpR object with the same attributes as the original.
     */
    public SitUpR clone(){
        return new SitUpR(this);
    }

    /**
     * Returns a string representation of the SitUpR object.
     * Overrides the toString method in the superclass.
     * @return A string representation of the SitUpR object, including information from the superclass and indication of Sit Up type.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append("Sit Up\n");

        return sb.toString();
    }


    public double calculateCaloriesConsume(User user) {
        return 0;
    }

}
