package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.entities.Tournament;
import model.interfaces.Observable;
import model.interfaces.Observer;
import model.messages.BattleWinner;
import view.interfaces.GymView;

import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class TournamentFrame extends JFrame implements Observer {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JScrollPane TextAreaPane;
    private JTextArea TournamentTextArea;
    private ActionListener listener;

    private Observable obs;

    public TournamentFrame(Tournament tournament) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(this.contentPane);
        this.contentPane.setLayout(new BorderLayout(0, 0));

        this.TextAreaPane = new JScrollPane();
        this.contentPane.add(this.TextAreaPane);

        this.TournamentTextArea = new JTextArea();
        this.TextAreaPane.setViewportView(this.TournamentTextArea);

        this.obs = tournament;
        obs.addObserver(this);

        this.setVisible(true);
    }

    public void setActionListener(ActionListener listener) {
        this.listener = listener;
    }

    @Override
    public void update(Observable obj, Object arg) {
        if (obj != obs)
            return;

        if (arg instanceof BattleWinner) {
            BattleWinner battle = (BattleWinner) arg;

            SwingUtilities.invokeLater(() -> {
                TournamentTextArea
                        .append("Ganador de " + battle.getInstance() + ": " + battle.getWinner().getName() + " ("
                                + battle.getWinner().getCredits() + ")\n");
                listener.actionPerformed(new ActionEvent(battle.getWinner(), ActionEvent.ACTION_PERFORMED, "UPDATE"));
            });
        }

    }
}