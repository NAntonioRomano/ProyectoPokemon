package view.personalizedPanes;

import javax.swing.JPanel;

import model.entities.pokemons.Pokemon;
import model.entities.weapons.Weapon;

import java.awt.event.ActionListener;
import java.util.List;


public abstract class StatePane extends JPanel{

    public void setActionListener(ActionListener actionListener){}
    public String getTrainerName(){return null;}
    public String getArenaName(){return null;}
    public String getArenaType(){return null;}
    public String getArenaLevel(){return null;}
    public String getPokemonName(){return null;}
    public String getPokemonType(){return null;}
    public String getWeaponType(){return null;}
    public Pokemon getSelectedPokemon(){return null;}
    public Weapon getSelectedWeapon(){return null;}
    public void updatePokemonList(){}
    public void updateWeaponList(){}


}
