/**
 * @author Youran Wang : youran.wang@student.uni-luebeck.de
 * modified by  Youran Wang (719511)
 */
package tnt.spiele;

import java.awt.*;
import javax.swing.*;

public class check extends Add {
    public static JPanel oneMoreLook(){
        // Panel intialisierung
        JPanel jPanelB = new JPanel();

        // set the color and size of Panel
        jPanelB.setBounds(100, 100, 0, 0);
        jPanelB.setBackground(new Color(200, 200, 200));

        Spielefield.intial();

        return jPanelB;
    }
    public static JPanel oneMoreLook2(){
        // Panel intialisierung
        JPanel jPanelB = new JPanel();

        // set the color and size of Panel
        jPanelB.setBounds(100, 100, 0, 0);
        jPanelB.setBackground(new Color(200, 200, 200));

        // use the class Mouse with the Methode intial()
        Spielefield_3er.intial();
        return jPanelB;
    }
    public static JPanel oneMoreLook3(){
        // Panel intialisierung
        JPanel jPanelB = new JPanel();

        // set the color and size of Panel
        jPanelB.setBounds(100, 100, 0, 0);
        jPanelB.setBackground(new Color(200, 200, 200));

        // use the class Mouse with the Methode intial()
        Spielefield.intial();

        return jPanelB;
    }
}

