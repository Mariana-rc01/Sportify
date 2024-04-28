package com.group11.sportify.activities.repeating;

import com.group11.sportify.activities.Activity;
import com.group11.sportify.users.User;

import java.time.LocalDate;

/**
 * This abstract class represents an exercise as a series of repetitions.
 * It extends the Activity class.
 */
public abstract class ActivityRepetitions extends Activity {
    private int repetitions;

    /**
     * Default constructor for the ActivityRepetitions class.
     */
    public ActivityRepetitions() {
        super();
        this.repetitions = 0;
    }

    /**
     * Constructor for the ActivityRepetitions class.
     * @param code The code of the exercise.
     * @param description The description of the exercise.
     * @param time The time spent performing the exercise in minutes.
     * @param averageHeartRate The average heart rate during the activity.
     * @param date The date of the activity.
     * @param repetitions The number of repetitions of the exercise.
     * @param user the user associated with this activity.
     */
    public ActivityRepetitions(int code, String description, int time, int averageHeartRate, LocalDate date, int repetitions, User user) {
        super(code, description, time, averageHeartRate,date, user);
        this.repetitions = repetitions;
    }

    /**
     * Constructor for the ActivityRepetitions class.
     * @param a The activity to copy.
     * @param repetitions The number of repetitions of the exercise.
     */
    public ActivityRepetitions(Activity a, int repetitions) {
        super(a);
        this.repetitions = repetitions;
    }

    /**
     * Constructor for the ActivityRepetitions class.
     * @param s The series of repetitions to copy.
     */
    public ActivityRepetitions(ActivityRepetitions s){
        super(s);
        this.repetitions = s.getRepetitions();
    }

    /**
     * Gets the number of repetitions of the exercise.
     * @return The number of repetitions of the exercise.
     */
    public int getRepetitions() {
        return this.repetitions;
    }

    /**
     * Sets the number of repetitions of the exercise.
     * @param reps The number of repetitions of the exercise.
     */
    public void setRepetitions(int reps) {
        this.repetitions = reps;
    }

    /**
     * Returns a string representation of the ActivityRepetitions object.
     * @return A string representation of the ActivityRepetitions object, including information from the superclass and the number of repetitions.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append("Series with repetitions: \n");
        sb.append("Number of repetitions= ");
        sb.append(repetitions).append("\n");

        return sb.toString();
    }

    /**
     * Compares the ActivityRepetitions object with another object.
     * @param o The object to compare with.
     * @return True if the objects are equal, false otherwise.
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ActivityRepetitions that)) return false;
        if (!super.equals(o)) return false;
        return getRepetitions() == that.getRepetitions();
    }

    public abstract double calculateCaloriesConsume(User user);
}
