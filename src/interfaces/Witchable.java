package interfaces;

/**
 * Witchable interface represents an object that can be bewitched by Spell
 */
public interface Witchable {

    /**
     * This method is used to bewitch the object with a fog spell.
     */
    void bewitchFog();

    /**
     * This method is used to bewitch the object with a wind spell.
     */
    void bewitchWind();

    /**
     * This method is used to bewitch the object with a storm spell.
     */
    void bewitchStorm();
}