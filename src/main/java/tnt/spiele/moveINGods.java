/**
 * modified by  Youran Wang (719511)
 * and by Finn Hinrchs (712699)
 */
package tnt.spiele;

import tnt.enginee.Position;
import tnt.enginee.Pawn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class moveINGods {
    // the List of positions for the move
    public static List<Position> player1_pawn1_List_move=new ArrayList<>();

    public static int player1_pawn1_move_x[] = new int[200];
    public static int player1_pawn1_move_y[] = new int[200];

    public static List<Position> player1_pawn2_List_move=new ArrayList<>();

    public static int player1_pawn2_move_x[] = new int[200];
    public static int player1_pawn2_move_y[] = new int[200];

    public static List<Position> player2_pawn1_List_move=new ArrayList<>();

    public static int player2_pawn1_move_x[] = new int[200];
    public static int player2_pawn1_move_y[] = new int[200];

    public static List<Position> player2_pawn2_List_move=new ArrayList<>();

    public static int player2_pawn2_move_x[] = new int[200];
    public static int player2_pawn2_move_y[] = new int[200];
    
    public static Pawn pl1_p1 = new Pawn(new Position(0,0));
    public static Pawn pl1_p2 = new Pawn(new Position(0,0));
    public static Pawn pl2_p1 = new Pawn(new Position(0,0));
    public static Pawn pl2_p2 = new Pawn(new Position(0,0));
    
    public static boolean selectPl1_p1 = false;
    public static boolean selectPl1_p2 = false;
    public static boolean selectPl2_p1 = false;
    public static boolean selectPl2_p2 = false;

    /*public static List player1_List_move=new ArrayList<>();

    public static int player1_move_x[] = new int[200];
    public static int player1_move_y[] = new int[200];
    public static List player2_List_move=new ArrayList<>();

    public static int player2_move_x[] = new int[200];
    public static int player2_move_y[] = new int[200];*/

    //For now p1 and p2 are only placeholders, the proper references still need to be added.
    public static void selectPawnPl1(){
        if(SpielefieldGods.a == pl1_p1.getPosition().getX() && SpielefieldGods.b == pl1_p1.getPosition().getY()){
            //moveA();
        	selectPl1_p1 = true;
        	System.out.println("Player1 selected Pawn1");
        }else if(SpielefieldGods.a == pl1_p2.getPosition().getX() && SpielefieldGods.b == pl1_p2.getPosition().getY()){
            //moveC();
        	selectPl1_p2 = true;
        	System.out.println("Player1 selected Pawn2");
        }
    }
    
    public static void moveA(){
    	if(AddGods.player1.getGodCard().getGodNumber() == 1) {
    		if(pl2_p1.getPosition().getX() == SpielefieldGods.a && pl2_p1.getPosition().getY() == SpielefieldGods.b) {
    			pl2_p1.setPawnPosition(pl1_p1.getPosition());
    	        pl1_p1.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    		}else if(pl2_p2.getPosition().getX() == SpielefieldGods.a && pl2_p2.getPosition().getY() == SpielefieldGods.b) {
    			pl2_p2.setPawnPosition(pl1_p1.getPosition());
    	        pl1_p1.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    	        
    		}else {
    			pl1_p1.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    		}
    	}if(AddGods.player1.getGodCard().getGodNumber() == 8) {//Minotaur, see if enemy pawn gets moved and where
    		if(pl2_p1.getPosition().getX() == SpielefieldGods.a && pl2_p1.getPosition().getY() == SpielefieldGods.b) {
    			if(pl1_p1.getPosition().getX() < pl2_p1.getPosition().getX()) {
    				if(pl1_p1.getPosition().getY() < pl2_p1.getPosition().getY()) {
    					pl1_p1.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    					pl2_p1.setPawnPosition(new Position(SpielefieldGods.a+1,SpielefieldGods.b+1));
    				}else if(pl1_p1.getPosition().getY() > pl2_p1.getPosition().getY()) {
    					pl1_p1.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    					pl2_p1.setPawnPosition(new Position(SpielefieldGods.a+1,SpielefieldGods.b-1));
    				}else {
    					pl1_p1.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    					pl2_p1.setPawnPosition(new Position(SpielefieldGods.a+1,SpielefieldGods.b));
    				}
    			}else if(pl1_p1.getPosition().getX() > pl2_p1.getPosition().getX()) {
    				if(pl1_p1.getPosition().getY() < pl2_p1.getPosition().getY()) {
    					pl1_p1.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    					pl2_p1.setPawnPosition(new Position(SpielefieldGods.a-1,SpielefieldGods.b+1));
    				}else if(pl1_p1.getPosition().getY() > pl2_p1.getPosition().getY()) {
    					pl1_p1.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    					pl2_p1.setPawnPosition(new Position(SpielefieldGods.a-1,SpielefieldGods.b-1));
    				}else {
    					pl1_p1.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    					pl2_p1.setPawnPosition(new Position(SpielefieldGods.a-1,SpielefieldGods.b));
    				}
    			}else {
    				if(pl1_p1.getPosition().getY() < pl2_p1.getPosition().getY()) {
    					pl1_p1.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    					pl2_p1.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b-1));
    				}else {
    					pl1_p1.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    					pl2_p1.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b+1));
    				}
    			}
    		}else if(pl2_p2.getPosition().getX() == SpielefieldGods.a && pl2_p2.getPosition().getY() == SpielefieldGods.b) {
    			
    		}else {
    			pl1_p1.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    		}
    	}else {
    		pl1_p1.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    	}
    	player1_pawn1_List_move.add(new Position(SpielefieldGods.a,SpielefieldGods.b));
    	Arrays.fill(player1_pawn1_move_x,SpielefieldGods.a);
        Arrays.fill(player1_pawn1_move_y,SpielefieldGods.b);
        for (int i = 0; i < SpielefieldGods.Field.length; i++) {
            for (int j = 0; j < SpielefieldGods.Field[i].length; j++) {
                System.out.print(SpielefieldGods.Field[j][i]);
            }
            System.out.println();
        }
        System.out.println("Move Size: "+(player1_pawn1_List_move.size()+player1_pawn2_List_move.size()));
        System.out.println("move-------Player1----------");
    }

    public static void moveC(){
    	if(AddGods.player1.getGodCard().getGodNumber() == 1) {
    		if(pl2_p1.getPosition().getX() == SpielefieldGods.a && pl2_p1.getPosition().getY() == SpielefieldGods.b) {
    			pl2_p1.setPawnPosition(pl1_p2.getPosition());
    	        pl1_p2.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    		}else if(pl2_p2.getPosition().getX() == SpielefieldGods.a && pl2_p2.getPosition().getY() == SpielefieldGods.b) {
    			pl2_p2.setPawnPosition(pl1_p2.getPosition());
    	        pl1_p2.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    	        
    		}else {
    			pl1_p2.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    		}
    	}if(AddGods.player1.getGodCard().getGodNumber() == 8) {//Minotaur, see if enemy pawn gets moved and where
    		if(pl2_p1.getPosition().getX() == SpielefieldGods.a && pl2_p1.getPosition().getY() == SpielefieldGods.b) {
    			if(pl1_p2.getPosition().getX() < pl2_p1.getPosition().getX()) {
    				if(pl1_p2.getPosition().getY() < pl2_p1.getPosition().getY()) {
    					pl1_p2.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    					pl2_p1.setPawnPosition(new Position(SpielefieldGods.a+1,SpielefieldGods.b+1));
    				}else if(pl1_p2.getPosition().getY() > pl2_p1.getPosition().getY()) {
    					pl1_p2.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    					pl2_p1.setPawnPosition(new Position(SpielefieldGods.a+1,SpielefieldGods.b-1));
    				}else {
    					pl1_p2.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    					pl2_p1.setPawnPosition(new Position(SpielefieldGods.a+1,SpielefieldGods.b));
    				}
    			}else if(pl1_p2.getPosition().getX() > pl2_p1.getPosition().getX()) {
    				if(pl1_p2.getPosition().getY() < pl2_p1.getPosition().getY()) {
    					pl1_p2.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    					pl2_p1.setPawnPosition(new Position(SpielefieldGods.a-1,SpielefieldGods.b+1));
    				}else if(pl1_p2.getPosition().getY() > pl2_p1.getPosition().getY()) {
    					pl1_p2.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    					pl2_p1.setPawnPosition(new Position(SpielefieldGods.a-1,SpielefieldGods.b-1));
    				}else {
    					pl1_p2.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    					pl2_p1.setPawnPosition(new Position(SpielefieldGods.a-1,SpielefieldGods.b));
    				}
    			}else {
    				if(pl1_p2.getPosition().getY() < pl2_p1.getPosition().getY()) {
    					pl1_p2.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    					pl2_p1.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b-1));
    				}else {
    					pl1_p2.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    					pl2_p1.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b+1));
    				}
    			}
    		}else if(pl2_p2.getPosition().getX() == SpielefieldGods.a && pl2_p2.getPosition().getY() == SpielefieldGods.b) {
    			
    		}else {
    			pl1_p2.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    		}
    	}else {
    		pl1_p2.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    	}
    	player1_pawn2_List_move.add(new Position(SpielefieldGods.a,SpielefieldGods.b));
    	Arrays.fill(player1_pawn2_move_x,SpielefieldGods.a);
        Arrays.fill(player1_pawn2_move_y,SpielefieldGods.b);
        for (int i = 0; i < SpielefieldGods.Field.length; i++) {
            for (int j = 0; j < SpielefieldGods.Field[i].length; j++) {
                System.out.print(SpielefieldGods.Field[j][i]);
            }
            System.out.println();
        }
        System.out.println("Move Size: "+(player1_pawn1_List_move.size()+player1_pawn2_List_move.size()));
        System.out.println("move-------Player1----------");
    }
    
    public static void selectPawnPl2(){
        if(SpielefieldGods.a == pl2_p1.getPosition().getX() && SpielefieldGods.b == pl2_p1.getPosition().getY()){
            //moveB();
        	selectPl2_p1 = true;
        	System.out.println("Player2 selected Pawn1");
        }else if(SpielefieldGods.a == pl2_p2.getPosition().getX() && SpielefieldGods.b == pl2_p2.getPosition().getY()){
            //moveD();
        	selectPl2_p2 = true;
        	System.out.println("Player2 selected Pawn2");
        }
    }
    
    public static void moveB(){
    	if(AddGods.player2.getGodCard().getGodNumber() == 1) {
    		if(pl1_p1.getPosition().getX() == SpielefieldGods.a && pl1_p1.getPosition().getY() == SpielefieldGods.b) {
    			pl1_p1.setPawnPosition(pl2_p1.getPosition());
    	        pl2_p1.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    		}else if(pl1_p2.getPosition().getX() == SpielefieldGods.a && pl1_p2.getPosition().getY() == SpielefieldGods.b) {
    			pl1_p2.setPawnPosition(pl2_p1.getPosition());
    	        pl2_p1.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    	        
    		}else {
    			pl2_p1.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    		}
    	}if(AddGods.player2.getGodCard().getGodNumber() == 8) {//Minotaur, see if enemy pawn gets moved and where
    		if(pl1_p1.getPosition().getX() == SpielefieldGods.a && pl1_p1.getPosition().getY() == SpielefieldGods.b) {
    			if(pl2_p1.getPosition().getX() < pl1_p1.getPosition().getX()) {
    				if(pl2_p1.getPosition().getY() < pl1_p1.getPosition().getY()) {
    					pl2_p1.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    					pl1_p1.setPawnPosition(new Position(SpielefieldGods.a+1,SpielefieldGods.b+1));
    				}else if(pl2_p1.getPosition().getY() > pl1_p1.getPosition().getY()) {
    					pl2_p1.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    					pl1_p1.setPawnPosition(new Position(SpielefieldGods.a+1,SpielefieldGods.b-1));
    				}else {
    					pl2_p1.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    					pl1_p1.setPawnPosition(new Position(SpielefieldGods.a+1,SpielefieldGods.b));
    				}
    			}else if(pl2_p1.getPosition().getX() > pl1_p1.getPosition().getX()) {
    				if(pl2_p1.getPosition().getY() < pl1_p1.getPosition().getY()) {
    					pl2_p1.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    					pl1_p1.setPawnPosition(new Position(SpielefieldGods.a-1,SpielefieldGods.b+1));
    				}else if(pl2_p1.getPosition().getY() > pl1_p1.getPosition().getY()) {
    					pl2_p1.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    					pl1_p1.setPawnPosition(new Position(SpielefieldGods.a-1,SpielefieldGods.b-1));
    				}else {
    					pl2_p1.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    					pl1_p1.setPawnPosition(new Position(SpielefieldGods.a-1,SpielefieldGods.b));
    				}
    			}else {
    				if(pl2_p1.getPosition().getY() < pl1_p1.getPosition().getY()) {
    					pl2_p1.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    					pl1_p1.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b-1));
    				}else {
    					pl2_p1.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    					pl1_p1.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b+1));
    				}
    			}
    		}else if(pl1_p2.getPosition().getX() == SpielefieldGods.a && pl1_p2.getPosition().getY() == SpielefieldGods.b) {
    			
    		}else {
    			pl2_p1.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    		}
    	}else {
    		pl2_p1.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    	}
    	player2_pawn1_List_move.add(new Position(SpielefieldGods.a,SpielefieldGods.b));
    	Arrays.fill(player2_pawn1_move_x,SpielefieldGods.a);
        Arrays.fill(player2_pawn1_move_y,SpielefieldGods.b);
        for (int i = 0; i < SpielefieldGods.Field.length; i++) {
            for (int j = 0; j < SpielefieldGods.Field[i].length; j++) {
                System.out.print(SpielefieldGods.Field[j][i]);
            }
            System.out.println();
        }
        System.out.println("Move Size: "+(player2_pawn1_List_move.size()+player2_pawn2_List_move.size()));
        System.out.println("move-------Player2----------");
    }

    public static void moveD(){
    	if(AddGods.player2.getGodCard().getGodNumber() == 1) {
    		if(pl1_p1.getPosition().getX() == SpielefieldGods.a && pl1_p1.getPosition().getY() == SpielefieldGods.b) {
    			pl1_p1.setPawnPosition(pl2_p2.getPosition());
    	        pl2_p2.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    		}else if(pl1_p2.getPosition().getX() == SpielefieldGods.a && pl1_p2.getPosition().getY() == SpielefieldGods.b) {
    			pl1_p2.setPawnPosition(pl2_p2.getPosition());
    	        pl2_p2.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    	        
    		}else {
    			pl2_p2.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    		}
    	}if(AddGods.player2.getGodCard().getGodNumber() == 8) {//Minotaur, see if enemy pawn gets moved and where
    		if(pl1_p1.getPosition().getX() == SpielefieldGods.a && pl1_p1.getPosition().getY() == SpielefieldGods.b) {
    			if(pl2_p2.getPosition().getX() < pl1_p1.getPosition().getX()) {
    				if(pl2_p2.getPosition().getY() < pl1_p1.getPosition().getY()) {
    					pl2_p2.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    					pl1_p1.setPawnPosition(new Position(SpielefieldGods.a+1,SpielefieldGods.b+1));
    				}else if(pl2_p2.getPosition().getY() > pl1_p1.getPosition().getY()) {
    					pl2_p2.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    					pl1_p1.setPawnPosition(new Position(SpielefieldGods.a+1,SpielefieldGods.b-1));
    				}else {
    					pl2_p2.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    					pl1_p1.setPawnPosition(new Position(SpielefieldGods.a+1,SpielefieldGods.b));
    				}
    			}else if(pl2_p2.getPosition().getX() > pl1_p1.getPosition().getX()) {
    				if(pl2_p2.getPosition().getY() < pl1_p1.getPosition().getY()) {
    					pl2_p2.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    					pl1_p1.setPawnPosition(new Position(SpielefieldGods.a-1,SpielefieldGods.b+1));
    				}else if(pl2_p2.getPosition().getY() > pl1_p1.getPosition().getY()) {
    					pl2_p2.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    					pl1_p1.setPawnPosition(new Position(SpielefieldGods.a-1,SpielefieldGods.b-1));
    				}else {
    					pl2_p2.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    					pl1_p1.setPawnPosition(new Position(SpielefieldGods.a-1,SpielefieldGods.b));
    				}
    			}else {
    				if(pl2_p2.getPosition().getY() < pl1_p1.getPosition().getY()) {
    					pl2_p2.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    					pl1_p1.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b-1));
    				}else {
    					pl2_p2.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    					pl1_p1.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b+1));
    				}
    			}
    		}else if(pl1_p2.getPosition().getX() == SpielefieldGods.a && pl1_p2.getPosition().getY() == SpielefieldGods.b) {
    			
    		}else {
    			pl2_p2.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    		}
    	}else {
    		pl2_p2.setPawnPosition(new Position(SpielefieldGods.a,SpielefieldGods.b));
    	}
    	player2_pawn2_List_move.add(new Position(SpielefieldGods.a,SpielefieldGods.b));
    	Arrays.fill(player2_pawn2_move_x,SpielefieldGods.a);
        Arrays.fill(player2_pawn2_move_y,SpielefieldGods.b);
        for (int i = 0; i < SpielefieldGods.Field.length; i++) {
            for (int j = 0; j < SpielefieldGods.Field[i].length; j++) {
                System.out.print(SpielefieldGods.Field[j][i]);
            }
            System.out.println();
        }
        System.out.println("Move Size: "+(player2_pawn1_List_move.size()+player2_pawn2_List_move.size()));
        System.out.println("move-------Player2----------");
    }
}

