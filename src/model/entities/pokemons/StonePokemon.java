package model.entities.pokemons;

import model.entities.weapons.Weapon;

public class StonePokemon extends Pokemon {

	protected double rechargeRate;

	protected Weapon weapon;

	/**
	 * Constructor for StonePokemon
	 * preconditions: name != null
	 * 
	 * @param name the name of the pokemon
	 */
	public StonePokemon(String name) {
		super(name, 0, 300, 600, 150, 200);
		this.rechargeRate = 0.1;
	}

	@Override
	public void attack(Pokemon other) {
		if (this.weapon != null) {
			weapon.attack(other);
		} else
			super.attack(other);
	}

	@Override
	protected double getAttack() {
		return this.damage * 0.15;
	}

	@Override
	public void afterAttack() {
		this.damage -= this.damage * 0.05;
		this.damage = Math.max(this.damage, 1);
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

		this.health = percentage * 600;
		this.shield = percentage * 300;
		this.damage = percentage * 150;
	}

	@Override
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	@Override
	public void bewitchFog() {
		this.damage *= 0.4;
	}

	@Override
	public void bewitchWind() {
		this.health *= 0.25;
	}

	@Override
	public void bewitchStorm() {
		this.shield = 0;
		this.damage *= 0.7;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		StonePokemon clone = (StonePokemon) super.clone();

		if (this.weapon != null)
			clone.weapon = (Weapon) this.weapon.clone();
		else
			clone.weapon = null;

		return clone;
	}

}
