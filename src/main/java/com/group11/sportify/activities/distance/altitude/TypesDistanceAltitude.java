package com.group11.sportify.activities.distance.altitude;

import com.group11.sportify.activities.Activity;
import com.group11.sportify.activities.ActivityType.ActivityTypeImplentation;

/**
 * The TypesDistanceAltitude enum represents the different types of distance and altitude activities.
 */
public enum TypesDistanceAltitude implements ActivityTypeImplentation {
    MOUNTAIN_BIKING("Mountain biking", "🚵", MountainBiking.class),
    ROAD_CYCLING("Road cycling", "🚴", RoadCycling.class),
    ROAD_RUNNING("Road running", "🏃", RoadRunning.class),
    TRAIL_RUNNING("Trail running", "🏃", TrailRunning.class);

    private final String name;
    private final String icon;
    private final Class<? extends Activity> type;

    /**
     * Constructor for the TypesDistanceAltitude enum.
     * @param name The name of the distance and altitude activity.
     * @param icon The icon of the distance and altitude activity.
     * @param type The type of the distance and altitude activity.
     */
    TypesDistanceAltitude(String name, String icon, Class<? extends Activity> type) {
        this.name = name;
        this.icon = icon;
        this.type = type;
    }

    /**
     * Gets the name of the distance and altitude activity.
     * @return The name of the distance and altitude activity.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Gets the icon of the distance and altitude activity.
     * @return The icon of the distance and altitude activity.
     */
    @Override
    public String getIcon() {
        return icon;
    }

    /**
     * Gets the type of the distance and altitude activity.
     * @return The type of the distance and altitude activity.
     */
    @Override
    public Class<? extends Activity> getType() {
        return type;
    }
}
