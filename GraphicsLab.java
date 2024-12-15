import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/* 
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.awt.image.AffineTransformOp;
import java.awt.image.ImageObserver;
*/

/*
DO:

DONE:
Add turn system inside interaction loop
Implemented no return tile rule
Altered multiple functions to use Switch statments instead of nested if/else's
Added ImageName component to Tile class, reducing costly AssignTiles calls
Altered Arrows to call shared functions, reducing duplicate code
Altered player object names to be more consistent, Player 1 is always red, 2 is blue, 3 is green and 4 is yellow
Get basic random AI working
Get AI to recognize board navigation and move to targeted squares
Added board check to player move, requiring tiles to be connected
Add toggle to set a player to computer controlled
Add autoplay button to let computer players take turns instantly
*/

public class GraphicsLab extends labyDriver {
    //Main frame the player can see and holds everything
    public static JFrame frame;

    //Panels that hold and rotate images for grid board
    //The tiles
    private static JPanel Tile1, Tile2, Tile3, Tile4, Tile5, Tile6, Tile7, Tile8, Tile9, Tile10;
    private static JPanel Tile11, Tile12, Tile13, Tile14, Tile15, Tile16, Tile17, Tile18, Tile19, Tile20;
    private static JPanel Tile21, Tile22, Tile23, Tile24, Tile25, Tile26, Tile27, Tile28, Tile29, Tile30;
    private static JPanel Tile31, Tile32, Tile33, Tile34, Tile35, Tile36, Tile37, Tile38, Tile39, Tile40;
    private static JPanel Tile41, Tile42, Tile43, Tile44, Tile45, Tile46, Tile47, Tile48, Tile49;

    //Tile that player will rotate and insert
    private static JPanel TileMain;

    //Images that go into the panels
    private BufferedImage Img1, Img2, Img3, Img4, Img5, Img6, Img7, Img8, Img9, Img10;
    private BufferedImage Img11, Img12, Img13, Img14, Img15, Img16, Img17, Img18, Img19, Img20;
    private BufferedImage Img21, Img22, Img23, Img24, Img25, Img26, Img27, Img28, Img29, Img30;
    private BufferedImage Img31, Img32, Img33, Img34, Img35, Img36, Img37, Img38, Img39, Img40;
    private BufferedImage Img41, Img42, Img43, Img44, Img45, Img46, Img47, Img48, Img49;

    //Image that goes into the main tile
    private static BufferedImage Img50;

    //Panels that will hold col/ row indicators
    //Which will tell the player which row and col the player can change

    public static JButton Arrow1Button, Arrow2Button, Arrow3Button;
    public static JButton Arrow4Button, Arrow5Button, Arrow6Button;
    public static JButton Arrow7Button, Arrow8Button, Arrow9Button;
    public static JButton Arrow10Button, Arrow11Button, Arrow12Button;

    //Player
    public static JPanel playerB, PlayerY, PlayerG, PlayerR;

    public static BufferedImage BlueWiz, YellowWiz, GreenWiz, RedWiz;

    //Player layer
    public static JFrame Player1, Player2, Player3, Player4;

    public static JPanel T1, T2, T3, T4;

    public static BufferedImage TP1, TP2, TP3, TP4;
    private static boolean check = false, check2 = false;

    //Variables used to adjust what tile's height and length will be
    private int X=75,Y=75;

    //Variable to track current turn
    //1, 2, 3, 4 indicate player X's turn to move tiles
    //5, 6, 7, 8 indicate player (X-4)'s turn to move character
    //Turn order is Red (1,5), Blue (2,6), Green (3,7), Yellow (4,8)
    private int turn = 1;

    //Variables to track player's computer controlled status/cpu level
    //0 indicated manual player control (no com)
    //1 indicates random cpu, 2 easy, and 3 hard (if I get that far)
    private int com1 = 0;
    private int com2 = 0;
    private int com3 = 0;
    private int com4 = 0;

    private cpu1 computer1 = new cpu1();
    private cpu2 computer2 = new cpu2();

    private boolean autoplay = false;

    //Variable to track where the last tile came from (to disallow immediate replacement)
    private int lastTile = 0;
    private int lastDir = 0;
    

    private static int pX, pY;
    //Class called GraphicsLab which will contain all the important code
    //and logic for displaying images,tiles, and text
    public GraphicsLab() {
        //Code involving the frame
        //Creating the frame with a title that will hold everything
        frame = new JFrame("Labyrinth");
        //Creating function for the program to close if the window closes
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Setting the size of the frame
        frame.setSize(1300, 750);
        //Setting layout style of frame
        //null allows for absolute positioning
        frame.setLayout(null);

        //Code for the images
        //Calling a function that assigns all the tiles what image they should be
        //Initializing loop avoids null pointer error
        int i = 1;
        for(i=1;i<=50;i++) {
            TileGraphics(i, "Tile_I_0.jpg");
        }
        

        //Code for setting bounds of tiles and inserting them
        //Row 1
        Tile1.setBounds(100, 75, X, Y);
        Tile2.setBounds(175,75,X,Y);
        Tile3.setBounds(250,75,X,Y);
        Tile4.setBounds(325,75,X,Y);
        Tile5.setBounds(400,75,X,Y);
        Tile6.setBounds(475,75,X,Y);
        Tile7.setBounds(550,75,X,Y);
        //Row 2
        Tile8.setBounds(100,150,X,Y);
        Tile9.setBounds(175,150,X,Y);
        Tile10.setBounds(250,150,X,Y);
        Tile11.setBounds(325,150,X,Y);
        Tile12.setBounds(400,150,X,Y);
        Tile13.setBounds(475,150,X,Y);
        Tile14.setBounds(550,150,X,Y);
        //Row 3
        Tile15.setBounds(100,225,X,Y);
        Tile16.setBounds(175,225,X,Y);
        Tile17.setBounds(250,225,X,Y);
        Tile18.setBounds(325,225,X,Y);
        Tile19.setBounds(400,225,X,Y);
        Tile20.setBounds(475,225,X,Y);
        Tile21.setBounds(550,225,X,Y);
        //Row 4
        Tile22.setBounds(100,300,X,Y);
        Tile23.setBounds(175,300,X,Y);
        Tile24.setBounds(250,300,X,Y);
        Tile25.setBounds(325,300,X,Y);
        Tile26.setBounds(400,300,X,Y);
        Tile27.setBounds(475,300,X,Y);
        Tile28.setBounds(550,300,X,Y);
        //Row 5
        Tile29.setBounds(100,375,X,Y);
        Tile30.setBounds(175,375,X,Y);
        Tile31.setBounds(250,375,X,Y);
        Tile32.setBounds(325,375,X,Y);
        Tile33.setBounds(400,375,X,Y);
        Tile34.setBounds(475,375,X,Y);
        Tile35.setBounds(550,375,X,Y);
        //Row 6
        Tile36.setBounds(100,450,X,Y);
        Tile37.setBounds(175,450,X,Y);
        Tile38.setBounds(250,450,X,Y);
        Tile39.setBounds(325,450,X,Y);
        Tile40.setBounds(400,450,X,Y);
        Tile41.setBounds(475,450,X,Y);
        Tile42.setBounds(550,450,X,Y);
        //Row 7
        Tile43.setBounds(100,525,X,Y);
        Tile44.setBounds(175,525,X,Y);
        Tile45.setBounds(250,525,X,Y);
        Tile46.setBounds(325,525,X,Y);
        Tile47.setBounds(400,525,X,Y);
        Tile48.setBounds(475,525,X,Y);
        Tile49.setBounds(550,525,X,Y);
        //Main rotating tile which is off to the side
        TileMain.setBounds(1000, 300,X,Y);

        JButton R = new JButton("R");
        JButton L = new JButton("L");
        JButton C = new JButton("COM");
        JButton A = new JButton("Autoplay");
        JButton p1 = new JButton("P1: " + com1);
        JButton p2 = new JButton("P2: " + com2);
        JButton p3 = new JButton("P3: " + com3);
        JButton p4 = new JButton("P4: " + com4);
        R.setBounds(1100,300,100,100);
        L.setBounds(900,300,100,100);
        C.setBounds(1000,400,100,50);
        A.setBounds(1000,455,100,50);
        p1.setBounds(1150,10,80,25);
        p2.setBounds(1150,35,80,25);
        p3.setBounds(1150,60,80,25);
        p4.setBounds(1150,85,80,25);
        R.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {rotateRight();}
        });
        L.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {rotateLeft();}
        });
        C.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {comTurn();}
        });
        A.addMouseListener (new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {autoplay = !autoplay;}
            @Override
            public void mousePressed(MouseEvent e) {while(autoplay){comTurn();}}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
        p1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                com1++;
                if(com1 > 2) com1 = 0;
                p1.setText("P1: " + com1);
            }
        });
        p2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                com2++;
                if(com2 > 2) com2 = 0;
                p2.setText("P2: " + com2);
            }
        });
        p3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                com3++;
                if(com3 > 2) com3 = 0;
                p3.setText("P3: " + com3);
            }
        });
        p4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                com4++;
                if(com4 > 2) com4 = 0;
                p4.setText("P4: " + com4);
            }
        });

        frame.add(R);
        frame.add(L);
        frame.add(C);
        frame.add(A);
        frame.add(p1);
        frame.add(p2);
        frame.add(p3);
        frame.add(p4);

        //Creating and putting the images in the arrows
        IndicatorsAdd();

        //Code for actually adding the tiles and such to the frame
        //Row 1
        frame.add(Tile1);
        frame.add(Tile2);
        frame.add(Tile3);
        frame.add(Tile4);
        frame.add(Tile5);
        frame.add(Tile6);
        frame.add(Tile7);
        //Row 2
        frame.add(Tile8);
        frame.add(Tile9);
        frame.add(Tile10);
        frame.add(Tile11);
        frame.add(Tile12);
        frame.add(Tile13);
        frame.add(Tile14);
        //Row 3
        frame.add(Tile15);
        frame.add(Tile16);
        frame.add(Tile17);
        frame.add(Tile18);
        frame.add(Tile19);
        frame.add(Tile20);
        frame.add(Tile21);
        //Row 4
        frame.add(Tile22);
        frame.add(Tile23);
        frame.add(Tile24);
        frame.add(Tile25);
        frame.add(Tile26);
        frame.add(Tile27);
        frame.add(Tile28);
        //Row 5
        frame.add(Tile29);
        frame.add(Tile30);
        frame.add(Tile31);
        frame.add(Tile32);
        frame.add(Tile33);
        frame.add(Tile34);
        frame.add(Tile35);
        //Row 6
        frame.add(Tile36);
        frame.add(Tile37);
        frame.add(Tile38);
        frame.add(Tile39);
        frame.add(Tile40);
        frame.add(Tile41);
        frame.add(Tile42);
        //Row 7
        frame.add(Tile43);
        frame.add(Tile44);
        frame.add(Tile45);
        frame.add(Tile46);
        frame.add(Tile47);
        frame.add(Tile48);
        frame.add(Tile49);
        //Adding the rotating tile to the screen
        frame.add(TileMain);

        //Keeps play layer above board layer
        frame.setFocusableWindowState(false);

        //Setting the frame visible and everything inside of it
        frame.setVisible(true);

        GraphicsPlayerPiece();
    }

    //The main function
    //Creates and runs everything, mostly for figuring out what works and what doesnt
    public static void main(String[] args) {
        new GraphicsLab();
    }

    public void rotateRight(){
        board.rotR();
        try {
            Img50 = ImageIO.read(new File(board.getImage(49)));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        frame.repaint();
    }

    public void rotateLeft(){
        board.rotL();
        try {
            Img50 = ImageIO.read(new File(board.getImage(49)));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        frame.repaint();
    }

    //Will take the ID and Type from craig's tile class
    //And give it a string which can be used in the Tile Graphics function
    String AssignTile(int ID, char Type, int rot) {
        System.getProperty("user.dir");
        String TileFname = "";
        switch(ID){
            case 1: TileFname = "Tile_L_Red_0.jpg";
                break;
            case 2: TileFname = "Tile_L_Blue_0.jpg";
                break;
            case 3: TileFname = "Tile_L_Yellow_0.jpg";
                break;
            case 4: TileFname = "Tile_L_Green_0.jpg";
                break;
            case 5: 
                if(rot == 0) TileFname = "Tile_T_Skull_0.jpg";
                if(rot == 90) TileFname = "Tile_T_Skull_90.jpg";
                if(rot == 180) TileFname = "Tile_T_Skull_180.jpg";
                if(rot == 270) TileFname = "Tile_T_Skull_270.jpg";
                break;
            case 6: 
                if(rot == 0) TileFname = "Tile_T_Sword_0.jpg";
                if(rot == 90) TileFname = "Tile_T_Sword_90.jpg";
                if(rot == 180) TileFname = "Tile_T_Sword_180.jpg";
                if(rot == 270) TileFname = "Tile_T_Sword_270.jpg";
                break;
            case 7:
                if(rot == 0) TileFname = "Tile_T_Coins_0.jpg";
                if(rot == 90) TileFname = "Tile_T_Coins_90.jpg";
                if(rot == 180) TileFname = "Tile_T_Coins_180.jpg";
                if(rot == 270) TileFname = "Tile_T_Coins_270.jpg";
                break;
            case 8: 
                if(rot == 0) TileFname = "Tile_T_Keys_0.jpg";
                if(rot == 90) TileFname = "Tile_T_Keys_90.jpg";
                if(rot == 180) TileFname = "Tile_T_Keys_180.jpg";
                if(rot == 270) TileFname = "Tile_T_Keys_270.jpg";
                break;
            case 9: 
                if(rot == 0) TileFname = "Tile_T_Emerald_0.jpg";
                if(rot == 90) TileFname = "Tile_T_Emerald_90.jpg";
                if(rot == 180) TileFname = "Tile_T_Emerald_180.jpg";
                if(rot == 270) TileFname = "Tile_T_Emerald_270.jpg";
                break;
            case 10: 
                if(rot == 0) TileFname = "Tile_T_Knight_0.jpg";
                if(rot == 90) TileFname = "Tile_T_Knight_90.jpg";
                if(rot == 180) TileFname = "Tile_T_Knight_180.jpg";
                if(rot == 270) TileFname = "Tile_T_Knight_270.jpg";
                break;
            case 11:
                if(rot == 0) TileFname = "Tile_T_Book_0.jpg";
                if(rot == 90) TileFname = "Tile_T_Book_90.jpg";
                if(rot == 180) TileFname = "Tile_T_Book_180.jpg";
                if(rot == 270) TileFname = "Tile_T_Book_270.jpg";
                break;
            case 12:
                if(rot == 0) TileFname = "Tile_T_Crown_0.jpg";
                if(rot == 90) TileFname = "Tile_T_Crown_90.jpg";
                if(rot == 180) TileFname = "Tile_T_Crown_180.jpg";
                if(rot == 270) TileFname = "Tile_T_Crown_270.jpg";
                break;
            case 13:
                if(rot == 0) TileFname = "Tile_T_Chest_0.jpg";
                if(rot == 90) TileFname = "Tile_T_Chest_90.jpg";
                if(rot == 180) TileFname = "Tile_T_Chest_180.jpg";
                if(rot == 270) TileFname = "Tile_T_Chest_270.jpg";
                break;
            case 14:
                if(rot == 0) TileFname = "Tile_T_Candleabra_0.jpg";
                if(rot == 90) TileFname = "Tile_T_Candleabra_90.jpg";
                if(rot == 180) TileFname = "Tile_T_Candleabra_180.jpg";
                if(rot == 270) TileFname = "Tile_T_Candleabra_270.jpg";
                break;
            case 15:
                if(rot == 0) TileFname = "Tile_T_Map_0.jpg";
                if(rot == 90) TileFname = "Tile_T_Map_90.jpg";
                if(rot == 180) TileFname = "Tile_T_Map_180.jpg";
                if(rot == 270) TileFname = "Tile_T_Map_270.jpg";
                break;
            case 16:
                if(rot == 0) TileFname = "Tile_T_Ring_0.jpg";
                if(rot == 90) TileFname = "Tile_T_Ring_90.jpg";
                if(rot == 180) TileFname = "Tile_T_Ring_180.jpg";
                if(rot == 270) TileFname = "Tile_T_Ring_270.jpg";
                break;
            case 17:
                if(rot == 0) TileFname = "Tile_L_Spider_0.jpg";
                if(rot == 90) TileFname = "Tile_L_Spider_90.jpg";
                if(rot == 180) TileFname = "Tile_L_Spider_180.jpg";
                if(rot == 270) TileFname = "Tile_L_Spider_270.jpg";
                break;
            case 18:
                if(rot == 0) TileFname = "Tile_L_Mouse_0.jpg";
                if(rot == 90) TileFname = "Tile_L_Mouse_90.jpg";
                if(rot == 180) TileFname = "Tile_L_Mouse_180.jpg";
                if(rot == 270) TileFname = "Tile_L_Mouse_270.jpg";
                break;
            case 19:
                if(rot == 0) TileFname = "Tile_L_Moth_0.jpg";
                if(rot == 90) TileFname = "Tile_L_Moth_90.jpg";
                if(rot == 180) TileFname = "Tile_L_Moth_180.jpg";
                if(rot == 270) TileFname = "Tile_L_Moth_270.jpg";
                break;
            case 20:
                if(rot == 0) TileFname = "Tile_L_Beetle_0.jpg";
                if(rot == 90) TileFname = "Tile_L_Beetle_90.jpg";
                if(rot == 180) TileFname = "Tile_L_Beetle_180.jpg";
                if(rot == 270) TileFname = "Tile_L_Beetle_270.jpg";
                break;
            case 21:
                if(rot == 0) TileFname = "Tile_L_Lizard_0.jpg";
                if(rot == 90) TileFname = "Tile_L_Lizard_90.jpg";
                if(rot == 180) TileFname = "Tile_L_Lizard_180.jpg";
                if(rot == 270) TileFname = "Tile_L_Lizard_270.jpg";
                break;
            case 22:
                if(rot == 0) TileFname = "Tile_L_Owl_0.jpg";
                if(rot == 90) TileFname = "Tile_L_Owl_90.jpg";
                if(rot == 180) TileFname = "Tile_L_Owl_180.jpg";
                if(rot == 270) TileFname = "Tile_L_Owl_270.jpg";
                break;
            case 23:
                if(rot == 0) TileFname = "Tile_T_Bat_0.jpg";
                if(rot == 90) TileFname = "Tile_T_Bat_90.jpg";
                if(rot == 180) TileFname = "Tile_T_Bat_180.jpg";
                if(rot == 270) TileFname = "Tile_T_Bat_270.jpg";
                break;
            case 24:
                if(rot == 0) TileFname = "Tile_T_Troll_0.jpg";
                if(rot == 90) TileFname = "Tile_T_Troll_90.jpg";
                if(rot == 180) TileFname = "Tile_T_Troll_180.jpg";
                if(rot == 270) TileFname = "Tile_T_Troll_270.jpg";
                break;
            case 25:
                if(rot == 0) TileFname = "Tile_T_Ghost_0.jpg";
                if(rot == 90) TileFname = "Tile_T_Ghost_90.jpg";
                if(rot == 180) TileFname = "Tile_T_Ghost_180.jpg";
                if(rot == 270) TileFname = "Tile_T_Ghost_270.jpg";
                break;
            case 26:
                if(rot == 0) TileFname = "Tile_T_Genie_0.jpg";
                if(rot == 90) TileFname = "Tile_T_Genie_90.jpg";
                if(rot == 180) TileFname = "Tile_T_Genie_180.jpg";
                if(rot == 270) TileFname = "Tile_T_Genie_270.jpg";
                break;
            case 27:
                if(rot == 0) TileFname = "Tile_T_Lady_0.jpg";
                if(rot == 90) TileFname = "Tile_T_Lady_90.jpg";
                if(rot == 180) TileFname = "Tile_T_Lady_180.jpg";
                if(rot == 270) TileFname = "Tile_T_Lady_270.jpg";
                break;
            case 28:
                if(rot == 0) TileFname = "Tile_T_Dragon_0.jpg";
                if(rot == 90) TileFname = "Tile_T_Dragon_90.jpg";
                if(rot == 180) TileFname = "Tile_T_Dragon_180.jpg";
                if(rot == 270) TileFname = "Tile_T_Dragon_270.jpg";
                break;
            default:
                if(Type == 'l')
                {
                    if(rot == 0) TileFname = "Tile_L_0.jpg";
                    if(rot == 90) TileFname = "Tile_L_90.jpg";
                    if(rot == 180) TileFname = "Tile_L_180.jpg";
                    if(rot == 270) TileFname = "Tile_L_270.jpg";
                }
                else
                {
                    if(rot == 0 || rot == 180) TileFname = "Tile_I_0.jpg";
                    else TileFname = "Tile_I_90.jpg";
                }
                break;
            }
        return TileFname;
    }

    //Function that goes through the tiles and assigns them what image they are
    //It will get sent which tiles are being changed and what the file name should be
    //Must be called 50 times before anything else graphically happens
    void TileGraphics(int x, String Fname){
        //To get which tile is being called we use a switch statement
        switch(x){
        //Tile 1 Panel created and then image is painted in it
        case 1: 
            Tile1 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img1, 0, 0, null);
                }
            };
            try {
                Img1 = ImageIO.read(new File(Fname));

            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        //Tile 2 Panel created and then image is painted in it
        case 2: 
            Tile2 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img2, 0, 0, null);
                }
            };
            try {
                Img2 = ImageIO.read(new File(Fname));

            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        //Tile 3 Panel created and then image is painted in it
        case 3: 
            Tile3 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img3, 0, 0, null);
                }
            };
            try {
                Img3 = ImageIO.read(new File(Fname));

            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        //Tile 4 Panel created and then image is painted in it
        case 4: 
            Tile4 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img4, 0, 0, null);
                }
            };
            try {
                Img4 = ImageIO.read(new File(Fname));

            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        //Tile 5 Panel created and then image is painted in it
        case 5: 
            Tile5 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img5, 0, 0, null);
                }
            };
            try {
                Img5 = ImageIO.read(new File(Fname));

            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        //Tile 6 Panel created and then image is painted in it
        case 6: 
            Tile6 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img6, 0, 0, null);
                }
            };
            try {
                Img6 = ImageIO.read(new File(Fname));

            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        //Tile 7 Panel created and then image is painted in it
        case 7: 
            Tile7 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img7, 0, 0, null);
                }
            };
            try {
                Img7 = ImageIO.read(new File(Fname));

            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
    //Row 1 end
    //Row 2 Start
        //Tile 8 Panel created and then image is painted in it
        case 8: 
            Tile8 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img8, 0, 0, null);
                }
            };
            try {
                Img8 = ImageIO.read(new File(Fname));
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        //Tile 9 Panel created and then image is painted in it
        case 9: 
            Tile9 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img9, 0, 0, null);
                }
            };
            try {
                Img9 = ImageIO.read(new File(Fname));
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        //Tile 10 Panel created and then image is painted in it
        case 10: 
            Tile10 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img10, 0, 0, null);
                }
            };
            try {
                Img10 = ImageIO.read(new File(Fname));
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        //Tile 11 Panel created and then image is painted in it
        case 11: 
            Tile11 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img11, 0, 0, null);
                }
            };
            try {
                Img11 = ImageIO.read(new File(Fname));
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        //Tile 12 Panel created and then image is painted in it
        case 12: 
            Tile12 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img12, 0, 0, null);
                }
            };
            try {
                Img12 = ImageIO.read(new File(Fname));
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        //Tile 13 Panel created and then image is painted in it
        case 13: 
            Tile13 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img13, 0, 0, null);
                }
            };
            try {
                Img13 = ImageIO.read(new File(Fname));
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        //Tile 14 Panel created and then image is painted in it
        case 14: 
            Tile14 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img14, 0, 0, null);
                }
            };
            try {
                Img14 = ImageIO.read(new File(Fname));
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
    //Row 2 end
    //Row 3 Start
        //Tile 15 Panel created and then image is painted in it
        case 15: 
            Tile15 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img15, 0, 0, null);
                }
            };
            try {
                Img15 = ImageIO.read(new File(Fname));
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        //Tile 16 Panel created and then image is painted in it
        case 16: 
            Tile16 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img16, 0, 0, null);
                }
            };
            try {
                Img16 = ImageIO.read(new File(Fname));
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        //Tile 17 Panel created and then image is painted in it
        case 17: 
            Tile17 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img17, 0, 0, null);
                }
            };
            try {
                Img17 = ImageIO.read(new File(Fname));
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        //Tile 18 Panel created and then image is painted in it
        case 18: 
            Tile18 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img18, 0, 0, null);
                }
            };
            try {
                Img18 = ImageIO.read(new File(Fname));
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        //Tile 19 Panel created and then image is painted in it
        case 19: 
            Tile19 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img19, 0, 0, null);
                }
            };
            try {
                Img19 = ImageIO.read(new File(Fname));
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        //Tile 20 Panel created and then image is painted in it
        case 20: 
            Tile20 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img20, 0, 0, null);
                }
            };
            try {
                Img20 = ImageIO.read(new File(Fname));
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        //Tile 21 Panel created and then image is painted in it
        case 21: 
            Tile21 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img21, 0, 0, null);
                }
            };
            try {
                Img21 = ImageIO.read(new File(Fname));
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
    //End of row 3
    //Row 4 start
        //Tile 21 Panel created and then image is painted in it
        case 22: 
            Tile22 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img22, 0, 0, null);
                }
            };
            try {
                Img22 = ImageIO.read(new File(Fname));
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        //Tile 23 Panel created and then image is painted in it
        case 23: 
            Tile23 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img23, 0, 0, null);
                }
            };
            try {
                Img23 = ImageIO.read(new File(Fname));
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        //Tile 24 Panel created and then image is painted in it
        case 24: 
            Tile24 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img24, 0, 0, null);
                }
            };
            try {
                Img24 = ImageIO.read(new File(Fname));
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        //Tile 25 Panel created and then image is painted in it
        case 25: 
            Tile25 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img25, 0, 0, null);
                }
            };
            try {
                Img25 = ImageIO.read(new File(Fname));
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        //Tile 26 Panel created and then image is painted in it
        case 26: 
            Tile26 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img26, 0, 0, null);
                }
            };
            try {
                Img26 = ImageIO.read(new File(Fname));
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        //Tile 27 Panel created and then image is painted in it
        case 27: 
            Tile27 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img27, 0, 0, null);
                }
            };
            try {
                Img27 = ImageIO.read(new File(Fname));
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        //Tile 28 Panel created and then image is painted in it
        case 28: 
            Tile28 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img28, 0, 0, null);
                }
            };
            try {
                Img28 = ImageIO.read(new File(Fname));
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
    //End of row 4
    //Start of row 5
        //Tile 29 Panel created and then image is painted in it
        case 29: 
            Tile29 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img29, 0, 0, null);
                }
            };
            try {
                Img29 = ImageIO.read(new File(Fname));
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        //Tile 30 Panel created and then image is painted in it
        case 30: 
            Tile30 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img30, 0, 0, null);
                }
            };
            try {
                Img30 = ImageIO.read(new File(Fname));
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        //Tile 31 Panel created and then image is painted in it
        case 31: 
            Tile31 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img31, 0, 0, null);
                }
            };
            try {
                Img31 = ImageIO.read(new File(Fname));
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        //Tile 32 Panel created and then image is painted in it
        case 32: 
            Tile32 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img32, 0, 0, null);
                }
            };
            try {
                Img32 = ImageIO.read(new File(Fname));
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        //Tile 33 Panel created and then image is painted in it
        case 33: 
            Tile33 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img33, 0, 0, null);
                }
            };
            try {
                Img33 = ImageIO.read(new File(Fname));
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        //Tile 34 Panel created and then image is painted in it
        case 34: 
            Tile34 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img34, 0, 0, null);
                }
            };
            try {
                Img34 = ImageIO.read(new File(Fname));
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        //Tile 35 Panel created and then image is painted in it
        case 35: 
            Tile35 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img35, 0, 0, null);
                }
            };
            try {
                Img35 = ImageIO.read(new File(Fname));
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
    //End of row 5
    //Start of row 6
        //Tile 36 Panel created and then image is painted in it
        case 36: 
            Tile36 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img36, 0, 0, null);
                }
            };
            try {
                Img36 = ImageIO.read(new File(Fname));
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        //Tile 37 Panel created and then image is painted in it
        case 37: 
            Tile37 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img37, 0, 0, null);
                }
            };
            try {
                Img37 = ImageIO.read(new File(Fname));
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        //Tile 38 Panel created and then image is painted in it
        case 38: 
            Tile38 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img38, 0, 0, null);
                }
            };
            try {
                Img38 = ImageIO.read(new File(Fname));
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        //Tile 39 Panel created and then image is painted in it
        case 39: 
            Tile39 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img39, 0, 0, null);
                }
            };
            try {
                Img39 = ImageIO.read(new File(Fname));
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        //Tile 40 Panel created and then image is painted in it
        case 40: 
            Tile40 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img40, 0, 0, null);
                }
            };
            try {
                Img40 = ImageIO.read(new File(Fname));
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        //Tile 35 Panel created and then image is painted in it
        case 41: 
            Tile41 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img41, 0, 0, null);
                }
            };
            try {
                Img41 = ImageIO.read(new File(Fname));
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        //Tile 42 Panel created and then image is painted in it
        case 42: 
            Tile42 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img42, 0, 0, null);
                }
            };
            try {
                Img42 = ImageIO.read(new File(Fname));
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
    //End of row 6
    //Start of row 7
        //Tile 43 Panel created and then image is painted in it
        case 43: 
            Tile43 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img43, 0, 0, null);
                }
            };
            try {
                Img43 = ImageIO.read(new File(Fname));
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        //Tile 44 Panel created and then image is painted in it
        case 44: 
            Tile44 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img44, 0, 0, null);
                }
            };
            try {
                Img44 = ImageIO.read(new File(Fname));
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        //Tile 45 Panel created and then image is painted in it
        case 45: 
            Tile45 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img45, 0, 0, null);
                }
            };
            try {
                Img45 = ImageIO.read(new File(Fname));
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        //Tile 46 Panel created and then image is painted in it
        case 46: 
            Tile46 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img46, 0, 0, null);
                }
            };
            try {
                Img46 = ImageIO.read(new File(Fname));
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        //Tile 47 Panel created and then image is painted in it
        case 47: 
            Tile47 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img47, 0, 0, null);
                }
            };
            try {
                Img47 = ImageIO.read(new File(Fname));
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        //Tile 48 Panel created and then image is painted in it
        case 48: 
            Tile48 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img48, 0, 0, null);
                }
            };
            try {
                Img48 = ImageIO.read(new File(Fname));
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        //Tile 49 Panel created and then image is painted in it
        case 49: 
            Tile49 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img49, 0, 0, null);
                }
            };
            try {
                Img49 = ImageIO.read(new File(Fname));
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
    //End of row 7
    //End of grid tiles
        //Spare Tile
        case 50: 
            TileMain = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img50, 0, 0, null);
                }
            };
            try {
                Img50 = ImageIO.read(new File(Fname));
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        }
    }

    //Function that will assign the images of the arrows
    //As of 10/16 this is new and needs to be added to the main code
    public void IndicatorsAdd()
    {
        //Three Arrows per side
         ImageIcon D = new ImageIcon("ArrowDown.png");
         ImageIcon R = new ImageIcon("ArrowLeft.png");
         ImageIcon U = new ImageIcon("Arrow.png");
         ImageIcon L = new ImageIcon("ArrowRight.png");
         ImageIcon DB = new ImageIcon("ArrowDownBlack.png");
         ImageIcon RB = new ImageIcon("ArrowLeftBlack.png");
         ImageIcon UB = new ImageIcon("ArrowBlack.png");
         ImageIcon LB = new ImageIcon("ArrowRightBlack.png");

        Arrow1Button = new JButton(D);
        Arrow2Button = new JButton(D);
        Arrow3Button = new JButton(D);
        //Right side
        Arrow4Button = new JButton(R);
        Arrow5Button = new JButton(R);
        Arrow6Button = new JButton(R);
        //Bottom
        Arrow7Button = new JButton(U);
        Arrow8Button = new JButton(U);
        Arrow9Button = new JButton(U);
        //Left
        Arrow10Button = new JButton(L);
        Arrow11Button = new JButton(L);
        Arrow12Button = new JButton(L);
        //Setting the bounds and adding the arrows to the frame
        //Top Arrows
        Arrow1Button.setBounds(175,0,X,Y);
        Arrow2Button.setBounds(325,0,X,Y);
        Arrow3Button.setBounds(475,0,X,Y);
        //Right arrows, Img called LeftArrows becuase they face left
        Arrow4Button.setBounds(625,150,X,Y);
        Arrow5Button.setBounds(625,300,X,Y);
        Arrow6Button.setBounds(625,450,X,Y);
        //Arrows on the bottom row
        Arrow7Button.setBounds(475, 600,X,Y);
        Arrow8Button.setBounds(325, 600,X,Y);
        Arrow9Button.setBounds(175,600,X,Y);
        //Arrows on the Left
        Arrow10Button.setBounds(0,450,X,Y);
        Arrow11Button.setBounds(0,300,X,Y);
        Arrow12Button.setBounds(0,150,X,Y);
        //Adding action listeners

        Arrow1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!((com1 != 0 && turn == 1) || (com2 != 0 && turn == 2) || (com3 != 0 && turn == 3) || (com4 != 0 && turn == 4)))
                moveDown(1);
            }
        });
        Arrow2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!((com1 != 0 && turn == 1) || (com2 != 0 && turn == 2) || (com3 != 0 && turn == 3) || (com4 != 0 && turn == 4)))
                moveDown(3);
            }
        });
        Arrow3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!((com1 != 0 && turn == 1) || (com2 != 0 && turn == 2) || (com3 != 0 && turn == 3) || (com4 != 0 && turn == 4)))
                moveDown(5);
            }
        });
        Arrow4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!((com1 != 0 && turn == 1) || (com2 != 0 && turn == 2) || (com3 != 0 && turn == 3) || (com4 != 0 && turn == 4)))
                moveLeft(1);
            }
        });
        Arrow5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!((com1 != 0 && turn == 1) || (com2 != 0 && turn == 2) || (com3 != 0 && turn == 3) || (com4 != 0 && turn == 4)))
                moveLeft(3);
            }
        });
        Arrow6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!((com1 != 0 && turn == 1) || (com2 != 0 && turn == 2) || (com3 != 0 && turn == 3) || (com4 != 0 && turn == 4)))
                moveLeft(5);
            }

        });
        Arrow7Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!((com1 != 0 && turn == 1) || (com2 != 0 && turn == 2) || (com3 != 0 && turn == 3) || (com4 != 0 && turn == 4)))
                moveUp(5);
            }
        });
        Arrow8Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!((com1 != 0 && turn == 1) || (com2 != 0 && turn == 2) || (com3 != 0 && turn == 3) || (com4 != 0 && turn == 4)))
                moveUp(3);
            }
        });
        Arrow9Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!((com1 != 0 && turn == 1) || (com2 != 0 && turn == 2) || (com3 != 0 && turn == 3) || (com4 != 0 && turn == 4)))
                moveUp(1);
            }
        });
        Arrow10Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!((com1 != 0 && turn == 1) || (com2 != 0 && turn == 2) || (com3 != 0 && turn == 3) || (com4 != 0 && turn == 4)))
                moveRight(5);
            }
        });
        Arrow11Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!((com1 != 0 && turn == 1) || (com2 != 0 && turn == 2) || (com3 != 0 && turn == 3) || (com4 != 0 && turn == 4)))
                moveRight(3);
            }
        });
        Arrow12Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!((com1 != 0 && turn == 1) || (com2 != 0 && turn == 2) || (com3 != 0 && turn == 3) || (com4 != 0 && turn == 4)))
                moveRight(1);
            }
        });
        //Mouse Listeners now
        Arrow1Button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {Arrow1Button.setIcon(DB);}
            @Override
            public void mouseExited(MouseEvent e) {Arrow1Button.setIcon(D);}
        });
        Arrow2Button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {Arrow2Button.setIcon(DB);}
            @Override
            public void mouseExited(MouseEvent e) {Arrow2Button.setIcon(D);}
        });
        Arrow3Button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {Arrow3Button.setIcon(DB);}
            @Override
            public void mouseExited(MouseEvent e) {Arrow3Button.setIcon(D);}
        });
        Arrow4Button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {Arrow4Button.setIcon(RB);}
            @Override
            public void mouseExited(MouseEvent e) {Arrow4Button.setIcon(R);}
        });
        Arrow5Button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {Arrow5Button.setIcon(RB);}
            @Override
            public void mouseExited(MouseEvent e) {Arrow5Button.setIcon(R);}
        });
        Arrow6Button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {Arrow6Button.setIcon(RB);}
            @Override
            public void mouseExited(MouseEvent e) {Arrow6Button.setIcon(R);}
        });
        Arrow7Button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {Arrow7Button.setIcon(UB); }
            @Override
            public void mouseExited(MouseEvent e) {Arrow7Button.setIcon(U);}
        });
        Arrow8Button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {Arrow8Button.setIcon(UB);}
            @Override
            public void mouseExited(MouseEvent e) {Arrow8Button.setIcon(U);}
        });
        Arrow9Button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {Arrow9Button.setIcon(UB);}
            @Override
            public void mouseExited(MouseEvent e) {Arrow9Button.setIcon(U);}
        });
        Arrow10Button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {Arrow10Button.setIcon(LB);}
            @Override
            public void mouseExited(MouseEvent e) {Arrow10Button.setIcon(L);}
        });
        Arrow11Button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {Arrow11Button.setIcon(LB);}
            @Override
            public void mouseExited(MouseEvent e) {Arrow11Button.setIcon(L);}
        });
        Arrow12Button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {Arrow12Button.setIcon(LB);}
            @Override
            public void mouseExited(MouseEvent e) {Arrow12Button.setIcon(L);}
        });
        //Adding arrows
        frame.add(Arrow1Button);
        frame.add(Arrow2Button);
        frame.add(Arrow3Button);
        frame.add(Arrow4Button);
        frame.add(Arrow5Button);
        frame.add(Arrow6Button);
        frame.add(Arrow7Button);
        frame.add(Arrow8Button);
        frame.add(Arrow9Button);
        frame.add(Arrow10Button);
        frame.add(Arrow11Button);
        frame.add(Arrow12Button);
    }

    private void moveDown (int col){
        if(!(lastTile == col && lastDir == 3) && (turn < 5)){
            board.SlideTileDown(col);
            for(int i = 0; i < 50; i++){
                Tile hold = board.getTile(i);
                TileGraphics(i + 1, hold.getImage());
            }
            frame.repaint();
            if(blue.slideDown(col)){ Player2.setBounds(blue.getX()*75 +125 , blue.getY() * 75 +120, 35, 50);}
            if(yellow.slideDown(col)){ Player4.setBounds(yellow.getX()*75 +125 , yellow.getY() * 75 +120, 35, 50);}
            if(green.slideDown(col)){ Player3.setBounds(green.getX()*75 +125 , green.getY() * 75 +120, 35, 50);}
            if(red.slideDown(col)){ Player1.setBounds(red.getX()*75 +125 , red.getY() * 75 +120, 35, 50);}
            frame.repaint();
            switch(col){
                case 1: lastTile = 9; break;
                case 3: lastTile = 8; break;
                case 5: lastTile = 7; break;
            }
            lastDir = 1;
            turn += 4;
        }
    }

    private void moveUp (int col){
        if(!(lastTile == col && lastDir == 1) && (turn < 5)){
            board.SlideTileUp(col);
            for(int i = 0; i < 50; i++){
                Tile hold = board.getTile(i);
                TileGraphics(i + 1, hold.getImage());
            }
            frame.repaint();
            if(blue.slideUp(col)){ Player2.setBounds(blue.getX()*75 +125 , blue.getY() * 75 +120, 35, 50);}
            if(yellow.slideUp(col)){ Player4.setBounds(yellow.getX()*75 +125 , yellow.getY() * 75 +120, 35, 50);}
            if(green.slideUp(col)){ Player3.setBounds(green.getX()*75 +125 , green.getY() * 75 +120, 35, 50);}
            if(red.slideUp(col)){ Player1.setBounds(red.getX()*75 +125 , red.getY() * 75 +120, 35, 50);}
            frame.repaint();
            switch(col){
                case 1: lastTile = 1; break;
                case 3: lastTile = 3; break;
                case 5: lastTile = 5; break;
            }
            lastDir = 3;
            turn += 4;
        }
    }

    private void moveLeft(int row){
        if(!(lastTile == row && lastDir == 4) && (turn < 5)){
            board.SlideTileLeft(row);
            for(int i = 0; i < 50; i++){
                Tile hold = board.getTile(i);
                TileGraphics(i + 1, hold.getImage());
            }
            frame.repaint();
            if(blue.slideLeft(row)){ Player2.setBounds(blue.getX()*75 +125 , blue.getY() * 75 +120, 35, 50);}
            if(yellow.slideLeft(row)){ Player4.setBounds(yellow.getX()*75 +125 , yellow.getY() * 75 +120, 35, 50);}
            if(green.slideLeft(row)){ Player3.setBounds(green.getX()*75 +125 , green.getY() * 75 +120, 35, 50);}
            if(red.slideLeft(row)){ Player1.setBounds(red.getX()*75 +125 , red.getY() * 75 +120, 35, 50);}
            frame.repaint();
            switch(row){
                case 1: lastTile = 1; break;
                case 3: lastTile = 3; break;
                case 5: lastTile = 5; break;
            }
            lastDir = 2;
            turn += 4;
        }
    }

    private void moveRight(int row){
        if(!(lastTile == row && lastDir == 2) && (turn < 5)){
            board.SlideTileRight(row);
            for(int i = 0; i < 50; i++){
                Tile hold = board.getTile(i);
                TileGraphics(i + 1, hold.getImage());
            }
            frame.repaint();
            if(blue.slideRight(row)){ Player2.setBounds(blue.getX()*75 +125 , blue.getY() * 75 +120, 35, 50);}
            if(yellow.slideRight(row)){ Player4.setBounds(yellow.getX()*75 +125 , yellow.getY() * 75 +120, 35, 50);}
            if(green.slideRight(row)){ Player3.setBounds(green.getX()*75 +125 , green.getY() * 75 +120, 35, 50);}
            if(red.slideRight(row)){ Player1.setBounds(red.getX()*75 +125 , red.getY() * 75 +120, 35, 50);}
            frame.repaint();
            switch(row){
                case 1: lastTile = 1; break;
                case 3: lastTile = 3; break;
                case 5: lastTile = 5; break;
            }
            lastDir = 4;
            turn += 4;
        }
    }

    //Player Piece
    public void GraphicsPlayerPiece(){
        ChangeP('R');
        ChangeP('B');
        ChangeP('G');
        ChangeP('Y');

        Player2 = new JFrame();
        Player2.setUndecorated(true);
        Player2.setAlwaysOnTop(true);
        Player2.setBounds(580,110,35,50);
        playerB = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(BlueWiz, 0, 0, null);
            }
        };
        try {
            BlueWiz = ImageIO.read(new File("BluePlayer.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        playerB.setBounds(200,200,35,50);
        Player2.setBackground(new Color(0,0,0,0));
        Player2.add(playerB);
        playerB.setBackground(new Color(0,0,0,0));
        Player2.setVisible(true);

        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {}
            @Override
            public void windowClosing(WindowEvent e) {}
            @Override
            public void windowClosed(WindowEvent e) {}
            @Override
            public void windowIconified(WindowEvent e) {Player2.setVisible(false);}
            @Override
            public void windowDeiconified(WindowEvent e) { Player2.setVisible(true);}
            @Override
            public void windowActivated(WindowEvent e) {}
            @Override
            public void windowDeactivated(WindowEvent e) {}
        });

        //Mouse Listener
        Player2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {
                if(turn == 6 && com2 == 0){
                    PointerInfo a = MouseInfo.getPointerInfo();
                    Point b = a.getLocation();
                    int xm = (int) b.getX();
                    int ym = (int) b.getY();
                    pX = (int) (MouseInfo.getPointerInfo().getLocation().getX() - 110) / 75;
                    if(pX>6) pX=6;
                    if(pX<0) pX=0;
                    pY = (int)(MouseInfo.getPointerInfo().getLocation().getY() - 100) / 75;
                    if(pY>6) pY=6;
                    if(pY<0) pY=0;
                    if(board.adjacent(blue.getpos(), (pX+pY*7))){
                        Player2.setBounds(xm-15,ym-15,35,50);
                        blue.setXY(pX, pY);
                        if(check && check2){
                            Player2.setBounds(580,110,35,50);
                            pX = 0;
                            pY = 0;
                            blue.setXY(pX,pY);
                        }
                        ChangeP('B');
                        frame.repaint();
                        if(blue.checkTreasure(board.getTreasure(pX, pY)) == 0){
                            JOptionPane.showMessageDialog(null, "Blue Player Won!");
                            System.exit(1);
                        }
                        turn = 3;
                    }
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {check2 = false;}
            @Override
            public void mouseExited(MouseEvent e) {check2 = true;}
        });
        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {check = false;}
            @Override
            public void mouseExited(MouseEvent e) {check = true;}
        });

        Player4 = new JFrame();
        Player4.setUndecorated(true);
        Player4.setAlwaysOnTop(true);
        Player4.setBounds(125,560,35,50);
        PlayerY = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(YellowWiz, 0, 0, null);
            }
        };
        try {
            YellowWiz = ImageIO.read(new File("YellowpLayer.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        PlayerY.setBounds(200,200,35,50);
        Player4.setBackground(new Color(0,0,0,0));
        Player4.add(PlayerY);
        PlayerY.setBackground(new Color(0,0,0,0));
        Player4.setVisible(true);
        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {}
            @Override
            public void windowClosing(WindowEvent e) {}
            @Override
            public void windowClosed(WindowEvent e) {}
            @Override
            public void windowIconified(WindowEvent e) {Player4.setVisible(false);}
            @Override
            public void windowDeiconified(WindowEvent e) {Player4.setVisible(true);}
            @Override
            public void windowActivated(WindowEvent e) {}
            @Override
            public void windowDeactivated(WindowEvent e) {}
        });

        //Mouse Listener
        Player4.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {
                if(turn == 8 && com4 == 0){
                    PointerInfo a = MouseInfo.getPointerInfo();
                    Point b = a.getLocation();
                    int xm = (int) b.getX();
                    int ym = (int) b.getY();
                    pX = (int) (MouseInfo.getPointerInfo().getLocation().getX() - 110) / 75;
                    if(pX>6) pX=6;
                    if(pX<0) pX=0;
                    pY = (int)(MouseInfo.getPointerInfo().getLocation().getY() - 100) / 75;
                    if(pY>6) pY=6;
                    if(pY<0) pY=0;
                    if(board.adjacent(yellow.getpos(), (pX+pY*7))){
                        yellow.setXY(pX, pY);
                        Player4.setBounds(xm-15,ym-15,35,50);
                        if(check && check2){
                            Player4.setBounds(125,560,35,50);
                            pX = 0;
                            pY = 0;
                            yellow.setXY(pX, pY);
                        }
                        ChangeP('Y');
                        frame.repaint();
                        if(yellow.checkTreasure(board.getTreasure(pX, pY)) == 0){
                            JOptionPane.showMessageDialog(null, "Yellow Player Won!");
                            System.exit(1);
                        }
                        turn = 1;
                    }
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {check2 = false;}
            @Override
            public void mouseExited(MouseEvent e) {check2 = true;}
        });
        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {check = false;}
            @Override
            public void mouseExited(MouseEvent e) {check = true;}
        });

        Player3 = new JFrame();
        Player3.setUndecorated(true);
        Player3.setAlwaysOnTop(true);
        Player3.setBounds(580,560,35,50);
        PlayerG = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(GreenWiz, 0, 0, null);
            }
        };
        try {
            GreenWiz = ImageIO.read(new File("GreenPLayer.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        PlayerG.setBounds(200,200,35,50);
        Player3.setBackground(new Color(0,0,0,0));
        Player3.add(PlayerG);
        PlayerG.setBackground(new Color(0,0,0,0));
        Player3.setVisible(true);
        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {}
            @Override
            public void windowClosing(WindowEvent e) {}
            @Override
            public void windowClosed(WindowEvent e) {}
            @Override
            public void windowIconified(WindowEvent e) {Player3.setVisible(false);}
            @Override
            public void windowDeiconified(WindowEvent e) {Player3.setVisible(true);}
            @Override
            public void windowActivated(WindowEvent e) {}
            @Override
            public void windowDeactivated(WindowEvent e) {}
        });

        //Mouse Listener
        Player3.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {
                if(turn == 7 && com3 == 0){
                    PointerInfo a = MouseInfo.getPointerInfo();
                    Point b = a.getLocation();
                    int xm = (int) b.getX();
                    int ym = (int) b.getY();
                    pX = (int) (MouseInfo.getPointerInfo().getLocation().getX() - 110) / 75;
                    if(pX>6) pX=6;
                    if(pX<0) pX=0;
                    pY = (int)(MouseInfo.getPointerInfo().getLocation().getY() - 100) / 75;
                    if(pY>6) pY=6;
                    if(pY<0) pY=0;
                    if(board.adjacent(green.getpos(), (pX+pY*7))){
                        Player3.setBounds(xm-15,ym-15,35,50);
                        green.setXY(pX, pY);
                        if(check && check2){
                            Player3.setBounds(580,560,35,50);
                            pX = 0;
                            pY = 0;
                            green.setXY(pX, pY);
                        }
                        ChangeP('G');
                        frame.repaint();
                        if(green.checkTreasure(board.getTreasure(pX, pY)) == 0){
                            JOptionPane.showMessageDialog(null, "Green Player Won!");
                            System.exit(1);
                        }
                        turn = 4;
                    }
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {check2 = false;}
            @Override
            public void mouseExited(MouseEvent e) {check2 = true;}
        });
        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {check = false;}
            @Override
            public void mouseExited(MouseEvent e) {check = true;}
        });

        Player1 = new JFrame();
        Player1.setUndecorated(true);
        Player1.setAlwaysOnTop(true);
        Player1.setBounds(125,110,35,50);
        PlayerR = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(RedWiz, 0, 0, null);
            }
        };
        try {
            RedWiz = ImageIO.read(new File("RedPLayer.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        PlayerR.setBounds(200,200,35,50);
        Player1.setBackground(new Color(0,0,0,0));
        Player1.add(PlayerR);
        PlayerR.setBackground(new Color(0,0,0,0));
        Player1.setVisible(true);
        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {}
            @Override
            public void windowClosing(WindowEvent e) {}
            @Override
            public void windowClosed(WindowEvent e) {}
            @Override
            public void windowIconified(WindowEvent e) {Player1.setVisible(false);}
            @Override
            public void windowDeiconified(WindowEvent e) {Player1.setVisible(true);}
            @Override
            public void windowActivated(WindowEvent e) {}
            @Override
            public void windowDeactivated(WindowEvent e) {}
        });

        //Mouse Listener
        Player1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {
                if(turn == 5 && com1 == 0){
                    PointerInfo a = MouseInfo.getPointerInfo();
                    Point b = a.getLocation();
                    int xm = (int) b.getX();
                    int ym = (int) b.getY();
                    pX = (int) (MouseInfo.getPointerInfo().getLocation().getX() - 110) / 75;
                    if(pX>6) pX=6;
                    if(pX<0) pX=0;
                    pY = (int)(MouseInfo.getPointerInfo().getLocation().getY() - 100) / 75;
                    if(pY>6) pY=6;
                    if(pY<0) pY=0;
                    if(board.adjacent(red.getpos(), (pX+pY*7))){
                        Player1.setBounds(xm-15,ym-15,35,50);
                        red.setXY(pX, pY);
                        if(check && check2) {
                            Player1.setBounds(125,110,35,50);
                            pX = 0;
                            pY = 0;
                            red.setXY(pX, pY);
                        }
                        ChangeP('R');
                        frame.repaint();
                        if(red.checkTreasure(board.getTreasure(pX, pY)) == 0) {
                            JOptionPane.showMessageDialog(null, "Red Player Won!");
                            System.exit(1);
                        }
                        turn = 2;
                    }
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {check2 = false;}
            @Override
            public void mouseExited(MouseEvent e) {check2 = true;}
        });
        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {check = false;}
            @Override
            public void mouseExited(MouseEvent e) {check = true;}
        });
    }

    public void ChangeP(char Piece) {
        int tile;
        char temp;
        JLabel label1 = new JLabel("Test");
        switch(Piece){
            case 'B': 
                tile = blue.checkTreasure(board.getTreasure(pX, pY));
                temp = ' ';
                if (tile != 0) {
                    temp = 'T';
                } else {
                    temp = 'L';
                }
                T2 = new JPanel() {
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        g.drawImage(TP2, 0, 0, null);
                    }
                };
                try {
                    TP2 = ImageIO.read(new File(AssignTile(tile, temp, 0)));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                T2.setBounds(900, 10, 75, 75);
                frame.add(T2);
                label1.setText("Player Blue");
                label1.setBounds(900,70,100,60);
                frame.add(label1);
            break;
            case 'R': 
                tile = red.checkTreasure(board.getTreasure(pX, pY));
                temp = ' ';
                if (tile != 0) {
                    temp = 'T';
                } else {
                    temp = 'L';
                }
                T1 = new JPanel() {
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        g.drawImage(TP1, 0, 0, null);
                    }
                };
                try {
                    TP1 = ImageIO.read(new File(AssignTile(tile, temp, 0)));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                T1.setBounds(1000, 10, 75, 75);
                frame.add(T1);
                label1.setText("Player Red");
                label1.setBounds(1000,70,100,60);
                frame.add(label1);
            break;
            case 'G': 
                tile = green.checkTreasure(board.getTreasure(pX, pY));
                temp = ' ';
                if (tile != 0) {
                    temp = 'T';
                } else {
                    temp = 'L';
                }
                T3 = new JPanel() {
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        g.drawImage(TP3, 0, 0, null);
                    }
                };
                try {
                    TP3 = ImageIO.read(new File(AssignTile(tile, temp, 0)));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                T3.setBounds(900, 150, 75, 75);
                frame.add(T3);
                label1.setText("Player Green");
                label1.setBounds(900,200,100,60);
                frame.add(label1);
            break;
            case 'Y': 
                tile = yellow.checkTreasure(board.getTreasure(pX, pY));
                temp = ' ';
                if (tile != 0) {
                    temp = 'T';
                } else {
                    temp = 'L';
                }
                T4 = new JPanel() {
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        g.drawImage(TP4, 0, 0, null);
                    }
                };
                try {
                    TP4 = ImageIO.read(new File(AssignTile(tile, temp, 0)));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                T4.setBounds(1000, 150, 75, 75);
                frame.add(T4);
                label1.setText("Player Yellow");
                label1.setBounds(1000,200,100,60);
                frame.add(label1);
            break;
        }
    }

    public void comTurn(){
        boolean ai1 = (com1 != 0 && turn == 1);
        boolean ai2 = (com2 != 0 && turn == 2);
        boolean ai3 = (com3 != 0 && turn == 3);
        boolean ai4 = (com4 != 0 && turn == 4);
        int lastPos = lastTile + (lastDir - 1) * 3;
        int move = 0;
        int revolve = 0;
        if(ai1){
            switch(com1)
            {
                case 1:{
                    revolve = computer1.rotate();
                    while(revolve > 0){
                        rotateRight();
                        revolve--;
                    }
                    tileSlide(computer1.tile(lastPos));
                    move = computer1.move(red.getpos(), board, red.getTreasure());
                }
                case 2:{
                    revolve = computer2.rotate();
                    while(revolve > 0){
                        rotateRight();
                        revolve--;
                    }
                    tileSlide(computer2.tile(lastPos));
                    move = computer2.move(red.getpos(), board, red.getTreasure());
                }
            }
            red.setPos(move);
            pX = red.getX();
            pY = red.getY();
            Player1.setBounds(pX*75 +125 , pY * 75 +120, 35, 50);
            ChangeP('R');
            frame.repaint();
            if(red.checkTreasure(board.getTreasure(pX, pY)) == 0) {
                JOptionPane.showMessageDialog(null, "Red Player Won!");
                System.exit(1);
            }
            turn = 2;
        }
        if(ai2){
            switch(com2)
            {
                case 1:{
                    revolve = computer1.rotate();
                    while(revolve > 0){
                        rotateRight();
                        revolve--;
                    }
                    tileSlide(computer1.tile(lastPos));
                    move = computer1.move(blue.getpos(), board, blue.getTreasure());
                }
                case 2:{
                    revolve = computer2.rotate();
                    while(revolve > 0){
                        rotateRight();
                        revolve--;
                    }
                    tileSlide(computer2.tile(lastPos));
                    move = computer2.move(blue.getpos(), board, blue.getTreasure());
                }
            }
            blue.setPos(move);
            pX = blue.getX();
            pY = blue.getY();
            Player2.setBounds(pX*75 +125 , pY * 75 +120, 35, 50);
            ChangeP('B');
            frame.repaint();
            if(blue.checkTreasure(board.getTreasure(pX, pY)) == 0) {
                JOptionPane.showMessageDialog(null, "Blue Player Won!");
                System.exit(1);
            }
            turn = 3;
        }
        if(ai3){
            switch(com3)
            {
                case 1:{
                    revolve = computer1.rotate();
                    while(revolve > 0){
                        rotateRight();
                        revolve--;
                    }
                    tileSlide(computer1.tile(lastPos));
                    move = computer1.move(green.getpos(), board, green.getTreasure());
                }
                case 2:{
                    revolve = computer2.rotate();
                    while(revolve > 0){
                        rotateRight();
                        revolve--;
                    }
                    tileSlide(computer2.tile(lastPos));
                    move = computer2.move(green.getpos(), board, green.getTreasure());
                }
            }
            green.setPos(move);
            pX = green.getX();
            pY = green.getY();
            Player3.setBounds(pX*75 +125 , pY * 75 +120, 35, 50);
            ChangeP('G');
            frame.repaint();
            if(red.checkTreasure(board.getTreasure(pX, pY)) == 0) {
                JOptionPane.showMessageDialog(null, "Green Player Won!");
                System.exit(1);
            }
            turn = 4;
        }
        if(ai4){
            switch(com4)
            {
                case 1:{
                    revolve = computer1.rotate();
                    while(revolve > 0){
                        rotateRight();
                        revolve--;
                    }
                    tileSlide(computer1.tile(lastPos));
                    move = computer1.move(yellow.getpos(), board, yellow.getTreasure());
                }
                case 2:{
                    revolve = computer2.rotate();
                    while(revolve > 0){
                        rotateRight();
                        revolve--;
                    }
                    tileSlide(computer2.tile(lastPos));
                    move = computer2.move(yellow.getpos(), board, yellow.getTreasure());
                }
            }
            yellow.setPos(move);
            pX = yellow.getX();
            pY = yellow.getY();
            Player4.setBounds(pX*75+125 , pY*75 +120, 35, 50);
            ChangeP('Y');
            frame.repaint();
            if(yellow.checkTreasure(board.getTreasure(pX, pY)) == 0) {
                JOptionPane.showMessageDialog(null, "Yellow Player Won!");
                System.exit(1);
            }
            turn = 2;
        }
    }

    private void tileSlide(int pos){
        switch(pos){
            case 1: moveDown(1); break;
            case 2: moveDown(3); break;
            case 3: moveDown(5); break;
            case 4: moveLeft(1); break;
            case 5: moveLeft(3); break;
            case 6: moveLeft(5); break;
            case 7: moveUp(5); break;
            case 8: moveUp(3); break;
            case 9: moveUp(1); break;
            case 10: moveRight(5); break;
            case 11: moveRight(3); break;
            case 12: moveRight(1); break;
        }
    }
}