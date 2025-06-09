package view.personalizedPanes;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;
import model.entities.Battle;
import model.entities.pokemons.Pokemon;
import model.interfaces.Arena;
import model.interfaces.Observable;
import model.interfaces.Observer;
import model.messages.BattleTrainers;
import model.messages.BattleWinner;
import model.messages.DeadPokemon;
import model.messages.PokemonAttack;

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
	private JPanel Trainer2Pane;
	private JLabel Trainer2NameLabel;
	private JPanel pokemonsT2Pane;
	private JPanel T2Pokemon1;
	private JPanel T2Pokemon2;
	private JPanel T2Pokemon3;
	private JLabel[] T2Pokemonlbl = new JLabel[3];
	private JLabel[] T1Pokemonlbl = new JLabel[3];
	private Pokemon[] inBattle1;
	private Pokemon[] inBattle2;

	private Observable obs;

	public BattleArenaPane(Arena arena) {
		this.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLoweredBevelBorder(), arena.getName()));
		setLayout(new BorderLayout(0, 0));
		this.setPreferredSize(new Dimension(300, 200));
		this.setMinimumSize(new Dimension(250, 150));
		this.setMaximumSize(new Dimension(Integer.MAX_VALUE, 250));

		// --- Trainer 1 arriba ---
		JPanel topTrainerPane = new JPanel(new BorderLayout(0, 5));
		// Nombre
		this.Trainer1NameLabel = new JLabel("Trainer 1", SwingConstants.CENTER);
		this.Trainer1NameLabel.setFont(new Font("SansSerif", Font.BOLD, 16));

		topTrainerPane.add(this.Trainer1NameLabel, BorderLayout.NORTH);
		// Pokémons en una fila
		JPanel pokemonsRow1 = new JPanel(new GridLayout(1, 3, 5, 0));
		for (int i = 0; i < 3; i++) {
			JPanel slot = new JPanel();
			this.T1Pokemonlbl[i] = new JLabel("Unknown", SwingConstants.CENTER);
			slot.add(this.T1Pokemonlbl[i]);
			pokemonsRow1.add(slot);
		}
		topTrainerPane.add(pokemonsRow1, BorderLayout.CENTER);
		add(topTrainerPane, BorderLayout.NORTH);
		// --- Texto de batalla en el centro ---
		this.BattleObserverPane = new JScrollPane();
		this.BattleTextArea = new JTextArea();
		this.BattleObserverPane.setViewportView(this.BattleTextArea);
		add(this.BattleObserverPane, BorderLayout.CENTER);

		// --- Trainer 2 abajo ---
		JPanel bottomTrainerPane = new JPanel(new BorderLayout(0, 5));
		// Nombre
		this.Trainer2NameLabel = new JLabel("Trainer 2", SwingConstants.CENTER);
		this.Trainer2NameLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
		bottomTrainerPane.add(this.Trainer2NameLabel, BorderLayout.NORTH);
		// Pokémons en una fila
		JPanel pokemonsRow2 = new JPanel(new GridLayout(1, 3, 5, 0));
		for (int i = 0; i < 3; i++) {
			JPanel slot = new JPanel();
			this.T2Pokemonlbl[i] = new JLabel("Unknown", SwingConstants.CENTER);
			slot.add(this.T2Pokemonlbl[i]);
			pokemonsRow2.add(slot);
		}
		bottomTrainerPane.add(pokemonsRow2, BorderLayout.CENTER);
		add(bottomTrainerPane, BorderLayout.SOUTH);

		// Observador
		this.obs = arena;
		obs.addObserver(this);
	}

	@Override
	public void update(Observable obj, Object arg) {
		if (arg instanceof BattleTrainers) {
			BattleTrainers battle = (BattleTrainers) arg;

			SwingUtilities.invokeLater(() -> {
				Trainer1NameLabel.setText(battle.getTrainer1().getName());
				Trainer2NameLabel.setText(battle.getTrainer2().getName());
				inBattle1 = battle.getTrainer1().getPokemons();
				inBattle2 = battle.getTrainer2().getPokemons();
				setPokemonText(1, inBattle1);
				setPokemonText(2, inBattle2);
				BattleTextArea.setText("");
				BattleTextArea
						.append("Comienza la batalla entre :" +
								battle.getTrainer1().getName() + "y " + battle.getTrainer2().getName() + "\n");
			});
		} else if (arg instanceof PokemonAttack) {
			PokemonAttack attack = (PokemonAttack) arg;
			SwingUtilities.invokeLater(() -> {
				BattleTextArea
						.append(attack.getAttacker().getName() + " le inflinge a " + attack.getAttacked().getName()
								+ " " + String.format("%.2f", attack.getAttacker().getAttack()) + " de danio" + "\n");
				setPokemonText(1, inBattle1);
				setPokemonText(2, inBattle2);
			});
		} else if (arg instanceof DeadPokemon) {
			DeadPokemon dead = (DeadPokemon) arg;
			SwingUtilities.invokeLater(() -> {
				BattleTextArea
						.append(dead.getDeadPokemon().getName() + " murio" + "\n");
			});
		}
	}

	private void setPokemonText(int number, Pokemon[] pokemons) {
		if (number == 1) {
			for (int i = 0; i < pokemons.length; i++) {
				T1Pokemonlbl[i].setText(
						(pokemons[i].getName() + "(" + String.format("%.2f", pokemons[i].getHealth()) + "Hp)"));
			}
			for (int i = pokemons.length; i < T1Pokemonlbl.length; i++) {
				T1Pokemonlbl[i].setText("");
			}
		} else {
			for (int i = 0; i < pokemons.length; i++) {
				T2Pokemonlbl[i]
						.setText(pokemons[i].getName() + "(" + String.format("%.2f", pokemons[i].getHealth()) + "Hp)");
			}
			for (int i = pokemons.length; i < T2Pokemonlbl.length; i++) {
				T2Pokemonlbl[i].setText("");
			}
		}
	}

}
