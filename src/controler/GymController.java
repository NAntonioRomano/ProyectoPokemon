package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.exceptions.ImpossiblePurchaseException;
import model.interfaces.Arena;
import model.models.*;
import model.models.pokemons.Pokemon;
import model.models.trainers.Trainer;
import view.interfaces.GymView;

public class GymController implements ActionListener {
    private GymView gymview;
    private GymFacade gymFacade;

    public GymController(GymView gymview, GymFacade gymFacade) {
        this.gymview = gymview;
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
            removePokemonFromTrainer();
        }
        else if (command.equals(GymView.SELL_POKEMON)) {
            sellPokemon();
        } else if (command.equals(GymView.PURCHASE_WEAPON)) {

            purchaseWeapon();
        } else if (command.equals(GymView.ADD_WEAPON_TO_POKEMON)) {
            addWeaponToPokemon();
        }
    }

    private void addWeaponToPokemon() {
        try {
            gymview.getSelectedPokemon().setWeapon(gymview.getSelectedWeapon());
            gymview.updateTrainerData(null);
        } catch (UnsupportedOperationException e) {
            gymview.ShowErrorMessage(e.getMessage());
        }
    }

    private void purchaseWeapon() {
        try {
            Trainer selected = gymview.getSelectedTrainer();
            gymFacade.purchaseValuable(selected, gymFacade.newWeapon(gymview.getWeaponType()));
            gymview.updateTrainerData(selected);

        } catch (ImpossiblePurchaseException e) {
            gymview.ShowErrorMessage(e.getMessage());
        } catch (IllegalArgumentException e) {
            gymview.ShowErrorMessage(e.getMessage());
        }
    }

    private void purchasePokemon() {
        try {
            Trainer selected = gymview.getSelectedTrainer();
            gymFacade.purchaseValuable(
                    selected,
                    gymFacade.newPokemon(gymview.getPokemonName(), gymview.getPokemonType()));
            gymview.updateTrainerData(selected);
        } catch (ImpossiblePurchaseException e) {
            gymview.ShowErrorMessage(e.getMessage());
        } catch (IllegalArgumentException e) {
            gymview.ShowErrorMessage(e.getMessage());
        }

    }

    private void removeArena(ActionEvent e) {
        Arena arena = (Arena) e.getSource();
        gymFacade.removeArena(arena);
    }

    private void addArena() {
        String name = gymview.getArenaName();
        String type = gymview.getArenaType();
        String level = gymview.getArenaLevel();

        gymFacade.addArena(name, type, level);
    }

    private void addTrainer() {
        Trainer trainer = gymFacade.newTrainer(gymview.getTrainerName());
        gymFacade.addTrainer(trainer);
        gymview.addTrainer(trainer);
    }

    private void removeTrainer(ActionEvent e) {
        Trainer trainer = (Trainer) e.getSource();
        gymFacade.removeTrainer(trainer);
    }

    private void removePokemonFromTrainer() {
        Trainer selected = gymview.getSelectedTrainer();
        Pokemon pokemon = gymview.getSelectedPokemon();
        gymFacade.removePokemonFromTrainer(selected, pokemon);
        gymview.updateTrainerData(selected);
    }

    private void sellPokemon() {
        Trainer selected = gymview.getSelectedTrainer();
        Pokemon pokemon = gymview.getSelectedPokemon();
        gymFacade.sellPokemon(selected, pokemon);
        gymview.updateTrainerData(selected);
    }

}
