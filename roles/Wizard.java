package roles;

import weapons.wizardWpns.WizardWpn;

public class Wizard extends Role{

    public Wizard(double health, double force, double hability, WizardWpn weapon) {
        super("Mago", health, force, hability, weapon);
    }
}
