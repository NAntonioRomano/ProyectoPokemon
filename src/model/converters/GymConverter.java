package model.converters;

import model.dto.GymDTO;
import model.entities.Gym;

public class GymConverter extends Converter<Gym, GymDTO> {

    @Override
    public GymDTO fromEntityToDTO(Gym entity) {
        if (entity == null)
            return null;

        TrainerConverter trainerConverter = new TrainerConverter();
        ArenaConverter arenaConverter = new ArenaConverter();

        GymDTO dto = new GymDTO();
        dto.setTrainers(trainerConverter.fromEntitiesToDTOs(entity.getTrainers()));
        dto.setArenas(arenaConverter.fromEntitiesToDTOs(entity.getArenas()));
        return dto;
    }

    @Override
    public Gym fromDTOtoEntity(GymDTO dto) {
        if (dto == null)
            return null;

        TrainerConverter trainerConverter = new TrainerConverter();
        ArenaConverter arenaConverter = new ArenaConverter();

        Gym gym = new Gym();
        gym.setTrainers(trainerConverter.fromDTOsToEntities(dto.getTrainers()));
        gym.setArenas(arenaConverter.fromDTOsToEntities(dto.getArenas()));
        return gym;
    }

}
