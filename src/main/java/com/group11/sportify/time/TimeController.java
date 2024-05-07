package com.group11.sportify.time;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Class that controls the time of the application.
 */
public class TimeController implements Serializable {
    private LocalDateTime currentDateTime;
    private LocalDateTime applicationStartDateTime;

    /**
     * Default constructor for the TimeController class.
     */
    public TimeController() {
        currentDateTime = LocalDateTime.now();
        applicationStartDateTime = currentDateTime;
    }

    /**
     * Constructor for the TimeController class.
     * 
     * @param currentDateTime The current date and time of the application.
     */
    public LocalDateTime getCurrentDateTime() {
        return currentDateTime;
    }

    /**
     * Gets the date and time when the application started.
     * 
     * @return The date and time when the application started.
     */
    public LocalDateTime getApllicationStartDateTime() {
        return applicationStartDateTime;
    }

    /**
     * Skips n hours from the appliation time.
     * 
     * @param hours The number of hours to skip.
     */
    public void skipTime(int hours) {
        currentDateTime = currentDateTime.plusHours(hours);
    }

    /**
     * Skips n days from the appliation time.
     * 
     * @param days  The number of days to skip.
     * @param hours The number of hours to skip.
     */
    public void skipTime(int days, int hours) {
        currentDateTime = currentDateTime.plusDays(days).plusHours(hours);
    }

    /**
     * Skips n months from the appliation time.
     * 
     * @param months The number of months to skip.
     * @param days   The number of days to skip.
     * @param hours  The number of hours to skip.
     */
    public void skipTime(int months, int days, int hours) {
        currentDateTime = currentDateTime.plusMonths(months).plusDays(days).plusHours(hours);
    }

    /**
     * Skips to a specific date.
     *
     * @param date New date.
     */
    public void skipTime(LocalDateTime date) {
        currentDateTime = date;
    }

    /**
     * Clears all time-related data from the TimeController.
     */
    public void clearTimeData() {
        currentDateTime = LocalDateTime.now();
        applicationStartDateTime = LocalDateTime.now();
    }
}
