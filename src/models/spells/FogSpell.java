package models.spells;

import interfaces.Witchable;

public class FogSpell extends Spell {

    @Override
    public void bewitch(Witchable witchable) {
        witchable.bewitchFog();
    }

}
