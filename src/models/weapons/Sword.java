package models.weapons;

import models.pokemons.Pokemon;

public class Sword extends Weapon {

	public Sword() {
		super(50);
	}

	@Override
	public void attack(Pokemon pokemon) {
		pokemon.receiveDamage(100);
	}

}
