import gym.Arena;
import gym.Gym;
import gym.Trainer;
import gym.TrainerPrepared;
import pokemons.FirePokemon;
import pokemons.IcePokemon;
import pokemons.Pokemon;
import pokemons.StonePokemon;
import pokemons.WaterPokemon;
import spells.Spell;
import spells.Wind;
import weapons.Sword;
import weapons.Weapon;

public class Main {

    public static void main(String[] args) {

        try {

            Pokemon charmander = new FirePokemon("Charmander nazi");
            Pokemon squirtle = new WaterPokemon("Squirtle");
            Pokemon bulbasaur = new FirePokemon("Bulbasaur");
            Pokemon pikachu = new IcePokemon("Pikachu");
            Pokemon mewtwo = new StonePokemon("Mewtwo");
            Pokemon snorlax = new StonePokemon("Snorlax");

            Weapon sword = new Sword();

            Trainer ash = new Trainer("Ash");
            Trainer misty = new Trainer("Misty");

            ash.addCredits(10000000);
            misty.addCredits(10000000);

            ash.purchase(sword);

            ash.purchase(charmander);
            ash.purchase(squirtle);
            ash.purchase(bulbasaur);

            misty.purchase(pikachu);
            misty.purchase(mewtwo);
            misty.purchase(snorlax);

            Spell spell = new Wind();
            spell.bewitch(ash.getPokemons().get(0));

            Arena arena = new Arena("Pewter City", new TrainerPrepared(ash), new TrainerPrepared(misty));

            arena.startBattle();

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

    }

}
