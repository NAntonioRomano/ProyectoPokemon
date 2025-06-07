package model.entities.pokemons;

public class PokemonFactory {
    public static Pokemon newPokemon(String name, String type) throws IllegalArgumentException {
        switch (type) {
            case "FirePokemon":
                return new FirePokemon(name);
            case "WaterPokemon":
                return new WaterPokemon(name);
            case "StonePokemon":
                return new StonePokemon(name);
            case "IcePokemon":
                return new IcePokemon(name);
        }

        throw new IllegalArgumentException("Unknown pokemon type: " + type);
    }
}
