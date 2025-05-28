package view.interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import model.models.Trainer;

public interface GymView extends ActionListener {
    String ADD_TRAINER = "ADD_TRAINER";
    String RMV_TRAINER = "RMV_TRAINER";
    String ADD_ARENA = "ADD_ARENA";
    String RMV_ARENA = "RMV_ARENA";
    String RMV_ITEM = "RMV_ITEM";
    String PURCHASE_POKEMON = "PURCHASE_POKEMON";
    String RMV_POKEMON_FROM_TRAINER = "RMV_POKEMON_FROM_TRAINER";
    String PURCHASE_WEAPON = "PURCHASE_WEAPON";



    void setActionListener(ActionListener listener);
    void addTrainer(Trainer trainer);  
    void ShowErrorMessage(String message);
    void updateTrainerData(Trainer trainer);
    public Trainer getSelectedTrainer();
    String getTrainerName();
    String getArenaName();
    String getArenaType();
    String getArenaLevel();
    String getPokemonName();
    String getPokemonType();
    String getWeaponType();
}
