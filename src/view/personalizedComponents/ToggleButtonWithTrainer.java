package view.personalizedComponents;

import javax.swing.JToggleButton;

import model.models.Trainer;

public class ToggleButtonWithTrainer extends JToggleButton {
    private Trainer trainer;

    public ToggleButtonWithTrainer(Trainer trainer) {
        super();
        this.trainer = trainer;
    }

    public Trainer getTrainer() {
        return trainer;
    }
}
