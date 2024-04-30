package com.group11.sportify.activities.repeating.weight;

import com.group11.sportify.activities.Activity;
import com.group11.sportify.activities.repeating.ActivityRepetitions;
import com.group11.sportify.users.User;

import java.time.LocalDateTime;

public abstract class ActivityRepetitionsWeight extends ActivityRepetitions {
    private double weight;

    /**
     * Default constructor for the ActivityRepetitionsWeight class.
     */
    public ActivityRepetitionsWeight() {
        super();
        this.weight = 0;
    }

    /**
     * Constructor for the ActivityRepetitionsWeight class.
     * @param code The code of the exercise.
     * @param description The description of the exercise.
     * @param time The time spent performing the exercise in minutes.
     * @param averageHeartRate The average heart rate during the activity.
     * @param date The date of the activity.
     * @param repetitions The number of repetitions of the activity.
     * @param weight The weight used during the activity.
     * @param userCode the code of the user associated with this activity.
     */
    public ActivityRepetitionsWeight(int code, String description, int time, int averageHeartRate, LocalDateTime date, int repetitions, double weight, int userCode) {
        super(code, description, time, averageHeartRate, date, repetitions, userCode);
        this.weight = weight;
    }

    /**
     * Constructor for the ActivityRepetitionsWeight class.
     * @param a The activity to copy.
     * @param weight The weight used during the activity.
     */
    public ActivityRepetitionsWeight(ActivityRepetitions a, double weight) {
        super(a);
        this.weight = weight;
    }

    /**
     * Constructor for the ActivityRepetitionsWeight class.
     * @param a The activity to copy.
     * @param repetitions The number of repetitions of the activity.
     * @param weight The weight used during the activity.
     */
    public ActivityRepetitionsWeight(Activity a, int repetitions, double weight) {
        super(a, repetitions);
        this.weight = weight;
    }

    /**
     * Constructor for the ActivityRepetitionsWeight class.
     * @param s The activity to copy.
     */
    public ActivityRepetitionsWeight(ActivityRepetitionsWeight s) {
        super(s);
        this.weight = s.getWeight();
    }

    /**
     * Gets the weight used during the activity.
     * @return The weight used during the activity.
     */
    public double getWeight() {
        return this.weight;
    }

    /**
     * Sets the weight used during the activity.
     * @param weight The weight used during the activity.
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Returns a string representation of the ActivityRepetitionsWeight object.
     * @return A string representation of the ActivityRepetitionsWeight object, including information from the superclass and the weight used.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append("Activity with weights: \n");
        sb.append("Weight = ");
        sb.append(weight).append("\n");

        return sb.toString();
    }

    public abstract double calculateCaloriesConsume(User user);
}
