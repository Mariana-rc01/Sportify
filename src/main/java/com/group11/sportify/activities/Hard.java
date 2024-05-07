package com.group11.sportify.activities;

import java.io.Serializable;

/**
 * This interface represents activities that are considered hard.
 */
public interface Hard extends Serializable {

    /**
     * Checks if the activity is hard.
     * @return True if the activity is hard
     */
    boolean isHard();
}
