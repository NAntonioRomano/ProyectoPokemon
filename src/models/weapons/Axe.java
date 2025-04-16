package models.weapons;

import models.pokemons.Pokemon;

/**
 * Axe class that extends the Weapon class.
 * This class represents an axe weapon with a specific attack power.
 */
public class Axe extends Weapon {

    /**
     * Constructor for the Axe class.
     */
    public Axe() {
        super(80);
    }

    @Override
    public void attack(Pokemon pokemon) {
        int min = 50;
        int max = 150;
        pokemon.receiveDamage(Math.random() * (max - min) + min);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Axe cannot be cloned");
    }

}