package interfaces;

import models.pokemons.Pokemon;

/**
 * Hostile interface represents an entity that can attack a Pokemon.
 */
public interface Hostile {

	/**
	 * This method is used to attack a Pokemon.
	 * 
	 * @param pokemon The Pokemon to be attacked.
	 */
	void attack(Pokemon pokemon);

	void afterAttack();
}
