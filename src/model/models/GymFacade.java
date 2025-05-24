package model.models;

import model.interfaces.Arena;
import model.models.arenas.*;

public class GymFacade {
    private Gym gym;

    public GymFacade(Gym gym){
        this.gym = gym;
    }

    public void addTrainer(String name){
        Trainer trainer = new Trainer(name);
        gym.addTrainer(trainer);
    }

    public Trainer getTrainer(String name){
        for (Trainer trainer : gym.getTrainers()){
            if(trainer.getName().equalsIgnoreCase(name)){
                return trainer;
            }
        }
        return null;
    }


    public void removeTrainer(String name){
        for (Trainer trainer : gym.getTrainers()){
            if(trainer.getName().equalsIgnoreCase(name)){
                gym.removeTrainer(trainer);
                break;
            }
        }
    }

    public void removeTrainer(Trainer trainer){
        gym.removeTrainer(trainer);
    }

    public void addArena(String name, String type, String difficulty){
        Arena arena = new ArenaWithLevel(new ArenaWithType(new BaseArena(name), type), difficulty);
        gym.addArena(arena);
    }

    public void removeArena(String name){
        for (Arena arena : gym.getArenas()){
            if(arena.getName().equalsIgnoreCase(name)){
                gym.removeArena(arena);
                break;
            }
        }
    }

    public void removeArena(Arena arena){
        gym.removeArena(arena);
    }


}
