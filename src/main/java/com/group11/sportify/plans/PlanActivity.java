package com.group11.sportify.plans;

import java.io.Serializable;

public class PlanActivity implements Serializable {
    private int iterations;
    private int activityCode;

    /**
     * Constructor for the PlanActivity class.
     * @param iterations The number of iterations of the activity.
     * @param activityCode The code of the activity to perform.
     */
    public PlanActivity(int iterations, int activityCode){
        this.iterations = iterations;
        this.activityCode = activityCode;
    }

    /**
     * Constructor for the PlanActivity class.
     * @param pa The PlanActivity to copy.
     */
    public PlanActivity(PlanActivity pa){
        this.iterations = pa.iterations;
        this.activityCode = pa.activityCode;
    }

    /**
     * Getter for the iterations attribute.
     * @return The number of iterations of the activity.
     */
    public int getIterations(){
        return this.iterations;
    }

    /**
     * Getter for the activity code attribute.
     * @return The code of the activity to perform.
     */
    public int getActivityCode(){
        return this.activityCode;
    }

    /**
     * Setter for the iterations attribute.
     * @param iterations The number of iterations of the activity.
     */
    public void setIterations(int iterations){
        this.iterations = iterations;
    }

    /**
     * Clones the PlanActivity object.
     * @return A new instance of PlanActivity object with the same attributes as the original.
     */
    public PlanActivity clone(){
        return new PlanActivity(this);
    }

    /**
     * Returns a string representation of the PlanActivity object.
     * @return A string representation of the PlanActivity object.
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Activity ").append(this.activityCode).append(" x").append(this.iterations).append(" times\n");
        return sb.toString();
    }

    /**
     * Compares the PlanActivity object with another object.
     * @param o The object to compare with.
     * @return True if the objects are equal, false otherwise.
     */
    public boolean equals(Object o){
        if (o == this) return true;
        if (o == null) return false;
        if (o.getClass() != this.getClass()) return false;
        PlanActivity pa = (PlanActivity) o;
        return this.iterations == pa.iterations && this.activityCode == pa.activityCode;
    }
}
