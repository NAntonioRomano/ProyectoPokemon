package gym;

import java.util.ArrayList;
import java.util.List;

import exceptions.ImpossiblePurchaseException;
import interfaces.Classifiable;
import pokemons.Pokemon;

public class Trainer implements Classifiable {
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

	// public void purchasePokemon(Pokemon pokemon) throws
	// ImpossiblePurchaseException {
	// double cost = pokemon.getCost();

	// if (credits < cost)
	// throw new ImpossiblePurchaseException(cost, credits);

	// pokemons.add(pokemon);
	// credits -= cost;
	// }

	@Override
	public int getCategory() {
		return pokemons.stream()
				.mapToInt(Pokemon::getCategory)
				.sum();
	}

}
