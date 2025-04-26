package models;

import java.util.ArrayList;
import java.util.List;

import exceptions.TrainerWithoutPokemonsException;
import models.pokemons.Pokemon;

/**
 * TrainerPrepared class represents a trainer with a limited number of pokemon
 * prepared for battle.
 */
public class TrainerPrepared {
	private String name;
	private Pokemon[] pokemons;
	private Trainer trainer;
	private final int maxPokemonsPerFigth = 3;

	/**
	 * Constructor for TrainerPrepared class.
	 * 
	 * @param trainer Trainer object to be prepared.
	 * @throws TrainerWithoutPokemonsException if the trainer has no pokemons.
	 */
	public TrainerPrepared(Trainer trainer) throws TrainerWithoutPokemonsException {
		this.name = trainer.getName();
		List<Pokemon> trainerPokemons = trainer.getPokemons();

		if (trainerPokemons.size() == 0)
			throw new TrainerWithoutPokemonsException(trainer);

		int length = Math.min(maxPokemonsPerFigth, trainerPokemons.size());
		pokemons = new Pokemon[length];

		for (int i = 0; i < length; i++)
			pokemons[i] = trainerPokemons.get(i);

		this.trainer = trainer;
	}

	/**
	 * Getter for the name of the trainer prepared.
	 * 
	 * @return the name of the trainer prepared.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter for array of pokemons.
	 * 
	 * @return the array of pokemons.
	 */
	public Pokemon[] getPokemons() {
		return pokemons;
	}

	/**
	 * Getter for the trainer.
	 * 
	 * @return the trainer.
	 */
	public Trainer getTrainer() {
		return trainer;
	}

	/**
	 * Getter for pokemon of the trainer prepared in espific index.
	 * 
	 * @param index the index of the pokemon.
	 * @return the pokemon in the index.
	 * @throws ArrayIndexOutOfBoundsException if the index is out of bounds.
	 */
	public Pokemon getPokemon(int index) throws ArrayIndexOutOfBoundsException {
		return pokemons[index];
	}

	public Pokemon getRandomPokemon() {

		List<Pokemon> livePokemons = getLivePokemons();

		if (livePokemons.size() == 0)
			return null;

		int randomIndex = (int) (Math.random() * livePokemons.size());

		Pokemon choicePokemon = livePokemons.get(randomIndex);

		System.out
				.println(choicePokemon != null
						? "✅ " + this.getName() + ": Chose " + choicePokemon.getName()
								+ " for battle!"
						: "No more pokemons for " + this.getName());
		return choicePokemon;
	}

	public List<Pokemon> getLivePokemons() {

		List<Pokemon> livePokemons = new ArrayList<>();

		for (Pokemon pokemon : pokemons) {
			if (!pokemon.isDead()) {
				livePokemons.add(pokemon);
			}
		}
		return livePokemons;
	}

	/**
	 * Method to check if the trainer has all pokemons dead.
	 * 
	 * @return true if all pokemons are dead, false otherwise.
	 */
	public boolean allDeadPokemons() {
		for (Pokemon pokemon : pokemons) {
			if (!pokemon.isDead())
				return false;
		}
		return true;
	}

}
