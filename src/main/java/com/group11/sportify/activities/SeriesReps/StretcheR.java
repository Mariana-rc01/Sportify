package com.group11.sportify.activities.SeriesReps;

import com.group11.sportify.users.User;

/**
 * This class represents the Stretch exercise as a series of repetitions.
 * It extends the SeriesReps class.
 */
public class StretcheR extends SeriesReps {

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

    public double calculateCaloriesConsume(User user) {
        return 0;
    }
}
