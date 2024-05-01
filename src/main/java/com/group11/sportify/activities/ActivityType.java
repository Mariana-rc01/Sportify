package com.group11.sportify.activities;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.group11.sportify.activities.distance.TypesDistance;
import com.group11.sportify.activities.distance.altitude.TypesDistanceAltitude;
import com.group11.sportify.activities.repeating.TypesRepeating;
import com.group11.sportify.activities.repeating.weight.TypesRepeatingWeight;

/**
 * Enum representing the different types of activities.
 */
public enum ActivityType {
    REPEATING("Repeating", "This type of activity is executed as a series of repetitions.", "🔁", TypesRepeating.values()),
    REPEATING_WEIGHTS("Repeating with weights", "This type of activity is is executed as a series of repetitions with weights.", "🏋️", TypesRepeatingWeight.values()),
    DISTANCE("Distance", "This type of activity is distance-based.", "🏃", TypesDistance.values()),
    DISTANCE_ALTITUDE("Distance and altitude", "This type of activity is distance and altitude-based.", "🚵", TypesDistanceAltitude.values());

    /**
     * Interface representing the implementation of an activity type.
     */
    public interface ActivityTypeImplentation {
        String getName();
        String getIcon();
        Class<? extends Activity> getType();
    }

    private final String name;
    private final String description;
    private final String icon;
    private final ActivityTypeImplentation[] implementations;

    /**
     * Constructor for the ActivityType enum.
     * @param name The name of the activity type.
     * @param description The description of the activity type.
     * @param icon The icon of the activity type.
     * @param implementations The implementations of the activity type.
     */
    ActivityType(String name, String description, String icon, ActivityTypeImplentation... implementations) {
        this.name = name;
        this.description = description;
        this.icon = icon;
        this.implementations = implementations;
    }

    /**
     * Gets the name of the activity type.
     * @return The name of the activity type.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the description of the activity type.
     * @return The description of the activity type.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the icon of the activity type.
     * @return The icon of the activity type.
     */
    public String getIcon() {
        return icon;
    }

    /**
     * Gets the implementations of the activity type.
     * @return The implementations of the activity type.
     */
    public ActivityTypeImplentation[] getImplementations() {
        return implementations;
    }

    /*
     * Gets the properties of the activity type.
     * 
     * @return The properties of the activity type.
     */
    public List<ActivityProperty> getProperties() {
        return switch(this) {
            case REPEATING -> List.of(ActivityProperty.DESCRIPTION, ActivityProperty.TIME_SPENT, ActivityProperty.AVERAGE_HEART_RATE, ActivityProperty.DATE, ActivityProperty.REPETITIONS);
            case REPEATING_WEIGHTS -> List.of(ActivityProperty.DESCRIPTION, ActivityProperty.TIME_SPENT, ActivityProperty.AVERAGE_HEART_RATE, ActivityProperty.DATE, ActivityProperty.REPETITIONS, ActivityProperty.WEIGHT);
            case DISTANCE -> List.of(ActivityProperty.DESCRIPTION, ActivityProperty.TIME_SPENT, ActivityProperty.AVERAGE_HEART_RATE, ActivityProperty.DATE, ActivityProperty.DISTANCE);
            case DISTANCE_ALTITUDE -> List.of(ActivityProperty.DESCRIPTION, ActivityProperty.TIME_SPENT, ActivityProperty.AVERAGE_HEART_RATE, ActivityProperty.DATE, ActivityProperty.DISTANCE, ActivityProperty.ALTITUDE);
        };
    }
}
