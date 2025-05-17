package interfaces;


import models.Trainer;
import models.TrainerPrepared;

public interface Arena {
    /**
     * Starts a battle between two trainers.
     * The trainers are represented by TrainerPrepared objects,
     * which contain the trainers and their respective Pokemon.
     * The battle continues until one of the trainers has all their Pokemon
     * defeated.
     * preconditions: TP1 != null, TP2 != null
     * 
     * @param TP1 The first TrainerPrepared object representing the first trainer.
     * @param TP2 The second TrainerPrepared object representing the second trainer.
     * @return The Trainer object representing the winner of the battle.
     */
    Trainer startBattle(TrainerPrepared trainer1, TrainerPrepared trainer2);

    /**
     * Method that returns the name of the arena.
     * @return A string with the name of the arena.
     */
    String getName();

    /**
     * Method that returns a string with the details of the arena.
     * The details may be include:
     * - The name of the arena
     * - The credits for the winner
     * - The type of the arena
     * - The difficulty level of the arena
     * @return A string with the details of the arena.
     * 
     */
    String getDetails();

    /**
     * Method that returns the credits for the winner of the arena.
     * @return An integer with the credits for winner of the battle.
     */
    int getCredditsForWinner();

    boolean isBusy();

    void setBusy(boolean busy);

}
