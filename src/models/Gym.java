package models;

import java.util.ArrayList;
import java.util.List;

import exceptions.TrainerWithoutPokemonsException;

public class Gym {
	private List<Trainer> trainers = new ArrayList<>();
	private List<Arena> arenas = new ArrayList<>();

	public void Arena_Battle(Arena arena, Trainer trainer1, Trainer trainer2) throws TrainerWithoutPokemonsException {
		arena.startBattle(new TrainerPrepared(trainer1), new TrainerPrepared(trainer2));
	}
}
