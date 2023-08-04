/**
 * modified by  Youran Wang (719511)
 * and by Finn Hinrichs (712699)
 */
package tnt.spiele;

import tnt.enginee.Position;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class SpielefieldGods extends Canvas implements MouseListener {
    // set a Matrix with n*n as Spielefield
    // size n could be changed
    public static int Field[][] = new int[6][6];
    // the parameter of position and boolean
    public static int a;
    public static int b;
    public static boolean WinA;
    public static boolean WinB;
    public static boolean ifkuppelA;
    public static boolean ifkuppelB;
    //variables to see if card effect is being used
    public static boolean ifGodCardA;
    public static boolean ifGodCardB;
    //variables to track how often cardeffect has been used
    public static int gcuA;
    public static int gcuB;
    //variable for tracking demeters card effect
    private static Position alreadybuilt;
    private static boolean player1_first;
    private static boolean player2_first;
    //variables to see if the pawns have been set
    private static boolean pl1_p1_first;
    private static boolean pl1_p2_first;
    private static boolean pl2_p1_first;
    private static boolean pl2_p2_first;
    public static boolean addPoint;
    public static Graphics2D drawImage;
    private List V_array=new ArrayList<>();

    // print the Spielefield with awt and Canvas application
    public SpielefieldGods() {
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
        addPoint=false;
        WinA=false;
        WinB=false;
        
        ifGodCardA = false;
        ifGodCardB = false;
        gcuA = 0;
        gcuB = 0;
        //variables to see if the pawns have all been set, didn't work with them all being first for some reason
        pl1_p1_first= false;
        pl1_p2_first= true;
        pl2_p1_first = false;
        pl2_p2_first = true;
        initview();
    }
    // the Frame of playboard
    public static void initview(){
        // creating an object to the Jframe class
    	if(		AddGods.player1.getGodCard().getGodNumber() >= 4 &&
    			AddGods.player1.getGodCard().getGodNumber() <= 6 &&
    			AddGods.player2.getGodCard().getGodNumber() >= 4 &&
    			AddGods.player2.getGodCard().getGodNumber() <= 6) {
    		JFrame jFrame = new JFrame();
            jFrame.setLocationRelativeTo(null);
            jFrame.setBounds(500, 500, 600, 500);
            jFrame.setVisible(true);
            // set the button
            JButton jButtonA = new JButton("Kuppel for :"+ AddGods.player1.getName());
            jButtonA.setBounds(350,30,200,40);
            jButtonA.addActionListener(e -> {
                ifkuppelA=true;
            });
            jFrame.add(jButtonA);
            
            JButton jButtonB = new JButton("Kuppel for :" +AddGods.player2.getName());
            jButtonB.setBounds(350,210,200,40);
            jButtonB.addActionListener(e -> {
                ifkuppelB=true;
            });
            jFrame.add(jButtonB);
            
            JButton jButtonC = new JButton("Godcard :" +AddGods.player1.getGodCard().getGodName());
            jButtonC.setBounds(350,90,200,40);
            jButtonC.addActionListener(e -> {
            	JOptionPane.showMessageDialog(null, AddGods.player1.getGodCard().getGodCardEffect());
            });
            jFrame.add(jButtonC);
            
            JButton jButtonD = new JButton("Godcard :" +AddGods.player2.getGodCard().getGodName());
            jButtonD.setBounds(350,270,200,40);
            jButtonD.addActionListener(e -> {
            	JOptionPane.showMessageDialog(null, AddGods.player2.getGodCard().getGodCardEffect());
            });
            jFrame.add(jButtonD);
            
            JButton jButtonE = new JButton("Use CardEffect :" +AddGods.player1.getGodCard().getGodName());
            jButtonE.setBounds(350,150,200,40);
            jButtonE.addActionListener(e -> {
            	ifGodCardA = true;
            });
            jFrame.add(jButtonE);
            
            JButton jButtonF = new JButton("Use CardEffect :" +AddGods.player2.getGodCard().getGodName());
            jButtonF.setBounds(350,330,200,40);
            jButtonF.addActionListener(e -> {
            	ifGodCardB = true;
            });
            jFrame.add(jButtonF);

            SpielefieldGods Spielefield=new SpielefieldGods();
            Spielefield.setBounds(0,0, 500, 500);
            jFrame.add(Spielefield);
            jFrame.setVisible(true);
    	}else if(AddGods.player1.getGodCard().getGodNumber() >= 4 &&
    			AddGods.player1.getGodCard().getGodNumber() <= 6) {
    		JFrame jFrame = new JFrame();
            jFrame.setLocationRelativeTo(null);
            jFrame.setBounds(500, 500, 600, 500);
            jFrame.setVisible(true);
            // set the button
            JButton jButtonA = new JButton("Kuppel for :"+ AddGods.player1.getName());
            jButtonA.setBounds(350,30,200,40);
            jButtonA.addActionListener(e -> {
                ifkuppelA=true;
            });
            jFrame.add(jButtonA);
            
            JButton jButtonB = new JButton("Kuppel for :" +AddGods.player2.getName());
            jButtonB.setBounds(350,210,200,40);
            jButtonB.addActionListener(e -> {
                ifkuppelB=true;
            });
            jFrame.add(jButtonB);
            
            JButton jButtonC = new JButton("Godcard :" +AddGods.player1.getGodCard().getGodName());
            jButtonC.setBounds(350,90,200,40);
            jButtonC.addActionListener(e -> {
            	JOptionPane.showMessageDialog(null, AddGods.player1.getGodCard().getGodCardEffect());
            });
            jFrame.add(jButtonC);
            
            JButton jButtonD = new JButton("Godcard :" +AddGods.player2.getGodCard().getGodName());
            jButtonD.setBounds(350,270,200,40);
            jButtonD.addActionListener(e -> {
            	JOptionPane.showMessageDialog(null, AddGods.player2.getGodCard().getGodCardEffect());
            });
            jFrame.add(jButtonD);
            
            JButton jButtonE = new JButton("Use CardEffect :" +AddGods.player1.getGodCard().getGodName());
            jButtonE.setBounds(350,150,200,40);
            jButtonE.addActionListener(e -> {
            	ifGodCardA = true;
            });
            jFrame.add(jButtonE);

            SpielefieldGods Spielefield=new SpielefieldGods();
            Spielefield.setBounds(0,0, 500, 500);
            jFrame.add(Spielefield);
            jFrame.setVisible(true);
    	}else if(AddGods.player2.getGodCard().getGodNumber() >= 4 &&
    			AddGods.player2.getGodCard().getGodNumber() <= 6) {
    		JFrame jFrame = new JFrame();
            jFrame.setLocationRelativeTo(null);
            jFrame.setBounds(500, 500, 600, 500);
            jFrame.setVisible(true);
            // set the button
            JButton jButtonA = new JButton("Kuppel for :"+ AddGods.player1.getName());
            jButtonA.setBounds(350,30,200,40);
            jButtonA.addActionListener(e -> {
                ifkuppelA=true;
            });
            jFrame.add(jButtonA);
            
            JButton jButtonB = new JButton("Kuppel for :" +AddGods.player2.getName());
            jButtonB.setBounds(350,150,200,40);
            jButtonB.addActionListener(e -> {
                ifkuppelB=true;
            });
            jFrame.add(jButtonB);
            
            JButton jButtonC = new JButton("Godcard :" +AddGods.player1.getGodCard().getGodName());
            jButtonC.setBounds(350,90,200,40);
            jButtonC.addActionListener(e -> {
            	JOptionPane.showMessageDialog(null, AddGods.player1.getGodCard().getGodCardEffect());
            });
            jFrame.add(jButtonC);
            
            JButton jButtonD = new JButton("Godcard :" +AddGods.player2.getGodCard().getGodName());
            jButtonD.setBounds(350,210,200,40);
            jButtonD.addActionListener(e -> {
            	JOptionPane.showMessageDialog(null, AddGods.player2.getGodCard().getGodCardEffect());
            });
            jFrame.add(jButtonD);
            
            JButton jButtonF = new JButton("Use CardEffect :" +AddGods.player2.getGodCard().getGodName());
            jButtonF.setBounds(350,270,200,40);
            jButtonF.addActionListener(e -> {
            	ifGodCardB = true;
            });
            jFrame.add(jButtonF);

            SpielefieldGods Spielefield=new SpielefieldGods();
            Spielefield.setBounds(0,0, 500, 500);
            jFrame.add(Spielefield);
            jFrame.setVisible(true);
    	}else {
    		JFrame jFrame = new JFrame();
            jFrame.setLocationRelativeTo(null);
            jFrame.setBounds(500, 500, 600, 500);
            jFrame.setVisible(true);
            // set the button
            JButton jButtonA = new JButton("Kuppel for :"+ AddGods.player1.getName());
            jButtonA.setBounds(350,30,200,40);
            jButtonA.addActionListener(e -> {
                ifkuppelA=true;
            });
            jFrame.add(jButtonA);
            
            JButton jButtonB = new JButton("Kuppel for :" +AddGods.player2.getName());
            jButtonB.setBounds(350,150,200,40);
            jButtonB.addActionListener(e -> {
                ifkuppelB=true;
            });
            jFrame.add(jButtonB);
            
            JButton jButtonC = new JButton("Godcard :" +AddGods.player1.getGodCard().getGodName());
            jButtonC.setBounds(350,90,200,40);
            jButtonC.addActionListener(e -> {
            	JOptionPane.showMessageDialog(null, AddGods.player1.getGodCard().getGodCardEffect());
            });
            jFrame.add(jButtonC);
            
            JButton jButtonD = new JButton("Godcard :" +AddGods.player2.getGodCard().getGodName());
            jButtonD.setBounds(350,210,200,40);
            jButtonD.addActionListener(e -> {
            	JOptionPane.showMessageDialog(null, AddGods.player2.getGodCard().getGodCardEffect());
            });
            jFrame.add(jButtonD);

            SpielefieldGods Spielefield=new SpielefieldGods();
            Spielefield.setBounds(0,0, 500, 500);
            jFrame.add(Spielefield);
            jFrame.setVisible(true);
    	}


    }
    public static void main(String args[]) {
    }
    // paint() method
    public void paint(Graphics g) {
        // calling the paint method present in the super class or parent class
        super.paint(g);
        drawImage = (Graphics2D) g;
        for (int i = 0; i < Field.length; i++) {
            for (int j = 0; j < Field[i].length; j++) {
                // always paint the rectangle for the Spielefield
                drawImage.drawRect(10+(50*i), 10+(50*j), 50 ,50);
                // always paint the Number of Stage for this Building
                drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1.0f));
                drawImage.setColor(Color.BLACK);
                drawImage.drawString(Field[i][j] + "", 10 + (50 * i) + 25, 10 + (50 * j) + 30);
                // The Position, which player1 was builded, will always paint.
                for(int q = 0; q< putIN.player1_List_put.size();q++){
                    if(putIN.player1_put_x.get(q)==j && putIN.player1_put_y.get(q)==i) {
                        drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.2f));
                        drawImage.setColor(Color.RED);
                        drawImage.fillRect(10 + (50 * putIN.player1_put_x.get(q)), 10 + (50 * putIN.player1_put_y.get(q)), 50, 50);
                    }
                }
                // The Position, which player2 was builded, will always paint.
                for(int w = 0; w< putIN.player2_List_put.size();w++){
                    if(putIN.player2_put_x.get(w)==j && putIN.player2_put_y.get(w)==i) {
                        drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.2f));
                        drawImage.setColor(Color.BLUE);
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
/*
        for(int i = 0; i< putIN.player1_List_put.size();i++){
            drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.2f));
            drawImage.setColor(Color.RED);
            drawImage.fillRect(10+(50*putIN.player1_put_x.get(i)), 10+(50*putIN.player1_put_y.get(i)), 50 ,50);
        }

        for(int i = 0; i< putIN.player2_List_put.size();i++){
            drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.2f));
            drawImage.setColor(Color.BLUE);
            drawImage.fillRect(10+(50*putIN.player2_put_x.get(i)), 10+(50*putIN.player2_put_y.get(i)), 50 ,50);

        }

        for(int i = 0; i< kuppel.player_List_kuppel.size();i++){
            drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1.0f));
            drawImage.setColor(Color.BLACK);
            drawImage.fillRect(10+(50*kuppel.kuppel_put_x.get(i)), 10+(50*kuppel.kuppel_put_y.get(i)), 50 ,50);

        }

        */
        
        // the Position of Engineer for player1 should be paint in Spielefield
        if(player1_first){
            drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.5f));
            drawImage.setColor(Color.RED);
            drawImage.fillRect(10+(50*moveIN.player1_move_x[moveIN.player1_move_x.length-1]), 10+(50*moveIN.player1_move_y[moveIN.player1_move_y.length-1]), 50 ,50);
        }
        // the Position of Engineer for player2 should be paint in Spielefield
        if(player2_first){
            drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.5f));
            drawImage.setColor(Color.BLUE);
            drawImage.fillRect(10+(50*moveIN.player2_move_x[moveIN.player2_move_x.length-1]), 10+(50*moveIN.player2_move_y[moveIN.player2_move_y.length-1]), 50 ,50);
        }

            // press the mouse and get the action
            while(addPoint) {
            	System.out.print(V_array.size());
                //Position e = e_2.nextElement();
                int z_a = a + 1;
                int z_b = b + 1;
                //ints for more compact if statements
                int pl1ms = moveINGods.player1_pawn1_List_move.size() + moveINGods.player1_pawn2_List_move.size();
                int pl2ms = moveINGods.player2_pawn1_List_move.size() + moveINGods.player2_pawn2_List_move.size();
                int pl1ps = putINGods.player1_List_put.size() - gcuA;
                int pl2ps = putINGods.player1_List_put.size() - gcuB;
                //int player1_put_size = putINGods.player1.
                // print the position of press
                System.out.println("Mouse at :" + z_a + " , " + z_b);
                System.out.println(ifkuppelA);
                System.out.println(ifkuppelB);
                // if need a kuppel
                if (ifkuppelA) {
                	SpielefieldGods.Field[a][b] = 9;
                    kuppel.kuppelA();
                    drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1.0f));
                    drawImage.setColor(Color.BLACK);
                    drawImage.fillRect(10 + (50 * a), 10 + (50 * b), 50, 50);
                    ifkuppelA = false;
                } else if (ifkuppelB) {
                    SpielefieldGods.Field[a][b] = 9;
                    kuppel.kuppelB();
                    drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1.0f));
                    drawImage.setColor(Color.BLACK);
                    drawImage.fillRect(10 + (50 * a), 10 + (50 * b), 50, 50);
                    ifkuppelB = false;
                } else {
                	System.out.println(pl1ms);
                	System.out.println(pl2ms);
                	System.out.println(pl1ps);
                	System.out.println(pl2ps);
                	// pl1 p1 set -- pl2 p1 set -- pl1 p2 set -- pl2 p2 set--
                	if(pl1ms == pl2ms && pl1ps == pl2ps) {//moveINGods player1
                		if(!pl1_p1_first && pl1_p2_first) {
                			moveINGods.moveA();
                            System.out.println("Player 1 has set Pawn 1");
                            drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.5f));
                            drawImage.setColor(Color.RED);
                            drawImage.fillRect(10 + (50 * a), 10 + (50 * b), 50, 50);
                            pl1_p1_first = true;
                            pl1_p2_first = false;
                            addPoint = false;
                            
                		}else if(!pl1_p2_first){
                			moveINGods.moveC();
                            System.out.println("Player 1 has set Pawn 2 ");
                            drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.5f));
                            drawImage.setColor(Color.ORANGE);
                            drawImage.fillRect(10 + (50 * a), 10 + (50 * b), 50, 50);
                            pl1_p2_first = true;
                            pl1_p1_first = false;
                            addPoint = false;
                            
                		}else {//player1 normal move

                        	System.out.println("Player1 has set both pawns");
                			if(moveINGods.selectPl1_p1 || moveINGods.selectPl1_p2) {
                				if(moveINGods.selectPl1_p1) {
                    				if(RegelcheckGods.ifAMoveRight()) {
                    					Regelcheck.ifAwin();
                    					moveINGods.moveA();
                                        System.out.println("should colors");
                                        drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.5f));
                                        drawImage.setColor(Color.RED);
                                        drawImage.fillRect(10 + (50 * a), 10 + (50 * b), 50, 50);
                                        addPoint = false;
                                        putINGods.pl1_p1_moved = true;
                        				moveINGods.selectPl1_p1 = false;
                    				}else {
                    					addPoint = false;
                    					break;
                    				}
                    				
                    			}else if(moveINGods.selectPl1_p2) {
                    				if(RegelcheckGods.ifCMoveRight()) {
                    					Regelcheck.ifAwin();
                    					moveINGods.moveC();
                                        System.out.println("should colors");
                                        drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.5f));
                                        drawImage.setColor(Color.ORANGE);
                                        drawImage.fillRect(10 + (50 * a), 10 + (50 * b), 50, 50);
                                        addPoint = false;
                                        putINGods.pl1_p2_moved = true;
                        				moveINGods.selectPl1_p2 = false;
                    				}else {
                    					addPoint = false;
                    					break;
                    				}
                    				
                    			}
                			}else {
                				System.out.println("Player 1 selecting pawn");
                				moveINGods.selectPawnPl1();
                				addPoint = false;
                				break;
                			}
                			
                		}
                	}else if(pl1ms > pl2ms && pl1ps == pl2ps && pl1_p1_first && pl1_p2_first) {//putINGods player 1
                		if(putINGods.pl1_p1_moved) {
                			if(ifGodCardA) {
                				if(AddGods.player1.getGodCard().getGodNumber() == 4) {
                					kuppel.kuppelA();
                				}else if(AddGods.player1.getGodCard().getGodNumber() == 5) {
                					if(RegelcheckGods.ifAPutRight()) {
                						SpielefieldGods.Field[a][b] = SpielefieldGods.Field[a][b] + 1;
                						putINGods.putA();
                						System.out.println("should number");
                                        drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.2f));
                                        drawImage.setColor(Color.RED);
                                        drawImage.fillRect(10 + (50 * a), 10 + (50 * b), 50, 50);
                                        drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1.0f));
                                        drawImage.setColor(Color.BLACK);
                                        drawImage.drawString(Field[a][b] + "", 10 + (50 * a) + 25, 10 + (50 * b) + 30);
                						alreadybuilt = new Position(a,b);
                						gcuA ++;
                						ifGodCardA = false;
                						addPoint = false;
                					}else {
                						addPoint = false;
                						break;
                					}
                				}else if(RegelcheckGods.ifAPutRight()) {
                						SpielefieldGods.Field[a][b] = SpielefieldGods.Field[a][b] + 1;
                						putINGods.putA();
                						System.out.println("should number");
                                        drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.2f));
                                        drawImage.setColor(Color.RED);
                                        drawImage.fillRect(10 + (50 * a), 10 + (50 * b), 50, 50);
                                        drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1.0f));
                                        drawImage.setColor(Color.BLACK);
                                        drawImage.drawString(Field[a][b] + "", 10 + (50 * a) + 25, 10 + (50 * b) + 30);
                						if(RegelcheckGods.ifAPutRight()) {
                							SpielefieldGods.Field[a][b] = SpielefieldGods.Field[a][b] + 1;
                							putINGods.putA();
                							System.out.println("should number");
                                            drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.2f));
                                            drawImage.setColor(Color.RED);
                                            drawImage.fillRect(10 + (50 * a), 10 + (50 * b), 50, 50);
                                            drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1.0f));
                                            drawImage.setColor(Color.BLACK);
                                            drawImage.drawString(Field[a][b] + "", 10 + (50 * a) + 25, 10 + (50 * b) + 30);
                    						gcuA ++;
                    					}
                						ifGodCardA = false;
                						addPoint = false;
                					
                				}else {
                					addPoint = false;
                					break;
                				}
                				//gcuA ++;
                			}else {
                				if(AddGods.player1.getGodCard().getGodNumber() == 5) {
                					if(RegelcheckGods.ifAPutRight() && !(SpielefieldGods.a == alreadybuilt.getX() && SpielefieldGods.b == alreadybuilt.getY())) {
                						SpielefieldGods.Field[a][b] = SpielefieldGods.Field[a][b] + 1;
                						putINGods.putA();
                						System.out.println("should number");
                                        drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.2f));
                                        drawImage.setColor(Color.RED);
                                        drawImage.fillRect(10 + (50 * a), 10 + (50 * b), 50, 50);
                                        drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1.0f));
                                        drawImage.setColor(Color.BLACK);
                                        drawImage.drawString(Field[a][b] + "", 10 + (50 * a) + 25, 10 + (50 * b) + 30);
                                        addPoint = false;
                					}else {
                						addPoint = false;
                						break;
                					}
                				}else {
                					SpielefieldGods.Field[a][b] = SpielefieldGods.Field[a][b] + 1;
                                    putINGods.putA();
                                    System.out.println("should number");
                                    drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.2f));
                                    drawImage.setColor(Color.RED);
                                    drawImage.fillRect(10 + (50 * a), 10 + (50 * b), 50, 50);
                                    drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1.0f));
                                    drawImage.setColor(Color.BLACK);
                                    drawImage.drawString(Field[a][b] + "", 10 + (50 * a) + 25, 10 + (50 * b) + 30);
                                    addPoint = false;
                				}
                			}
                            /*System.out.println("should number");
                            drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.2f));
                            drawImage.setColor(Color.RED);
                            drawImage.fillRect(10 + (50 * a), 10 + (50 * b), 50, 50);
                            drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1.0f));
                            drawImage.setColor(Color.BLACK);
                            drawImage.drawString(Field[a][b] + "", 10 + (50 * a) + 25, 10 + (50 * b) + 30);*/
                            addPoint = false;
                			
                		}else if(putINGods.pl1_p2_moved){
                			if(ifGodCardA) {
                				if(AddGods.player1.getGodCard().getGodNumber() == 4) {
                					kuppel.kuppelA();
                				}else if(AddGods.player1.getGodCard().getGodNumber() == 5) {
                					if(RegelcheckGods.ifCPutRight()) {
                						SpielefieldGods.Field[a][b] = SpielefieldGods.Field[a][b] + 1;
                						putINGods.putA();
                						System.out.println("should number");
                		                drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.2f));
                		                drawImage.setColor(Color.ORANGE);
                		                drawImage.fillRect(10 + (50 * a), 10 + (50 * b), 50, 50);
                		                drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1.0f));
                		                drawImage.setColor(Color.BLACK);
                		                drawImage.drawString(Field[a][b] + "", 10 + (50 * a) + 25, 10 + (50 * b) + 30);
                						alreadybuilt = new Position(a,b);
                						gcuA ++;
                						ifGodCardA = false;
                						addPoint = false;
                					}
                				}else if(RegelcheckGods.ifCPutRight()) {
                						SpielefieldGods.Field[a][b] = SpielefieldGods.Field[a][b] + 1;
                						putINGods.putA();
                						System.out.println("should number");
                		                drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.2f));
                		                drawImage.setColor(Color.ORANGE);
                		                drawImage.fillRect(10 + (50 * a), 10 + (50 * b), 50, 50);
                		                drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1.0f));
                		                drawImage.setColor(Color.BLACK);
                		                drawImage.drawString(Field[a][b] + "", 10 + (50 * a) + 25, 10 + (50 * b) + 30);
                						if(RegelcheckGods.ifCPutRight()) {
                							SpielefieldGods.Field[a][b] = SpielefieldGods.Field[a][b] + 1;
                							putINGods.putA();
                							System.out.println("should number");
                		                    drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.2f));
                		                    drawImage.setColor(Color.ORANGE);
                		                    drawImage.fillRect(10 + (50 * a), 10 + (50 * b), 50, 50);
                		                    drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1.0f));
                		                    drawImage.setColor(Color.BLACK);
                		                    drawImage.drawString(Field[a][b] + "", 10 + (50 * a) + 25, 10 + (50 * b) + 30);
                							gcuA ++;
                						}
                						ifGodCardA = false;
                						addPoint = false;
                					
                				}else {
                					addPoint = false;
                					break;
                				}
                				//gcuA ++;
                			}else {
                				if(AddGods.player1.getGodCard().getGodNumber() == 5) {
                					if(RegelcheckGods.ifCPutRight() && !(SpielefieldGods.a == alreadybuilt.getX() && SpielefieldGods.b == alreadybuilt.getY())) {
                						SpielefieldGods.Field[a][b] = SpielefieldGods.Field[a][b] + 1;
                						putINGods.putA();
                						System.out.println("should number");
                		                drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.2f));
                		                drawImage.setColor(Color.ORANGE);
                		                drawImage.fillRect(10 + (50 * a), 10 + (50 * b), 50, 50);
                		                drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1.0f));
                		                drawImage.setColor(Color.BLACK);
                		                drawImage.drawString(Field[a][b] + "", 10 + (50 * a) + 25, 10 + (50 * b) + 30);
                		                addPoint = false;
                					}
                				}else {
                					SpielefieldGods.Field[a][b] = SpielefieldGods.Field[a][b] + 1;
                		            putIN.putA();
                		            System.out.println("should number");
                		            drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.2f));
                		            drawImage.setColor(Color.ORANGE);
                		            drawImage.fillRect(10 + (50 * a), 10 + (50 * b), 50, 50);
                		            drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1.0f));
                		            drawImage.setColor(Color.BLACK);
                		            drawImage.drawString(Field[a][b] + "", 10 + (50 * a) + 25, 10 + (50 * b) + 30);
                		            addPoint = false;
                				}
                			}
                		    /*System.out.println("should number");
                		    drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.2f));
                		    drawImage.setColor(Color.RED);
                		    drawImage.fillRect(10 + (50 * a), 10 + (50 * b), 50, 50);
                		    drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1.0f));
                		    drawImage.setColor(Color.BLACK);
                		    drawImage.drawString(Field[a][b] + "", 10 + (50 * a) + 25, 10 + (50 * b) + 30);*/
                		    addPoint = false;
                		    break;
                		}
                	}else if(pl1ms > pl2ms && pl1ps > pl2ps || pl1ms > pl2ms && pl1ps == pl2ps && (!pl1_p2_first || !pl1_p1_first) || pl1ps ==  0 && pl2ps == 0) {//moveINGods player 2
                		if(!pl2_p1_first) {
                			moveINGods.moveB();
                			System.out.println("PLayer 2 has set Pawn 1");
                            drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.5f));
                            drawImage.setColor(Color.BLUE);
                            drawImage.fillRect(10 + (50 * a), 10 + (50 * b), 50, 50);
                            pl2_p1_first = true;
                            pl2_p2_first = false;
                            System.out.println("pl2_p2_first = "+ pl2_p2_first);
                            System.out.println(pl1ps + pl2ps);
                            addPoint = false;
                            break;
                            
                		}else if(!pl2_p2_first || pl1ps == 0){
                			moveINGods.moveD();
                			System.out.println("Player 2 has set pawn 2");
                            drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.5f));
                            drawImage.setColor(Color.GREEN);
                            drawImage.fillRect(10 + (50 * a), 10 + (50 * b), 50, 50);
                            pl2_p2_first = true;
                            pl1_p1_first = true;
                            addPoint = false;
                            break;
                            
                		}else {//player2 move normally
                			if(moveINGods.selectPl2_p1 || moveINGods.selectPl2_p2) {
                				if(moveINGods.selectPl2_p1) {// checks which pawn has been selected
                    				if(RegelcheckGods.ifBMoveRight()) {
                    					Regelcheck.ifBwin();
                    					moveINGods.moveB();
                            			System.out.println("should color");
                                        drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.5f));
                                        drawImage.setColor(Color.BLUE);
                                        drawImage.fillRect(10 + (50 * a), 10 + (50 * b), 50, 50);
                                        addPoint = false;
                                        putINGods.pl2_p1_moved = true;
                        				moveINGods.selectPl2_p1 = false;
                    				}else {
                    					addPoint = false;
                    					break;
                    				}
                    			}else if(moveINGods.selectPl2_p2) {
                    				if(RegelcheckGods.ifDMoveRight()) {
                    					Regelcheck.ifBwin();
                    					moveINGods.moveD();
                            			System.out.println("should color");
                                        drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.5f));
                                        drawImage.setColor(Color.GREEN);
                                        drawImage.fillRect(10 + (50 * a), 10 + (50 * b), 50, 50);
                                        addPoint = false;
                                        putINGods.pl2_p2_moved = true;
                        				moveINGods.selectPl2_p2 = false;
                    				}else {
                    					addPoint = false;
                    					break;
                    				}
                    				
                    			}
                			}else {
                				moveINGods.selectPawnPl2();
                				addPoint = false;
                				break;
                			}
                			
                		}
                	}else if(pl1ms == pl2ms && pl1ps > pl2ps && pl1_p1_first && pl1_p2_first) {//putINGods player 2
                		if(putINGods.pl2_p1_moved) {
                			if(ifGodCardB) {
                				if(AddGods.player1.getGodCard().getGodNumber() == 4) {
                					kuppel.kuppelB();
                				}else if(AddGods.player1.getGodCard().getGodNumber() == 5) {
                					if(RegelcheckGods.ifBPutRight()) {
                						SpielefieldGods.Field[a][b] = SpielefieldGods.Field[a][b] + 1;
                						putINGods.putB();
                						System.out.println("should number");
                		                drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.2f));
                		                drawImage.setColor(Color.BLUE);
                		                drawImage.fillRect(10 + (50 * a), 10 + (50 * b), 50, 50);
                		                drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1.0f));
                		                drawImage.setColor(Color.BLACK);
                		                drawImage.drawString(Field[a][b] + "", 10 + (50 * a) + 25, 10 + (50 * b) + 30);
                						alreadybuilt = new Position(a,b);
                						gcuA ++;
                						ifGodCardB = false;
                						addPoint = false;
                					}else {
                						addPoint = false;
                						break;
                					}
                				}else {
                					if(RegelcheckGods.ifBPutRight()) {
                						SpielefieldGods.Field[a][b] = SpielefieldGods.Field[a][b] + 1;
                						putINGods.putB();
                						System.out.println("should number");
                		                drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.2f));
                		                drawImage.setColor(Color.BLUE);
                		                drawImage.fillRect(10 + (50 * a), 10 + (50 * b), 50, 50);
                		                drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1.0f));
                		                drawImage.setColor(Color.BLACK);
                		                drawImage.drawString(Field[a][b] + "", 10 + (50 * a) + 25, 10 + (50 * b) + 30);
                						if(RegelcheckGods.ifBPutRight()) {
                							SpielefieldGods.Field[a][b] = SpielefieldGods.Field[a][b] + 1;
                							putINGods.putB();
                							System.out.println("should number");
                		                    drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.2f));
                		                    drawImage.setColor(Color.BLUE);
                		                    drawImage.fillRect(10 + (50 * a), 10 + (50 * b), 50, 50);
                		                    drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1.0f));
                		                    drawImage.setColor(Color.BLACK);
                		                    drawImage.drawString(Field[a][b] + "", 10 + (50 * a) + 25, 10 + (50 * b) + 30);
                							gcuA ++;
                						}
                						ifGodCardB = false;
                						addPoint = false;
                					}else {
                						addPoint = false;
                						break;
                					}
                				}
                				//gcuA ++;
                			}else {
                				if(AddGods.player1.getGodCard().getGodNumber() == 5) {
                					if(RegelcheckGods.ifBPutRight() && !(SpielefieldGods.a == alreadybuilt.getX() && SpielefieldGods.b == alreadybuilt.getY())) {
                						SpielefieldGods.Field[a][b] = SpielefieldGods.Field[a][b] + 1;
                						putINGods.putB();
                						System.out.println("should number");
                		                drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.2f));
                		                drawImage.setColor(Color.BLUE);
                		                drawImage.fillRect(10 + (50 * a), 10 + (50 * b), 50, 50);
                		                drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1.0f));
                		                drawImage.setColor(Color.BLACK);
                		                drawImage.drawString(Field[a][b] + "", 10 + (50 * a) + 25, 10 + (50 * b) + 30);
                		                addPoint = false;
                					}
                				}else {
                					SpielefieldGods.Field[a][b] = SpielefieldGods.Field[a][b] + 1;
                		            putINGods.putB();
                		            System.out.println("should number");
                		            drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.2f));
                		            drawImage.setColor(Color.BLUE);
                		            drawImage.fillRect(10 + (50 * a), 10 + (50 * b), 50, 50);
                		            drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1.0f));
                		            drawImage.setColor(Color.BLACK);
                		            drawImage.drawString(Field[a][b] + "", 10 + (50 * a) + 25, 10 + (50 * b) + 30);
                		            addPoint = false;
                				}
                			}
                		    /*System.out.println("should number");
                		    drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.2f));
                		    drawImage.setColor(Color.RED);
                		    drawImage.fillRect(10 + (50 * a), 10 + (50 * b), 50, 50);
                		    drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1.0f));
                		    drawImage.setColor(Color.BLACK);
                		    drawImage.drawString(Field[a][b] + "", 10 + (50 * a) + 25, 10 + (50 * b) + 30);*/
                		    addPoint = false;
                		}else if(putINGods.pl2_p2_moved) {
                			if(ifGodCardB) {
                				if(AddGods.player1.getGodCard().getGodNumber() == 4) {
                					kuppel.kuppelB();
                				}else if(AddGods.player1.getGodCard().getGodNumber() == 5) {
                					if(RegelcheckGods.ifDPutRight()) {
                						SpielefieldGods.Field[a][b] = SpielefieldGods.Field[a][b] + 1;
                						putINGods.putB();
                						System.out.println("should number");
                		                drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.2f));
                		                drawImage.setColor(Color.BLUE);
                		                drawImage.fillRect(10 + (50 * a), 10 + (50 * b), 50, 50);
                		                drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1.0f));
                		                drawImage.setColor(Color.BLACK);
                		                drawImage.drawString(Field[a][b] + "", 10 + (50 * a) + 25, 10 + (50 * b) + 30);
                						alreadybuilt = new Position(a,b);
                						gcuA ++;
                						ifGodCardB = false;
                						addPoint = false;
                					}else {
                						addPoint = false;
                						break;
                					}
                				}else {
                					if(RegelcheckGods.ifDPutRight()) {
                						SpielefieldGods.Field[a][b] = SpielefieldGods.Field[a][b] + 1;
                						putINGods.putB();
                						System.out.println("should number");
                		                drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.2f));
                		                drawImage.setColor(Color.BLUE);
                		                drawImage.fillRect(10 + (50 * a), 10 + (50 * b), 50, 50);
                		                drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1.0f));
                		                drawImage.setColor(Color.BLACK);
                		                drawImage.drawString(Field[a][b] + "", 10 + (50 * a) + 25, 10 + (50 * b) + 30);
                						if(RegelcheckGods.ifDPutRight()) {
                							SpielefieldGods.Field[a][b] = SpielefieldGods.Field[a][b] + 1;
                							putINGods.putB();
                							System.out.println("should number");
                		                    drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.2f));
                		                    drawImage.setColor(Color.BLUE);
                		                    drawImage.fillRect(10 + (50 * a), 10 + (50 * b), 50, 50);
                		                    drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1.0f));
                		                    drawImage.setColor(Color.BLACK);
                		                    drawImage.drawString(Field[a][b] + "", 10 + (50 * a) + 25, 10 + (50 * b) + 30);
                							gcuA ++;
                						}
                						ifGodCardB = false;
                						addPoint = false;
                					}else {
                						break;
                					}
                				}
                				//gcuA ++;
                			}else {
                				if(AddGods.player1.getGodCard().getGodNumber() == 5) {
                					if(RegelcheckGods.ifDPutRight() && !(SpielefieldGods.a == alreadybuilt.getX() && SpielefieldGods.b == alreadybuilt.getY())) {
                						SpielefieldGods.Field[a][b] = SpielefieldGods.Field[a][b] + 1;
                						putINGods.putB();
                						System.out.println("should number");
                		                drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.2f));
                		                drawImage.setColor(Color.BLUE);
                		                drawImage.fillRect(10 + (50 * a), 10 + (50 * b), 50, 50);
                		                drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1.0f));
                		                drawImage.setColor(Color.BLACK);
                		                drawImage.drawString(Field[a][b] + "", 10 + (50 * a) + 25, 10 + (50 * b) + 30);
                		                addPoint = false;
                					}else {
                						addPoint = false;
                						break;
                					}
                				}else {
                					SpielefieldGods.Field[a][b] = SpielefieldGods.Field[a][b] + 1;
                		            putINGods.putB();
                		            System.out.println("should number");
                		            drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.2f));
                		            drawImage.setColor(Color.BLUE);
                		            drawImage.fillRect(10 + (50 * a), 10 + (50 * b), 50, 50);
                		            drawImage.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1.0f));
                		            drawImage.setColor(Color.BLACK);
                		            drawImage.drawString(Field[a][b] + "", 10 + (50 * a) + 25, 10 + (50 * b) + 30);
                		            addPoint = false;
                				}
                			}
                		    addPoint = false;
                		}
                	}
                }
            }
            }
    // MouseListener method implementation
    public void mousePressed(MouseEvent e) {
            addPoint = true;
            V_array.add(new Position(e.getX(), e.getY()));
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
