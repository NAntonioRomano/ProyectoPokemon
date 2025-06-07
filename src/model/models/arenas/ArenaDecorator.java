package model.models.arenas;

import model.interfaces.Arena;
import model.models.trainers.Trainer;
import model.models.trainers.TrainerPrepared;

public abstract class ArenaDecorator implements Arena {
    private Arena arena;

    public ArenaDecorator(Arena arena) {
        this.arena = arena;
    }

    protected Arena getArena() {
        return this.arena;
    }

    @Override
    public Trainer startBattle(TrainerPrepared trainer1, TrainerPrepared trainer2) {
        return getArena().startBattle(trainer1, trainer2);
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
