package exceptions;

import models.Trainer;

public class TrainerWithoutPokemonsException extends Exception {

    private Trainer trainer;

    public TrainerWithoutPokemonsException(Trainer trainer) {
        super("The trainer " + trainer.getName() + " has no available pokemons!");
        this.trainer = trainer;
    }

    public Trainer getTrainer() {
        return trainer;
    }

}