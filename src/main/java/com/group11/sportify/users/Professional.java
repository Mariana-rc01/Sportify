package com.group11.sportify.users;

import com.group11.sportify.activities.SeriesReps.StretcheR;

/**
 * This class represents a professional user.
 * Professional users are characterized by their high level of fitness and expertise in sports.
 */
public class Professional extends User{

    /**
     * Default constructor for the Professional class.
     */
    public Professional() {
        super();
    }

    /**
     * Constructor for the Professional class.
     * @param code The code of the user.
     * @param name The name of the user.
     * @param address The address of the user.
     * @param email The email of the user.
     * @param averageHeartRate The average heart rate of the user.
     */
    public Professional(int code, String name, String address, String email, int averageHeartRate) {
        super(code, name, address, email, averageHeartRate);
    }

    /**
     * Constructor for the Professional class.
     * @param u The user to copy.
     */
    public Professional(User u) {
        super(u);
    }

    /**
     * Clones the Professional object.
     * @return A new instance of Professional object with the same attributes as the original.
     */
    public Professional clone(){
        return new Professional(this);
    }

    /**
     * Returns a string representation of the Professional object.
     * @return A string representation of the Professional object, including information from the superclass and indication of Professional type.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append("Professional\n");

        return sb.toString();
    }

    // Pensar nisto
    public double calculateCaloriesFactor() {
        return 0;
    }
}
