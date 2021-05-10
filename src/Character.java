import java.util.ArrayList;

public class Character {
    String name;
    int health;
    int stamina;

    int healthMax;
    int staminaMax;
    int attack;
    int defense;
    int speed;
    int move;

    int healthMaxBase;
    int staminaMaxBase;
    int attackBase;
    int defenseBase;
    int speedBase;
    int moveBase;

    ArrayList<Equipment> equipment=new ArrayList<>();
    ArrayList<Item> item=new ArrayList<>();

    public Character(){
        this.name="Generic";
        this.healthMaxBase=5;
        this.attackBase=1;
        this.defenseBase=1;
        this.speedBase=1;
        this.moveBase=1;

    }
    public Character(String name){
        this.name = name;
        this.healthMaxBase=5;
        this.attackBase=1;
        this.defenseBase=1;
        this.speedBase=1;
        this.moveBase=1;
    }

    public void displayCharacterBaseStats(){
        System.out.println("Character Base Stats");
        System.out.println("Name: "+ name);
        System.out.println("Max HP: "+healthMaxBase);
        System.out.println("Base Attack: "+attackBase);
        System.out.println("Base Defense: "+defenseBase);
        System.out.println("Base Speed: "+speedBase);
        System.out.println("Base Move: "+moveBase);
    }
    public void displayCharacterStats(){
        System.out.println("Character Stats");
        calcStats();
        System.out.println("Name: "+ name);
        System.out.println("Max HP: "+healthMax);
        System.out.println("Attack: "+attack);
        System.out.println("Defense: "+defense);
        System.out.println("Speed: "+speed);
        System.out.println("Move: "+move);
    }
    public void displayCharacter(){
        System.out.println("Character Info");
        System.out.println("Name: "+ name);
        System.out.println("Health: "+ health+"/"+healthMax);
        System.out.println("Stamina: "+ stamina+"/"+staminaMax);
        for (int x=0;x<Setup.equipTypes.length;x++){
            if (isEquipped(x)){
                System.out.println(Setup.equipTypes[x] +": "+ getEquipped(x).name);
            }
            else{
                System.out.println(Setup.equipTypes[x] + ": none");
            }
        }
    }

    public void equip(Equipment toEquip){
        if (isEquipped(toEquip.id)){
            unequip(getEquipped(toEquip.id));
        }
        equipment.add(toEquip);
        calcStats();
    }
    public void unequip(Equipment toEquip){
        equipment.remove(toEquip);
        calcStats();
    }

    public Boolean isEquipped(int id){
        for (Equipment next:equipment){
            if (next.id==id){
                return true;
            }
        }
        return false;
    }
    public Equipment getEquipped(int id){
        for (Equipment next:equipment){
            if (next.id==id){
                return next;
            }
        }
        return null;
    }

    public void zeroStats(){
        healthMax=0;
        attack=0;
        defense=0;

    }
    public void fullHeal(){
        health=healthMax;
    }
    public void fullStamina(){
        stamina=staminaMax;
    }
    public void fullRestore(){
        fullHeal();
        fullStamina();
    }
    public void calcStats(){
        //zeroStats();
        double healthMaxMultiplier=1;
        double staminaMaxMultiplier=1;
        double attackMultiplier=1;
        double defenseMultiplier=1;
        double speedMultiplier=1;
        double moveMultiplier=1;

        int healthMaxBonus=0;
        int staminaMaxBonus=0;
        int attackBonus=0;
        int defenseBonus=0;
        int speedBonus=0;
        int moveBonus=0;

        for (Equipment next:equipment){
            healthMaxBonus+=next.healthMaxBonus;
            staminaMaxBonus+=next.staminaMaxBonus;
            attackBonus+=next.attackBonus;
            defenseBonus+=next.defenseBonus;
            speedBonus+=next.speedBonus;
            moveBonus+=next.moveBonus;

            healthMaxMultiplier+=next.healthMaxMultiplier;
            staminaMaxMultiplier+=next.staminaMaxMultiplier;
            attackMultiplier+=next.attackMultiplier;
            defenseMultiplier+=next.defenseMultiplier;
            speedMultiplier+=next.speedMultiplier;
            moveMultiplier+=next.moveMultiplier;
        }

        healthMax=(int)Math.floor((healthMaxBase+healthMaxBonus)*healthMaxMultiplier);
        staminaMax=(int)Math.floor((staminaMaxBase+staminaMaxBonus)*staminaMaxMultiplier);
        attack=(int)Math.floor((attackBase+attackBonus)*attackMultiplier);
        defense=(int)Math.floor((defenseBase+defenseBonus)*defenseMultiplier);
        speed=(int)Math.floor((speedBase+speedBonus)*speedMultiplier);
        move=(int)Math.floor((moveBase+moveBonus)*moveMultiplier);


        if (health>healthMax){ health=healthMax; }
        if (stamina>staminaMax){ stamina=staminaMax; }
    }
}