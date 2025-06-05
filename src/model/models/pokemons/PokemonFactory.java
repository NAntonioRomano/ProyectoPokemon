package model.models.pokemons;

public class PokemonFactory {
    public static Pokemon newPokemon(String name, String type) throws IllegalArgumentException {
        switch (type) {
            case "FIRE_POKEMON":
                return new FirePokemon(name);
            case "WATER_POKEMON":
                return new WaterPokemon(name);
            case "STONE_POKEMON":
                return new StonePokemon(name);
            case "ICE_POKEMON":
                return new IcePokemon(name);
        }

        throw new IllegalArgumentException("Unknown pokemon type: " + type);
    }
}
