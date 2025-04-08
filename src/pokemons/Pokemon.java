package pokemons;

import interfaces.IPokemon;

public abstract class Pokemon implements IPokemon {
	protected String name;
	protected int xp;
	protected double shield;
	protected double health;
	protected double damage;
	protected int cost;

	public Pokemon(String name, int xp, double shield, double health, double damage, int cost) {
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

	protected void afterAttack() {
	}

	@Override
	public void attack(IPokemon other) {
		other.receiveDamage(getAttack());
		afterAttack();
	}

	@Override
	public void receiveDamage(double damage) {
		getReceiveDamage(damage);
		this.shield = Math.max(0, this.shield);
		this.health = Math.max(0, this.health);
	}
}
