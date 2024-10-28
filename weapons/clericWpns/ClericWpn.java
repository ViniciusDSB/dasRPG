package weapons.clericWpns;

import weapons.Weapon;

//Martelo: apesar de pesado, e uma arma letal.
//  Modificador: 0.6.
//Maça: por ser mais leve, e mais fácil de manusear.
//  Modificador: 0.4

public abstract class ClericWpn extends Weapon{
    public ClericWpn(String name, double dmgModifier){
        super(name, dmgModifier);
    }
}
