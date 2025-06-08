package model.messages;

import model.entities.trainers.Trainer;

public class BattleWinner {
    private Trainer winner;
    private String instance;

    public BattleWinner(Trainer winner, String instance) {
        this.winner = winner;
        this.instance = instance;
    }

    public Trainer getWinner() {
        return winner;
    }

    public void setWinner(Trainer winner) {
        this.winner = winner;
    }

    public String getInstance() {
        return instance;
    }

    public void setInstance(String instance) {
        this.instance = instance;
    }

}
