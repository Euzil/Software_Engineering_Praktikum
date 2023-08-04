/**
 * @author Youran Wang : youran.wang@student.uni-luebeck.de
 * modified by  Youran Wang (719511)
 */
package tnt.spiele;
import tnt.enginee.Player;
import tnt.enginee.Position;

import java.awt.*;
import javax.swing.*;
/** variable
* jFrame : the GUI of Beginn
* imagePanel : the background will be as a Panel
* background : the Image of background need be loaded as ImageIcon
 */
public class Beginn {
    public static JFrame jFrame;
    private static JPanel imagePanel;
    private static ImageIcon background;

public static void Start() {

    Player player1 = new Player("", null, new Position(2, 2));
    Player player2 = new Player("", null, new Position(2, 2));

    // Panel initialisierung
    // set the color and size of Panel
    jFrame = new JFrame("TNT GAME");
    jFrame.setBounds(300,300,1920,1272);
    jFrame.setBackground(new Color(41, 122, 41));
    jFrame.setLayout(null);
    jFrame.setVisible(true);
    jFrame.setLocationRelativeTo(null);
    jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    // set background Image
    background = new ImageIcon("File/santorini_Game.jpg");
    JLabel label = new JLabel(background);
    label.setBounds(0,0,background.getIconWidth(),background.getIconHeight());
    imagePanel=(JPanel)jFrame.getContentPane() ;
    imagePanel.setOpaque(false);
    imagePanel.setLayout(new FlowLayout());

    // set the playing Button
    JButton jButtonBegin1 = new JButton("2v2 Spieler");
    jButtonBegin1.setBounds(490,160,300,40);

    JButton jButtonBegin2 = new JButton("3v3 Spieler");
    jButtonBegin2.setBounds(490,260,300,40);


    /*JButton jButtonBegin3 = new JButton("4v4 Spieler");
    jButtonBegin3.setBounds(490,360,300,40);
    */

    JButton jButtonBeginGods = new JButton("2v2 mit Gods");
    jButtonBeginGods.setBounds(490,360,300,40);

    // set the text
    JLabel textLabel1 = new JLabel("Terror Nightmare Towers");
    textLabel1.setBounds(500,60,400,80);
    textLabel1.setFont(new Font(null, Font.PLAIN, 25));

    // add the text, button and background
    jFrame.add(textLabel1);
    jFrame.add(jButtonBegin1);
    jFrame.add(jButtonBegin2);
    //jFrame.add(jButtonBegin3);
    jFrame.add(jButtonBeginGods);
    jFrame.getLayeredPane().setLayout(null);
    jFrame.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));

    // Process
    jButtonBegin1.addActionListener(e -> {
        jFrame.setContentPane(Add.startA());
    });

    jButtonBegin2.addActionListener(e -> {
        jFrame.setContentPane(Add.startB());
    });
/*
    jButtonBegin3.addActionListener(e -> {
        jFrame.setContentPane(Add.startC());
    });

*/
    jButtonBeginGods.addActionListener(e -> {
        jFrame.setContentPane(AddGods.startAGods());
    });

    jFrame.setLocationRelativeTo(null);
    jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
}

    public static void main(String[] args) {
    Start();
    }
}
