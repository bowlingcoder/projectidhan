import java.util.ArrayList;

public class Character {
    private String name;
    private int health;
    private int stamina;
    private int moveLeft;
    private boolean npc=true;
    private int team=0;
    private Tile tile;

    private int healthMax;
    private int staminaMax;
    private int attack;
    private int defense;
    private int speed;
    private int move;
    private int range=1;

    private int healthMaxBase;
    private int staminaMaxBase;
    private int attackBase;
    private int defenseBase;

    private int speedBase;
    private int moveBase;

    ArrayList<Equipment> equipment=new ArrayList<>();
    ArrayList<Buff> buffs=new ArrayList<>();
    ArrayList<Item> items =new ArrayList<>();

    public Character(){
        this.name="Generic";
        this.healthMaxBase=5;
        this.attackBase=2;
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

    public String displayCharacterBaseStats(){
        String toReturn="";
        toReturn+=("Character Base Stats\n");
        toReturn+=("Name: "+ name+"\n");
        toReturn+=("Max HP: "+healthMaxBase+"\n");
        toReturn+=("Base Attack: "+attackBase+"\n");
        toReturn+=("Base Defense: "+defenseBase+"\n");
        toReturn+=("Base Speed: "+speedBase+"\n");
        toReturn+=("Base Move: "+moveBase+"\n");
        return toReturn;
    }
    public String displayCharacterStats(){
        String toReturn="";
        calcStats();
        toReturn+=("Character Stats\n");
        toReturn+=("Name: "+ name+"\n");
        toReturn+=("Max HP: "+healthMax+"\n");
        toReturn+=("Attack: "+attack+"\n");
        toReturn+=("Defense: "+defense+"\n");
        toReturn+=("Speed: "+speed+"\n");
        toReturn+=("Move: "+move+"\n");
        return toReturn;
    }
    public String displayCharacter(){
        String toReturn="";
        toReturn+=("Character Info\n");
        toReturn+=("Name: "+ name+"\n");
        toReturn+=("Health: "+ health+"/"+healthMax+"\n");
        toReturn+=("Stamina: "+ stamina+"/"+staminaMax+"\n");
        for (int x=0;x<Setup.equipTypes.length;x++){
            if (isEquipped(x)){
                toReturn+=(Setup.equipTypes[x] +": "+ getEquipped(x).getName()+"\n");
            }
            else{
                toReturn+=(Setup.equipTypes[x] + ": none\n");
            }
        }
        return toReturn;
    }
    public String turnStart(){
        String toReturn="";
        moveLeft=move;
        for (int x=0;x<buffs.size();x++){
            buffs.get(x).setDuration(buffs.get(x).getDuration()-1);
            if (buffs.get(x).getDuration()<0){
                buffs.remove(x);
                x--;
            }
        }
        return toReturn;
    }
    public String planMove(Tile target){
        String toReturn="";
        if (getTargetsInRange().size()==0)
        {

        }
        return toReturn;
    }
    public ArrayList<Character> getTargetsInRange(){
        ArrayList<Character> targets= Setup.playerCombat.grid.getCharactersInRange(tile.x,tile.y,range);
        for (int x=0;x<targets.size();x++){
            if (targets.get(x).team==team){
                targets.remove(x);
                x--;
            }
        }
        return targets;
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
        for (Buff next:buffs){
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
    public String move(int tiles){
        String toReturn="";
        return toReturn;
    }
    public String attack(Character to){
        String toReturn="";
        int baseDamage=attack;
        int damage=to.getAttacked(baseDamage);
        toReturn+=name+" attacked "+to.name+"\n";
        toReturn+=to.name+" took "+damage+" damage.\n";
        return toReturn;
    }
    public int getAttacked(int baseDamage){
        int damage=baseDamage-defense;
        takeDamage(damage);
        return damage;
    }
    public String takeDamage(int damage){
        String toReturn="";
        toReturn+=loseHp(damage);
        return toReturn;
    }
    public String loseHp(int amount){
        String toReturn="";
        health-=amount;
        return toReturn;
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

    public ArrayList<Item> getItems() { return items; }
    public void setItems(ArrayList<Item> items) { this.items = items; }

    public boolean isNpc() {
        return npc;
    }

    public void setNpc(boolean npc) {
        this.npc = npc;
    }

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    public int getMoveLeft() {
        return moveLeft;
    }

    public void setMoveLeft(int moveLeft) {
        this.moveLeft = moveLeft;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }
}