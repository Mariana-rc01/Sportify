package com.group11.sportify.plans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.group11.sportify.plans.exceptions.TrainingPlanDoesntExistException;

/**
 * Controller class for training plans.
 */
public class TrainingPlanController implements Serializable {

    /**
     * Map to store activities with their unique codes as keys.
     */
    private Map<Integer, TrainingPlan> trainingPlans;

    /**
     * Constructor for TrainingPlanController class.
     * Initializes the training plans map.
     */
    public TrainingPlanController() {
        this.trainingPlans = new HashMap<>();
    }

    /**
     * Retrieves a list of all training plans.
     *
     * @return A list containing all training plans.
     */
    public List<TrainingPlan> getAllTrainingPlans() {
        return this.trainingPlans.values().stream().map(TrainingPlan::clone).toList();
    }

    public int getNumberTrainingPlans(){
        return this.trainingPlans.size();
    }

    public void addTrainingPlan(int code, TrainingPlan tp){
        this.trainingPlans.put(code, tp);
    }

    /**
     * Retrieves a training plan by its unique code.
     *
     * @param code The unique code of the plan to retrieve.
     * @return The training plan corresponding to the given code.
     * @throws TrainingPlanDoesntExistException If no activity with the given code
     *                                          exists.
     */
    public TrainingPlan getTrainingPlan(int code) throws TrainingPlanDoesntExistException {
        if (this.trainingPlans.containsKey(code)) {
            return this.trainingPlans.get(code).clone();
        }
        throw new TrainingPlanDoesntExistException();
    }

    /**
     * Clears all training plans data from the TrainingPlanController.
     */
    public void clearTrainingPlans() {
        trainingPlans.clear();
    }
}
