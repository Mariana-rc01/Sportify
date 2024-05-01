package com.group11.sportify.activities.repeating;

import com.group11.sportify.activities.Activity;
import com.group11.sportify.activities.ActivityType.ActivityTypeImplentation;

/**
 * The TypesRepeating enum represents the different types of repeating activities.
 */
public enum TypesRepeating implements ActivityTypeImplentation {
    BURPEE("Burpee", "🏋️", Burpee.class),
    JUMPING_JACKS("Jumping jacks", "🤸", JumpingJack.class),
    PUSH_UP("Push-ups", "🏋️", PushUp.class),
    SIT_UP("Sit-ups", "🏋️", SitUp.class),
    STRETCH("Stretch", "🧘", Stretch.class);

    private final String name;
    private final String icon;
    private final Class<? extends Activity> type;

    /**
     * Constructor for the TypesRepeating enum.
     * @param name The name of the repeating activity.
     * @param icon The icon of the repeating activity.
     * @param type The type of the repeating activity.
     */
    TypesRepeating(String name, String icon, Class<? extends Activity> type) {
        this.name = name;
        this.icon = icon;
        this.type = type;
    }

    /**
     * Gets the name of the repeating activity.
     * @return The name of the repeating activity.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Gets the icon of the repeating activity.
     * @return The icon of the repeating activity.
     */
    @Override
    public String getIcon() {
        return icon;
    }

    /**
     * Gets the type of the repeating activity.
     * @return The type of the repeating activity.
     */
    @Override
    public Class<? extends Activity> getType() {
        return type;
    }
}
