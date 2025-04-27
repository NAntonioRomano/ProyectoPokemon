package models;

import java.util.ArrayList;
import java.util.List;

import exceptions.TrainerWithoutPokemonsException;
import models.pokemons.Pokemon;

public class TrainerPrepared {
	private String name;
	private Pokemon[] pokemons;
	private Trainer trainer;
	private final int maxPokemonsPerFigth = 3;

	/**
	 * Constructor for TrainerPrepared class.
	 * preconditions: trainer != null
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

	public String getName() {
		return name;
	}

	public Pokemon[] getPokemons() {
		return pokemons;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	/**
	 * Getter for pokemon of the trainer prepared in espific index.
	 * preconditions: index >= 0
	 * 
	 * @param index the index of the pokemon.
	 * @return the pokemon in the index.
	 * @throws ArrayIndexOutOfBoundsException if the index is out of bounds.
	 */
	public Pokemon getPokemon(int index) throws ArrayIndexOutOfBoundsException {
		return pokemons[index];
	}

	/**
	 * Method to get a random live pokemon from the trainer.
	 * 
	 * @return the random pokemon.
	 */
	public Pokemon getRandomPokemon() {
		List<Pokemon> livePokemons = getLivePokemons();

		if (livePokemons.size() == 0)
			return null;

		int randomIndex = (int) (Math.random() * livePokemons.size());
		Pokemon choosenPokemon = livePokemons.get(randomIndex);
		System.out
				.println(choosenPokemon != null
						? "✅ " + this.getName() + ": Choose " + choosenPokemon.getName()
								+ " for battle!"
						: "No more pokemons for " + this.getName());
		return choosenPokemon;
	}

	/**
	 * Method to get the live pokemons of the trainer.
	 * 
	 * @return the list of live pokemons.
	 */
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
