package model.entities.weapons;

public class WeaponFactory {
    public static Weapon newWeapon(String type) throws IllegalArgumentException {
        switch (type) {
            case "SWORD":
                return new Sword();
            case "AXE":
                return new Axe();
        }

        throw new IllegalArgumentException("Unknown weapon type: " + type);
    }
}
