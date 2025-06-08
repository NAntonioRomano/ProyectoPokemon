package view.personalizedPanes;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

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
        this.setLayout(new BorderLayout(0, 0));
        this.setBorder(BorderFactory.createLineBorder(getBackground(), 3));

        Dimension prefered_size = new Dimension(250, 150);

        this.setPreferredSize(prefered_size);
        this.setMinimumSize(prefered_size);
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE,150));
		
		this.NamePane = new JPanel();
		add(this.NamePane, BorderLayout.NORTH);
		this.NamePane.setBorder(BorderFactory.createLoweredBevelBorder());
		
		this.NameLabel = new JLabel(arena.getName());
		this.NamePane.add(this.NameLabel);
		
		this.DescriptionPane = new JPanel();
		add(this.DescriptionPane, BorderLayout.CENTER);
		this.DescriptionPane.setLayout(new GridLayout(0, 1, 0, 0));
		this.DescriptionPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Descripcion"));
		
		this.TypeArenaLabel = new JLabel(arena.getType());
		this.TypeArenaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.DescriptionPane.add(this.TypeArenaLabel);
		
		this.LevelArenaLabel = new JLabel(arena.getLevel());
		this.LevelArenaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.DescriptionPane.add(this.LevelArenaLabel);
		
		this.WinnerCreditsArenaLabel = new JLabel(Integer.toString(arena.getCredditsForWinner()));
		this.WinnerCreditsArenaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.DescriptionPane.add(this.WinnerCreditsArenaLabel);
		
		this.ButtonPane = new JPanel();
		add(this.ButtonPane, BorderLayout.SOUTH);
		
		this.DeleteButton = new ButtonWithObject("ELIMINAR",arena);
        this.DeleteButton.setActionCommand(GymView.RMV_ARENA);
		this.ButtonPane.add(this.DeleteButton);

	}

    public void setActionListener(ActionListener listener){
        this.DeleteButton.addActionListener(listener);
    }

    public Arena getArena(){
        return arena;
    }

}
