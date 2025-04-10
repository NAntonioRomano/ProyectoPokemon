import gym.Arena;
import gym.Gym;
import gym.Trainer;
import gym.TrainerPrepared;
import pokemons.FirePokemon;
import pokemons.IcePokemon;
import pokemons.Pokemon;
import pokemons.StonePokemon;
import pokemons.WaterPokemon;

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

            ash.getPokemons().add(charmander);
            ash.getPokemons().add(squirtle);
            ash.getPokemons().add(bulbasaur);

            misty.getPokemons().add(pikachu);
            misty.getPokemons().add(mewtwo);
            misty.getPokemons().add(snorlax);

            Arena arena = new Arena("Pewter City", new TrainerPrepared(ash), new TrainerPrepared(misty));

            arena.startBattle();

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

    }

}
