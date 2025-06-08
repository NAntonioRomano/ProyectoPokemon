package model.entities;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import model.entities.trainers.Trainer;
import model.exceptions.TrainerWithoutPokemonsException;
import model.interfaces.Observable;
import model.interfaces.Observer;
import model.messages.BattleWinner;

public class Tournament implements Observable {

    private Gym gym;
    private Trainer winner;
    private ArrayList<Trainer> semifinalTrainers;
    private ArrayList<Trainer> finalTrainers;
    private ArrayList<Trainer> quarterfinalTrainers;

    private List<Observer> observers;

    public Tournament(Gym gym, ArrayList<Trainer> quarterfinalTrainers) {
        this.gym = gym;
        this.quarterfinalTrainers = quarterfinalTrainers;
        this.semifinalTrainers = new ArrayList<>();
        this.finalTrainers = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public void startTournament() throws TrainerWithoutPokemonsException, InterruptedException {
        runQuarterfinals();
        runSemifinals();
        runFinal();
    }

    synchronized private void runFinal() throws InterruptedException, TrainerWithoutPokemonsException {
        while (finalTrainers.size() != 2)
            wait();

        Collections.shuffle(finalTrainers); // Change the order of begining.

        startBattle(gym, finalTrainers.get(0), finalTrainers.get(1), "Final");
    }

    synchronized private void runSemifinals() throws InterruptedException, TrainerWithoutPokemonsException {
        while (semifinalTrainers.size() != 4)
            wait();

        Collections.shuffle(semifinalTrainers);

        for (int i = 0; i < semifinalTrainers.size() - 1; i += 2)
            startBattle(gym, semifinalTrainers.get(i), semifinalTrainers.get(i + 1),
                    "Semi Final");
    }

    private void runQuarterfinals() throws TrainerWithoutPokemonsException {
        Collections.shuffle(quarterfinalTrainers);

        for (int i = 0; i < quarterfinalTrainers.size() - 1; i += 2)
            startBattle(gym, quarterfinalTrainers.get(i), quarterfinalTrainers.get(i + 1),
                    "Quarter Final");
    }

    private void startBattle(Gym gym, Trainer trainer1, Trainer trainer2, String title)
            throws TrainerWithoutPokemonsException {
        Battle battle = new Battle(gym, this, trainer1, trainer2, title);
        Thread th = new Thread(battle);
        th.start();
    }

    public void setWinner(Trainer winner) {
        this.winner = winner;
        notifyObservers(new BattleWinner(winner, "Final"));

        // recharge all
        quarterfinalTrainers
                .forEach(trainer -> trainer.getPokemons()
                        .forEach(pokemon -> pokemon.recharge()));
    }

    synchronized public void setFinalTrainer(Trainer winner) {
        finalTrainers.add(winner);
        notifyAll();
        notifyObservers(new BattleWinner(winner, "Semi Final"));
    }

    synchronized public void setSemifinalTrainer(Trainer winner) {
        semifinalTrainers.add(winner);
        notifyAll();
        notifyObservers(new BattleWinner(winner, "Quarter Final"));
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