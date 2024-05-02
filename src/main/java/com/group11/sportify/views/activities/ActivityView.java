package com.group11.sportify.views.activities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.group11.sportify.Sportify;
import com.group11.sportify.activities.Activity;
import com.group11.sportify.activities.ActivityController;
import com.group11.sportify.activities.ActivityProperty;
import com.group11.sportify.activities.ActivityType;
import com.group11.sportify.activities.ActivityType.ActivityTypeImplentation;
import com.group11.sportify.users.User;
import com.group11.sportify.views.View;
import com.group11.sportify.views.components.Input;
import com.group11.sportify.views.components.Menu;

/**
 *  Activity related views.
 */
public class ActivityView implements View {

    private User currentUser;
    private Sportify sportifyApplication;

    /**
     * Default constructor for the ActivityView class.
     * @param currentUser The current user.
     * @param sportifyApplication The Sportify application.
     */
    public ActivityView(User currentUser, Sportify sportifyApplication) {
        this.currentUser = currentUser;
        this.sportifyApplication = sportifyApplication;
    }

    @Override
    public void show() {
        activityMenu();
    }
    
    /**
     * Shows the activity menu.
     */
    public void activityMenu(){
        boolean shouldExit = false;
        while(!shouldExit){
            System.out.println("\n====================");
            System.out.println("  Activity Menu 🤾‍♂️   ");
            System.out.println("====================");
    
            Menu menu = new Menu(new String[]{"🆕 Register new Activity", "👀 View all activities", "🚪 Return"});
            menu.setHandler(0, this::newActivity);
            menu.setHandler(1, this::viewActivities);
            shouldExit = !menu.run();
        }
    }

    /**
     *  New activity menu.
     */
    public void newActivity() {
        boolean shouldExit = false;
        while(!shouldExit){
            System.out.println("\n==========================");
            System.out.println(" Register New Activity 🤾‍♂️");
            System.out.println("==========================");
    
            List<String> options = new ArrayList<>();
            for(ActivityType type : ActivityType.values()){
                options.add(type.getIcon() + " " + type.getName());
            }
            options.add("🚪 Return");
    
            Menu menu = new Menu(options.toArray(new String[0]));
            
            for(int i = 0; i < ActivityType.values().length; i++){
                int index = i;
                menu.setHandler(i, () -> newActivityType(ActivityType.values()[index]));
            }

            shouldExit = !menu.run();
        }
    }

    /**
     * View all activities.
     */
    public void viewActivities(){
        ActivityController activityController = sportifyApplication.getController().getActivitiesController();
        List<Activity> activities = activityController.getUserActivities(currentUser.getCode());
        System.out.println("\n==========================");
        System.out.println("  Your Activities 🤾‍♂️   ");
        System.out.println("==========================");
        for(Activity activity : activities){
            System.out.println(activity);
        }
    }

    /**
     * New activity type.
     * @param type The type of the activity.
     */
    public void newActivityType(ActivityType type) {
        System.out.println("\n==========================");
        System.out.println(type.getName() + " " + type.getIcon());
        System.out.println("==========================");
        System.out.println(type.getDescription());

        List<String> options = new ArrayList<>();
        for(ActivityTypeImplentation implementation : type.getImplementations()){
            options.add(implementation.getIcon() + " " + implementation.getName());
        }
        options.add("🚪 Return");
    
        Menu menu = new Menu(options.toArray(new String[0]));
        for(int i = 0; i < type.getImplementations().length; i++){
            int index = i;
            menu.setHandler(i, () -> createActivity(type, type.getImplementations()[index]));
        }

        menu.run();
    }

    /**
     * Create activity.
     * @param type The type of the activity.
     * @param implementation The implementation of the activity.
     */
    public void createActivity(ActivityType type, ActivityTypeImplentation implementation) {
        System.out.println("\n==========================\n");
        System.out.println("Creating new activity of type " + implementation.getName() + ".");
        List<Object> inputValues = new ArrayList<>();
        for(ActivityProperty property : type.getProperties()){
            System.out.println("\n" + property.getDescription() + ": ");
            Input input = new Input();
            Object value = input.getInput(property.getType());
            inputValues.add(value);
        }

        ActivityController activityController = sportifyApplication.getController().getActivitiesController();

        switch (type) {
            case REPEATING:
                activityController.insertActivity(implementation.getType(), (String) inputValues.get(0), (int) inputValues.get(1), (int) inputValues.get(2), (LocalDateTime) inputValues.get(3), (int) inputValues.get(4), currentUser.getCode());
                break;
        
            case REPEATING_WEIGHTS:
                activityController.insertActivity(implementation.getType(), (String) inputValues.get(0), (int) inputValues.get(1), (int) inputValues.get(2), (LocalDateTime) inputValues.get(3), (int) inputValues.get(4), (double) inputValues.get(5), currentUser.getCode());
                break;
            case DISTANCE:
                activityController.insertActivity(implementation.getType(), (String) inputValues.get(0), (int) inputValues.get(1), (int) inputValues.get(2), (LocalDateTime) inputValues.get(3), (double) inputValues.get(4), currentUser.getCode());
                break;
            case DISTANCE_ALTITUDE:
                activityController.insertActivity(implementation.getType(), (String) inputValues.get(0), (int) inputValues.get(1), (int) inputValues.get(2), (LocalDateTime) inputValues.get(3), (double) inputValues.get(4), (double) inputValues.get(5), currentUser.getCode());
                break;
        }
    }
}
