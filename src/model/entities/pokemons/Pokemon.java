package model.entities.pokemons;

import model.capabilities.PokemonCapability;
import model.entities.weapons.Weapon;
import model.interfaces.Buyer;
import model.interfaces.Classifiable;
import model.interfaces.Hostile;
import model.interfaces.Valuable;
import model.interfaces.Witchable;

public abstract class Pokemon implements Hostile, Valuable, Classifiable, Witchable, Cloneable {
	protected String name;
	protected int xp;
	protected double shield;
	protected double health;
	protected double damage;
	protected double cost;

	/**
	 * Constructor for the Pokemon class.
	 * preconditions: name != null && xp >= 0 && shield >= 0 && health > 0 && damage
	 * >= 0 && cost >= 0
	 * 
	 * @param name   The name of the Pokemon.
	 * @param xp     The experience points of the Pokemon.
	 * @param shield The shield of the Pokemon.
	 * @param health The health of the Pokemon.
	 * @param damage The damage of the Pokemon.
	 * @param cost   The cost of the Pokemon.
	 */
	public Pokemon(String name, int xp, double shield, double health, double damage, double cost) {
		super();
		this.name = name;
		this.xp = xp;
		this.shield = shield;
		this.health = health;
		this.damage = damage;
		this.cost = cost;
	}

	public Pokemon() {
		this("Unknown", 0, 0.0, 100.0, 10.0, 0.0);
	}

	public String getName() {
		return this.name;
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

	@Override
	public double getCost() {
		return this.cost;
	}

	@Override
	public int getCategory() {
		return this.xp;
	}

	protected abstract double getAttack();

	/**
	 * Calculate the damage received
	 * preconditions: damage >= 0
	 * 
	 * @param damage The damage received
	 */

	protected abstract void getReceiveDamage(double damage);

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

	public void setWeapon(Weapon weapon) {
		throw new UnsupportedOperationException(name + " cannot use a weapon");
	}

	/**
	 * Checks if the pokemon is dead
	 * 
	 * @return true if the pokemon is dead, false otherwise
	 */
	public boolean isDead() {
		return this.health <= 0;
	}

	/**
	 * Increment the xp of the pokemon
	 * preconditions: xp >= 0
	 * 
	 * @param xp The xp to increment
	 */
	public void incrementXp(int xp) {
		this.xp += xp;
	}

	/**
	 * Increment the xp of the pokemon by 1
	 */
	public void incrementXp() {
		incrementXp(1);
	}

	/**
	 * Recharge the pokemon
	 */
	public abstract void recharge();

	/**
	 * Recieves damage from another pokemon
	 * preconditions: damage >= 0
	 * 
	 * @param damage The damage received
	 */
	public void receiveDamage(double damage) {
		getReceiveDamage(damage);
		this.shield = Math.max(0, this.shield);
		this.health = Math.max(0, this.health);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [name=" + name + ", xp=" + xp + ", shield=" + shield + ", health="
				+ health + ", damage="
				+ damage + ", cost=" + cost + "]";
	}

	@Override
	public void attack(Pokemon other) {
		other.receiveDamage(getAttack());

		if (other.isDead())
			incrementXp();

		afterAttack();
	}

	@Override
	public void deliverTo(Buyer buyer) {
		PokemonCapability capability = (PokemonCapability) buyer;

		if (capability.canPokemonBePurchased(this))
			capability.onPokemonPurchased(this);
		else
			System.out.println("Already have " + name + "!");
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public void bewitchFog() {
		throw new UnsupportedOperationException("Pokemon cannot bewitch fog");
	}

	@Override
	public void bewitchWind() {
		throw new UnsupportedOperationException("Pokemon cannot bewitch wind");
	}

	@Override
	public void bewitchStorm() {
		throw new UnsupportedOperationException("Pokemon cannot bewitch storm");
	}

}
