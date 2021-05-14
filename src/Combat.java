import com.sun.xml.internal.bind.v2.TODO;

//Basic interpretation of Combat
public class Combat {
    public void attack(Character hunter, Character prey){
        int damage = hunter.getAttack() - prey.getDefense();
        if(damage > 0){
            System.out.printf("%s took damage.\n",prey.getName());
            prey.setHealth(prey.getHealth()-damage);
        }
        else {
            System.out.printf("%s did no damage.\n", hunter.getName());
        }
        //TODO: Handle what happens if a character's health goes under zero
    }

    public void defend(Character defender) {
        defender.setDefense(defender.getDefense()*2);
        System.out.printf("%s's defense has temporarily increase\n", defender.getName());
        //TODO: Decide if we want a defend, and pick it's effect
    }

}
