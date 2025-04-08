package interfaces;

public interface IPokemon {
	void attack(IPokemon other);

	void receiveDamage(double damage);

	void recharge();
}
