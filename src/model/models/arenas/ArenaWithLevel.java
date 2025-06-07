package model.models.arenas;

import model.interfaces.Arena;

public class ArenaWithLevel extends ArenaDecorator {
    private String level;

    public ArenaWithLevel(Arena arena, String level){
        super(arena);
        this.level = level;
    }
    @Override
    public String getName() {
        return getArena().getName();
    }

    @Override
    public String getDetails() {
        return getArena().getDetails() + "\n" +
                "Level: " + this.level + "\n" + 
                "Credits: " + getCredditsForWinner() + "\n";
    }

    @Override
    public int getCredditsForWinner() {
        int credits = getArena().getCredditsForWinner();
        if(level.equalsIgnoreCase("Easy")){
            credits *= 0.9;
        }else if(level.equalsIgnoreCase("Intermediate")){
            credits *= 1.2;
        }else if(level.equalsIgnoreCase("Difficult")){
            credits *= 1.5;
        }
        return credits;
    }

}
