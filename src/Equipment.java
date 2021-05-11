public class Equipment {
    private String name;
    private int id; //0=mainhand, 1=offhand, 2=head, 3=body

    private int healthMaxBonus;
    private int staminaMaxBonus;
    private int attackBonus;
    private int defenseBonus;
    private int speedBonus;
    private int moveBonus;

    private double healthMaxMultiplier;
    private double staminaMaxMultiplier;
    private double attackMultiplier;
    private double defenseMultiplier;
    private double speedMultiplier;
    private double moveMultiplier;

    public Equipment(String name, int id){
        this.name = name;
        this.id=id;
    }

    //TODO: Decide if all of these Getters/Setters are necessary
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getHealthMaxBonus() { return healthMaxBonus; }
    public void setHealthMaxBonus(int healthMaxBonus) { this.healthMaxBonus = healthMaxBonus; }

    public int getStaminaMaxBonus() { return staminaMaxBonus; }
    public void setStaminaMaxBonus(int staminaMaxBonus) { this.staminaMaxBonus = staminaMaxBonus; }

    public int getAttackBonus() { return attackBonus; }
    public void setAttackBonus(int attackBonus) { this.attackBonus = attackBonus; }

    public int getDefenseBonus() { return defenseBonus; }
    public void setDefenseBonus(int defenseBonus) { this.defenseBonus = defenseBonus; }

    public int getSpeedBonus() { return speedBonus; }
    public void setSpeedBonus(int speedBonus) { this.speedBonus = speedBonus; }

    public int getMoveBonus() { return moveBonus; }
    public void setMoveBonus(int moveBonus) { this.moveBonus = moveBonus; }

    public double getHealthMaxMultiplier() { return healthMaxMultiplier; }
    public void setHealthMaxMultiplier(double healthMaxMultiplier) { this.healthMaxMultiplier = healthMaxMultiplier; }

    public double getStaminaMaxMultiplier() { return staminaMaxMultiplier; }
    public void setStaminaMaxMultiplier(double staminaMaxMultiplier) { this.staminaMaxMultiplier = staminaMaxMultiplier; }

    public double getAttackMultiplier() { return attackMultiplier; }
    public void setAttackMultiplier(double attackMultiplier) { this.attackMultiplier = attackMultiplier; }

    public double getDefenseMultiplier() { return defenseMultiplier; }
    public void setDefenseMultiplier(double defenseMultiplier) { this.defenseMultiplier = defenseMultiplier; }

    public double getSpeedMultiplier() { return speedMultiplier; }
    public void setSpeedMultiplier(double speedMultiplier) { this.speedMultiplier = speedMultiplier; }

    public double getMoveMultiplier() { return moveMultiplier; }
    public void setMoveMultiplier(double moveMultiplier) { this.moveMultiplier = moveMultiplier; }
}
