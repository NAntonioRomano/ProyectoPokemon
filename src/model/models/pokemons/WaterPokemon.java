package model.models.pokemons;

public class WaterPokemon extends Pokemon {

	/**
	 * Constructor for WaterPokemon
	 * preconditions: name != null
	 * 
	 * @param name the name of the Pokemon
	 */
	public WaterPokemon(String name) {
		super(name, 0, 100, 500, 120, 100);
	}

	@Override
	public void recharge() {
		this.damage = 120;
		this.health = 500;
		this.shield = 100;
	}

	@Override
	protected double getAttack() {
		return damage * 0.1;
	}

	@Override
	protected void getReceiveDamage(double damage) {
		if (this.shield > 0) {
			this.shield -= damage * 0.5;
			if (this.shield < 0)
				this.health += this.shield;
			this.health -= damage * 0.5;
		} else
			this.health -= damage;
	}

	@Override
	public void bewitchFog() {
		this.damage *= 0.5;
	}

	@Override
	public void bewitchWind() {
		this.damage *= 0.9;
		this.health *= 0.9;
	}

	@Override
	public void bewitchStorm() {
		this.shield *= 0.1;
	}

	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}

}
