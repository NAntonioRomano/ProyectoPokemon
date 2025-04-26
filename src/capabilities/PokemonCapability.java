package capabilities;

import models.pokemons.Pokemon;

/**
 * This interface defines the capabilities related to pokemon.
 * It includes methods for handling pokemon purchases and checking if a pokemon
 * can be purchased.
 */
public interface PokemonCapability {

    /**
     * This method is called when a pokemon is purchased.
     *
     * @param pokemon The pokemon that was purchased.
     */
    void onPokemonPurchased(Pokemon pokemon);

    /**
     * This method checks if a pokemon can be purchased.
     *
     * @param pokemon The pokemon to check.
     * @return true if the pokemon can be purchased, false otherwise.
     */
    boolean canPokemonBePurchased(Pokemon pokemon);
}
