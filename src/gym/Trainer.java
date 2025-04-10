package gym;

import java.util.ArrayList;
import java.util.List;

import pokemons.Pokemon;

public class Trainer {
	private String name;
	private List<Pokemon> pokemons;
	
	public Trainer(String name) {
		super();
		this.name = name;
		this.pokemons = new ArrayList<>();
	}
	
}
