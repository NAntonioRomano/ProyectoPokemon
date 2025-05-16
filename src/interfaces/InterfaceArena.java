package interfaces;

import models.Trainer;
import models.TrainerPrepared;

public interface InterfaceArena {
    Trainer startBattle(TrainerPrepared trainer1, TrainerPrepared trainer2) throws Exception;
    String getName();
    String getDetails();
    int getCredditsForWinner();
}
