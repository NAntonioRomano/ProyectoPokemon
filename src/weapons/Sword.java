package weapons;

import pokemons.Pokemon;

public class Sword extends Weapon {

	public Sword() {
		super(50, 100);
	}

	@Override
	public void attack(Pokemon pokemon) {
		pokemon.receiveDamage(damage);
	}

}
