package view.interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import model.models.Trainer;

public interface GymView {
    void setActionListener(ActionListener listener);
    Trainer getTrainer(ActionEvent e);
    void addTrainer(Trainer trainer);
    String getTrainerName();
    String getArenaName();
    String getType();
    ImageIcon getIcon();    
}
