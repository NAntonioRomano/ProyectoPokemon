package model.models;

import java.util.ArrayList;
import java.util.List;

import model.capabilities.PokemonCapability;
import model.capabilities.WeaponCapability;
import model.interfaces.Buyer;
import model.interfaces.Classifiable;
import model.models.pokemons.Pokemon;
import model.models.weapons.Weapon;

public class Trainer implements Buyer, Classifiable, PokemonCapability, WeaponCapability, Cloneable {
	private String name;
	private double credits;
	private ArrayList<Pokemon> pokemons;
	private ArrayList<Weapon> weapons;

	/**
	 * Constructor to create a Trainer object with a specified name.
	 * preconditions: name != null
	 * 
	 * @param name the name of the trainer
	 */
	public Trainer(String name) {
		this.name = name;
		this.pokemons = new ArrayList<>();
		this.weapons = new ArrayList<>();
		this.credits = 600;
	}

	public String getName() {
		return name;
	}

	public List<Pokemon> getPokemons() {
		return pokemons;
	}

	public List<Weapon> getWeapons() {
		return weapons;
	}

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
