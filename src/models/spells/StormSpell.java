package models.spells;

import interfaces.Witchable;

/**
 * Represents a storm spell that can be cast on a witchable object.
 */
public class StormSpell extends Spell {

    @Override
    public void bewitch(Witchable witchable) {
        witchable.bewitchStorm();
    }

}
