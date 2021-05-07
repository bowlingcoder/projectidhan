public class Main {
    public static void main(String[] args) {
        Character testCharacter=new Character();
        testCharacter.name="Test";
        Battlegrid testGrid=new Battlegrid();
        testGrid.blankBattleGrid();
        testGrid.addCharacter(testCharacter,5,5);
        System.out.println(testGrid.outputMapTest());
        testGrid.moveCharacter(5,5,6,5);
        System.out.println(testGrid.outputMapTest());
    }
}