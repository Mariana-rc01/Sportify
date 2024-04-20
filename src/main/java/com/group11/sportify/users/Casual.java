package com.group11.sportify.users;

/**
 * This class represents a casual user.
 * Casual users are characterized by their occasional participation in sports activities.
 */
public class Casual extends User {

    /**
     * Default constructor for the Casual class.
     */
    public Casual() {
        super();
    }

    /**
     * Constructor for the Casual class.
     * @param code The code of the user.
     * @param name The name of the user.
     * @param address The address of the user.
     * @param email The email of the user.
     * @param averageHeartRate The average heart rate of the user.
     * @param weight The weight of the user.
     * @param height The height of the user.
     */
    public Casual(int code, String name, String address, String email, int averageHeartRate, double weight, double height) {
        super(code, name, address, email, averageHeartRate,weight, height);
    }

    /**
     * Constructor for the Casual class.
     * @param u The user to copy.
     */
    public Casual(User u) {
        super(u);
    }

    /**
     * Clones the Casual object.
     * @return A new instance of Casual object with the same attributes as the original.
     */
    public Casual clone(){
        return new Casual(this);
    }

    /**
     * Returns a string representation of the Casual object.
     * @return A string representation of the Casual object, including information from the superclass and indication of Casual type.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append("Casual\n");

        return sb.toString();
    }

    /**
     * Calculates the calories factor based on the user's BMI.
     * If the BMI is higher than 24.9, it returns a factor of 1.0, otherwise, it returns 0.8.
     * @return The calories factor based on BMI.
     */
    public double calculateCaloriesFactor() {
        double bmi = this.calculateBMI();
        double factor = 0;
        if (bmi > 24.9) {
            factor = 1.0;
        }
        else factor = 0.8;
        return factor;
    }
}
