package model.models.weapons;

public class WeaponFactory {
    public static Weapon newWeapon(String type){
        switch (type) {
            case "SWORD":
                return new Sword();
            case "AXE":
                return new Axe();
        }
        return null;
    }
}
