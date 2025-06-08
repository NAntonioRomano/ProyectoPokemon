package model.entities.trainers;

public class TrainerFactory {

    /**
     * Creates a new Trainer with the specified name and credits.
     * preconditions: name != null && credits >= 0
     * 
     * @param name    the name of the trainer
     * @param credits the initial credits for the trainer
     * @return a new Trainer object with the given name and credits
     */

    public static Trainer createTrainer(String name, int credits) {
        Trainer trainer = new Trainer(name);
        trainer.addCredits(credits);
        return trainer;
    }
}
