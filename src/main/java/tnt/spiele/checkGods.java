/**
 * modified by  Youran Wang (719511)
 * and by Finn Hinrichs (712699)
 */
package tnt.spiele;

import tnt.enginee.Player;
import tnt.enginee.Position;

import java.awt.*;
import javax.swing.*;

public class checkGods extends AddGods{

    public static JPanel oneMoreLook(){
        // Panel intialisierung
        JPanel jPanelB = new JPanel();

        // set the color and size of Panel
        jPanelB.setBounds(100, 100, 1080, 560);
        jPanelB.setBackground(new Color(200, 200, 200));

        JButton jButton = new JButton("okkkkkkkk");
        // print the information of game
        JLabel textLabelPlayer = new JLabel(player1.getColor()+"---"+player1.getName()+"   VS   "+player2.getName()+"---"+player2.getColor());
        textLabelPlayer.setFont(new Font(null, Font.PLAIN, 25));
        textLabelPlayer.setBounds(100,120,60,80);

        jPanelB.add(textLabelPlayer);
        // use the class Mouse with the Methode intial()
        SpielefieldGods.intial();

        return jPanelB;
    }


}

