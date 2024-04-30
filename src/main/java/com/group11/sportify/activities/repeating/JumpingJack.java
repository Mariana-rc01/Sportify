package com.group11.sportify.activities.repeating;

import com.group11.sportify.activities.Activity;
import com.group11.sportify.users.User;

import java.time.LocalDate;

/**
 * This class represents the Jumping Jack exercise as a series of repetitions.
 * It extends the SeriesReps class.
 */
public class JumpingJack extends ActivityRepetitions {

    /**
     * Default constructor for the JumpingJack class.
     */
    public JumpingJack() {
        super();
    }

    /**
     * Constructor for the SeriesReps class.
     * @param code The code of the exercise.
     * @param description The description of the exercise.
     * @param time The time spent performing the exercise in minutes.
     * @param averageHeartRate The average heart rate during the activity.
     * @param date The date of the activity.
     * @param repetitions The number of repetitions of the exercise.
     * @param userCode the code of the user associated with this activity.
     */
    public JumpingJack(int code, String description, int time, int averageHeartRate, LocalDate date, int repetitions, int userCode) {
        super(code, description, time, averageHeartRate, date, repetitions, userCode);
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
    public JumpingJack(ActivityRepetitions s) {
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

    /**
     * Calculates the total calories burned during jumping jacks based on the user's characteristics.
     *
     * @param user The user performing the jumping jacks.
     * @return The total calories burned during jumping jacks.
     */
    public double calculateCaloriesConsume(User user) {
        double caloriesPerJumping = 0.19;
        int reps = this.getRepetitions();
        double userFactor = user.calculateCaloriesFactor();
        int heartRate;
        if (reps < 25) heartRate = user.getAverageHeartRate() + (int) (1/userFactor)*15;
        else heartRate = user.getAverageHeartRate() + (int) (1/userFactor)*25;
        this.setAverageHeartRateDuringActivity(heartRate);
        return caloriesPerJumping * this.getRepetitions() * userFactor;
    }
}
