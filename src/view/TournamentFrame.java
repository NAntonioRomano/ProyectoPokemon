package view;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.entities.Tournament;
import model.exceptions.TrainerWithoutPokemonsException;
import model.interfaces.Arena;
import model.interfaces.Observable;
import model.interfaces.Observer;
import model.messages.BattleWinner;
import view.interfaces.GymView;

import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class TournamentFrame extends JFrame implements Observer {

	private JPanel contentPane;
	private JScrollPane TextAreaPane;
	private JTextArea TournamentTextArea;
	private JScrollPane ArenasScrollPane;
	private JPanel ArenaPane;
    private ActionListener listener;

    private Observable obs;

    public TournamentFrame(Tournament tournament, ArrayList<Arena> arenas) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		this.TextAreaPane = new JScrollPane();
		this.contentPane.add(this.TextAreaPane, BorderLayout.SOUTH);
		
		this.TournamentTextArea = new JTextArea();
		this.TextAreaPane.setViewportView(this.TournamentTextArea);
		
		this.ArenasScrollPane = new JScrollPane();
		this.contentPane.add(this.ArenasScrollPane, BorderLayout.CENTER);
		
		this.ArenaPane = new JPanel();
		this.ArenasScrollPane.setViewportView(this.ArenaPane);
		this.ArenaPane.setLayout(new GridLayout(1, 3, 3, 3));

        this.obs = tournament;
        obs.addObserver(this);

        this.setVisible(true);
    }

    private void setArenas(ArrayList<Arena> arenas){
        
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
        }else if(arg instanceof TrainerWithoutPokemonsException){
            ShowErrorMessage(((TrainerWithoutPokemonsException) arg).getMessage());
        }

    }

    public void ShowErrorMessage(String message) {
		JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE, null);
	}
}