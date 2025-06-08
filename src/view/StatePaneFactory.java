package view;

import view.personalizedPanes.InventoryStatePane;
import view.personalizedPanes.MainMenuStatePane;
import view.personalizedPanes.ShopStatePane;
import view.personalizedPanes.StatePane;
import view.personalizedPanes.TournamentStatePane;

public class StatePaneFactory {
    public static StatePane createStatePane(String type) throws IllegalArgumentException{
        switch (type) {
            case "MAINMENU":
                return new MainMenuStatePane();
            case "SHOP":
                return new ShopStatePane();
            case "INVENTORY":
                return new InventoryStatePane();
            case "TOURNAMENT":
                return new TournamentStatePane();
        
            default:
                throw new IllegalArgumentException("Unknown type of statePane");
        }
    }
}
