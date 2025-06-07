package model.converters;

import model.dto.TrainerDTO;
import model.entities.trainers.Trainer;

public class TrainerConverter extends Converter<Trainer, TrainerDTO>{

    @Override
    public TrainerDTO fromEntityToDTO(Trainer entity) {
        if (entity == null)
            return null;

        PokemonConverter pokemonConverter = new PokemonConverter();
        WeaponConverter weaponConverter = new WeaponConverter();

        TrainerDTO dto = new TrainerDTO();
        dto.setName(entity.getName());
        dto.setCredits(entity.getBalance());
        dto.setPokemons(pokemonConverter.fromEntitiesToDTOs(entity.getPokemons()));
        dto.setWeapons(weaponConverter.fromEntitiesToDTOs(entity.getWeapons()));
        return dto;
    }

    @Override
    public Trainer fromDTOtoEntity(TrainerDTO dto) {
        if (dto == null)
            return null;

        PokemonConverter pokemonConverter = new PokemonConverter();
        WeaponConverter weaponConverter = new WeaponConverter();

        Trainer entity = new Trainer();
        entity.setName(dto.getName());
        entity.setCredits(dto.getCredits());
        entity.setPokemons(pokemonConverter.fromDTOsToEntities(dto.getPokemons()));
        entity.setWeapons(weaponConverter.fromDTOsToEntities(dto.getWeapons()));
        return entity;
    }

}
