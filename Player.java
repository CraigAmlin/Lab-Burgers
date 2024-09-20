

public class Player {
    private int ID, X, Y;
    private int index = 0;
    private int [] Treasure = new int[7];

    public Player(int playerNo, Cards deck){
        ID = playerNo;
        switch(ID){
            case 1: X=0; Y=0; break;
            case 2: X=6; Y=0; break;
            case 3: X=0; Y=6; break;
            case 4: X=6; Y=6; break;
            default: X=3; Y=3; break;
        }
        for(int i=0;i<6;i++){
            Treasure[i] = deck.getTarget(ID, i);
        }
        Treasure[6] = ID;
    }

    //check treasure function
    //checks if current tile holds next target treasure
    //returns ID of next target treasure
    //if no next target treasure exists (all are collected) returns 0
    public int checkTreasure(int tile){
        if(tile == Treasure[index]){
            if(Treasure[index] == ID){
                return 0;
            }
            index++;
        }
        return Treasure[index];
    }

    public int checkTreasure(TileGrid board){
        int tile = board.getTreasure(X, Y);
        if(tile == Treasure[index]){
            if(Treasure[index] == ID){
                return 0;
            }
            index++;
        }
        return Treasure[index];
    }

    //player slide functions
    //recieves row or column being slid
    //checks if player will be slid and slides them 1 tile in appropriate direction
    //checks if player has left board bounds, and wraps around to other side of board if so
    //returns true if player was moved, returns false if player was not moved
    public boolean slideLeft(int row){
        if(Y!=row)
           return false; 
        X--;
        if(X<0)
            X=6;
        return true;
    }

    public boolean slideRight(int row){
        if(Y!=row)
            return false;
        X++;
        if(X>6)
            X=0;
        return true;
    }

    public boolean slideUp(int col){
        if(X!=col)
           return false;
        Y--;
        if(Y<0)
            Y=6;
        return true;
    }

    public boolean slideDown(int col){
        if(X!=col)
            return false;
        Y++;
        if(Y>6)
            Y=0;
        return true;
    }

    //get and set functions
    //set X and Y values individually, together, or by board position
    //check X and Y values individually or by board position
    public int getX(){
        return X;
    }

    public int getY(){
        return Y;
    }

    public int getpos(){
        int pos = (7*Y)+X;
        return pos;
    }

    public void setX(int newX){
        X = newX;
        return;
    }

    public void setY(int newY){
        Y = newY;
        return;
    }

    public void setXY(int newX, int newY){
        X = newX;
        Y = newY;
        return;
    }

    public void setPos(int pos){
        X = pos%7;
        Y = pos/7;
        return;
    }
}
