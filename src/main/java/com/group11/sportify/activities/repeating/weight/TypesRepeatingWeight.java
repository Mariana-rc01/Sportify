package com.group11.sportify.activities.repeating.weight;

import com.group11.sportify.activities.Activity;
import com.group11.sportify.activities.ActivityType.ActivityTypeImplentation;

/**
 * The TypesRepeatingWeight enum represents the different types of repeating weight activities.
 */
public enum TypesRepeatingWeight implements ActivityTypeImplentation {
    LEG_EXTENSION("Leg extension", "🏋️", LegExtension.class),
    WEIGHTLIFTING("Weightlifting", "🏋️", Weightlifting.class);

    private final String name;
    private final String icon;
    private final Class<? extends Activity> type;

    /**
     * Constructor for the TypesRepeatingWeight enum.
     * @param name The name of the repeating weight activity.
     * @param icon The icon of the repeating weight activity.
     * @param type The type of the repeating weight activity.
     */
    TypesRepeatingWeight(String name, String icon, Class<? extends Activity> type) {
        this.name = name;
        this.icon = icon;
        this.type = type;
    }

    /**
     * Gets the name of the repeating weight activity.
     * @return The name of the repeating weight activity.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Gets the icon of the repeating weight activity.
     * @return The icon of the repeating weight activity.
     */
    @Override
    public String getIcon() {
        return icon;
    }

    /**
     * Gets the type of the repeating weight activity.
     * @return The type of the repeating weight activity.
     */
    @Override
    public Class<? extends Activity> getType() {
        return type;
    }
}
