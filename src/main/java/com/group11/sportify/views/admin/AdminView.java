package com.group11.sportify.views.admin;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.group11.sportify.Sportify;
import com.group11.sportify.views.View;
import com.group11.sportify.views.components.Menu;
import com.group11.sportify.views.statistics.StatisticsView;

public class AdminView implements View {

    private Sportify sportifyApplication;

    /**
     * Default constructor for the AdminView class.
     *
     * @param sportifyApplication The Sportify application.
     */
    public AdminView(Sportify sportifyApplication) {
        this.sportifyApplication = sportifyApplication;
    }

    @Override
    public void show() {
        adminMenu();
    }

    /**
     * Shows the admin menu of the application.
     */
    public void adminMenu() {
        boolean shouldExit = false;
        while (!shouldExit) {
            System.out.println("\n===================");
            System.out.println("    Admin 👑   ");
            System.out.println("===================");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime currentTime = sportifyApplication.getController().getTimeController().getCurrentDateTime();
            System.out.println("It's " + currentTime.format(dtf) + ".\n");

            Menu menu = new Menu(new String[] { "📊 View Statistics", "🗑️  Clear Data", "⌛ Skip Time", "🚪 Return" });
            menu.setHandler(0, this::runStatisticsView);
            menu.setHandler(1, () -> {
                runClearData();
                System.out.println("\nClear Data successfully!");
            });
            menu.setHandler(2, this::runSkipTimeView);
            shouldExit = !menu.run();
        }
    }

    /**
     * Runs the statistics view.
     */
    public void runStatisticsView() {
        StatisticsView statisticsView = new StatisticsView(sportifyApplication);
        statisticsView.show();
    }

    /**
     * Runs the statistics view.
     */
    public void runSkipTimeView() {
        SkipTimeView skipTimeView = new SkipTimeView(sportifyApplication);
        skipTimeView.show();
    }

    public void runClearData() {
        sportifyApplication.getController().clearData();
    }
}
