package view.personalizedPanes;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import view.interfaces.GymView;

import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class MainMenuStatePane extends StatePane {

	private static final long serialVersionUID = 1L;
	private JPanel addTrainerPane;
	private JPanel addArenaPane;
	private JScrollPane TrainerIconScrollPane;
	private JPanel ButtonDataPane;
	private JPanel DataTrainerPane;
	private JLabel NameTrainerLbl;
	private JPanel NameTrainerPane;
	private JPanel addTrainerButtonPane;
	private JTextField textField;
	private JButton addTrainerButton;
	private JPanel TypeLevelArenaPane;
	private JPanel TypeRdioButtons;
	private JPanel LevelRdioButtons;
	private JRadioButton ForestRdioBtn;
	private JRadioButton DesertRdioBtn;
	private JRadioButton JungleRdioBtn;
	private JRadioButton EasyRdioBtn;
	private JRadioButton IntermediateRdioBtn;
	private JRadioButton DifficultRdioBtn;
	private JPanel buttonDataPaneArena;
	private JPanel dataArenaPane;
	private JPanel nameArenaPane;
	private JLabel nameArenaLbl;
	private JTextField nameArenaTxfld;
	private JPanel addArenaButtonPane;
	private JButton addArenaButton;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public MainMenuStatePane() {
		setLayout(new GridLayout(0, 1, 1, 1));
		
		
		this.addTrainerPane = new JPanel();
		add(this.addTrainerPane);
		this.addTrainerPane.setLayout(new GridLayout(1, 2, 1, 1));
		this.addTrainerPane.setBorder(BorderFactory.createTitledBorder("Nuevo Entrenador"));
		
		this.TrainerIconScrollPane = new JScrollPane();
		this.addTrainerPane.add(this.TrainerIconScrollPane);
		
		this.ButtonDataPane = new JPanel();
		this.addTrainerPane.add(this.ButtonDataPane);
		this.ButtonDataPane.setLayout(new BorderLayout(0, 0));
		
		this.DataTrainerPane = new JPanel();
		this.ButtonDataPane.add(this.DataTrainerPane, BorderLayout.CENTER);
		this.DataTrainerPane.setLayout(new GridLayout(2, 1, 0, 0));
		
		this.NameTrainerPane = new JPanel();
		this.DataTrainerPane.add(this.NameTrainerPane);
		this.NameTrainerPane.setLayout(new BoxLayout(this.NameTrainerPane, BoxLayout.Y_AXIS));
		this.NameTrainerPane.add(Box.createVerticalStrut(70)); 
		
		this.NameTrainerLbl = new JLabel("NOMBRE DEL ENTRENADOR");
		this.NameTrainerLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.NameTrainerLbl.setHorizontalTextPosition(SwingConstants.CENTER);
		this.NameTrainerPane.add(this.NameTrainerLbl);
		this.NameTrainerLbl.setHorizontalAlignment(SwingConstants.CENTER);
		
		this.textField = new JTextField();
		this.textField.setMinimumSize(new Dimension(100, 100));
		this.textField.setMaximumSize(new Dimension(300, 20));
		this.textField.setHorizontalAlignment(SwingConstants.CENTER);
		this.textField.setColumns(10);
		this.textField.setAlignmentX(0.5f);
		this.NameTrainerPane.add(this.textField);
		
		this.addTrainerButtonPane = new JPanel();
		this.addTrainerButtonPane.setMinimumSize(new Dimension(100, 100));
		this.addTrainerButtonPane.add(Box.createVerticalStrut(70)); 
		this.DataTrainerPane.add(this.addTrainerButtonPane);
		this.addTrainerButtonPane.setLayout(new BoxLayout(this.addTrainerButtonPane, BoxLayout.Y_AXIS));
		
		this.addTrainerButton = new JButton("AGREGAR AL GIMNASIO\r\n");
		this.addTrainerButton.setActionCommand(GymView.ADD_TRAINER);
		this.addTrainerButton.setMaximumSize(new Dimension(300, 23));
		this.addTrainerButton.setMinimumSize(new Dimension(100, 23));
		this.addTrainerButton.setHorizontalTextPosition(SwingConstants.CENTER);
		this.addTrainerButton.setAlignmentX(Component.CENTER_ALIGNMENT); 
		this.addTrainerButtonPane.add(this.addTrainerButton);
		
		this.addArenaPane = new JPanel();
		add(this.addArenaPane);
		this.addArenaPane.setLayout(new GridLayout(1, 2, 1, 1));
		this.addArenaPane.setBorder(BorderFactory.createTitledBorder("Nueva Arena"));
		
		this.TypeLevelArenaPane = new JPanel();
		this.addArenaPane.add(this.TypeLevelArenaPane);
		this.TypeLevelArenaPane.setLayout(new GridLayout(2, 1, 1, 1));
		
		this.TypeRdioButtons = new JPanel();
		this.TypeLevelArenaPane.add(this.TypeRdioButtons);
		this.TypeRdioButtons.setLayout(new GridLayout(3, 1, 0, 0));
		this.TypeRdioButtons.setBorder(BorderFactory.createTitledBorder("Tipo"));
		
		this.ForestRdioBtn = new JRadioButton("BOSQUE");
		buttonGroup.add(this.ForestRdioBtn);
		this.TypeRdioButtons.add(this.ForestRdioBtn);
		
		this.DesertRdioBtn = new JRadioButton("DESIERTO");
		buttonGroup.add(this.DesertRdioBtn);
		this.TypeRdioButtons.add(this.DesertRdioBtn);
		
		this.JungleRdioBtn = new JRadioButton("JUNGLA");
		buttonGroup.add(this.JungleRdioBtn);
		this.TypeRdioButtons.add(this.JungleRdioBtn);
		
		
		
		this.LevelRdioButtons = new JPanel();
		this.TypeLevelArenaPane.add(this.LevelRdioButtons);
		this.LevelRdioButtons.setLayout(new GridLayout(3, 1, 1, 1));
		this.LevelRdioButtons.setBorder(BorderFactory.createTitledBorder("Nivel"));
		
		this.EasyRdioBtn = new JRadioButton("FACIL");
		buttonGroup_1.add(this.EasyRdioBtn);
		this.LevelRdioButtons.add(this.EasyRdioBtn);
		
		this.IntermediateRdioBtn = new JRadioButton("INTERMEDIO");
		buttonGroup_1.add(this.IntermediateRdioBtn);
		this.LevelRdioButtons.add(this.IntermediateRdioBtn);
		
		this.DifficultRdioBtn = new JRadioButton("DIFICL");
		buttonGroup_1.add(this.DifficultRdioBtn);
		this.LevelRdioButtons.add(this.DifficultRdioBtn);
		
		
		this.buttonDataPaneArena = new JPanel();
		this.addArenaPane.add(this.buttonDataPaneArena);
		this.buttonDataPaneArena.setLayout(new BorderLayout(0, 0));
		this.dataArenaPane = new JPanel();
		this.buttonDataPaneArena.add(this.dataArenaPane, BorderLayout.CENTER);

		this.dataArenaPane.setLayout(new GridLayout(2, 1, 0, 0)); 
		
		this.nameArenaPane = new JPanel();
		this.dataArenaPane.add(this.nameArenaPane);
		this.nameArenaPane.setLayout(new BoxLayout(this.nameArenaPane, BoxLayout.Y_AXIS));
		
		this.nameArenaPane.add(Box.createVerticalStrut(70));
		
		this.nameArenaLbl = new JLabel("NOMBRE DE LA ARENA"); 
		this.nameArenaLbl.setHorizontalTextPosition(SwingConstants.CENTER);
		this.nameArenaLbl.setHorizontalAlignment(SwingConstants.CENTER);
		this.nameArenaLbl.setAlignmentX(0.5f);
		this.nameArenaPane.add(this.nameArenaLbl);
		
		this.nameArenaTxfld = new JTextField();
		this.nameArenaTxfld.setMinimumSize(new Dimension(100, 100));
		this.nameArenaTxfld.setMaximumSize(new Dimension(300, 20));
		this.nameArenaTxfld.setHorizontalAlignment(SwingConstants.CENTER);
		this.nameArenaTxfld.setColumns(10);
		this.nameArenaTxfld.setAlignmentX(0.5f);
		this.nameArenaPane.add(this.nameArenaTxfld);
		
		this.addArenaButtonPane = new JPanel();
		this.addArenaButtonPane.setMinimumSize(new Dimension(100, 100));
		this.dataArenaPane.add(this.addArenaButtonPane);
		this.addArenaButtonPane.setLayout(new BoxLayout(this.addArenaButtonPane, BoxLayout.Y_AXIS));
		
		this.addArenaButtonPane.add(Box.createVerticalStrut(70));
		
		this.addArenaButton = new JButton("AGREGAR AL GIMNASIO\r\n");
		this.addArenaButton.setActionCommand(GymView.ADD_ARENA);
		this.addArenaButton.setMinimumSize(new Dimension(100, 23));
		this.addArenaButton.setMaximumSize(new Dimension(300, 23));
		this.addArenaButton.setHorizontalTextPosition(SwingConstants.CENTER);
		this.addArenaButton.setAlignmentX(0.5f);
		this.addArenaButtonPane.add(this.addArenaButton);
		
		
		

	}


	@Override
	public void setActionListener(ActionListener actionListener) {
		
		this.addTrainerButton.addActionListener(actionListener);
		this.addArenaButton.addActionListener(actionListener);
		
		this.ForestRdioBtn.addActionListener(actionListener);
		this.DesertRdioBtn.addActionListener(actionListener);
		this.JungleRdioBtn.addActionListener(actionListener);
		
		this.EasyRdioBtn.addActionListener(actionListener);
		this.IntermediateRdioBtn.addActionListener(actionListener);
		this.DifficultRdioBtn.addActionListener(actionListener);
	}

	@Override
	public String getTrainerName() {
		String trainerName = this.textField.getText();
		if(trainerName.isEmpty()) {
			return null;
		}
		return trainerName;
	}

	@Override
	public String getArenaName() {
		String arenaName = this.nameArenaTxfld.getText();
		if(arenaName.isEmpty()) {
			return null;
		}
		return arenaName;
	}

	@Override
	public String getArenaType() {
		if(this.ForestRdioBtn.isSelected()) {
			return "FOREST";
		}else if(this.DesertRdioBtn.isSelected()) {
			return "DESERT";
		}else if(this.JungleRdioBtn.isSelected()) {
			return "JUNGLE";
		}
		return null;
	}

	@Override
	public String getArenaLevel() {
		if(this.EasyRdioBtn.isSelected()) {
			return "EASY";
		}else if(this.IntermediateRdioBtn.isSelected()) {
			return "INTERMEDIATE";
		}else if(this.DifficultRdioBtn.isSelected()) {
			return "DIFFICULT";
		}
		return null;
	}
}
