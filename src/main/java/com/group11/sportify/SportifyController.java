package com.group11.sportify;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.group11.sportify.activities.Activity;
import com.group11.sportify.activities.ActivityController;
import com.group11.sportify.activities.ActivityType;
import com.group11.sportify.activities.ActivityType.ActivityTypeImplentation;
import com.group11.sportify.activities.Hard;
import com.group11.sportify.activities.distance.ActivityDistance;
import com.group11.sportify.activities.distance.altitude.ActivityDistanceAltitude;
import com.group11.sportify.activities.exceptions.ActivityDoesntExistException;
import com.group11.sportify.plans.TrainingPlan;
import com.group11.sportify.plans.TrainingPlanController;
import com.group11.sportify.plans.exceptions.TrainingPlanDoesntExistException;
import com.group11.sportify.time.TimeController;
import com.group11.sportify.users.User;
import com.group11.sportify.users.UserController;
import com.group11.sportify.users.exceptions.UserDoesntExistException;

/*
 * Controller class for the Sportify application data.
 */
public class SportifyController implements Serializable {
    private UserController userController;
    private ActivityController activitiesController;
    private TimeController timeController;
    private TrainingPlanController trainingPlanController;

    /**
     * Default constructor for the SportifyController class.
     */
    public SportifyController() {
        userController = new UserController();
        activitiesController = new ActivityController();
        timeController = new TimeController();
        trainingPlanController = new TrainingPlanController();
    }

    /*
     * Returns the user controller
     * 
     * @return The user controller.
     */
    public UserController getUserController() {
        return userController;
    }

    /*
     * Returns the activities controller
     * 
     * @return The activities controller.
     */
    public ActivityController getActivitiesController() {
        return activitiesController;
    }

    /*
     * Returns the time controller
     * 
     * @return The time controller.
     */
    public TimeController getTimeController() {
        return timeController;
    }

    /*
     * Returns the training plan controller
     * 
     * @return The training plan controller.
     */
    public TrainingPlanController getTrainingPlanController() {
        return trainingPlanController;
    }

    /**
     * 1ª Statistic
     * Finds the user who burned the most calories within the specified time period.
     *
     * @param startDate The start date of the time period.
     * @param endDate   The end date of the time period.
     * @return The user who burned the most calories, or null if no user is found.
     * @throws ActivityDoesntExistException If an activity doesn't exist.
     */
    public User getUserWithMostCalories(LocalDateTime startDate, LocalDateTime endDate)
            throws ActivityDoesntExistException {
        return userController.getAllUsers().stream().max(Comparator.comparingDouble(
                user -> {
                    try {
                        return calculateTotalCalories(startDate, endDate, user);
                    } catch (ActivityDoesntExistException e) {
                        return 0;
                    }
                })).orElse(null);
    }

    /**
     * Calculates the total calories burned by a user from activities
     * within the specified time period.
     *
     * @param startDate The start date of the time period.
     * @param endDate   The end date of the time period.
     * @param user      The user for whom to calculate the total calories burned.
     * @return The total calories burned by the user from individual activities.
     * @throws ActivityDoesntExistException If an activity doesn't exist.
     */
    public double calculateTotalCalories(LocalDateTime startDate, LocalDateTime endDate, User user)
            throws ActivityDoesntExistException {
        return user.getActivities().stream().mapToDouble(activityCode -> {
            try {
                Activity activity = activitiesController.getActivity(activityCode);
                LocalDateTime activityDate = activity.getDate();
                if (activityDate.isAfter(startDate) && activityDate.isBefore(endDate)) {
                    return activity.calculateCaloriesConsume(user);
                }
            } catch (ActivityDoesntExistException e) {
                return 0;
            }
            return 0;
        }).sum();
    }

    /*
     * 2ª Statistic
     * Returns the user with the most activities between two dates.
     *
     * @param startDate The start date.
     * 
     * @param endDate The end date.
     *
     * @return The user with most activities between the two dates or null if there
     * is none.
     */
    public User getUserWithMostActivitiesBetweenDates(LocalDateTime startDate, LocalDateTime endDate) {
        int topUserCode = activitiesController.getActivitiesBetweenDates(startDate, endDate).stream()
                .collect(Collectors.groupingBy(Activity::getUserCode)).entrySet().stream()
                .max((e1, e2) -> e1.getValue().size() - e2.getValue().size()).get().getKey();
        try {
            return userController.getUser(topUserCode);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 3ª Statistic
     * Returns the most practiced activity in the application.
     *
     * @return The most practiced activity in the application.
     */
    public ActivityTypeImplentation getMostPracticedActivity() {
        Class<? extends Activity> mostPracticedActivityClass = activitiesController.getAllActivities().stream()
                .collect(Collectors.groupingBy(Activity::getClass)).entrySet().stream()
                .max((e1, e2) -> e1.getValue().size() - e2.getValue().size()).get().getKey();
        return ActivityType.getImplementation(mostPracticedActivityClass);
    }

    /**
     * 4ª Statistic
     * Calculates the total distance covered by a user within the specified time
     * period.
     *
     * @param user      The user for whom to calculate the total distance.
     * @param startDate The start date of the time period.
     * @param endDate   The end date of the time period.
     * @return The total distance covered by the user.
     * @throws ActivityDoesntExistException If an activity doesn't exist.
     */
    public double getTotalDistanceUser(User user, LocalDateTime startDate, LocalDateTime endDate)
            throws ActivityDoesntExistException {
        double totalDistance = 0;

        totalDistance += user.getActivities().stream().mapToDouble(activityCode -> {
            try {
                Activity activity = activitiesController.getActivity(activityCode);
                if (activity instanceof ActivityDistance) {
                    LocalDateTime activityDate = activity.getDate();
                    if (activityDate.isAfter(startDate) && activityDate.isBefore(endDate)) {
                        return ((ActivityDistance) activity).getDistance();
                    }
                }
            } catch (ActivityDoesntExistException e) {
                return 0;
            }
            return 0;
        }).sum();

        return totalDistance;
    }

    /**
     * 5ª Statistic
     * Calculates the total altitude covered by a user within the specified time
     * period.
     *
     * @param user      The user for whom to calculate the total altitude.
     * @param startDate The start date of the time period.
     * @param endDate   The end date of the time period.
     * @return The total altitude covered by the user.
     * @throws ActivityDoesntExistException If an activity doesn't exist.
     */
    public double getTotalAltitudeUser(User user, LocalDateTime startDate, LocalDateTime endDate)
            throws ActivityDoesntExistException {
        double totalAltitude = 0;

        totalAltitude += user.getActivities().stream().mapToDouble(activityCode -> {
            try {
                Activity activity = activitiesController.getActivity(activityCode);
                if (activity instanceof ActivityDistanceAltitude) {
                    LocalDateTime activityDate = activity.getDate();
                    if (activityDate.isAfter(startDate) && activityDate.isBefore(endDate)) {
                        return ((ActivityDistanceAltitude) activity).getAltitude();
                    }
                }
            } catch (ActivityDoesntExistException e) {
                return 0;
            }
            return 0;
        }).sum();

        return totalAltitude * 1000;
    }

    /**
     * 6ª Statistic
     * Returns the training plan which is the most effective one burning calories.
     *
     * @param user The user for whom to calculate the total altitude.
     * @return The training plan which is the most effective one burning calories.
     * @throws ActivityDoesntExistException     If an activity doesn't exist.
     * @throws TrainingPlanDoesntExistException If a training plan doesn't exist.
     */
    public TrainingPlan getMostEffectiveTrainingPlanBurningCalories(User user)
            throws ActivityDoesntExistException, TrainingPlanDoesntExistException {
        List<Integer> trainingPlansCode = user.getTrainingPlans();
        int result = -1;
        double maxCalories = 0;

        for (int trainingCode : trainingPlansCode) {

            TrainingPlan trainingPlan = trainingPlanController.getTrainingPlan(trainingCode);

            if (trainingPlan != null) {
                List<Integer> codes = trainingPlan.getPlanActivities();
                double planCalories = 0;

                for (Integer activityCode : codes) {

                    Activity activity = activitiesController.getActivity(activityCode);
                    if (activity != null) {
                        planCalories += activity.calculateCaloriesConsume(user);
                    }
                }

                if (planCalories > maxCalories || result == -1) {
                    maxCalories = planCalories;
                    result = trainingCode;
                }
            }
        }

        return trainingPlanController.getTrainingPlan(result);
    }

    /**
     * 7ª Statistic
     * Gets all activities belonging to a user.
     *
     * @param userCode The code of the user to get the activities from.
     * @return The list of activities belonging to the specified user.
     */
    public List<Activity> getUserActivities(int userCode) {
        List<Activity> activities = this.activitiesController.getUserActivities(userCode);
        return activities;
    }

    /**
     * Clears all data stored in the application, including user data, activity
     * data, training plan data, and time-related data.
     */
    public void clearData() {
        userController.clearUsers();
        activitiesController.clearActivities();
        trainingPlanController.clearTrainingPlans();
        timeController.clearTimeData();
    }

    /**
     * Generates a training plan based on the provided parameters.
     *
     * @param startDate             The start date of the training plan.
     * @param plan                  The training plan to be generated.
     * @param user                  The user for whom the training plan is being
     *                              generated.
     * @param activities            The list of activities to include in the
     *                              training plan.
     * @param minimumCaloriesBurned The minimum number of calories to be burned
     *                              during the training plan.
     * @return Returns caloriesConsume if the training plan is successfully
     *         generated, -1 otherwise.
     */
    public double generateTrainingPlan(LocalDate startDate, TrainingPlan plan, User user,
            List<Class<? extends Activity>> activities, int minimumCaloriesBurned) {
        // Calculate target calories per activity
        int totalActivities = activities.size();
        double targetCaloriesPerActivity = (double) minimumCaloriesBurned / totalActivities * 25;

        int userCode = user.getCode();
        double caloriesConsume = 0;

        List<LocalDateTime> availableSlots = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            LocalDate currentDate = startDate.plusDays(i);
            availableSlots.add(currentDate.atTime(9, 0));
            availableSlots.add(currentDate.atTime(15, 0));
            availableSlots.add(currentDate.atTime(17, 0));
        }
        List<LocalDate> hardActivityDays = new ArrayList<>();

        for (Class<? extends Activity> activityClass : activities) {
            Activity activity = null;

            // Calculate activity parameters
            int repetitions = (int) Math.ceil(targetCaloriesPerActivity);
            double distance = targetCaloriesPerActivity;
            int time = (int) targetCaloriesPerActivity * 10;
            double weight = Math.random() % 70;
            double altitude = Math.random() % 100;

            ActivityType.ActivityTypeImplentation implementation = ActivityType.getImplementation(activityClass);
            ActivityType type = null;

            // Determinar o tipo de atividade
            for (ActivityType activityType : ActivityType.values()) {
                for (ActivityType.ActivityTypeImplentation impl : activityType.getImplementations()) {
                    if (impl.equals(implementation)) {
                        type = activityType;
                        break;
                    }
                }
                if (type != null)
                    break;
            }

            boolean hard = false;
            LocalDateTime chosenDate;
            try {
                Activity activityInstance = activityClass.getDeclaredConstructor().newInstance();

                if (activityInstance instanceof Hard) {
                    hard = true;
                }

            } catch (InstantiationException | IllegalAccessException | InvocationTargetException
                    | NoSuchMethodException e) {
                return 0;
            }

            chosenDate = chooseDate(availableSlots, hardActivityDays, hard);

            if (hard == true) {
                hardActivityDays.add(chosenDate.toLocalDate());
            }

            availableSlots.remove(chosenDate);

            switch (type) {
                case REPEATING:
                    activity = this.getActivitiesController().insertActivity(activityClass, "repetitions",
                            time, user.getAverageHeartRate(), chosenDate, repetitions, userCode);
                    break;
                case REPEATING_WEIGHTS:
                    activity = this.getActivitiesController().insertActivity(activityClass, "repetitions",
                            time, user.getAverageHeartRate(), chosenDate, repetitions, weight, userCode);
                    break;
                case DISTANCE:
                    activity = this.getActivitiesController().insertActivity(activityClass, "repetitions",
                            time, user.getAverageHeartRate(), chosenDate, distance, userCode);
                    break;
                case DISTANCE_ALTITUDE:
                    activity = this.getActivitiesController().insertActivity(activityClass, "repetitions",
                            time, user.getAverageHeartRate(), chosenDate, distance * 0.6, altitude,
                            userCode);
                    break;
            }

            // Add activity to the training plan
            int code = activity.getCode();
            plan.addPlanActivity(code);
            caloriesConsume = caloriesConsume + activity.calculateCaloriesConsume(user);
        }

        // Add the training plan to the training plan controller and link it to the user
        int codeTP = this.getTrainingPlanController().getNumberTrainingPlans();
        this.getTrainingPlanController().addTrainingPlan(codeTP, plan);
        try {
            this.getUserController().insertTrainingPlan(userCode, codeTP);
        } catch (UserDoesntExistException e) {
            return -1;
        }

        return caloriesConsume;
    }

    /**
     * Chooses a date and time slot for scheduling an activity
     *
     * @param availableSlots   List of available time slots
     * @param hardActivityDays List of dates with hard activities
     * @param isHard           Indicates whether the activity is hard
     * @return Returns the chosen date and time slot
     */
    private LocalDateTime chooseDate(List<LocalDateTime> availableSlots, List<LocalDate> hardActivityDays,
            boolean isHard) {
        if (isHard) {
            for (LocalDateTime slot : availableSlots) {
                LocalDate currentDate = slot.toLocalDate();
                LocalDate previousDate = currentDate.minusDays(1);

                // Check if the current date or the previous date has a hard activity scheduled
                if (!hardActivityDays.contains(currentDate) && !hardActivityDays.contains(previousDate)) {
                    return slot;
                }
            }

            // If no suitable date and time are found, choose the next available date
            // outside of the avaiableSlots
            LocalDate lastSlotDate = availableSlots.get(availableSlots.size() - 1).toLocalDate();
            LocalDate nextDay = lastSlotDate.plusDays(2);
            while (hardActivityDays.contains(nextDay)) {
                nextDay = nextDay.plusDays(2);
            }
            return nextDay.atTime(9, 0);
        } else { // If the activity is not hard, choose a random available time slot
            Random random = new Random();
            int randomIndex = random.nextInt(availableSlots.size());
            return availableSlots.get(randomIndex);
        }
    }

}
