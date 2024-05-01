package com.group11.sportify.activities.distance;

import com.group11.sportify.activities.Activity;
import com.group11.sportify.activities.ActivityType.ActivityTypeImplentation;

/**
 * The TypesDistance enum represents the different types of distance activities.
 */
public enum TypesDistance implements ActivityTypeImplentation {
    ICE_SKATING("Ice skating", "⛸️", IceSkating.class),
    ROWING("Rowing", "🚣", Rowing.class),
    TRACK_AND_FIELD("Track and field", "🏃", TrackAndField.class);

    private final String name;
    private final String icon;
    private final Class<? extends Activity> type;

    /**
     * Constructor for the TypesDistance enum.
     * @param name The name of the distance activity.
     * @param icon The icon of the distance activity.
     * @param type The type of the distance activity.
     */
    TypesDistance(String name, String icon, Class<? extends Activity> type) {
        this.name = name;
        this.icon = icon;
        this.type = type;
    }

    /**
     * Gets the name of the distance activity.
     * @return The name of the distance activity.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Gets the icon of the distance activity.
     * @return The icon of the distance activity.
     */
    @Override
    public String getIcon() {
        return icon;
    }

    /**
     * Gets the type of the distance activity.
     * @return The type of the distance activity.
     */
    @Override
    public Class<? extends Activity> getType() {
        return type;
    }
}
