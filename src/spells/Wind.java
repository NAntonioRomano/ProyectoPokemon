package spells;

import interfaces.Witchable;

public class Wind extends Spell {

    @Override
    public void bewitch(Witchable witchable) {
        witchable.bewitchWind();
    }

}
