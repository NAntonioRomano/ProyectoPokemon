package spells;

import interfaces.Witchable;

public class Storm extends Spell {

    @Override
    public void bewitch(Witchable witchable) {
        witchable.bewitchStorm();
    }

}
