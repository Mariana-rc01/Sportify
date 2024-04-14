package com.group11.sportify.activities.SeriesReps;

import com.group11.sportify.activities.Activity;
import com.group11.sportify.users.User;

import java.util.Objects;

public abstract class SeriesReps extends Activity {
    private int repetitions;

    public SeriesReps() {
        super();
        this.repetitions = 0;
    }

    public SeriesReps(String name, boolean isHard, int time, int repetitions) {
        super(name, isHard,time);
        this.repetitions = repetitions;
    }

    public SeriesReps(Activity a, int repetitions) {
        super(a);
        this.repetitions = repetitions;
    }

    public SeriesReps(SeriesReps s){
        super(s);
        this.repetitions = s.getRepetitions();
    }

    public int getRepetitions() {
        return this.repetitions;
    }

    public void setRepetitions(int reps){
        this.repetitions = reps;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append("Series with repetitions: \n");
        sb.append("Number of repetitions= ");
        sb.append(repetitions).append("\n");

        return sb.toString();
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SeriesReps s = (SeriesReps) o;
        return getRepetitions() == s.getRepetitions();
    }

    public abstract double calculateCaloriesConsume(User user);
}
