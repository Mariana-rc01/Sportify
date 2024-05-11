package com.group11.sportify.plans;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TrainingPlan implements Serializable {
    private LocalDateTime startDate;
    private Set<Integer> activities;
    private int userCode;

    /**
     * Default constructor for the TrainingPlan class.
     */
    public TrainingPlan(){
        this.startDate = LocalDateTime.now();
        this.activities = new HashSet<>();
    }

    /**
     * Constructor for the TrainingPlan class.
     * @param startDate The start date of the training plan.
     * @param userCode The user code of the training plan.
     */
    public TrainingPlan(LocalDateTime startDate, int userCode){
        this.startDate = startDate;
        this.activities = new HashSet<>();
        this.userCode = userCode;
    }

    /**
     * Constructor for the TrainingPlan class.
     * @param tp The training plan to copy.
     */
    public TrainingPlan(TrainingPlan tp){
        this.startDate = tp.startDate;
        this.activities = new HashSet<>(tp.getPlanActivities());
        this.userCode = tp.userCode;
    }

    /**
     * Getter for the startDate attribute.
     * @return The start date of the training plan.
     */
    public LocalDateTime getStartDate(){
        return this.startDate;
    }

    /**
     * Getter for the plan attribute.
     * @return The plan of the training plan.
     */
    public List<Integer> getPlanActivities(){
        return new ArrayList<>(this.activities);
    }

    /**
     * Getter for the userCode attribute.
     * @return The user code of the training plan.
     */
    public int getUserCode(){
        return this.userCode;
    }

    /**
     * Setter for the startDate attribute.
     * @param startDate The start date of the training plan.
     */
    public void setStartDate(LocalDateTime startDate){
        this.startDate = startDate;
    }

    /**
     * Setter for the plan attribute.
     * @param plan The plan of the training plan.
     */
    public void setPlanActivities(HashSet<Integer> plan){
        this.activities = new HashSet<>(plan);
    }

    /**
     * Add a plan activity to the training plan.
     * @param planActivity The plan activity to add.
     */
    public void addPlanActivity(int activity){
        this.activities.add(activity);
    }

    /**
     * Remove a plan activity from the training plan.
     * @param index The index of the plan activity to remove.
     */
    public void removePlanActivity(int index){
        this.activities.remove(index);
    }

    /**
     * Clone the training plan.
     * @return A new training plan with the same attributes.
     */
    public TrainingPlan clone(){
        return new TrainingPlan(this);
    }

    /**
     * Returns a string representation of the TrainingPlan object.
     * @return A string representation of the TrainingPlan object.
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Training Plan\n");
        sb.append("Start Date: ").append(this.startDate).append("\n");
        return sb.toString();
    }

    /**
     * Compare the Training plan with another object.
     * @param o The object to compare with.
     * @return True if the objects are equal, false otherwise.
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TrainingPlan plan)) return false;
        return getStartDate().equals(plan.getStartDate()) && getPlanActivities().equals(plan.getPlanActivities()) 
        && getUserCode() == plan.getUserCode();
    }
}
