public class Main {
    public static void main(String[] args) {
        Character testCharacter=new Character("Sneak");
        Equipment testWeapon = new Equipment("Iron Pipe", "attack", 5);
        Equipment testShield = new Equipment("Paper Plate", "defense", 1);
        testCharacter.equipWeapon(testWeapon);
        testCharacter.equipShield(testShield);
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