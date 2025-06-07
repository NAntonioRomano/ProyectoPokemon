package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.entities.GymFacade;
import model.entities.pokemons.Pokemon;
import model.entities.trainers.Trainer;
import model.exceptions.ImpossiblePurchaseException;
import model.interfaces.Arena;
import view.interfaces.GymView;

public class GymController implements ActionListener {
	private GymView gymView;
	private GymFacade gymFacade;

	public GymController(GymView gymview, GymFacade gymFacade) {
		this.gymView = gymview;
		this.gymFacade = gymFacade;

		for (Trainer trainer : gymFacade.getGym().getTrainers())
			gymView.addTrainer(trainer);

		for (Arena arena : gymFacade.getGym().getArenas())
			gymView.addArena(arena);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		if (command.equals(GymView.ADD_TRAINER)) {
			addTrainer();
		} else if (command.equals(GymView.RMV_TRAINER)) {
			removeTrainer(e);
		} else if (command.equals(GymView.ADD_ARENA)) {
			addArena();
		} else if (command.equals(GymView.RMV_ARENA)) {
			removeArena(e);
		} else if (command.equals(GymView.PURCHASE_POKEMON)) {
			purchasePokemon();
		} else if (command.equals(GymView.RMV_POKEMON_FROM_TRAINER)) {
			removePokemonFromTrainer();
		} else if (command.equals(GymView.SELL_POKEMON)) {
			sellPokemon();
		} else if (command.equals(GymView.PURCHASE_WEAPON)) {

			purchaseWeapon();
		} else if (command.equals(GymView.ADD_WEAPON_TO_POKEMON)) {
			addWeaponToPokemon();
		}
	}

	private void addWeaponToPokemon() {
		try {
			gymView.getSelectedPokemon().setWeapon(gymView.getSelectedWeapon());
			gymView.updateTrainerData(null);
		} catch (UnsupportedOperationException e) {
			gymView.ShowErrorMessage(e.getMessage());
		}
	}

	private void purchaseWeapon() {
		try {
			Trainer selected = gymView.getSelectedTrainer();
			gymFacade.purchaseValuable(selected, gymFacade.newWeapon(gymView.getWeaponType()));
			gymView.updateTrainerData(selected);

		} catch (ImpossiblePurchaseException e) {
			gymView.ShowErrorMessage(e.getMessage());
		} catch (IllegalArgumentException e) {
			gymView.ShowErrorMessage(e.getMessage());
		}
	}

	private void purchasePokemon() {
		try {
			Trainer selected = gymView.getSelectedTrainer();
			gymFacade.purchaseValuable(selected,
					gymFacade.newPokemon(gymView.getPokemonName(), gymView.getPokemonType()));
			gymView.updateTrainerData(selected);
		} catch (ImpossiblePurchaseException e) {
			gymView.ShowErrorMessage(e.getMessage());
		} catch (IllegalArgumentException e) {
			gymView.ShowErrorMessage(e.getMessage());
		}

	}

	private void removeArena(ActionEvent e) {
		Arena arena = (Arena) e.getSource();
		gymFacade.removeArena(arena);
	}

	private void addArena() {
		String name = gymView.getArenaName();
		String type = gymView.getArenaType();
		String level = gymView.getArenaLevel();
		Arena arena = gymFacade.addArena(name, type, level);
		gymView.addArena(arena);
	}

	private void addTrainer() {
		Trainer trainer = gymFacade.newTrainer(gymView.getTrainerName());
		gymFacade.addTrainer(trainer);
		gymView.addTrainer(trainer);
	}

	private void removeTrainer(ActionEvent e) {
		Trainer trainer = (Trainer) e.getSource();
		gymFacade.removeTrainer(trainer);
	}

	private void removePokemonFromTrainer() {
		Trainer selected = gymView.getSelectedTrainer();
		Pokemon pokemon = gymView.getSelectedPokemon();
		gymFacade.removePokemonFromTrainer(selected, pokemon);
		gymView.updateTrainerData(selected);
	}

	private void sellPokemon() {
		Trainer selected = gymView.getSelectedTrainer();
		Pokemon pokemon = gymView.getSelectedPokemon();
		gymFacade.sellPokemon(selected, pokemon);
		gymView.updateTrainerData(selected);
	}

}
