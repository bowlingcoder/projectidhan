import java.util.ArrayList;

public class Character {
    String name;
    int health;
    int stamina;

    int healthMax;
    int attack;
    int defense;
    int speed;
    int move;

    int healthMaxBase;
    int attackBase;
    int defenseBase;
    int speedBase;
    int moveBase;

    ArrayList<Equipment> equipment=new ArrayList<>();
    ArrayList<Item> item=new ArrayList<>();

    public void zeroStats(){
        healthMax=0;
        attack=0;
        defense=0;

    }
    public void calcStats(){
        zeroStats();
        double healthMaxMultiplier=1;
        double attackMultiplier=1;
        double defenseMultiplier=1;
        double speedMultiplier=1;
        double moveMultiplier=1;

        int healthMaxBonus=0;
        int attackBonus=0;
        int defenseBonus=0;
        int speedBonus=0;
        int moveBonus=0;

        healthMax=(int)Math.floor((healthMaxBase+healthMaxBonus)*healthMaxMultiplier);
        attack=(int)Math.floor((attackBase+attackBonus)*attackMultiplier);
        defense=(int)Math.floor((defenseBase+defenseBonus)*defenseMultiplier);
        speed=(int)Math.floor((speedBase+speedBonus)*speedMultiplier);
        move=(int)Math.floor((moveBase+moveBonus)*moveMultiplier);

        if (health>healthMax){
            health=healthMax;
        }
    }
}