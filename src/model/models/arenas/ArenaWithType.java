package model.models.arenas;

import model.interfaces.Arena;
import model.models.Trainer;
import model.models.TrainerPrepared;

public class ArenaWithType extends ArenaDecorator{

    private String type;

    public ArenaWithType(Arena arena, String type){
        super(arena);
        this.type = type;
    }

    @Override
    public String getName() {
        return getArena().getName();
    }

    @Override
    public String getDetails() {
        return getArena().getDetails() +
                "Type: " + this.type + "\n";
    }

    @Override
    public int getCredditsForWinner() {
        int credits = 0;
        if(type.equalsIgnoreCase("Forest")){
            credits = 700;
        }else if(type.equalsIgnoreCase("Desert")){
            credits = 1000;
        }else if(type.equalsIgnoreCase("Jungle")){
            credits = 800;
        }

        return credits;
    }

    @Override
    public Trainer startBattle(TrainerPrepared trainer1, TrainerPrepared trainer2){
        return getArena().startBattle(trainer1,trainer2);
    }

    @Override
    public boolean isBusy() {
        return getArena().isBusy();
    }
    @Override
    public void setBusy(boolean busy) {
        getArena().setBusy(busy);
    }

}