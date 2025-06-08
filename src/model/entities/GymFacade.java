package model.entities;

import java.util.ArrayList;

import model.entities.arenas.ArenaWithLevel;
import model.entities.arenas.ArenaWithType;
import model.entities.arenas.BaseArena;
import model.entities.pokemons.Pokemon;
import model.entities.pokemons.PokemonFactory;
import model.entities.trainers.Trainer;
import model.entities.weapons.Weapon;
import model.entities.weapons.WeaponFactory;
import model.exceptions.ImpossiblePurchaseException;
import model.exceptions.TrainerWithoutPokemonsException;
import model.interfaces.Arena;
import model.interfaces.Valuable;

public class GymFacade {
    private Gym gym;

    public GymFacade(Gym gym) {
        this.gym = gym;
    }

    public Gym getGym() {
        return this.gym;
    }

    public Weapon newWeapon(String type) throws IllegalArgumentException {
        return WeaponFactory.newWeapon(type);
    }

    public Pokemon newPokemon(String name, String type) throws IllegalArgumentException {
        return PokemonFactory.newPokemon(name, type);
    }

    public Trainer newTrainer(String name) {
        return new Trainer(name);
    }

    public void addTrainer(Trainer trainer) {
        gym.addTrainer(trainer);
    }

    public void removeTrainer(Trainer trainer) {
        gym.removeTrainer(trainer);
    }

    public Arena addArena(String name, String type, String difficulty) {
        Arena arena = new ArenaWithLevel(new ArenaWithType(new BaseArena(name), type), difficulty);
        gym.addArena(arena);
        return arena;
    }

    public void removeArena(Arena arena) {
        gym.removeArena(arena);
    }

    public void purchaseValuable(Trainer trainer, Valuable valuable) throws ImpossiblePurchaseException {
        trainer.purchase(valuable);
    }

    public Tournament getTournament(ArrayList<Trainer> trainers)
            throws TrainerWithoutPokemonsException, InterruptedException {
        return new Tournament(gym, trainers);
    }

}
