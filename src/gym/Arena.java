package gym;

public class Arena {
    private String name;
    private TrainerPrepared trainer1;
    private TrainerPrepared trainer2;

    public Arena(String name, TrainerPrepared trainer1, TrainerPrepared trainer2) {
        this.name = name;
        this.trainer1 = trainer1;
        this.trainer2 = trainer2;
    }

    public String getName() {
        return name;
    }

    public TrainerPrepared getTrainer1() {
        return trainer1;
    }

    public TrainerPrepared getTrainer2() {
        return trainer2;
    }

    public void setTrainer1(TrainerPrepared trainer1) {
        this.trainer1 = trainer1;
    }

    public void setTrainer2(TrainerPrepared trainer2) {
        this.trainer2 = trainer2;
    }

    public void startBattle() {
        System.out.println("Starting battle between " + trainer1.getName() + " and " + trainer2.getName());

        trainer1.getPokemons()[0].attack(trainer2.getPokemons()[0]);
    }
}