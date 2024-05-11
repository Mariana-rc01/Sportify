package com.group11.sportify.views.plans;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.group11.sportify.Sportify;
import com.group11.sportify.activities.Activity;
import com.group11.sportify.activities.ActivityController;
import com.group11.sportify.activities.ActivityProperty;
import com.group11.sportify.activities.ActivityType;
import com.group11.sportify.activities.ActivityType.ActivityTypeImplentation;
import com.group11.sportify.plans.TrainingPlan;
import com.group11.sportify.plans.TrainingPlanController;
import com.group11.sportify.users.User;
import com.group11.sportify.views.View;
import com.group11.sportify.views.components.Input;
import com.group11.sportify.views.components.Menu;

public class TrainingPlanView implements View {

    private User currentUser;
    private Sportify sportifyApplication;

    /**
     * Default constructor for the TrainingPlanView class.
     * 
     * @param currentUser         The current user.
     * @param sportifyApplication The Sportify application.
     */
    public TrainingPlanView(User currentUser, Sportify sportifyApplication) {
        this.currentUser = currentUser;
        this.sportifyApplication = sportifyApplication;
    }

    @Override
    public void show() {
        planMenu();
    }

    /**
     * Shows the plan menu.
     */
    private void planMenu() {
        boolean shouldExit = false;
        while (!shouldExit) {
            System.out.println("\n====================");
            System.out.println("  Training Plan 🍎  ");
            System.out.println("====================");

            Menu menu = new Menu(new String[] { "🆕 Create new training plan", "🪄 Generate training plan",
                    "👀 View all training plans", "🚪 Return" });
            menu.setHandler(0, this::newTrainingPlan);
            menu.setHandler(1, this::generatePlanView);
            menu.setHandler(2, this::viewTrainingPlans);
            shouldExit = !menu.run();
        }
    }

    /**
     * Create a new training plan.
     */
    private void newTrainingPlan() {
        System.out.println("\n====================");
        System.out.println("  New Training Plan 🍎  ");
        System.out.println("====================");

        System.out.println("Please enter the following details to create a new training plan:");

        Input input = new Input();
        System.out.println("When do you plan on executing this plan?");
        LocalDate startDate = input.getDate();
        TrainingPlan plan = new TrainingPlan(startDate.atTime(0, 0), this.currentUser.getCode());
        ActivityController activityController = sportifyApplication.getController().getActivitiesController();

        Boolean shouldExit = false;

        while(!shouldExit){
            List<String> options = new ArrayList<>();
            for(ActivityType type : ActivityType.values()){
                options.add(type.getIcon() + " " + type.getName());
            }
            int chosenIndex = new Menu(options.toArray(new String[0])).runSimple();
            ActivityType chosenType = ActivityType.values()[chosenIndex];
    
            List<String> activityOptions = new ArrayList<>();
            for(ActivityTypeImplentation activity : chosenType.getImplementations()){
                activityOptions.add(activity.getIcon() + " " + activity.getName());
            }
    
            int chosenActivityIndex = new Menu(activityOptions.toArray(new String[0])).runSimple();
            ActivityTypeImplentation chosenActivity = chosenType.getImplementations()[chosenActivityIndex];
    
            List<Object> inputValues = new ArrayList<>();
            for(ActivityProperty property : chosenType.getProperties()){
                System.out.println("\n" + property.getDescription() + ": ");
                Object value = input.getInput(property.getType());
                inputValues.add(value);
            }
    
            int addedActivityCode = -1;
            switch (chosenType) {
                case REPEATING:
                    addedActivityCode = activityController.insertActivity(chosenActivity.getType(), (String) inputValues.get(0), (int) inputValues.get(1), (int) inputValues.get(2), (LocalDateTime) inputValues.get(3), (int) inputValues.get(4), currentUser.getCode()).getCode();
                    break;
                case REPEATING_WEIGHTS:
                    addedActivityCode = activityController.insertActivity(chosenActivity.getType(), (String) inputValues.get(0), (int) inputValues.get(1), (int) inputValues.get(2), (LocalDateTime) inputValues.get(3), (int) inputValues.get(4), (double) inputValues.get(5), currentUser.getCode()).getCode();
                    break;
                case DISTANCE:
                    addedActivityCode = activityController.insertActivity(chosenActivity.getType(), (String) inputValues.get(0), (int) inputValues.get(1), (int) inputValues.get(2), (LocalDateTime) inputValues.get(3), (double) inputValues.get(4), currentUser.getCode()).getCode();
                    break;
                case DISTANCE_ALTITUDE:
                    addedActivityCode = activityController.insertActivity(chosenActivity.getType(), (String) inputValues.get(0), (int) inputValues.get(1), (int) inputValues.get(2), (LocalDateTime) inputValues.get(3), (double) inputValues.get(4), (double) inputValues.get(5), currentUser.getCode()).getCode();
                    break;
            }
    
            plan.addPlanActivity(addedActivityCode);
    
            Menu menu = new Menu(new String[] { "🆕 Add another activity", "🚪 Finish" });
            int choice = menu.runSimple();
            if(choice != 0){
                shouldExit = true;
            }
        }

        TrainingPlanController trainingPlanController = sportifyApplication.getController().getTrainingPlanController();
        trainingPlanController.addTrainingPlan(trainingPlanController.getNumberTrainingPlans(), plan);
        System.out.println("Training plan created successfully.");
    }

    /**
     * View all training plans.
     */
    private void viewTrainingPlans(){
        System.out.println("\n====================");
        System.out.println("  View Training Plans 🍎  ");
        System.out.println("====================");

        List<TrainingPlan> plans = sportifyApplication.getController().getTrainingPlanController().getUserTrainingPlans(currentUser.getCode());
        if (plans.isEmpty()) {
            System.out.println("You have no training plans.");
            return;
        }

        System.out.println("Here are your training plans:");
        for (int i = 0; i < plans.size(); i++) {
            TrainingPlan plan = plans.get(i);
            System.out.println((i + 1) + ". " + plan.getStartDate().toLocalDate());
            System.out.println("   " + plan.getPlanActivities().size() + " activities");
            ActivityController activityController = sportifyApplication.getController().getActivitiesController();
            for (int activityCode : plan.getPlanActivities()) {
                try {
                    Activity activity = activityController.getActivity(activityCode);
                    System.out.println(activity.toString());
                } catch (Exception e) {
                    System.out.println("Activity not found."); 
                }
            }
        }
    } 

    /**
     * Generate a training plan.
     */
    private void generatePlanView() {
        System.out.println("\n===========================");
        System.out.println(" Generate Training Plan 🪄");
        System.out.println("===========================");

        System.out.println("Please enter the following details to generate a training plan:");

        Input input = new Input();
        System.out.println("When do you plan on executing this plan?");
        LocalDate startDate = input.getDate();
        int uniqueActivitiesCount = -1;

        System.out.println("How many calories do you want to burn? (minimum)");
        int minimumCaloriesBurned = input.getInt();

        while (uniqueActivitiesCount <= 0 || uniqueActivitiesCount > 15) {
            System.out.println("How many unique activities should the plan contain?");
            uniqueActivitiesCount = input.getInt();
            if (uniqueActivitiesCount <= 0 || uniqueActivitiesCount > 15) {
                System.out.println("Please enter a number between 1 and 15.");
            }
        }

        int occupiedSlots = 0;
        Map<Class<? extends Activity>, Integer> activities = new HashMap<>();
        for (int i = 0; i < uniqueActivitiesCount && occupiedSlots < 21; i++) {
            Class<? extends Activity> pickedActivity = null;
            while (pickedActivity == null || activities.containsKey(pickedActivity)) {
                pickedActivity = activityPicker();
                if (activities.containsValue(pickedActivity)) {
                    System.out.println("This activity is already in the plan.");
                }
            }

            System.out.println("How many times should this activity be repeated?");
            int repeatCount = -1;
            while (repeatCount <= 0 || occupiedSlots + repeatCount > 21) {
                repeatCount = input.getInt();
                if (repeatCount <= 0 || occupiedSlots + repeatCount > 21) {
                    System.out.println("Please enter a number between 1 and " + (21 - occupiedSlots));
                }
            }
            activities.put(pickedActivity, repeatCount);
            occupiedSlots += repeatCount;
        }

        TrainingPlan plan = new TrainingPlan(startDate.atTime(9, 0), this.currentUser.getCode());

        // Create a list to save the activities based on the number of repetitions
        List<Class<? extends Activity>> activityList = new ArrayList<>();

        // Iterate over the map
        for (Map.Entry<Class<? extends Activity>, Integer> entry : activities.entrySet()) {
            Class<? extends Activity> activity = entry.getKey();
            int repeatCount = entry.getValue();
            for (int i = 0; i < repeatCount; i++) {
                activityList.add(activity);
            }
        }

        double caloriesConsume = sportifyApplication.getController().generateTrainingPlan(startDate, plan, currentUser,
                activityList, minimumCaloriesBurned);
        System.out.println("\nAdded training plan with " + caloriesConsume + " calories consume.");
    }

    /*
     * Prompt the user to pick an activity.
     * 
     * @return The selected activity.
     */
    private Class<? extends Activity> activityPicker() {
        System.out.println("Please select an activity:");

        List<ActivityType> options = new ArrayList<>();
        for (ActivityType type : ActivityType.values()) {
            options.add(type);
        }

        Menu menu = new Menu(
                options.stream().map(type -> type.getIcon() + " " + type.getName()).toArray(String[]::new));
        int chosenIndex = menu.runSimple();

        List<ActivityTypeImplentation> activities = new ArrayList<>();
        for (ActivityTypeImplentation activity : options.get(chosenIndex).getImplementations()) {
            activities.add(activity);
        }

        Menu activityMenu = new Menu(activities.stream().map(activity -> activity.getIcon() + " " + activity.getName())
                .toArray(String[]::new));

        System.out.println("Please select an activity:");

        int chosenActivityIndex = activityMenu.runSimple();

        return activities.get(chosenActivityIndex).getType();
    }
}
