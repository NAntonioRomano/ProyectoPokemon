package model.entities.arenas;

import model.interfaces.Arena;

public class ArenaFactory {
    public static Arena newArena(String name, String level, String type) throws IllegalArgumentException {
        return new ArenaWithLevel(new ArenaWithType(new BaseArena(name), type), level);
    }
}
