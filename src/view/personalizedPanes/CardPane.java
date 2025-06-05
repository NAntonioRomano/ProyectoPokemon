package view.personalizedPanes;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JPanel;

import model.models.pokemons.Pokemon;
import model.models.weapons.Weapon;

public class CardPane extends JPanel {

    private StatePane statePane;
    private ActionListener actionListener;

    public CardPane(){
        this.setLayout(new BorderLayout());
        this.statePane = new MainMenuStatePane();
        this.add(statePane);
        this.revalidate();
        this.repaint();
    }

    public void setStatePane(StatePane statePane) {
        this.statePane = statePane;
        this.statePane.setActionListener(this.actionListener);
        this.removeAll();
        this.add(statePane, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }

    public void setActionListener(ActionListener listener){
        this.actionListener = listener;
        if (this.statePane != null) {
            this.statePane.setActionListener(listener);
        }
    }

    public String getTrainerName(){return statePane.getTrainerName();}
    public String getArenaName(){return statePane.getArenaName();}
    public String getArenaType(){return statePane.getArenaType();}
    public String getArenaLevel(){return statePane.getArenaLevel();}
    public String getPokemonName(){return statePane.getPokemonName();}
    public String getPokemonType(){return statePane.getPokemonType();}
    public String getWeaponType(){return statePane.getWeaponType();}
    public Pokemon getSelectedPokemon(){return statePane.getSelectedPokemon();}
    public Weapon getSelectedWeapon(){return statePane.getSelectedWeapon();}
    public void updatePokemonList(){statePane.updatePokemonList();}
    public void updateWeaponList(){statePane.updateWeaponList();}

}
