package model.messages;

import model.entities.pokemons.Pokemon;

public class DeadPokemon {
    private Pokemon dead;

    public DeadPokemon(Pokemon dead){
        this.dead = dead;
    }

    public Pokemon getDeadPokemon(){
        return dead;
    }
}
