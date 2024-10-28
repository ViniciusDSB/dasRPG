package weapons.wizardWpns;

import weapons.Weapon;

//Magia da transmutação: reduz o cálcio dos ossos do oponente, deixando-os mais porosos.
//  Modificador: 0.25.
//Psikappa: com o poder de telecinese, arremessa o oponente à distˆancia.
//  Modificador: 0.5.

public abstract class WizardWpn extends Weapon{
    public WizardWpn(String name, double dmgModifier){
        super(name, dmgModifier);
    }
}
