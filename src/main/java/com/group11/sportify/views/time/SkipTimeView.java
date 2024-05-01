package com.group11.sportify.views.admin;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.group11.sportify.Sportify;
import com.group11.sportify.views.View;
import com.group11.sportify.views.components.Input;
import com.group11.sportify.views.components.Menu;

public class SkipTimeView implements View {

    private Sportify sportifyApplication;

    /**
     * Default constructor for the AdminView class.
     *
     * @param sportifyApplication The Sportify application.
     */
    public SkipTimeView(Sportify sportifyApplication) {
        this.sportifyApplication = sportifyApplication;
    }

    @Override
    public void show() {
        skipTimeMenu();
    }

    /**
     * Shows the admin menu of the application.
     */
    public void skipTimeMenu() {
        boolean shouldExit = false;
        while (!shouldExit) {
            System.out.println("\n===================");
            System.out.println("     SkipTime ⌛   ");
            System.out.println("===================");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime currentTime = sportifyApplication.getController().getTimeController().getCurrentDateTime();
            System.out.println("It's " + currentTime.format(dtf) + ".\n");

            Menu menu = new Menu(new String[] { "📅 Skip to a date", "🗓️ Skip months, days and hours",
                    "🌅 Skip days and hours", "🕝 Skip hours", "🚪 Return" });
            Input codeInput = new Input();
            menu.setHandler(0, () -> {
                LocalDateTime date = codeInput.getDateTime();
                sportifyApplication.getController().getTimeController().skipTime(date);
            });
            menu.setHandler(1, () -> {
                System.out.println("Number of months");
                int months = codeInput.getFutureTime();
                System.out.println("Number of days");
                int days = codeInput.getFutureTime();
                System.out.println("Number of hours");
                int hours = codeInput.getFutureTime();
                sportifyApplication.getController().getTimeController().skipTime(months, days, hours);
            });
            menu.setHandler(2, () -> {
                System.out.println("Number of days");
                int days = codeInput.getFutureTime();
                System.out.println("Number of hours");
                int hours = codeInput.getFutureTime();
                sportifyApplication.getController().getTimeController().skipTime(days, hours);
            });
            menu.setHandler(3, () -> {
                System.out.println("Number of hours");
                int hours = codeInput.getFutureTime();
                sportifyApplication.getController().getTimeController().skipTime(0, hours);
            });
            shouldExit = !menu.run();
        }
    }
}
