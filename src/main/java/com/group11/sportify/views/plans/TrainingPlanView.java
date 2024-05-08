package com.group11.sportify.views.plans;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.group11.sportify.Sportify;
import com.group11.sportify.activities.Activity;
import com.group11.sportify.activities.ActivityType;
import com.group11.sportify.activities.ActivityType.ActivityTypeImplentation;
import com.group11.sportify.plans.TrainingPlan;
import com.group11.sportify.users.User;
import com.group11.sportify.views.View;
import com.group11.sportify.views.components.Input;
import com.group11.sportify.views.components.Menu;

public class TrainingPlanView implements View {

    private User currentUser;
    private Sportify sportifyApplication;

    /**
     * Default constructor for the TrainingPlanView class.
     * @param currentUser The current user.
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
    public void planMenu(){
        boolean shouldExit = false;
        while(!shouldExit){
            System.out.println("\n====================");
            System.out.println("  Training Plan 🍎  ");
            System.out.println("====================");
    
            Menu menu = new Menu(new String[]{"🆕 Create new training plan", "🪄 Generate training plan", "👀 View all training plans", "🚪 Return"});
            menu.setHandler(1, this::generatePlanView);
            shouldExit = !menu.run();
        }
    }

    private void generatePlanView(){
        System.out.println("\n===========================");
        System.out.println(" Generate Training Plan 🪄");
        System.out.println("===========================");

        System.out.println("Please enter the following details to generate a training plan:");

        Input input = new Input();
        System.out.println("When do you plan on executing this plan?");
        LocalDate startDate = input.getDate();
        int uniqueActivitiesCount = -1;
        
        while(uniqueActivitiesCount <= 0 || uniqueActivitiesCount > 15){
            System.out.println("How many unique activities should the plan contain?");
            uniqueActivitiesCount = input.getInt();
            if(uniqueActivitiesCount <= 0 || uniqueActivitiesCount > 15){
                System.out.println("Please enter a number between 1 and 15.");
            }
        }

        int occupiedSlots = 0;
        Map<Class<? extends Activity>, Integer> activities = new HashMap<>();
        for(int i = 0; i < uniqueActivitiesCount && occupiedSlots < 21; i++){
            Class<? extends Activity> pickedActivity = null;
            while(pickedActivity == null || activities.containsKey(pickedActivity)){
                pickedActivity = activityPicker();
                if(activities.containsValue(pickedActivity)){
                    System.out.println("This activity is already in the plan.");
                }
            }

            System.out.println("How many times should this activity be repeated?");
            int repeatCount = -1;
            while(repeatCount <= 0 || occupiedSlots + repeatCount > 21){
                repeatCount = input.getInt();
                if(repeatCount <= 0 || occupiedSlots + repeatCount > 21){
                    System.out.println("Please enter a number between 1 and " + (21 - occupiedSlots));
                }
            }
            activities.put(pickedActivity, repeatCount);
            occupiedSlots += repeatCount;
        }

        int spacing = 21 / occupiedSlots;
        TrainingPlan plan = new TrainingPlan(startDate.atTime(9, 0));
        int index = 0;
        while(occupiedSlots > 0){
            int randomIndex = (int)(Math.random() * activities.size());

            Class<? extends Activity> activity = activities.keySet().toArray(new Class[0])[randomIndex];
            int repeatCount = activities.get(activity);
            if(repeatCount == 1){
                activities.remove(activity);
            } else {
                activities.put(activity, repeatCount - 1);
            }

            int hour = index % 3 == 0 ? 9 : ((index % 3) == 1 ? 17 : 19);
            LocalDateTime time = startDate.plusDays(index / 3).atTime(hour, 0);
            System.out.println("Adding " + activity.getSimpleName() + " at " + time);
            index += spacing;
            occupiedSlots--;
        }
    }

    private Class<? extends Activity> activityPicker(){
        System.out.println("Please select an activity:");
        
        List<ActivityType> options = new ArrayList<>();
        for(ActivityType type : ActivityType.values()){
            options.add(type);
        }
        
        Menu menu = new Menu(options.stream().map(type -> type.getIcon() + " " + type.getName()).toArray(String[]::new));
        int chosenIndex = menu.runSimple();

        List<ActivityTypeImplentation> activities = new ArrayList<>();
        for(ActivityTypeImplentation activity : options.get(chosenIndex).getImplementations()){
            activities.add(activity);
        }

        Menu activityMenu = new Menu(activities.stream().map(activity -> activity.getIcon() + " " + activity.getName()).toArray(String[]::new));
        
        System.out.println("Please select an activity:");
        
        int chosenActivityIndex = activityMenu.runSimple();

        return activities.get(chosenActivityIndex).getType();
    }
}
