package model.messages;


import model.entities.trainers.TrainerPrepared;

public class BattleTrainers {
    private TrainerPrepared t1;
    private TrainerPrepared t2;

    public BattleTrainers(TrainerPrepared t1, TrainerPrepared t2){
        this.t1 = t1;
        this.t2 = t2;
    }

    public TrainerPrepared getTrainer1(){
        return t1;
    }
    public TrainerPrepared getTrainer2(){
        return t2;
    }
}
