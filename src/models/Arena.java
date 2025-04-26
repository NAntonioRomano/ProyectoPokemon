package models;

import models.pokemons.*;

public class Arena {

    private String name;
    private final double creditsForWinner;

    /**
     * Constructor for Arena class.
     * preconditions: name != null
     * 
     * @param name The name of the arena.
     */
    public Arena(String name) {
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
    public Arena(String name, double creditsForWinner) {
        this.name = name;
        this.creditsForWinner = creditsForWinner;
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
     * preconditions: TP1 != null, TP2 != null
     * 
     * @param TP1 The first TrainerPrepared object representing the first trainer.
     * @param TP2 The second TrainerPrepared object representing the second trainer.
     * @return The Trainer object representing the winner of the battle.
     */
    public Trainer startBattle(TrainerPrepared TP1, TrainerPrepared TP2) {

        System.out.println();
        System.out.println("Starting battle in " + this.name + " between " + TP1.getTrainer().getName() + " and "
                + TP2.getTrainer().getName());

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
        winner.addCredits(creditsForWinner);
        System.out.println("🏅 " + winner.getName() + " won the battle!");
        System.out.println();

        return winner;

        // int fighterIndexTP1 = 0;
        // int fighterIndexTP2 = 0;
        //
        // while (!TP1.allDeadPokemons() && !TP2.allDeadPokemons()) {
        //
        // Pokemon pokemonInBattleTP1 = TP1.getPokemon(fighterIndexTP1);
        // Pokemon pokemonInBattleTP2 = TP2.getPokemon(fighterIndexTP2);
        //
        // pokemonInBattleTP1.attack(pokemonInBattleTP2);
        //
        // if (!pokemonInBattleTP2.isDead())
        // pokemonInBattleTP2.attack(pokemonInBattleTP1);
        // else if (!TP2.allDeadPokemons())
        // fighterIndexTP2++;
        //
        // if (!TP1.allDeadPokemons() && pokemonInBattleTP1.isDead())
        // fighterIndexTP1++;
        //
        // }
        //
        // Trainer winner = TP1.allDeadPokemons() ? TP2.getTrainer() : TP1.getTrainer();
        // winner.addCredits(creditsForWinner);
        //
        // return winner;

    }

}
