import models.Arena;
import models.Trainer;
import models.TrainerPrepared;
import models.pokemons.FirePokemon;
import models.pokemons.IcePokemon;
import models.pokemons.Pokemon;
import models.pokemons.StonePokemon;
import models.pokemons.WaterPokemon;
import models.spells.Spell;
import models.spells.WindSpell;
import models.weapons.Axe;
import models.weapons.Sword;
import models.weapons.Weapon;

public class Main {

    public static void main(String[] args) {

        try {

            Pokemon charmander = new FirePokemon("Charmander");
            Pokemon squirtle = new WaterPokemon("Squirtle");
            Pokemon bulbasaur = new FirePokemon("Bulbasaur");
            Pokemon pikachu = new IcePokemon("Pikachu");
            Pokemon mewtwo = new StonePokemon("Mewtwo");
            Pokemon snorlax = new StonePokemon("Snorlax");

            Trainer ash = new Trainer("Ash");
            Trainer misty = new Trainer("Misty");

            ash.addCredits(1000);
            misty.addCredits(1000);

            ash.purchase(charmander);
            ash.purchase(squirtle);
            ash.purchase(bulbasaur);

            misty.purchase(pikachu);
            misty.purchase(mewtwo);
            misty.purchase(snorlax);

            // Ash purchases a Pokemon that already exists in his collection. Should not
            // duplicate
            ash.purchase(charmander);

            Weapon sword = new Sword();
            misty.purchase(sword);
            snorlax.setWeapon(misty.getWeapons().get(0));

            Spell spell = new WindSpell();
            spell.bewitch(charmander);

            Arena arena = new Arena("Pewter City");

            Trainer winner = arena.startBattle(new TrainerPrepared(misty), new TrainerPrepared(ash));
            System.out.println("The winner in " + arena.getName() + " is: " + winner);

            System.out.println();
            System.out.println("-------------------Clone test---------------------");

            System.out.println(misty);
            Trainer jitjav = (Trainer) misty.clone();

            System.out.println(jitjav);

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

    }

}
