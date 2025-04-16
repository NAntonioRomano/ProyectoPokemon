package models;

import models.pokemons.*;

public class Arena {
    private String name;
    private final double creditsForWinner = 500;

    public Arena(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Trainer startBattle(TrainerPrepared TP1, TrainerPrepared TP2) {
        int fighterIndexTP1 = 0;
        int fighterIndexTP2 = 0;

        Pokemon pokemonInBattleTP1 = TP1.getPokemon(fighterIndexTP1);
        Pokemon pokemonInBattleTP2 = TP2.getPokemon(fighterIndexTP2);

        while (!TP1.allDeadPokemons() && !TP2.allDeadPokemons()) {
            pokemonInBattleTP1.attack(pokemonInBattleTP2);

            if (!pokemonInBattleTP2.isDead())
                pokemonInBattleTP2.attack(pokemonInBattleTP1);
            else if (!TP2.allDeadPokemons()) {
                fighterIndexTP2++;
                pokemonInBattleTP2 = TP2.getPokemon(fighterIndexTP2);
            }

            if (!TP1.allDeadPokemons() && pokemonInBattleTP1.isDead()) {
                fighterIndexTP1++;
                pokemonInBattleTP1 = TP1.getPokemon(fighterIndexTP1);
            }
        }

        Trainer winner = TP1.allDeadPokemons() ? TP2.getTrainer() : TP1.getTrainer();

        winner.addCredits(creditsForWinner);

        return winner;

    }

}