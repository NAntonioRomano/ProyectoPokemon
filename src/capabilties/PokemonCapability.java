package capabilties;

import models.pokemons.Pokemon;

public interface PokemonCapability {
    void onPokemonPurchased(Pokemon pokemon);

    boolean canPokemonBePurchased(Pokemon pokemon);
}
