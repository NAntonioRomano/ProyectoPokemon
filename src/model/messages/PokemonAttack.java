package model.messages;

import model.entities.pokemons.Pokemon;

public class PokemonAttack {
    private Pokemon attacker;
    private Pokemon attacked;

    public PokemonAttack(Pokemon attacker, Pokemon attacked){
        this.attacked = attacked;
        this.attacker = attacker;
    }

    public Pokemon getAttacker(){
        return attacker;
    }

    public Pokemon getAttacked(){
        return attacked;
    }
}
