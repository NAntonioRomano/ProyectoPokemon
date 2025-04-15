package models;

import models.pokemons.*;

public class Arena {
    private String name;

    public Arena(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public TrainerPrepared startBattle(TrainerPrepared TP1, TrainerPrepared TP2){
        int cantBattleT1 = 0;
        int cantBattleT2 = 0;

        Pokemon inBattleT1 = TP1.getPokemons()[cantBattleT1];
        Pokemon inBattleT2 = TP2.getPokemons()[cantBattleT2];

        while(!TP1.allDeadPokemons() && !TP2.allDeadPokemons()){
            inBattleT1.attack(inBattleT2);
            if(!inBattleT2.isDead()){
                inBattleT2.attack(inBattleT1);
            }else if(!TP2.allDeadPokemons()){
                cantBattleT2++;
                inBattleT2 = TP2.getPokemons()[cantBattleT2];
            }
            
            if(!TP1.allDeadPokemons() && inBattleT1.isDead()){
                cantBattleT1++;
                inBattleT1 = TP1.getPokemons()[cantBattleT1];
            }
        }

        if (TP1.allDeadPokemons())
            return TP2;

        return TP1;

    }


}