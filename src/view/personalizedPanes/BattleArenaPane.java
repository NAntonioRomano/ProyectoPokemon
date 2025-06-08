package view.personalizedPanes;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

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

    private Observable obs;

	public BattleArenaPane(Arena arena) {
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), arena.getName()));
		setLayout(new BorderLayout(0, 0));
        this.setPreferredSize(new Dimension(300, 200));
        this.setMinimumSize(new Dimension(250, 150));
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE, 250));
		
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
		
		this.T1Pokemonlbl[0] = new JLabel("Unknown");
		this.T1Pokemon1.add(this.T1Pokemonlbl[0]);
		
		this.T1Pokemon2 = new JPanel();
		this.PokemonsT1Pane.add(this.T1Pokemon2);
		
		this.T1Pokemonlbl[1] = new JLabel("Unknown");
		this.T1Pokemon2.add(this.T1Pokemonlbl[1]);
		
		this.T1Pokemon3 = new JPanel();
		this.PokemonsT1Pane.add(this.T1Pokemon3);
		this.T1Pokemon3.setLayout(new GridLayout(3, 1, 0, 0));
		
		this.T1Pokemonlbl[2] = new JLabel("Unknown");
		this.T1Pokemon3.add(this.T1Pokemonlbl[2]);
		
		this.Trainer2Pane = new JPanel();
		this.Trainer2Pane.setMinimumSize(new Dimension(30, 10));
		add(this.Trainer2Pane, BorderLayout.EAST);
		this.Trainer2Pane.setLayout(new BorderLayout(0, 0));
		
		this.Trainer2NameLabel = new JLabel("TrainerName");
		this.Trainer2Pane.add(this.Trainer2NameLabel, BorderLayout.NORTH);
		
		this.pokemonsT2Pane = new JPanel();
		this.Trainer2Pane.add(this.pokemonsT2Pane, BorderLayout.CENTER);
		this.pokemonsT2Pane.setLayout(new GridLayout(3, 1, 0, 0));
		
		this.T2Pokemon1 = new JPanel();
		this.pokemonsT2Pane.add(this.T2Pokemon1);
		
		this.T2Pokemonlbl[0] = new JLabel("Unknown");
		this.T2Pokemon1.add(this.T2Pokemonlbl[0]);
		
		this.T2Pokemon2 = new JPanel();
		this.pokemonsT2Pane.add(this.T2Pokemon2);
		
		this.T2Pokemonlbl[1] = new JLabel("Unknown");
		this.T2Pokemon2.add(this.T2Pokemonlbl[1]);
		
		this.T2Pokemon3 = new JPanel();
		this.pokemonsT2Pane.add(this.T2Pokemon3);
		
		this.T2Pokemonlbl[2] = new JLabel("Unknown");
		this.T2Pokemon3.add(this.T2Pokemonlbl[2]);

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
                setPokemonText(1, battle.getTrainer1().getPokemons());
                setPokemonText(2, battle.getTrainer2().getPokemons());
                BattleTextArea.setText("");
                BattleTextArea
                        .append("Comienza la batalla entre :" + 
                            battle.getTrainer1().getName() + "y " + battle.getTrainer2().getName() + "\n");
            });
        }else if(arg instanceof PokemonAttack){
            PokemonAttack attack = (PokemonAttack)arg;
            SwingUtilities.invokeLater(() -> {
                BattleTextArea
                        .append(attack.getAttacker().getName() + "le inflinge a: " + attack.getAttacked().getName() + " " + attack.getAttacker().getDamage() + "de danio"  + "\n");
            });
        }else if(arg instanceof DeadPokemon){
            DeadPokemon dead = (DeadPokemon)arg;
            SwingUtilities.invokeLater(() -> {
                BattleTextArea
                        .append(dead.getDeadPokemon().getName()+ "murio" + "\n");
            });            
        }
    }

    private void setPokemonText(int number, Pokemon[] pokemons){
        if(number == 1){
            for(int i=0;i<pokemons.length;i++){
                T1Pokemonlbl[i].setText(pokemons[i].getName());
            }
            for (int i = pokemons.length; i < T1Pokemonlbl.length; i++) {
                T1Pokemonlbl[i].setText("");
            }
        }else{
            for(int i=0;i<pokemons.length;i++){
                T2Pokemonlbl[i].setText(pokemons[i].getName());
            }
            for (int i = pokemons.length; i < T2Pokemonlbl.length; i++) {
                T2Pokemonlbl[i].setText("");
            }
        }
    }

}
