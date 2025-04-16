package models;

import java.util.ArrayList;
import java.util.List;

import capabilties.PokemonCapability;
import capabilties.WeaponCapability;
import interfaces.Buyer;
import interfaces.Classifiable;
import models.pokemons.Pokemon;
import models.weapons.Weapon;

public class Trainer implements Buyer, Classifiable, PokemonCapability, WeaponCapability {
	private String name;
	private List<Pokemon> pokemons;
	private double credits;

	public Trainer(String name) {
		this.name = name;
		this.pokemons = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public List<Pokemon> getPokemons() {
		return pokemons;
	}

	public double getCredits() {
		return credits;
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
		System.out.println("No se qué pingo hacer con esta arma :/");
	}

}
