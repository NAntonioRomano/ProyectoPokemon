package view.personalizedPanes;

import javax.swing.JPanel;
import javax.swing.JToggleButton;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Desktop.Action;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent; // Necesario para ItemEvent
import java.awt.event.ItemListener; // Necesario para ItemListener

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import model.entities.Gym;
import model.entities.trainers.Trainer;
import view.interfaces.GymView;
import view.personalizedComponents.ButtonWithTrainer;
import view.personalizedComponents.ToggleButtonWithTrainer;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

// TrainerPane ahora implementa ItemListener
public class TrainerPane extends JPanel implements ItemListener {

    private static final long serialVersionUID = 1L;
    private ToggleButtonWithTrainer CenterPaneButton;
    private JPanel SouthPane;
    private JPanel WestPaneData;
    private JPanel CenterPaneData;
    private JLabel TrainerNameLabel;
    private ButtonWithTrainer INVENTORY;
    private ButtonWithTrainer DELETE;
    private JPanel panelDetalle;
    private JPanel panelEliminarButton;
    private JLabel ImgTrainerLabel;
    private JPanel InfoTrainerPane;
    private JLabel TrainerLevel;
    private JLabel TrainerCredits;
    private JLabel TrainerLevelData;
    private JLabel TrainerCreditsData;
    private ImageIcon TrainerIcon;
    private Trainer trainer;
	private final Color SELECT_COLOR = Color.ORANGE;
    private final Color NO_SELECT_COLOR = Color.YELLOW;

    /**
     * Create the panel.
     */
    public TrainerPane(Trainer trainer) {
        this.trainer = trainer;
        this.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.setLayout(new BorderLayout(0, 0));
        this.setBorder(BorderFactory.createLineBorder(getBackground(), 3));

        Dimension prefered_size = new Dimension(250, 150);

        this.setPreferredSize(prefered_size);
        this.setMinimumSize(prefered_size);
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE,150));

        this.CenterPaneButton = new ToggleButtonWithTrainer(trainer);
        add(this.CenterPaneButton, BorderLayout.CENTER);
        this.CenterPaneButton.setLayout(new BorderLayout(0, 0));
        this.CenterPaneButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        this.CenterPaneButton.setOpaque(true); 
        this.CenterPaneButton.addItemListener(this); 
        
        this.WestPaneData = new JPanel();
        Dimension WestPaneData_dimennsion = new Dimension(70, 10);
        this.WestPaneData.setPreferredSize(WestPaneData_dimennsion);
        this.CenterPaneButton.add(this.WestPaneData, BorderLayout.WEST);
        this.WestPaneData.setLayout(new BorderLayout(0, 0));

        this.ImgTrainerLabel = new JLabel("");
        this.ImgTrainerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.ImgTrainerLabel.setIcon(TrainerIcon); 
        this.WestPaneData.add(this.ImgTrainerLabel);

        this.CenterPaneData = new JPanel();
        this.CenterPaneButton.add(this.CenterPaneData, BorderLayout.CENTER);
        this.CenterPaneData.setLayout(new BorderLayout(0, 0));
        this.CenterPaneData.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

        this.TrainerNameLabel = new JLabel(trainer.getName());
        this.TrainerNameLabel.setPreferredSize(new Dimension(75, 20));
        this.TrainerNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.CenterPaneData.add(this.TrainerNameLabel, BorderLayout.NORTH);

        this.InfoTrainerPane = new JPanel();
        this.CenterPaneData.add(this.InfoTrainerPane, BorderLayout.CENTER);
        this.InfoTrainerPane.setLayout(new GridLayout(2, 2, 5, 5));
        this.InfoTrainerPane.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

        this.TrainerLevel = new JLabel("Nivel:");
        this.TrainerLevel.setHorizontalAlignment(SwingConstants.CENTER);
        this.InfoTrainerPane.add(this.TrainerLevel);

        this.TrainerLevelData = new JLabel(Integer.toString(trainer.getCategory()));
        this.InfoTrainerPane.add(this.TrainerLevelData);

        this.TrainerCredits = new JLabel("Creditos:");
        this.TrainerCredits.setHorizontalAlignment(SwingConstants.CENTER);
		this.InfoTrainerPane.add(this.TrainerCredits);

        this.TrainerCreditsData = new JLabel(Integer.toString((int)trainer.getBalance()));
		this.InfoTrainerPane.add(this.TrainerCreditsData);
		

        this.SouthPane = new JPanel();
        add(this.SouthPane, BorderLayout.SOUTH);
        this.SouthPane.setPreferredSize(new Dimension(0, 40));
        this.SouthPane.setLayout(new GridLayout(1, 2, 5, 5));
        this.SouthPane.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

        this.panelDetalle = new JPanel();
        this.SouthPane.add(this.panelDetalle);

        this.INVENTORY = new ButtonWithTrainer("INVENTARIO", trainer);
        this.INVENTORY.setActionCommand("INVENTORY");
        this.panelDetalle.add(this.INVENTORY);

        this.panelEliminarButton = new JPanel();
        this.SouthPane.add(this.panelEliminarButton);

        this.DELETE = new ButtonWithTrainer("ELIMINAR", trainer);
        this.DELETE.setActionCommand(GymView.RMV_TRAINER);
        this.panelEliminarButton.add(this.DELETE);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == CenterPaneButton) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                CenterPaneButton.setBackground(SELECT_COLOR);
            } else {
                CenterPaneButton.setBackground(null);
            }
        }
    }

        public void updateTrainerData() {
            TrainerLevelData.setText(Integer.toString(this.trainer.getCategory()));
            TrainerCreditsData.setText(Integer.toString((int)this.trainer.getBalance()));
            this.revalidate();
            this.repaint();
    }

    public Trainer getTrainer(){
        return this.trainer;
    }


    public JToggleButton getCenterPaneButton() {
        return CenterPaneButton;
    }

    public JButton getInventoryButton() {
        return INVENTORY;
    }

    public JButton getDeleteButton() {
        return DELETE;
    }

    public JLabel getCreditsLabel() {
        return TrainerCreditsData;
    }

    public JLabel getLevelLabel() {
        return TrainerLevelData;
    }
}
