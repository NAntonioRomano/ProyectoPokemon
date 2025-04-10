package weapons;

import pokemons.Pokemon;

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

}