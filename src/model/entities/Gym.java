package model.entities;

import java.util.ArrayList;
import java.util.List;

import model.entities.trainers.Trainer;
import model.entities.trainers.TrainerPrepared;
import model.interfaces.Arena;

public class Gym {
	private ArrayList<Trainer> trainers;
	private ArrayList<Arena> arenas;

	public Gym() {
		this.trainers = new ArrayList<Trainer>();
		this.arenas = new ArrayList<Arena>();
	}

	/**
	 * Adds a trainer to the gym.
	 * preconditions: Arena != null, trainer1 != null, trainer2 != null
	 * 
	 * @param trainer1 The trainer to be added.
	 * @param trainer2 The trainer to be added.
	 * @param arena    The arena where the trainer will battle.
	 */

	public Trainer Arena_Battle(Arena arena, Trainer trainer1, Trainer trainer2) {
		Trainer winner = arena.startBattle(new TrainerPrepared(trainer1), new TrainerPrepared(trainer2));
		winner.addCredits(arena.getCredditsForWinner());
		synchronized (this) {
			arena.setBusy(false);
			notifyAll();
		}

		return winner;
	}

	public List<Trainer> getTrainers() {
		return trainers;
	}

	public void addTrainer(Trainer trainer) {
		if (trainer != null) {
			trainers.add(trainer);
		}
	}

	public void removeTrainer(Trainer trainer) {
		if (trainer != null) {
			trainers.remove(trainer);
		}
	}

	public List<Arena> getArenas() {
		return arenas;
	}

	public void addArena(Arena arena) {
		if (arena != null) {
			arenas.add(arena);
		}
	}

	public void removeArena(Arena arena) {
		if (arena != null) {
			arenas.remove(arena);
		}
	}

	synchronized public Arena getFreeArena() {
		while (allBusyArenas()) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		for (Arena arena : arenas) {
			if (!arena.isBusy()) {
				arena.setBusy(true);
				return arena;
			}
		}
		return null;
	}

	private boolean allBusyArenas() {
		for (Arena arena : arenas) {
			if (!arena.isBusy()) {
				return false;
			}
		}
		return true;
	}

	public void setTrainers(List<Trainer> trainers) {
		this.trainers = (ArrayList) trainers;
	}

	public void setArenas(List<Arena> arenas) {
		this.arenas = (ArrayList) arenas;
	}

}
