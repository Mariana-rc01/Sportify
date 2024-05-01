package com.group11.sportify.activities;

import java.time.LocalDateTime;

/**
 * The ActivityProperty enum represents the properties of an activity.
 */
public enum ActivityProperty {
    DESCRIPTION(String.class, "Activity description"),
    TIME_SPENT(Integer.class, "Time spent during the activity in minutes"),
    AVERAGE_HEART_RATE(Integer.class, "Average heart rate during the activity"),
    DATE(LocalDateTime.class, "Date of the activity"),
    REPETITIONS(Integer.class, "Number of repetitions of the exercise"),
    WEIGHT(Double.class, "Total weight (Kg) used during the activity"),
    DISTANCE(Double.class, "Distance (meters) covered during the activity"),
    ALTITUDE(Double.class, "Altitude (meters) covered during the activity");

    private final Class<?> type;
    private final String description;

    /**
     * Constructor for the ActivityProperty enum.
     * @param type The type of the property.
     * @param description The description of the property.
     */
    ActivityProperty(Class<?> type, String description) {
        this.type = type;
        this.description = description;
    }

    /**
     * Gets the type of the property.
     * @return The type of the property.
     */
    public Class<?> getType() {
        return type;
    }

    /**
     * Gets the description of the property.
     * @return The description of the property.
     */
    public String getDescription() {
        return description;
    }
}
