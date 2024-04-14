package com.group11.sportify.activities.SeriesReps;

import com.group11.sportify.users.User;

/**
 * This class represents the Sit-up exercise as a series of repetitions.
 * It extends the SeriesReps class.
 */
public class SitUpR extends SeriesReps {

    /**
     * Constructor for the SitUpR class.
     * @param name The name of the exercise.
     * @param time The time spent performing the exercise in minutes.
     * @param repetitions The number of repetitions of the exercise.
     */
    public SitUpR(String name, int time, int repetitions) {
        super(name, true, time, repetitions);
    }


    public double calculateCaloriesConsume(User user) {
        return 0;
    }

}
