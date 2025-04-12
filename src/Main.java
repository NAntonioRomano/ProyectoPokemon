import exceptions.ImpossiblePurchaseException;
import interfaces.Witchable;
import models.Arena;
import models.Gym;
import models.Trainer;
import models.TrainerPrepared;
import models.pokemons.FirePokemon;
import models.pokemons.IcePokemon;
import models.pokemons.Pokemon;
import models.pokemons.StonePokemon;
import models.pokemons.WaterPokemon;
import models.spells.Spell;
import models.spells.Wind;
import models.weapons.Sword;
import models.weapons.Weapon;

public class Main {

    public static void main(String[] args) {

        try {

            Pokemon charmander = new FirePokemon("Charmander nazi");
            Pokemon squirtle = new WaterPokemon("Squirtle");
            Pokemon bulbasaur = new FirePokemon("Bulbasaur");
            Pokemon pikachu = new IcePokemon("Pikachu");
            Pokemon mewtwo = new StonePokemon("Mewtwo");
            Pokemon snorlax = new StonePokemon("Snorlax");

            Trainer ash = new Trainer("Ash");
            Trainer misty = new Trainer("Misty");

            ash.addCredits(10000000);
            misty.addCredits(10000000);

            Weapon sword = new Sword();
            ash.purchase(sword);

            ash.purchase(charmander);
            ash.purchase(squirtle);
            ash.purchase(bulbasaur);

            misty.purchase(pikachu);
            misty.purchase(mewtwo);
            misty.purchase(snorlax);

            Spell spell = new Wind();
            spell.bewitch(charmander);

            Arena arena = new Arena("Pewter City", new TrainerPrepared(ash), new TrainerPrepared(misty));

            arena.startBattle();

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

    }

}
