package com.group11.sportify.plans;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrainingPlan {
    private LocalDateTime startDate;
    private Map<Integer, PlanActivity> plan;

    /**
     * Default constructor for the TrainingPlan class.
     */
    public TrainingPlan(){
        this.startDate = LocalDateTime.now();
        this.plan = new HashMap<>();
    }

    /**
     * Constructor for the TrainingPlan class.
     * @param startDate The start date of the training plan.
     */
    public TrainingPlan(LocalDateTime startDate){
        this.startDate = startDate;
        this.plan = new HashMap<>();
    }

    /**
     * Constructor for the TrainingPlan class.
     * @param tp The training plan to copy.
     */
    public TrainingPlan(TrainingPlan tp){
        this.startDate = tp.startDate;
        this.plan = new HashMap<>();
        for (Map.Entry<Integer, PlanActivity> entry : tp.plan.entrySet()) {
            this.plan.put(entry.getKey(), entry.getValue().clone());
        }
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
    public List<PlanActivity> getPlanActivities(){
        return this.plan.values().stream().map(PlanActivity::clone).toList();
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
    public void setPlanActivities(Map<Integer, PlanActivity> plan){
        this.plan = new HashMap<>();
        for (Map.Entry<Integer, PlanActivity> entry : plan.entrySet()) {
            this.plan.put(entry.getKey(), entry.getValue().clone());
        }
    }

    /**
     * Add a plan activity to the training plan.
     * @param planActivity The plan activity to add.
     */
    public void addPlanActivity(PlanActivity planActivity){
        this.plan.put(this.plan.size(), planActivity.clone());
    }

    /**
     * Remove a plan activity from the training plan.
     * @param index The index of the plan activity to remove.
     */
    public void removePlanActivity(int index){
        this.plan.remove(index);
    }

    /**
     * Clone the training plan.
     * @return A new training plan with the same attributes.
     */
    public TrainingPlan clone(){
        return new TrainingPlan(this);
    }

    /**
     * Get the total time spent on the training plan.
     * @return The total time spent on the training plan.
     */
    public int getTotalTimeSpentMinutes(){
        return this.plan.values().stream().mapToInt(pa -> pa.getActivity().getTimeSpentMinutes() * pa.getIterations()).sum();
    }

    /**
     * Returns a string representation of the TrainingPlan object.
     * @return A string representation of the TrainingPlan object.
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Training Plan\n");
        sb.append("Start Date: ").append(this.startDate).append("\n");
        for (Map.Entry<Integer, PlanActivity> entry : this.plan.entrySet()) {
            sb.append(entry.getValue().toString());
        }
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
        return getStartDate().equals(plan.getStartDate()) && getPlanActivities().equals(plan.getPlanActivities());
    }
}
