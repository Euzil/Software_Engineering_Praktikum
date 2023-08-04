/**
 * modified by  Youran Wang (719511)
 * and by Fin Hinrichs (712699)
 */
package tnt.spiele;

import tnt.enginee.GodCard;
import tnt.enginee.Pawn;
import tnt.enginee.Player;
import tnt.enginee.PlayerGods;
import tnt.enginee.Position;

import java.awt.*;
import java.util.Random;

import javax.swing.*;
// the Panel for the Setting of Players
public class AddGods extends BeginnGods{
    public static PlayerGods player1;
    public static PlayerGods player2;
    public static JPanel startAGods() {


        player1 = new PlayerGods("", "", new Position(2, 2), new Pawn(new Position(0,0)), new Pawn(new Position(0,0)), new GodCard(0));
        player2 = new PlayerGods("", "", new Position(2, 2), new Pawn(new Position(0,0)), new Pawn(new Position(0,0)), new GodCard(0));

        // Panel intialisierung
        JPanel jPanelA = new JPanel();


        // set the color and Size of Panel
        jPanelA.setBounds(100, 100, 1080, 560);
        jPanelA.setBackground(new Color(200, 200, 200));

        // set the Buttons on the Panel
        JButton jButton1A = new JButton("Name1");
        jButton1A.setBounds(170,30,80,40);

        JButton jButton2A = new JButton("Color1");
        jButton2A.setBounds(260,30,80,40);

        JButton jButton3A = new JButton("Name2");
        jButton3A.setBounds(170,220,80,40);

        JButton jButton4A = new JButton("Color2");
        jButton4A.setBounds(260,220,80,40);

        JButton jButton5A = new JButton("player1 go");
        jButton5A.setBounds(350,30,120,40);

        JButton jButton6A = new JButton("player2 go");
        jButton6A.setBounds(350,220,120,40);
        
        JButton jButton7A = new JButton("GodCard");
        jButton7A.setBounds(100,220,160,80);
        
        JButton jButton8A = new JButton("GodCard");
        jButton8A.setBounds(30,320,160,80);


        JButton jButtonBeginA = new JButton("BEGIN!!!");

        // set the Text of the Panel
        JLabel textLabel1A = new JLabel("player1 :");
        textLabel1A.setFont(new Font(null, Font.PLAIN, 25));
        textLabel1A.setBounds(100,120,160,80);

        JLabel textLabel2A = new JLabel("player2 :");
        textLabel2A.setFont(new Font(null, Font.PLAIN, 25));
        textLabel2A.setBounds(30,220,60,80);

        JLabel textLabelBegin = new JLabel("Begin!!!!!!!!!!");
        textLabelBegin.setFont(new Font(null, Font.PLAIN, 25));


        JLabel textLabel3 = new JLabel(player1.getName()+"--"+player1.getColor()+": ready");
        textLabel3.setFont(new Font(null, Font.PLAIN, 25));

        JLabel textLabel4 = new JLabel(player2.getName()+"--"+player2.getColor()+": ready");
        textLabel4.setFont(new Font(null, Font.PLAIN, 25));


        // add the Buttons on the Panel
        jPanelA.add(textLabel1A);
        jPanelA.add(jButton1A);
        jPanelA.add(jButton2A);
        jPanelA.add(jButton5A);
        jPanelA.add(jButton7A);
        jPanelA.add(textLabel2A);
        jPanelA.add(jButton3A);
        jPanelA.add(jButton4A);
        jPanelA.add(jButton6A);
        jPanelA.add(jButton8A);
        jPanelA.add(jButtonBeginA);

        // typing the name for Player1
        jButton1A.addActionListener(e -> {
            String inputContentName = JOptionPane.showInputDialog(jPanelA, "Your Name :", "player");
            player1.setName(inputContentName);
        });
        // choose the Color for Player1
        jButton2A.addActionListener(e -> {
            Object[] selectionValues = new Object[]{"RED", "BLUE", "YELLOW"};
            Object inputContentColor = JOptionPane.showInputDialog(jPanelA, "Color: ", "Color",
                    JOptionPane.PLAIN_MESSAGE, null, selectionValues, selectionValues[0]);
            player1.setColor((String) inputContentColor);
        });
        // typing the name for Player2
        jButton3A.addActionListener(e -> {

            String inputContentName = JOptionPane.showInputDialog(jPanelA, "Your Name :", "player");
            player2.setName(inputContentName);

        });
        // choose the color for Player2
        jButton4A.addActionListener(e -> {
            Object[] selectionValues = new Object[]{"RED", "BLUE", "YELLOW"};
            Object inputContentColor = JOptionPane.showInputDialog(jPanelA, "Color: ", "Color",
                    JOptionPane.PLAIN_MESSAGE, null, selectionValues, selectionValues[0]);
            player2.setColor((String) inputContentColor);

        });
        // print the Information of Player 1
        jButton5A.addActionListener(e -> {
            player1.print();
        });
        // print the Information of Player 2
        jButton6A.addActionListener(e -> {
            player2.print();
        });
        //select Godcards
        jButton7A.addActionListener(e -> {
        	Integer[] selectionValues = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        	Integer inputContentGodCards = (Integer)JOptionPane.showInputDialog(jPanelA, "God: ", "GodCard", 
        			JOptionPane.PLAIN_MESSAGE, null, selectionValues, selectionValues[0]);
        	player1.setGodCard(new GodCard(inputContentGodCards));
        });
      //who can select godcards per rng
        jButton8A.addActionListener(e -> {
        	Integer[] selectionValues = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        	Integer inputContentGodCards = (Integer)JOptionPane.showInputDialog(jPanelA, "God: ", "GodCard", 
        			JOptionPane.PLAIN_MESSAGE, null, selectionValues, selectionValues[0]);
        	player2.setGodCard(new GodCard(inputContentGodCards));
        });
        // go to the next  Panel
        jButtonBeginA.addActionListener(e -> {
            System.out.println(player1.getName()+"  VS  "+player2.getName());
            jFrame.setContentPane(checkGods.oneMoreLook());
            //check.oneMoreLook2();
        });

        return jPanelA;
    }


    public static void main(String[] args) {

    }
}
