package com.group11.sportify.activities;

public abstract class SeriesReps extends Activity{
    private int repetitions;

    public SeriesReps(String name, boolean isHard, int time, int repetitions) {
        super(name, isHard,time);
        this.repetitions = repetitions;
    }

    public int getRepetitions() {
        return this.repetitions;
    }

    public void setRepetitions(int reps){
        this.repetitions = reps;
    }

    // String user vai passar para User user ou algo assim
    public abstract double calculateCaloriesConsume(String user);
}
