package models;

import exceptions.TrainerWithoutPokemonsException;

public class Battle implements Runnable {
    private Gym gym;
    private Trainer trainer1;
    private Trainer trainer2;

    public Battle(Gym gym, Trainer trainer1, Trainer trainer2) throws TrainerWithoutPokemonsException{
        if (trainer1.getPokemons().isEmpty())
            throw new TrainerWithoutPokemonsException(trainer1);
        this.trainer1 = trainer1;
        if (trainer2.getPokemons().isEmpty())
            throw new TrainerWithoutPokemonsException(trainer2);
        this.trainer2 = trainer2;
        this.gym = gym;
    }

    @Override
    public void run() {
        gym.Arena_Battle(gym.getFreeArena(), trainer1, trainer2);
    }


    

}
