package spells;

import interfaces.Witchable;

public class Storm extends Spell {

    @Override
    protected void bewitch(Witchable witchable) {
        witchable.bewitchStorm();
    }

}
