/**
 * @author Youran Wang : youran.wang@student.uni-luebeck.de
 * modified by  Youran Wang (719511)
 */
package tnt.spiele;

import tnt.enginee.Position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * player1_List_put : record the position of put for player1
 * player2_List_put : record the position of put for player2
 * player1_put_x : record the X of put for player1
 * player1_put_y : record the Y of put for player1
 * player2_put_x : record the X of put for player2
 * player2_put_y : record the Y of put for player2
 */
public class putIN  {
    // the List of positions for the Kuppels
    public static List player1_List_put=new ArrayList<>();
    public static List<Integer> player1_put_x=new ArrayList<>();
    public static List<Integer> player1_put_y=new ArrayList<>();
    public static List player2_List_put=new ArrayList<>();
    public static List<Integer> player2_put_x= new ArrayList<>();
    public static List<Integer> player2_put_y= new ArrayList<>();
    /**
     * This Methode is for Put of A
     * all the Positions, which A put will add to a ArrayList to record.
     */
    public static void putA(){
        // Position will be recorded in Arraylists
        player1_List_put.add(new Position(Spielefield.a,Spielefield.b));
        player1_put_x.add(Spielefield.a);
        player1_put_y.add(Spielefield.b);
        System.out.println(player1_List_put);
        // print the Matrix and add the build into the Matrix
        for (int i = 0; i < Spielefield.Field.length; i++) {
            for (int j = 0; j < Spielefield.Field[i].length; j++) {
                System.out.print(Spielefield.Field[j][i]);
            }
            System.out.println();
        }
        System.out.println("put-------A----------");
    }
    /**
     * This Methode is for Put of B
     * all the Positions, which B put will add to a ArrayList to record.
     */
    public static void putB(){
        // Position will be recorded in Arraylists
        player2_List_put.add(new Position(Spielefield.a,Spielefield.b));
        player2_put_x.add(Spielefield.a);
        player2_put_y.add(Spielefield.b);
        // print the Matrix and add the build into the Matrix
        for (int i = 0; i < Spielefield.Field.length; i++) {
            for (int j = 0; j < Spielefield.Field[i].length; j++) {
                System.out.print(Spielefield.Field[j][i]);
            }
            System.out.println();
        }
        System.out.println("put-------B----------");
    }
    /**
     * This Methode is for Clearing all parameter
     * all the parameter will be set as undefinited
     */
    public static void clear(){
        player1_List_put=new ArrayList<>();
        player1_put_x=new ArrayList<>();
        player1_put_y=new ArrayList<>();
        player2_List_put=new ArrayList<>();
        player2_put_x= new ArrayList<>();
        player2_put_y= new ArrayList<>();
    }
}
