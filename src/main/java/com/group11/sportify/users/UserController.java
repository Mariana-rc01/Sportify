package com.group11.sportify.users;

import com.group11.sportify.activities.Activity;
import com.group11.sportify.activities.exceptions.ActivityDoesntExistException;
import com.group11.sportify.users.exceptions.UserDoesntExistException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controller class for managing users.
 */
public class UserController {

    /**
     * Map to store users with their unique codes as keys.
     */
    private Map<Integer, User> users;

    /**
     * Constructor for UserController class.
     * Initializes the users map.
     */
    public UserController(){
        this.users = new HashMap<>();
    }

    /**
     * Retrieves a list of all users.
     * @return A list containing all users.
     */
    public List<User> getAllUsers() {
        return this.users.values().stream().map(User::clone).toList();
    }

    /**
     * Retrieves a user by their unique code.
     *
     * @param code The unique code of the user to retrieve.
     * @return The user corresponding to the given code.
     * @throws UserDoesntExistException If no user with the given code exists.
     */
    public User getUser(int code) throws UserDoesntExistException {
        if(this.users.containsKey(code)){
            return this.users.get(code).clone();
        }
        throw new UserDoesntExistException();
    }

    /**
     * Inserts a new amateur user into the system.
     * @param name The name of the user.
     * @param address The address of the user.
     * @param email The email address of the user.
     * @param averageHeartRate The average heart rate of the user.
     * @param weight The weight of the user.
     * @param height The height of the user.
     * @return The newly inserted user.
     */
    public User insertUserAmateur(String name, String address, String email, int averageHeartRate, double weight, double height){
        int code = this.users.size();
        User user = new Amateur(code,name,address,email,averageHeartRate,weight,height);
        this.users.put(code,user);
        return user;
    }

    /**
     * Inserts a new casual user into the system.
     * @param name The name of the user.
     * @param address The address of the user.
     * @param email The email address of the user.
     * @param averageHeartRate The average heart rate of the user.
     * @param weight The weight of the user.
     * @param height The height of the user.
     * @return The newly inserted user.
     */
    public User insertUserCasual(String name, String address, String email, int averageHeartRate, double weight, double height){
        int code = this.users.size();
        User user = new Casual(code,name,address,email,averageHeartRate,weight,height);
        this.users.put(code,user);
        return user;
    }

    /**
     * Inserts a new professional user into the system.
     * @param name The name of the user.
     * @param address The address of the user.
     * @param email The email address of the user.
     * @param averageHeartRate The average heart rate of the user.
     * @param weight The weight of the user.
     * @param height The height of the user.
     * @return The newly inserted user.
     */
    public User insertUserProfessional(String name, String address, String email, int averageHeartRate, double weight, double height){
        int code = this.users.size();
        User user = new Professional(code,name,address,email,averageHeartRate,weight,height);
        this.users.put(code,user);
        return user;
    }

    /**
     * Inserts a new activity for a user identified by the given code.
     * @param code The code of the user to insert the activity for.
     * @param activity The activity to insert already created on ActivityController.
     * @throws UserDoesntExistException If the user with the specified code doesn't exist.
     */
    public void insertActivity(int code, Activity activity) throws UserDoesntExistException {
        if(this.users.containsKey(code)){
            User user = this.users.get(code);
            user.getActivities().put(activity.getCode(), activity.clone());
        }
        throw new UserDoesntExistException();
    }

    /**
     * Updates a user with the specified code with the provided new values.
     *
     * @param code The unique code of the user to update.
     * @param newName The new name of the user (empty string to keep unchanged).
     * @param newAddress The new address of the user (empty string to keep unchanged).
     * @param newEmail The new email address of the user (empty string to keep unchanged).
     * @param newAverageHeartRate The new average heart rate of the user (0 to keep unchanged).
     * @param newWeight The new weight of the user (0 to keep unchanged).
     * @param newHeight The new height of the user (0 to keep unchanged).
     * @return The updated user.
     * @throws UserDoesntExistException If no user with the given code exists.
     */
    public User updateUser(int code, String newName, String newAddress, String newEmail, int newAverageHeartRate, double newWeight, double newHeight) throws UserDoesntExistException{
        if (users.containsKey(code)) {
            User user = users.get(code);

            if (!newName.isEmpty()) user.setName(newName);
            if (!newAddress.isEmpty()) user.setAddress(newAddress);
            if (!newEmail.isEmpty()) user.setEmail(newEmail);
            if (newAverageHeartRate != 0) user.setAverageHeartRate(newAverageHeartRate);
            if (newWeight != 0) user.setWeight(newWeight);
            if (newHeight != 0) user.setHeight(newHeight);

            users.put(code, user);

            return user;
        } else {
            throw new UserDoesntExistException();
        }
    }

    /**
     * Updates a specific activity of a user with the provided activity information.
     *
     * @param code The unique code of the user to update.
     * @param updatedActivity The updated activity to be associated with the user.
     * @return The updated user.
     * @throws UserDoesntExistException If no user with the provided code exists.
     * @throws ActivityDoesntExistException If the provided activity doesn't exist in the user.
     */
    public User updateUserActivity(int code, Activity updatedActivity) throws UserDoesntExistException, ActivityDoesntExistException {
        if (users.containsKey(code)) {
            User user = users.get(code);

            if (updatedActivity != null){
                if (user.getActivities().containsKey(updatedActivity.getCode())) {
                    user.getActivities().put(updatedActivity.getCode(), updatedActivity);
                }
                else throw new ActivityDoesntExistException();
            }

            users.put(code, user);

            return user;
        } else {
            throw new UserDoesntExistException();
        }
    }
}
