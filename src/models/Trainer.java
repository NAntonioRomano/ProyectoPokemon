package models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import capabilities.PokemonCapability;
import capabilities.WeaponCapability;
import interfaces.Buyer;
import interfaces.Classifiable;
import models.pokemons.Pokemon;
import models.pokemons.StonePokemon;
import models.weapons.Weapon;

/**
 * The Trainer class represents a trainer in the game.
 * It implements the Buyer, Classifiable, PokemonCapability, and
 * WeaponCapability interfaces.
 * It contains information about the trainer's name, credits, and their
 * collection of pokemon.
 */
public class Trainer implements Buyer, Classifiable, PokemonCapability, WeaponCapability, Cloneable {
	private String name;
	private double credits;
	private ArrayList<Pokemon> pokemons;
	private ArrayList<Weapon> weapons;

	/**
	 * Constructor to create a Trainer object with a specified name.
	 *
	 * @param name the name of the trainer
	 */
	public Trainer(String name) {
		this.name = name;
		this.pokemons = new ArrayList<>();
		this.weapons = new ArrayList<>();
	}

	/**
	 * Getter method to retrieve the trainer's name.
	 * 
	 * @return the name of the trainer
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the list of pokemons owned by the trainer.
	 */
	public List<Pokemon> getPokemons() {
		return pokemons;
	}

	/**
	 * @return the list of weapons owned by the trainer.
	 */
	public List<Weapon> getWeapons() {
		return weapons;
	}

	/**
	 * @param credits the credits to add.
	 */
	public void addCredits(double credits) {
		this.credits += credits;
	}

	@Override
	public int getCategory() {
		return pokemons.stream()
				.mapToInt(Pokemon::getCategory)
				.sum();
	}

	@Override
	public double getBalance() {
		return credits;
	}

	@Override
	public void subtract(double amount) {
		this.credits -= amount;
	}

	@Override
	public boolean canPokemonBePurchased(Pokemon pokemon) {
		return !pokemons.stream()
				.anyMatch(item -> item.getName() == pokemon.getName());
	}

	@Override
	public void onPokemonPurchased(Pokemon pokemon) {
		pokemons.add(pokemon);
	}

	@Override
	public void onWeaponPurchased(Weapon weapon) {
		weapons.add(weapon);
	}

	@Override
	public String toString() {
		return "Trainer [name=" + name + ", credits=" + credits + ", pokemons=" + pokemons + "]";
	}

	@Override
	public Object clone() throws CloneNotSupportedException {

		Trainer clone = (Trainer) super.clone();
		clone.pokemons = (ArrayList<Pokemon>) this.pokemons.clone();
		clone.weapons = (ArrayList<Weapon>) this.weapons.clone();
		clone.pokemons.clear();
		clone.weapons.clear();

		for (Pokemon pokemon : this.pokemons)
			clone.pokemons.add((Pokemon) pokemon.clone());

		for (Weapon weapon : this.weapons)
			clone.weapons.add((Weapon) weapon.clone());

		return clone;
	}

}
