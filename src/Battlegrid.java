import java.util.ArrayList;

public class Battlegrid {
    Tile[][] tiles=new Tile[20][20];
    ArrayList<Character>characters=new ArrayList<>();
    public void blankBattleGrid(){
        for (int x=0;x<tiles.length;x++){
            for (int y=0;y<tiles[x].length;y++){
                tiles[x][y]=new Tile(x,y,true);
            }
        }
    }
    public void addCharacter(Character toAdd,int x, int y){
        characters.add(toAdd);
        tiles[x][y].currentCharacter=toAdd;
        toAdd.setTile(tiles[x][y]);
    }
    public void moveCharacter(int initialX, int initialY, int toX, int toY){
        tiles[toX][toY].currentCharacter=tiles[initialX][initialY].currentCharacter;
        tiles[initialX][initialY].currentCharacter=null;
        tiles[toX][toY].currentCharacter.setTile(tiles[toX][toY]);
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
    public ArrayList<Character> getCharactersInRange(int centerX, int centerY, int range){
        ArrayList<Character> toReturn=new ArrayList<>();
        for (int x=-range;x<=range;x++){
            for (int y=-range;y<=range;y++){
                if (centerX+x<0||centerX+x>tiles.length||centerY+y<0||centerY+y>tiles[0].length||Math.abs(x)+Math.abs(y)>range){
                    continue;
                }
                if (tiles[centerX+x][centerY+y].currentCharacter!=null){
                    toReturn.add(tiles[centerX+x][centerY+y].currentCharacter);
                }
            }
        }
        return toReturn;
    }
    public String[][] getMap(){
        String[][] toReturn=new String[tiles.length][tiles[0].length];
        for (int x=0;x<tiles.length;x++){
            for (int y=0;y<tiles[x].length;y++){
                if (!tiles[x][y].walkable){
                    toReturn[x][y]="x";
                }
                else if (tiles[x][y].currentCharacter!=null){
                    toReturn[x][y]=tiles[x][y].currentCharacter.getName().substring(0,1);
                }
                else {
                    toReturn[x][y]="";
                }
            }
        }
        return toReturn;
    }
    public int getDistance(int initialX, int initialY, int toX, int toY){
        return Math.max(Math.abs(initialX-toX),Math.abs(initialY-toY));
    }
    public ArrayList<Tile> getLine(int initialX, int initialY, int toX, int toY){
        ArrayList<Tile>toReturn=new ArrayList<>();
        int length=getDistance(initialX,initialY,toX,toY);
        return toReturn;
    }
    public Tile getNearbyEmptyTile(Tile tile, int range, int max){
        for (int x=-range;x<=range;x++){
            for (int y=-range;y<=range;y++){
                if (tile.x+x<0||tile.x+x>tiles.length||tile.y+y<0||tile.y+y>tiles[0].length){
                    continue;
                }
                Tile tempTile=tiles[tile.x+x][tile.y+y];
                if (tempTile.walkable&&tempTile.currentCharacter==null){
                    return tempTile;
                }
            }
        }
        if (range>=max){
            return null;
        }
        return getNearbyEmptyTile(tile,range+1,max);
    }
    public Battlegrid(){
        blankBattleGrid();
    }
}