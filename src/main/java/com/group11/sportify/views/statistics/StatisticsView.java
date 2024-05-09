package com.group11.sportify.views.statistics;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.group11.sportify.Sportify;
import com.group11.sportify.activities.Activity;
import com.group11.sportify.activities.ActivityType.ActivityTypeImplentation;
import com.group11.sportify.activities.exceptions.ActivityDoesntExistException;
import com.group11.sportify.plans.TrainingPlan;
import com.group11.sportify.plans.exceptions.TrainingPlanDoesntExistException;
import com.group11.sportify.users.User;
import com.group11.sportify.users.exceptions.UserDoesntExistException;
import com.group11.sportify.views.View;
import com.group11.sportify.views.components.Input;
import com.group11.sportify.views.components.Menu;

public class StatisticsView implements View {

    private Sportify sportifyApplication;
    private List<String> statistics;

    /**
     * Default constructor for the StatisticsView class.
     *
     * @param sportifyApplication The Sportify application.
     */
    public StatisticsView(Sportify sportifyApplication) {
        this.sportifyApplication = sportifyApplication;
        this.statistics = new ArrayList<String>();
        this.statistics.add("💪 User with most calories burned in a period or overall");
        this.statistics.add("🏆 User with most activities in a period or overall");
        this.statistics.add("📈 Most performed activity type");
        this.statistics.add("🏃 Total distance covered by a user in a period or overall");
        this.statistics.add("⛰️  Total altitude accumulated by a user in a period or overall");
        this.statistics.add("🏋  Most demanding training plan");
        this.statistics.add("📋 List user activities");
    }

    @Override
    public void show() {
        StatisticsMenu();
    }

    /**
     * Shows the statistics menu of the application.
     */
    public void StatisticsMenu() {
        boolean shouldExit = false;
        while (!shouldExit) {
            System.out.println("\n===================");
            System.out.println("    Statistics 📊   ");
            System.out.println("===================");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime currentTime = sportifyApplication.getController().getTimeController().getCurrentDateTime();
            System.out.println("It's " + currentTime.format(dtf) + ".\n");

            List<String> options = new ArrayList<>();
            for (String statistic : statistics) {
                options.add(statistic);
            }
            options.add("🚪 Return");

            Menu menu = new Menu(options.toArray(new String[0]));

            for (int i = 0; i < statistics.size(); i++) {
                int index = i;
                menu.setHandler(i, () -> {
                    try {
                        runStatistics(index);
                    } catch (ActivityDoesntExistException e) {
                        System.out.println("An error occurred: Activity doesn't exist.");
                        return;
                    } catch (TrainingPlanDoesntExistException e) {
                        System.out.println("An error occurred: Training Plan doesn't exist.");
                        return;
                    } catch (UserDoesntExistException e) {
                        System.out.println("An error occurred: User not found.");
                        return;
                    }
                });
            }
            shouldExit = !menu.run();
        }
    }

    /**
     * Runs the statistics based on the selected index.
     *
     * @param index The index of the selected statistic.
     * @throws ActivityDoesntExistException     If the activity doesn't exist.
     * @throws TrainingPlanDoesntExistException If the training plan doesn't exist.
     * @throws UserDoesntExistException         If the user doesn't exist.
     */
    private void runStatistics(int index)
            throws ActivityDoesntExistException, TrainingPlanDoesntExistException, UserDoesntExistException {
        if (index == 0 || index == 1) {
            runStatisticsWithDates(index, 0);
        } else if (index == 2 || index == 5) {
            runStatisticsAnswer(index, 0);
        } else {
            runStatisticsWithUserCode(index);
        }
    }

    /**
     * Runs the statistics with user code for the specified index.
     *
     * @param index The index of the selected statistic.
     * @throws ActivityDoesntExistException     If the activity doesn't exist.
     * @throws TrainingPlanDoesntExistException If the training plan doesn't exist.
     * @throws UserDoesntExistException         If the user doesn't exist.
     */
    private void runStatisticsWithUserCode(int index)
            throws ActivityDoesntExistException, TrainingPlanDoesntExistException, UserDoesntExistException {
        System.out.println("\n=====================================");
        System.out.println(statistics.get(index));
        System.out.println("=====================================");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime currentTime = sportifyApplication.getController().getTimeController().getCurrentDateTime();
        System.out.println("It's " + currentTime.format(dtf) + ".\n");

        System.out.println("Please enter your account code:");
        Input codeInput = new Input();
        int userCode = codeInput.getInt();
        User user;
        try {
            user = sportifyApplication.getController().getUserController().getUser(userCode);
        } catch (Exception ex) {
            System.out.println("❌ User not found.\n");
            return;
        }
        if (index == 6) { // done
            runStatisticsAnswer(index, userCode);
        } else { // 3 and 4
            runStatisticsWithDates(index, userCode);
        }
    }

    /**
     * Runs the statistics with dates for the specified index and user code.
     *
     * @param index    The index of the selected statistic.
     * @param userCode The code of the user.
     */
    private void runStatisticsWithDates(int index, int userCode) {
        boolean shouldExit = false;
        while (!shouldExit) {
            System.out.println("\n=====================================");
            System.out.println(statistics.get(index));
            System.out.println("=====================================");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime currentTime = sportifyApplication.getController().getTimeController().getCurrentDateTime();
            System.out.println("It's " + currentTime.format(dtf) + ".\n");

            Menu menu = new Menu(new String[] { "🕖 At the moment", "📆 Between Dates", "🚪 Return" });
            LocalDateTime start = sportifyApplication.getController().getTimeController().getApllicationStartDateTime();
            LocalDateTime end = sportifyApplication.getController().getTimeController().getCurrentDateTime();
            menu.setHandler(0, () -> {
                try {
                    runStatisticsDatesAnswer(index, userCode, start, end);
                } catch (UserDoesntExistException | ActivityDoesntExistException e) {
                    System.out.println("An error ocurred");
                }
            });
            menu.setHandler(1, () -> {
                try {
                    runStatisticsBetweenDates(index, userCode);
                } catch (UserDoesntExistException | ActivityDoesntExistException e) {
                    System.out.println("An error ocurred");
                }
            });
            shouldExit = !menu.run();
        }
    }

    /**
     * Runs the statistics between specified dates for the given index and user
     * code.
     *
     * @param index    The index of the selected statistic.
     * @param userCode The code of the user.
     * @throws ActivityDoesntExistException 
     * @throws UserDoesntExistException 
     */
    private void runStatisticsBetweenDates(int index, int userCode) throws UserDoesntExistException, ActivityDoesntExistException {
        System.out.println("\n=====================================");
        System.out.println(statistics.get(index));
        System.out.println("=====================================");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime currentTime = sportifyApplication.getController().getTimeController().getCurrentDateTime();
        System.out.println("It's " + currentTime.format(dtf) + ".\n");

        System.out.println("Please enter the start date:");
        Input codeInput = new Input();
        LocalDateTime startDate = codeInput.getDateTime();
        System.out.println("\nPlease enter the end date:");
        LocalDateTime endDate = codeInput.getDateTime();

        runStatisticsDatesAnswer(index, userCode, startDate, endDate);
    }

    /**
     * Displays the statistics answer for the given index, user code, start date,
     * and end date.
     *
     * @param index    The index of the selected statistic.
     * @param userCode The code of the user.
     * @param start    The start date and time.
     * @param end      The end date and time.
     * @throws ActivityDoesntExistException
     * @throws UserDoesntExistException
     */
    private void runStatisticsDatesAnswer(int index, int userCode, LocalDateTime start, LocalDateTime end) throws UserDoesntExistException, ActivityDoesntExistException {
        boolean shouldExit = false;
        while (!shouldExit) {
            System.out.println("\n=====================================");
            System.out.println(statistics.get(index));
            System.out.println("=====================================");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime currentTime = sportifyApplication.getController().getTimeController().getCurrentDateTime();
            System.out.println("It's " + currentTime.format(dtf) + ".\n");

            User user;

            if (index == 0) {
                try {
                    user = sportifyApplication.getController().getUserWithMostCalories(start, end);
                } catch (ActivityDoesntExistException e) {
                    System.out.println("An error occurred: Activity doesn't exist.");
                    return;
                }
                System.out.println(user);
            }
            if (index == 1) {
                user = sportifyApplication.getController().getUserWithMostActivitiesBetweenDates(start, end);
                if (user == null)
                    System.out.println("Nothing to show");
                else
                    System.out.println(user);
            }

            if (index == 3) {
                double distance = 0;
                try {
                    user = sportifyApplication.getController().getUserController().getUser(userCode);
                } catch (UserDoesntExistException e) {
                    System.out.println("An error occurred: User not found.");
                    return;
                }
                try {
                    distance = sportifyApplication.getController().getTotalDistanceUser(user, start, end);
                } catch (ActivityDoesntExistException e) {
                    System.out.println("An error occurred: Activity doesn't exist.");
                    return;
                }

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                String formattedStart = start.format(formatter);
                String formattedEnd = end.format(formatter);

                System.out.println(
                        "The user " + userCode + " covered " + distance + " meters during this time period, from "
                                + formattedStart + " to " + formattedEnd + ".");
            }

            if (index == 4) {
                double distance = 0;
                try {
                    user = sportifyApplication.getController().getUserController().getUser(userCode);
                } catch (UserDoesntExistException e) {
                    System.out.println("An error occurred: User not found.");
                    return;
                }
                try {
                    distance = sportifyApplication.getController().getTotalAltitudeUser(user, start, end);
                } catch (ActivityDoesntExistException e) {
                    System.out.println("An error occurred: Activity doesn't exist.");
                    return;
                }
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                String formattedStart = start.format(formatter);
                String formattedEnd = end.format(formatter);

                System.out.println(
                        "The user " + userCode + " covered " + distance + " meters in altitude during this time period, from "
                                + formattedStart + " to " + formattedEnd + ".");
            }

            Menu menu = new Menu(new String[] { "🚪 Return" });
            shouldExit = !menu.run();
        }
    }

    /**
     * Displays the statistics answer for the given index and user.
     *
     * @param index The index of the selected statistic.
     * @param user  The user for whom the statistics are displayed.
     * @throws ActivityDoesntExistException     If the activity doesn't exist.
     * @throws TrainingPlanDoesntExistException If the training plan doesn't exist.
     * @throws UserDoesntExistException         If the user doesn't exist.
     */
    private void runStatisticsAnswer(int index, int user)
            throws ActivityDoesntExistException, TrainingPlanDoesntExistException, UserDoesntExistException {
        boolean shouldExit = false;
        while (!shouldExit) {
            System.out.println("\n=====================================");
            System.out.println(statistics.get(index));
            System.out.println("=====================================");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime currentTime = sportifyApplication.getController().getTimeController().getCurrentDateTime();
            System.out.println("It's " + currentTime.format(dtf) + ".\n");

            if (index == 2) {
                ActivityTypeImplentation activityType = sportifyApplication.getController().getMostPracticedActivity();
                System.out.println("The most practiced activity in the application is " + activityType.getName() + " " + activityType.getIcon());
            }
            if (index == 5) {
                User userU;
                try {
                    userU = sportifyApplication.getController().getUserController().getUser(user);
                } catch (UserDoesntExistException e) {
                    System.out.println("An error occurred: User not found.");
                    return;
                }
                TrainingPlan tp = null;
                try {
                    tp = sportifyApplication.getController().getMostEffectiveTrainingPlanBurningCalories(userU);
                } catch (ActivityDoesntExistException e) {
                    System.out.println("An error occurred: Activity not found.");
                    return;
                } catch (TrainingPlanDoesntExistException e){
                    System.out.println("An error ocurred: TrainingPlan not found");
                }
                System.out.println("The most effective training plan is: " + tp.toString());
            }

            if (index == 6) {
                List<Activity> activities;
                activities = sportifyApplication.getController().getUserActivities(user);

                if (activities.isEmpty()) {
                    System.out.println("No activities found for this user.");
                } else {
                    System.out.println("Activities for user " + user + ":");
                    for (Activity activity : activities) {
                        System.out.println(activity);
                    }
                }
            }

            Menu menu = new Menu(new String[] { "🚪 Return" });
            shouldExit = !menu.run();
        }
    }

}
