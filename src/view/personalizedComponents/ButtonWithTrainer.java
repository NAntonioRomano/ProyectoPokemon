package view.personalizedComponents;

import javax.swing.JButton;

import model.entities.trainers.Trainer;

public class ButtonWithTrainer extends JButton {
    private Trainer trainer;

    public ButtonWithTrainer(String text, Trainer trainer) {
        super(text);
        this.trainer = trainer;
    }

    public Trainer getTrainer() {
        return trainer;
    }
    
}
