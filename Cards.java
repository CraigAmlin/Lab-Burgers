import java.util.Random;

public class Cards {
    private int [] cardDeck = new int [24];
    Random rand = new Random();

    /*Idealized use case:
    *on startup*
    Cards deck = new Cards();
    Player red = new Player(1,deck);
    Player blue = new Player(2,deck);
    Player yellow = new Player(3,deck);
    Player green = new Player(4,deck);


    *on board slide*
    board.SlideTileDown(1);     //slides tiles in specified collumn down one, inserting spare tile at top of board and moving tile at bottom of board to spare tile position
    red.SlideDown(1);           //checks if player should slide, slides player if so, wraps player around if player falls off board
    blue.SlideDown(1);
    yellow.SlideDown(1);
    green.SlideDown(1);


    *on turn end*
    int pX, pY;
    pX = (mouseX - boardOffsetX) / tileWidth;
    if(pX>6) pX=6;
    if(pX<0) pX=0;
    pY = (mouseY - boardOffsetY) / tileWidth;
    if(pY>6) pY=6;
    if(pY<0) pY=0;
    player.setXY(pX, pY);
    int winner;
    winner = player.checkTreasure(board.getTreasure(pX, pY));          //alternative syntax: winner = player.checkTreasure(board);
    if(winner == 0)
        //win game
    else
        //print "Next target treasure is " (decode winner)
    */

    //Cards initializer
    public Cards(){
        for(int i = 0; i<24;i++){
            cardDeck[i] = i+5;
        }

        for(int i=0;i<24;i++){
            int t = rand.nextInt(24);
            int hold = cardDeck[i]; 
            cardDeck[i] = cardDeck[t];
            cardDeck[t] = hold;
        }
    }

    //Function to return a player's next target treasure
    public int getTarget(int pl, int i){
        int index;
        switch(pl){
            case 1:
                    index = 0 + i;
                break;
            case 2:
                    index = 6 + i;
                break;
            case 3:
                    index = 12 + i;
                break;
            case 4:
                    index = 18 + i;
                break;
            default: index = 0;
        }
        return cardDeck[index];
    }
}
