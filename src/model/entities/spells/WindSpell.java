package model.entities.spells;

import model.interfaces.Witchable;

public class WindSpell extends Spell {

    @Override
    public void bewitch(Witchable witchable) {
        witchable.bewitchWind();
    }

}
