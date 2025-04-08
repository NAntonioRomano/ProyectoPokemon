package pokemons;

public class FirePokemon extends Pokemon {

	public FirePokemon(String name) {
		super(name, 0, 200, 530, 80, 120);
	}

	@Override
	protected double getAttack() {
		return this.damage * 0.2;
	}
	
	@Override
	protected void afterAttack() {
		this.damage = Math.max(10, damage * 0.75);
	}

	@Override
	protected void getReceiveDamage(double damage) {
		if (this.shield > 0) {
			this.shield -= damage*0.75;
			this.health -= damage*0.25;
		} else
			this.health -= damage;
	}

	@Override
	public void recharge() {
		double percentage = 0.8 + 0.05*this.xp;
		
		this.health = percentage * 530;
		this.shield = percentage * 200;
		this.damage = percentage * 80;		
	}
	
}
