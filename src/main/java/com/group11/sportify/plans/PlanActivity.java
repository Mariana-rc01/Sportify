package com.group11.sportify.plans;

import com.group11.sportify.activities.Activity;

public class PlanActivity {
    private int iterations;
    private Activity activity;

    /**
     * Default constructor for the PlanActivity class.
     */
    public PlanActivity(){
        this.iterations = 0;
        this.activity = null;
    }

    /**
     * Constructor for the PlanActivity class.
     * @param iterations The number of iterations of the activity.
     * @param activity The activity to perform.
     */
    public PlanActivity(int iterations, Activity activity){
        this.iterations = iterations;
        this.activity = activity.clone();
    }

    /**
     * Constructor for the PlanActivity class.
     * @param pa The PlanActivity to copy.
     */
    public PlanActivity(PlanActivity pa){
        this.iterations = pa.iterations;
        this.activity = pa.activity.clone();
    }

    /**
     * Getter for the iterations attribute.
     * @return The number of iterations of the activity.
     */
    public int getIterations(){
        return this.iterations;
    }

    /**
     * Getter for the activity attribute.
     * @return The activity to perform.
     */
    public Activity getActivity(){
        return this.activity.clone();
    }

    /**
     * Setter for the iterations attribute.
     * @param iterations The number of iterations of the activity.
     */
    public void setIterations(int iterations){
        this.iterations = iterations;
    }

    /**
     * Setter for the activity attribute.
     * @param activity The activity to perform.
     */
    public void setActivity(Activity activity){
        this.activity = activity.clone();
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
        sb.append(this.activity.toString()).append("x").append(this.iterations).append(" times\n");
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
        return this.iterations == pa.iterations && this.activity.equals(pa.activity);
    }
}
