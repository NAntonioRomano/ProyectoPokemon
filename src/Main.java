
import java.util.ArrayList;
import java.util.Collections;

import model.models.Battle;
import model.models.Gym;
import model.models.Tournament;
import model.models.arenas.ArenaWithLevel;
import model.models.arenas.ArenaWithType;
import model.models.arenas.ArenaFactory;
import model.models.arenas.BaseArena;
import model.interfaces.Arena;
import model.models.pokemons.FirePokemon;
import model.models.pokemons.IcePokemon;
import model.models.pokemons.Pokemon;
import model.models.pokemons.PokemonFactory;
import model.models.pokemons.StonePokemon;
import model.models.pokemons.WaterPokemon;
import model.models.spells.Spell;
import model.models.spells.WindSpell;
import model.models.trainers.Trainer;
import model.models.trainers.TrainerFactory;
import model.models.trainers.TrainerPrepared;
import model.models.weapons.Sword;
import model.models.weapons.Weapon;

public class Main {

    public static void main(String[] args) {
        try {
            Gym gym = new Gym();

            Arena arena1 = ArenaFactory.newArena("Pewter City", "Difficult", "Forest");
            Arena arena2 = ArenaFactory.newArena("Cerulean City", "Difficult", "Desert");
            gym.addArena(arena1);
            gym.addArena(arena2);

            ArrayList<Trainer> trainers = new ArrayList<>();

            Trainer ash = TrainerFactory.createTrainer("Ash", 1000);
            Pokemon charmander = PokemonFactory.newPokemon("Charmander", "FIRE_POKEMON");
            Pokemon squirtle = PokemonFactory.newPokemon("Squirtle", "FIRE_POKEMON");
            Pokemon pikachu = PokemonFactory.newPokemon("Pikachu", "FIRE_POKEMON");
            ash.purchase(charmander);
            ash.purchase(squirtle);
            ash.purchase(pikachu);
            // Ash purchases a Pokemon that already exists in his collection. Should not
            // duplicate
            ash.purchase(charmander);
            trainers.add(ash);

            Trainer misty = TrainerFactory.createTrainer("Misty", 1000);
            Pokemon vulpix = PokemonFactory.newPokemon("Vulpix", "STONE_POKEMON");
            Pokemon growlithe = PokemonFactory.newPokemon("Growlithe", "STONE_POKEMON");
            Pokemon geodude1 = PokemonFactory.newPokemon("Geodude1", "STONE_POKEMON");
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
            Pokemon eevee = PokemonFactory.newPokemon("Eevee", "WATER_POKEMON");
            Pokemon jigglypuff = PokemonFactory.newPokemon("Jigglypuff", "WATER_POKEMON");
            Pokemon magikarp = PokemonFactory.newPokemon("Magikarp", "WATER_POKEMON");
            brock.purchase(eevee);
            brock.purchase(jigglypuff);
            brock.purchase(magikarp);
            trainers.add(brock);

            Trainer gary = TrainerFactory.createTrainer("Gary", 1000);
            Pokemon mewtwo = PokemonFactory.newPokemon("Mewtwo", "STONE_POKEMON");
            Pokemon snorlax = PokemonFactory.newPokemon("Snorlax", "STONE_POKEMON");
            Pokemon bulbasaur = PokemonFactory.newPokemon("Bulbasaur", "STONE_POKEMON");
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
            Pokemon magikarp2 = PokemonFactory.newPokemon("Magikarp", "FIRE_POKEMON");
            Pokemon geodude2 = PokemonFactory.newPokemon("Geodude2", "FIRE_POKEMON");
            Pokemon geodude3 = PokemonFactory.newPokemon("Geodude3", "FIRE_POKEMON");
            james.purchase(magikarp2);
            james.purchase(geodude2);
            james.purchase(geodude3);
            trainers.add(james);

            Trainer tonyStark = TrainerFactory.createTrainer("Tony Stark", 1000);
            Pokemon pikachu2 = PokemonFactory.newPokemon("Pikachu", "ICE_POKEMON");
            Pokemon vulpix2 = PokemonFactory.newPokemon("Vulpix", "ICE_POKEMON");
            Pokemon geodude4 = PokemonFactory.newPokemon("Geodude4", "ICE_POKEMON");
            tonyStark.purchase(pikachu2);
            tonyStark.purchase(vulpix2);
            tonyStark.purchase(geodude4);
            trainers.add(tonyStark);

            Trainer elteclas = TrainerFactory.createTrainer("Elteclas", 1000);
            Pokemon pikachu3 = PokemonFactory.newPokemon("Pikachu", "WATER_POKEMON");
            Pokemon vulpix3 = PokemonFactory.newPokemon("Vulpix", "WATER_POKEMON");
            Pokemon geodude5 = PokemonFactory.newPokemon("Geodude5", "WATER_POKEMON");
            elteclas.purchase(pikachu3);
            elteclas.purchase(vulpix3);
            elteclas.purchase(geodude5);
            trainers.add(elteclas);

            Trainer vscode = TrainerFactory.createTrainer("VSCode", 1000);
            Pokemon mewtwo2 = PokemonFactory.newPokemon("Mewtwo", "ICE_POKEMON");
            Pokemon vulpix4 = PokemonFactory.newPokemon("Vulpix", "ICE_POKEMON");
            Pokemon geodude6 = PokemonFactory.newPokemon("Geodude6", "ICE_POKEMON");
            vscode.purchase(mewtwo2);
            vscode.purchase(vulpix4);
            vscode.purchase(geodude6);
            trainers.add(vscode);

            Collections.shuffle(trainers);

            Tournament tournament = new Tournament(gym, trainers);

            tournament.startTournament();

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

    }

}
