package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import model.models.*;
import view.interfaces.GymView;

public class GymControler implements ActionListener {
    private GymView gymview;
    private GymFacade gymFacade;

    public GymControler(GymView gymview, GymFacade gymFacade) {
        this.gymview = gymview;
        this.gymFacade = gymFacade;
    }

    

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if(command.equals("ADD_TRAINER")){
            addTrainer();
        }else if(command.equals("RMV_TRAINER")){
            removeTrainer(e);
        }
    }

    private void addTrainer(){
        String name = gymview.getTrainerName();
        gymFacade.addTrainer(name);

        Trainer new_Trainer = gymFacade.getTrainer(name);

        gymview.addTrainer(new_Trainer);
        
    }

    private void removeTrainer(ActionEvent e){
        Trainer trainer = gymview.getTrainer(e);
        gymFacade.removeTrainer(trainer);
    }

}
