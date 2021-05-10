public class Equipment {
    String name;
    int id; //0=mainhand, 1=offhand, 2=head, 3=body

    int healthMaxBonus;
    int staminaMaxBonus;
    int attackBonus;
    int defenseBonus;
    int speedBonus;
    int moveBonus;

    double healthMaxMultiplier;
    double staminaMaxMultiplier;
    double attackMultiplier;
    double defenseMultiplier;
    double speedMultiplier;
    double moveMultiplier;

    public Equipment(String name, int id){
        this.name = name;
        this.id=id;
    }
}
