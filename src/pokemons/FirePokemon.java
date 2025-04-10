package pokemons;

public class FirePokemon extends Pokemon {
	
	protected double rechargeRate = 0.05;

	public FirePokemon(String name) {
		super(name, 0, 200, 530, 80, 120);
	}

	public FirePokemon(String name, int xp, double shield, double health, double damage, int cost) {
		super(name, xp, shield, health, damage, cost);
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
		double percentage = 0.8 * ((1 + rechargeRate) * this.xp);
		
		this.health = percentage * 530;
		this.shield = percentage * 200;
		this.damage = percentage * 80;		
	}
	
}
