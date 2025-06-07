package model.entities.trainers;

public class TrainerFactory {

    public static Trainer createTrainer(String name, int credits) {
        Trainer trainer = new Trainer(name);
        trainer.addCredits(credits);
        return trainer;
    }
}
