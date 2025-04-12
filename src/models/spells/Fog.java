package models.spells;

import interfaces.Witchable;

public class Fog extends Spell {

    @Override
    public void bewitch(Witchable witchable) {
        witchable.bewitchFog();
    }

}