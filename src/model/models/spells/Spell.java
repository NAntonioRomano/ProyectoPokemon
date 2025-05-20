package model.models.spells;

import model.interfaces.Witchable;

public abstract class Spell {

    /**
     * This method is used to bewitch a witchable object.
     * preconditions: witchable != null
     * 
     * @param witchable The witchable object to be bewitched.
     */
    public abstract void bewitch(Witchable witchable);

}
