package models.weapons;

import capabilities.WeaponCapability;
import interfaces.Buyer;
import interfaces.Hostile;
import interfaces.Valuable;

/**
 * Abstract class representing a weapon.
 * Implements the Hostile and Valuable interfaces.
 */
public abstract class Weapon implements Hostile, Valuable, Cloneable {

	protected double cost;

	/**
	 * Constructor for the Weapon class.
	 * 
	 * @param cost The cost of the weapon.
	 */
	public Weapon(double cost) {
		super();
		this.cost = cost;
	}

	@Override
	public void afterAttack() {
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
