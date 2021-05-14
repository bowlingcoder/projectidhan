import java.util.ArrayList;

//Basic interpretation of Combat
public class Combat {
    int selectedActionType=0;
    ArrayList<Character> turnOrder=new ArrayList<>();
    Battlegrid grid=new Battlegrid();
    public void attack(Character hunter, Character prey){
        System.out.printf(hunter.attack(prey));
        /*int damage = hunter.getAttack() - prey.getDefense();
        if(damage > 0){
            System.out.printf("%s took damage.\n",prey.getName());
            prey.setHealth(prey.getHealth()-damage);
        }
        else {
            System.out.printf("%s did no damage.\n", hunter.getName());
        }*/
        //TODO: Handle what happens if a character's health goes under zero
    }
    public String takeTurn(){
        String toReturn="";
        Character temp=turnOrder.get(0);
        toReturn+=temp.turnStart();
        turnOrder.remove(temp);
        turnOrder.add(temp);
        if (temp.isNpc()){
        }
        if (turnOrder.get(0).isNpc()){
            toReturn+=takeTurn();
        }
        return toReturn;
    }
    public void defend(Character defender) {
        defender.setDefense(defender.getDefense()*2);
        System.out.printf("%s's defense has temporarily increase\n", defender.getName());
        //TODO: Decide if we want a defend, and pick it's effect
    }
    public Combat(){

    }

}
