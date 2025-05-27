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
        setTitle("Mi Aplicación de Gimnasio Pokémon");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1400, 1400);
        setLocationRelativeTo(null);

        add(gymPane); 



        setVisible(true);
    }

    public static void main(String[] args) {

        // Crear instancia de Gym
        Gym gym = new Gym();

        // Crear instancia de GymFacade
        GymFacade gymFacade = new GymFacade(gym);

        GymView gymView = new GymPane(); 

        // Crear instancia de GymController
        GymController gymController = new GymController(gymView, gymFacade);

        gymView.setActionListener(gymController); // Asignar el ActionListener al GymView


        // Crear la ventana principal
        SwingUtilities.invokeLater(() -> {
            new MainFrame((GymPane) gymView);
        });
    }
}
