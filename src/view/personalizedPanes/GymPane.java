package view.personalizedPanes;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;

import model.models.Trainer;
import model.models.pokemons.Pokemon;
import model.models.weapons.Weapon;
import view.interfaces.GymView;
import view.personalizedComponents.ButtonWithTrainer;
import view.personalizedComponents.ToggleButtonWithTrainer;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
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
	private HashMap<Trainer,TrainerPane> TrainerPanes;
	private ButtonGroup TrainerButtonGroup;
	private ActionListener actionListener;

	/**
	 * Create the panel.
	 */
	public GymPane() {
		setMinimumSize(new Dimension(1400, 1400));
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
		this.ArenasContainer.setLayout(new GridLayout(0, 1, 0, 0));
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
		this.InteractivePane.add(StatePanel,BorderLayout.CENTER);

		this.TrainerButtonGroup = new ButtonGroup();
		this.TrainerPanes = new HashMap<Trainer, TrainerPane>();

		this.revalidate();
		this.repaint();

		
		
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		this.actionListener = actionListener;
		if(this.StatePanel != null) {
			this.StatePanel.setActionListener(actionListener);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		
		if(action.equals(GymView.RMV_TRAINER)){
			ButtonWithTrainer button = (ButtonWithTrainer) e.getSource();
			this.actionListener.actionPerformed(new ActionEvent(button.getTrainer(), ActionEvent.ACTION_PERFORMED, GymView.RMV_TRAINER));
			toRemove(button.getTrainer());

		}else if(action.equals("MAINMENU")) {
			this.InteractivePane.remove(this.StatePanel);
			this.StatePanel.setStatePane(new MainMenuStatePane());
		}else if(action.equals("SHOP")) {
			this.InteractivePane.remove(this.StatePanel);
			this.StatePanel.setStatePane(new ShopStatePane());
		}else if(action.equals("INVENTORY")){
			ButtonWithTrainer button = (ButtonWithTrainer) e.getSource();
			this.InteractivePane.remove(this.StatePanel);
			this.StatePanel.setStatePane(new InventoryStatePane(button.getTrainer()));
		}else {
			this.StatePanel = null;
		}
		
		this.InteractivePane.add(StatePanel,BorderLayout.CENTER);
		this.InteractivePane.revalidate();
		this.InteractivePane.repaint();
		
	}

	@Override
	public void ShowErrorMessage(String message) {
		JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE, null);
	}

	public void toRemove(Trainer trainer) {
		TrainerPane trainerPane = this.TrainerPanes.get(trainer);
		if (trainerPane != null) {
			this.TrainerContainer.remove(trainerPane);
			this.TrainerButtonGroup.remove(trainerPane.getCenterPaneButton());
			this.TrainerPanes.remove(trainer);
			this.TrainerContainer.revalidate();
			this.TrainerContainer.repaint();
		} else {
			ShowErrorMessage("Trainer not found.");
		}
	}

	@Override
	public void addTrainer(Trainer trainer) {
		TrainerPane trainerPane = new TrainerPane(trainer);
		trainerPane.getDeleteButton().addActionListener(this);
		trainerPane.getInventoryButton().addActionListener(this);
		this.TrainerContainer.add(trainerPane);
		this.TrainerButtonGroup.add(trainerPane.getCenterPaneButton());
		this.TrainerPanes.put(trainer, trainerPane);
		this.TrainerContainer.revalidate();
		this.TrainerContainer.repaint();
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
	public Trainer getSelectedTrainer() {
		Enumeration<AbstractButton> buttons = this.TrainerButtonGroup.getElements();
		while (buttons.hasMoreElements()) {
			ToggleButtonWithTrainer button = (ToggleButtonWithTrainer) buttons.nextElement();
			if (button.isSelected()) {
				return button.getTrainer();
			}
		}
		return null;
	}

	@Override
	public void updateTrainerData(Trainer trainer) {
		if(trainer != null){
			TrainerPane trainerPane = TrainerPanes.get(trainer);
			trainerPane.updateTrainerData();
			this.revalidate();
			this.repaint();
		}
		this.StatePanel.updatePokemonList();
		this.StatePanel.updateWeaponList();
	}

	@Override
	public Pokemon getSelectedPokemon() {
		if(this.StatePanel.getSelectedPokemon() != null)
			return this.StatePanel.getSelectedPokemon();
		else{
			ShowErrorMessage("Debe seleccionar un pokemon de la lista");
			return null;
		}
		
	}

	@Override
	public Weapon getSelectedWeapon() {
		if(this.StatePanel.getSelectedWeapon() != null)
			return this.StatePanel.getSelectedWeapon();
		else{
			ShowErrorMessage("Debe seleccionar un arma de la lista");
			return null;
		}
	}

	

}