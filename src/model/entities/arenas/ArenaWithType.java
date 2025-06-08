package model.entities.arenas;

import model.interfaces.Arena;
import model.interfaces.Observer;

public class ArenaWithType extends ArenaDecorator {

    private String type;

    public ArenaWithType(Arena arena, String type) {
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

    public String getType() {
        return type;
    }

    @Override
    public int getCredditsForWinner() {
        if (type.equalsIgnoreCase("Forest"))
            return 700;

        if (type.equalsIgnoreCase("Desert"))
            return 1000;

        if (type.equalsIgnoreCase("Jungle"))
            return 800;

        return 0;
    }

    @Override
    public String getLevel() {
        return getArena().getType();
    }
    
    @Override
    public void addObserver(Observer o) {
        getArena().addObserver(o);
    }

    @Override
    public void notifyObservers(Object args) {
        getArena().notifyObservers(args);
    }

}