package view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import controller.GymController;
import model.converters.GymConverter;
import model.dto.GymDTO;
import model.entities.Gym;
import model.entities.GymFacade;
import model.persistence.Persistence;
import model.persistence.XMLPersistence;
import view.interfaces.GymView;
import view.personalizedPanes.GymPane;

public class MainFrame extends JFrame {
	private static Persistence<Object> persistence = new XMLPersistence();
	private static GymFacade gymFacade;

	public MainFrame(GymPane gymPane) {
		setTitle("Gimnasio Pokémon - Grupocho");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(1200, 700);
		setResizable(false);
		setLocationRelativeTo(null);
		add(gymPane);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				saveData();
				dispose();
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		Gym gym;
		GymPane gymPane = new GymPane();

		try {
			GymConverter gymConverter = new GymConverter();
			persistence.openInput("Gym.xml");
			GymDTO dto = (GymDTO) persistence.read();
			gym = gymConverter.fromDTOtoEntity(dto);
			persistence.closeInput();
			gymPane.restoreView(gym.getTrainers(), gym.getArenas());

		} catch (Exception e) {
			e.printStackTrace();
			gym = new Gym();
		}

		gymFacade = new GymFacade(gym);

		GymView gymView = gymPane;
		GymController gymController = new GymController(gymView, gymFacade);

		gymView.setActionListener(gymController);

		SwingUtilities.invokeLater(() -> new MainFrame(gymPane));
	}

	public static void saveData() {
		try {
			GymConverter gymConverter = new GymConverter();
			GymDTO dto = gymConverter.fromEntityToDTO(gymFacade.getGym());
			persistence.openOutput("Gym.xml");
			persistence.write(dto);
			persistence.closeOutput();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
