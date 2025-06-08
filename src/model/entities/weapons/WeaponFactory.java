package model.entities.weapons;

public class WeaponFactory {
    public static Weapon newWeapon(String type) throws IllegalArgumentException {
        switch (type) {
            case "Sword":
                return new Sword();
            case "Axe":
                return new Axe();
        }

        throw new IllegalArgumentException("Unknown weapon type: " + type);
    }
}
