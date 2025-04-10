package pokemons;

import weapons.Weapon;

public class StonePokemon extends FirePokemon {

	protected Weapon weapon;

	public StonePokemon(String name) {
		super(name, 0, 300, 600, 150, 200);
		this.rechargeRate = 0.1;
	}

	@Override
	public void attack(Pokemon other) {
		if (this.weapon != null)
			weapon.attack(other);
		else
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

}
