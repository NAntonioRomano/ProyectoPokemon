# Proyecto Pokémon

## Patrones de Diseño Implementados

### Template Method
- **Pokemon.java**: Se implementan los métodos `getAttack()` y `getReceiveDamage()` como parte de un patrón Template Method, donde el flujo de ejecución está definido en una clase base y las subclases pueden proporcionar implementaciones específicas de los métodos.

### Double Dispatch
- **Witchable.java / Spell.java**: Se utiliza el patrón Double Dispatch para permitir la interacción entre dos clases de manera que se pueda determinar el comportamiento correcto según los tipos de los objetos involucrados, logrando un nivel de polimorfismo adicional durante las invocaciones de métodos.

### Capability
- **PokemonCapability.java / WeaponCapability.java**: En este proyecto se aplica el patrón Capability para permitir que diferentes objetos (como Pokémon y Armas) adquieran y utilicen capacidades específicas. Cada objeto puede tener comportamientos modificados o extendidos dependiendo de las capacidades que implementa.

## Interfaces: Buyer y Valuable
- **Buyer**: Representa a un comprador genérico que puede adquirir cualquier objeto que implemente la interfaz **Valuable**. Un **Buyer** debe implementar las **Capabilities** requeridas por los **Valuables** que desea comprar.
- En la interfaz **Buyer**, se aplica el patrón Template Method a través del método `deliverTo(Valuable v)`, el cual realiza el proceso de entrega y requiere que el **Buyer** implemente la lógica correspondiente. Además, se emplea el patrón Double Dispatch en este método para manejar correctamente los tipos de objetos durante la entrega.

## TrainerPrepared
- La clase **TrainerPrepared** permite que un entrenador (o **Trainer**) elija hasta tres Pokémon para participar en una batalla dentro de la Arena. Esta clase gestiona los Pokémon disponibles y su estrategia en el combate.

## Arena
- La **Arena** está especializada en la lucha entre dos entrenadores preparados (**TrainerPrepared**). La batalla finaliza cuando uno de los entrenadores se queda sin Pokémon disponibles para continuar luchando. La Arena administra el combate y asegura que las reglas del enfrentamiento se mantengan de acuerdo con las condiciones definidas.
