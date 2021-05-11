public class Main {
    public static void main(String[] args) {
        //Testing Character/Equipment Creation
        Character testCharacter=new Character("Sneak");
        Character testCharacter2=new Character();

        Equipment testWeapon = new Equipment("Iron Pipe", 0);
        testWeapon.setAttackBonus(5);
        Equipment testShield = new Equipment("Paper Plate", 1);
        testShield.setDefenseBonus(1);
        testCharacter.equip(testWeapon);
        testCharacter.equip(testShield);

        testCharacter.displayCharacterBaseStats();
        testCharacter.displayCharacterStats();
        testCharacter.displayCharacter();
        testCharacter2.displayCharacter();

        //Testing Map
        Battlegrid testGrid=new Battlegrid();
        testGrid.blankBattleGrid();
        testGrid.addCharacter(testCharacter,5,5);
        System.out.println(testGrid.outputMapTest());
        testGrid.moveCharacter(5,5,6,5);
        System.out.println(testGrid.outputMapTest());

        //Testing Combat
        Combat battle = new Combat();
        battle.attack(testCharacter, testCharacter2);
        testCharacter2.displayCharacter();
        System.out.println();
        testCharacter2.fullRestore();
        battle.attack(testCharacter2, testCharacter);
        testCharacter.displayCharacter();
        System.out.println();
        battle.defend(testCharacter2);
        battle.attack(testCharacter, testCharacter2);
        testCharacter2.displayCharacter();
    }
}
