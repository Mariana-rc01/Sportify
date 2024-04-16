package com.group11.sportify.users;

/**
 * This class represents an amateur user.
 * Amateur users are characterized by their intermediate level of fitness and participation in sports activities.
 */
public class Amateur extends User {

    /**
     * Default constructor for the Amateur class.
     */
    public Amateur() {
        super();
    }

    /**
     * Constructor for the Amateur class.
     * @param code The code of the user.
     * @param name The name of the user.
     * @param address The address of the user.
     * @param email The email of the user.
     * @param averageHeartRate The average heart rate of the user.
     */
    public Amateur(int code, String name, String address, String email, int averageHeartRate) {
        super(code, name, address, email, averageHeartRate);
    }

    /**
     * Constructor for the Amateur class.
     * @param u The user to copy.
     */
    public Amateur(User u) {
        super(u);
    }

    /**
     * Clones the Amateur object.
     * @return A new instance of Amateur object with the same attributes as the original.
     */
    public Amateur clone(){
        return new Amateur(this);
    }

    /**
     * Returns a string representation of the Amateur object.
     * @return A string representation of the Amateur object, including information from the superclass and indication of Amateur type.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append("Amateur\n");

        return sb.toString();
    }

    // Pensar nisto
    public double calculateCaloriesFactor() {
        return 0;
    }
}
