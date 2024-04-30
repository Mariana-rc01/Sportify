package com.group11.sportify.plans.exceptions;

public class TrainingPlanDoesntExistException extends Exception{
    public TrainingPlanDoesntExistException() {
        super();
    }

    public TrainingPlanDoesntExistException(String msg) {
        super(msg);
    }
}
