package view.personalizedPanes;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import model.entities.pokemons.Pokemon;
import model.entities.trainers.Trainer;
import model.entities.weapons.Weapon;
import model.interfaces.Valuable;
import view.interfaces.GymView;
import view.personalizedComponents.ButtonWithObject;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

public class InventoryStatePane extends StatePane {

	private static final long serialVersionUID = 1L;
	private JScrollPane PokemonsScrollPane;
	private JPanel ButtonsPane;
	private JScrollPane WeaponsScrollPane;
	private JList<Pokemon> PokemonList;
	private JList<Weapon> WeaponList;
	private ButtonWithObject SellButton;
	private JButton addToPokemon;
	private JPanel WrapperSellButton;
	private JPanel WrapperAddButton;
	private DefaultListModel<Pokemon> pokemonListModel;
	private DefaultListModel<Weapon> weaponListModel;
	private Trainer trainer;

	/**
	 * Create the panel.
	 */
	public InventoryStatePane() {
		setLayout(new BorderLayout(0, 5)); // vertical spacing opcional

		// Lista de Pokémon (arriba)
		this.pokemonListModel = new DefaultListModel<>();
		this.PokemonList = new JList<>(this.pokemonListModel);
		this.PokemonList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.PokemonsScrollPane = new JScrollPane(this.PokemonList);
		this.PokemonsScrollPane.setPreferredSize(new Dimension(0, 250));
		add(this.PokemonsScrollPane, BorderLayout.NORTH);

		// Panel de botones (centro)
		this.ButtonsPane = new JPanel(new GridLayout(1, 2, 0, 0)); // 1 fila, 2 columnas con separación
		this.ButtonsPane.setPreferredSize(new Dimension(0, 10)); // menor altura
		this.ButtonsPane.setMaximumSize(new Dimension(Integer.MAX_VALUE, 10));

		this.SellButton = new ButtonWithObject("VENDER", trainer);
		this.SellButton.setFont(new Font("SansSerif", Font.BOLD, 20));
		this.SellButton.setActionCommand(GymView.SELL_VALUABLE_FROM_TRAINER);
		this.ButtonsPane.add(this.SellButton);

		this.addToPokemon = new JButton("⬆⬆ AGREGAR ⬆⬆");
		this.addToPokemon.setFont(new Font("SansSerif", Font.BOLD, 20));
		this.addToPokemon.setActionCommand(GymView.ADD_WEAPON_TO_POKEMON);
		this.ButtonsPane.add(this.addToPokemon);

		add(this.ButtonsPane, BorderLayout.CENTER);

		// Lista de armas (abajo)
		this.weaponListModel = new DefaultListModel<>();
		this.WeaponList = new JList<>(this.weaponListModel);
		this.WeaponList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.WeaponsScrollPane = new JScrollPane(this.WeaponList);
		this.WeaponsScrollPane.setPreferredSize(new Dimension(0, 250));
		add(this.WeaponsScrollPane, BorderLayout.SOUTH);
	}

	@Override
	public void setActionListener(ActionListener listener) {
		this.SellButton.addActionListener(listener);
		this.addToPokemon.addActionListener(listener);
	}

	@Override
	public void updatePokemonList() {
		this.pokemonListModel.clear();
		for (Pokemon p : trainer.getPokemons()) {
			this.pokemonListModel.addElement(p);
		}
		this.revalidate();
		this.repaint();
	}

	@Override
	public void updateWeaponList() {
		this.weaponListModel.clear();
		for (Weapon w : trainer.getWeapons()) {
			this.weaponListModel.addElement(w);
		}
		this.revalidate();
		this.repaint();
	}

	@Override
	public Pokemon getSelectedPokemon() {
		return PokemonList.getSelectedValue();
	}

	@Override
	public Weapon getSelectedWeapon() {
		return WeaponList.getSelectedValue();
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
		this.SellButton.setObject(trainer);
		this.updatePokemonList();
		this.updateWeaponList();
	}

	@Override
	public Valuable getSelectedValuable() {
		if (PokemonList.getSelectedValue() != null) {
			return PokemonList.getSelectedValue();
		} else if (WeaponList.getSelectedValue() != null) {
			return WeaponList.getSelectedValue();
		}

		return null;
	}

}
