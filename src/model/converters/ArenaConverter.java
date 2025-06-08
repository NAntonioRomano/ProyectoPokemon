package model.converters;

import model.dto.ArenaDTO;
import model.entities.arenas.ArenaFactory;
import model.interfaces.Arena;

public class ArenaConverter extends Converter<Arena, ArenaDTO> {

    @Override
    public ArenaDTO fromEntityToDTO(Arena entity) {
        if (entity == null)
            return null;

        ArenaDTO dto = new ArenaDTO();
        dto.setName(entity.getName());  
        dto.setLevel(entity.getLevel());
        dto.setType(entity.getType());
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
