package models.pokemons;

import capabilties.PokemonCapability;
import interfaces.Buyer;
import interfaces.Classifiable;
import interfaces.Hostile;
import interfaces.Valuable;
import interfaces.Witchable;

public abstract class Pokemon implements Hostile, Valuable, Classifiable, Witchable {
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

	protected abstract double getAttack();

	protected abstract void getReceiveDamage(double damage);

	protected abstract void recharge();

	protected void afterAttack() {
	}

	@Override
	public void attack(Pokemon other) {
		if (other.isDead())
			System.out.println(other.getName() + " is already dead!");
		else {
			System.out.println("Attacking " + other.getName() + " with " + this.getName());
			other.receiveDamage(getAttack());
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
		((PokemonCapability) buyer).onPokemonPurchased(this);
	}

	public String getName() {
		return this.name;
	}

	public boolean isDead() {
		return this.health <= 0;
	}

}
