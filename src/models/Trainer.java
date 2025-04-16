package models;

import java.util.ArrayList;
import java.util.List;

import capabilties.PokemonCapability;
import capabilties.WeaponCapability;
import interfaces.Buyer;
import interfaces.Classifiable;
import models.pokemons.Pokemon;
import models.pokemons.StonePokemon;
import models.weapons.Weapon;

public class Trainer implements Buyer, Classifiable, PokemonCapability, WeaponCapability {
	private String name;
	private double credits;
	private List<Pokemon> pokemons;

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
		setWeapon(weapon);
	}

	public void setWeapon(Weapon weapon) {
		StonePokemon pokemon = pokemons.stream()
				.filter(item -> item instanceof StonePokemon)
				.map(item -> (StonePokemon) item)
				.findFirst()
				.orElse(null);

		if (pokemon != null)
			pokemon.setWeapon(weapon);
		else
			System.out.println(name + " no tiene pokemones de piedra para equipar el arma.");

	}

	@Override
	public String toString() {
		return "Trainer [name=" + name + ", credits=" + credits + ", pokemons=" + pokemons + "]";
	}

}
