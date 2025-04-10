package weapons;

import interfaces.Hostile;

public abstract class Weapon implements Hostile {
	
	protected double cost;
	protected double damage;
	
	public Weapon(double cost, double damage) {
		super();
		this.cost = cost;
		this.damage = damage;
	}
}
