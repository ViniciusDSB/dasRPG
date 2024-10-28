package dasRpg;

import java.util.Scanner;
import roles.*;
import weapons.*;

import weapons.clericWpns.*;
import weapons.paladinWpns.*;
import weapons.wizardWpns.*;



public class Master {

    public static void main(String[] args){
        Scanner scann = new Scanner(System.in);

        Role player1 = setPlayerInfo(scann);
        Role player2 = setPlayerInfo(scann);
        
        //if some invalid option was given, player1 or 2, or both wll be =null, so the program finished.
        if(player1 != null && player2 != null){
            player1.printStatus();
            player2.printStatus();

            int attacker = 1; //can be any value but 0
            int defender = 1;

            //there are only 2 players, so only 3 options are possible, based on the description of the project
            //1 - type 0 as first input -> the program ends;
            //2 - type 1 2 or 2 1 -> player 1 attacks 2 or player 2 attacks player 1;
            //3 - type invalid input, like: 1 1, 2 2, 1 0, 2 0, 3 0,... -> nothing happens
            //if the program is not finished, their status are printed anyway.

            while(attacker != 0){

                attacker = scann.nextInt();
                if(attacker == 0)
                    break; //if the first action input is 0 the execution is finished.
                defender = scann.nextInt();

                if(attacker == 1 && defender == 2)
                    player1.attack(player2);
                else if (attacker == 2 && defender == 1)
                    player2.attack(player1);

                player1.printStatus();
                player2.printStatus();

            }

        }

        scann.close();
    }

    public static Role setPlayerInfo(Scanner scann){
        Role player;
        
        //1 - Wizard
        //  1 - transmutation, 2 - psikapa
        //2 - Paladin
        //  1 - sword, 2 - arrow
        //3 - Cleric
        //  1 - hammer, 2 - apple
        
        int name = scann.nextInt();
        double health = scann.nextDouble();
        double force = scann.nextDouble();
        double hability = scann.nextDouble();
        int weapon = scann.nextInt();

        if(name == 1){//define player como mago
            WizardWpn wpn = ( weapon == 1  ) ? new Transmutation() : new Psikappa();
            player = new Wizard(health, force, hability, wpn);
        }
        else if(name == 2){//define player como paladino
            PaladinWpn wpn = ( weapon == 1  ) ? new Sword() : new Spear();
            player = new Paladin(health, force, hability, wpn);
        }
        else if(name == 3){//define player como cleigo
            ClericWpn wpn = ( weapon == 1  ) ? new Hammer() : new Apple();
            player = new Cleric(health, force, hability, wpn);
        }
        else{
            player = null; //if an invalidoption is given
        }

        return player;
    }
}
