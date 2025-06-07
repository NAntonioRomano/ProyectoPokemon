package model.models;

import model.exceptions.ImpossiblePurchaseException;
import model.interfaces.Arena;
import model.interfaces.Valuable;
import model.models.arenas.*;
import model.models.pokemons.Pokemon;
import model.models.pokemons.PokemonFactory;
import model.models.trainers.Trainer;
import model.models.weapons.Weapon;
import model.models.weapons.WeaponFactory;

public class GymFacade {
    private Gym gym;

    public GymFacade(Gym gym){
        this.gym = gym;
    }

    public Weapon newWeapon(String type) throws IllegalArgumentException{
        return WeaponFactory.newWeapon(type);
    }
    public Pokemon newPokemon(String name, String type) throws IllegalArgumentException{
        return PokemonFactory.newPokemon(name, type);
    }
    public Trainer newTrainer(String name){
        return new Trainer(name);
    }
    public void addTrainer(Trainer trainer){
        gym.addTrainer(trainer);
    }


    public void removeTrainer(Trainer trainer){
        gym.removeTrainer(trainer);
    }

    public void addArena(String name, String type, String difficulty){
        Arena arena = new ArenaWithLevel(new ArenaWithType(new BaseArena(name), type), difficulty);
        gym.addArena(arena);
    }

    public void removeArena(Arena arena){
        gym.removeArena(arena);
    }

    public void purchaseValuable(Trainer trainer, Valuable valuable) throws ImpossiblePurchaseException{
        trainer.purchase(valuable);
    }

    public void removePokemonFromTrainer(Trainer trainer, Pokemon pokemon) {
        trainer.removePokemon(pokemon);
    }

    public void sellPokemon(Trainer trainer, Pokemon pokemon) {
        trainer.sellPokemon(pokemon);
    }
}
