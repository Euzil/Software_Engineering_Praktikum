/**
 * modified by  Youran Wang (719511)
 * and by Fin Hinrichs (712699)
 */
package tnt.spiele;

import tnt.enginee.GodCard;
import tnt.enginee.Pawn;
import tnt.enginee.PlayerGods;
import tnt.enginee.Position;

import java.awt.*;
import javax.swing.*;





public class BeginnGods {
    public static JFrame jFrame;

public static void StartGods() {

    PlayerGods player1 = new PlayerGods("", "", new Position(2, 2), new Pawn(new Position(0,0)), new Pawn(new Position(0,0)), new GodCard(0));
    PlayerGods player2 = new PlayerGods("", "", new Position(2, 2), new Pawn(new Position(0,0)), new Pawn(new Position(0,0)), new GodCard(0));

    // Panel initialisierung
    // set the color and size of Panel
    jFrame = new JFrame("TNT GAME");
    jFrame.setBounds(300,300,1280,760);
    jFrame.setBackground(new Color(41, 122, 41));
    jFrame.setVisible(true);
    jFrame.setLocationRelativeTo(null);
    jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    // set the playing Button
    JButton jButtonBegin = new JButton("Lets Play");
    jButtonBegin.setBounds(590,360,100,40);
    // set the text
    JLabel textLabel1 = new JLabel("----TNT GAME----");
    textLabel1.setBounds(540,200,200,40);
    textLabel1.setFont(new Font(null, Font.PLAIN, 25));

    // add the text and button
    jFrame.add(textLabel1);
    jFrame.add(jButtonBegin);

    //Process
    jButtonBegin.addActionListener(e -> {
        jFrame.setContentPane(AddGods.startAGods());
    });

    jFrame.setLocationRelativeTo(null);


    jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
}

}
