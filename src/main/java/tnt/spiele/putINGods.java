/**
 * modified by  Youran Wang (719511)
 * and by Finn Hinrichs (712699)
 */
package tnt.spiele;

import tnt.enginee.Position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class putINGods extends moveINGods  {
    // the List of positions for the Kuppels
    public static List player1_List_put=new ArrayList<>();
    public static List<Integer> player1_put_x=new ArrayList<>();
    public static List<Integer> player1_put_y=new ArrayList<>();

    public static List player2_List_put=new ArrayList<>();
    public static List<Integer> player2_put_x= new ArrayList<>();
    public static List<Integer> player2_put_y= new ArrayList<>();
    
    public static boolean pl1_p1_moved = false;
    public static boolean pl1_p2_moved = false;
    public static boolean pl2_p1_moved = false;
    public static boolean pl2_p2_moved = false;

    // print the Matrix and add the build into the Matrix
    public static void putA(){
        player1_List_put.add(new Position(Spielefield.a,Spielefield.b));
        player1_put_x.add(Spielefield.a);
        player1_put_y.add(Spielefield.b);
        System.out.println(player1_List_put);
        for (int i = 0; i < Spielefield.Field.length; i++) {
            for (int j = 0; j < Spielefield.Field[i].length; j++) {
                System.out.print(Spielefield.Field[j][i]);
            }
            System.out.println();
        }
        System.out.println(player1_List_put.size());
        System.out.println("put-------A----------");
    }
    
    // print the Matrix and add the build into the Matrix
    public static void putB(){
        player2_List_put.add(new Position(Spielefield.a,Spielefield.b));
        player2_put_x.add(Spielefield.a);
        player2_put_y.add(Spielefield.b);
        for (int i = 0; i < Spielefield.Field.length; i++) {
            for (int j = 0; j < Spielefield.Field[i].length; j++) {
                System.out.print(Spielefield.Field[j][i]);
            }
            System.out.println();
        }
        System.out.println(player2_List_put.size());
        System.out.println("put-------B----------");
    }
    public static void main(String[] args) {
    }
}
