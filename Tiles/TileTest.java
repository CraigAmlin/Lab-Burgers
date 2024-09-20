public class TileTest {
    public static void main(String [] args){
        TileGrid board = new TileGrid();

        board.printTiles();
        board.SlideTileUp(0);
        board.SlideTileLeft(6);
        board.SlideTileDown(6);
        board.SlideTileRight(0);
        board.printTiles();
    }
}
