package models.weapons;

import models.pokemons.Pokemon;

/**
 * The Sword class represents a weapon that can be used to attack a Pokemon.
 * It extends the Weapon class and provides a specific implementation for the
 * attack method.
 */
public class Sword extends Weapon {

	/**
	 * Constructs a Sword object with a specific damage value.
	 * The damage value is set to 50.
	 */
	public Sword() {
		super(50);
	}

	@Override
	public void attack(Pokemon pokemon) {
		pokemon.receiveDamage(100);
	}

}
