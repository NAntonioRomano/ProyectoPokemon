package model.models.arenas;

import model.interfaces.Arena;

public abstract class ArenaDecorator implements Arena {
    private Arena arena;

    public ArenaDecorator(Arena arena){
        this.arena = arena;
    }

    protected Arena getArena(){
        return this.arena;
    }
}
