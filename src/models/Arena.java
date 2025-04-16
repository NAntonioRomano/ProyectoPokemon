package models;

import models.pokemons.*;

/**
 * Arena class represents a battle arena where two trainers can battle
 * against each other.
 * It contains methods to start a battle and determine the winner.
 */
public class Arena {

    private String name;
    private final double creditsForWinner = 500;

    /**
     * Constructor for Arena class.
     *
     * @param name The name of the arena.
     */
    public Arena(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the arena.
     *
     * @return The name of the arena.
     */
    public String getName() {
        return name;
    }

    /**
     * Starts a battle between two trainers.
     * The trainers are represented by TrainerPrepared objects,
     * which contain the trainers and their respective Pokemon.
     * The battle continues until one of the trainers has all their Pokemon
     * defeated.
     */
    public Trainer startBattle(TrainerPrepared TP1, TrainerPrepared TP2) {

        System.out.println("Starting battle in " + this.name + " between " + TP1.getTrainer().getName() + " and "
                + TP2.getTrainer().getName());

        int fighterIndexTP1 = 0;
        int fighterIndexTP2 = 0;

        while (!TP1.allDeadPokemons() && !TP2.allDeadPokemons()) {

            Pokemon pokemonInBattleTP1 = TP1.getPokemon(fighterIndexTP1);
            Pokemon pokemonInBattleTP2 = TP2.getPokemon(fighterIndexTP2);

            pokemonInBattleTP1.attack(pokemonInBattleTP2);

            if (!pokemonInBattleTP2.isDead())
                pokemonInBattleTP2.attack(pokemonInBattleTP1);
            else if (!TP2.allDeadPokemons())
                fighterIndexTP2++;

            if (!TP1.allDeadPokemons() && pokemonInBattleTP1.isDead())
                fighterIndexTP1++;

        }

        Trainer winner = TP1.allDeadPokemons() ? TP2.getTrainer() : TP1.getTrainer();
        winner.addCredits(creditsForWinner);

        return winner;

    }

}