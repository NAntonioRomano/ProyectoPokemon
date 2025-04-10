package spells;

import interfaces.Witchable;

public class Wind extends Spell {

    @Override
    protected void bewitch(Witchable witchable) {
        witchable.bewitchWind();
    }

}
