package model.entities;

import model.entities.trainers.Trainer;
import model.exceptions.TrainerWithoutPokemonsException;

public class Battle implements Runnable {
    private Tournament tournament;
    private Gym gym;
    private Trainer trainer1;
    private Trainer trainer2;
    private String type;

    public Battle(Gym gym, Tournament tournament, Trainer trainer1, Trainer trainer2, String type)
            throws TrainerWithoutPokemonsException {
        if (trainer1.getPokemons().isEmpty())
            throw new TrainerWithoutPokemonsException(trainer1);
        this.trainer1 = trainer1;
        if (trainer2.getPokemons().isEmpty())
            throw new TrainerWithoutPokemonsException(trainer2);
        this.trainer2 = trainer2;
        this.tournament = tournament;
        this.gym = gym;
        this.type = type;
    }

    @Override
    public void run() {
        Trainer winner = gym.Arena_Battle(gym.getFreeArena(), trainer1, trainer2);

        switch (type) {
            case "Quarter Final":
                tournament.setSemifinalTrainer(winner);
                break;
            case "Semi Final":
                tournament.setFinalTrainer(winner);
                break;
            case "Final":
                tournament.setWinner(winner);
            default:
                break;
        }

    }
}
