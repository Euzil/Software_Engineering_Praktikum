/**
 * @author Youran Wang : youran.wang@student.uni-luebeck.de
 * modified by  Youran Wang (719511)
 */
package tnt.spiele;
public class Regelcheck_3er {
    /**
     * its the Methode to check, if A already won the Game
     *
     * @return if A win
     */
    public static boolean ifAwin() {
        if (Spielefield_3er.Field[Spielefield_3er.a][Spielefield_3er.b] == 4) {
            System.out.println("A win");
            return true;
        } else {
            return false;
        }
    }
    /**
     * its the Methode to check, if B already won the Game
     *
     * @return if B win
     */
    public static boolean ifBwin() {
        if (Spielefield_3er.Field[Spielefield_3er.a][Spielefield_3er.b] == 4) {
            System.out.println("B win");
            return true;
        } else {
            return false;
        }
    }
    /**
     * its the Methode to check, if C already won the Game
     *
     * @return if C win
     */
    public static boolean ifCwin() {
        if (Spielefield_3er.Field[Spielefield_3er.a][Spielefield_3er.b] == 4) {
            System.out.println("C win");
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
        for (int q = 0; q < putIN_3er.player1_List_put.size(); q++) {
            if (putIN_3er.player1_put_x.get(q) == Spielefield_3er.a && putIN_3er.player1_put_y.get(q) == Spielefield_3er.b) {
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
        for (int q = 0; q < putIN_3er.player2_List_put.size(); q++) {
            if (putIN_3er.player2_put_x.get(q) == Spielefield_3er.a && putIN_3er.player2_put_y.get(q) == Spielefield_3er.b) {
                ifinblist=true;
            }
        }
        return ifinblist;
    }
    /** Its the Methode to check, if the posotion was been choose by player 2
     *
     * @return if this Position in
     */
    private static boolean ifInCList() {
        boolean ifinclist = false;
        for (int q = 0; q < putIN_3er.player3_List_put.size(); q++) {
            if (putIN_3er.player3_put_x.get(q) == Spielefield_3er.a && putIN_3er.player3_put_y.get(q) == Spielefield_3er.b) {
                ifinclist=true;
            }
        }
        return ifinclist;
    }
    /**
     * Its the Methode to check, if A can move to here
     *
     * @return if a Move Right
     */
    public static boolean ifAMoveRight() {
        boolean ifamoveright = true;
        // if the posotion was been choose by player 2 and player 3
        if(ifInCList()==false && ifInBList()==false) {
            // if there is a Kuppel
            if (Spielefield_3er.Field[Spielefield_3er.a][Spielefield_3er.b] < 5) {
                //if there is near to the last move
                if (    (Spielefield_3er.a == (moveIN_3er.player1_move_x[moveIN_3er.player1_move_x.length - 1] - 1) && Spielefield_3er.b == (moveIN_3er.player1_move_y[moveIN_3er.player1_move_y.length - 1])) ||
                        (Spielefield_3er.a == (moveIN_3er.player1_move_x[moveIN_3er.player1_move_x.length - 1] + 1) && Spielefield_3er.b == (moveIN_3er.player1_move_y[moveIN_3er.player1_move_y.length - 1])) ||
                        (Spielefield_3er.a == (moveIN_3er.player1_move_x[moveIN_3er.player1_move_x.length - 1]) && Spielefield_3er.b == (moveIN_3er.player1_move_y[moveIN_3er.player1_move_y.length - 1] - 1)) ||
                        (Spielefield_3er.a == (moveIN_3er.player1_move_x[moveIN_3er.player1_move_x.length - 1]) && Spielefield_3er.b == (moveIN_3er.player1_move_y[moveIN_3er.player1_move_y.length - 1] + 1)) ||
                        (Spielefield_3er.a == (moveIN_3er.player1_move_x[moveIN_3er.player1_move_x.length - 1] + 1) && Spielefield_3er.b == (moveIN_3er.player1_move_y[moveIN_3er.player1_move_y.length - 1] + 1)) ||
                        (Spielefield_3er.a == (moveIN_3er.player1_move_x[moveIN_3er.player1_move_x.length - 1] + 1) && Spielefield_3er.b == (moveIN_3er.player1_move_y[moveIN_3er.player1_move_y.length - 1] - 1)) ||
                        (Spielefield_3er.a == (moveIN_3er.player1_move_x[moveIN_3er.player1_move_x.length - 1] - 1) && Spielefield_3er.b == (moveIN_3er.player1_move_y[moveIN_3er.player1_move_y.length - 1] + 1)) ||
                        (Spielefield_3er.a == (moveIN_3er.player1_move_x[moveIN_3er.player1_move_x.length - 1] - 1) && Spielefield_3er.b == (moveIN_3er.player1_move_y[moveIN_3er.player1_move_y.length - 1] - 1))) {
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
    /**
     * Its the Methode to check, if B can move to here
     *
     * @return if b Move Right
     */
    public static boolean ifBMoveRight() {
        boolean ifbmoveright = true;
        // if the posotion was been choose by player 1 and player 3
        if(ifInCList()==false && ifInAList()==false) {
            // if there is a Kuppel
            if (Spielefield_3er.Field[Spielefield.a][Spielefield.b] < 5) {
                // if there is near to the last move
                if ((Spielefield_3er.a == (moveIN_3er.player2_move_x[moveIN_3er.player2_move_x.length - 1] - 1) && Spielefield_3er.b == (moveIN_3er.player2_move_y[moveIN_3er.player2_move_y.length - 1])) ||
                        (Spielefield_3er.a == (moveIN_3er.player2_move_x[moveIN_3er.player2_move_x.length - 1] + 1) && Spielefield_3er.b == (moveIN_3er.player2_move_y[moveIN_3er.player2_move_y.length - 1])) ||
                        (Spielefield_3er.a == (moveIN_3er.player2_move_x[moveIN_3er.player2_move_x.length - 1]) && Spielefield_3er.b == (moveIN_3er.player2_move_y[moveIN_3er.player2_move_y.length - 1] - 1)) ||
                        (Spielefield_3er.a == (moveIN_3er.player2_move_x[moveIN_3er.player2_move_x.length - 1]) && Spielefield_3er.b == (moveIN_3er.player2_move_y[moveIN_3er.player2_move_y.length - 1] + 1)) ||
                        (Spielefield_3er.a == (moveIN_3er.player2_move_x[moveIN_3er.player2_move_x.length - 1] + 1) && Spielefield_3er.b == (moveIN_3er.player2_move_y[moveIN_3er.player2_move_y.length - 1] + 1)) ||
                        (Spielefield_3er.a == (moveIN_3er.player2_move_x[moveIN_3er.player2_move_x.length - 1] + 1) && Spielefield_3er.b == (moveIN_3er.player2_move_y[moveIN_3er.player2_move_y.length - 1] - 1)) ||
                        (Spielefield_3er.a == (moveIN_3er.player2_move_x[moveIN_3er.player2_move_x.length - 1] - 1) && Spielefield_3er.b == (moveIN_3er.player2_move_y[moveIN_3er.player2_move_y.length - 1] + 1)) ||
                        (Spielefield_3er.a == (moveIN_3er.player2_move_x[moveIN_3er.player2_move_x.length - 1] - 1) && Spielefield_3er.b == (moveIN_3er.player2_move_y[moveIN_3er.player2_move_y.length - 1] - 1))) {
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
    /**
     * Its the Methode to check, if C can move to here
     *
     * @return if c Move Right
     */
    public static boolean ifCMoveRight() {
        boolean ifbmoveright = true;
        // if the posotion was been choose by player 1 and player 2
        if(ifInAList()==false && ifInBList()==false){
            // if there is a Kuppe
            if (Spielefield_3er.Field[Spielefield_3er.a][Spielefield_3er.b] < 5) {
                // if there is near to the last move
                if ((Spielefield_3er.a == (moveIN_3er.player3_move_x[moveIN_3er.player3_move_x.length - 1] - 1) && Spielefield_3er.b == (moveIN_3er.player3_move_y[moveIN_3er.player3_move_y.length - 1])) ||
                        (Spielefield_3er.a == (moveIN_3er.player3_move_x[moveIN_3er.player3_move_x.length - 1] + 1) && Spielefield_3er.b == (moveIN_3er.player3_move_y[moveIN_3er.player3_move_y.length - 1])) ||
                        (Spielefield_3er.a == (moveIN_3er.player3_move_x[moveIN_3er.player3_move_x.length - 1]) && Spielefield_3er.b == (moveIN_3er.player3_move_y[moveIN_3er.player3_move_y.length - 1] - 1)) ||
                        (Spielefield_3er.a == (moveIN_3er.player3_move_x[moveIN_3er.player3_move_x.length - 1]) && Spielefield_3er.b == (moveIN_3er.player3_move_y[moveIN_3er.player3_move_y.length - 1] + 1)) ||
                        (Spielefield_3er.a == (moveIN_3er.player3_move_x[moveIN_3er.player3_move_x.length - 1] + 1) && Spielefield_3er.b == (moveIN_3er.player3_move_y[moveIN_3er.player3_move_y.length - 1] + 1 )) ||
                        (Spielefield_3er.a == (moveIN_3er.player3_move_x[moveIN_3er.player3_move_x.length - 1] + 1) && Spielefield_3er.b == (moveIN_3er.player3_move_y[moveIN_3er.player3_move_y.length - 1] - 1 )) ||
                        (Spielefield_3er.a == (moveIN_3er.player3_move_x[moveIN_3er.player3_move_x.length - 1] - 1) && Spielefield_3er.b == (moveIN_3er.player3_move_y[moveIN_3er.player3_move_y.length - 1] + 1 )) ||
                        (Spielefield_3er.a == (moveIN_3er.player3_move_x[moveIN_3er.player3_move_x.length - 1] - 1) && Spielefield_3er.b == (moveIN_3er.player3_move_y[moveIN_3er.player3_move_y.length - 1] - 1 ))) {
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
    /**
     * Its the Methode to check, if A can put to here
     *
     * @return if a Put Right
     */
    public static boolean ifAPutRight() {
        boolean ifaputright = true;
        // if the posotion was been choose by player 2 and player 3
        if(ifInCList()==false && ifInBList()==false) {
            // if there is near to the last move
            if ((Spielefield_3er.a == (moveIN_3er.player1_move_x[moveIN_3er.player1_move_x.length - 1] - 1) && Spielefield_3er.b == (moveIN_3er.player1_move_y[moveIN_3er.player1_move_y.length - 1])) ||
                    (Spielefield_3er.a == (moveIN_3er.player1_move_x[moveIN_3er.player1_move_x.length - 1] + 1) && Spielefield_3er.b == (moveIN_3er.player1_move_y[moveIN_3er.player1_move_y.length - 1])) ||
                    (Spielefield_3er.a == (moveIN_3er.player1_move_x[moveIN_3er.player1_move_x.length - 1]) && Spielefield_3er.b == (moveIN_3er.player1_move_y[moveIN_3er.player1_move_y.length - 1] - 1)) ||
                    (Spielefield_3er.a == (moveIN_3er.player1_move_x[moveIN_3er.player1_move_x.length - 1]) && Spielefield_3er.b == (moveIN_3er.player1_move_y[moveIN_3er.player1_move_y.length - 1] + 1)) ||
                    (Spielefield_3er.a == (moveIN_3er.player1_move_x[moveIN_3er.player1_move_x.length - 1] + 1) && Spielefield_3er.b == (moveIN_3er.player1_move_y[moveIN_3er.player1_move_y.length - 1] + 1)) ||
                    (Spielefield_3er.a == (moveIN_3er.player1_move_x[moveIN_3er.player1_move_x.length - 1] + 1) && Spielefield_3er.b == (moveIN_3er.player1_move_y[moveIN_3er.player1_move_y.length - 1] - 1)) ||
                    (Spielefield_3er.a == (moveIN_3er.player1_move_x[moveIN_3er.player1_move_x.length - 1] - 1) && Spielefield_3er.b == (moveIN_3er.player1_move_y[moveIN_3er.player1_move_y.length - 1] + 1)) ||
                    (Spielefield_3er.a == (moveIN_3er.player1_move_x[moveIN_3er.player1_move_x.length - 1] - 1) && Spielefield_3er.b == (moveIN_3er.player1_move_y[moveIN_3er.player1_move_y.length - 1] - 1))) {
                // if there is a Kuppel and the last Move was high enough to reach this Field
                if ((Spielefield_3er.Field[Spielefield_3er.a][Spielefield_3er.b] == Spielefield_3er.Field[moveIN_3er.player1_move_x[moveIN_3er.player1_move_x.length - 1]][moveIN_3er.player1_move_y[moveIN_3er.player1_move_y.length - 1]]) &&
                        (Spielefield_3er.Field[Spielefield_3er.a][Spielefield_3er.b] < 5)) {
                    ifaputright = true;
                } else {
                    ifaputright = false;
                    System.out.print("cant put there");
                }
            } else {
                ifaputright = false;
                System.out.print("cant put there");
            }
        }else {
            ifaputright = false;
            System.out.print("cant put there");
        }
        return ifaputright;
    }
    /**
     * Its the Methode to check, if A can put to here
     *
     * @return if a Put Right
     */
    public static boolean ifBPutRight() {
        boolean ifbputright = true;
        // if the posotion was been choose by player 1 and player 3
        if(ifInAList()==false && ifInCList()==false) {
            // if there is near to the last move
            if ((Spielefield_3er.a == (moveIN_3er.player2_move_x[moveIN_3er.player2_move_x.length - 1] - 1) && Spielefield_3er.b == (moveIN_3er.player2_move_y[moveIN_3er.player2_move_y.length - 1])) ||
                    (Spielefield_3er.a == (moveIN_3er.player2_move_x[moveIN_3er.player2_move_x.length - 1] + 1) && Spielefield_3er.b == (moveIN_3er.player2_move_y[moveIN_3er.player2_move_y.length - 1])) ||
                    (Spielefield_3er.a == (moveIN_3er.player2_move_x[moveIN_3er.player2_move_x.length - 1]) && Spielefield_3er.b == (moveIN_3er.player2_move_y[moveIN_3er.player2_move_y.length - 1] - 1)) ||
                    (Spielefield_3er.a == (moveIN_3er.player2_move_x[moveIN_3er.player2_move_x.length - 1]) && Spielefield_3er.b == (moveIN_3er.player2_move_y[moveIN_3er.player2_move_y.length - 1] + 1)) ||
                    (Spielefield_3er.a == (moveIN_3er.player2_move_x[moveIN_3er.player2_move_x.length - 1] + 1) && Spielefield_3er.b == (moveIN_3er.player2_move_y[moveIN_3er.player2_move_y.length - 1] + 1)) ||
                    (Spielefield_3er.a == (moveIN_3er.player2_move_x[moveIN_3er.player2_move_x.length - 1] + 1) && Spielefield_3er.b == (moveIN_3er.player2_move_y[moveIN_3er.player2_move_y.length - 1] - 1)) ||
                    (Spielefield_3er.a == (moveIN_3er.player2_move_x[moveIN_3er.player2_move_x.length - 1] - 1) && Spielefield_3er.b == (moveIN_3er.player2_move_y[moveIN_3er.player2_move_y.length - 1] + 1)) ||
                    (Spielefield_3er.a == (moveIN_3er.player2_move_x[moveIN_3er.player2_move_x.length - 1] - 1) && Spielefield_3er.b == (moveIN_3er.player2_move_y[moveIN_3er.player2_move_y.length - 1] - 1))) {
                // if there is a Kuppel and the last Move was high enough to reach this Field
                if ((Spielefield_3er.Field[Spielefield_3er.a][Spielefield_3er.b] == Spielefield_3er.Field[moveIN_3er.player2_move_x[moveIN_3er.player2_move_x.length - 1]][moveIN_3er.player2_move_y[moveIN_3er.player2_move_y.length - 1]]) &&
                        (Spielefield_3er.Field[Spielefield_3er.a][Spielefield_3er.b] < 5)) {
                    ifbputright = true;
                } else {
                    ifbputright = false;
                    System.out.print("cant put there");
                }
            } else {
                ifbputright = false;
                System.out.print("cant put there");
            }
        }else {
            ifbputright = false;
            System.out.print("cant put there");
        }
        return ifbputright;
    }
     /*
     * Its the Methode to check, if C can put to here
     *
     * @return if c Put Right
     */
    public static boolean ifCPutRight() {
        boolean ifcputright = true;
        // if the posotion was been choose by player 1 and player 2
        if(ifInAList()==false && ifInBList()==false) {
            // if there is near to the last move
            if ((Spielefield_3er.a == (moveIN_3er.player3_move_x[moveIN_3er.player3_move_x.length - 1] - 1) && Spielefield_3er.b == (moveIN_3er.player3_move_y[moveIN_3er.player3_move_y.length - 1])) ||
                    (Spielefield_3er.a == (moveIN_3er.player3_move_x[moveIN_3er.player3_move_x.length - 1] + 1) && Spielefield_3er.b == (moveIN_3er.player3_move_y[moveIN_3er.player3_move_y.length - 1])) ||
                    (Spielefield_3er.a == (moveIN_3er.player3_move_x[moveIN_3er.player3_move_x.length - 1]) && Spielefield_3er.b == (moveIN_3er.player3_move_y[moveIN_3er.player3_move_y.length - 1] - 1)) ||
                    (Spielefield_3er.a == (moveIN_3er.player3_move_x[moveIN_3er.player3_move_x.length - 1]) && Spielefield_3er.b == (moveIN_3er.player3_move_y[moveIN_3er.player3_move_y.length - 1] + 1)) ||
                    (Spielefield_3er.a == (moveIN_3er.player3_move_x[moveIN_3er.player3_move_x.length - 1] + 1) && Spielefield_3er.b == (moveIN_3er.player3_move_y[moveIN_3er.player3_move_y.length - 1] + 1)) ||
                    (Spielefield_3er.a == (moveIN_3er.player3_move_x[moveIN_3er.player3_move_x.length - 1] + 1) && Spielefield_3er.b == (moveIN_3er.player3_move_y[moveIN_3er.player3_move_y.length - 1] - 1)) ||
                    (Spielefield_3er.a == (moveIN_3er.player3_move_x[moveIN_3er.player3_move_x.length - 1] - 1) && Spielefield_3er.b == (moveIN_3er.player3_move_y[moveIN_3er.player3_move_y.length - 1] + 1)) ||
                    (Spielefield_3er.a == (moveIN_3er.player3_move_x[moveIN_3er.player3_move_x.length - 1] - 1) && Spielefield_3er.b == (moveIN_3er.player3_move_y[moveIN_3er.player3_move_y.length - 1] - 1))) {
                // if there is a Kuppel and the last Move was high enough to reach this Fieldif ((Spielefield_3er.Field[Spielefield_3er.a][Spielefield_3er.b] == Spielefield_3er.Field[moveIN_3er.player3_move_x[moveIN_3er.player3_move_x.length - 1]][moveIN_3er.player3_move_y[moveIN_3er.player3_move_y.length - 1]])&&
                if ((Spielefield_3er.Field[Spielefield_3er.a][Spielefield_3er.b] == Spielefield_3er.Field[moveIN_3er.player3_move_x[moveIN_3er.player3_move_x.length - 1]][moveIN_3er.player3_move_y[moveIN_3er.player3_move_y.length - 1]]) &&
                        Spielefield_3er.Field[Spielefield_3er.a][Spielefield_3er.b] < 5) {
                    ifcputright = true;
                } else {
                    ifcputright = false;
                    System.out.print("cant put there");
                }
            } else {
                ifcputright = false;
                System.out.print("cant put there");
            }
        }else{
            ifcputright = false;
            System.out.print("cant put there");
        }
        return ifcputright;
    }
    /**
     * Its the Methode to check, if A can Kuppel to here
     *
     * @return if a kuppel Right
     */
    public static boolean ifAKuppelRight() {
        boolean ifakuppelright = true;
        // if there is near to the last move
        if (    (Spielefield_3er.a == (moveIN_3er.player1_move_x[moveIN_3er.player1_move_x.length - 1] - 1) && Spielefield_3er.b == (moveIN_3er.player1_move_y[moveIN_3er.player1_move_y.length - 1])) ||
                (Spielefield_3er.a == (moveIN_3er.player1_move_x[moveIN_3er.player1_move_x.length - 1] + 1) && Spielefield_3er.b == (moveIN_3er.player1_move_y[moveIN_3er.player1_move_y.length - 1])) ||
                (Spielefield_3er.a == (moveIN_3er.player1_move_x[moveIN_3er.player1_move_x.length - 1]) && Spielefield_3er.b == (moveIN_3er.player1_move_y[moveIN_3er.player1_move_y.length - 1] - 1)) ||
                (Spielefield_3er.a == (moveIN_3er.player1_move_x[moveIN_3er.player1_move_x.length - 1]) && Spielefield_3er.b == (moveIN_3er.player1_move_y[moveIN_3er.player1_move_y.length - 1] + 1))) {
            // if there is a Kuppel and the last Move was high enough to reach this Field
            if ((Spielefield_3er.Field[Spielefield_3er.a][Spielefield_3er.b] == Spielefield_3er.Field[moveIN_3er.player1_move_x[moveIN_3er.player1_move_x.length - 1]][moveIN_3er.player1_move_y[moveIN_3er.player1_move_y.length - 1]]) &&
                    (Spielefield_3er.Field[Spielefield_3er.a][Spielefield_3er.b] < 5)) {
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
    /**
     * Its the Methode to check, if A can Kuppel to here
     *
     * @return if a kuppel Right
     */
    public static boolean ifBKuppelRight() {
        boolean ifbkuppelright = true;
        // if there is near to the last move
        if ((Spielefield_3er.a == (moveIN_3er.player2_move_x[moveIN_3er.player2_move_x.length - 1] - 1) && Spielefield_3er.b == (moveIN_3er.player2_move_y[moveIN_3er.player2_move_y.length - 1])) ||
                (Spielefield_3er.a == (moveIN_3er.player2_move_x[moveIN_3er.player2_move_x.length - 1] + 1) && Spielefield_3er.b == (moveIN_3er.player2_move_y[moveIN_3er.player2_move_y.length - 1])) ||
                (Spielefield_3er.a == (moveIN_3er.player2_move_x[moveIN_3er.player2_move_x.length - 1]) && Spielefield_3er.b == (moveIN_3er.player2_move_y[moveIN_3er.player2_move_y.length - 1] - 1)) ||
                (Spielefield_3er.a == (moveIN_3er.player2_move_x[moveIN_3er.player2_move_x.length - 1]) && Spielefield_3er.b == (moveIN_3er.player2_move_y[moveIN_3er.player2_move_y.length - 1] + 1))) {
            // if there is a Kuppel and the last Move was high enough to reach this Field
            if ((Spielefield_3er.Field[Spielefield_3er.a][Spielefield_3er.b] == Spielefield_3er.Field[moveIN_3er.player2_move_x[moveIN_3er.player2_move_x.length - 1]][moveIN_3er.player2_move_y[moveIN_3er.player2_move_y.length - 1]]) &&
                    (Spielefield_3er.Field[Spielefield_3er.a][Spielefield_3er.b] < 5)) {
                ifbkuppelright = true;
            } else {
                ifbkuppelright = false;
                System.out.print("cant Kuppel there");
            }
        } else {
            ifbkuppelright = false;
            System.out.print("cant Kuppel there");
        }
        return ifbkuppelright;
    }
    /**
     * Its the Methode to check, if C can Kuppel to here
     *
     * @return if c kuppel Right
     */
    public static boolean ifCKuppelRight() {
        boolean ifckuppelright = true;
        // if there is near to the last move
        if ((Spielefield_3er.a == (moveIN_3er.player3_move_x[moveIN_3er.player3_move_x.length - 1] - 1) && Spielefield_3er.b == (moveIN_3er.player3_move_y[moveIN_3er.player3_move_y.length - 1])) ||
                (Spielefield_3er.a == (moveIN_3er.player3_move_x[moveIN_3er.player3_move_x.length - 1] + 1) && Spielefield_3er.b == (moveIN_3er.player3_move_y[moveIN_3er.player3_move_y.length - 1])) ||
                (Spielefield_3er.a == (moveIN_3er.player3_move_x[moveIN_3er.player3_move_x.length - 1]) && Spielefield_3er.b == (moveIN_3er.player3_move_y[moveIN_3er.player3_move_y.length - 1] - 1)) ||
                (Spielefield_3er.a == (moveIN_3er.player3_move_x[moveIN_3er.player3_move_x.length - 1]) && Spielefield_3er.b == (moveIN_3er.player3_move_y[moveIN_3er.player3_move_y.length - 1] + 1))) {
            // if there is a Kuppel and the last Move was high enough to reach this Fieldif ((Spielefield_3er.Field[Spielefield_3er.a][Spielefield_3er.b] == Spielefield_3er.Field[moveIN_3er.player3_move_x[moveIN_3er.player3_move_x.length - 1]][moveIN_3er.player3_move_y[moveIN_3er.player3_move_y.length - 1]])&&
            if ((Spielefield_3er.Field[Spielefield_3er.a][Spielefield_3er.b] == Spielefield_3er.Field[moveIN_3er.player3_move_x[moveIN_3er.player3_move_x.length - 1]][moveIN_3er.player3_move_y[moveIN_3er.player3_move_y.length - 1]]) &&
                    Spielefield_3er.Field[Spielefield_3er.a][Spielefield_3er.b] < 5) {
                ifckuppelright = true;
            } else {
                ifckuppelright = false;
                System.out.print("cant Kuppel there");
            }
        } else {
            ifckuppelright = false;
            System.out.print("cant Kuppel there");
        }
        return ifckuppelright;
    }


}



