/**
 * @author Youran Wang : youran.wang@student.uni-luebeck.de
 * modified by  Youran Wang (719511)
 */
package tnt.spiele;
import tnt.enginee.Position;

import java.util.ArrayList;
import java.util.List;

/** variable
 * player_List_kuppel : record the Posotion of all Kuppels
 * kuppel_put_x : record the X of all Kuppels
 * kuppel_put_y : record the Y of all Kuppels
 */
public class kuppel {
    // the List of positions for the Kuppels
    public static List player_List_kuppel=new ArrayList<>();
    public static List<Integer> kuppel_put_x=new ArrayList<>();
    public static List<Integer> kuppel_put_y=new ArrayList<>();
    /**
     * This Methode is for Kuppel of A
     * all the Positions, which A moved will add to a ArrayList to record.
     */
    public static void kuppelA() {
        // Position will be recorded in Arraylists
        player_List_kuppel.add(new Position(Spielefield.a,Spielefield.b));
        kuppel_put_x.add(Spielefield.a);
        kuppel_put_y.add(Spielefield.b);
        // print the Matrix and add the kuppel into the Matrix
        for (int i = 0; i < Spielefield.Field.length; i++) {
            for (int j = 0; j < Spielefield.Field[i].length; j++) {
                System.out.print(Spielefield.Field[j][i]);
            }
            System.out.println();
        }
        System.out.println("put-------A----------");
    }
    /**
     * This Methode is for Kuppel of B
     * all the Positions, which B moved will add to a ArrayList to record.
     */
    public static void kuppelB() {
        // Position will be recorded in Arraylists
        player_List_kuppel.add(new Position(Spielefield.a,Spielefield.b));
        kuppel_put_x.add(Spielefield.a);
        kuppel_put_y.add(Spielefield.b);
        // print the Matrix and add the kuppel into the Matrix
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
        player_List_kuppel=new ArrayList<>();
        kuppel_put_x=new ArrayList<>();
        kuppel_put_y=new ArrayList<>();
    }
}
