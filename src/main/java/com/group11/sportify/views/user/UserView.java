package com.group11.sportify.views.user;

import com.group11.sportify.Sportify;
import com.group11.sportify.users.User;
import com.group11.sportify.views.View;
import com.group11.sportify.views.activities.ActivityView;
import com.group11.sportify.views.components.Menu;

/**
 * The UserView class represents the view of the user.
 */
public class UserView implements View {

    private User currentUser;
    private Sportify sportifyApplication;

    /**
     * Default constructor for the UserView class.
     * @param currentUser The current user.
     * @param sportifyApplication The Sportify application.
     */
    public UserView(User currentUser, Sportify sportifyApplication) {
        this.currentUser = currentUser;
        this.sportifyApplication = sportifyApplication;
    }

    @Override
    public void show() {
        userMenu();
    }

    /**
     * Shows the user menu.
     */
    public void userMenu(){
        boolean shouldExit = false;
        while(!shouldExit){
            System.out.println("\n===================");
            System.out.println("    User Menu 👤   ");
            System.out.println("===================");
            System.out.println("Welcome " + currentUser.getName() + "!");
            System.out.println("What would you like to do today?\n");

            Menu menu = new Menu(new String[]{"🤾‍ Activities", "🍎 Training Plans", "🚪 Sign Out"});
            menu.setHandler(0, this::runUserActivityView);
            shouldExit = !menu.run();
        }
    }

    /**
     * Runs the user activity view.
     */
    public void runUserActivityView(){
        ActivityView activityView = new ActivityView(currentUser, sportifyApplication);
        activityView.show();
    }
}
