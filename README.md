#Proyecto Pokemon

##Patrones de diseño implementados
* Template Method
    - Pokemon.java -> getAttack() / getReceiveDamage()
* Double Dispatch
    - Witchable.java / Spell.java 
* Capability
    - PokemonCapability.java / WeaponCapability.java

##Interfaces Buyer and Valuable
    - Un Buyer podría comprar cualquier Valuable
    - Un Buyer debe implementar las Capabilities de los Valuables que quiere comprar
    - En la Interface Buyer, se aplica un Template Method y se usa un Double Dispatch (deliverTo(Valuable v)) 

##TrainerPrepared
    - Trainer con hasta tres pokemons elegidos para el combate en la Arena

##Arena
    - Arena especializada en la lucha entre dos TrainerPrepared
    - El combate finaliza cuando alguno de los entrenadores se queda sin pokemons

