package models.arenas;

import models.Trainer;
import models.TrainerPrepared;
import models.pokemons.*;
import exceptions.TrainerWithoutPokemonsException;
import interfaces.Arena;

public class BaseArena implements Arena {

    private String name;
    private int creditsForWinner;
    private boolean inBattle;

    /**
     * Constructor for Arena class.
     * preconditions: name != null
     * 
     * @param name The name of the arena.
     */
    public BaseArena(String name) {
        this.name = name;
        this.creditsForWinner = 500;
    }

    /**
     * Constructor for Arena class.
     * preconditions: name != null, creditsForWinner >= 0
     * 
     * @param name             The name of the arena.
     * @param creditsForWinner The amount of credits to be given to the winner.
     *
     */
    public BaseArena(String name, int creditsForWinner) {
        this.name = name;
        this.creditsForWinner = creditsForWinner;
    }
    



    @Override
    public Trainer startBattle(TrainerPrepared TP1, TrainerPrepared TP2){

        Pokemon pokemonInBattleTP1 = TP1.getRandomPokemon();
        Pokemon pokemonInBattleTP2 = TP2.getRandomPokemon();

        while (pokemonInBattleTP1 != null && pokemonInBattleTP2 != null) {

            // TP1 have adventage over TP2 always
            pokemonInBattleTP1.attack(pokemonInBattleTP2);

            if (pokemonInBattleTP2.isDead()) {
                pokemonInBattleTP2 = TP2.getRandomPokemon();
            } else {
                pokemonInBattleTP2.attack(pokemonInBattleTP1);
                if (pokemonInBattleTP1.isDead()) {
                    pokemonInBattleTP1 = TP1.getRandomPokemon();
                }
            }
        }

        Trainer winner = pokemonInBattleTP1 != null ? TP1.getTrainer() : TP2.getTrainer();

        return winner;
        
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDetails() {
        return "Arena: " + getName() + "\n";
    }

    @Override
    public int getCredditsForWinner() {
        return (int) creditsForWinner;
    }

    @Override
    public boolean isBusy() {
        return this.inBattle;
    }

    @Override
    public void setBusy(boolean busy) {
        this.inBattle = busy;
    }

}
