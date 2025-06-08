package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.exceptions.ImpossiblePurchaseException;
import model.exceptions.TrainerWithoutPokemonsException;
import model.interfaces.Arena;
import model.entities.GymFacade;
import model.entities.Tournament;
import model.entities.trainers.Trainer;
import view.interfaces.GymView;

public class GymController implements ActionListener {
    private GymView gymView;
    private GymFacade gymFacade;

    public GymController(GymView gymview, GymFacade gymFacade) {
        this.gymView = gymview;
        this.gymFacade = gymFacade;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals(GymView.ADD_TRAINER)) {
            addTrainer();
        } else if (command.equals(GymView.RMV_TRAINER)) {
            removeTrainer(e);
        } else if (command.equals(GymView.ADD_ARENA)) {
            addArena();
        } else if (command.equals(GymView.RMV_ARENA)) {
            removeArena(e);
        } else if (command.equals(GymView.PURCHASE_POKEMON)) {
            purchasePokemon();
        } else if (command.equals(GymView.RMV_POKEMON_FROM_TRAINER)) {
        } else if (command.equals(GymView.PURCHASE_WEAPON)) {
            purchaseWeapon();
        } else if (command.equals(GymView.ADD_WEAPON_TO_POKEMON)) {
            addWeaponToPokemon();
        } else if (command.equals(GymView.START_TOURNAMENT)) {
            startTournament();
        }
    }

    private void startTournament() {
        try {
            ArrayList<Trainer> trainers = gymView.getSelectedTrainers();
            if (trainers != null) {
                Tournament tournament = gymFacade.getTournament(trainers);
                gymView.startTournament(tournament);
                tournament.startTournament();
            }
        } catch (TrainerWithoutPokemonsException e) {
            gymView.ShowErrorMessage(e.getMessage());
        } catch (InterruptedException e) {
            gymView.ShowErrorMessage(e.getMessage());
        }
    }

    private void addWeaponToPokemon() {
        try {
            gymView.getSelectedPokemon().setWeapon(gymView.getSelectedWeapon());
        } catch (UnsupportedOperationException e) {
            gymView.ShowErrorMessage(e.getMessage());
        }
    }

    private void purchaseWeapon() {
        try {
            Trainer selected = gymView.getSelectedTrainer();
            if (selected != null)
                gymFacade.purchaseValuable(selected, gymFacade.newWeapon(gymView.getWeaponType()));

        } catch (ImpossiblePurchaseException e) {
            gymView.ShowErrorMessage(e.getMessage());
        } catch (IllegalArgumentException e) {
            gymView.ShowErrorMessage(e.getMessage());
        }
    }

    private void purchasePokemon() {
        try {
            Trainer selected = gymView.getSelectedTrainer();
            if (selected != null)
                gymFacade.purchaseValuable(
                        selected,
                        gymFacade.newPokemon(gymView.getPokemonName(), gymView.getPokemonType()));
        } catch (ImpossiblePurchaseException e) {
            gymView.ShowErrorMessage(e.getMessage());
        } catch (IllegalArgumentException e) {
            gymView.ShowErrorMessage(e.getMessage());
        }

    }

    private void removeArena(ActionEvent e) {
        Arena arena = (Arena) e.getSource();
        gymFacade.removeArena(arena);
    }

    private void addArena() {
        String name = gymView.getArenaName();
        String type = gymView.getArenaType();
        String level = gymView.getArenaLevel();

        Arena newArena = gymFacade.addArena(name, type, level);
        gymView.addArena(newArena);
    }

    private void addTrainer() {
        Trainer trainer = gymFacade.newTrainer(gymView.getTrainerName());
        gymFacade.addTrainer(trainer);
        gymView.addTrainer(trainer);
    }

    private void removeTrainer(ActionEvent e) {
        Trainer trainer = (Trainer) e.getSource();
        gymFacade.removeTrainer(trainer);
    }

}