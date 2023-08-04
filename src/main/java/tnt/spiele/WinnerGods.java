package tnt.spiele;

import javax.swing.*;
import java.awt.*;


public class WinnerGods {
    public static JFrame Win;

    public static void winner(){
        Win = new JFrame("TNT GAME");
        Win.setBounds(300,300,1280,760);
        Win.setBackground(new Color(41, 122, 41));
        Win.setVisible(true);
        Win.setLocationRelativeTo(null);
        Win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // set the playing Button
        if(SpielefieldGods.WinA){
            JButton jButtonWinA = new JButton("A Winnnn");
            jButtonWinA.setBounds(590,360,300,40);
            Win.add(jButtonWinA);
        }else if(SpielefieldGods.WinB){
            JButton jButtonWinB = new JButton("B Winnnn");
            jButtonWinB.setBounds(590,360,300,40);
            Win.add(jButtonWinB);
        }

        //Process

        Win.setLocationRelativeTo(null);


        Win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
