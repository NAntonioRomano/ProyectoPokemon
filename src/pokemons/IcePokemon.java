package pokemons;

public class IcePokemon extends Pokemon {

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
	}

	@Override
	protected void getReceiveDamage(double damage) {
		if (this.shield > 0)
			this.shield -= damage;
		else
			this.health -= damage;
	}

	@Override
	public void recharge() {
		this.health += 200;
		this.shield += 100;
		this.damage += 100;

	}
}
