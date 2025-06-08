package view.personalizedPanes;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import model.interfaces.Arena;
import model.messages.BattleWinner;

public class BattleArenaPane extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;
	private JScrollPane BattleObserverPane;
	private JTextArea BattleTextArea;
	private JPanel Trainer1Pane;
	private JLabel Trainer1NameLabel;
	private JPanel PokemonsT1Pane;
	private JPanel T1Pokemon1;
	private JPanel T1Pokemon2;
	private JPanel T1Pokemon3;
	private JPanel trainer2Pane;
	private JLabel trainer2NameLabel;
	private JPanel pokemonsT2Pane;
	private JPanel pokemon1;
	private JPanel pokemon2;
	private JPanel pokemon3;
	private JLabel pokemon1lbl;
    private Observable obs;

	public BattleArenaPane(Arena arena) {
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), arena.getName()));
		setLayout(new BorderLayout(10, 10));
		
		this.BattleObserverPane = new JScrollPane();
		add(this.BattleObserverPane);
		
		this.BattleTextArea = new JTextArea();
		this.BattleObserverPane.setViewportView(this.BattleTextArea);
		
		this.Trainer1Pane = new JPanel();
		this.Trainer1Pane.setMinimumSize(new Dimension(30, 10));
		add(this.Trainer1Pane, BorderLayout.WEST);
		this.Trainer1Pane.setLayout(new BorderLayout(0, 0));
		
		this.Trainer1NameLabel = new JLabel("TrainerName");
		this.Trainer1Pane.add(this.Trainer1NameLabel, BorderLayout.NORTH);
		
		this.PokemonsT1Pane = new JPanel();
		this.Trainer1Pane.add(this.PokemonsT1Pane, BorderLayout.CENTER);
		this.PokemonsT1Pane.setLayout(new GridLayout(3, 1, 0, 0));
		
		this.T1Pokemon1 = new JPanel();
		this.PokemonsT1Pane.add(this.T1Pokemon1);
		
		this.T1Pokemon2 = new JPanel();
		this.PokemonsT1Pane.add(this.T1Pokemon2);
		
		this.T1Pokemon3 = new JPanel();
		this.PokemonsT1Pane.add(this.T1Pokemon3);
		this.T1Pokemon3.setLayout(new GridLayout(3, 1, 0, 0));
		
		this.trainer2Pane = new JPanel();
		this.trainer2Pane.setMinimumSize(new Dimension(30, 10));
		add(this.trainer2Pane, BorderLayout.EAST);
		this.trainer2Pane.setLayout(new BorderLayout(0, 0));
		
		this.trainer2NameLabel = new JLabel("TrainerName");
		this.trainer2Pane.add(this.trainer2NameLabel, BorderLayout.NORTH);
		
		this.pokemonsT2Pane = new JPanel();
		this.trainer2Pane.add(this.pokemonsT2Pane, BorderLayout.CENTER);
		this.pokemonsT2Pane.setLayout(new GridLayout(3, 1, 0, 0));
		
		this.pokemon1 = new JPanel();
		this.pokemonsT2Pane.add(this.pokemon1);
		this.pokemon1.setLayout(new GridLayout(1, 0, 0, 0));
		
		this.pokemon1lbl = new JLabel("New label");
		this.pokemon1.add(this.pokemon1lbl);
		
		this.pokemon2 = new JPanel();
		this.pokemonsT2Pane.add(this.pokemon2);
		
		this.pokemon3 = new JPanel();
		this.pokemonsT2Pane.add(this.pokemon3);
		this.pokemon3.setLayout(new GridLayout(3, 1, 0, 0));

        this.obs = (Observable)arena;
        this.obs.addObserver(this);
	}

    @Override
    public void update(Observable obj, Object arg) {
                if (obj != obs)
            return;

        if (arg instanceof BattleWinner) {
            BattleWinner battle = (BattleWinner) arg;

            SwingUtilities.invokeLater(() -> {
                BattleTextArea
                        .append("Ganador de " + battle.getInstance() + ": " + battle.getWinner().getName() + " ("
                                + battle.getWinner().getCredits() + ")\n");
            });
        }
    }

}
