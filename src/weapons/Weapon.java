package weapons;

import interfaces.Hostile;
import interfaces.Valuable;

public abstract class Weapon implements Hostile, Valuable {

	protected double cost;

	public Weapon(double cost) {
		super();
		this.cost = cost;
	}

	@Override
	public double getCost() {
		return this.cost;
	}

}
