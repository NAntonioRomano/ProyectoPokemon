package spells;

import interfaces.Witchable;

public class Fog extends Spell {

    @Override
    protected void bewitch(Witchable witchable) {
        witchable.bewitchFog();
    }

}