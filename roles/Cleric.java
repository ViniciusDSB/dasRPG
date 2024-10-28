package roles;

import weapons.clericWpns.ClericWpn;

public class Cleric extends Role{

    public Cleric(double health, double force, double hability, ClericWpn weapon) {
        super("Clerigo", health, force, hability, weapon);
    }

}

