
import java.util.ArrayList;
import java.util.Collections;

import model.models.Battle;
import model.models.Gym;
import model.models.Tournament;
import model.models.Trainer;
import model.models.TrainerPrepared;
import model.models.arenas.ArenaWithLevel;
import model.models.arenas.ArenaWithType;
import model.models.arenas.BaseArena;
import model.models.pokemons.FirePokemon;
import model.models.pokemons.IcePokemon;
import model.models.pokemons.Pokemon;
import model.models.pokemons.StonePokemon;
import model.models.pokemons.WaterPokemon;
import model.models.spells.Spell;
import model.models.spells.WindSpell;
import model.models.weapons.Sword;
import model.models.weapons.Weapon;

public class Main {

    /*
     * public static void main(String[] args) {
     * 
     * try {
     * 
     * Pokemon charmander = new FirePokemon("Charmander");
     * Pokemon squirtle = new WaterPokemon("Squirtle");
     * Pokemon bulbasaur = new FirePokemon("Bulbasaur");
     * Pokemon pikachu = new IcePokemon("Pikachu");
     * Pokemon mewtwo = new StonePokemon("Mewtwo");
     * Pokemon snorlax = new StonePokemon("Snorlax");
     * 
     * Trainer ash = new Trainer("Ash");
     * Trainer misty = new Trainer("Misty");
     * 
     * ash.addCredits(1000);
     * misty.addCredits(1000);
     * 
     * ash.purchase(charmander);
     * ash.purchase(squirtle);
     * ash.purchase(bulbasaur);
     * 
     * misty.purchase(pikachu);
     * misty.purchase(mewtwo);
     * misty.purchase(snorlax);
     * 
     * // Ash purchases a Pokemon that already exists in his collection. Should not
     * // duplicate
     * ash.purchase(charmander);
     * 
     * Weapon sword = new Sword();
     * misty.purchase(sword);
     * snorlax.setWeapon(misty.getWeapons().get(0));
     * 
     * Spell spell = new WindSpell();
     * spell.bewitch(charmander);
     * 
     * BaseArena arena = new BaseArena("Pewter City");
     * ArenaWithType arenaWithType = new ArenaWithType(arena, "Forest");
     * ArenaWithLevel arenaWithLevel = new ArenaWithLevel(arenaWithType, "Easy");
     * System.out.println(misty.getBalance());
     * System.out.println(ash.getBalance());
     * System.out.println(arenaWithLevel.getDetails());
     * Trainer winner = arenaWithLevel.startBattle(new TrainerPrepared(misty), new
     * TrainerPrepared(ash));
     * System.out.println("The winner in " + arena.getName() + " is: " + winner);
     * System.out.println("Credits for the winner: " +
     * arenaWithLevel.getCredditsForWinner() + "\n");
     * 
     * System.out.println();
     * System.out.println("-------------------Clone test---------------------");
     * 
     * System.out.println(misty);
     * Trainer mistyClone = (Trainer) misty.clone();
     * 
     * System.out.println(mistyClone);
     * 
     * } catch (Exception e) {
     * System.out.println("An error occurred: " + e.getMessage());
     * }
     * 
     * }
     */

    public static void main(String[] args) {
        try {
            Gym gym = new Gym();
            Pokemon charmander = new FirePokemon("Charmander");
            Pokemon squirtle = new WaterPokemon("Squirtle");
            Pokemon bulbasaur = new FirePokemon("Bulbasaur");
            Pokemon pikachu = new IcePokemon("Pikachu");
            Pokemon mewtwo = new StonePokemon("Mewtwo");
            Pokemon snorlax = new StonePokemon("Snorlax");
            Pokemon eevee = new WaterPokemon("Eevee");
            Pokemon jigglypuff = new IcePokemon("Jigglypuff");
            Pokemon onix = new StonePokemon("Onix");
            Pokemon growlithe = new FirePokemon("Growlithe");
            Pokemon psyduck = new WaterPokemon("Psyduck");
            Pokemon vulpix = new FirePokemon("Vulpix");
            Pokemon lapras = new IcePokemon("Lapras");
            Pokemon geodude = new StonePokemon("Geodude");
            Pokemon magikarp = new WaterPokemon("Magikarp");
            Pokemon flareon = new FirePokemon("Flareon");
            Pokemon articuno = new IcePokemon("Articuno");
            Pokemon graveler = new StonePokemon("Graveler");

            Trainer ash = new Trainer("Ash");
            Trainer misty = new Trainer("Misty");
            Trainer brock = new Trainer("Brock");
            Trainer gary = new Trainer("Gary");
            Trainer james = new Trainer("James");
            Trainer tonyStark = new Trainer("Tony Stark");
            Trainer elteclas = new Trainer("El madafakin teclas vro");
            Trainer vscode = new Trainer("mi amigo vscode");

            ash.addCredits(1000);
            misty.addCredits(1000);
            brock.addCredits(1000);
            gary.addCredits(1000);
            james.addCredits(1000);
            vscode.addCredits(1000);

            ash.purchase(charmander);
            ash.purchase(squirtle);

            misty.purchase(pikachu);
            misty.purchase(vulpix);

            brock.purchase(eevee);
            brock.purchase(jigglypuff);

            gary.purchase(growlithe);
            gary.purchase(vulpix);

            james.purchase(geodude);
            james.purchase(magikarp);

            vscode.purchase(mewtwo);
            vscode.purchase(vulpix);
            vscode.purchase(geodude);

            elteclas.purchase(flareon);
            elteclas.purchase(vulpix);
            elteclas.purchase(geodude);

            tonyStark.purchase(pikachu);
            tonyStark.purchase(vulpix);
            tonyStark.purchase(geodude);

            // Ash purchases a Pokemon that already exists in his collection. Should not
            // duplicate
            ash.purchase(charmander);

            Weapon sword = new Sword();
            misty.purchase(sword);
            snorlax.setWeapon(sword);
            mewtwo.setWeapon(sword);
            onix.setWeapon(sword);
            geodude.setWeapon(sword);
            graveler.setWeapon(sword);

            BaseArena a1 = new BaseArena("Pewter City");
            ArenaWithType arenatipo1 = new ArenaWithType(a1, "Forest");
            ArenaWithLevel arena1 = new ArenaWithLevel(arenatipo1, "Easy");

            BaseArena a2 = new BaseArena("Cerulean City");
            ArenaWithType arenatipo2 = new ArenaWithType(a2, "Forest");
            ArenaWithLevel arena2 = new ArenaWithLevel(arenatipo2, "Easy");

            gym.addArena(arena1);
            gym.addArena(arena2);

            ArrayList<Trainer> trainers = new ArrayList<>();
            trainers.add(ash);
            trainers.add(misty);
            trainers.add(brock);
            trainers.add(gary);
            trainers.add(james);
            trainers.add(vscode);
            trainers.add(elteclas);
            trainers.add(tonyStark);

            Collections.shuffle(trainers);

            Tournament tournament = new Tournament(gym, trainers);

            tournament.startTournament();

            // Battle battle1 = new Battle(gym, misty,ash);
            // Battle battle2 = new Battle(gym, brock, gary);
            // Battle battle3 = new Battle(gym, james, rick);
            // Thread t1 = new Thread(battle1);
            // Thread t2 = new Thread(battle2);
            // Thread t3 = new Thread(battle3);

            // t1.start();
            // t2.start();
            // t3.start();

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

    }

}
