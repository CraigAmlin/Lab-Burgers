import java.util.Random;

public class cpu2 {
    Random rand = new Random();

    public int tile (int lasPos) {
        int x = rand.nextInt(12);
        while(x == lasPos){
            x = rand.nextInt(12);
        }
        return x;
    }

    public int move (int pos, TileGrid board, int treasure) {
        int space = 0;
        int [] accepted = new int[49];
        accepted[space] = pos;
        space++;
        int target = 0;
        for(int i : accepted){
            if(board.upCon(i)){
                target = i-7;
                if(board.getTreasure(target) == treasure) return target;
                if(!checkTarget(target, accepted)){
                    accepted[space] = target;
                    space++;
                }
            }
            if(board.rightCon(i)){
                target = i+1;
                if(board.getTreasure(target) == treasure) return target;
                if(!checkTarget(target, accepted)){
                    accepted[space] = target;
                    space++;
                }
            }
            if(board.downCon(i)){
                target = i+7;
                if(board.getTreasure(target) == treasure) return target;
                if(!checkTarget(target, accepted)){
                    accepted[space] = target;
                    space++;
                }
            }
            if(board.leftCon(i)){
                target = i-1;
                if(board.getTreasure(target) == treasure) return target;
                if(!checkTarget(target, accepted)){
                    accepted[space] = target;
                    space++;
                }
            }
        }
        return accepted[rand.nextInt(space)];
    }

    private boolean checkTarget(int target, int[] accepted){
        for(int i : accepted) {
            if(i == target) return true;
        }
        return false;
    }
}
