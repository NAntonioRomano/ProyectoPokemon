package models.arenas;

import interfaces.InterfaceArena;
import models.Trainer;
import models.TrainerPrepared;

public class ArenaWithType extends ArenaDecorator{

    private String type;

    public ArenaWithType(InterfaceArena arena, String type){
        super(arena);
        this.type = type;
    }

    @Override
    public String getName() {
        return getArena().getName();
    }

    @Override
    public String getDetails() {
        return getArena().getDetails() + "\n" +
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
    public Trainer startBattle(TrainerPrepared trainer1, TrainerPrepared trainer2) throws Exception {
        return getArena().startBattle(trainer1,trainer2);
    }

}