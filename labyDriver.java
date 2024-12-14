/* 
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
*/

public class labyDriver {
public static TileGrid board = new TileGrid();

public static Cards deck = new Cards();

public static Player red = new Player(1,deck);

public static Player blue = new Player(2,deck);

public static Player yellow = new Player(3,deck);

public static Player green = new Player(4,deck);

    public static void main(String[] args) {

            GraphicsLab graphics = new GraphicsLab();
            for (int i = 0; i < 50; i++) {
                Tile hold = board.getTile(i);
                graphics.TileGraphics(i + 1, hold.getImage());
            }
            GraphicsLab.frame.repaint();
    }
}
