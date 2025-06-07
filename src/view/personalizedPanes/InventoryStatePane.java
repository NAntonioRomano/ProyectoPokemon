package view.personalizedPanes;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.List;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;

import model.models.pokemons.Pokemon;
import model.models.trainers.Trainer;
import model.models.weapons.Weapon;
import view.interfaces.GymView;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class InventoryStatePane extends StatePane {

	private static final long serialVersionUID = 1L;
	private JScrollPane PokemonsScrollPane;
	private JPanel ButtonsPane;
	private JScrollPane WeaponsScrollPane;
	private JList<Pokemon> PokemonList;
	private JList<Weapon> WeaponList;
	private JButton SellButton;
	private JButton addToPokemon;
	private JPanel WrapperSellButton;
	private JPanel WrapperAddButton;
    private DefaultListModel<Pokemon> pokemonListModel;
    private DefaultListModel<Weapon> weaponListModel;
	private Trainer trainer;

	/**
	 * Create the panel.
	 */
	public InventoryStatePane(Trainer trainer) {
		this.trainer = trainer;
		Dimension ButtonDimension = new Dimension(300,20);
		setLayout(new GridLayout(1, 3, 0, 0));
		
		this.PokemonsScrollPane = new JScrollPane();
		add(this.PokemonsScrollPane);
		
		this.pokemonListModel = new DefaultListModel<>();
        this.PokemonList = new JList<>(this.pokemonListModel);
		this.PokemonsScrollPane.setViewportView(this.PokemonList);
        this.PokemonList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		this.ButtonsPane = new JPanel();
		add(this.ButtonsPane);
		this.ButtonsPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.WrapperSellButton = new JPanel();
		this.ButtonsPane.add(this.WrapperSellButton);
		this.WrapperSellButton.setLayout(new BoxLayout(this.WrapperSellButton, BoxLayout.Y_AXIS));
		this.WrapperSellButton.add(Box.createVerticalStrut(60));
		
		this.SellButton = new JButton("VENDER");
		this.SellButton.setActionCommand(GymView.SELL_POKEMON);
		this.SellButton.setAlignmentX(CENTER_ALIGNMENT);
		this.SellButton.setAlignmentY(CENTER_ALIGNMENT);
		this.SellButton.setMinimumSize(ButtonDimension);
		this.SellButton.setPreferredSize(ButtonDimension);
		this.SellButton.setMaximumSize(ButtonDimension);
		this.WrapperSellButton.add(this.SellButton);
		
		this.WrapperAddButton = new JPanel();
		this.ButtonsPane.add(this.WrapperAddButton);
		this.WrapperAddButton.setLayout(new BoxLayout(this.WrapperAddButton, BoxLayout.Y_AXIS));
		this.WrapperAddButton.add(Box.createVerticalStrut(60));
		
		this.addToPokemon = new JButton("<--- AGREGAR ");
		this.addToPokemon.setActionCommand(GymView.ADD_WEAPON_TO_POKEMON);
		this.addToPokemon.setAlignmentX(CENTER_ALIGNMENT);
		this.addToPokemon.setAlignmentY(CENTER_ALIGNMENT);
		this.addToPokemon.setMinimumSize(ButtonDimension);
		this.addToPokemon.setPreferredSize(ButtonDimension);
		this.addToPokemon.setMaximumSize(ButtonDimension);
		this.WrapperAddButton.add(this.addToPokemon);
		this.WeaponsScrollPane = new JScrollPane();
		add(this.WeaponsScrollPane);
		
		this.weaponListModel = new DefaultListModel<>();
        this.WeaponList = new JList<>(this.weaponListModel);
		this.WeaponsScrollPane.setViewportView(this.WeaponList);
        this.WeaponList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        this.updatePokemonList();
        this.updateWeaponList();

	}

    @Override
    public void setActionListener(ActionListener listener){
        this.SellButton.addActionListener(listener);
        this.addToPokemon.addActionListener(listener);
    }
	@Override
	public void updatePokemonList(){
		this.pokemonListModel.clear();
		for (Pokemon p : trainer.getPokemons()) {
			this.pokemonListModel.addElement(p);
		}
		this.revalidate();
		this.repaint();
	}
	@Override
    public void updateWeaponList(){
		this.weaponListModel.clear();
		for (Weapon w : trainer.getWeapons()) {
			this.weaponListModel.addElement(w);
		}
		this.revalidate();
		this.repaint();
	}
	@Override
	public Pokemon getSelectedPokemon(){
		return PokemonList.getSelectedValue();
	}
	@Override
	public Weapon getSelectedWeapon(){
		return WeaponList.getSelectedValue();
	}
    
}
