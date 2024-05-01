package com.group11.sportify.views.main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.group11.sportify.Sportify;
import com.group11.sportify.users.User;
import com.group11.sportify.views.View;
import com.group11.sportify.views.components.Input;
import com.group11.sportify.views.components.Menu;
import com.group11.sportify.views.user.UserView;

/**
 * The MainView class represents the main view of the application.
 */
public class MainView implements View {

    private Sportify sportifyApplication;

    /**
     * Default constructor for the MainView class.
     * @param sportifyApplication The Sportify application.
     */
    public MainView(Sportify sportifyApplication) {
        this.sportifyApplication = sportifyApplication;
    }

    @Override
    public void show() {
        mainMenu();
    }

    /**
     * Shows the main menu of the application.
     */
    public void mainMenu(){
        boolean shouldExit = false;
        while(!shouldExit) {
            System.out.println("\n===================");
            System.out.println("    Sportify 🥇   ");
            System.out.println("===================");
            System.out.println("Welcome to Sportify, your best fit buddy!");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime currentTime = sportifyApplication.getController().getTimeController().getCurrentDateTime();
            System.out.println("It's " + currentTime.format(dtf) + ".\n");

            Menu menu = new Menu(new String[]{"👤 Load Account", "📝 Create Account", "👑 Admin", "🚪 Exit"});
            menu.setHandler(0, this::loadAccountMenu);
            shouldExit = !menu.run();
        }
    }

    /**
     * Account menu loading view.
     */
    public void loadAccountMenu(){
        System.out.println("\n===================");
        System.out.println("  Load Account 👤");
        System.out.println("===================");
        System.out.println("Please enter your account code:");
        Input codeInput = new Input();
        int userCode = codeInput.getInt();
        User user;
        try {
            user = sportifyApplication.getController().getUserController().getUser(userCode);
        } catch(Exception ex){
            System.out.println("❌ User not found.\n");
            return;
        }

        UserView userView = new UserView(user, sportifyApplication);
        userView.show();
    }
}
