package models.pokemons;

import capabilities.PokemonCapability;
import interfaces.Buyer;
import interfaces.Classifiable;
import interfaces.Hostile;
import interfaces.Valuable;
import interfaces.Witchable;
import models.weapons.Weapon;

public abstract class Pokemon implements Hostile, Valuable, Classifiable, Witchable, Cloneable {
	protected String name;
	protected int xp;
	protected double shield;
	protected double health;
	protected double damage;
	protected double cost;

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

	protected abstract double getAttack();

	protected abstract void getReceiveDamage(double damage);

	protected abstract void recharge();

	protected void afterAttack() {
	}

	public void setWeapon(Weapon weapon) {
		throw new UnsupportedOperationException(name + " cannot use a weapon");
	}

	@Override
	public void attack(Pokemon other) {
		if (other.isDead())
			System.out.println(other.getName() + " is already dead!");
		else {
			System.out.println(this.getName() + " is attacking " + other.getName() + "!");
			other.receiveDamage(getAttack());

			if (other.isDead())
				incrementXp();

			afterAttack();
		}
	}

	public void receiveDamage(double damage) {
		getReceiveDamage(damage);
		this.shield = Math.max(0, this.shield);
		this.health = Math.max(0, this.health);

		if (this.isDead())
			System.out.println(this.getName() + " has died!");
	}

	@Override
	public double getCost() {
		return this.cost;
	}

	@Override
	public int getCategory() {
		return this.xp;
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
	public String toString() {
		return getClass().getSimpleName() + " [name=" + name + ", xp=" + xp + ", shield=" + shield + ", health="
				+ health + ", damage="
				+ damage + ", cost=" + cost + "]";
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
