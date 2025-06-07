package model.converters;

import java.util.List;

import model.dto.PokemonDTO;
import model.entities.pokemons.Pokemon;
import model.entities.pokemons.PokemonFactory;

public class PokemonConverter extends Converter<Pokemon, PokemonDTO> {

    @Override
    public PokemonDTO fromEntityToDTO(Pokemon entity) {
        if (entity == null)
            return null;

        PokemonDTO dto = new PokemonDTO();
        dto.setName(entity.getName());
        dto.setXp(entity.getXp());
        dto.setShield(entity.getShield());
        dto.setHealth(entity.getHealth());
        dto.setDamage(entity.getDamage());
        dto.setCost(entity.getCost());
        dto.setType(entity.getClass().getSimpleName());
        return dto;
    }

    @Override
    public Pokemon fromDTOtoEntity(PokemonDTO dto) {
        if (dto == null)
            return null;

        try {
            Pokemon pokemon = PokemonFactory.newPokemon(dto.getName(), dto.getType());
            pokemon.setXp(dto.getXp());
            pokemon.setShield(dto.getShield());
            pokemon.setHealth(dto.getHealth());
            pokemon.setDamage(dto.getDamage());
            pokemon.setCost(dto.getCost());
            return pokemon;
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Error converting DTO to Entity: " + e.getMessage(), e);
        }

    }

}