package models.pokemons;

public class FirePokemon extends Pokemon {

	protected double rechargeRate;

	/**
	 * Constructor for FirePokemon with a name.
	 * preconditions: name != null
	 * 
	 * @param name The name of the FirePokemon.
	 */
	public FirePokemon(String name) {
		super(name, 0, 200, 530, 80, 120);
		this.rechargeRate = 0.05;
	}

	/**
	 * Constructor for FirePokemon with all attributes.
	 * preconditions: name != null, xp >= 0, shield >= 0, health > 0, damage >= 0,
	 * cost >= 0
	 * 
	 * @param name   The name of the FirePokemon.
	 * @param xp     The experience points of the FirePokemon.
	 * @param shield The shield of the FirePokemon.
	 * @param health The health of the FirePokemon.
	 * @param damage The damage of the FirePokemon.
	 * @param cost   The cost of the FirePokemon.
	 */
	public FirePokemon(String name, int xp, double shield, double health, double damage, int cost) {
		super(name, xp, shield, health, damage, cost);
	}

	@Override
	protected double getAttack() {
		return this.damage * 0.2;
	}

	@Override
	public void afterAttack() {
		this.damage = Math.max(10, damage * 0.75);
	}

	@Override
	protected void getReceiveDamage(double damage) {
		if (this.shield > 0) {
			this.shield -= damage * 0.75;
			if (this.shield < 0)
				this.health += this.shield;
			this.health -= damage * 0.25;
		} else
			this.health -= damage;
	}

	@Override
	public void recharge() {
		double percentage = 0.8 * ((1 + rechargeRate) * this.xp);

		this.health = percentage * 530;
		this.shield = percentage * 200;
		this.damage = percentage * 80;
	}

	@Override
	public void bewitchFog() {
		this.damage *= 0.5;
	}

	@Override
	public void bewitchWind() {
		this.health *= 0.5;
	}

	@Override
	public void bewitchStorm() {
		this.shield *= 0.8;
		this.damage *= 0.8;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("FirePokemon cannot be cloned");
	}

}
