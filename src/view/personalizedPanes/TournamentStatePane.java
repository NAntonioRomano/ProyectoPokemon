package view.personalizedPanes;

import javax.swing.JPanel;
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
		setLayout(new GridLayout(0, 2, 0, 0));
		
		this.TrainersScrollPane = new JScrollPane();
		add(this.TrainersScrollPane);
		this.trainerListModel = new DefaultListModel<>();
		this.TrainersList = new JList<Trainer>(trainerListModel);
        this.TrainersList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		this.TrainersScrollPane.setViewportView(this.TrainersList);
		this.TrainersScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(),"Entrenadores disponibles"));
		
		this.ButtonPane = new JPanel();
		add(this.ButtonPane);
		this.ButtonPane.setLayout(new BoxLayout(this.ButtonPane, BoxLayout.Y_AXIS));
		this.ButtonPane.add(Box.createVerticalStrut(120));
		
		this.StartTournamentButton = new JButton("COMENZAR");
		this.StartTournamentButton.setAlignmentX(CENTER_ALIGNMENT);
		this.StartTournamentButton.setAlignmentY(CENTER_ALIGNMENT);
		this.StartTournamentButton.setActionCommand(GymView.START_TOURNAMENT);
		this.ButtonPane.add(this.StartTournamentButton);


	}


    @Override
    public void setActionListener(ActionListener actionListener) {
        this.StartTournamentButton.addActionListener(actionListener);
    }

    @Override
    public ArrayList<Trainer> getSelectedTrainers(){
        ArrayList<Trainer> trainers = (ArrayList<Trainer>)this.TrainersList.getSelectedValuesList();
        return trainers;
    }

    public void setTrainers(ArrayList<Trainer> trainers){
        this.trainerListModel.clear();
		for (Trainer t : trainers) {
			this.trainerListModel.addElement(t);
		}
		this.revalidate();
		this.repaint();
    }

}
