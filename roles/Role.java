package roles;

import weapons.Weapon;

public abstract class Role{

     private String name;
     private double health;
     private double force;
     private double hability;
     private Weapon weapon;

     public Role(String name, double health, double force, double hability, Weapon weapon){
          this.name = name;
          this.health = health;
          this.force = force;
          this.hability = hability;
          this.weapon = weapon;
     }

     public void printStatus() {
          String formattedHealth = String.format("%.2f", this.getHealth());
          String formattedForce = String.format("%.2f", this.getForce());
          String formattedHability = String.format("%.2f", this.getHability());
 
          if (this.isAlive())
               System.out.println(this.getName() + " [Saude: " + formattedHealth + ", Forca: " + formattedForce + ", Destreza: " + formattedHability + ", " + this.weapon.getName() + "]");
          else
               System.out.println(this.name + " [Morreu, Forca: " + formattedForce + ", Destreza: " + formattedHability + ", " + this.weapon.getName() + "]");
     }

     private boolean isAlive(){
          if(this.health>=1)
               return true;
          else
               return false;
     }

     public void attack(Role opponent) {
          //if i am alive then
          //   i try try to attack only if opponent isItAlive;

          if(this.isAlive()) {
              
               if (opponent.isItAlive()) {
                    System.out.println("O " + this.name + " ataca o " + opponent.getName() + " com " + this.weapon.getName() + ".");

                    //block to check hability levels; it only deals damage if
                    //   opponent.habbility < self.hability
                    //or if opponent.habbility > self.hability then
                    //   self receive(opponent.damage)
                    //if none is true their habilities can only be equal -> so attack is defended

                    if (opponent.getHability() < this.hability) {
                         double damage = this.calculateDamage();
                         opponent.hitted(damage);
                         System.out.println("O ataque foi efetivo com " + String.format("%.2f", damage) + " pontos de dano!");
                    } 
                    else if(opponent.getHability() > this.hability) {
                         double damageReceived = opponent.getDamage();
                         this.receiveDamage(damageReceived);
                         System.out.println("O ataque foi inefetivo e revidado com " + String.format("%.2f", damageReceived) + " pontos de dano!");
                    }
                    else
                         System.out.println("O ataque foi defendido, ninguém se machucou!");

               }else
                  System.out.println("Pare! O " + opponent.getName() + " já está morto!");
          }else
               System.out.println("O " + this.name + " não consegue atacar, pois está morto.");
     }
      
     //deduces damage from my health points
     private void receiveDamage(double receivedDamage){
          this.health -= receivedDamage;
     }
     //calculates my damage
     private double calculateDamage(){
          return this.force * this.weapon.getDamageModifier();
     }

     //Public versions of isAlive(), calculateDamage() and receiveDamage()
     
     //i tell the attacker if i am alive
     public boolean isItAlive(){
          return isAlive();
     }
     
     //i receive attacker damage and decrease my health points
     public void hitted(double damage){
          this.receiveDamage(damage);
     }
     
     //i tell the opponent my damage, so he can decrease his health
     public double getDamage(){
          return this.calculateDamage();
     }

     public String getName() {
          return this.name;
     }
     public double getHealth() {
          return this.health;
     }
     public double getForce() {
         return this.force;
     }
     public double getHability() {
         return this.hability;
     }
     
}
