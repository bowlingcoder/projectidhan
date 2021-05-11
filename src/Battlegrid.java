import java.util.ArrayList;

public class Battlegrid {
    Tile[][] tiles=new Tile[20][20];
    ArrayList<Character>turnOrder=new ArrayList<>();
    ArrayList<Character>characters=new ArrayList<>();

    public void blankBattleGrid(){
        for (int x=0;x<tiles.length;x++){
            for (int y=0;y<tiles[x].length;y++){
                tiles[x][y]=new Tile();
            }
        }
    }
    public void addCharacter(Character toAdd,int x, int y){
        characters.add(toAdd);
        tiles[x][y].currentCharacter=toAdd;
    }
    public void moveCharacter(int initialX, int initialY, int toX, int toY){
        tiles[toX][toY].currentCharacter=tiles[initialX][initialY].currentCharacter;
        tiles[initialX][initialY].currentCharacter=null;
    }
    public String outputMapTest(){
        String toReturn="";
        for (int x=0;x<tiles.length;x++){
            for (int y=0;y<tiles[x].length;y++){
                if (!tiles[x][y].walkable){
                    toReturn+="x";
                }
                else if (tiles[x][y].currentCharacter!=null){
                    toReturn+=tiles[x][y].currentCharacter.getName().substring(0,1);
                }
                else {
                    toReturn+="o";
                }
            }
            toReturn+="\n";
        }
        return toReturn;
    }
}