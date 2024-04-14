package com.group11.sportify.users;

/**
 * This abstract class represents a user of the Sportify application.
 * Users can be of different types such as professionals, amateurs, or casual users.
 * Each user has a unique code, name, address, email, and average heart rate.
 */
public abstract class User {
    private int code;
    private String name;
    private String address;
    private String email;
    private int averageHeartRate;

    // Falta registar as atividades que efetuou

    /**
     * Default constructor.
     */
    public User(){
        this.code = 0;
        this.name = "";
        this.address = "";
        this.email = "";
        this.averageHeartRate = 0;
    }

    /**
     * Constructor with parameters initializing attributes with provided values.
     * @param code The unique code of the user.
     * @param name The name of the user.
     * @param address The address of the user.
     * @param email The email of the user.
     * @param averageHeartRate The average heart rate of the user.
     */
    public User(int code, String name, String address, String email, int averageHeartRate) {
        this.code = code;
        this.name = name;
        this.address = address;
        this.email = email;
        this.averageHeartRate = averageHeartRate;
    }

    /**
     * Copy constructor creating a new User object with the same attributes as the provided user.
     * @param u The user to copy.
     */
    public User(User u){
        this.code = u.getCode();
        this.name = u.getName();
        this.address = u.getAddress();
        this.email = u.getEmail();
        this.averageHeartRate = u.getAverageHeartRate();
    }

    /**
     * Get the unique code of the user.
     * @return The code of the user.
     */
    public int getCode() {
        return this.code;
    }

    /**
     * Set the unique code of the user.
     * @param code The code to set.
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Get the name of the user.
     * @return The name of the user.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set the name of the user.
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the address of the user.
     * @return The address of the user.
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Set the address of the user.
     * @param address The address to set.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Get the email of the user.
     * @return The email of the user.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Set the email of the user.
     * @param email The email to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the average heart rate of the user.
     * @return The average heart rate of the user.
     */
    public int getAverageHeartRate() {
        return this.averageHeartRate;
    }

    /**
     * Set the average heart rate of the user.
     * @param averageHeartRate The average heart rate to set.
     */
    public void setAverageHeartRate(int averageHeartRate) {
        this.averageHeartRate = averageHeartRate;
    }

    /**
     * Abstract method to calculate the calories factor for the user.
     * Subclasses must implement this method to provide specific calculation based on user type.
     * @return The calculated calories factor.
     */
    public abstract double calculateCaloriesFactor();
}
