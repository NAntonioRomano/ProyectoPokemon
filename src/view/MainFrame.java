package view;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("Mi Aplicación de Gimnasio Pokémon");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1400, 1400);
        setLocationRelativeTo(null);


        GymPane gymPanel = new GymPane();
        add(gymPanel); 

        setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainFrame();
            }
        });
    }
}
