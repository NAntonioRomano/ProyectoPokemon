
import java.util.ArrayList;

import model.entities.Gym;
import model.entities.Tournament;
import model.entities.arenas.ArenaFactory;
import model.entities.pokemons.Pokemon;
import model.entities.pokemons.PokemonFactory;
import model.entities.trainers.Trainer;
import model.entities.trainers.TrainerFactory;
import model.entities.weapons.Sword;
import model.entities.weapons.Weapon;
import model.interfaces.Arena;

public class Main {

    public static void main(String[] args) {
        try {
            Gym gym = new Gym();

            Arena arena1 = ArenaFactory.newArena("Pewter City", "Hard", "Forest");
            Arena arena2 = ArenaFactory.newArena("Cerulean City", "Hard", "Desert");
            gym.addArena(arena1);
            gym.addArena(arena2);

            ArrayList<Trainer> trainers = new ArrayList<>();

            Trainer ash = TrainerFactory.createTrainer("Ash", 1000);
            Pokemon charmander = PokemonFactory.newPokemon("Charmander", "FirePokemon");
            Pokemon squirtle = PokemonFactory.newPokemon("Squirtle", "FirePokemon");
            Pokemon pikachu = PokemonFactory.newPokemon("Pikachu", "FirePokemon");
            ash.purchase(charmander);
            ash.purchase(squirtle);
            ash.purchase(pikachu);
            // Ash purchases a Pokemon that already exists in his collection. Should not
            // duplicate
            ash.purchase(charmander);
            trainers.add(ash);

            Trainer misty = TrainerFactory.createTrainer("Misty", 1000);
            Pokemon vulpix = PokemonFactory.newPokemon("Vulpix", "StonePokemon");
            Pokemon growlithe = PokemonFactory.newPokemon("Growlithe", "StonePokemon");
            Pokemon geodude1 = PokemonFactory.newPokemon("Geodude1", "StonePokemon");
            misty.purchase(vulpix);
            misty.purchase(growlithe);
            misty.purchase(geodude1);
            Weapon misty_sword1 = new Sword();
            Weapon misty_sword2 = new Sword();
            Weapon misty_sword3 = new Sword();
            misty.purchase(misty_sword1);
            misty.purchase(misty_sword2);
            misty.purchase(misty_sword3);
            growlithe.setWeapon(misty_sword1);
            geodude1.setWeapon(misty_sword2);
            vulpix.setWeapon(misty_sword3);

            trainers.add(misty);

            Trainer brock = TrainerFactory.createTrainer("Brock", 1000);
            Pokemon eevee = PokemonFactory.newPokemon("Eevee", "WaterPokemon");
            Pokemon jigglypuff = PokemonFactory.newPokemon("Jigglypuff", "WaterPokemon");
            Pokemon magikarp = PokemonFactory.newPokemon("Magikarp", "WaterPokemon");
            brock.purchase(eevee);
            brock.purchase(jigglypuff);
            brock.purchase(magikarp);
            trainers.add(brock);

            Trainer gary = TrainerFactory.createTrainer("Gary", 1000);
            Pokemon mewtwo = PokemonFactory.newPokemon("Mewtwo", "StonePokemon");
            Pokemon snorlax = PokemonFactory.newPokemon("Snorlax", "StonePokemon");
            Pokemon bulbasaur = PokemonFactory.newPokemon("Bulbasaur", "StonePokemon");
            gary.purchase(mewtwo);
            gary.purchase(snorlax);
            gary.purchase(bulbasaur);
            Weapon sword1 = new Sword();
            Weapon sword2 = new Sword();
            Weapon sword3 = new Sword();
            gary.purchase(sword1);
            gary.purchase(sword2);
            gary.purchase(sword3);
            mewtwo.setWeapon(sword1);
            snorlax.setWeapon(sword2);
            bulbasaur.setWeapon(sword3);
            trainers.add(gary);

            Trainer james = TrainerFactory.createTrainer("James", 1000);
            Pokemon magikarp2 = PokemonFactory.newPokemon("Magikarp", "FirePokemon");
            Pokemon geodude2 = PokemonFactory.newPokemon("Geodude2", "FirePokemon");
            Pokemon geodude3 = PokemonFactory.newPokemon("Geodude3", "FirePokemon");
            james.purchase(magikarp2);
            james.purchase(geodude2);
            james.purchase(geodude3);
            trainers.add(james);

            Trainer tonyStark = TrainerFactory.createTrainer("Tony Stark", 1000);
            Pokemon pikachu2 = PokemonFactory.newPokemon("Pikachu", "IcePokemon");
            Pokemon vulpix2 = PokemonFactory.newPokemon("Vulpix", "IcePokemon");
            Pokemon geodude4 = PokemonFactory.newPokemon("Geodude4", "IcePokemon");
            tonyStark.purchase(pikachu2);
            tonyStark.purchase(vulpix2);
            tonyStark.purchase(geodude4);
            trainers.add(tonyStark);

            Trainer elteclas = TrainerFactory.createTrainer("Elteclas", 1000);
            Pokemon pikachu3 = PokemonFactory.newPokemon("Pikachu", "WaterPokemon");
            Pokemon vulpix3 = PokemonFactory.newPokemon("Vulpix", "WaterPokemon");
            Pokemon geodude5 = PokemonFactory.newPokemon("Geodude5", "WaterPokemon");
            elteclas.purchase(pikachu3);
            elteclas.purchase(vulpix3);
            elteclas.purchase(geodude5);
            trainers.add(elteclas);

            Trainer vscode = TrainerFactory.createTrainer("VSCode", 1000);
            Pokemon mewtwo2 = PokemonFactory.newPokemon("Mewtwo", "IcePokemon");
            Pokemon vulpix4 = PokemonFactory.newPokemon("Vulpix", "IcePokemon");
            Pokemon geodude6 = PokemonFactory.newPokemon("Geodude6", "IcePokemon");
            vscode.purchase(mewtwo2);
            vscode.purchase(vulpix4);
            vscode.purchase(geodude6);
            trainers.add(vscode);

            Tournament tournament = new Tournament(gym, trainers);

            tournament.startTournament();

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

    }

}
