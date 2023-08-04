/**
 * @author Youran Wang : youran.wang@student.uni-luebeck.de
 * modified by  Youran Wang (719511)
 */
package tnt.spiele;

import tnt.enginee.Position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** variable
 * player1_List_move : record the position of movement for player1
 * player2_List_move : record the position of movement for player2
 * player1_move_x : record the X of movement for player1
 * player1_move_y : record the Y of movement for player1
 * player2_move_x : record the X of movement for player2
 * player2_move_y : record the Y of movement for player2
 */
public class moveIN  {
    // the List of positions for the move
    public static List player1_List_move=new ArrayList<>();
    public static int player1_move_x[] = new int[200];
    public static int player1_move_y[] = new int[200];
    public static List player2_List_move=new ArrayList<>();
    public static int player2_move_x[] = new int[200];
    public static int player2_move_y[] = new int[200];
    /**
     * This Methode is for Movemnt of A
     * all the Positions, which A moved will add to a ArrayList to record.
     */
    public static void moveA(){
        // Position will be recorded in Arraylists
        player1_List_move.add(new Position(Spielefield.a,Spielefield.b));
        Arrays.fill(player1_move_x,Spielefield.a);
        Arrays.fill(player1_move_y,Spielefield.b);
        // print the Matrix and add the move into the Matrix
        for (int i = 0; i < Spielefield.Field.length; i++) {
            for (int j = 0; j < Spielefield.Field[i].length; j++) {
                System.out.print(Spielefield.Field[j][i]);
            }
            System.out.println();
        }
        System.out.println("move-------A----------");
    }
    /**
     * This Methode is for Movemnt of B
     * all the Positions, which B moved will add to a ArrayList to record.
     */
    public static void moveB() {
        // Position will be recorded in Arraylists
        player2_List_move.add(new Position(Spielefield.a,Spielefield.b));
        Arrays.fill(player2_move_x,Spielefield.a);
        Arrays.fill(player2_move_y,Spielefield.b);
        // print the Matrix and add the move into the Matrix
            for (int i = 0; i < Spielefield.Field.length; i++) {
                for (int j = 0; j < Spielefield.Field[i].length; j++) {
                    System.out.print(Spielefield.Field[j][i]);
                }
                System.out.println();
            }
            System.out.println("move-------B----------");
        }
    /**
     * This Methode is for Clearing all parameter
     * all the parameter will be set as undefinited
     */
    public static void Clear(){
        player1_List_move=new ArrayList<>();
        player1_move_x = new int[200];
        player1_move_y= new int[200];
        player2_List_move=new ArrayList<>();
        player2_move_x = new int[200];
        player2_move_y = new int[200];
    }
}

