package models.spells;

import interfaces.Witchable;

/**
 * Represents a fog spell that can be cast on a witchable object.
 */
public class FogSpell extends Spell {

    @Override
    public void bewitch(Witchable witchable) {
        witchable.bewitchFog();
    }

}