package gym;

import java.util.ArrayList;
import java.util.List;

import capabilties.PokemonCapability;
import capabilties.WeaponCapability;
import exceptions.ImpossiblePurchaseException;
import interfaces.Classifiable;
import models.AbstractBuyer;
import pokemons.Pokemon;
import weapons.Weapon;

public class Trainer extends AbstractBuyer implements Classifiable, PokemonCapability, WeaponCapability {
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
	public void onPokemonPurchased(Pokemon pokemon) {
		pokemons.add(pokemon);
	}

	@Override
	public void onWeaponPurchased(Weapon weapon) {
		System.out.println("No se qué pingo hacer con esta arma :/");
	}

}
