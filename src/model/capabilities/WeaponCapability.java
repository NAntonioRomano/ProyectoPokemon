package model.capabilities;

import model.entities.weapons.Weapon;

/**
 * This interface defines the capability to handle weapons.
 * It includes a method to be called when a weapon is purchased.
 */
public interface WeaponCapability {

    /**
     * This method is called when a weapon is purchased.
     *
     * @param weapon The weapon that was purchased.
     */
    void onWeaponPurchased(Weapon weapon);
}
