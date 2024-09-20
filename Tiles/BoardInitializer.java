public class BoardInitializer {
    public static TileGrid MakeBoard(){
        TileGrid board = new TileGrid();
        board.CreateTile(0, 'l', 'r', 1);//treasure 1 is the player 1 starting square
        board.CreateTile(6, 'l', 'd', 2);//treasure 2 is the player 2 starting square
        board.CreateTile(42, 'l', 'u', 3);//treasure 3 is the player 3 starting square
        board.CreateTile(48, 'l', 'l', 4);//treasure 4 is the player 4 starting square
        board.CreateTile(0, 'i', 'u', 0);//treasure X is the 
        return board;
    }
}
