public class Tile{

    private char type;
    private int rotation, treasure;
    private boolean[] connection = new boolean [4];
    //private String imageName;

    //Tile creation function
    //char typ assigns tile Type, must be 'i','l', or 't'
    //char rot assigns tile Rotation, must be 0, 90, 180, or 270
    //int trs assigns treasure ID, assign ID 0 for no treasure, 1-4 for player starting positions, 5-28 for card treasures
    public Tile(char typ,int rot, int trs){        
        type = typ;
        rotation = rot;
        treasure = trs;
        this.updateTile();
    }

    //update tile function
    //checks the Tile's type and rotation, then adjusts the Tile's connections to match
    public void updateTile(){
        boolean[] con = new boolean[4];
        switch(this.type){
            case 'i' :
                con[0] = true;
                con[1] = false;
                con[2] = true;
                con[3] = false;
                break;
            case 'l' :
                con[0] = true;
                con[1] = true;
                con[2] = false;
                con[3] = false;
                break;
            case 't' :
                con[0] = true;
                con[1] = true;
                con[2] = true;
                con[3] = false;
                break;
        }
        switch(this.rotation){
            case 0 :
                connection[0] = con[0];
                connection[1] = con[1];
                connection[2] = con[2];
                connection[3] = con[3];
                break;
            case 90 :
                connection[0] = con[3];
                connection[1] = con[0];
                connection[2] = con[1];
                connection[3] = con[2];
                break;
            case 180 :
                connection[0] = con[2];
                connection[1] = con[3];
                connection[2] = con[0];
                connection[3] = con[1];
                break;
            case 270 :
                connection[0] = con[1];
                connection[1] = con[2];
                connection[2] = con[3];
                connection[3] = con[0];
                break;
            
        }
    return;
    }

    //rotates tile clockwise
    //calls update tile function
    public void rotateRight(){
        rotation += 90;
        if(rotation > 270)
            rotation = 0;
        updateTile();
    }

    //rotates the tile counterclockwise
    //calls update tile function
    public void rotateLeft(){
        rotation -= 90;
        if(rotation < 0)
            rotation = 270;
        updateTile();
    }

    //return tile rotation
    public int getRotation(){
        return rotation;
    }

    //return tile type
    public char getType(){
        return type;
    }

    //return treasure ID
    public int getTreasure(){
        return treasure;
    }
}
