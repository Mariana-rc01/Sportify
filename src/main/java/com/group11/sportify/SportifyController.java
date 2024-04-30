package com.group11.sportify;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.group11.sportify.activities.Activity;
import com.group11.sportify.activities.ActivityController;
import com.group11.sportify.activities.distance.ActivityDistance;
import com.group11.sportify.activities.exceptions.ActivityDoesntExistException;
import com.group11.sportify.plans.PlanActivity;
import com.group11.sportify.plans.TrainingPlan;
import com.group11.sportify.plans.TrainingPlanController;
import com.group11.sportify.plans.exceptions.TrainingPlanDoesntExistException;
import com.group11.sportify.users.User;
import com.group11.sportify.users.UserController;

/*
 * Controller class for the Sportify application data.
 */
public class SportifyController {
    private UserController userController;
    private ActivityController activitiesController;
    private TrainingPlanController trainingPlanController;

    /**
     * Returns the user with the most activities in the sportiy application.
     *
     * @return The user with most activities or null if there is none.
     */
    public User getUserWithMostActivities(){
        return userController.getAllUsers().stream().max((u1, u2) -> u1.getActivities().size() - u2.getActivities().size()).orElse(null);
    }

    /*
     * Returns the user with the most activities between two dates.
     *
     * @param startDate The start date.
     * @param endDate The end date.
     *
     * @return The user with most activities between the two dates or null if there is none.
     */
    public User getUserWithMostActivitiesBetweenDates(LocalDateTime startDate, LocalDateTime endDate){
        int topUserCode = activitiesController.getActivitiesBetweenDates(startDate, endDate).stream().collect(Collectors.groupingBy(Activity::getUserCode)).entrySet().stream().max((e1, e2) -> e1.getValue().size() - e2.getValue().size()).get().getKey();
        try {
            return userController.getUser(topUserCode);
        } catch (Exception e) {
            return null;
        }
    }

    /* 1ª Estatística */
    /**
     * Finds the user who burned the most calories within the specified time period.
     *
     * @param startDate The start date of the time period.
     * @param endDate   The end date of the time period.
     * @return The user who burned the most calories, or null if no user is found.
     * @throws ActivityDoesntExistException    If an activity doesn't exist.
     * @throws TrainingPlanDoesntExistException If a training plan doesn't exist.
     */
    public User getUserWithMostCalories(LocalDateTime startDate, LocalDateTime endDate) throws ActivityDoesntExistException, TrainingPlanDoesntExistException {
        return userController.getAllUsers().stream().max(Comparator.comparingDouble(
            user -> {   try {
                            return calculateTotalCalories(startDate, endDate, user);
                        } catch (ActivityDoesntExistException | TrainingPlanDoesntExistException e) {
                            return 0;
                        }
                    })).orElse(null);
    }
    
    /**
     * Calculates the total calories burned by a user within the specified time period.
     *
     * @param startDate The start date of the time period.
     * @param endDate   The end date of the time period.
     * @param user      The user for whom to calculate the total calories burned.
     * @return The total calories burned by the user.
     * @throws ActivityDoesntExistException    If an activity doesn't exist.
     * @throws TrainingPlanDoesntExistException If a training plan doesn't exist.
     */
    public double calculateTotalCalories(LocalDateTime startDate, LocalDateTime endDate, User user) throws ActivityDoesntExistException, TrainingPlanDoesntExistException {
        double individualActivitiesCalories = calculateIndividualActivitiesCalories(startDate, endDate, user);
        double trainingPlansCalories = calculateTrainingPlansCalories(startDate, endDate, user);
        return individualActivitiesCalories + trainingPlansCalories;
    }


    /**
     * Calculates the total calories burned by a user from individual activities within the specified time period.
     *
     * @param startDate The start date of the time period.
     * @param endDate   The end date of the time period.
     * @param user      The user for whom to calculate the total calories burned.
     * @return The total calories burned by the user from individual activities.
     * @throws ActivityDoesntExistException If an activity doesn't exist.
     */
    public double calculateIndividualActivitiesCalories(LocalDateTime startDate, LocalDateTime endDate, User user) throws ActivityDoesntExistException {
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

    /**
     * Calculates the total calories burned by a user from training plans within the specified time period.
     *
     * @param startDate The start date of the time period.
     * @param endDate   The end date of the time period.
     * @param user      The user for whom to calculate the total calories burned.
     * @return The total calories burned by the user from training plans.
     * @throws TrainingPlanDoesntExistException If a training plan doesn't exist.
     * @throws ActivityDoesntExistException    If an activity doesn't exist.
     */
    public double calculateTrainingPlansCalories(LocalDateTime startDate, LocalDateTime endDate, User user) throws TrainingPlanDoesntExistException, ActivityDoesntExistException{
        double totalCalories = 0;

        List<Integer> trainingPlansCode = user.getTrainingPlans();

        for (int trainingCode : trainingPlansCode){

            TrainingPlan trainingPlan = trainingPlanController.getActivity(trainingCode);
            List<PlanActivity> plans = trainingPlan.getPlanActivities();

            for (PlanActivity plan : plans){

                int activityCode = plan.getActivityCode();
                Activity activity = activitiesController.getActivity(activityCode);
                LocalDateTime activityDate = activity.getDate();

                if (activityDate.isAfter(startDate) && activityDate.isBefore(endDate)) {
                    int iterations = plan.getIterations();
                    totalCalories += activity.calculateCaloriesConsume(user) * iterations;
                }
            }
        }

        return totalCalories;
    }

    /* 2ª estatística */
    /**
     * Calculates the total distance covered by a user within the specified time period.
     *
     * @param user       The user for whom to calculate the total distance.
     * @param startDate  The start date of the time period.
     * @param endDate    The end date of the time period.
     * @return The total distance covered by the user.
     * @throws ActivityDoesntExistException    If an activity doesn't exist.
     * @throws TrainingPlanDoesntExistException If a training plan doesn't exist.
     */
    public double getTotalDistanceUser(User user, LocalDateTime startDate, LocalDateTime endDate) throws ActivityDoesntExistException, TrainingPlanDoesntExistException{
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

        List<Integer> trainingPlansCode = user.getTrainingPlans();
        
        for (int trainingCode : trainingPlansCode){

            TrainingPlan trainingPlan = trainingPlanController.getActivity(trainingCode);
            List<PlanActivity> plans = trainingPlan.getPlanActivities();

            for (PlanActivity plan : plans){

                int activityCode = plan.getActivityCode();
                Activity activity = activitiesController.getActivity(activityCode);
                LocalDateTime activityDate = activity.getDate();

                if (activity instanceof ActivityDistance && activityDate.isAfter(startDate) && activityDate.isBefore(endDate)) {
                    int iterations = plan.getIterations();
                    totalDistance += ((ActivityDistance) activity).getDistance() * iterations;
                }
            }
        }

        return totalDistance;
    }

}
