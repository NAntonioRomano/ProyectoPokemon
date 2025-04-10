package gym;

import java.util.ArrayList;
import java.util.List;
import exceptions.TrainerWithoutPokemonsException;

import pokemons.Pokemon;

public class TrainerPrepared {
	private String name;
	private Pokemon[] pokemons = new Pokemon[3];
	
	public TrainerPrepared(Trainer trainer) throws TrainerWithoutPokemonsException {
		this.name = trainer.name;

        if (trainer.pokemons.length() == 0)
            throw new TrainerWithoutPokemonsException();

        for(int i = 0; i < pokemons.length; i++)
		    pokemons[i] = trainer.pokemons.get(i); 
	}
}