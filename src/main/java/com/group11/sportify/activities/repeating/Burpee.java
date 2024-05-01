package com.group11.sportify.activities.repeating;

import com.group11.sportify.activities.Activity;
import com.group11.sportify.activities.Hard;
import com.group11.sportify.users.User;

import java.time.LocalDateTime;

/**
 * This class represents the Burpee exercise as a series of repetitions.
 * It extends the SeriesReps class.
 */
public class Burpee extends ActivityRepetitions implements Hard{

    /**
     * Default constructor for the Burpee class.
     */
    public Burpee(){
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
     * @param userCode the code of user associated with this activity.
     */
    public Burpee(int code, String description, int time, int averageHeartRate, LocalDateTime date, int repetitions, int userCode) {
        super(code, description, time, averageHeartRate, date, repetitions, userCode);
    }

    /**
     * Constructor for the Burpee class.
     * @param a The activity to copy.
     * @param repetitions The number of repetitions of the exercise.
     */
    public Burpee(Activity a, int repetitions) {
        super(a, repetitions);
    }

    /**
     * Constructor for the Burpee class.
     * @param s The series of repetitions to copy.
     */
    public Burpee(ActivityRepetitions s) {
        super(s);
    }

    /**
     * Clones the Burpee object.
     * @return A new instance of Burpee object with the same attributes as the original.
     */
    public Burpee clone(){
        return new Burpee(this);
    }

    /**
     * Returns a string representation of the Burpee object.
     * @return A string representation of the Burpee object.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.insert(0, "Burpee\n");

        return sb.toString();
    }

    /**
     * Checks if the Burpee exercise is hard.
     * @return Always returns true, as Burpee is considered a hard activity.
     */
    public boolean isHard() {
        return true;
    }

    /**
     * Calculates the total calories burned during burpees based on the user's characteristics.
     *
     * @param user The user performing the burpees.
     * @return The total calories burned during burpees.
     */
    public double calculateCaloriesConsume(User user) {
        int reps = this.getRepetitions();
        double caloriesPerBurpee = 1.75;
        double userFactor = user.calculateCaloriesFactor();
        int heartRate;
        if (reps < 10) heartRate = user.getAverageHeartRate() + (int) (1/userFactor)*20;
        else heartRate = user.getAverageHeartRate() + (int) (1/userFactor)*35;
        this.setAverageHeartRateDuringActivity(heartRate);
        return caloriesPerBurpee * reps * userFactor;
    }

}
