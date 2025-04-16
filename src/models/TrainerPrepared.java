package models;

import java.util.Arrays;
import java.util.List;

import exceptions.TrainerWithoutPokemonsException;
import models.pokemons.Pokemon;
import models.weapons.Weapon;

public class TrainerPrepared {
	private String name;
	private Pokemon[] pokemons;
	private Trainer trainer;
	private final int maxPokemonsPerFigth = 3;

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

	public Pokemon getPokemon(int index) throws ArrayIndexOutOfBoundsException {
		return pokemons[index];
	}

	public boolean allDeadPokemons() {
		for (Pokemon pokemon : pokemons) {
			if (!pokemon.isDead())
				return false;
		}
		return true;
	}

}