package pokemons;

public class WaterPokemon extends Pokemon {

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
			this.health -= damage * 0.5;
		} else
			this.health -= damage;
	}

}
