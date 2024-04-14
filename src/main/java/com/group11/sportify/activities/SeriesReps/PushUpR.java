package com.group11.sportify.activities.SeriesReps;

import com.group11.sportify.activities.Activity;
import com.group11.sportify.users.User;

/**
 * This class represents the Push-up exercise as a series of repetitions.
 * It extends the SeriesReps class.
 */
public class PushUpR extends SeriesReps {

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

    public PushUpR(Activity a, int repetitions) {
        super(a, repetitions);
    }

    public PushUpR(SeriesReps s) {
        super(s);
    }


    public double calculateCaloriesConsume(User user) {
        return 0;
    }
}
