/**
 * @author Youran Wang : youran.wang@student.uni-luebeck.de
 * modified by  Youran Wang (719511)
 */
package tnt.spiele;
import java.awt.*;
import java.lang.reflect.Field;
public class Regelcheck {

    /** its the Methode to check, if A already won the Game
     *
     * @return if A win
     */
    public static boolean ifAwin() {
        if (Spielefield.Field[Spielefield.a][Spielefield.b] == 4) {
            System.out.println("A win");
            return true;
        } else {
            return false;
        }
    }
    /** its the Methode to check, if B already won the Game
     *
     * @return if B win
     */
    public static boolean ifBwin() {
        if (Spielefield.Field[Spielefield.a][Spielefield.b] == 4) {
            System.out.println("B win");
            return true;
        } else {
            return false;
        }
    }
    /** Its the Methode to check, if the posotion was been choose by player 1
     *
     * @return if this Position in
     */
    private static boolean ifInAList() {
        boolean ifinalist = false;
        for (int q = 0; q < putIN.player1_List_put.size(); q++) {
            if (putIN.player1_put_x.get(q) == Spielefield.a && putIN.player1_put_y.get(q) == Spielefield.b) {
                ifinalist=true;
            }
        }
        return ifinalist;
    }
    /** Its the Methode to check, if the posotion was been choose by player 2
     *
     * @return if this Position in
     */
    private static boolean ifInBList() {
        boolean ifinblist = false;
        for (int q = 0; q < putIN.player2_List_put.size(); q++) {
            if (putIN.player2_put_x.get(q) == Spielefield.a && putIN.player2_put_y.get(q) == Spielefield.b) {
                ifinblist=true;
            }
        }
        return ifinblist;
    }
    /** Its the Methode to check, if A can move to here
     *
     * @return if a Move Right
     */
    public static boolean ifAMoveRight() {
        boolean ifamoveright = true;
        // if the posotion was been choose by player 2
        if(ifInBList()==false) {
            // if there is a Kuppel
            if (Spielefield.Field[Spielefield.a][Spielefield.b] < 5) {
                //if there is near to the last move
                if ((Spielefield.a == (moveIN.player1_move_x[moveIN.player1_move_x.length - 1] - 1) && Spielefield.b == (moveIN.player1_move_y[moveIN.player1_move_y.length - 1])) ||
                        (Spielefield.a == (moveIN.player1_move_x[moveIN.player1_move_x.length - 1] + 1) && Spielefield.b == (moveIN.player1_move_y[moveIN.player1_move_y.length - 1])) ||
                        (Spielefield.a == (moveIN.player1_move_x[moveIN.player1_move_x.length - 1]) && Spielefield.b == (moveIN.player1_move_y[moveIN.player1_move_y.length - 1] - 1)) ||
                        (Spielefield.a == (moveIN.player1_move_x[moveIN.player1_move_x.length - 1]) && Spielefield.b == (moveIN.player1_move_y[moveIN.player1_move_y.length - 1] + 1)) ||
                        (Spielefield.a == (moveIN.player1_move_x[moveIN.player1_move_x.length - 1] + 1) && Spielefield.b == (moveIN.player1_move_y[moveIN.player1_move_y.length - 1] + 1)) ||
                        (Spielefield.a == (moveIN.player1_move_x[moveIN.player1_move_x.length - 1] + 1) && Spielefield.b == (moveIN.player1_move_y[moveIN.player1_move_y.length - 1] - 1)) ||
                        (Spielefield.a == (moveIN.player1_move_x[moveIN.player1_move_x.length - 1] - 1) && Spielefield.b == (moveIN.player1_move_y[moveIN.player1_move_y.length - 1] + 1)) ||
                        (Spielefield.a == (moveIN.player1_move_x[moveIN.player1_move_x.length - 1] - 1) && Spielefield.b == (moveIN.player1_move_y[moveIN.player1_move_y.length - 1] - 1))) {
                    ifamoveright = true;
                } else {
                    System.out.println("Cant move there");
                    ifamoveright = false;
                }
            } else {
                System.out.println("Cant move there");
                ifamoveright = false;
            }
        }else{
            System.out.println("Cant move there");
            ifamoveright = false;
        }
        return ifamoveright;
    }
     /** Its the Methode to check, if B can move to here
     *
     * @return if b Move Right
     */
    public static boolean ifBMoveRight() {
        boolean ifbmoveright = true;
        // if the posotion was been choose by player 1
        if(ifInAList()==false) {
            // if there is a Kuppel
            if (Spielefield.Field[Spielefield.a][Spielefield.b] < 5) {
                // if there is near to the last move
                if (    (Spielefield.a == (moveIN.player2_move_x[moveIN.player2_move_x.length - 1] - 1) && Spielefield.b == (moveIN.player2_move_y[moveIN.player2_move_y.length - 1])) ||
                        (Spielefield.a == (moveIN.player2_move_x[moveIN.player2_move_x.length - 1] + 1) && Spielefield.b == (moveIN.player2_move_y[moveIN.player2_move_y.length - 1])) ||
                        (Spielefield.a == (moveIN.player2_move_x[moveIN.player2_move_x.length - 1]) && Spielefield.b == (moveIN.player2_move_y[moveIN.player2_move_y.length - 1] - 1)) ||
                        (Spielefield.a == (moveIN.player2_move_x[moveIN.player2_move_x.length - 1]) && Spielefield.b == (moveIN.player2_move_y[moveIN.player2_move_y.length - 1] + 1)) ||
                        (Spielefield.a == (moveIN.player2_move_x[moveIN.player2_move_x.length - 1] + 1) && Spielefield.b == (moveIN.player2_move_y[moveIN.player2_move_y.length - 1] + 1)) ||
                        (Spielefield.a == (moveIN.player2_move_x[moveIN.player2_move_x.length - 1] + 1) && Spielefield.b == (moveIN.player2_move_y[moveIN.player2_move_y.length - 1] - 1)) ||
                        (Spielefield.a == (moveIN.player2_move_x[moveIN.player2_move_x.length - 1] - 1) && Spielefield.b == (moveIN.player2_move_y[moveIN.player2_move_y.length - 1] + 1)) ||
                        (Spielefield.a == (moveIN.player2_move_x[moveIN.player2_move_x.length - 1] - 1) && Spielefield.b == (moveIN.player2_move_y[moveIN.player2_move_y.length - 1] - 1))) {
                    ifbmoveright = true;
                } else {
                    System.out.println("Cant move there");
                    ifbmoveright = false;
                }
            } else {
                System.out.println("Cant move there");
                ifbmoveright = false;
            }
        }else{
            System.out.println("Cant move there");
            ifbmoveright = false;
        }
        return ifbmoveright;
    }

    /** Its the Methode to check, if A can put to here
     *
     * @return if a Put Right
     */
    public static boolean ifAPutRight() {
        boolean ifaputright = true;
        // if the posotion was been choose by player 2
        if(ifInBList()==false) {
            // if there is near to the last move
            if (    (Spielefield.a == (moveIN.player1_move_x[moveIN.player1_move_x.length - 1] - 1) && Spielefield.b == (moveIN.player1_move_y[moveIN.player1_move_y.length - 1])) ||
                    (Spielefield.a == (moveIN.player1_move_x[moveIN.player1_move_x.length - 1] + 1) && Spielefield.b == (moveIN.player1_move_y[moveIN.player1_move_y.length - 1])) ||
                    (Spielefield.a == (moveIN.player1_move_x[moveIN.player1_move_x.length - 1]) && Spielefield.b == (moveIN.player1_move_y[moveIN.player1_move_y.length - 1] - 1)) ||
                    (Spielefield.a == (moveIN.player1_move_x[moveIN.player1_move_x.length - 1]) && Spielefield.b == (moveIN.player1_move_y[moveIN.player1_move_y.length - 1] + 1)) ||
                    (Spielefield.a == (moveIN.player1_move_x[moveIN.player1_move_x.length - 1] + 1) && Spielefield.b == (moveIN.player1_move_y[moveIN.player1_move_y.length - 1] + 1))||
                    (Spielefield.a == (moveIN.player1_move_x[moveIN.player1_move_x.length - 1] + 1) && Spielefield.b == (moveIN.player1_move_y[moveIN.player1_move_y.length - 1] - 1))||
                    (Spielefield.a == (moveIN.player1_move_x[moveIN.player1_move_x.length - 1] - 1) && Spielefield.b == (moveIN.player1_move_y[moveIN.player1_move_y.length - 1] + 1))||
                    (Spielefield.a == (moveIN.player1_move_x[moveIN.player1_move_x.length - 1] - 1) && Spielefield.b == (moveIN.player1_move_y[moveIN.player1_move_y.length - 1] - 1))) {
                // if there is a Kuppel and the last Move was high enough to reach this Field
                if ((Spielefield.Field[Spielefield.a][Spielefield.b] == Spielefield.Field[moveIN.player1_move_x[moveIN.player1_move_x.length - 1]][moveIN.player1_move_y[moveIN.player1_move_y.length - 1]]) &&
                        Spielefield.Field[Spielefield.a][Spielefield.b] < 5) {
                    ifaputright = true;
                } else {
                    ifaputright = false;
                    System.out.print("cant put there");
                }
            } else {
                ifaputright = false;
                System.out.print("cant put there");
            }
        }else{
            ifaputright = false;
            System.out.print("cant put there");
        }
        return ifaputright;
    }
    /** Its the Methode to check, if A can put to here
     *
     * @return if a Put Right
     */
    public static boolean ifBPutRight() {
        boolean ifbputright = true;
        // if the posotion was been choose by player 1
        if(ifInBList()==false) {
            // if there is near to the last move
            if (    (Spielefield.a == (moveIN.player2_move_x[moveIN.player2_move_x.length - 1] - 1) && Spielefield.b == (moveIN.player2_move_y[moveIN.player2_move_y.length - 1])) ||
                    (Spielefield.a == (moveIN.player2_move_x[moveIN.player2_move_x.length - 1] + 1) && Spielefield.b == (moveIN.player2_move_y[moveIN.player2_move_y.length - 1])) ||
                    (Spielefield.a == (moveIN.player2_move_x[moveIN.player2_move_x.length - 1]) && Spielefield.b == (moveIN.player2_move_y[moveIN.player2_move_y.length - 1] - 1)) ||
                    (Spielefield.a == (moveIN.player2_move_x[moveIN.player2_move_x.length - 1]) && Spielefield.b == (moveIN.player2_move_y[moveIN.player2_move_y.length - 1] + 1)) ||
                    (Spielefield.a == (moveIN.player2_move_x[moveIN.player2_move_x.length - 1] + 1) && Spielefield.b == (moveIN.player2_move_y[moveIN.player2_move_y.length - 1] + 1 ))||
                    (Spielefield.a == (moveIN.player2_move_x[moveIN.player2_move_x.length - 1] + 1) && Spielefield.b == (moveIN.player2_move_y[moveIN.player2_move_y.length - 1] - 1))||
                    (Spielefield.a == (moveIN.player2_move_x[moveIN.player2_move_x.length - 1] - 1) && Spielefield.b == (moveIN.player2_move_y[moveIN.player2_move_y.length - 1] + 1))||
                    (Spielefield.a == (moveIN.player2_move_x[moveIN.player2_move_x.length - 1] - 1) && Spielefield.b == (moveIN.player2_move_y[moveIN.player2_move_y.length - 1] - 1))) {
                // if there is a Kuppel and the last Move was high enough to reach this Field
                if ((Spielefield.Field[Spielefield.a][Spielefield.b] == Spielefield.Field[moveIN.player2_move_x[moveIN.player2_move_x.length - 1]][moveIN.player2_move_y[moveIN.player2_move_y.length - 1]]) &&
                        (Spielefield.Field[Spielefield.a][Spielefield.b] < 5)) {
                    ifbputright = true;
                } else {
                    ifbputright = false;
                    System.out.print("cant put there");
                }
            } else {
                ifbputright = false;
                System.out.print("cant put there");

            }
        }else{
            ifbputright = false;
            System.out.print("cant put there");
        }
        return ifbputright;
    }
    /** Its the Methode to check, if A can kuppel to here
     *
     * @return if a Kuppel Right
     */
    public static boolean ifAKuppelRight() {
        boolean ifakuppelright = true;
        // if there is near to the last move
        if (    (Spielefield.a == (moveIN.player1_move_x[moveIN.player1_move_x.length - 1] - 1) && Spielefield.b == (moveIN.player1_move_y[moveIN.player1_move_y.length - 1])) ||
                (Spielefield.a == (moveIN.player1_move_x[moveIN.player1_move_x.length - 1] + 1) && Spielefield.b == (moveIN.player1_move_y[moveIN.player1_move_y.length - 1])) ||
                (Spielefield.a == (moveIN.player1_move_x[moveIN.player1_move_x.length - 1]) && Spielefield.b == (moveIN.player1_move_y[moveIN.player1_move_y.length - 1] - 1)) ||
                (Spielefield.a == (moveIN.player1_move_x[moveIN.player1_move_x.length - 1]) && Spielefield.b == (moveIN.player1_move_y[moveIN.player1_move_y.length - 1] + 1))) {
            // if there is a Kuppel and the last Move was high enough to reach this Field
            if ((Spielefield.Field[Spielefield.a][Spielefield.b] == Spielefield.Field[moveIN.player1_move_x[moveIN.player1_move_x.length - 1]][moveIN.player1_move_y[moveIN.player1_move_y.length - 1]])&&
                    Spielefield.Field[Spielefield.a][Spielefield.b] <5) {
                ifakuppelright = true;
            } else {
                ifakuppelright = false;
                System.out.print("cant Kuppel there");
            }
        } else {
            ifakuppelright = false;
            System.out.print("cant Kuppel there");
        }
        return ifakuppelright;
    }
    /** Its the Methode to check, if B can kuppel to here
     *
     * @return if b Kuppel Right
     */
    public static boolean ifBKuppelRight() {
        boolean ifbkuppelright = true;
        // if there is near to the last move
        if (    (Spielefield.a == (moveIN.player2_move_x[moveIN.player2_move_x.length - 1] - 1) && Spielefield.b == (moveIN.player2_move_y[moveIN.player2_move_y.length - 1])) ||
                (Spielefield.a == (moveIN.player2_move_x[moveIN.player2_move_x.length - 1] + 1) && Spielefield.b == (moveIN.player2_move_y[moveIN.player2_move_y.length - 1])) ||
                (Spielefield.a == (moveIN.player2_move_x[moveIN.player2_move_x.length - 1]) && Spielefield.b == (moveIN.player2_move_y[moveIN.player2_move_y.length - 1] - 1)) ||
                (Spielefield.a == (moveIN.player2_move_x[moveIN.player2_move_x.length - 1]) && Spielefield.b == (moveIN.player2_move_y[moveIN.player2_move_y.length - 1] + 1))) {
            // if there is a Kuppel and the last Move was high enough to reach this Field
            if ((Spielefield.Field[Spielefield.a][Spielefield.b] == Spielefield.Field[moveIN.player2_move_x[moveIN.player2_move_x.length - 1]][moveIN.player2_move_y[moveIN.player2_move_y.length - 1]])&&
                    (Spielefield.Field[Spielefield.a][Spielefield.b] <5) ){
                ifbkuppelright = true;
            } else {
                ifbkuppelright = false;
                System.out.print("cant Kuppel there");
            }
        } else {
            ifbkuppelright= false;
            System.out.print("cant Kuppel there");

        }
        return ifbkuppelright;
    }

}

