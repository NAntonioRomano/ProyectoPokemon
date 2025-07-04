package view.personalizedPanes;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import model.interfaces.Arena;
import model.interfaces.Valuable;
import model.entities.Tournament;
import model.entities.pokemons.Pokemon;
import model.entities.trainers.Trainer;
import model.entities.weapons.Weapon;
import view.MainFrame;
import view.StatePaneFactory;
import view.TournamentFrame;
import view.interfaces.GymView;
import view.personalizedComponents.ButtonWithObject;
import view.personalizedComponents.ToggleButtonWithTrainer;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Color;

public class GymPane extends JPanel implements GymView {

	private static final long serialVersionUID = 1L;
	private JPanel TrainersArenasPane;
	private JPanel InteractivePane;
	private JScrollPane TrainersScrollPane;
	private JScrollPane ArenasScrollPane;
	private JPanel ButtonsPane;
	private JButton MainMenuButton;
	private JButton ShopButton;
	private JButton TournamentButton;
	private JButton ExitButton;
	private CardPane StatePanel;
	private JPanel TrainerContainer;
	private JPanel ArenasContainer;
	private HashMap<Trainer, TrainerPane> TrainerPanes;
	private HashMap<Arena, ArenaPane> ArenaPanes;
	private ButtonGroup TrainerButtonGroup;
	private ActionListener actionListener;

	/**
	 * Create the panel.
	 */
	public GymPane() {
		setMinimumSize(new Dimension(1400, 1000));
		setLayout(new GridLayout(1, 2, 1, 1));

		this.TrainersArenasPane = new JPanel();
		add(this.TrainersArenasPane);
		this.TrainersArenasPane.setLayout(new GridLayout(1, 2, 1, 1));

		this.TrainersScrollPane = new JScrollPane();
		this.TrainersArenasPane.add(this.TrainersScrollPane);

		this.TrainerContainer = new JPanel();
		this.TrainersScrollPane.setViewportView(this.TrainerContainer);
		this.TrainerContainer.setLayout(new BoxLayout(TrainerContainer, BoxLayout.Y_AXIS));
		this.TrainerContainer.setBorder(BorderFactory.createTitledBorder("Entrenadores del gimnasio"));

		this.ArenasScrollPane = new JScrollPane();
		this.TrainersArenasPane.add(this.ArenasScrollPane);

		this.ArenasContainer = new JPanel();
		this.ArenasScrollPane.setViewportView(this.ArenasContainer);
		this.ArenasContainer.setLayout(new BoxLayout(ArenasContainer, BoxLayout.Y_AXIS));
		this.ArenasContainer.setBorder(BorderFactory.createTitledBorder("Arenas del gimnasio"));

		this.InteractivePane = new JPanel();
		add(this.InteractivePane);
		this.InteractivePane.setLayout(new BorderLayout(0, 0));

		this.ButtonsPane = new JPanel();
		this.InteractivePane.add(this.ButtonsPane, BorderLayout.NORTH);
		this.ButtonsPane.setLayout(new GridLayout(1, 4, 1, 1));

		this.MainMenuButton = new JButton("MENU PRINCIPAL");
		this.MainMenuButton.setActionCommand("MAINMENU");
		this.MainMenuButton.addActionListener(this);
		this.ButtonsPane.add(this.MainMenuButton);

		this.ShopButton = new JButton("TIENDA");
		this.ShopButton.setActionCommand("SHOP");
		this.ShopButton.addActionListener(this);
		this.ButtonsPane.add(this.ShopButton);

		this.TournamentButton = new JButton("TORNEO");
		this.TournamentButton.setActionCommand("TOURNAMENT");
		this.TournamentButton.addActionListener(this);
		this.ButtonsPane.add(this.TournamentButton);

		this.ExitButton = new JButton("SALIR");
		this.ExitButton.setActionCommand("EXIT");
		this.ExitButton.addActionListener(this);
		this.ExitButton.setBackground(new Color(255, 255, 255));
		this.ButtonsPane.add(this.ExitButton);

		this.StatePanel = new CardPane();
		this.StatePanel.setActionListener(this);
		this.InteractivePane.add(StatePanel, BorderLayout.CENTER);

		this.TrainerButtonGroup = new ButtonGroup();
		this.TrainerPanes = new HashMap<Trainer, TrainerPane>();
		this.ArenaPanes = new HashMap<Arena, ArenaPane>();

		this.revalidate();
		this.repaint();

	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		this.actionListener = actionListener;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();

		if (action.equals(GymView.RMV_TRAINER)) {
			ButtonWithObject button = (ButtonWithObject) e.getSource();
			this.actionListener.actionPerformed(
					new ActionEvent((Trainer) button.getObject(), ActionEvent.ACTION_PERFORMED, GymView.RMV_TRAINER));
			toRemove((Trainer) button.getObject());
		} else if (action.equals(GymView.ADD_TRAINER)) {
			this.actionListener.actionPerformed(e);
		} else if (action.equals(GymView.ADD_ARENA)) {
			this.actionListener.actionPerformed(e);
		} else if (action.equals(GymView.RMV_ARENA)) {
			ButtonWithObject button = (ButtonWithObject) e.getSource();
			this.actionListener.actionPerformed(
					new ActionEvent((Arena) button.getObject(), ActionEvent.ACTION_PERFORMED, GymView.RMV_ARENA));
			toRemove((Arena) button.getObject());
		} else if (action.equals(GymView.ADD_WEAPON_TO_POKEMON)) {
			this.actionListener.actionPerformed(e);
		} else if (action.equals(GymView.PURCHASE_POKEMON)) {
			this.actionListener.actionPerformed(e);
			this.updateTrainerData();
		} else if (action.equals(GymView.PURCHASE_WEAPON)) {
			this.actionListener.actionPerformed(e);
			this.updateTrainerData();
		} else if (action.equals(GymView.ADD_WEAPON_TO_POKEMON)) {
			this.actionListener.actionPerformed(e);
		} else if (action.equals(GymView.START_TOURNAMENT)) {
			this.actionListener.actionPerformed(e);
		} else if (action.equals(GymView.SELL_VALUABLE_FROM_TRAINER)) {
			ButtonWithObject button = (ButtonWithObject) e.getSource();
			this.actionListener.actionPerformed(
					new ActionEvent((Trainer) button.getObject(), ActionEvent.ACTION_PERFORMED,
							GymView.SELL_VALUABLE_FROM_TRAINER));
			updateTrainerData((Trainer) button.getObject());
		} else if (action.equals("MAINMENU")) {
			this.changeStatePane(action, e.getSource());
		} else if (action.equals("SHOP")) {
			this.changeStatePane(action, e.getSource());
		} else if (action.equals("INVENTORY")) {
			this.changeStatePane(action, e.getSource());
		} else if (action.equals("TOURNAMENT")) {
			this.changeStatePane(action, e.getSource());
		} else if (action.equals("UPDATE")) {
			updateTrainerData((Trainer) e.getSource());
		} else if (action.equals("EXIT")) {
			MainFrame.saveData();
			SwingUtilities.getWindowAncestor(this).dispose();
			System.exit(0);
		} else {
			return;
		}

	}

	@Override
	public void ShowErrorMessage(String message) {
		JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE, null);
	}

	@Override
	public Trainer getSelectedTrainer() {
		Enumeration<AbstractButton> buttons = this.TrainerButtonGroup.getElements();
		while (buttons.hasMoreElements()) {
			ToggleButtonWithTrainer button = (ToggleButtonWithTrainer) buttons.nextElement();
			if (button.isSelected()) {
				return button.getTrainer();
			}
		}
		ShowErrorMessage("Debe seleccionar un entrenador");
		return null;
	}

	public void updateTrainerData() {
		updateTrainerData(this.getSelectedTrainer());
	}

	public void updateTrainerData(Trainer trainer) {
		TrainerPane trainerPane = TrainerPanes.get(trainer);
		trainerPane.updateTrainerData();
		this.revalidate();
		this.repaint();

		this.StatePanel.updatePokemonList();
		this.StatePanel.updateWeaponList();
	}

	@Override
	public Pokemon getSelectedPokemon() {
		if (this.StatePanel.getSelectedPokemon() != null)
			return this.StatePanel.getSelectedPokemon();
		else {
			ShowErrorMessage("Debe seleccionar un pokemon de la lista");
			return null;
		}

	}

	@Override
	public Weapon getSelectedWeapon() {
		if (this.StatePanel.getSelectedWeapon() != null)
			return this.StatePanel.getSelectedWeapon();
		else {
			ShowErrorMessage("Debe seleccionar un arma de la lista");
			return null;
		}
	}

	@Override
	public Valuable getSelectedValuable() {
		return this.StatePanel.getSelectedValuable();
	}

	@Override
	public String getTrainerName() {
		return this.StatePanel.getTrainerName();
	}

	@Override
	public String getArenaName() {
		return this.StatePanel.getArenaName();
	}

	@Override
	public String getArenaType() {
		return this.StatePanel.getArenaType();
	}

	@Override
	public String getPokemonType() {
		return this.StatePanel.getPokemonType();
	}

	@Override
	public String getArenaLevel() {
		return this.StatePanel.getArenaLevel();
	}

	@Override
	public String getPokemonName() {
		return this.StatePanel.getPokemonName();
	}

	@Override
	public String getWeaponType() {
		return this.StatePanel.getWeaponType();
	}

	@Override
	public ArrayList<Trainer> getSelectedTrainers() {
		ArrayList<Trainer> trainers = StatePanel.getSelectedTrainers();
		if (trainers.size() != 8) {
			ShowErrorMessage("Debe selccionar 8 entrenadores");
			return null;
		}
		return trainers;
	}

	public void toRemove(Trainer trainer) {
		TrainerPane trainerPane = this.TrainerPanes.get(trainer);

		this.TrainerContainer.remove(trainerPane);
		this.TrainerButtonGroup.remove(trainerPane.getCenterPaneButton());
		this.TrainerPanes.remove(trainer);
		this.TrainerContainer.revalidate();
		this.TrainerContainer.repaint();

	}

	public void toRemove(Arena arena) {
		ArenaPane arenaPane = this.ArenaPanes.get(arena);

		this.ArenasContainer.remove(arenaPane);
		this.ArenaPanes.remove(arena);
		this.ArenasContainer.revalidate();
		this.ArenasContainer.repaint();
	}

	private void changeStatePane(String type, Object arg) throws IllegalArgumentException {
		StatePane statepane = StatePaneFactory.createStatePane(type);
		this.StatePanel.setStatePane(statepane);

		switch (type) {
			case "TOURNAMENT":
				TournamentStatePane tp = (TournamentStatePane) statepane;
				tp.setTrainers(new ArrayList<Trainer>(TrainerPanes.keySet()));
				break;
			case "INVENTORY":
				InventoryStatePane ip = (InventoryStatePane) statepane;
				ip.setTrainer((Trainer) ((ButtonWithObject) arg).getObject());
				break;
			default:
				break;
		}

		this.InteractivePane.revalidate();
		this.InteractivePane.repaint();
	}

	@Override
	public void addTrainer(Trainer trainer) {
		TrainerPane trainerPane = new TrainerPane(trainer);
		this.TrainerContainer.add(trainerPane);
		this.TrainerPanes.put(trainer, trainerPane);
		this.TrainerButtonGroup.add(trainerPane.getCenterPaneButton());
		trainerPane.setActionListener(this);
		this.revalidate();
		this.repaint();
	}

	@Override
	public void addArena(Arena arena) {
		ArenaPane arenaPane = new ArenaPane(arena);
		this.ArenasContainer.add(arenaPane);
		this.ArenaPanes.put(arena, arenaPane);
		arenaPane.setActionListener(this);
		this.revalidate();
		this.repaint();
	}

	public void restoreView(ArrayList<Trainer> trainers, ArrayList<Arena> arenas) {
		for (int i = 0; i < trainers.size(); i++) {
			addTrainer(trainers.get(i));
		}
		for (int i = 0; i < arenas.size(); i++) {
			addArena(arenas.get(i));
		}
	}

	@Override
	public void startTournament(Tournament tournament) {
		TournamentFrame tf = new TournamentFrame(tournament, new ArrayList<Arena>(ArenaPanes.keySet()));
		tf.setActionListener(this);
	}

}