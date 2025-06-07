package model.models.pokemons;

import model.capabilities.PokemonCapability;
import model.interfaces.Buyer;
import model.interfaces.Classifiable;
import model.interfaces.Hostile;
import model.interfaces.Valuable;
import model.interfaces.Witchable;
import model.models.weapons.Weapon;

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

	public String getName() {
		return this.name;
	}

	public boolean isDead() {
		return this.health <= 0;
	}

	public void incrementXp(int xp) {
		this.xp += xp;
	}

	public void incrementXp() {
		incrementXp(1);
	}

	/**
	 * Return the amount of attack of this pokemon
	 */
	protected abstract double getAttack();

	/**
	 * Calculate the damage received
	 * preconditions: damage >= 0
	 * 
	 * @param damage The damage received
	 */

	protected abstract void getReceiveDamage(double damage);

	/**
	 * Recharge the pokemon
	 */
	public abstract void recharge();

	/**
	 * Set the weapon of the pokemon
	 * preconditions: weapon != null
	 * 
	 * @param weapon The weapon to set
	 */
	public void setWeapon(Weapon weapon) {
		throw new UnsupportedOperationException(name + " cannot use a weapon");
	}

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

	// This method is called from hostile
	@Override
	public void attack(Pokemon other) {
		try {
			Thread.sleep(5);
		} catch (Exception e) {
		}

		other.receiveDamage(getAttack());

		if (other.isDead())
			incrementXp();

		afterAttack();
	}

	// this method is called from Valuable
	@Override
	public double getCost() {
		return this.cost;
	}

	// this method is called from Valuable
	@Override
	public void deliverTo(Buyer buyer) {
		PokemonCapability capability = (PokemonCapability) buyer;

		if (capability.canPokemonBePurchased(this))
			capability.onPokemonPurchased(this);
		else
			System.out.println("Already have " + name + "!");
	}

	// this method is called from Classifiable
	@Override
	public int getCategory() {
		return this.xp;
	}

	// this method is called from Cloneable
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	// this method is called from Witchable
	@Override
	public void bewitchFog() {
		throw new UnsupportedOperationException("Pokemon cannot bewitch fog");
	}

	// this method is called from Witchable
	@Override
	public void bewitchWind() {
		throw new UnsupportedOperationException("Pokemon cannot bewitch wind");
	}

	// this method is called from Witchable
	@Override
	public void bewitchStorm() {
		throw new UnsupportedOperationException("Pokemon cannot bewitch storm");
	}
}
