package com.group11.sportify.activities.SeriesReps;

import com.group11.sportify.activities.Activity;
import com.group11.sportify.activities.Hard;
import com.group11.sportify.users.User;

import java.time.LocalDate;

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
     * Constructor for the SeriesReps class.
     * @param code The code of the exercise.
     * @param description The description of the exercise.
     * @param time The time spent performing the exercise in minutes.
     * @param averageHeartRate The average heart rate during the activity.
     * @param date The date of the activity.
     * @param repetitions The number of repetitions of the exercise.
     * @param user the user associated with this activity.
     */
    public PushUp(int code, String description, int time, int averageHeartRate, LocalDate date, int repetitions, User user) {
        super(code, description, time, averageHeartRate, date, repetitions, user);
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

    /**
     * Calculates the total calories burned during push-ups based on the user's characteristics.
     *
     * @param user The user performing the push-ups.
     * @return The total calories burned during push-ups.
     */
    public double calculateCaloriesConsume(User user) {
        double caloriesPerPushUp = 1;
        int reps = this.getRepetitions();
        double userFactor = user.calculateCaloriesFactor();
        int heartRate;
        if (reps < 12) heartRate = user.getAverageHeartRate() + (int) (1/userFactor)*15;
        else heartRate = user.getAverageHeartRate() + (int) (1/userFactor)*35;
        this.setAverageHeartRateDuringActivity(heartRate);
        return caloriesPerPushUp * this.getRepetitions() * userFactor;
    }
}
