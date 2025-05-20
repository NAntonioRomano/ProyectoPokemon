package model.interfaces;

import model.models.pokemons.Pokemon;

public interface Hostile {

	/**
	 * This method is used to attack a Pokemon.
	 * precionditions: pokemon != null
	 * 
	 * @param pokemon The Pokemon to be attacked.
	 */
	void attack(Pokemon pokemon);

	/**
	 * This method is called after an attack.
	 */
	default void afterAttack() {
	}
}
