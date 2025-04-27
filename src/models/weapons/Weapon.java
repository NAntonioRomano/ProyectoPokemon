package models.weapons;

import capabilities.WeaponCapability;
import interfaces.Buyer;
import interfaces.Hostile;
import interfaces.Valuable;

public abstract class Weapon implements Hostile, Valuable, Cloneable {

	protected double cost;

	/**
	 * Constructor for the Weapon class.
	 * preconditions: cost >= 0
	 * 
	 * @param cost The cost of the weapon.
	 */
	public Weapon(double cost) {
		super();
		this.cost = cost;
	}

	@Override
	public double getCost() {
		return this.cost;
	}

	@Override
	public void deliverTo(Buyer buyer) {
		((WeaponCapability) buyer).onWeaponPurchased(this);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
