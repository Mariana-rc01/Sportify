package com.group11.sportify;

import java.io.Serializable;

/**
 * The Sportify class represents the application itself.
 */
public class Sportify implements Serializable {
    private SportifyController controller;

    /**
     * Default constructor for the Sportify class.
     */
    public Sportify() {
        controller = new SportifyController();
    }

    /**
     * Gets the controller of the Sportify class.
     * @return The controller of the Sportify class.
     */
    public SportifyController getController() {
        return controller;
    }
}
