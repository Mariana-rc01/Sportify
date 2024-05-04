package com.group11.sportify.views.user;

import com.group11.sportify.Sportify;
import com.group11.sportify.users.User;
import com.group11.sportify.users.UserController;
import com.group11.sportify.views.View;
import com.group11.sportify.views.components.Input;
import com.group11.sportify.views.components.Menu;

public class NewUserView implements View {
    private Sportify sportifyApplication;

    /**
     * Default constructor for the UserView class.
     * @param sportifyApplication The Sportify application.
     */
    public NewUserView(Sportify sportifyApplication) {
        this.sportifyApplication = sportifyApplication;
    }

    @Override
    public void show() {
        newUserMenu();
    }

    /**
     * Shows the new user menu.
     */
    public void newUserMenu(){
        UserController userController = sportifyApplication.getController().getUserController();

        System.out.println("\n=====================");
        System.out.println("  Create Account 📝");
        System.out.println("=====================");
        System.out.println("Hello! As you're new around here, we need you to fill out the following form in order to create your account! \uD83E\uDD29");

        Input input = new Input();

        System.out.println("\nPlease enter your name:");
        String name = input.getString();

        System.out.println("\nPlease enter your email:");
        String email = input.getString();

        System.out.println("\nPlease enter your address:");
        String address = input.getString();

        System.out.println("\nPlease enter your average heart rate:");
        int averageHeartRate = input.getInt();

        System.out.println("\nPlease enter your weight:");
        double weight = input.getDouble();

        System.out.println("\nPlease enter your height:");
        double height = input.getDouble();

        System.out.println("\nPlease select your level:");
        Menu menu = new Menu(new String[]{"\uD83D\uDFE2 Amateur", "\uD83D\uDFE1 Casual", "\uD83D\uDD34 Professional"});
        menu.setHandler(0, ()->{createAndLoadUserMenu(userController.insertUserAmateur(name, address, email, averageHeartRate, weight, height), this.sportifyApplication);});
        menu.setHandler(1, ()->{createAndLoadUserMenu(userController.insertUserCasual(name, address, email, averageHeartRate, weight, height), this.sportifyApplication);});
        menu.setHandler(2, ()->{createAndLoadUserMenu(userController.insertUserProfessional(name, address, email, averageHeartRate, weight, height), this.sportifyApplication);});
        menu.run();
    }

    /**
     * Create and load the user menu.
     * @param user The user.
     * @param sportifyApplication The Sportify application.
     */
    public void createAndLoadUserMenu(User user, Sportify sportifyApplication){
        UserView userView = new UserView(user, sportifyApplication);
        System.out.println("\nYour account code is " + user.getCode() +", thank you for joining us! ✨");
        userView.show();
    }
}
