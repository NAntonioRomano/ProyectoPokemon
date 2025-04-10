package exceptions;

public class TrainerWithoutPokemonsException extends Exception {
    public TrainerWithoutPokemonsException() {
        super("El entrenador no tiene pokemones disponibles");
    }
}