package model.entities.arenas;

import java.util.ArrayList;
import java.util.List;

import model.entities.pokemons.*;
import model.entities.trainers.Trainer;
import model.entities.trainers.TrainerPrepared;
import model.interfaces.Arena;
import model.interfaces.Observer;
import model.messages.BattleTrainers;
import model.messages.DeadPokemon;
import model.messages.PokemonAttack;

public class BaseArena implements Arena {

    private String name;
    private int creditsForWinner;
    private boolean inBattle;

    private List<Observer> observers;

    /**
     * Constructor for Arena class.
     * preconditions: name != null, creditsForWinner >= 0
     * 
     * @param name             The name of the arena.
     * @param creditsForWinner The amount of credits to be given to the winner.
     *
     */
    public BaseArena(String name, int creditsForWinner) {
        this.name = name;
        this.creditsForWinner = creditsForWinner;
        this.observers = new ArrayList<>();
    }

    /**
     * Constructor for Arena class.
     * preconditions: name != null
     * 
     * @param name The name of the arena.
     */
    public BaseArena(String name) {
        this(name, 500);
    }

    @Override
    public Trainer startBattle(TrainerPrepared TP1, TrainerPrepared TP2) {

        notifyObservers(new BattleTrainers(TP1, TP2));
        Pokemon pokemonInBattleTP1 = TP1.getRandomPokemon();
        Pokemon pokemonInBattleTP2 = TP2.getRandomPokemon();

        if (pokemonInBattleTP1 != null && pokemonInBattleTP2 != null)

            while (pokemonInBattleTP1 != null && pokemonInBattleTP2 != null) {
                pokemonInBattleTP1.attack(pokemonInBattleTP2);
                notifyObservers(new PokemonAttack(pokemonInBattleTP1, pokemonInBattleTP2));
                if (pokemonInBattleTP2.isDead()) {
                    notifyObservers(new DeadPokemon(pokemonInBattleTP2));
                    pokemonInBattleTP2 = TP2.getRandomPokemon();

                } else {
                    pokemonInBattleTP2.attack(pokemonInBattleTP1);
                    notifyObservers(new PokemonAttack(pokemonInBattleTP2, pokemonInBattleTP1));
                    if (pokemonInBattleTP1.isDead()) {
                        notifyObservers(new DeadPokemon(pokemonInBattleTP1));
                        pokemonInBattleTP1 = TP1.getRandomPokemon();
                    }
                }
            }

        TrainerPrepared winner = pokemonInBattleTP1 != null ? TP1 : TP2;

        for (Pokemon pokemon : winner.getPokemons())
            pokemon.recharge();

        return winner.getTrainer();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDetails() {
        return "Arena: " + getName() + "\n";
    }

    @Override
    public int getCredditsForWinner() {
        return (int) creditsForWinner;
    }

    @Override
    public boolean isBusy() {
        return this.inBattle;
    }

    @Override
    public void setBusy(boolean busy) {
        this.inBattle = busy;
    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public String getLevel() {
        return null;
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    synchronized public void notifyObservers(Object args) {
        observers.forEach(item -> item.update(this, args));
    }

}
