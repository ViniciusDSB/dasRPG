package weapons.paladinWpns;

import weapons.Weapon;

//Espada: possui uma lãmina afiada mas é frágil.
//  Modificador: 0.3.
//Lançaa: ataques em longa distãncia.
//  Modificador: 0.5

public abstract class PaladinWpn extends Weapon{
    public PaladinWpn(String name, double dmgModifier){
        super(name, dmgModifier);
    }
}
