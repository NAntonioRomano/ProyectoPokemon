package view;

import javax.swing.JPanel;
import javax.swing.JToggleButton;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import model.models.Trainer;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class TrainerPane extends JPanel {

	private static final long serialVersionUID = 1L;
	private JToggleButton CenterPaneButton;
	private JPanel SouthPane;
	private JPanel WestPaneData;
	private JPanel CenterPaneData;
	private JLabel TrainerNameLabel;
	private JButton DETALLE;
	private JButton ELIMINAR;
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

	/**
	 * Create the panel.
	 */
	public TrainerPane(ImageIcon icon, Trainer trainer) {
		this.trainer = trainer;
		this.setForeground(new Color(255, 255, 0));
		this.setBackground(new Color(255, 255, 0));
		this.setLayout(new BorderLayout(0, 0));
		this.setBorder(BorderFactory.createLineBorder(getBackground(), 3));
		
		Dimension prefered_size = new Dimension(350,150);
		
		this.setPreferredSize(prefered_size);
		this.setMinimumSize(prefered_size);
		this.setMaximumSize(prefered_size);
		
		this.CenterPaneButton = new JToggleButton();
		add(this.CenterPaneButton, BorderLayout.CENTER);
		this.CenterPaneButton.setLayout(new BorderLayout(0, 0));
		this.CenterPaneButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		
		this.WestPaneData = new JPanel();
		Dimension WestPaneData_dimennsion = new Dimension(70,10);
		this.WestPaneData.setPreferredSize(WestPaneData_dimennsion);
		this.CenterPaneButton.add(this.WestPaneData, BorderLayout.WEST);
		this.WestPaneData.setLayout(new BorderLayout(0, 0));
		
		this.ImgTrainerLabel = new JLabel("");
		this.ImgTrainerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.TrainerIcon = icon;
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
		this.SouthPane.setPreferredSize(new Dimension(0,40));
		this.SouthPane.setLayout(new GridLayout(1, 2, 5, 5));
		this.SouthPane.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		
		this.panelDetalle = new JPanel();
		this.SouthPane.add(this.panelDetalle);
		
		this.DETALLE = new JButton("DETALLE");
		this.panelDetalle.add(this.DETALLE);
		
		this.panelEliminarButton = new JPanel();
		this.SouthPane.add(this.panelEliminarButton);
		
		this.ELIMINAR = new JButton("ELIMINAR");
		this.panelEliminarButton.add(this.ELIMINAR);

	}

}
