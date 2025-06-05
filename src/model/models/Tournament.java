package model.models;

import java.util.ArrayList;

import model.exceptions.TrainerWithoutPokemonsException;

public class Tournament {

    private Gym gym;
    private Trainer winner;
    private ArrayList<Trainer> semifinalTrainers;
    private ArrayList<Trainer> finalTrainers;
    private ArrayList<Trainer> quarterfinalTrainers;

    public Tournament(Gym gym, ArrayList<Trainer> quarterfinalTrainers) {
        this.gym = gym;
        this.semifinalTrainers = new ArrayList<Trainer>();
        this.finalTrainers = new ArrayList<Trainer>();
        this.quarterfinalTrainers = quarterfinalTrainers;
    }

    public void startTournament() throws TrainerWithoutPokemonsException, InterruptedException {
        System.out.println("Comienza el torneo nashei");
        runQuarterfinals();
        runSemifinals();
        runFinal();
    }

    synchronized private void runFinal() throws InterruptedException, TrainerWithoutPokemonsException {
        while (finalTrainers.size() != 2)
            wait();

        startBattle(gym, finalTrainers.get(0), finalTrainers.get(1), "Final");
    }

    synchronized private void runSemifinals() throws InterruptedException, TrainerWithoutPokemonsException {
        while (semifinalTrainers.size() != 4)
            wait();

        for (int i = 0; i < semifinalTrainers.size() - 1; i += 2)
            startBattle(gym, semifinalTrainers.get(i), semifinalTrainers.get(i + 1),
                    "Semi Final");
    }

    private void runQuarterfinals() throws TrainerWithoutPokemonsException {
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
        System.out.println("Ganador del torneo: " + winner.getName());
    }

    synchronized public void setFinalTrainer(Trainer winner) {
        finalTrainers.add(winner);
        notifyAll();
        System.out.println("Ganador de semifinal: " + winner.getName());
    }

    synchronized public void setSemifinalTrainer(Trainer winner) {
        semifinalTrainers.add(winner);
        notifyAll();
        System.out.println("Ganador de cuartos: " + winner.getName());
    }
}