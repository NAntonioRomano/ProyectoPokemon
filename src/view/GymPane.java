package view;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Color;

public class GymPane extends JPanel {

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
	private JPanel StatePanel;
	private JPanel TrainerContainer;
	private JPanel ArenasContainer;

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
		this.TrainersScrollPane.setLayout(new GridLayout(0,1,1,1));
		
		this.TrainerContainer = new JPanel();
		this.TrainersScrollPane.setViewportView(this.TrainerContainer);
		this.TrainerContainer.setLayout(new GridLayout(0, 1, 0, 0));
		this.TrainerContainer.setBorder(BorderFactory.createTitledBorder("Entrenadores del gimnasio"));
		
		this.ArenasScrollPane = new JScrollPane();
		this.TrainersArenasPane.add(this.ArenasScrollPane);
		this.ArenasScrollPane.setLayout(new GridLayout(0,1,1,1));
		
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
		this.ButtonsPane.add(this.MainMenuButton);
		
		this.ShopButton = new JButton("TIENDA");
		this.ButtonsPane.add(this.ShopButton);
		
		this.TournamentButton = new JButton("TORNEO");
		this.ButtonsPane.add(this.TournamentButton);
		
		this.ExitButton = new JButton("SALIR");
		this.ExitButton.setBackground(new Color(255, 255, 255));
		this.ButtonsPane.add(this.ExitButton);
		
		this.StatePanel = new JPanel();
		this.InteractivePane.add(this.StatePanel, BorderLayout.CENTER);
		this.StatePanel.setLayout(new BorderLayout(0, 0));

		
	}
}
