import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GraphicsLab {
    //Main frame the player can see and holds everything
    private JFrame frame;

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

    //Variables used to adjust what tile's height and length will be
    private int X=75,Y=75;

    //Will make the text multi-lined using HTML
    public static String convertToMultiline(String orig)
    {
        return "<html>" + orig.replaceAll("\n", "<br>");
    }

    //Class called GraphicsLab which will contain all the important code
    //and logic for displaying images,tiles, and text
    public GraphicsLab(String s) {
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
        TileGraphics(1);

     //Code for setting bounds of tiles and inserting them
        //(position X, position Y,Image length X, image length Y)
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

        //Creating Instruction Text
        JLabel InstructSet1 = new JLabel("Text1");
        JLabel InstructSet2 = new JLabel("Text1");

        //Instruction text, setting what it says and allows it to wrap by using HTML
        InstructSet1.setText(convertToMultiline("To rotate the image\nuse the left or right arrow key"));
        InstructSet2.setText("");

        //Setting bounds of the text on screen
        InstructSet1.setBounds(1000,225,200,30);
        InstructSet2.setBounds(1000,400,400,30);


        //Adding text to frame
        frame.add(InstructSet1);
        frame.add(InstructSet2);

        //Setting the frame visible and everything inside of it
        frame.setVisible(true);

    }

//The main function
    //Creates and runs everything, mostly for figuring out what works and what doesnt
    public static void main(String[] args)
    {
        String W = "Tile_L (1).jpg";
        int deg = 270;
        //Graphics need a string which has the image name
        new GraphicsLab(W);
        //Rotating an image needs int for degrees
       rot(deg);
       TileRepaint();
    }

    //Function that updates and repaints all the tiles
    //Makes the board display correctly
    public static void TileRepaint()
    {
        //Repainting all the tiles and updating them
        GraphicsLab.Tile1.repaint();
        GraphicsLab.Tile2.repaint();
        GraphicsLab.Tile3.repaint();
        GraphicsLab.Tile4.repaint();
        GraphicsLab.Tile5.repaint();
        GraphicsLab.Tile6.repaint();
        GraphicsLab.Tile7.repaint();
        GraphicsLab.Tile8.repaint();
        GraphicsLab.Tile9.repaint();
        GraphicsLab.Tile10.repaint();
        GraphicsLab.Tile11.repaint();
        GraphicsLab.Tile12.repaint();
        GraphicsLab.Tile13.repaint();
        GraphicsLab.Tile14.repaint();
        GraphicsLab.Tile15.repaint();
        GraphicsLab.Tile16.repaint();
        GraphicsLab.Tile17.repaint();
        GraphicsLab.Tile18.repaint();
        GraphicsLab.Tile19.repaint();
        GraphicsLab.Tile20.repaint();
        GraphicsLab.Tile21.repaint();
        GraphicsLab.Tile22.repaint();
        GraphicsLab.Tile23.repaint();
        GraphicsLab.Tile24.repaint();
        GraphicsLab.Tile25.repaint();
        GraphicsLab.Tile26.repaint();
        GraphicsLab.Tile27.repaint();
        GraphicsLab.Tile28.repaint();
        GraphicsLab.Tile29.repaint();
        GraphicsLab.Tile30.repaint();
        GraphicsLab.Tile31.repaint();
        GraphicsLab.Tile32.repaint();
        GraphicsLab.Tile33.repaint();
        GraphicsLab.Tile34.repaint();
        GraphicsLab.Tile35.repaint();
        GraphicsLab.Tile36.repaint();
        GraphicsLab.Tile37.repaint();
        GraphicsLab.Tile38.repaint();
        GraphicsLab.Tile39.repaint();
        GraphicsLab.Tile40.repaint();
        GraphicsLab.Tile41.repaint();
        GraphicsLab.Tile42.repaint();
        GraphicsLab.Tile43.repaint();
        GraphicsLab.Tile44.repaint();
        GraphicsLab.Tile45.repaint();
        GraphicsLab.Tile46.repaint();
        GraphicsLab.Tile47.repaint();
        GraphicsLab.Tile48.repaint();
        GraphicsLab.Tile49.repaint();
        GraphicsLab.TileMain.repaint();
    }

    //Function that rotates the Main tile
    public static void rot(int Degree)
    {
        Img50 = rotateImage(Img50,Degree);
        GraphicsLab.TileMain.repaint();
    }

//Function that goes through the tiles and assigns them what image they are
    //It will get sent which tiles are being changed and what the file name should be
    //Must be called 50 times before anything else graphically happens
    void TileGraphics(int x/*, String Fname*/)
    {
        //To get which tile is being called we use an if else statement
        if(x == 1) {
            Tile1 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img1, 0, 0, null);
                }
            };
            try {
                Img1 = ImageIO.read(new File("Tile_L_Blue(1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            //Tile 2 Panel created and then image is painted in it
        if(x == 2) {
            Tile2 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img2, 0, 0, null);
                }
            };
            try {
                Img2 = ImageIO.read(new File("Tile_I (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//Tile 3 Panel created and then image is painted in it
        if(x == 3) {
            Tile3 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img3, 0, 0, null);
                }
            };
            try {
                Img3 = ImageIO.read(new File("Tile_L_Beetle (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//Tile 4 Panel created and then image is painted in it
        if(x == 4) {
            Tile4 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img4, 0, 0, null);
                }
            };
            try {
                Img4 = ImageIO.read(new File("Tile_T_Troll (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            //Tile 5 Panel created and then image is painted in it
        if(x==5) {
            Tile5 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img5, 0, 0, null);
                }
            };
            try {
                Img5 = ImageIO.read(new File("Tile_T_Emerald (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//Tile 6 Panel created and then image is painted in it
        if(x==6) {
            Tile6 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img6, 0, 0, null);
                }
            };
            try {
                Img6 = ImageIO.read(new File("Tile_T_Genie (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            //Tile 7 Panel created and then image is painted in it
        if(x==7) {
            Tile7 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img7, 0, 0, null);
                }
            };
            try {
                Img7 = ImageIO.read(new File("Tile_L_Green (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//Row 1 end
            //Row 2 Start
            //Tile 8 Panel created and then image is painted in it
        if(x==8) {
            Tile8 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img8, 0, 0, null);
                }
            };
            try {
                Img8 = ImageIO.read(new File("Tile_L (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            //Tile 9 Panel created and then image is painted in it
        if(x==9) {
            Tile9 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img9, 0, 0, null);
                }
            };
            try {
                Img9 = ImageIO.read(new File("Tile_L_Rat (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            //Tile 10 Panel created and then image is painted in it
        if(x==10) {
            Tile10 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img10, 0, 0, null);
                }
            };
            try {
                Img10 = ImageIO.read(new File("Tile_I (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            //Tile 11 Panel created and then image is painted in it
        if(x==11) {
            Tile11 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img11, 0, 0, null);
                }
            };
            try {
                Img11 = ImageIO.read(new File("Tile_T_Abra (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            //Tile 12 Panel created and then image is painted in it
        if(x==12) {
            Tile12 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img12, 0, 0, null);
                }
            };
            try {
                Img12 = ImageIO.read(new File("Tile_T_Book (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            //Tile 13 Panel created and then image is painted in it
        if(x==13) {
            Tile13 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img13, 0, 0, null);
                }
            };
            try {
                Img13 = ImageIO.read(new File("Tile_L (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            //Tile 14 Panel created and then image is painted in it
        if(x==14) {
            Tile14 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img14, 0, 0, null);
                }
            };
            try {
                Img14 = ImageIO.read(new File("Tile_T_Chest (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            //Row 2 end
            //Row 3 Start
            //Tile 15 Panel created and then image is painted in it
        if(x==15) {
            Tile15 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img15, 0, 0, null);
                }
            };
            try {
                Img15 = ImageIO.read(new File("Tile_L (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            //Tile 16 Panel created and then image is painted in it
        if(x==16) {
            Tile16 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img16, 0, 0, null);
                }
            };
            try {
                Img16 = ImageIO.read(new File("Tile_T_Keys (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            //Tile 17 Panel created and then image is painted in it
        if(x==17) {
            Tile17 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img17, 0, 0, null);
                }
            };
            try {
                Img17 = ImageIO.read(new File("Tile_T_Map (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            //Tile 18 Panel created and then image is painted in it
        if(x==18) {
            Tile18 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img18, 0, 0, null);
                }
            };
            try {
                Img18 = ImageIO.read(new File("Tile_T_Ring (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            //Tile 19 Panel created and then image is painted in it
        if(x==19) {
            Tile19 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img19, 0, 0, null);
                }
            };
            try {
                Img19 = ImageIO.read(new File("Tile_T_Sword (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            //Tile 20 Panel created and then image is painted in it
        if(x==20) {
            Tile20 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img20, 0, 0, null);
                }
            };
            try {
                Img20 = ImageIO.read(new File("Tile_I (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            //Tile 21 Panel created and then image is painted in it
        if(x==21) {
            Tile21 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img21, 0, 0, null);
                }
            };
            try {
                Img21 = ImageIO.read(new File("Tile_T_Lady (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            //End of row 3
            //Row 4 start
            //Tile 21 Panel created and then image is painted in it
        if(x==22) {
            Tile22 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img22, 0, 0, null);
                }
            };
            try {
                Img22 = ImageIO.read(new File("Tile_T_Crown (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            //Tile 23 Panel created and then image is painted in it
        if(x==23) {
            Tile23 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img23, 0, 0, null);
                }
            };
            try {
                Img23 = ImageIO.read(new File("Tile_L (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            //Tile 24 Panel created and then image is painted in it
        if(x==24) {
            Tile24 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img24, 0, 0, null);
                }
            };
            try {
                Img24 = ImageIO.read(new File("Tile_L (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            //Tile 25 Panel created and then image is painted in it
        if(x==25) {
            Tile25 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img25, 0, 0, null);
                }
            };
            try {
                Img25 = ImageIO.read(new File("Tile_L_Beetle (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            //Tile 26 Panel created and then image is painted in it
        if(x==26) {
            Tile26 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img26, 0, 0, null);
                }
            };
            try {
                Img26 = ImageIO.read(new File("Tile_L (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            //Tile 27 Panel created and then image is painted in it
        if(x==27) {
            Tile27 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img27, 0, 0, null);
                }
            };
            try {
                Img27 = ImageIO.read(new File("Tile_T_Ghost (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            //Tile 28 Panel created and then image is painted in it
        if(x==28) {
            Tile28 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img28, 0, 0, null);
                }
            };
            try {
                Img28 = ImageIO.read(new File("Tile_I (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            //End of row 4
            //Start of row 5
            //Tile 29 Panel created and then image is painted in it
        if(x==29) {
            Tile29 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img29, 0, 0, null);
                }
            };
            try {
                Img29 = ImageIO.read(new File("Tile_T_Knight (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            //Tile 30 Panel created and then image is painted in it
        if(x==30) {
            Tile30 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img30, 0, 0, null);
                }
            };
            try {
                Img30 = ImageIO.read(new File("Tile_I (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            //Tile 31 Panel created and then image is painted in it
        if(x==31) {
            Tile31 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img31, 0, 0, null);
                }
            };
            try {
                Img31 = ImageIO.read(new File("Tile_T_Ring (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            //Tile 32 Panel created and then image is painted in it
        if(x==32) {
            Tile32 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img32, 0, 0, null);
                }
            };
            try {
                Img32 = ImageIO.read(new File("Tile_L (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            //Tile 33 Panel created and then image is painted in it
        if(x==33) {
            Tile33 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img33, 0, 0, null);
                }
            };
            try {
                Img33 = ImageIO.read(new File("Tile_L_Spider (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            //Tile 34 Panel created and then image is painted in it
        if(x==34) {
            Tile34 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img34, 0, 0, null);
                }
            };
            try {
                Img34 = ImageIO.read(new File("Tile_I (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            //Tile 35 Panel created and then image is painted in it
        if(x==35)
        {
            Tile35 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img35, 0, 0, null);
                }
            };
            try {
                Img35 = ImageIO.read(new File("Tile_T_Dragon (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            //End of row 5
            //Start of row 6
            //Tile 36 Panel created and then image is painted in it
        if(x==36) {
            Tile36 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img36, 0, 0, null);
                }
            };
            try {
                Img36 = ImageIO.read(new File("Tile_T_Coins (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            //Tile 37 Panel created and then image is painted in it
        if(x==37) {
            Tile37 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img37, 0, 0, null);
                }
            };
            try {
                Img37 = ImageIO.read(new File("Tile_L (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            //Tile 38 Panel created and then image is painted in it
        if(x==38) {
            Tile38 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img38, 0, 0, null);
                }
            };
            try {
                Img38 = ImageIO.read(new File("Tile_I (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            //Tile 39 Panel created and then image is painted in it
        if(x==39) {
            Tile39 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img39, 0, 0, null);
                }
            };
            try {
                Img39 = ImageIO.read(new File("Tile_L (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            //Tile 40 Panel created and then image is painted in it
        if(x==40) {
            Tile40 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img40, 0, 0, null);
                }
            };
            try {
                Img40 = ImageIO.read(new File("Tile_L (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            //Tile 35 Panel created and then image is painted in it
        if(x==41) {
            Tile41 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img41, 0, 0, null);
                }
            };
            try {
                Img41 = ImageIO.read(new File("Tile_L_Owl (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            //Tile 42 Panel created and then image is painted in it
        if(x==42) {
            Tile42 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img42, 0, 0, null);
                }
            };
            try {
                Img42 = ImageIO.read(new File("Tile_L (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            //End of row 6
            //Start of row 7
//Tile 43 Panel created and then image is painted in it
        if(x==43) {
            Tile43 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img43, 0, 0, null);
                }
            };
            try {
                Img43 = ImageIO.read(new File("Tile_L_Yellow (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            //Tile 44 Panel created and then image is painted in it
        if(x==44) {
            Tile44 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img44, 0, 0, null);
                }
            };
            try {
                Img44 = ImageIO.read(new File("Tile_I (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            //Tile 45 Panel created and then image is painted in it
        if(x==45) {
            Tile45 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img45, 0, 0, null);
                }
            };
            try {
                Img45 = ImageIO.read(new File("Tile_I (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            //Tile 46 Panel created and then image is painted in it
        if(x==46) {
            Tile46 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img46, 0, 0, null);
                }
            };
            try {
                Img46 = ImageIO.read(new File("Tile_L (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            //Tile 47 Panel created and then image is painted in it
        if(x==47) {
            Tile47 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img47, 0, 0, null);
                }
            };
            try {
                Img47 = ImageIO.read(new File("Tile_L (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            //Tile 48 Panel created and then image is painted in it
        if(x==48) {
            Tile48 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img48, 0, 0, null);
                }
            };
            try {
                Img48 = ImageIO.read(new File("Tile_I (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            //Tile 49 Panel created and then image is painted in it
        if(x == 49) {
            Tile49 = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img49, 0, 0, null);
                }
            };
            try {
                Img49 = ImageIO.read(new File("Tile_L_Red (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            //End of grid tiles
            //Rotated Tile
        if(x==50) {
            TileMain = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(Img50, 0, 0, null);
                }
            };
            try {
                Img50 = ImageIO.read(new File("Tile_L (1).jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //Variable to be called for rotating image
    //Will rotate the Main Tile's image the specified degree
    private static BufferedImage rotateImage(BufferedImage image, double degrees) {
        //Math to figure out how far to rotate an image
        double radians = Math.toRadians(degrees);
        double sin = Math.abs(Math.sin(radians));
        double cos = Math.abs(Math.cos(radians));
        //Getting the images length and width
        int width = image.getWidth();
        int height = image.getHeight();
        //Creating new variables for setting the image to the new rotated values
        int newWidth = (int) Math.floor(width * cos + height * sin);
        int newHeight = (int) Math.floor(height * cos + width * sin);

        //Creating the new image
        BufferedImage rotated = new BufferedImage(newWidth, newHeight, image.getType());
        Graphics2D g2d = rotated.createGraphics();
        //Rotating
        g2d.translate((newWidth - width) / 2, (newHeight - height) / 2);
        g2d.rotate(radians, width / 2, height / 2);
        //Drawing the new image into the panel
        g2d.drawRenderedImage(image, null);
        g2d.dispose();
        //Returning the rotated image
        return rotated;
    }
}