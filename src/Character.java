import java.util.ArrayList;

public class Character {
    private String name;
    private int health;
    private int stamina;


    private int healthMax;
    private int staminaMax;
    private int attack;
    private int defense;
    private int speed;
    private int move;

    private int healthMaxBase;
    private int staminaMaxBase;
    private int attackBase;
    private int defenseBase;

    private int speedBase;
    private int moveBase;

    ArrayList<Equipment> equipment=new ArrayList<>();
    ArrayList<Item> item=new ArrayList<>();

    public Character(){
        this.name="Generic";
        this.healthMaxBase=5;
        this.attackBase=1;
        this.defenseBase=1;
        this.speedBase=1;
        this.moveBase=1;
        calcStats();
        fullRestore();
    }
    public Character(String name){
        this.name = name;
        this.healthMaxBase=5;
        this.attackBase=1;
        this.defenseBase=1;
        this.speedBase=1;
        this.moveBase=1;
        calcStats();
        fullRestore();
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
                System.out.println(Setup.equipTypes[x] +": "+ getEquipped(x).getName());
            }
            else{
                System.out.println(Setup.equipTypes[x] + ": none");
            }
        }
    }

    public void equip(Equipment toEquip){
        if (isEquipped(toEquip.getId())){
            unequip(getEquipped(toEquip.getId()));
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
            if (next.getId()==id){
                return true;
            }
        }
        return false;
    }
    public Equipment getEquipped(int id){
        for (Equipment next:equipment){
            if (next.getId()==id){
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
            healthMaxBonus+= next.getHealthMaxBonus();
            staminaMaxBonus+= next.getStaminaMaxBonus();
            attackBonus+= next.getAttackBonus();
            defenseBonus+= next.getDefenseBonus();
            speedBonus+= next.getSpeedBonus();
            moveBonus+= next.getMoveBonus();

            healthMaxMultiplier+= next.getHealthMaxMultiplier();
            staminaMaxMultiplier+= next.getStaminaMaxMultiplier();
            attackMultiplier+= next.getAttackMultiplier();
            defenseMultiplier+= next.getDefenseMultiplier();
            speedMultiplier+= next.getSpeedMultiplier();
            moveMultiplier+= next.getMoveMultiplier();
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

    //TODO: Decide if all of these Getters/Setters are necessary
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getHealth() { return health; }
    public void setHealth(int health) { this.health = health; }

    public int getStamina() { return stamina; }
    public void setStamina(int stamina) { this.stamina = stamina; }

    public int getHealthMax() { return healthMax; }
    public void setHealthMax(int healthMax) { this.healthMax = healthMax; }

    public int getStaminaMax() { return staminaMax; }
    public void setStaminaMax(int staminaMax) { this.staminaMax = staminaMax; }

    public int getAttack() { return attack; }
    public void setAttack(int attack) { this.attack = attack; }

    public int getDefense() { return defense; }
    public void setDefense(int defense) { this.defense = defense; }

    public int getSpeed() { return speed; }
    public void setSpeed(int speed) { this.speed = speed; }

    public int getMove() { return move; }
    public void setMove(int move) { this.move = move; }

    public int getHealthMaxBase() { return healthMaxBase; }
    public void setHealthMaxBase(int healthMaxBase) { this.healthMaxBase = healthMaxBase; }

    public int getStaminaMaxBase() { return staminaMaxBase; }
    public void setStaminaMaxBase(int staminaMaxBase) { this.staminaMaxBase = staminaMaxBase; }

    public int getAttackBase() { return attackBase; }
    public void setAttackBase(int attackBase) { this.attackBase = attackBase; }

    public int getDefenseBase() { return defenseBase; }
    public void setDefenseBase(int defenseBase) { this.defenseBase = defenseBase; }

    public int getSpeedBase() { return speedBase; }
    public void setSpeedBase(int speedBase) { this.speedBase = speedBase; }

    public int getMoveBase() { return moveBase; }
    public void setMoveBase(int moveBase) { this.moveBase = moveBase; }

    public ArrayList<Equipment> getEquipment() { return equipment; }
    public void setEquipment(ArrayList<Equipment> equipment) { this.equipment = equipment; }

    public ArrayList<Item> getItem() { return item; }
    public void setItem(ArrayList<Item> item) { this.item = item; }
}