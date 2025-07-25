package model.entities.weapons;

import model.entities.pokemons.Pokemon;

public class Axe extends Weapon {

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

    @Override
    public String toString() {
        return "Axe [Min Attack: " + 50 + " Max Attack: " + 150 + " Cost: " + getCost() + "]";
    }

}
