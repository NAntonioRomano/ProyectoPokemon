package model.dto;

import java.io.Serializable;
import java.util.List;

public class GymDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private List<TrainerDTO> trainers;
    private List<ArenaDTO> arenas;

    public List<TrainerDTO> getTrainers() {
        return trainers;
    }

    public List<ArenaDTO> getArenas() {
        return arenas;
    }

    public void setTrainers(List<TrainerDTO> trainers) {
        this.trainers = trainers;
    }

    public void setArenas(List<ArenaDTO> arenas) {
        this.arenas = arenas;
    }
}
