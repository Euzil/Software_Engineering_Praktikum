/**
 * @author Youran Wang : youran.wang@student.uni-luebeck.de
 * modified by  Youran Wang (719511)
 */
package tnt.spiele;

import javax.swing.*;
import java.awt.*;
public class Winner_3er {
    public static JFrame Win;
    private static JPanel imagePanel;
    private static ImageIcon background;
    /**
     * This Methode is for Winner
     */
    public static void winner() {
        Win = new JFrame("TNT GAME");
        Win.setBounds(300, 300, 1280, 760);
        Win.setBackground(new Color(41, 122, 41));
        Win.setVisible(true);
        Win.setLocationRelativeTo(null);
        Win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        background = new ImageIcon("File/GUI_Horror-Design.png");
        JLabel label = new JLabel(background);
        label.setBounds(0,0,background.getIconWidth(),background.getIconHeight());
        imagePanel=(JPanel)Win.getContentPane() ;
        imagePanel.setOpaque(false);
        imagePanel.setLayout(new FlowLayout());
        Win.getLayeredPane().setLayout(null);
        Win.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
        // set the playing Button
        if (Spielefield_3er.WinA) {
            JButton jButtonWinA = new JButton("A Winnnn");
            jButtonWinA.setBounds(490, 360, 300, 40);
            Win.add(jButtonWinA);
            Win.setLayout(null);
            jButtonWinA.addActionListener(e -> {
                System.exit(0);
            });
        } else if (Spielefield_3er.WinB) {
            JButton jButtonWinB = new JButton("B Winnnn");
            jButtonWinB.setBounds(490, 360, 300, 40);
            Win.add(jButtonWinB);
            Win.setLayout(null);
            jButtonWinB.addActionListener(e -> {
                System.exit(0);
            });
        } else if (Spielefield_3er.WinC) {
            JButton jButtonWinC = new JButton("C Winnnn");
            jButtonWinC.setBounds(490, 360, 300, 40);
            Win.add(jButtonWinC);
            Win.setLayout(null);
            jButtonWinC.addActionListener(e -> {
                System.exit(0);
            });
        }
        //Process
        Win.setLocationRelativeTo(null);
        Win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            //Process
            Win.setLocationRelativeTo(null);
            Win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        }
    public static void main(String[] args) {
       Spielefield_3er.WinC=true;
       winner();
    }
    }


