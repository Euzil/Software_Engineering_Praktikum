/**
 * @author Youran Wang : youran.wang@student.uni-luebeck.de
 * modified by  Youran Wang (719511)
 */
package tnt.spiele;

import tnt.enginee.Player;
import tnt.enginee.Position;
import tnt.spiele.Beginn;
import tnt.spiele.check;

import java.awt.*;
import javax.swing.*;
// the Panel for the Setting of Players
/** variable
* player1 : definited player1
* player2 : definited player2
* player3 : definited player3
* player4 : definited player4
* background : the Image of background need be loaded as ImageIcon
* Size : the Size of GameField would be here choose
 */
public class Add extends Beginn {
    public static Player player1;
    public static Player player2;
    public static Player player3;
    public static Player player4;
    private static ImageIcon background;
    public static int Size;

    public static JPanel startA() {

        player1 = new Player("", null, new Position(2, 2));
        player2 = new Player("", null, new Position(2, 2));

        // Panel intialisierung
        JPanel jPanelA = new JPanel();
        jPanelA.setLayout(null);

        // set the color and Size of Panel
        jPanelA.setBounds(50, 50, 1080, 560);
        jPanelA.setBackground(new Color(200, 200, 200));

        // set the Buttons on the Panel
        JButton jButton1A = new JButton("Name1");
        jButton1A.setBounds(270,150,120,40);

        JButton jButton2A = new JButton("Farbe1");
        jButton2A.setBounds(400,150,120,40);

        JButton jButton3A = new JButton("Name2");
        jButton3A.setBounds(270,250,120,40);

        JButton jButton4A = new JButton("Farbe2");
        jButton4A.setBounds(400,250,120,40);

        JButton jButton5A = new JButton("Spieler1 go");
        jButton5A.setBounds(530,150,200,40);

        JButton jButton6A = new JButton("Spieler2 go");
        jButton6A.setBounds(530,250,200,40);


        JButton jButtonBeginA = new JButton("Anfangen!!!");
        jButtonBeginA.setBounds(450,350,160,40);

        JButton jButtonSize = new JButton("Größe");
        jButtonSize.setBounds(270,350,160,40);

        // set the Text of the Panel
        JLabel textLabel1A = new JLabel("Spieler1 :");
        textLabel1A.setFont(new Font(null, Font.PLAIN, 25));
        textLabel1A.setBounds(100,130,160,80);

        JLabel textLabel2A = new JLabel("Spieler2 :");
        textLabel2A.setFont(new Font(null, Font.PLAIN, 25));
        textLabel2A.setBounds(100,230,160,80);

        JLabel textLabelBegin = new JLabel("Begin!!!!!!!!!!");
        textLabelBegin.setFont(new Font(null, Font.PLAIN, 25));

        JLabel textLabel3 = new JLabel(player1.getName()+"--"+player1.getColor()+": ready");
        textLabel3.setFont(new Font(null, Font.PLAIN, 25));

        JLabel textLabel4 = new JLabel(player2.getName()+"--"+player2.getColor()+": ready");
        textLabel4.setFont(new Font(null, Font.PLAIN, 25));

        // set the background of Meun
        background = new ImageIcon("File/santorirni_Game_2.jpg");
        JLabel label = new JLabel(background);
        label.setBounds(0,0,background.getIconWidth(),background.getIconHeight());

        // add the Buttons and background on the Panel
        jPanelA.add(textLabel1A);
        jPanelA.add(jButton1A);
        jPanelA.add(jButton2A);
        jPanelA.add(jButton5A);
        jPanelA.add(textLabel2A);
        jPanelA.add(jButton3A);
        jPanelA.add(jButton4A);
        jPanelA.add(jButton6A);
        jPanelA.add(jButtonBeginA);
        jPanelA.add(jButtonSize);
        jPanelA.add(label);
        // typing the name for Player1
        jButton1A.addActionListener(e -> {
            String inputContentName = JOptionPane.showInputDialog(jPanelA, "Deine Name :", "Name eingebn");
            player1.setName(inputContentName);
        });
        // choose the Color for Player1
        jButton2A.addActionListener(e -> {
            Object[] selectionValues = new Object[]{Color.RED, Color.BLUE, Color.YELLOW, Color.GREEN};
            Object inputContentColor = JOptionPane.showInputDialog(jPanelA, "Farbe: ", "Farbe wählen",
                    JOptionPane.PLAIN_MESSAGE, null, selectionValues, selectionValues[0]);
            player1.setColor((Color)inputContentColor);
        });
        // typing the name for Player2
        jButton3A.addActionListener(e -> {
            String inputContentName = JOptionPane.showInputDialog(jPanelA, "Deine Name :", "Name eingebn");
            player2.setName(inputContentName);
        });
        // choose the color for Player2
        jButton4A.addActionListener(e -> {
            Object[] selectionValues = new Object[]{Color.RED, Color.BLUE, Color.YELLOW, Color.GREEN};
            Object inputContentColor = JOptionPane.showInputDialog(jPanelA, "Farbe: ", "Farbe wählen",
                    JOptionPane.PLAIN_MESSAGE, null, selectionValues, selectionValues[0]);
            player2.setColor((Color) inputContentColor);
        });
        // typing the Size of Field
        jButtonSize.addActionListener(e -> {
            String inputContentSize = JOptionPane.showInputDialog(jPanelA, "Größe des Fields:", "eine Nummer eingeben");
            int inputContentSize_int=Integer.valueOf(inputContentSize).intValue();
            Size=inputContentSize_int;
        });
        // print the Information of Player 1
        jButton5A.addActionListener(e -> {
            player1.print();
        });
        // print the Information of Player 2
        jButton6A.addActionListener(e -> {
            player2.print();
        });
        // go to the next  Panel
        jButtonBeginA.addActionListener(e -> {
            System.out.println(player1.getName()+"  VS  "+player2.getName());
            jFrame.setContentPane(check.oneMoreLook());
        });
        return jPanelA;
    }

    public static JPanel startB() {

        player1 = new Player("", null, new Position(2, 2));
        player2 = new Player("", null, new Position(2, 2));
        player3 = new Player("", null, new Position(2, 2));
        // Panel intialisierung
        JPanel jPanelA = new JPanel();
        jPanelA.setLayout(null);

        // set the color and Size of Panel
        jPanelA.setBounds(50, 50, 1080, 600);
        jPanelA.setBackground(new Color(200, 200, 200));

        // set the Buttons on the Panel
        JButton jButton1A = new JButton("Name1");
        jButton1A.setBounds(270,120,120,40);

        JButton jButton2A = new JButton("Farbe1");
        jButton2A.setBounds(400,120,120,40);

        JButton jButton3A = new JButton("Name2");
        jButton3A.setBounds(270,220,120,40);

        JButton jButton4A = new JButton("Farbe2");
        jButton4A.setBounds(400,220,120,40);

        JButton jButton5A = new JButton("Name3");
        jButton5A.setBounds(270,320,120,40);

        JButton jButton6A = new JButton("Farbe3");
        jButton6A.setBounds(400,320,120,40);

        JButton jButton7A = new JButton("Spieler1 go");
        jButton7A.setBounds(530,120,200,40);

        JButton jButton8A = new JButton("Spieler2 go");
        jButton8A.setBounds(530,220,200,40);

        JButton jButton9A = new JButton("Spieler3 go");
        jButton9A.setBounds(530,320,200,40);

        JButton jButtonBeginA = new JButton("BEGIN!!!");
        jButtonBeginA.setBounds(450,400,160,40);


        JButton jButtonSize = new JButton("Größe");
        jButtonSize.setBounds(270,400,160,40);

        // set the Text of the Panel
        JLabel textLabel1A = new JLabel("Spieler1 :");
        textLabel1A.setFont(new Font(null, Font.PLAIN, 25));
        textLabel1A.setBounds(100,100,160,80);

        JLabel textLabel2A = new JLabel("Spieler2 :");
        textLabel2A.setFont(new Font(null, Font.PLAIN, 25));
        textLabel2A.setBounds(100,200,160,80);

        JLabel textLabel3A = new JLabel("Spieler3 :");
        textLabel3A.setFont(new Font(null, Font.PLAIN, 25));
        textLabel3A.setBounds(100,300,160,80);

        JLabel textLabelBegin = new JLabel("Anfangen!!!!!!!!!!");
        textLabelBegin.setFont(new Font(null, Font.PLAIN, 25));

        JLabel textLabel3 = new JLabel(player1.getName()+"--"+player1.getColor()+": ready");
        textLabel3.setFont(new Font(null, Font.PLAIN, 25));

        JLabel textLabel4 = new JLabel(player2.getName()+"--"+player2.getColor()+": ready");
        textLabel4.setFont(new Font(null, Font.PLAIN, 25));

        JLabel textLabel5 = new JLabel(player3.getName()+"--"+player3.getColor()+": ready");
        textLabel5.setFont(new Font(null, Font.PLAIN, 25));

        // set the background of Meun
        background = new ImageIcon("File/santorirni_Game_2.jpg");
        JLabel label = new JLabel(background);
        label.setBounds(0,0,background.getIconWidth(),background.getIconHeight());

        // add the Buttons and background on the Panel
        jPanelA.add(jButton1A);
        jPanelA.add(jButton2A);
        jPanelA.add(jButton3A);
        jPanelA.add(jButton4A);
        jPanelA.add(jButton5A);
        jPanelA.add(jButton6A);
        jPanelA.add(jButton7A);
        jPanelA.add(jButton8A);
        jPanelA.add(jButton9A);
        jPanelA.add(textLabel1A);
        jPanelA.add(textLabel2A);
        jPanelA.add(textLabel3A);
        jPanelA.add(jButtonBeginA);
        jPanelA.add(jButtonSize);
        jPanelA.add(label);

        // typing the name for Player1
        jButton1A.addActionListener(e -> {
            String inputContentName = JOptionPane.showInputDialog(jPanelA, "Deine Name :", "Name eingebn");
            player1.setName(inputContentName);
        });
        // typing the name for Player2
        jButton3A.addActionListener(e -> {
            String inputContentName = JOptionPane.showInputDialog(jPanelA, "Deine Name :", "Name eingebn");
            player2.setName(inputContentName);
        });
        // typing the name for Player3
        jButton5A.addActionListener(e -> {
            String inputContentName = JOptionPane.showInputDialog(jPanelA, "Deine Name :", "Name eingebn");
            player3.setName(inputContentName);
        });
        // choose the Color for Player1
        jButton2A.addActionListener(e -> {
            Object[] selectionValues = new Object[]{Color.RED, Color.BLUE, Color.YELLOW, Color.GREEN};
            Object inputContentColor = JOptionPane.showInputDialog(jPanelA, "Farbe: ", "Farbe wählen",
                    JOptionPane.PLAIN_MESSAGE, null, selectionValues, selectionValues[0]);
            player1.setColor((Color) inputContentColor);
        });

        // choose the color for Player2
        jButton4A.addActionListener(e -> {
            Object[] selectionValues = new Object[]{Color.RED, Color.BLUE, Color.YELLOW, Color.GREEN};
            Object inputContentColor = JOptionPane.showInputDialog(jPanelA, "Farbe: ", "Farbe wählen",
                    JOptionPane.PLAIN_MESSAGE, null, selectionValues, selectionValues[0]);
            player2.setColor((Color) inputContentColor);

        });
        // choose the color for Player3
        jButton6A.addActionListener(e -> {
            Object[] selectionValues = new Object[]{Color.RED, Color.BLUE, Color.YELLOW, Color.GREEN};
            Object inputContentColor = JOptionPane.showInputDialog(jPanelA, "Farbe: ", "Farbe wählen",
                    JOptionPane.PLAIN_MESSAGE, null, selectionValues, selectionValues[0]);
            player3.setColor((Color) inputContentColor);
        });
        // typing the Size of Field
        jButtonSize.addActionListener(e -> {
            String inputContentSize = JOptionPane.showInputDialog(jPanelA, "Size of Field:", "Typing a number");
            int inputContentSize_int=Integer.valueOf(inputContentSize).intValue();
            Size=inputContentSize_int;
        });
        // print the Information of Player 1
        jButton7A.addActionListener(e -> {
            player1.print();
        });
        // print the Information of Player 2
        jButton8A.addActionListener(e -> {
            player2.print();
        });
        // print the Information of Player 3
        jButton9A.addActionListener(e -> {
            player3.print();
        });

        // go to the next  Panel
        jButtonBeginA.addActionListener(e -> {
            System.out.println(player1.getName()+"  VS  "+player2.getName());
            jFrame.setContentPane(check.oneMoreLook2());
            //check.oneMoreLook2();
        });
        return jPanelA;

    }

    public static JPanel startC() {

        player1 = new Player("", null, new Position(2, 2));
        player2 = new Player("", null, new Position(2, 2));
        player3 = new Player("", null, new Position(2, 2));
        player4 = new Player("", null, new Position(2, 2));
        // Panel intialisierung
        JPanel jPanelA = new JPanel();
        jPanelA.setLayout(null);

        // set the color and Size of Panel
        jPanelA.setBounds(50, 50, 1080, 600);
        jPanelA.setBackground(new Color(200, 200, 200));

        // set the Buttons on the Panel
        JButton jButton1A = new JButton("Name1");
        jButton1A.setBounds(270,120,120,40);

        JButton jButton2A = new JButton("Color1");
        jButton2A.setBounds(400,120,120,40);

        JButton jButton3A = new JButton("Name2");
        jButton3A.setBounds(270,220,120,40);

        JButton jButton4A = new JButton("Color2");
        jButton4A.setBounds(400,220,120,40);

        JButton jButton5A = new JButton("Name3");
        jButton5A.setBounds(270,320,120,40);

        JButton jButton6A = new JButton("Color3");
        jButton6A.setBounds(400,320,120,40);

        JButton jButton7A = new JButton("player1 go");
        jButton7A.setBounds(530,120,200,40);

        JButton jButton8A = new JButton("player2 go");
        jButton8A.setBounds(530,220,200,40);

        JButton jButton9A = new JButton("player3 go");
        jButton9A.setBounds(530,320,200,40);

        JButton jButton10A = new JButton("Name4");
        jButton10A.setBounds(270,420,120,40);

        JButton jButton11A = new JButton("Color4");
        jButton11A.setBounds(400,420,120,40);

        JButton jButton12A = new JButton("player4 go");
        jButton12A.setBounds(530,420,200,40);

        JButton jButtonBeginA = new JButton("BEGIN!!!");
        jButtonBeginA.setBounds(800,320,200,40);

        // set the Text of the Panel
        JLabel textLabel1A = new JLabel("player1 :");
        textLabel1A.setFont(new Font(null, Font.PLAIN, 25));
        textLabel1A.setBounds(100,100,160,80);

        JLabel textLabel2A = new JLabel("player2 :");
        textLabel2A.setFont(new Font(null, Font.PLAIN, 25));
        textLabel2A.setBounds(100,200,160,80);

        JLabel textLabel3A = new JLabel("player3 :");
        textLabel3A.setFont(new Font(null, Font.PLAIN, 25));
        textLabel3A.setBounds(100,300,160,80);

        JLabel textLabel4A = new JLabel("player4 :");
        textLabel4A.setFont(new Font(null, Font.PLAIN, 25));
        textLabel4A.setBounds(100,400,160,80);

        JLabel textLabelBegin = new JLabel("Begin!!!!!!!!!!");
        textLabelBegin.setFont(new Font(null, Font.PLAIN, 25));


        JLabel textLabel3 = new JLabel(player1.getName()+"--"+player1.getColor()+": ready");
        textLabel3.setFont(new Font(null, Font.PLAIN, 25));

        JLabel textLabel4 = new JLabel(player2.getName()+"--"+player2.getColor()+": ready");
        textLabel4.setFont(new Font(null, Font.PLAIN, 25));

        JLabel textLabel5 = new JLabel(player3.getName()+"--"+player3.getColor()+": ready");
        textLabel5.setFont(new Font(null, Font.PLAIN, 25));

        JLabel textLabel6 = new JLabel(player4.getName()+"--"+player3.getColor()+": ready");
        textLabel6.setFont(new Font(null, Font.PLAIN, 25));


        // add the Buttons on the Panel
        jPanelA.add(jButton1A);
        jPanelA.add(jButton2A);
        jPanelA.add(jButton3A);
        jPanelA.add(jButton4A);
        jPanelA.add(jButton5A);
        jPanelA.add(jButton6A);
        jPanelA.add(jButton7A);
        jPanelA.add(jButton8A);
        jPanelA.add(jButton9A);
        jPanelA.add(jButton10A);
        jPanelA.add(jButton11A);
        jPanelA.add(jButton12A);
        jPanelA.add(textLabel1A);
        jPanelA.add(textLabel2A);
        jPanelA.add(textLabel3A);
        jPanelA.add(textLabel4A);
        jPanelA.add(jButtonBeginA);

        // typing the name for Player1
        jButton1A.addActionListener(e -> {
            String inputContentName = JOptionPane.showInputDialog(jPanelA, "Your Name :", "player");
            player1.setName(inputContentName);
        });
        // typing the name for Player2
        jButton3A.addActionListener(e -> {
            String inputContentName = JOptionPane.showInputDialog(jPanelA, "Your Name :", "player");
            player2.setName(inputContentName);
        });
        // typing the name for Player3
        jButton5A.addActionListener(e -> {
            String inputContentName = JOptionPane.showInputDialog(jPanelA, "Your Name :", "player");
            player3.setName(inputContentName);
        });
        // typing the name for Player4
        jButton10A.addActionListener(e -> {
            String inputContentName = JOptionPane.showInputDialog(jPanelA, "Your Name :", "player");
            player4.setName(inputContentName);
        });
        // choose the Color for Player1
        jButton2A.addActionListener(e -> {
            Object[] selectionValues = new Object[]{Color.RED, Color.BLUE, Color.YELLOW, Color.GREEN};
            Object inputContentColor = JOptionPane.showInputDialog(jPanelA, "Color: ", "Color",
                    JOptionPane.PLAIN_MESSAGE, null, selectionValues, selectionValues[0]);
            player1.setColor((Color) inputContentColor);
        });

        // choose the color for Player2
        jButton4A.addActionListener(e -> {
            Object[] selectionValues = new Object[]{Color.RED, Color.BLUE, Color.YELLOW, Color.GREEN};
            Object inputContentColor = JOptionPane.showInputDialog(jPanelA, "Color: ", "Color",
                    JOptionPane.PLAIN_MESSAGE, null, selectionValues, selectionValues[0]);
            player2.setColor((Color) inputContentColor);

        });

        // choose the color for Player3
        jButton6A.addActionListener(e -> {
            Object[] selectionValues = new Object[]{Color.RED, Color.BLUE, Color.YELLOW, Color.GREEN};
            Object inputContentColor = JOptionPane.showInputDialog(jPanelA, "Color: ", "Color",
                    JOptionPane.PLAIN_MESSAGE, null, selectionValues, selectionValues[0]);
            player3.setColor((Color) inputContentColor);

        });

        // choose the color for Player4
        jButton11A.addActionListener(e -> {
            Object[] selectionValues = new Object[]{Color.RED, Color.BLUE, Color.YELLOW, Color.GREEN};
            Object inputContentColor = JOptionPane.showInputDialog(jPanelA, "Color: ", "Color",
                    JOptionPane.PLAIN_MESSAGE, null, selectionValues, selectionValues[0]);
            player4.setColor((Color) inputContentColor);

        });
        // print the Information of Player 1
        jButton7A.addActionListener(e -> {
            player1.print();
        });
        // print the Information of Player 2
        jButton8A.addActionListener(e -> {
            player2.print();
        });
        // print the Information of Player 3
        jButton9A.addActionListener(e -> {
            player3.print();
        });
        // print the Information of Player 4
        jButton12A.addActionListener(e -> {
            player4.print();
        });

        // go to the next  Panel
        jButtonBeginA.addActionListener(e -> {
            System.out.println(player1.getName()+"  VS  "+player2.getName());
            jFrame.setContentPane(check.oneMoreLook2());
            //check.oneMoreLook2();
        });
        return jPanelA;

    }


    public static void main(String[] args) {

    }
}
