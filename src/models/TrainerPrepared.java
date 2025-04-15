package models;

import java.util.Arrays;
import java.util.List;

import exceptions.TrainerWithoutPokemonsException;
import models.pokemons.Pokemon;

public class TrainerPrepared {
	private String name;
	private Pokemon[] pokemons;
	private final int maxPokemonsPerFigth = 3;

	public TrainerPrepared(Trainer trainer) throws TrainerWithoutPokemonsException {
		this.name = trainer.getName();
		List<Pokemon> trainerPokemons = trainer.getPokemons();

		if (trainerPokemons.size() == 0)
			throw new TrainerWithoutPokemonsException();

		int length = Math.min(maxPokemonsPerFigth, trainerPokemons.size());
		pokemons = new Pokemon[length];

		for (int i = 0; i < length; i++)
			pokemons[i] = trainerPokemons.get(i);
	}

	public String getName() {
		return name;
	}

	public Pokemon[] getPokemons() {
		return pokemons;
	}

	public boolean allDeadPokemons(){
		for (Pokemon pokemon : pokemons) {
			if (!pokemon.isDead())
				return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "TrainerPrepared [name=" + name + ", pokemons=" + Arrays.toString(pokemons) + "]";
	}

}