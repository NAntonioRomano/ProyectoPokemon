package models;

import java.util.ArrayList;
import java.util.List;

import exceptions.TrainerWithoutPokemonsException;

public class Gym {
	private List<Trainer> trainers = new ArrayList<>();
	private List<Arena> arenas = new ArrayList<>();

	/**
	 * Adds a trainer to the gym.
	 * preconditions: Arena != null, trainer1 != null, trainer2 != null
	 * 
	 * @param trainer1 The trainer to be added.
	 * @param trainer2 The trainer to be added.
	 * @param arena    The arena where the trainer will battle.
	 * @throws TrainerWithoutPokemonsException if the trainer has no pokemons.
	 */
	public void Arena_Battle(Arena arena, Trainer trainer1, Trainer trainer2)
			throws TrainerWithoutPokemonsException {
		arena.startBattle(new TrainerPrepared(trainer1), new TrainerPrepared(trainer2));
	}
}
