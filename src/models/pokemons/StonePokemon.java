package models.pokemons;

import models.weapons.Weapon;

/**
 * StonePokemon class represents a specific type of Pokemon with fire
 * attributes and behaviors.
 */
public class StonePokemon extends FirePokemon {

	protected Weapon weapon;

	/**
	 * Constructor for StonePokemon
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
			System.out.println("⚔️ " + name + " attacks " + other.getName() + " with a wepon with " + damage
					+ " damage!");
			weapon.attack(other);
		} else
			super.attack(other);
	}

	@Override
	protected double getAttack() {
		return this.damage * 0.15;
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
