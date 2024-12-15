import java.util.Random;

public class TileGrid {
    private static int SIZE = 7;
    public Tile [] tileMap = new Tile[SIZE*SIZE+1];

    //TileGrid Constructor
    //Automatically creates a board and randomizes all dynamic tiles
    //Tiles 0-48 fill out the board
    //Tile 49 is the spare tile, inserted into the board when sliding tiles
    public TileGrid(){
        Random rand = new Random();
        Tile [] tileDeck = new Tile[34];

        //Create and Assign Static Tiles
        tileMap[0] = new Tile('l', 90, 1, "Tile_L_Red_");//treasure 1 is the player 1 starting square (Red)
        tileMap[6] = new Tile ('l', 180, 2, "Tile_L_Blue_");//treasure 2 is the player 2 starting square (Blue)
        tileMap[42] = new Tile ('l', 0, 3, "Tile_L_Yellow_");//treasure 3 is the player 3 starting square (Yellow)
        tileMap[48] = new Tile ('l', 270, 4, "Tile_L_Green_");//treasure 4 is the player 4 starting square (Green)
        tileMap[2] = new Tile ('t', 90, 5, "Tile_T_Skull_");//treasure 5 is the Skull
        tileMap[4] = new Tile ('t', 90, 6, "Tile_T_Sword_");//treasure 6 is the Sword
        tileMap[14] = new Tile ('t', 0, 7, "Tile_T_Coins_");//treasure 7 is the Bag of Coins
        tileMap[16] = new Tile ('t', 0, 8, "Tile_T_Keys_");//treasure 8 is the Key Ring
        tileMap[18] = new Tile ('t', 90, 9, "Tile_T_Emerald_");//treasure 9 is the Emerald
        tileMap[20] = new Tile ('t', 180, 10, "Tile_T_Knight_");//treasure 10 is the Helmet
        tileMap[28] = new Tile ('t', 0, 11, "Tile_T_Book_");//treasure 11 is the Book
        tileMap[30] = new Tile ('t', 270, 12, "Tile_T_Crown_");//treasure 12 is the Crown
        tileMap[32] = new Tile ('t', 180, 13, "Tile_T_Chest_");//treasure 13 is the Chest
        tileMap[34] = new Tile ('t', 180, 14, "Tile_T_Candleabra_");//treasure 14 is the Candelabra
        tileMap[44] = new Tile ('t', 270, 15, "Tile_T_Map_");//treasure 15 is the Map
        tileMap[46] = new Tile ('t', 270, 16, "Tile_T_Ring_");//treasure 16 is the Ring

        //Create Dynamic Tiles
        //12 Treasure tiles, 6 L and 6 T
        tileDeck[0] = new Tile('l', TileGrid.randRot(), 17, "Tile_L_Spider_");//treasure 17 is the Spider
        tileDeck[1] = new Tile('l', TileGrid.randRot(), 18, "Tile_L_Mouse_");//treasure 18 is the Rat
        tileDeck[2] = new Tile('l', TileGrid.randRot(), 19, "Tile_L_Moth_");//treasure 19 is the Moth
        tileDeck[3] = new Tile('l', TileGrid.randRot(), 20, "Tile_L_Beetle_");//treasure 20 is the Scarab
        tileDeck[4] = new Tile('l', TileGrid.randRot(), 21, "Tile_L_Lizard_");//treasure 21 is the Salamander
        tileDeck[5] = new Tile('l', TileGrid.randRot(), 22, "Tile_L_Owl_");//treasure 22 is the Owl
        tileDeck[6] = new Tile('t', TileGrid.randRot(), 23, "Tile_T_Bat_");//treasure 23 is the Bat
        tileDeck[7] = new Tile('t', TileGrid.randRot(), 24, "Tile_T_Troll_");//treasure 24 is the Troll
        tileDeck[8] = new Tile('t', TileGrid.randRot(), 25, "Tile_T_Ghost_");//treasure 25 is the Ghost
        tileDeck[9] = new Tile('t', TileGrid.randRot(), 26, "Tile_T_Genie_");//treasure 26 is the Djin
        tileDeck[10] = new Tile('t', TileGrid.randRot(), 27, "Tile_T_Lady_");//treasure 27 is the Enchantress
        tileDeck[11] = new Tile('t', TileGrid.randRot(), 28, "Tile_T_Dragon_");//treasure 28 is the Dragon
        //10 basic L tiles
        tileDeck[12] = new Tile('l', TileGrid.randRot(), 0, "Tile_L_");//non-treasure tile
        tileDeck[13] = new Tile('l', TileGrid.randRot(), 0, "Tile_L_");//non-treasure tile
        tileDeck[14] = new Tile('l', TileGrid.randRot(), 0, "Tile_L_");//non-treasure tile
        tileDeck[15] = new Tile('l', TileGrid.randRot(), 0, "Tile_L_");//non-treasure tile
        tileDeck[16] = new Tile('l', TileGrid.randRot(), 0, "Tile_L_");//non-treasure tile
        tileDeck[17] = new Tile('l', TileGrid.randRot(), 0, "Tile_L_");//non-treasure tile
        tileDeck[18] = new Tile('l', TileGrid.randRot(), 0, "Tile_L_");//non-treasure tile
        tileDeck[19] = new Tile('l', TileGrid.randRot(), 0, "Tile_L_");//non-treasure tile
        tileDeck[20] = new Tile('l', TileGrid.randRot(), 0, "Tile_L_");//non-treasure tile
        tileDeck[21] = new Tile('l', TileGrid.randRot(), 0, "Tile_L_");//non-treasure tile
        //12 basic I tiles
        tileDeck[22] = new Tile('i', TileGrid.randRot(), 0, "Tile_I_");//non-treasure tile
        tileDeck[23] = new Tile('i', TileGrid.randRot(), 0, "Tile_I_");//non-treasure tile
        tileDeck[24] = new Tile('i', TileGrid.randRot(), 0, "Tile_I_");//non-treasure tile
        tileDeck[25] = new Tile('i', TileGrid.randRot(), 0, "Tile_I_");//non-treasure tile
        tileDeck[26] = new Tile('i', TileGrid.randRot(), 0, "Tile_I_");//non-treasure tile
        tileDeck[27] = new Tile('i', TileGrid.randRot(), 0, "Tile_I_");//non-treasure tile
        tileDeck[28] = new Tile('i', TileGrid.randRot(), 0, "Tile_I_");//non-treasure tile
        tileDeck[29] = new Tile('i', TileGrid.randRot(), 0, "Tile_I_");//non-treasure tile
        tileDeck[30] = new Tile('i', TileGrid.randRot(), 0, "Tile_I_");//non-treasure tile
        tileDeck[31] = new Tile('i', TileGrid.randRot(), 0, "Tile_I_");//non-treasure tile
        tileDeck[32] = new Tile('i', TileGrid.randRot(), 0, "Tile_I_");//non-treasure tile
        tileDeck[33] = new Tile('i', TileGrid.randRot(), 0, "Tile_I_");//non-treasure tile

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
    public static int randRot(){
        Random rand = new Random();
        int rotation;
        int r = rand.nextInt(4);
        rotation = 90 * r;
        return rotation;
    }

    //Adjacency check function
    public boolean adjacent(int start, int end){
        int space = 0;
        int [] accepted = new int[49];
        accepted[space] = start;
        space++;
        int target = 0;
        for(int i : accepted){
            if(upCon(i)){
                target = i-7;
                if(!checkTarget(target, accepted)){
                    accepted[space] = target;
                    space++;
                }
            }
            if(rightCon(i)){
                target = i+1;
                if(!checkTarget(target, accepted)){
                    accepted[space] = target;
                    space++;
                }
            }
            if(downCon(i)){
                target = i+7;
                if(!checkTarget(target, accepted)){
                    accepted[space] = target;
                    space++;
                }
            }
            if(leftCon(i)){
                target = i-1;
                if(!checkTarget(target, accepted)){
                    accepted[space] = target;
                    space++;
                }
            }
        }
        return checkTarget(end, accepted);
    }

    private boolean checkTarget(int target, int[] accepted){
        for(int i : accepted) {
            if(i == target) return true;
        }
        return false;
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

    //Top Edge Check function
    //Queries if a given tile is located at the top edge of the board 
    public boolean topEdge(int pos){
        return (pos <= 6);
    }

    //Top Edge Check function
    //Queries if a given tile is located at the top edge of the board 
    public boolean t_Edge(int pos){
        return (pos <= 6);
    }

    //Bottom Edge Check function
    //Queries if a given tile is located at the bottom edge of the board 
    public boolean b_Edge(int pos){
        return (pos >= 42 && pos != 49);
    }

    //Left Edge Check function
    //Queries if a given tile is located at the left edge of the board 
    public boolean l_Edge(int pos){
        return ((pos % 7)== 0);
    }

    //Right Edge Check function
    //Queries if a given tile is located at the right edge of the board 
    public boolean r_Edge(int pos){
        return ((pos % 7)== 6);
    }

    public boolean upCon(int pos){
        return (!t_Edge(pos) && tileMap[pos].connection[0] && tileMap[pos-7].connection[2]);
    }

    public boolean rightCon(int pos){
        return (!r_Edge(pos) && tileMap[pos].connection[1] && tileMap[pos+1].connection[3]);
    }

    public boolean downCon(int pos){
        return (!b_Edge(pos) && tileMap[pos].connection[2] && tileMap[pos+7].connection[0]);
    }

    public boolean leftCon(int pos){
        return (!l_Edge(pos) && tileMap[pos].connection[3] && tileMap[pos-1].connection[1]);
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
    //Return rotation/treasure/type/image/tile of tile A
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

    public String getImage(int pos){
        return tileMap[pos].getImage();
    }
    public String getImage(int x,int y){
        return tileMap[x+SIZE*y].getImage();
    }

    public Tile getTile(int x, int y){
        return tileMap[x+SIZE*y];
    }

    public Tile getTile(int pos){
        return tileMap[pos];
    }
}
