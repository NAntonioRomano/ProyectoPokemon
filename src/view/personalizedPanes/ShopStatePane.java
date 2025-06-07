package view.personalizedPanes;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.border.BevelBorder;

import view.interfaces.GymView;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.JButton;

public class ShopStatePane extends StatePane implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel PokemonPurchasePane;
	private JPanel WeaponPurchasePane;
	private JPanel TypeBtnsPane;
	private JPanel DataButtonPokemonPane;
	private JRadioButton FirePokemonButton;
	private JRadioButton StonePokemonButton;
	private JRadioButton IcePokemonButton;
	private JRadioButton WaterPokemonButton;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGrouptype = new ButtonGroup();
	private JLabel NamePokemonLabel;
	private JTextField NamePokemonTF;
	private JPanel NameFieldPane;
	private JPanel ContainerTypeBtnsPane;
	private JPanel addPokemonButtonPane;
	private JButton addPokemonBtn;
	private JPanel RdioBtnsWeaponPane;
	private JPanel addWeaponButtonPane;
	private JRadioButton SwordRdioBtn;
	private JRadioButton AxeRdioBtn;
	private JButton btnNewButton;
	private JButton addWeaponBtn;

	/**
	 * Create the panel.
	 */
	public ShopStatePane() {
		setLayout(new GridLayout(2, 1, 1, 1));

		this.PokemonPurchasePane = new JPanel();
		add(this.PokemonPurchasePane);
		this.PokemonPurchasePane.setLayout(new GridLayout(1, 2, 1, 1));
		this.PokemonPurchasePane.setBorder(BorderFactory.createTitledBorder("Comprar Pokemon"));

		this.TypeBtnsPane = new JPanel();
		this.PokemonPurchasePane.add(TypeBtnsPane);
		this.TypeBtnsPane.setLayout(new GridLayout(4, 1, 1, 1));
		this.TypeBtnsPane.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

		this.FirePokemonButton = new JRadioButton("FUEGO");
		this.FirePokemonButton.setActionCommand("FirePokemon");
		buttonGroup.add(this.FirePokemonButton);
		this.FirePokemonButton.setHorizontalAlignment(SwingConstants.CENTER);
		this.TypeBtnsPane.add(this.FirePokemonButton);

		this.StonePokemonButton = new JRadioButton("PIEDRA");
		this.StonePokemonButton.setActionCommand("StonePokemon");
		buttonGroup.add(this.StonePokemonButton);
		this.StonePokemonButton.setHorizontalAlignment(SwingConstants.CENTER);
		this.TypeBtnsPane.add(this.StonePokemonButton);

		this.IcePokemonButton = new JRadioButton("HIELO");
		this.IcePokemonButton.setActionCommand("IcePokemon");
		buttonGroup.add(this.IcePokemonButton);
		this.IcePokemonButton.setHorizontalAlignment(SwingConstants.CENTER);
		this.TypeBtnsPane.add(this.IcePokemonButton);

		this.WaterPokemonButton = new JRadioButton("AGUA");
		this.WaterPokemonButton.setActionCommand("WaterPokemon");
		buttonGroup.add(this.WaterPokemonButton);
		this.WaterPokemonButton.setHorizontalAlignment(SwingConstants.CENTER);
		this.TypeBtnsPane.add(this.WaterPokemonButton);

		this.DataButtonPokemonPane = new JPanel();
		this.PokemonPurchasePane.add(this.DataButtonPokemonPane);
		this.DataButtonPokemonPane.setLayout(new BoxLayout(this.DataButtonPokemonPane, BoxLayout.Y_AXIS));
		this.DataButtonPokemonPane.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		this.DataButtonPokemonPane.add(Box.createVerticalStrut(70));

		this.NamePokemonLabel = new JLabel("NOMBRE");
		this.NamePokemonLabel.setAlignmentX(CENTER_ALIGNMENT);
		this.NamePokemonLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.DataButtonPokemonPane.add(this.NamePokemonLabel);

		this.NameFieldPane = new JPanel();
		this.NameFieldPane.setLayout(new BoxLayout(this.NameFieldPane, BoxLayout.X_AXIS));
		this.DataButtonPokemonPane.add(this.NameFieldPane);

		this.NamePokemonTF = new JTextField();
		this.NamePokemonTF.setHorizontalAlignment(SwingConstants.CENTER);

		Dimension fixedSize = new Dimension(300, 20);
		this.NamePokemonTF.setMinimumSize(fixedSize);
		this.NamePokemonTF.setPreferredSize(fixedSize);
		this.NamePokemonTF.setMaximumSize(fixedSize);

		this.NamePokemonTF.setColumns(10);

		this.NameFieldPane.add(this.NamePokemonTF);

		this.addPokemonButtonPane = new JPanel();
		this.DataButtonPokemonPane.add(this.addPokemonButtonPane);
		this.addPokemonButtonPane.setLayout(new BoxLayout(this.addPokemonButtonPane, BoxLayout.Y_AXIS));
		this.addPokemonButtonPane.add(Box.createVerticalStrut(70));

		this.addPokemonBtn = new JButton("COMPRAR");
		this.addPokemonBtn.setActionCommand(GymView.PURCHASE_POKEMON);
		this.addPokemonBtn.setAlignmentX(CENTER_ALIGNMENT);

		this.addPokemonBtn.setMaximumSize(fixedSize);
		this.addPokemonBtn.setPreferredSize(fixedSize);
		this.addPokemonBtn.setMinimumSize(fixedSize);
		this.addPokemonButtonPane.add(this.addPokemonBtn);

		this.WeaponPurchasePane = new JPanel();
		add(this.WeaponPurchasePane);
		this.WeaponPurchasePane.setLayout(new GridLayout(1, 2, 1, 1));
		this.WeaponPurchasePane.setBorder(BorderFactory.createTitledBorder("Comprar Arma"));

		this.RdioBtnsWeaponPane = new JPanel();
		this.WeaponPurchasePane.add(this.RdioBtnsWeaponPane);
		this.RdioBtnsWeaponPane.setLayout(new GridLayout(2, 1, 1, 1));
		this.RdioBtnsWeaponPane.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

		this.SwordRdioBtn = new JRadioButton("ESPADA");
		this.SwordRdioBtn.setActionCommand("SWORD");
		buttonGrouptype.add(SwordRdioBtn);
		this.SwordRdioBtn.setHorizontalAlignment(SwingConstants.CENTER);
		this.RdioBtnsWeaponPane.add(this.SwordRdioBtn);

		this.AxeRdioBtn = new JRadioButton("HACHA");
		this.AxeRdioBtn.setActionCommand("AXE");
		buttonGrouptype.add(AxeRdioBtn);
		this.AxeRdioBtn.setHorizontalAlignment(SwingConstants.CENTER);
		this.RdioBtnsWeaponPane.add(this.AxeRdioBtn);

		this.addWeaponButtonPane = new JPanel();
		this.WeaponPurchasePane.add(this.addWeaponButtonPane);
		this.addWeaponButtonPane.setLayout(new BoxLayout(this.addWeaponButtonPane, BoxLayout.Y_AXIS));
		this.addWeaponButtonPane.add(Box.createVerticalStrut(140));
		this.addWeaponButtonPane.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

		this.addWeaponBtn = new JButton("COMPRAR");
		this.addWeaponBtn.setActionCommand(GymView.PURCHASE_WEAPON);
		this.addWeaponBtn.setAlignmentX(CENTER_ALIGNMENT);

		this.addWeaponBtn.setMaximumSize(fixedSize);
		this.addWeaponBtn.setPreferredSize(fixedSize);
		this.addWeaponBtn.setMinimumSize(fixedSize);
		this.addWeaponButtonPane.add(this.addWeaponBtn);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	@Override
	public void setActionListener(ActionListener listener) {
		this.addPokemonBtn.addActionListener(listener);
		this.addWeaponBtn.addActionListener(listener);
	}

	@Override
	public String getPokemonName() {
		String pokemonName = this.NamePokemonTF.getText();
		if (pokemonName.isEmpty()) {
			return null;
		}
		return pokemonName;
	}

	@Override
	public String getPokemonType() {
		if (this.FirePokemonButton.isSelected()) {
			return FirePokemonButton.getActionCommand();
		} else if (this.StonePokemonButton.isSelected()) {
			return StonePokemonButton.getActionCommand();
		} else if (this.IcePokemonButton.isSelected()) {
			return IcePokemonButton.getActionCommand();
		} else if (this.WaterPokemonButton.isSelected()) {
			return WaterPokemonButton.getActionCommand();
		}

		return null;
	}

	public String getWeaponType() {
		if (this.SwordRdioBtn.isSelected()) {
			return SwordRdioBtn.getActionCommand();
		} else if (this.AxeRdioBtn.isSelected()) {
			return AxeRdioBtn.getActionCommand();
		}
		return null;
	}

}
