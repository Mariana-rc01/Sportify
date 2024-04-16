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
     */
    public Casual(int code, String name, String address, String email, int averageHeartRate) {
        super(code, name, address, email, averageHeartRate);
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

    // Pensar nisto
    public double calculateCaloriesFactor() {
        return 0;
    }
}
