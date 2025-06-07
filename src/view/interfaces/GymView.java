package view.interfaces;

import java.awt.event.ActionListener;

import model.entities.pokemons.Pokemon;
import model.entities.trainers.Trainer;
import model.entities.weapons.Weapon;
import model.interfaces.Arena;

public interface GymView extends ActionListener {
	String ADD_TRAINER = "ADD_TRAINER";
	String RMV_TRAINER = "RMV_TRAINER";
	String ADD_ARENA = "ADD_ARENA";
	String RMV_ARENA = "RMV_ARENA";
	String RMV_ITEM = "RMV_ITEM";
	String PURCHASE_POKEMON = "PURCHASE_POKEMON";
	String RMV_POKEMON_FROM_TRAINER = "RMV_POKEMON_FROM_TRAINER";
	String PURCHASE_WEAPON = "PURCHASE_WEAPON";
	String ADD_WEAPON_TO_POKEMON = "ADD_WEAPON_TO_POKEMON";
	String SELL_POKEMON = "SELL_POKEMON";

	void setActionListener(ActionListener listener);

	void addTrainer(Trainer trainer);

	void addArena(Arena arena);

	void ShowErrorMessage(String message);

	void updateTrainerData(Trainer trainer);

	public Trainer getSelectedTrainer();

	String getTrainerName();

	String getArenaName();

	String getArenaType();

	String getArenaLevel();

	String getPokemonName();

	String getPokemonType();

	String getWeaponType();

	Pokemon getSelectedPokemon();

	Weapon getSelectedWeapon();
}
