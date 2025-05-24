package view.personalizedPanes;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;

import model.models.Trainer;
import view.interfaces.GymView;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class GymPane extends JPanel implements ActionListener,GymView {

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

	private MainMenuStatePane MainMenuStatePane;
	private ShopStatePane ShopStatePane;

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
		this.TrainerContainer.setLayout(new GridLayout(0, 1, 0, 0));
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

		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		
		
		if(this.StatePanel != null) {
			this.InteractivePane.remove(this.StatePanel);
		}
		
		if(action.equals("MAINMENU")) {
			this.StatePanel.setStatePane(new MainMenuStatePane());
		}else if(action.equals("SHOP")) {
			this.StatePanel.setStatePane(new ShopStatePane());
		}else {
			this.StatePanel = null;
		}
		
		this.InteractivePane.add(StatePanel,BorderLayout.CENTER);
		this.InteractivePane.revalidate();
		this.InteractivePane.repaint();
		
	}

	@Override
	public Trainer getTrainer(ActionEvent e) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getTrainer'");
	}

	@Override
	public void addTrainer(Trainer trainer) {
		TrainerPane trainerPane = new TrainerPane(trainer);
		this.TrainerContainer.add(trainerPane);
	}

	@Override
	public String getTrainerName() {
		return this.StatePanel.getTrainerName();
	}

	@Override
	public String getArenaName() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getArenaName'");
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getType'");
	}

	@Override
	public ImageIcon getIcon() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getIcon'");
	}
	@Override
	public void setActionListener(ActionListener actionListener) {
		this.MainMenuButton.addActionListener(actionListener);
		this.ShopButton.addActionListener(actionListener);
		this.TournamentButton.addActionListener(actionListener);
		this.ExitButton.addActionListener(actionListener);
		
		if(this.StatePanel != null) {
			this.StatePanel.setActionListener(actionListener);
		}
		
	}

}