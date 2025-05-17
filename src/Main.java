import models.Trainer;
import models.TrainerPrepared;
import models.arenas.BaseArena;
import models.arenas.ArenaWithLevel;
import models.arenas.ArenaWithType;
import models.pokemons.FirePokemon;
import models.pokemons.IcePokemon;
import models.pokemons.Pokemon;
import models.pokemons.StonePokemon;
import models.pokemons.WaterPokemon;
import models.spells.Spell;
import models.spells.WindSpell;
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

            BaseArena arena = new BaseArena("Pewter City");
            ArenaWithType arenaWithType = new ArenaWithType(arena, "Forest");
            ArenaWithLevel arenaWithLevel = new ArenaWithLevel(arenaWithType, "Easy");
            System.out.println(misty.getBalance());
            System.out.println(ash.getBalance());
            System.out.println(arenaWithLevel.getDetails());
            Trainer winner = arenaWithLevel.startBattle(new TrainerPrepared(misty), new TrainerPrepared(ash));
            System.out.println("The winner in " + arena.getName() + " is: " + winner);
            System.out.println("Credits for the winner: " + arenaWithLevel.getCredditsForWinner() + "\n");

            System.out.println();
            System.out.println("-------------------Clone test---------------------");

            System.out.println(misty);
            Trainer mistyClone = (Trainer) misty.clone();

            System.out.println(mistyClone);

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

    }

}
