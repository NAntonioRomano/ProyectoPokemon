package model.converters;

import java.util.List;
import java.util.stream.Collectors;

public abstract class Converter<Entity, DTO> {

  public abstract DTO fromEntityToDTO(Entity entity);

  public abstract Entity fromDTOtoEntity(DTO dto);

  public List<DTO> fromEntitiesToDTOs(List<Entity> entities) {
    return entities.stream()
        .map(this::fromEntityToDTO)
        .collect(Collectors.toList());
  }

  public List<Entity> fromDTOsToEntities(List<DTO> dtos) {
    return dtos.stream()
        .map(this::fromDTOtoEntity)
        .collect(Collectors.toList());
  }

}