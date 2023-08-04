/**
 * @author Youran Wang : youran.wang@student.uni-luebeck.de
 * modified by  Youran Wang (719511)
 */
package tnt.spiele;

import tnt.Main;
import tnt.enginee.Position;

import javax.swing.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * size : the size of GameField
 * Field : the Matrix of GameField
 * a : x of Position in System
 * b : y of Position in System
 * WinA : if player1 win the game
 * WinB : if player2 win the game
 * player1_first : if player1 has already done the first Move
 * player2_first : if player2 has already done the first Move
 * player1_first_put : if player1 has already done the first Put
 * player2_first_put : if player2 has already done the first Put
 * addPoint : if we choose a Position
 * drawImage : the drawTool
 * imagePanel : the background will be as a Panel
 * background : the Image of background need be loaded as ImageIcon
 * ListOfPosition : record the Position of all presses
 */
public class Spielefield extends Canvas implements MouseListener {
    // set a Matrix with n*n as Spielefield
    // size n could be changed
    public static int size=Add.Size;
    public static int Field[][] = new int[size][size];
    // the parameter of position and boolean
    public static int a;
    public static int b;
    public static boolean WinA;
    public static boolean WinB;
    public static boolean ifkuppelA;
    public static boolean ifkuppelB;
    private static boolean player1_first;
    private static boolean player2_first;
    private static boolean player1_first_put;
    private static boolean player2_first_put;
    public static boolean addPoint;
    public static Graphics2D drawImage;
    private static JPanel imagePanel;
    private static ImageIcon background;
    private List ListOfPosition=new ArrayList<>();

    // print the Spielefield with awt and Canvas appliaction
    public Spielefield() {
        setBackground(Color.white);
        // adding mouse listener
        addMouseListener(this);
    }
    // initialisierung
    public static void intial(){
        ifkuppelA=false;
        ifkuppelB=false;
        player1_first=false;
        player2_first=false;
        player1_first_put=false;
        player2_first_put=false;
        addPoint=false;
        WinA=false;
        WinB=false;
        initview();
    }
    // the Frame of playboard
    public static void initview(){
        // creating an object to the Jframe class
        JFrame jFrame = new JFrame();
        jFrame.setLocationRelativeTo(null);
        jFrame.setBounds(0, 0, 1920, 1080);
        jFrame.setVisible(true);
        jFrame.setLayout(null);

        // set the background of GameField
        background = new ImageIcon("File/GUI_Standard-Theme.png");
        JLabel label = new JLabel(background);
        label.setBounds(0,0,background.getIconWidth(),background.getIconHeight());
        imagePanel=(JPanel)jFrame.getContentPane();
        imagePanel.setOpaque(false);

        // set the button
        JButton jButton_kuppel_1 = new JButton("Kuppel für :"+ Add.player1.getName());
        jButton_kuppel_1.setBounds(350,130,200,40);
        jButton_kuppel_1.addActionListener(e -> {
            ifkuppelA=true;
        });
        jFrame.add(jButton_kuppel_1);

        JButton jButton_kuppel_2 = new JButton("Kuppel für :" + Add.player2.getName());
        jButton_kuppel_2.setBounds(650,130,200,40);
        jButton_kuppel_2.addActionListener(e -> {
            ifkuppelB=true;
        });
        jFrame.add(jButton_kuppel_2);

        // Start a new Field
        JButton jButton_new = new JButton("Neues Field");
        jButton_new.setBounds(350,30,200,40);
        jButton_new.addActionListener(e -> {
            // clear all parameter and shut down the Jframe
            jFrame.dispose();
            kuppel.clear();
            moveIN.Clear();
            putIN.clear();
            for (int i = 0; i < Field.length; i++) {
                for (int j = 0; j < Field[i].length; j++) {
                    Field[i][j]=0;
                }
            }
            jFrame.setContentPane(check.oneMoreLook());
        });
        jFrame.add(jButton_new);
        // close the Jframe
        JButton jButton_quit = new JButton("Ich verlasse !");
        jButton_quit.setBounds(650,30,200,40);
        jButton_quit.addActionListener(e -> {
            System.exit(0);
        });
        jFrame.add(jButton_quit);



        // set the Size of PlayField and add the background
        Spielefield Spielefield=new Spielefield();
        Spielefield.setBounds(100,200, 20+size*50+200, 20+size*50);
        jFrame.add(Spielefield);
        jFrame.setVisible(true);
        jFrame.getLayeredPane().setLayout(null);
        jFrame.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
    }
    // paint() method
    public void paint(Graphics g) {
        // calling the paint method present in the super class or parent class
        super.paint(g);
        drawImage = (Graphics2D) g;
        // The Label of Players and Kuppel. It incloud Color and Name.
        drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1.0f));
        drawImage.setColor(Color.BLACK);
        drawImage.drawString(Add.player1.getName()+ ":", 20+size*50+30, ((20+size*50)/size)-10);

        drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.5f));
        drawImage.setColor(Add.player1.getColor());
        drawImage.fillRect(20+size*50+100, (20+size*50)/size, 50, 50);

        drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.2f));
        drawImage.setColor(Add.player1.getColor());
        drawImage.fillRect(20+size*50+30, (20+size*50)/size, 50, 50);

        drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1.0f));
        drawImage.setColor(Color.BLACK);
        drawImage.drawString(Add.player2.getName() + " :", 20+size*50+30, (3*(20+size*50)/size)-10);

        drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.5f));
        drawImage.setColor(Add.player2.getColor());
        drawImage.fillRect(20+size*50+100, 3*(20+size*50)/size, 50, 50);

        drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.2f));
        drawImage.setColor(Add.player2.getColor());
        drawImage.fillRect(20+size*50+30, 3*(20+size*50)/size, 50, 50);

        drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1.0f));
        drawImage.setColor(Color.BLACK);
        drawImage.drawString("Kuppel"+" :", 20+size*50+60, (5*(20+size*50)/size)-10);

        drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1.0f));
        drawImage.setColor(Color.BLACK);
        drawImage.fillRect(20+size*50+60, 5*(20+size*50)/size, 50, 50);

        for (int i = 0; i < Field.length; i++) {
            for (int j = 0; j < Field[i].length; j++) {
                // always paint the rectangle for the Spielefield
                drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1.0f));
                drawImage.setColor(Color.BLACK);
                drawImage.drawRect(10+(50*i), 10+(50*j), 50 ,50);
                // always paint the Number of Stage for this Building
                drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1.0f));
                drawImage.setColor(Color.BLACK);
                drawImage.drawString(Field[i][j] + "", 10 + (50 * i) + 25, 10 + (50 * j) + 30);
                // The Position, which player1 was builded, will always paint.
                for(int q = 0; q< putIN.player1_List_put.size();q++){
                    if(putIN.player1_put_x.get(q)==j && putIN.player1_put_y.get(q)==i) {
                        drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.2f));
                        drawImage.setColor(Add.player1.getColor());
                        drawImage.fillRect(10 + (50 * putIN.player1_put_x.get(q)), 10 + (50 * putIN.player1_put_y.get(q)), 50, 50);
                    }
                }
                // The Position, which player2 was builded, will always paint.
                for(int w = 0; w< putIN.player2_List_put.size();w++){
                    if(putIN.player2_put_x.get(w)==j && putIN.player2_put_y.get(w)==i) {
                        drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.2f));
                        drawImage.setColor(Add.player2.getColor());
                        drawImage.fillRect(10 + (50 * putIN.player2_put_x.get(w)), 10 + (50 * putIN.player2_put_y.get(w)), 50, 50);
                    }
                }
                // if a Build was been "kuppel", then this Building could be not build any more
                for(int r = 0; r< kuppel.player_List_kuppel.size();r++){
                    if(kuppel.kuppel_put_x.get(r)==j && kuppel.kuppel_put_y.get(r)==i) {
                        drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1.0f));
                        drawImage.setColor(Color.BLACK);
                        drawImage.fillRect(10 + (50 * kuppel.kuppel_put_x.get(r)), 10 + (50 * kuppel.kuppel_put_y.get(r)), 50, 50);
                    }
                }

            }
        }
        // the Position of Engineer for player1 should be paint in Spielefield
        if(player1_first){
            drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.5f));
            drawImage.setColor(Add.player1.getColor());
            drawImage.fillRect(10+(50*moveIN.player1_move_x[moveIN.player1_move_x.length-1]), 10+(50*moveIN.player1_move_y[moveIN.player1_move_y.length-1]), 50 ,50);
        }
        // the Position of Engineer for player2 should be paint in Spielefield
        if(player2_first){
            drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.5f));
            drawImage.setColor(Add.player2.getColor());
            drawImage.fillRect(10+(50*moveIN.player2_move_x[moveIN.player2_move_x.length-1]), 10+(50*moveIN.player2_move_y[moveIN.player2_move_y.length-1]), 50 ,50);
        }
            // press the mouse and get the action
            while (addPoint) {
                //Position e = e_2.nextElement();
                int z_a = a + 1;
                int z_b = b + 1;
                // print the position of press
                System.out.println("Mouse at :" + z_a + " , " + z_b);
                // if need a kuppel
                if (ifkuppelA) {
                    if(Regelcheck.ifAKuppelRight()) {
                        Spielefield.Field[a][b] = 9;
                        kuppel.kuppelA();
                        drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1.0f));
                        drawImage.setColor(Color.BLACK);
                        drawImage.fillRect(10 + (50 * a), 10 + (50 * b), 50, 50);
                        ifkuppelA = false;
                    }else{
                        break;
                    }
                } else if (ifkuppelB) {
                    if(Regelcheck.ifBKuppelRight()) {
                        Spielefield.Field[a][b] = 9;
                        kuppel.kuppelB();
                        drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1.0f));
                        drawImage.setColor(Color.BLACK);
                        drawImage.fillRect(10 + (50 * a), 10 + (50 * b), 50, 50);
                        ifkuppelB = false;
                    }else{
                        break;
                    }
                } else {
                    // player1 move --player1 build -- player2 move -- player2 build
                    if (moveIN.player1_List_move.size() == moveIN.player2_List_move.size() && putIN.player1_List_put.size() == putIN.player2_List_put.size()) {
                        // if its the first step for playerA
                        if (player1_first) {
                            // if its conform to the rules
                            if (Regelcheck.ifAMoveRight()==true) {
                                // if A win the Game
                                if (Regelcheck.ifAwin() == false) {
                                    moveIN.moveA();
                                    drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.5f));
                                    drawImage.setColor(Add.player1.getColor());
                                    drawImage.fillRect(10 + (50 * a), 10 + (50 * b), 50, 50);
                                    addPoint = false;
                                    player1_first = true;
                                } else {
                                    WinA = true;
                                    Winner.winner();
                                    break;
                                }
                            }else{
                                break;
                            }
                        }else{
                            moveIN.moveA();
                            drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.5f));
                            drawImage.setColor(Add.player1.getColor());
                            drawImage.fillRect(10 + (50 * a), 10 + (50 * b), 50, 50);
                            addPoint = false;
                            player1_first = true;
                        }
                    } else if (moveIN.player1_List_move.size() > moveIN.player2_List_move.size() && putIN.player1_List_put.size() == putIN.player2_List_put.size()) {
                        // if its the first put for playerA
                        if(player1_first_put){
                            // if its conform to the rules
                            if (Regelcheck.ifAPutRight() == true) {
                                Spielefield.Field[a][b] = Spielefield.Field[a][b] + 1;
                                putIN.putA();
                                drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.2f));
                                drawImage.setColor(Add.player1.getColor());
                                drawImage.fillRect(10 + (50 * a), 10 + (50 * b), 50, 50);
                                drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1.0f));
                                drawImage.setColor(Color.BLACK);
                                drawImage.drawString(Field[a][b] + "", 10 + (50 * a) + 25, 10 + (50 * b) + 30);
                                addPoint = false;
                                player1_first_put=true;
                            } else {
                                break;
                            }
                        }else{
                            Spielefield.Field[a][b] = Spielefield.Field[a][b] + 1;
                            putIN.putA();
                            drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.2f));
                            drawImage.setColor(Add.player1.getColor());
                            drawImage.fillRect(10 + (50 * a), 10 + (50 * b), 50, 50);
                            drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1.0f));
                            drawImage.setColor(Color.BLACK);
                            drawImage.drawString(Field[a][b] + "", 10 + (50 * a) + 25, 10 + (50 * b) + 30);
                            addPoint = false;
                            player1_first_put=true;
                        }
                    } else if (moveIN.player1_List_move.size() > moveIN.player2_List_move.size() && putIN.player1_List_put.size() > putIN.player2_List_put.size()) {
                        // if its the first step for playerB
                        if (player2_first) {
                            // if its conform to the rules
                            if(Regelcheck.ifBMoveRight()==true) {
                                // if B win the Game
                                if (Regelcheck.ifBwin() == false) {
                                    moveIN.moveB();
                                    drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.5f));
                                    drawImage.setColor(Add.player2.getColor());
                                    drawImage.fillRect(10 + (50 * a), 10 + (50 * b), 50, 50);
                                    addPoint = false;
                                    player2_first = true;
                                } else {
                                    WinB = true;
                                    Winner.winner();
                                    break;
                                }
                            }else{
                                break;
                            }
                        }else{
                            moveIN.moveB();
                            drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.5f));
                            drawImage.setColor(Add.player2.getColor());
                            drawImage.fillRect(10 + (50 * a), 10 + (50 * b), 50, 50);
                            addPoint = false;
                            player2_first = true;
                        }
                    } else if (moveIN.player1_List_move.size() == moveIN.player2_List_move.size() && putIN.player1_List_put.size() > putIN.player2_List_put.size()) {
                        // if its the first put for playerB
                        if(player2_first_put) {
                            // if its conform to the rules
                            if(Regelcheck.ifBPutRight()==true) {
                                Spielefield.Field[a][b] = Spielefield.Field[a][b] + 1;
                                putIN.putB();
                                drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.2f));
                                drawImage.setColor(Add.player2.getColor());
                                drawImage.fillRect(10 + (50 * a), 10 + (50 * b), 50, 50);
                                drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1.0f));
                                drawImage.setColor(Color.BLACK);
                                drawImage.drawString(Field[a][b] + "", 10 + (50 * a) + 25, 10 + (50 * b) + 30);
                                addPoint = false;
                                player2_first_put = true;
                            }else{
                                break;
                            }
                        }else{
                            Spielefield.Field[a][b] = Spielefield.Field[a][b] + 1;
                            putIN.putB();
                            drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.2f));
                            drawImage.setColor(Add.player2.getColor());
                            drawImage.fillRect(10 + (50 * a), 10 + (50 * b), 50, 50);
                            drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1.0f));
                            drawImage.setColor(Color.BLACK);
                            drawImage.drawString(Field[a][b] + "", 10 + (50 * a) + 25, 10 + (50 * b) + 30);
                            addPoint = false;
                            player2_first_put=true;
                        }
                    }
                }
            }

    }
    // MouseListener method implementation
    public void mousePressed(MouseEvent e) {
            addPoint = true;
            // find the MousePosition of Field System
        ListOfPosition.add(new Position(e.getX(), e.getY()));
            a = Math.round((e.getX() - 10) / 50);
            b = Math.round((e.getY() - 10) / 50);
            // calling the repaint() method
            repaint();
    }
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
}
