package view;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import model.models.Gym;
import model.models.GymFacade;
import view.personalizedPanes.GymPane;
import view.interfaces.*;
import controler.GymControler;


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

        // Supongamos que tienes las siguientes clases:
        // Gym, GymFacade, GymController
        // y que GymPane puede recibir un GymController

        // Crear instancia de Gym
        Gym gym = new Gym();

        // Crear instancia de GymFacade
        GymFacade gymFacade = new GymFacade(gym);

        GymView gymView = new GymPane(); // Cambia esto por la implementación correcta de GymView

        // Crear instancia de GymController
        GymControler gymController = new GymControler(gymView, gymFacade);

        gymView.setActionListener(gymController); // Asignar el ActionListener al GymView

        // Si quieres pasar el controller al GymPane, modifica el constructor de GymPane
        // GymPane gymPanel = new GymPane(gymController);

        // Crear la ventana principal
        SwingUtilities.invokeLater(() -> {
            new MainFrame((GymPane) gymView); // Cambia esto por la implementación correcta de GymView
        });
    }
}
