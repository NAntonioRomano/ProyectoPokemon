package models.arenas;

import interfaces.InterfaceArena;

public abstract class ArenaDecorator implements InterfaceArena {
    private InterfaceArena arena;

    public ArenaDecorator(InterfaceArena arena){
        this.arena = arena;
    }

    protected InterfaceArena getArena(){
        return this.arena;
    }
}
