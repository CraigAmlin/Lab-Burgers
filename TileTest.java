

public class TileTest {
    public static void main(String[] args){
        TileGrid board = new TileGrid();
        board.newTile('I',0,'u',0);
        board.newTile('L',0,'d',1);
        board.newTile('L',6,'l',2);
        board.newTile('T',4,'r',3);
        board.newTile('I',0,'u',4);
        board.newTile('T',7,'r',5);
        board.printAll();
    }
}
