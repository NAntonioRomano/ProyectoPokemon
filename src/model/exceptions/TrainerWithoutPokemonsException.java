package model.exceptions;

import model.entities.trainers.Trainer;

/**
 * TrainerWithoutPokemonsException is thrown when a trainer has no available
 * pokemons.
 */
public class TrainerWithoutPokemonsException extends Exception {

    private Trainer trainer;

    /**
     * Constructor for TrainerWithoutPokemonsException
     *
     * @param trainer the trainer that has no available pokemons
     */
    public TrainerWithoutPokemonsException(Trainer trainer) {
        super("The trainer " + trainer.getName() + " has no available pokemons!");
        this.trainer = trainer;
    }

    public Trainer getTrainer() {
        return trainer;
    }

}