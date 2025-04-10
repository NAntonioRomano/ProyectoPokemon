package gym;

import java.util.List;

import exceptions.TrainerWithoutPokemonsException;
import pokemons.Pokemon;

public class TrainerPrepared {
	private String name;
	private Pokemon[] pokemons = new Pokemon[3];

	public TrainerPrepared(Trainer trainer) throws TrainerWithoutPokemonsException {
		this.name = trainer.getName();
		List<Pokemon> trainerPokemons = trainer.getPokemons();

		if (trainerPokemons.size() == 0)
			throw new TrainerWithoutPokemonsException();

		for (int i = 0; i < pokemons.length; i++)
			pokemons[i] = trainerPokemons.get(i);
	}

	public String getName() {
		return name;
	}

	public Pokemon[] getPokemons() {
		return pokemons;
	}
}