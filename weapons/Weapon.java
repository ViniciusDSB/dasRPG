package weapons;

public abstract class Weapon {
    private String name;
    private double dmgModifier;

    public Weapon(String name, double dmgModifier){
        this.name = name;
        this.dmgModifier = dmgModifier;
    }

    public String getName(){
        return this.name;
    }
    public double getDamageModifier(){
        return this.dmgModifier;
    }
}
