import java.util.Random;

public class TileGrid {
    private static int SIZE = 7;
    private Tile [] tileMap = new Tile[SIZE*SIZE+1];

    //TileGrid Constructor
    //Automatically creates a board and randomizes all dynamic tiles
    //Tiles 0-48 fill out the board
    //Tile 49 is the spare tile, inserted into the board when sliding tiles
    public TileGrid(){
        Random rand = new Random();
        Tile [] tileDeck = new Tile[34];

        //Create and Assign Static Tiles
        tileMap[0] = new Tile('l', 90, 1);//treasure 1 is the player 1 starting square (Red)
        tileMap[6] = new Tile ('l', 180, 2);//treasure 2 is the player 2 starting square (Blue)
        tileMap[42] = new Tile ('l', 180, 3);//treasure 3 is the player 3 starting square (Yellow)
        tileMap[48] = new Tile ('l', 270, 4);//treasure 4 is the player 4 starting square (Green)
        tileMap[2] = new Tile ('t', 90, 5);//treasure 5 is the Skull
        tileMap[4] = new Tile ('t', 90, 6);//treasure 6 is the Sword
        tileMap[14] = new Tile ('t', 0, 7);//treasure 7 is the Bag of Coins
        tileMap[16] = new Tile ('t', 0, 8);//treasure 8 is the Key Ring
        tileMap[18] = new Tile ('t', 90, 9);//treasure 9 is the Emerald
        tileMap[20] = new Tile ('t', 180, 10);//treasure 10 is the Helmet
        tileMap[28] = new Tile ('t', 0, 11);//treasure 11 is the Book
        tileMap[30] = new Tile ('t', 270, 12);//treasure 12 is the Crown
        tileMap[32] = new Tile ('t', 180, 13);//treasure 13 is the Chest
        tileMap[34] = new Tile ('t', 180, 14);//treasure 14 is the Candelabra
        tileMap[44] = new Tile ('t', 270, 15);//treasure 15 is the Map
        tileMap[46] = new Tile ('t', 270, 16);//treasure 16 is the Ring

        //Create Dynamic Tiles
        //12 Treasure tiles, 6 L and 6 T
        tileDeck[0] = new Tile('l', TileGrid.randRot(), 17);//treasure 17 is the Spider
        tileDeck[1] = new Tile('l', TileGrid.randRot(), 18);//treasure 18 is the Rat
        tileDeck[2] = new Tile('l', TileGrid.randRot(), 19);//treasure 19 is the Moth
        tileDeck[3] = new Tile('l', TileGrid.randRot(), 20);//treasure 20 is the Scarab
        tileDeck[4] = new Tile('l', TileGrid.randRot(), 21);//treasure 21 is the Salamander
        tileDeck[5] = new Tile('l', TileGrid.randRot(), 22);//treasure 22 is the Owl
        tileDeck[6] = new Tile('t', TileGrid.randRot(), 23);//treasure 23 is the Bat
        tileDeck[7] = new Tile('t', TileGrid.randRot(), 24);//treasure 24 is the Troll
        tileDeck[8] = new Tile('t', TileGrid.randRot(), 25);//treasure 25 is the Ghost
        tileDeck[9] = new Tile('t', TileGrid.randRot(), 26);//treasure 26 is the Djin
        tileDeck[10] = new Tile('t', TileGrid.randRot(), 27);//treasure 27 is the Enchantress
        tileDeck[11] = new Tile('t', TileGrid.randRot(), 28);//treasure 28 is the Dragon
        //10 basic L tiles
        tileDeck[12] = new Tile('l', TileGrid.randRot(), 0);//non-treasure tile
        tileDeck[13] = new Tile('l', TileGrid.randRot(), 0);//non-treasure tile
        tileDeck[14] = new Tile('l', TileGrid.randRot(), 0);//non-treasure tile
        tileDeck[15] = new Tile('l', TileGrid.randRot(), 0);//non-treasure tile
        tileDeck[16] = new Tile('l', TileGrid.randRot(), 0);//non-treasure tile
        tileDeck[17] = new Tile('l', TileGrid.randRot(), 0);//non-treasure tile
        tileDeck[18] = new Tile('l', TileGrid.randRot(), 0);//non-treasure tile
        tileDeck[19] = new Tile('l', TileGrid.randRot(), 0);//non-treasure tile
        tileDeck[20] = new Tile('l', TileGrid.randRot(), 0);//non-treasure tile
        tileDeck[21] = new Tile('l', TileGrid.randRot(), 0);//non-treasure tile
        //12 basic I tiles
        tileDeck[22] = new Tile('i', TileGrid.randRot(), 0);//non-treasure tile
        tileDeck[23] = new Tile('i', TileGrid.randRot(), 0);//non-treasure tile
        tileDeck[24] = new Tile('i', TileGrid.randRot(), 0);//non-treasure tile
        tileDeck[25] = new Tile('i', TileGrid.randRot(), 0);//non-treasure tile
        tileDeck[26] = new Tile('i', TileGrid.randRot(), 0);//non-treasure tile
        tileDeck[27] = new Tile('i', TileGrid.randRot(), 0);//non-treasure tile
        tileDeck[28] = new Tile('i', TileGrid.randRot(), 0);//non-treasure tile
        tileDeck[29] = new Tile('i', TileGrid.randRot(), 0);//non-treasure tile
        tileDeck[30] = new Tile('i', TileGrid.randRot(), 0);//non-treasure tile
        tileDeck[31] = new Tile('i', TileGrid.randRot(), 0);//non-treasure tile
        tileDeck[32] = new Tile('i', TileGrid.randRot(), 0);//non-treasure tile
        tileDeck[33] = new Tile('i', TileGrid.randRot(), 0);//non-treasure tile

        //Randomize Dynamic Tiles
        Tile hold;
        for(int i=0;i<34;i++){
            int r = rand.nextInt(33);
            hold = tileDeck[i];
            tileDeck[i] = tileDeck[r];
            tileDeck[r] = hold;
        }

        //Assign dynamic Tiles to all sliding Tile positions
        tileMap[1] = tileDeck[0];
        tileMap[3] = tileDeck[1];
        tileMap[5] = tileDeck[2];
        tileMap[7] = tileDeck[3];
        tileMap[8] = tileDeck[4];
        tileMap[9] = tileDeck[5];
        tileMap[10] = tileDeck[6];
        tileMap[11] = tileDeck[7];
        tileMap[12] = tileDeck[8];
        tileMap[13] = tileDeck[9];
        tileMap[15] = tileDeck[10];
        tileMap[17] = tileDeck[11];
        tileMap[19] = tileDeck[12];
        tileMap[21] = tileDeck[13];
        tileMap[22] = tileDeck[14];
        tileMap[23] = tileDeck[15];
        tileMap[24] = tileDeck[16];
        tileMap[25] = tileDeck[17];
        tileMap[26] = tileDeck[18];
        tileMap[27] = tileDeck[19];
        tileMap[29] = tileDeck[20];
        tileMap[31] = tileDeck[21];
        tileMap[33] = tileDeck[22];
        tileMap[35] = tileDeck[23];
        tileMap[36] = tileDeck[24];
        tileMap[37] = tileDeck[25];
        tileMap[38] = tileDeck[26];
        tileMap[39] = tileDeck[27];
        tileMap[40] = tileDeck[28];
        tileMap[41] = tileDeck[29];
        tileMap[43] = tileDeck[30];
        tileMap[45] = tileDeck[31];
        tileMap[47] = tileDeck[32];
        tileMap[49] = tileDeck[33];
    }
        
    //Randomizee Rotation function
    //Used in board initialization
    private static int randRot(){
        Random rand = new Random();

        int rotation;
        int r = rand.nextInt(4);
        switch(r%4){
            case 0:
                rotation = 0;
                break;
            
            case 1:
                rotation = 90;
                break;

            case 2:
                rotation = 180;
                break;

            case 3:
                rotation = 270;
                break;

            default:
                rotation = 0;
        }
        return rotation;
    }

    //CreateTile function (obsolete)
    //Used to create a new tile on the board at position X,Y
    public void CreateTile(int x, int y, char typ, char rot, int trs){
        tileMap[y*SIZE+x] = new Tile(typ,rot,trs);
        return;
    }

    //CreateTile function (obsolete)
    //Used to create a new tile on the board at index position pos
    public void CreateTile(int pos, char typ, char rot, int trs){
        tileMap[pos] = new Tile(typ,rot,trs);
        return;
    }

    //InsertTile function (obsolete)
    //Used to insert an existing tile into the board at index position pos
    public void InsertTile(int pos, Tile t){
        tileMap[pos] = t;
        return;
    }

    //InsertTile function (obsolete)
    //Used to insert an existing tile into the board at position X,Y
    public void InsertTile(int x, int y, Tile t){
        tileMap[y*SIZE+x] = t;
        return;
    }

    //Slide Left function
    //Inserts the spare tile at the right side of the board
    //Slides all tiles in the row left
    public void SlideTileLeft(int row){
        Tile hold;
        hold = tileMap[49];
        tileMap[49] = tileMap[row*SIZE];
        for(int i=0;i<SIZE-1;i++){
            tileMap [row*SIZE+i] = tileMap [row*SIZE+i+1];
        }
        tileMap [row*SIZE+SIZE-1] = hold;
        return;
    }

    //Slide Right function
    //Inserts the spare tile at the left side of the board
    //Slides all tiles in the row right
    public void SlideTileRight(int row){
        Tile hold;
        hold = tileMap[49];
        tileMap[49] = tileMap[row*SIZE+SIZE-1];
        for(int i=SIZE-1;i>0;i--){
            tileMap [row*SIZE+i] = tileMap [row*SIZE+i-1];
        }
        tileMap [row*SIZE] = hold;
        return;
    }

    //Slide Up function
    //Inserts the spare tile at the bottom of the board
    //Slides all tiles in the collumn up
    public void SlideTileUp(int col){
        Tile hold;
        hold = tileMap[49];
        tileMap[49] = tileMap[col];
        for(int i=0;i<SIZE-1;i++){
            tileMap [col+SIZE*i] = tileMap [col+SIZE*(i+1)];
        }
        tileMap [col+SIZE*(SIZE-1)] = hold;
        return;
    }

    //Slide Down function
    //Inserts the spare tile at the top of the board
    //Slides all tiles in the collumn down
    public void SlideTileDown( int col){
        Tile hold = tileMap[49];
        tileMap[49] = tileMap[col+SIZE*(SIZE-1)];
        for(int i=SIZE-1;i>0;i--){
            tileMap [col+SIZE*i] = tileMap [col+SIZE*(i-1)];
        }
        tileMap [col] = hold;
        return;
    }

    //Print function
    //Prints the treasure indexes of all tiles in the board
    //Used for initial testing
    public void printTiles(){
        for(int y=0;y<SIZE;y++){
            for(int x=0;x<SIZE;x++){
                System.out.print(tileMap[x+SIZE*y].getTreasure() + ", ");
            }
            System.out.println();
        }
    }

    //Rotation functions
    //Rotates the spare tile
    public void rotR(){
        tileMap[49].rotateRight();
        return;
    }
    public void rotL(){
        tileMap[49].rotateLeft();
        return;
    }

    //Get functions
    //Return rotation/treasure of tile A
    //Direct index and XY index accessible
    public int getRotation(int pos){
        return tileMap[pos].getRotation();
    }

    public int getRotation(int x,int y){
        return tileMap[x+SIZE*y].getRotation();
    }

    public int getTreasure(int pos){
        return tileMap[pos].getTreasure();
    }

    public int getTreasure(int x,int y){
        return tileMap[x+SIZE*y].getTreasure();
    }

    public char getType(int pos){
        return tileMap[pos].getType();
    }

    public char getType(int x,int y){
        return tileMap[x+SIZE*y].getType();
    }

    public Tile getTile(int x, int y){
        return tileMap[x+SIZE*y];
    }

    public Tile getTile(int pos){
        return tileMap[pos];
    }
}
