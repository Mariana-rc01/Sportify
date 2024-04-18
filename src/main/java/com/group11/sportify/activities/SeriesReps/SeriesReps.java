package com.group11.sportify.activities.SeriesReps;

import com.group11.sportify.activities.Activity;
import com.group11.sportify.users.User;

import java.util.Objects;

/**
 * This abstract class represents an exercise as a series of repetitions.
 * It extends the Activity class.
 */
public abstract class SeriesReps extends Activity {
    private int repetitions;

    /**
     * Default constructor for the SeriesReps class.
     */
    public SeriesReps() {
        super();
        this.repetitions = 0;
    }

    /**
     * Constructor for the SeriesReps class.
     * @param name The name of the exercise.
     * @param time The time spent performing the exercise in minutes.
     * @param repetitions The number of repetitions of the exercise.
     */
    public SeriesReps(String name, int time, int repetitions) {
        super(name, time);
        this.repetitions = repetitions;
    }

    /**
     * Constructor for the SeriesReps class.
     * @param a The activity to copy.
     * @param repetitions The number of repetitions of the exercise.
     */
    public SeriesReps(Activity a, int repetitions) {
        super(a);
        this.repetitions = repetitions;
    }

    /**
     * Constructor for the SeriesReps class.
     * @param s The series of repetitions to copy.
     */
    public SeriesReps(SeriesReps s){
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
     * Returns a string representation of the SeriesReps object.
     * @return A string representation of the SeriesReps object, including information from the superclass and the number of repetitions.
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
     * Compares the SeriesReps object with another object.
     * @param o The object to compare with.
     * @return True if the objects are equal, false otherwise.
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SeriesReps s = (SeriesReps) o;
        return getRepetitions() == s.getRepetitions();
    }

    public abstract double calculateCaloriesConsume(User user);
}
