package model.dto;

import java.io.Serializable;

public class PokemonDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private int xp;
    private double shield;
    private double health;
    private double damage;
    private double cost;
    private String type;

    public String getName() {
        return name;
    }

    public int getXp() {
        return xp;
    }

    public double getShield() {
        return shield;
    }

    public double getHealth() {
        return health;
    }

    public double getDamage() {
        return damage;
    }

    public double getCost() {
        return cost;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public void setShield(double shield) {
        this.shield = shield;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setType(String type) {
        this.type = type;
    }

}
