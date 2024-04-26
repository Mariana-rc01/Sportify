package com.group11.sportify.activities.SeriesReps;

import com.group11.sportify.activities.Activity;
import com.group11.sportify.activities.Hard;
import com.group11.sportify.users.User;

import java.time.LocalDate;

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
     * Constructor for the SeriesReps class.
     * @param code The code of the exercise.
     * @param description The description of the exercise.
     * @param time The time spent performing the exercise in minutes.
     * @param averageHeartRate The average heart rate during the activity.
     * @param date The date of the activity.
     * @param repetitions The number of repetitions of the exercise.
     */
    public SitUp(int code, String description, int time, int averageHeartRate, LocalDate date, int repetitions) {
        super(code, description, time, averageHeartRate, date, repetitions);
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

    /**
     * Checks if the Sit Up exercise is hard.
     * @return Always returns true, as Sit Up is considered a hard activity.
     */
    public boolean isHard() {
        return true;
    }

    /**
     * Calculates the total calories burned during sit-ups based on the user's characteristics.
     *
     * @param user The user performing the sit-ups.
     * @return The total calories burned during sit-ups.
     */
    public double calculateCaloriesConsume(User user) {
        double caloriesPerSitUp = 0.25;
        int reps = this.getRepetitions();
        double userFactor = user.calculateCaloriesFactor();
        int heartRate;
        if (reps < 15) heartRate = user.getAverageHeartRate() + (int) (1/userFactor)*10;
        else heartRate = user.getAverageHeartRate() + (int) (1/userFactor)*20;
        this.setAverageHeartRateDuringActivity(heartRate);
        return caloriesPerSitUp * reps * userFactor;
    }

}
