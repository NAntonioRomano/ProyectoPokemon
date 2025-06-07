package model.entities.pokemons;

public class IcePokemon extends Pokemon {

	/**
	 * Constructor for IcePokemon.
	 * preconditions: name != null
	 * 
	 * @param name The name of the IcePokemon.
	 */
	public IcePokemon(String name) {
		super(name, 0, 120, 400, 100, 100);
	}

	@Override
	protected double getAttack() {
		return damage * 0.15;
	}

	@Override
	public void afterAttack() {
		this.damage *= 0.95;
		this.damage = Math.max(this.damage, 1);
	}

	@Override
	protected void getReceiveDamage(double damage) {
		if (this.shield > 0) {
			this.shield -= damage;
			if (this.shield < 0)
				this.health += this.shield;
		} else
			this.health -= damage;
	}

	@Override
	public void recharge() {
		this.health += 200;
		this.shield += 100;
		this.damage += 100;
	}

	@Override
	public void bewitchFog() {
		this.damage *= 0.4;
	}

	@Override
	public void bewitchWind() {
		this.damage *= 0.8;
		this.health *= 0.8;
	}

	@Override
	public void bewitchStorm() {
		this.shield *= 0.2;
	}
}
