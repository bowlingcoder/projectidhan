public class Tile {
    Character currentCharacter;

    boolean walkable=true;
    int x;
    int y;
    public Tile (int x,int y, boolean walkable){
        this.x=x;
        this.y=y;
        this.walkable=walkable;
    }
}