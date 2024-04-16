package com.group11.sportify.activities.SeriesReps;

import com.group11.sportify.activities.Activity;
import com.group11.sportify.users.User;

/**
 * This class represents the Jumping Jack exercise as a series of repetitions.
 * It extends the SeriesReps class.
 */
public class JumpingJack extends SeriesReps {

    /**
     * Default constructor for the JumpingJack class.
     */
    public JumpingJack() {
        super();
    }

    /**
     * Constructor for the JumpingJack class.
     * @param name The name of the exercise.
     * @param isHard Indicates if the exercise is hard or not.
     * @param time The time spent performing the exercise in minutes.
     * @param repetitions The number of repetitions of the exercise.
     */
    public JumpingJack(String name, boolean isHard, int time, int repetitions) {
        super(name, isHard, time, repetitions);
    }

    /**
     * Constructor for the JumpingJack class.
     * @param a The activity to copy.
     * @param repetitions The number of repetitions of the exercise.
     */
    public JumpingJack(Activity a, int repetitions) {
        super(a, repetitions);
    }

    /**
     * Constructor for the JumpingJack class.
     * @param s The series of repetitions to copy.
     */
    public JumpingJack(SeriesReps s) {
        super(s);
    }

    /**
     * Clones the JumpingJack object.
     * @return A new instance of JumpingJack object with the same attributes as the original.
     */
    public JumpingJack clone(){
        return new JumpingJack(this);
    }

    /**
     * Returns a string representation of the JumpingJack object.
     * @return A string representation of the JumpingJack object, including information from the superclass and indication of Jumping Jack type.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append("Jumping Jack\n");

        return sb.toString();
    }

    public double calculateCaloriesConsume(User user) {
        return 0;
    }
}
