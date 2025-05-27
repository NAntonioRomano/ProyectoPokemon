package view.interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import model.models.Trainer;

public interface GymView {
    String ADD_TRAINER = "ADD_TRAINER";
    String RMV_TRAINER = "RMV_TRAINER";
    String ADD_ARENA = "ADD_ARENA";
    String RMV_ARENA = "RMV_ARENA";
    String ADD_ITEM = "ADD_ITEM";
    String RMV_ITEM = "RMV_ITEM";
    String ADD_POKEMON_TO_TRAINER = "ADD_POKEMON_TO_TRAINER";
    String RMV_POKEMON_FROM_TRAINER = "RMV_POKEMON_FROM_TRAINER";



    void setActionListener(ActionListener listener);
    Trainer toRemove(ActionEvent e);
    void addTrainer(Trainer trainer);
    String getTrainerName();
    String getArenaName();
    String getType();
    ImageIcon getIcon();   
    void ShowErrorMessage(String message); 
}
