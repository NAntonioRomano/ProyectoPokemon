package model.dto;

import java.io.Serializable;
import java.util.List;

public class TrainerDTO implements Serializable {
    private String name;
    private double credits;
    private List<PokemonDTO> pokemons;
    private List<WeaponDTO> weapons;

    public String getName() {
        return name;
    }

    public double getCredits() {
        return credits;
    }

    public List<PokemonDTO> getPokemons() {
        return pokemons;
    }

    public List<WeaponDTO> getWeapons() {
        return weapons;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    public void setPokemons(List<PokemonDTO> pokemons) {
        this.pokemons = pokemons;
    }

    public void setWeapons(List<WeaponDTO> weapons) {
        this.weapons = weapons;
    }
}
