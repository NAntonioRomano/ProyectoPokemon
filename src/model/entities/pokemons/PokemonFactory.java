package model.entities.pokemons;

public class PokemonFactory {

    /**
     * Creates a new instance of a specific type of Pokemon based on the provided
     * name and type.
     * preconditions: name != null && type != null
     * 
     * @param name the name of the Pokemon to create
     * @param type the type of Pokemon to create (e.g., "FirePokemon",
     *             "WaterPokemon", etc.)
     * @return a new Pokemon instance of the specified type
     * @throws IllegalArgumentException if the specified type is unknown
     */

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
