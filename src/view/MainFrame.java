package view;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import model.models.Gym;
import model.models.GymFacade;
import view.personalizedPanes.GymPane;
import view.interfaces.*;
import controler.GymController;

public class MainFrame extends JFrame {

    public MainFrame(GymPane gymPane) {
        setTitle("Gimnasio Pokémon - Grupocho");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1400, 1400);
        setLocationRelativeTo(null);
        add(gymPane);
        setVisible(true);
    }

    public static void main(String[] args) {
        Gym gym = new Gym();

        GymFacade gymFacade = new GymFacade(gym);

        GymView gymView = new GymPane();

        GymController gymController = new GymController(gymView, gymFacade);

        gymView.setActionListener(gymController);

        SwingUtilities.invokeLater(() -> new MainFrame((GymPane) gymView));
    }
}
