package models.spells;

import interfaces.Witchable;

/**
 * Abstract class representing a spell.
 */
public abstract class Spell {

    /**
     * This method is used to bewitch a witchable object.
     *
     * @param witchable The witchable object to be bewitched.
     */
    public abstract void bewitch(Witchable witchable);

}
