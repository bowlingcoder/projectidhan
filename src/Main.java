import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Project Idhan\nWhat is the name of your character");
        //Testing Character/Equipment Creation
        Scanner myObj = new Scanner(System.in);
        String mainCharacterName = myObj.nextLine();
        Character testCharacter=new Character(mainCharacterName);
        battleSim(testCharacter); //Testing Battle class

        //Testing Map
        Battlegrid testGrid=new Battlegrid();
        testGrid.blankBattleGrid();
        testGrid.addCharacter(testCharacter,5,5);
        System.out.println(testGrid.outputMapTest());
        testGrid.moveCharacter(5,5,6,5);
        System.out.println(testGrid.outputMapTest());

    }

    public static void battleSim(Character combatant){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Welcome to the battle sim, here we will do a demo battle");
        Character opponent=new Character();
        Equipment testWeapon = new Equipment("Iron Pipe", 0);
        testWeapon.setAttackBonus(2);
        //Equipment testShield = new Equipment("Paper Plate", 1);
        //testShield.setDefenseBonus(1);
        combatant.equip(testWeapon);
        //combantant.equip(testShield);
        System.out.println("Here you are, we have given some basic equipment.");
        combatant.displayCharacter();

        System.out.println("And here is your demo opponent");
        opponent.displayCharacterStats();
        System.out.println("Let the battle begin.");
        Combat battle = new Combat();
        String option = "";
        String opponentOption ="";
        String[] opponentChoices = {"attack","defend"};
        while(combatant.getHealth()>0 && opponent.getHealth()>0) {
            System.out.println("Player's turn.\nDo you wish to attack or defend?");
            if(option.equals("reset")){ combatant.setDefense(combatant.getDefense()/2); }
            while(!option.equals("attack") && !option.equals("defend")) {
                option = myObj.nextLine();
                if (option.equals("attack")) { battle.attack(combatant, opponent); }
                else if (option.equals("defend")) { battle.defend(combatant); }
                else { System.out.println("Type in either attack or defend"); }
            }
            if(option.equals("defend")){ option = "reset"; }
            else{ option = "";}

            System.out.println("Opponent's Turn");
            if(opponentOption.equals("reset")){  opponent.setDefense(opponent.getDefense()/2); }
            opponentOption = opponentChoices[(int) (Math.floor(Math.random()*2))];
            if(opponentOption.equals("attack")) { battle.attack(opponent, combatant); }
            else { battle.defend(opponent); }
            if(opponentOption.equals("defend")){ opponentOption = "reset"; }
            else{ opponentOption = "";}

            combatant.displayCharacter();
            opponent.displayCharacter();
        }
        System.out.println("Battle has concluded.");
    }
}
