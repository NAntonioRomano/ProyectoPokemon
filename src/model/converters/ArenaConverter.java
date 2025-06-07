package model.converters;

import model.dto.ArenaDTO;
import model.entities.arenas.ArenaFactory;
import model.entities.arenas.ArenaWithLevel;
import model.entities.arenas.ArenaWithType;
import model.interfaces.Arena;

public class ArenaConverter extends Converter<Arena, ArenaDTO> {

    @Override
    public ArenaDTO fromEntityToDTO(Arena entity) {
        if (entity == null)
            return null;

        ArenaDTO dto = new ArenaDTO();
        dto.setName(entity.getName());

        if (entity instanceof ArenaWithType) {
            ArenaWithType arenaWithType = (ArenaWithType) entity;
            dto.setType(arenaWithType.getType());
        }

        if (entity instanceof ArenaWithLevel) {
            ArenaWithLevel arenaWithLevel = (ArenaWithLevel) entity;
            dto.setLevel(arenaWithLevel.getLevel());
        }

        dto.setCreditsForWinner(entity.getCredditsForWinner());
        return dto;
    }

    @Override
    public Arena fromDTOtoEntity(ArenaDTO dto) {
        if (dto == null)
            return null;

        return ArenaFactory.newArena(dto.getName(), dto.getType(), dto.getLevel());
    }

}
