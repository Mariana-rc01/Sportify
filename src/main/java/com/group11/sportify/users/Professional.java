package com.group11.sportify.users;

import java.util.Set;

/**
 * This class represents a professional user.
 * Professional users are characterized by their high level of fitness and expertise in sports.
 */
public class Professional extends User {

    /**
     * Default constructor for the Professional class.
     */
    public Professional() {
        super();
    }

    /**
     * Constructor for the Professional class without activities.
     * @param code The code of the user.
     * @param name The name of the user.
     * @param address The address of the user.
     * @param email The email of the user.
     * @param averageHeartRate The average heart rate of the user.
     * @param weight The weight of the user.
     * @param height The height of the user.
     */
    public Professional(int code, String name, String address, String email, int averageHeartRate, double weight, double height) {
        super(code, name, address, email, averageHeartRate,weight,height);
    }

    /**
     * Constructor for the Professional class.
     * @param code The code of the user.
     * @param name The name of the user.
     * @param address The address of the user.
     * @param email The email of the user.
     * @param averageHeartRate The average heart rate of the user.
     * @param weight The weight of the user.
     * @param height The height of the user.
     * @param activities The activities of the user
     * @param plans The training plans of the user
     */
    public Professional(int code, String name, String address, String email, int averageHeartRate, double weight, double height, Set<Integer> activities, Set<Integer> plans) {
        super(code, name, address, email, averageHeartRate, weight, height, activities, plans);
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

    /**
     * Calculates the calories factor based on the user's BMI.
     * If the BMI is higher than 24.9, it returns a factor of 1.7, otherwise, it returns 1.4.
     * @return The calories factor based on BMI.
     */
    public double calculateCaloriesFactor() {
        double bmi = this.calculateBMI();
        double factor = 0;
        if (bmi > 24.9) {
            factor = 1.7;
        }
        else factor = 1.4;
        return factor;
    }
}
