package model.entities.spells;

import model.interfaces.Witchable;

public class StormSpell extends Spell {

    @Override
    public void bewitch(Witchable witchable) {
        witchable.bewitchStorm();
    }

}
