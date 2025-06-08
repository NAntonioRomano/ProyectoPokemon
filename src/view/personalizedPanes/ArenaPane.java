package view.personalizedPanes;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import model.interfaces.Arena;
import view.interfaces.GymView;
import view.personalizedComponents.ButtonWithObject;

public class ArenaPane extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel NamePane;
	private JPanel DescriptionPane;
	private JPanel ButtonPane;
	private ButtonWithObject DeleteButton;
	private JLabel NameLabel;
	private JLabel TypeArenaLabel;
	private JLabel LevelArenaLabel;
	private JLabel WinnerCreditsArenaLabel;
	private Arena arena;

	public ArenaPane(Arena arena) {
		this.arena = arena;
		this.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.setLayout(new BorderLayout(6, 6));
		this.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.GRAY, 2, true),
				BorderFactory.createEmptyBorder(6, 6, 6, 6)));

		Dimension preferredSize = new Dimension(250, 85);
		this.setPreferredSize(preferredSize);
		this.setMinimumSize(preferredSize);
		this.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));

		// Panel para el nombre (título) con fuente más pequeña
		this.NamePane = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		this.NamePane.setBorder(BorderFactory.createEmptyBorder(0, 0, 4, 0));
		this.NameLabel = new JLabel(arena.getName());
		this.NameLabel.setFont(new Font("SansSerif", Font.BOLD, 16)); // fuente más chica
		this.NamePane.add(this.NameLabel);
		this.add(this.NamePane, BorderLayout.NORTH);

		// Panel para Tipo y Nivel en una fila centrada
		JPanel typeLevelPane = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));

		this.TypeArenaLabel = new JLabel("Tipo: " + arena.getType());
		this.TypeArenaLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		this.TypeArenaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		typeLevelPane.add(this.TypeArenaLabel);

		this.LevelArenaLabel = new JLabel("Nivel: " + arena.getLevel());
		this.LevelArenaLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		this.LevelArenaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		typeLevelPane.add(this.LevelArenaLabel);

		// Panel para créditos centrado en segunda fila
		JPanel creditsPane = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		this.WinnerCreditsArenaLabel = new JLabel("Créditos: " + arena.getCredditsForWinner());
		this.WinnerCreditsArenaLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		this.WinnerCreditsArenaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		creditsPane.add(this.WinnerCreditsArenaLabel);

		// Panel contenedor vertical para tipo/nivel y créditos
		JPanel descriptionPane = new JPanel();
		descriptionPane.setLayout(new BoxLayout(descriptionPane, BoxLayout.Y_AXIS));
		descriptionPane.add(typeLevelPane);
		descriptionPane.add(creditsPane);

		this.add(descriptionPane, BorderLayout.CENTER);

		// Panel para el botón Eliminar con fuente más pequeña y margen reducido
		this.ButtonPane = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));

		this.DeleteButton = new ButtonWithObject("Eliminar", arena);
		this.DeleteButton.setActionCommand(GymView.RMV_ARENA);
		this.DeleteButton.setFont(new Font("SansSerif", Font.BOLD, 11)); // un poco más pequeño

		this.DeleteButton.setBackground(new Color(255, 220, 220));
		this.DeleteButton.setFocusPainted(false);
		this.ButtonPane.add(this.DeleteButton);
		this.add(this.ButtonPane, BorderLayout.SOUTH);
	}

	public void setActionListener(ActionListener listener) {
		this.DeleteButton.addActionListener(listener);
	}

	public Arena getArena() {
		return arena;
	}

}
