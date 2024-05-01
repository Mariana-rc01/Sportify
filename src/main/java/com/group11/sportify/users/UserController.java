package com.group11.sportify.users;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.group11.sportify.users.exceptions.UserDoesntExistException;

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
    public UserController() {
        this.users = new HashMap<>();
    }

    /**
     * Retrieves a list of all users.
     * 
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
        if (this.users.containsKey(code)) {
            return this.users.get(code).clone();
        }
        throw new UserDoesntExistException();
    }

    /**
     * Inserts a new amateur user into the system.
     * 
     * @param name             The name of the user.
     * @param address          The address of the user.
     * @param email            The email address of the user.
     * @param averageHeartRate The average heart rate of the user.
     * @param weight           The weight of the user.
     * @param height           The height of the user.
     * @return The newly inserted user.
     */
    public User insertUserAmateur(String name, String address, String email, int averageHeartRate, double weight,
            double height) {
        int code = this.users.size();
        User user = new Amateur(code, name, address, email, averageHeartRate, weight, height);
        this.users.put(code, user);
        return user;
    }

    /**
     * Inserts a new casual user into the system.
     * 
     * @param name             The name of the user.
     * @param address          The address of the user.
     * @param email            The email address of the user.
     * @param averageHeartRate The average heart rate of the user.
     * @param weight           The weight of the user.
     * @param height           The height of the user.
     * @return The newly inserted user.
     */
    public User insertUserCasual(String name, String address, String email, int averageHeartRate, double weight,
            double height) {
        int code = this.users.size();
        User user = new Casual(code, name, address, email, averageHeartRate, weight, height);
        this.users.put(code, user);
        return user;
    }

    /**
     * Inserts a new professional user into the system.
     * 
     * @param name             The name of the user.
     * @param address          The address of the user.
     * @param email            The email address of the user.
     * @param averageHeartRate The average heart rate of the user.
     * @param weight           The weight of the user.
     * @param height           The height of the user.
     * @return The newly inserted user.
     */
    public User insertUserProfessional(String name, String address, String email, int averageHeartRate, double weight,
            double height) {
        int code = this.users.size();
        User user = new Professional(code, name, address, email, averageHeartRate, weight, height);
        this.users.put(code, user);
        return user;
    }

    /**
     * Inserts a new activity for a user identified by the given code.
     * 
     * @param userCode     The code of the user to insert the activity for.
     * @param activityCode The activity to insert already created on
     *                     ActivityController.
     * @throws UserDoesntExistException If the user with the specified code doesn't
     *                                  exist.
     */
    public void insertActivity(int userCode, int activityCode) throws UserDoesntExistException {
        if (this.users.containsKey(userCode)) {
            User user = this.users.get(userCode);
            user.addActivity(activityCode);
        }
        throw new UserDoesntExistException();
    }

    /**
     * Inserts a new training plan for a user identified by the given code.
     * 
     * @param userCode The code of the user to insert the activity for.
     * @param planCode The plan to insert already created on ActivityPlanController.
     * @throws UserDoesntExistException If the user with the specified code doesn't
     *                                  exist.
     */
    public void insertTrainingPlan(int userCode, int planCode) throws UserDoesntExistException {
        if (this.users.containsKey(userCode)) {
            User user = this.users.get(userCode);
            user.addTrainingPlan(planCode);
        }
        throw new UserDoesntExistException();
    }

    /**
     * Updates a user with the specified code with the provided new values.
     *
     * @param code                The unique code of the user to update.
     * @param newName             The new name of the user (empty string to keep
     *                            unchanged).
     * @param newAddress          The new address of the user (empty string to keep
     *                            unchanged).
     * @param newEmail            The new email address of the user (empty string to
     *                            keep unchanged).
     * @param newAverageHeartRate The new average heart rate of the user (0 to keep
     *                            unchanged).
     * @param newWeight           The new weight of the user (0 to keep unchanged).
     * @param newHeight           The new height of the user (0 to keep unchanged).
     * @return The updated user.
     * @throws UserDoesntExistException If no user with the given code exists.
     */
    public User updateUser(int code, String newName, String newAddress, String newEmail, int newAverageHeartRate,
            double newWeight, double newHeight) throws UserDoesntExistException {
        if (users.containsKey(code)) {
            User user = users.get(code);

            if (!newName.isEmpty())
                user.setName(newName);
            if (!newAddress.isEmpty())
                user.setAddress(newAddress);
            if (!newEmail.isEmpty())
                user.setEmail(newEmail);
            if (newAverageHeartRate != 0)
                user.setAverageHeartRate(newAverageHeartRate);
            if (newWeight != 0)
                user.setWeight(newWeight);
            if (newHeight != 0)
                user.setHeight(newHeight);

            users.put(code, user);

            return user;
        } else {
            throw new UserDoesntExistException();
        }
    }

    /**
     * Clears all user data.
     */
    public void clearUsers() {
        users.clear();
    }
}
