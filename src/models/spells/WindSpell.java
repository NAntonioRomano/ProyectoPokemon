package models.spells;

import interfaces.Witchable;

/**
 * Represents a wind spell that can be cast on a witchable object.
 */
public class WindSpell extends Spell {

    @Override
    public void bewitch(Witchable witchable) {
        witchable.bewitchWind();
    }

}
