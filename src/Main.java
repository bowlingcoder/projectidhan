public class Main {
    public static void main(String[] args) {
        Character testCharacter=new Character("Sneak");
        Equipment testWeapon = new Equipment("Iron Pipe", 0);
        testWeapon.attackBonus=5;
        Equipment testShield = new Equipment("Paper Plate", 1);
        testShield.defenseBonus=1;
        testCharacter.equip(testWeapon);
        testCharacter.equip(testShield);
        testCharacter.fullRestore();
        testCharacter.displayCharacterBaseStats();
        testCharacter.displayCharacterStats();
        testCharacter.displayCharacter();

        Battlegrid testGrid=new Battlegrid();
        testGrid.blankBattleGrid();
        testGrid.addCharacter(testCharacter,5,5);
        System.out.println(testGrid.outputMapTest());
        testGrid.moveCharacter(5,5,6,5);
        System.out.println(testGrid.outputMapTest());
    }
}