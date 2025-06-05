package model.models.weapons;

import model.models.pokemons.Pokemon;

public class Sword extends Weapon {

	public Sword() {
		super(50);
	}

	@Override
	public void attack(Pokemon pokemon) {
		pokemon.receiveDamage(100);
	}
	@Override
    public String toString() {
        return "Sword [Attack " + 100 + " Cost: " + getCost() + "]";
    }
}
