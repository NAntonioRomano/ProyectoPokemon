package view.personalizedPanes;

import javax.swing.JPanel;
import javax.swing.JToggleButton;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import model.entities.trainers.Trainer;

import view.interfaces.GymView;
import view.personalizedComponents.ButtonWithObject;
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
    private ButtonWithObject INVENTORY;
    private ButtonWithObject DELETE;
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

    /**
     * Create the panel.
     */
    public TrainerPane(Trainer trainer) {
        this.trainer = trainer;
        this.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.setLayout(new BorderLayout(0, 0));
        this.setBackground(new Color(245, 245, 245));
        this.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 2),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        Dimension preferredSize = new Dimension(250, 130);
        this.setPreferredSize(preferredSize);
        this.setMinimumSize(preferredSize);
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE, 150));

        this.CenterPaneButton = new ToggleButtonWithTrainer(trainer);
        this.CenterPaneButton.setLayout(new BorderLayout(0, 0));
        this.CenterPaneButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        this.CenterPaneButton.setOpaque(true);
        this.CenterPaneButton.addItemListener(this);
        this.CenterPaneButton.setBackground(Color.WHITE);
        add(this.CenterPaneButton, BorderLayout.CENTER);

        this.WestPaneData = new JPanel(new BorderLayout(0, 0));
        this.WestPaneData.setPreferredSize(new Dimension(70, 10));
        this.WestPaneData.setBackground(Color.WHITE);
        this.CenterPaneButton.add(this.WestPaneData, BorderLayout.WEST);

        this.ImgTrainerLabel = new JLabel("", SwingConstants.CENTER);
        // this.ImgTrainerLabel.setIcon(new
        // ImageIcon(getClass().getResource("/assets/default_trainer.png")));
        this.WestPaneData.add(this.ImgTrainerLabel);

        this.CenterPaneData = new JPanel(new BorderLayout(0, 0));
        this.CenterPaneData.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        this.CenterPaneData.setBackground(Color.WHITE);
        this.CenterPaneButton.add(this.CenterPaneData, BorderLayout.CENTER);

        this.TrainerNameLabel = new JLabel(trainer.getName(), SwingConstants.CENTER);
        this.TrainerNameLabel.setPreferredSize(new Dimension(75, 20));
        this.TrainerNameLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        this.CenterPaneData.add(this.TrainerNameLabel, BorderLayout.NORTH);

        this.InfoTrainerPane = new JPanel(new GridLayout(2, 2, 5, 5));
        this.InfoTrainerPane.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        this.InfoTrainerPane.setBackground(Color.WHITE);
        this.CenterPaneData.add(this.InfoTrainerPane, BorderLayout.CENTER);

        this.TrainerLevel = new JLabel("Nivel:", SwingConstants.CENTER);
        this.TrainerLevel.setFont(new Font("SansSerif", Font.PLAIN, 12));
        this.InfoTrainerPane.add(this.TrainerLevel);

        this.TrainerLevelData = new JLabel(String.valueOf(trainer.getCategory()));
        this.TrainerLevelData.setFont(new Font("SansSerif", Font.PLAIN, 12));
        this.InfoTrainerPane.add(this.TrainerLevelData);

        this.TrainerCredits = new JLabel("Créditos:", SwingConstants.CENTER);
        this.TrainerCredits.setFont(new Font("SansSerif", Font.PLAIN, 12));
        this.InfoTrainerPane.add(this.TrainerCredits);

        this.TrainerCreditsData = new JLabel(String.valueOf((int) trainer.getBalance()));
        this.TrainerCreditsData.setFont(new Font("SansSerif", Font.PLAIN, 12));
        this.InfoTrainerPane.add(this.TrainerCreditsData);

        this.SouthPane = new JPanel(new GridLayout(1, 2, 5, 5));
        this.SouthPane.setPreferredSize(new Dimension(0, 40));
        this.SouthPane.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        this.SouthPane.setBackground(new Color(250, 250, 250));
        add(this.SouthPane, BorderLayout.SOUTH);

        this.panelDetalle = new JPanel();
        this.panelDetalle.setBackground(new Color(250, 250, 250));
        this.SouthPane.add(this.panelDetalle);

        this.INVENTORY = new ButtonWithObject("Inventario", trainer);
        this.INVENTORY.setActionCommand("INVENTORY");
        this.INVENTORY.setBackground(new Color(220, 240, 255));
        this.INVENTORY.setFont(new Font("SansSerif", Font.BOLD, 12));
        this.panelDetalle.add(this.INVENTORY);

        this.panelEliminarButton = new JPanel();
        this.panelEliminarButton.setBackground(new Color(250, 250, 250));
        this.SouthPane.add(this.panelEliminarButton);

        this.DELETE = new ButtonWithObject("Eliminar", trainer);
        this.DELETE.setActionCommand(GymView.RMV_TRAINER);
        this.DELETE.setBackground(new Color(255, 220, 220));
        this.DELETE.setFont(new Font("SansSerif", Font.BOLD, 12));
        this.panelEliminarButton.add(this.DELETE);
    }

    public void setActionListener(ActionListener listener) {
        this.DELETE.addActionListener(listener);
        this.INVENTORY.addActionListener(listener);
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
        TrainerCreditsData.setText(Integer.toString((int) this.trainer.getBalance()));
        this.revalidate();
        this.repaint();
    }

    public Trainer getTrainer() {
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
