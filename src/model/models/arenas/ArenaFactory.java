package model.models.arenas;

import model.interfaces.Arena;

public class ArenaFactory {
    public static Arena newArena(String name, String level, String type) throws IllegalArgumentException {

        if (level != "Easy" && level != "Intermediate" && level != "Difficult")
            throw new IllegalArgumentException("Unknwon arena level: " + level);

        if (type != "Forest" && type != "Desert" && type != "Jungle")
            throw new IllegalArgumentException("Unknown arena type: " + type);

        return new ArenaWithLevel(new ArenaWithType(new BaseArena(name), type), level);
    }
}
