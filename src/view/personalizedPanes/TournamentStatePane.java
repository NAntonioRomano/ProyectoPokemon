package view.personalizedPanes;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import model.entities.trainers.Trainer;

import view.interfaces.GymView;

import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

public class TournamentStatePane extends StatePane {

	private static final long serialVersionUID = 1L;
	private JScrollPane TrainersScrollPane;
	private JPanel ButtonPane;
	private JList<Trainer> TrainersList;
	private JButton StartTournamentButton;
	private DefaultListModel<Trainer> trainerListModel;

	public TournamentStatePane() {
		setLayout(new BorderLayout());

		// Scroll con la lista de entrenadores
		this.TrainersScrollPane = new JScrollPane();
		this.trainerListModel = new DefaultListModel<>();
		this.TrainersList = new JList<>(trainerListModel);
		this.TrainersList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		this.TrainersScrollPane.setViewportView(this.TrainersList);
		this.TrainersScrollPane.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLoweredBevelBorder(), "Entrenadores disponibles"));
		add(this.TrainersScrollPane, BorderLayout.CENTER); // Ocupa el espacio restante

		// Panel inferior con botón de inicio
		this.ButtonPane = new JPanel();
		this.ButtonPane.setLayout(new BoxLayout(this.ButtonPane, BoxLayout.Y_AXIS));

		this.StartTournamentButton = new JButton("COMENZAR TORNEO");
		this.StartTournamentButton.setFont(new Font("SansSerif", Font.BOLD, 20));
		this.StartTournamentButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
		this.StartTournamentButton.setPreferredSize(new Dimension(200, 100)); // Alto deseado

		this.StartTournamentButton.setActionCommand(GymView.START_TOURNAMENT);
		this.StartTournamentButton.setAlignmentX(CENTER_ALIGNMENT);

		this.ButtonPane.add(Box.createVerticalGlue()); // Empuja el botón hacia abajo
		this.ButtonPane.add(this.StartTournamentButton);

		add(this.ButtonPane, BorderLayout.SOUTH); // Panel ocupa solo el alto necesario
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		this.StartTournamentButton.addActionListener(actionListener);
	}

	@Override
	public ArrayList<Trainer> getSelectedTrainers() {
		ArrayList<Trainer> trainers = (ArrayList<Trainer>) this.TrainersList.getSelectedValuesList();
		return trainers;
	}

	public void setTrainers(ArrayList<Trainer> trainers) {
		this.trainerListModel.clear();
		for (Trainer t : trainers) {
			this.trainerListModel.addElement(t);
		}
		this.revalidate();
		this.repaint();
	}

}
