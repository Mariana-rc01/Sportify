package com.group11.sportify.users;

import com.group11.sportify.activities.Activity;
import com.group11.sportify.plans.TrainingPlan;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

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
    private double weight; // in kg
    private double height; // in cm
    private Map<Integer, Activity> activities;
    private Map<Integer, TrainingPlan> trainingPlans;

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
        this.activities = new HashMap<>();
        this.trainingPlans = new HashMap<>();
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
        this.activities = new HashMap<>();
        this.trainingPlans = new HashMap<>();
    }

    /**
     * Constructor with parameters initializing attributes with provided values.
     * @param code The unique code of the user.
     * @param name The name of the user.
     * @param address The address of the user.
     * @param email The email of the user.
     * @param averageHeartRate The average heart rate of the user.
     * @param activities The activities of the user
     */
    public User(int code, String name, String address, String email, int averageHeartRate, double weight, double height, Map<Integer,Activity> activities) {
        this.code = code;
        this.name = name;
        this.address = address;
        this.email = email;
        this.averageHeartRate = averageHeartRate;
        this.weight = weight;
        this.height = height;
        this.activities = activities.values().stream().collect(Collectors.toMap(Activity::getCode, Activity::clone));
    }

    /**
     * Constructor with parameters initializing attributes with provided values.
     * @param code The unique code of the user.
     * @param name The name of the user.
     * @param address The address of the user.
     * @param email The email of the user.
     * @param averageHeartRate The average heart rate of the user.
     * @param activities The activities of the user
     * @param plans The training plans of the user
     */
    public User(int code, String name, String address, String email, int averageHeartRate, double weight, double height, Map<Integer,Activity> activities, Map<Integer,TrainingPlan> trainingPlans) {
        this.code = code;
        this.name = name;
        this.address = address;
        this.email = email;
        this.averageHeartRate = averageHeartRate;
        this.weight = weight;
        this.height = height;
        this.activities = activities.values().stream().collect(Collectors.toMap(Activity::getCode, Activity::clone));
        this.trainingPlans = trainingPlans.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().clone()));
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
        this.activities = u.getActivities();
        this.trainingPlans = u.getTrainingPlans();
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
    public Map<Integer, Activity> getActivities() {
        return this.activities.values().stream().collect(Collectors.toMap(Activity::getCode, Activity::clone));
    }

    /**
     * Get training plans of the user.
     * @return training plans of the user.
     */
    public Map<Integer, TrainingPlan> getTrainingPlans() {
        return trainingPlans.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().clone()));
    }

    /**
     * Set activities of the user.
     * @param activities The activities to set.
     */
    public void setActivities(Map<Integer, Activity> activities) {
        this.activities = activities.values().stream().map(Activity::clone).collect(Collectors.toMap(Activity::getCode, Activity::clone));
    }

    /**
     * Set training plans of the user.
     * @param trainingPlans The training plans to set.
     */
    public void setTrainingPlans(Map<Integer, TrainingPlan> trainingPlans) {
        this.trainingPlans = trainingPlans.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().clone()));
    }

    /**
     * Add an activity to the user.
     * @param activity The activity to add.
     */
    public void addActivity(Activity activity) {
        this.activities.put(activity.getCode(), activity.clone());
    }

    /**
     * Add a training plan to the user.
     * @param trainingPlan The training plan to add.
     */
    public void addTrainingPlan(TrainingPlan trainingPlan) {
        this.trainingPlans.put(this.trainingPlans.size(), trainingPlan.clone());
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

        if (activities != null) {
            sb.append("Activities:\n");
            for (Activity activity : activities.values()) {
                sb.append(activity.toString()).append("\n");
            }
        }

        if (trainingPlans != null) {
            sb.append("Training Plans:\n");
            for (TrainingPlan trainingPlan : trainingPlans.values()) {
                sb.append(trainingPlan.toString()).append("\n");
            }
        }

        return sb.toString();
    }

    /**
     * Calculates the Body Mass Index (BMI) of the user.
     * @return The calculated BMI.
     */
    public double calculateBMI(){
        return this.getWeight() / (this.getHeight() * this.getHeight());
    }

    /**
     * Abstract method to calculate the calories factor for the user.
     * Subclasses must implement this method to provide specific calculation based on user type and on his bmi.
     * @return The calculated calories factor.
     */
    public abstract double calculateCaloriesFactor();
}
