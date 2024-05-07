package com.group11.sportify.users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * This abstract class represents a user of the Sportify application.
 * Users can be of different types such as professionals, amateurs, or casual users.
 * Each user has a unique code, name, address, email, and average heart rate.
 */
public abstract class User implements Serializable {
    private int code;
    private String name;
    private String address;
    private String email;
    private int averageHeartRate;
    private double weight; // in kg
    private double height; // in cm
    private Set<Integer> activities;
    private Set<Integer> trainingPlans;

    // Falta registar os planos de treino

    /**
     * Default constructor.
     */
    public User(){
        this.code = 0;
        this.name = "";
        this.address = "";
        this.email = "";
        this.averageHeartRate = 0;
        this.weight = 0;
        this.height = 0;
        this.activities = new HashSet<>();
        this.trainingPlans = new HashSet<>();
    }

    /**
     * Constructor with parameters initializing attributes with provided values without activities.
     * @param code The unique code of the user.
     * @param name The name of the user.
     * @param address The address of the user.
     * @param email The email of the user.
     * @param averageHeartRate The average heart rate of the user.
     */
    public User(int code, String name, String address, String email, int averageHeartRate, double weight, double height) {
        this.code = code;
        this.name = name;
        this.address = address;
        this.email = email;
        this.averageHeartRate = averageHeartRate;
        this.weight = weight;
        this.height = height;
        this.activities = new HashSet<>();
        this.trainingPlans = new HashSet<>();
    }

    /**
     * Constructor with parameters initializing attributes with provided values.
     * @param code The unique code of the user.
     * @param name The name of the user.
     * @param address The address of the user.
     * @param email The email of the user.
     * @param averageHeartRate The average heart rate of the user.
     * @param activitiesIds The activities IDs of the user
     */
    public User(int code, String name, String address, String email, int averageHeartRate, double weight, double height, Set<Integer> activitiesIds) {
        this.code = code;
        this.name = name;
        this.address = address;
        this.email = email;
        this.averageHeartRate = averageHeartRate;
        this.weight = weight;
        this.height = height;
        this.activities = new HashSet<>(activitiesIds);
        this.trainingPlans = new HashSet<>();
    }

    /**
     * Constructor with parameters initializing attributes with provided values.
     * @param code The unique code of the user.
     * @param name The name of the user.
     * @param address The address of the user.
     * @param email The email of the user.
     * @param averageHeartRate The average heart rate of the user.
     * @param activityCodes The activity codes of the user
     * @param planCodes The training plans codes of the user
     */
    public User(int code, String name, String address, String email, int averageHeartRate, double weight, double height, Set<Integer> activityCodes, Set<Integer> planCodes) {
        this.code = code;
        this.name = name;
        this.address = address;
        this.email = email;
        this.averageHeartRate = averageHeartRate;
        this.weight = weight;
        this.height = height;
        this.activities = new HashSet<>(activityCodes);
        this.trainingPlans = new HashSet<>(planCodes);
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
        this.weight = u.getWeight();
        this.height = u.getHeight();
        this.activities = new HashSet<>(u.getActivities());
        this.trainingPlans = new HashSet<>(u.getTrainingPlans());
    }

    public abstract User clone();

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
     * Get weight of the user.
     * @return Weight of the user.
     */
    public double getWeight() {
        return this.weight;
    }

    /**
     * Set weight of the user.
     * @param weight The weight to set.
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Get height of the user.
     * @return Height of the user.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Set height of the user.
     * @param height The height to set.
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Get activities of the user.
     * @return activities of the user.
     */
    public List<Integer> getActivities() {
        return new ArrayList<>(this.activities);
    }

    /**
     * Get training plans of the user.
     * @return training plans of the user.
     */
    public List<Integer> getTrainingPlans() {
        return new ArrayList<>(this.trainingPlans);
    }

    /**
     * Add activity to the user.
     * @param activityCode The activitiy to add.
     */
    public void addActivity(int activityCode) {
        this.activities.add(activityCode);
    }

    /**
     * Add training plan to the user.
     * @param trainingPlanCode The training plan to add.
     */
    public void addTrainingPlan(int trainingPlanCode) {
        this.trainingPlans.add(trainingPlanCode);
    }

    /**
     * Checks if this user is equal to another object.
     * Users are considered equal if they have the same code, name, address, email, and average heart rate.
     * @param o The object to compare with this user.
     * @return True if the objects are equal, false otherwise.
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return this.getCode() == user.getCode() && this.getAverageHeartRate() == user.getAverageHeartRate() &&
                Double.compare(this.getWeight(), user.getWeight()) == 0 && Double.compare(this.getHeight(), user.getHeight()) == 0
                && Objects.equals(this.getName(), user.getName()) && Objects.equals(this.getAddress(), user.getAddress()) &&
                Objects.equals(this.getEmail(), user.getEmail()) && Objects.equals(this.getActivities(), user.getActivities()) && Objects.equals(this.getTrainingPlans(), user.getTrainingPlans());
    }

    /**
     * Converts this user to a string representation.
     * @return The string representation of this user, including code, name, address, email, and average heart rate.
     */
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("User: \n");
        sb.append("Code= ");
        sb.append(code).append("\n");
        sb.append("Name= ");
        sb.append(name).append("\n");
        sb.append("Address= ");
        sb.append(address).append("\n");
        sb.append("Email= ");
        sb.append(email).append("\n");
        sb.append("Average Heart Rate= ");
        sb.append(averageHeartRate).append("\n");
        sb.append("Weight= ");
        sb.append(weight).append("\n");
        sb.append("Height= ");
        sb.append(height).append("\n");

        return sb.toString();
    }

    /**
     * Calculates the Body Mass Index (BMI) of the user.
     * @return The calculated BMI.
     */
    public double calculateBMI(){
        return this.getWeight() / (this.getHeight() * this.getHeight() * 1e-4);
    }

    /**
     * Abstract method to calculate the calories factor for the user.
     * Subclasses must implement this method to provide specific calculation based on user type and on his bmi.
     * @return The calculated calories factor.
     */
    public abstract double calculateCaloriesFactor();
}
