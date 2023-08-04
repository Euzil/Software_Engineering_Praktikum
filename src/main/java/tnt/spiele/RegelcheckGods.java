/* modified by Youran Wang (719511)
* and by Finn Hinrchs (712699)
*/

package tnt.spiele;

import java.awt.*;
import java.lang.reflect.Field;

public class RegelcheckGods {
	
	//variable to see if godcard conditions is met
	public static boolean ifAthenaConditionMetA = false;
	public static boolean ifAthenaConditionMetB = false;
	public static boolean ifPrometheusConditionMetA = false; 
	public static boolean ifPrometheusConditionMetB = false;
	public static boolean ifMinotaurConditionMetA = false; 
	public static boolean ifMinotaurConditionMetB = false;

    public static boolean ifAwin() {
        if (Spielefield.Field[Spielefield.a][Spielefield.b] >= 4) {
            System.out.println("A win");
            return true;
        }else if(AddGods.player1.getGodCard().getGodNumber() == 9) {//See if the player has the Pan card
        	if(moveINGods.selectPl1_p1) {//see which pawn was selected
        		if(SpielefieldGods.Field[moveINGods.pl1_p1.getPosition().getX()][moveINGods.pl1_p1.getPosition().getY()]-SpielefieldGods.Field[Spielefield.a][Spielefield.b] >=2 ) {
        			System.out.println("A win");
                    return true;
        		}
        	}else if(moveINGods.selectPl1_p2){
        		if (SpielefieldGods.Field[moveINGods.pl1_p2.getPosition().getX()][moveINGods.pl1_p2.getPosition().getY()]-SpielefieldGods.Field[Spielefield.a][Spielefield.b] >=2 ) {
        			System.out.println("A win");
                    return true;
        		}
        	}	
        }else {
            return false;
        }
        return false;
    }

    public static boolean ifBwin() {
        if (Spielefield.Field[Spielefield.a][Spielefield.b] >= 4) {
            System.out.println("B win");
            return true;
        }else if(AddGods.player2.getGodCard().getGodNumber() == 9) {//See if the player has the Pan card
        	if(moveINGods.selectPl2_p1) {//see which pawn was selected
        		if(SpielefieldGods.Field[moveINGods.pl2_p1.getPosition().getX()][moveINGods.pl2_p1.getPosition().getY()]-SpielefieldGods.Field[Spielefield.a][Spielefield.b] >=2 ) {
        			System.out.println("A win");
                    return true;
        		}
        	}else if(moveINGods.selectPl2_p2){
        		if (SpielefieldGods.Field[moveINGods.pl2_p2.getPosition().getX()][moveINGods.pl2_p2.getPosition().getY()]-SpielefieldGods.Field[Spielefield.a][Spielefield.b] >=2 ) {
        			System.out.println("A win");
                    return true;
        		}
        	}	
        } else {
            return false;
        }
		return false;
    }
    
    public static boolean ifAMoveRight() {
    	boolean ifamoveright = false; 
    	if (ifAthenaConditionMetB = true) {
    		if(AddGods.player1.getGodCard().getGodNumber() == 1) {// have to see how exactly the point square is calculated(edit: a and b should calculate the array number already)
        		if(		//check the possible move squares
        				SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX() &&
        				SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY() &&
        	    		//exclude its own current position
        				(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY())&&
        				//only excludes own other Pawn because of Card effect
        				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY())&&
        				//checks if the chosen Field has at most one higher than the current one
        				(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl1_p1.getPosition().getX()][moveINGods.pl1_p1.getPosition().getY()])){
        			ifamoveright = true;
        		}else {
        			System.out.println("Can't move here");
        		}
        	}else if(AddGods.player1.getGodCard().getGodNumber() == 2){
        		if(		SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX() ||
        				SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX()+2 || SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX()-2 &&
        				SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()||
        				SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()+2 || SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()-2 &&
        				(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()) &&
        				//exclude other pawn positions
        				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY()) && 
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p1.getPosition().getY()) &&
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p2.getPosition().getY()) &&
        				(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl1_p1.getPosition().getX()][moveINGods.pl1_p1.getPosition().getY()])) {
        			ifamoveright = true;
        		}else {
        			System.out.println("Can't move here");
        		}
        	}else if(AddGods.player1.getGodCard().getGodNumber() == 3) {
        		if (	SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX() &&
        				SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY() &&
        				//exclude own Position
        				(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()) &&
        				//exclude other pawn positions
        				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY()) && 
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p1.getPosition().getY()) &&
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p2.getPosition().getY()) &&
        				//checks if new Position is at most one higher than the current one
        				(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl1_p1.getPosition().getX()][moveINGods.pl1_p1.getPosition().getY()])) {
        			ifamoveright = true;
        		}else {
        			System.out.println("Can't move here");
        		}
        		
        		
        	}else if(AddGods.player1.getGodCard().getGodNumber() == 7){//can move freely if not up or down, else just normally
        		if(		(SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX() &&
        				SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY() &&
        	    		(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()) &&
        	    		(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY()) && 
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p1.getPosition().getY()) &&
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p2.getPosition().getY()) &&
        	    		(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl1_p1.getPosition().getX()][moveINGods.pl1_p1.getPosition().getY()])) || 
        				//checks if the height of the chosen field is the same as the one the pawn is on
        				(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] == SpielefieldGods.Field[moveINGods.pl1_p1.getPosition().getX()][moveINGods.pl1_p1.getPosition().getY()] &&
        				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY()) && 
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p1.getPosition().getY()) &&
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p2.getPosition().getY()) )) {
        			ifamoveright = true;
        		}else {
        			System.out.println("Can't move here");
        		}
        		
        	}else if(AddGods.player1.getGodCard().getGodNumber() == 8){//need to be readjusted(edit: still need the pawn check
        		if(		SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX() &&
        				SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY() &&
        				//exclude its own current position
                		(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY())&&
                		//only excludes own other Pawn because of Card effect
                		(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY())&&
                		//checks if the chosen Field has at most the same height as the current one
                		(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl1_p1.getPosition().getX()][moveINGods.pl1_p1.getPosition().getY()])) {
        			ifamoveright = true;
        			//check to see if field is occupied by enemy
        			if(	((SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()) ||
            			(SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()))) {
        				//check to see if field behind enemy is free
        				if(SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX()-1) {
        					for (int i = (-1); i <= +1; i++) {
        						if(SpielefieldGods.a-1 == moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl2_p1.getPosition().getY() ||
        							SpielefieldGods.a-1 == moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl2_p2.getPosition().getY()	||
        							SpielefieldGods.a-1 == moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl1_p2.getPosition().getY()	||
        							SpielefieldGods.Field[(SpielefieldGods.a-1)][SpielefieldGods.b+(i*2)] == 4	) {
        							ifMinotaurConditionMetA = false;
        						}
        					}
        				}else if(SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX()) {
        					for (int i = (-1); i <= +1; i++) {
        						if(SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl2_p1.getPosition().getY() ||
        							SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl2_p2.getPosition().getY()	||
        							SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl1_p2.getPosition().getY()	||
        							SpielefieldGods.Field[(SpielefieldGods.a)][SpielefieldGods.b+(i*2)] == 4	) {
        							ifMinotaurConditionMetA = false;
        						}
        					}
        				}else if(SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX()+1) {
        					for (int i = (-1); i <= +1; i++) {
        						if(SpielefieldGods.a+1 == moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl2_p1.getPosition().getY() ||
        							SpielefieldGods.a+1 == moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl2_p2.getPosition().getY()	||
        							SpielefieldGods.a+1 == moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl1_p2.getPosition().getY()	||
        							SpielefieldGods.Field[(SpielefieldGods.a+1)][SpielefieldGods.b+(i*2)] == 4	) {
        							ifMinotaurConditionMetA = false;
        						}
        					}
        				}else {
        					ifMinotaurConditionMetA = true;
        				}
        				
        			}
        		}else {
        			System.out.println("Can't move here");
        		}
        		
        	}else if(AddGods.player1.getGodCard().getGodNumber() == 10) {
        		if(		//check the possible move squares
        				SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX() &&
        				SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY() &&
        	    		//exclude its own current position
        				(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY()) &&
        				//exclude other pawn positions
        				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY()) && 
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p1.getPosition().getY()) &&
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p2.getPosition().getY()) &&
        				//checks if the chosen Field has at most one higher than the current one
        				(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl1_p1.getPosition().getX()][moveINGods.pl1_p1.getPosition().getY()])){
        			ifamoveright = true;
        			//condition is automatically met
        			ifPrometheusConditionMetA = true;
        			
        		}else {
        			System.out.println("Can't move here");
        		}
        	}else if (	SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX() &&
        				SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY() &&
        				//exclude own Position
        				(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()) &&
        				//exclude other pawn positions
        				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY()) && 
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p1.getPosition().getY()) &&
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p2.getPosition().getY()) &&
        				//checks if new Position is at most one higher than the current one
        				(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl1_p1.getPosition().getX()][moveINGods.pl1_p1.getPosition().getY()]+1)) {
        		ifamoveright = true;
        	}
        	else {
        		ifamoveright = false;
        	}
        	return ifamoveright;
    	}else {
    		if(AddGods.player1.getGodCard().getGodNumber() == 1) {// have to see how exactly the point square is calculated(edit: a and b should calculate the array number already)
        		if(		//check the possible move squares
        				SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX() &&
        				SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY() &&
        	    		//exclude its own current position
        				(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY())&&
        				//only excludes own other Pawn because of Card effect
        				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY())&&
        				//checks if the chosen Field has at most one higher than the current one
        				(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl1_p1.getPosition().getX()][moveINGods.pl1_p1.getPosition().getY()]+1)){
        			ifamoveright = true;
        		}else {
        			System.out.println("Can't move here");
        		}
        	}else if(AddGods.player1.getGodCard().getGodNumber() == 2){
        		if(		SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX() ||
        				SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX()+2 || SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX()-2 &&
        				SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()||
        				SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()+2 || SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()-2 &&
        				(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()) &&
        				//exclude other pawn positions
        				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY()) && 
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p1.getPosition().getY()) &&
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p2.getPosition().getY())) {
        			ifamoveright = true;
        		}else {
        			System.out.println("Can't move here");
        		}
        		
        	}else if(AddGods.player1.getGodCard().getGodNumber() == 3) {
        		if (	SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX() &&
        				SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY() &&
        				//exclude own Position
        				(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()) &&
        				//exclude other pawn positions
        				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY()) && 
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p1.getPosition().getY()) &&
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p2.getPosition().getY()) &&
        				//checks if new Position is at most one higher than the current one
        				(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl1_p1.getPosition().getX()][moveINGods.pl1_p1.getPosition().getY()]+1)) {
        			ifamoveright = true;
        			if ((SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] == SpielefieldGods.Field[moveINGods.pl1_p1.getPosition().getX()][moveINGods.pl1_p1.getPosition().getY()]+1)) {
        				ifAthenaConditionMetA = true;
        			}
        		}
        		
        		
        	}else if(AddGods.player1.getGodCard().getGodNumber() == 7){//can move freely if not up or down, else just normally
        		if(		(SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX() &&
        				SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY() &&
        	    		(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()) &&
        	    		(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY()) && 
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p1.getPosition().getY()) &&
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p2.getPosition().getY()) &&
        	    		(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl1_p1.getPosition().getX()][moveINGods.pl1_p1.getPosition().getY()]+1)) || 
        				//checks if the height of the chosen field is the same as the one the pawn is on
        				(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] == SpielefieldGods.Field[moveINGods.pl1_p1.getPosition().getX()][moveINGods.pl1_p1.getPosition().getY()] &&
        				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY()) && 
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p1.getPosition().getY()) &&
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p2.getPosition().getY()) )) {
        			ifamoveright = true;
        		}else {
        			System.out.println("Can't move here");
        		}
        		
        	}else if(AddGods.player1.getGodCard().getGodNumber() == 8){
        		if(		SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX() &&
        				SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY() &&
        				//exclude its own current position
                		(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY())&&
                		//only excludes own other Pawn because of Card effect
                		(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY())&&
                		//checks if the chosen Field has at most one more height than the current one
                		(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl1_p1.getPosition().getX()][moveINGods.pl1_p1.getPosition().getY()]+1)) {
        			ifamoveright = true;
        			//check to see if field is occupied by enemy
        			if(	((SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()) ||
            			(SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()))) {
        				//check to see if field behind enemy is free
        				if(SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX()-1) {
        					for (int i = (-1); i <= +1; i++) {
        						if(SpielefieldGods.a-1 == moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl2_p1.getPosition().getY() ||
        							SpielefieldGods.a-1 == moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl2_p2.getPosition().getY()	||
        							SpielefieldGods.a-1 == moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl1_p2.getPosition().getY()	||
        							SpielefieldGods.Field[(SpielefieldGods.a-1)][SpielefieldGods.b+(i*2)] == 4	) {
        							ifMinotaurConditionMetA = false;
        						}
        					}
        				}else if(SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX()) {
        					for (int i = (-1); i <= +1; i++) {
        						if(SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl2_p1.getPosition().getY() ||
        							SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl2_p2.getPosition().getY()	||
        							SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl1_p2.getPosition().getY()	||
        							SpielefieldGods.Field[(SpielefieldGods.a)][SpielefieldGods.b+(i*2)] == 4	) {
        							ifMinotaurConditionMetA = false;
        						}
        					}
        				}else if(SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX()+1) {
        					for (int i = (-1); i <= +1; i++) {
        						if(SpielefieldGods.a+1 == moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl2_p1.getPosition().getY() ||
        							SpielefieldGods.a+1 == moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl2_p2.getPosition().getY()	||
        							SpielefieldGods.a+1 == moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl1_p2.getPosition().getY()	||
        							SpielefieldGods.Field[(SpielefieldGods.a+1)][SpielefieldGods.b+(i*2)] == 4	) {
        							ifMinotaurConditionMetA = false;
        						}
        					}
        				}else {
        					ifMinotaurConditionMetA = true;
        				}
        				
        			}
        		}else {
        			System.out.println("Can't move here");
        		}
        		
        	}else if(AddGods.player1.getGodCard().getGodNumber() == 10) {
        		if(		//check the possible move squares
        				SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX() &&
        				SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY() &&
        	    		//exclude its own current position
        				(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY()) &&
        				//exclude other pawn positions
        				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY()) && 
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p1.getPosition().getY()) &&
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p2.getPosition().getY()) &&
        				//checks if the chosen Field has at most one higher than the current one
        				(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl1_p1.getPosition().getX()][moveINGods.pl1_p1.getPosition().getY()]+1)){
        			ifamoveright = true;
        			//checks to see if the condition is met
        			if((SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl1_p1.getPosition().getX()][moveINGods.pl1_p1.getPosition().getY()])) {
        				ifPrometheusConditionMetA = true;
        			}
        		}else {
        			System.out.println("Can't move here");
        		}
        	}else if (	SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX() &&
        				SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY() &&
        				//exclude own Position
        				(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()) &&
        				//exclude other pawn positions
        				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY()) && 
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p1.getPosition().getY()) &&
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p2.getPosition().getY()) &&
        				//checks if new Position is at most one higher than the current one
        				(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl1_p1.getPosition().getX()][moveINGods.pl1_p1.getPosition().getY()]+1)) {
        		ifamoveright = true;
        	}
        	else {
        		System.out.println("Can't move here");
        		ifamoveright = false;
        	}
    	}
    	
    	return ifamoveright;
    }
    
    /*public static boolean ifAMoveRight() {
        boolean ifamoveright=true;
        if(     (Spielefield.a==(moveIN.player1_move_x[moveIN.player1_move_x.length-1]-1) && Spielefield.b==(moveIN.player1_move_y[moveIN.player1_move_y.length-1])) ||
                (Spielefield.a==(moveIN.player1_move_x[moveIN.player1_move_x.length-1]+1) && Spielefield.b==(moveIN.player1_move_y[moveIN.player1_move_y.length-1])) ||
                (Spielefield.a==(moveIN.player1_move_x[moveIN.player1_move_x.length-1]) && Spielefield.b==(moveIN.player1_move_y[moveIN.player1_move_y.length-1]-1)) ||
                (Spielefield.a==(moveIN.player1_move_x[moveIN.player1_move_x.length-1]) && Spielefield.b==(moveIN.player1_move_y[moveIN.player1_move_y.length-1]+1)) ||
                (Spielefield.a==(moveIN.player1_move_x[moveIN.player1_move_x.length-1]) && Spielefield.b==(moveIN.player1_move_y[moveIN.player1_move_y.length-1]))){
            ifamoveright=true;
        }else {
            System.out.println("Cant move there");
            ifamoveright=false;
        }
        return ifamoveright;
    }*/
    
    public static boolean ifBMoveRight() {
    	boolean ifbmoveright = false; 
    	if (ifAthenaConditionMetA = true) {
    		if(AddGods.player2.getGodCard().getGodNumber() == 1) {// have to see how exactly the point square is calculated(edit: a and b should calculate the array number already)
        		if(		//check the possible move squares
        				SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX() &&
        				SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY() &&
        	    		//exclude its own current position
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p1.getPosition().getY())&&
        				//only excludes own other Pawn because of Card effect
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p2.getPosition().getY())&&
        				//checks if the chosen Field has at most one higher than the current one
        				(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl2_p1.getPosition().getX()][moveINGods.pl2_p1.getPosition().getY()])){
        			ifbmoveright = true;
        		}else {
        			System.out.println("Can't move here");
        		}
        	}else if(AddGods.player2.getGodCard().getGodNumber() == 2){
        		if(		SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX() ||
        				SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX()+2 || SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX()-2 &&
        				SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()||
        				SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()+2 || SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()-2 &&
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()) &&
        				//exclude other pawn positions
        				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY()) && 
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p2.getPosition().getY()) &&
        				(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY()) &&
        				(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl2_p1.getPosition().getX()][moveINGods.pl2_p1.getPosition().getY()])) {
        			ifbmoveright = true;
        		}else {
        			System.out.println("Can't move here");
        		}
        	}else if(AddGods.player2.getGodCard().getGodNumber() == 3) {
        		if (	SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX() &&
        				SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY() &&
        				//exclude own Position
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()) &&
        				//exclude other pawn positions
        				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY()) && 
        				(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY()) &&
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p2.getPosition().getY()) &&
        				//checks if new Position is at most one higher than the current one
        				(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl2_p1.getPosition().getX()][moveINGods.pl2_p1.getPosition().getY()])) {
        			ifbmoveright = true;
        		}else {
        			System.out.println("Can't move here");
        		}
        		
        		
        	}else if(AddGods.player2.getGodCard().getGodNumber() == 7){//can move freely if not up or down, else just normally
        		if(		(SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX() &&
        				SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY() &&
        	    		(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()) &&
        	    		//exclude other pawn positions
        				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY()) && 
        				(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY()) &&
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p2.getPosition().getY()) &&
        	    		(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl2_p1.getPosition().getX()][moveINGods.pl2_p1.getPosition().getY()])) || 
        				//checks if the height of the chosen field is the same as the one the pawn is on
        				(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] == SpielefieldGods.Field[moveINGods.pl2_p1.getPosition().getX()][moveINGods.pl2_p1.getPosition().getY()] &&
        				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY()) && 
                		(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY()) &&
                		(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p2.getPosition().getY()))) {
        			ifbmoveright = true;
        		}else {
        			System.out.println("Can't move here");
        		}
        		
        	}else if(AddGods.player2.getGodCard().getGodNumber() == 8){//need to be readjusted(edit: still need the pawn check
        		if(		(SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX() &&
        				SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()) &&
        	    		//exclude its own current position
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()) &&
                		//only excludes own other Pawn because of Card effect
                		(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p2.getPosition().getY())&&
                		//checks if the chosen Field has at most the same height as the current one
                		(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl2_p1.getPosition().getX()][moveINGods.pl2_p1.getPosition().getY()])) {
        			ifbmoveright = true;
        			//check to see if field is occupied by enemy
        			if(	((SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()) ||
            			(SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()))) {
        				//check to see if field behind enemy is free
        				if(SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX()-1) {
        					for (int i = (-1); i <= +1; i++) {
        						if(SpielefieldGods.a-1 == moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl1_p1.getPosition().getY() ||
        							SpielefieldGods.a-1 == moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl2_p2.getPosition().getY()	||
        							SpielefieldGods.a-1 == moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl1_p2.getPosition().getY()	||
        							SpielefieldGods.Field[(SpielefieldGods.a-1)][SpielefieldGods.b+(i*2)] == 4	) {
        							ifMinotaurConditionMetB = false;
        						}
        					}
        				}else if(SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX()) {
        					for (int i = (-1); i <= +1; i++) {
        						if(SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl1_p1.getPosition().getY() ||
        							SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl2_p2.getPosition().getY()	||
        							SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl1_p2.getPosition().getY()	||
        							SpielefieldGods.Field[(SpielefieldGods.a)][SpielefieldGods.b+(i*2)] == 4	) {
        							ifMinotaurConditionMetB = false;
        						}
        					}
        				}else if(SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX()+1) {
        					for (int i = (-1); i <= +1; i++) {
        						if(SpielefieldGods.a+1 == moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl1_p1.getPosition().getY() ||
        							SpielefieldGods.a+1 == moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl2_p2.getPosition().getY()	||
        							SpielefieldGods.a+1 == moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl1_p2.getPosition().getY()	||
        							SpielefieldGods.Field[(SpielefieldGods.a+1)][SpielefieldGods.b+(i*2)] == 4	) {
        							ifMinotaurConditionMetB = false;
        						}
        					}
        				}else {
        					ifMinotaurConditionMetB = true;
        				}
        				
        			}
        		}else {
        			System.out.println("Can't move here");
        		}
        		
        	}else if(AddGods.player2.getGodCard().getGodNumber() == 10) {
        		if(		//check the possible move squares
        				SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX() &&
        				SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY() &&
        	    		//exclude its own current position
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p1.getPosition().getY()) &&
        				//exclude other pawn positions
        				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY()) && 
        				(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY()) &&
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p2.getPosition().getY()) &&
        				//checks if the chosen Field has at most same height as the current one
        				(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl2_p1.getPosition().getX()][moveINGods.pl2_p1.getPosition().getY()])){
        			ifbmoveright = true;
        			//condition is automatically met
        			ifPrometheusConditionMetB = true;
        			
        		}else {
        			System.out.println("Can't move here");
        		}
        	}else if (	SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX() &&
        				SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY() &&
        				//exclude own Position
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()) &&
        				//exclude other pawn positions
        				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY()) && 
        				(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY()) &&
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p2.getPosition().getY()) &&
        				//checks if new Position is at most one higher than the current one
        				(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl2_p1.getPosition().getX()][moveINGods.pl2_p1.getPosition().getY()])) {
        		ifbmoveright = true;
        	}
        	else {
        		ifbmoveright = false;
        	}
        	return ifbmoveright;
    	}else {
    		if(AddGods.player2.getGodCard().getGodNumber() == 1) {// have to see how exactly the point square is calculated(edit: a and b should calculate the array number already)
        		if(		//check the possible move squares
        				SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX() &&
        				SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY() &&
        				//exclude its own current position
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()) &&
                		//only excludes own other Pawn because of Card effect
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p2.getPosition().getY())&&
        				//checks if the chosen Field has at most one higher than the current one
        				(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl2_p1.getPosition().getX()][moveINGods.pl2_p1.getPosition().getY()]+1)){
        			ifbmoveright = true;
        		}else {
        			System.out.println("Can't move here");
        		}
        	}else if(AddGods.player2.getGodCard().getGodNumber() == 2){
        		if(		SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX() ||
        				SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX()+2 || SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX()-2 &&
        				SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()||
        				SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()+2 || SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()-2 &&
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()) &&
        				//exclude other pawn positions
        				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY()) && 
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p2.getPosition().getY()) &&
        				(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY()) &&
        				(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl2_p1.getPosition().getX()][moveINGods.pl2_p1.getPosition().getY()]+1)) {
        			ifbmoveright = true;
        		}else {
        			System.out.println("Can't move here");
        		}
        		
        	}else if(AddGods.player2.getGodCard().getGodNumber() == 3) {
        		if (	SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX() ||
        				SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX()+2 || SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX()-2 &&
        				SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()||
        				SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()+2 || SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()-2 &&
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()) &&
        				//exclude other pawn positions
        				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY()) && 
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p2.getPosition().getY()) &&
        				(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY()) &&
        				//checks if new Position is at most one higher than the current one
        				(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl2_p1.getPosition().getX()][moveINGods.pl2_p1.getPosition().getY()]+1)) {
        			ifbmoveright = true;
        			if ((SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] == SpielefieldGods.Field[moveINGods.pl2_p1.getPosition().getX()][moveINGods.pl2_p1.getPosition().getY()]+1)) {
        				ifAthenaConditionMetA = true;
        			}
        		}
        		
        		
        	}else if(AddGods.player2.getGodCard().getGodNumber() == 7){//can move freely if not up or down, else just normally
        		if(		(SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX() &&
        				SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY() &&
        	    		(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()) &&
        	    		//exclude other pawn positions
        				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY()) && 
        				(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY()) &&
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p2.getPosition().getY()) &&
        	    		(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl2_p1.getPosition().getX()][moveINGods.pl2_p1.getPosition().getY()])) || 
        				//checks if the height of the chosen field is the same as the one the pawn is on
        				(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] == SpielefieldGods.Field[moveINGods.pl2_p1.getPosition().getX()][moveINGods.pl2_p1.getPosition().getY()] &&
        				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY()) && 
                		(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY()) &&
                		(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p2.getPosition().getY()))) {
        			ifbmoveright = true;
        		}else {
        			System.out.println("Can't move here");
        		}
        		
        	}else if(AddGods.player2.getGodCard().getGodNumber() == 8){
        		if(		(SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX() &&
        				SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()) &&
        	    		//exclude its own current position
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()) &&
                		//only excludes own other Pawn because of Card effect
                		(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p2.getPosition().getY())&&
                		//checks if the chosen Field has at most the same height as the current one
                		(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl2_p1.getPosition().getX()][moveINGods.pl2_p1.getPosition().getY()+1])) {
        			ifbmoveright = true;
        			//check to see if field is occupied by enemy
        			if(	((SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()) ||
            			(SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()))) {
        				//check to see if field behind enemy is free
        				if(SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX()-1) {
        					for (int i = (-1); i <= +1; i++) {
        						if(SpielefieldGods.a-1 == moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl1_p1.getPosition().getY() ||
        							SpielefieldGods.a-1 == moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl2_p2.getPosition().getY()	||
        							SpielefieldGods.a-1 == moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl1_p2.getPosition().getY()	||
        							SpielefieldGods.Field[(SpielefieldGods.a-1)][SpielefieldGods.b+(i*2)] == 4	) {
        							ifMinotaurConditionMetB = false;
        						}
        					}
        				}else if(SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX()) {
        					for (int i = (-1); i <= +1; i++) {
        						if(SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl1_p1.getPosition().getY() ||
        							SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl2_p2.getPosition().getY()	||
        							SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl1_p2.getPosition().getY()	||
        							SpielefieldGods.Field[(SpielefieldGods.a)][SpielefieldGods.b+(i*2)] == 4	) {
        							ifMinotaurConditionMetB = false;
        						}
        					}
        				}else if(SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX()+1) {
        					for (int i = (-1); i <= +1; i++) {
        						if(SpielefieldGods.a+1 == moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl1_p1.getPosition().getY() ||
        							SpielefieldGods.a+1 == moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl2_p2.getPosition().getY()	||
        							SpielefieldGods.a+1 == moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl1_p2.getPosition().getY()	||
        							SpielefieldGods.Field[(SpielefieldGods.a+1)][SpielefieldGods.b+(i*2)] == 4	) {
        							ifMinotaurConditionMetB = false;
        						}
        					}
        				}else {
        					ifMinotaurConditionMetB = true;
        				}
        				
        			}
        		}else {
        			System.out.println("Can't move here");
        		}
        		
        	}else if(AddGods.player2.getGodCard().getGodNumber() == 10) {
        		if(		//check the possible move squares
        				SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX() &&
        				SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY() &&
        	    		//exclude its own current position
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p1.getPosition().getY()) &&
        				//exclude other pawn positions
        				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY()) && 
        				(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY()) &&
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p2.getPosition().getY()) &&
        				//checks if the chosen Field has at most same height as the current one
        				(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl2_p1.getPosition().getX()][moveINGods.pl2_p1.getPosition().getY()+1])){
        			ifbmoveright = true;
        			//condition is automatically met
        			ifPrometheusConditionMetB = true;
        			
        		}else {
        			System.out.println("Can't move here");
        		}
        	}else if (	SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX() &&
        				SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY() &&
        				//exclude own Position
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()) &&
        				//exclude other pawn positions
        				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY()) && 
        				(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY()) &&
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p2.getPosition().getY()) &&
        				//checks if new Position is at most one higher than the current one
        				(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl2_p1.getPosition().getX()][moveINGods.pl2_p1.getPosition().getY()]+1)) {
        		ifbmoveright = true;
        	}
        	else {
        		System.out.println("Can't move here");
        		ifbmoveright = false;
        	}
    	}
    	
    	return ifbmoveright;
    }
    
    /*public static boolean ifBMoveRight() {
        boolean ifbmoveright=true;
        if(     (Spielefield.a==(moveIN.player2_move_x[moveIN.player2_move_x.length-1]-1) && Spielefield.b==(moveIN.player2_move_y[moveIN.player2_move_y.length-1])) ||
                (Spielefield.a==(moveIN.player2_move_x[moveIN.player2_move_x.length-1]+1) && Spielefield.b==(moveIN.player2_move_y[moveIN.player2_move_y.length-1])) ||
                (Spielefield.a==(moveIN.player2_move_x[moveIN.player2_move_x.length-1]) && Spielefield.b==(moveIN.player2_move_y[moveIN.player2_move_y.length-1]-1)) ||
                (Spielefield.a==(moveIN.player2_move_x[moveIN.player2_move_x.length-1]) && Spielefield.b==(moveIN.player2_move_y[moveIN.player2_move_y.length-1]+1)) ||
                (Spielefield.a==(moveIN.player2_move_x[moveIN.player2_move_x.length-1]) && Spielefield.b==(moveIN.player2_move_y[moveIN.player2_move_y.length-1]))){
            ifbmoveright=true;
        }else {
            System.out.println("Cant move there");
            ifbmoveright=false;
        }
        return ifbmoveright;
    }*/
    
    public static boolean ifCMoveRight() {
    	boolean ifcmoveright = false; 
    	if (ifAthenaConditionMetB = true) {
    		if(AddGods.player1.getGodCard().getGodNumber() == 1) {// have to see how exactly the point square is calculated(edit: a and b should calculate the array number already)
        		if(		//check the possible move squares
        				SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX() &&
        				SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY() &&
        	    		//exclude its own current position
        				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY())&&
        				//only excludes own other Pawn because of Card effect
        				(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY())&&
        				//checks if the chosen Field has at most one higher than the current one
        				(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl1_p2.getPosition().getX()][moveINGods.pl1_p2.getPosition().getY()])){
        			ifcmoveright = true;
        		}else {
        			System.out.println("Can't move here");
        		}
        	}else if(AddGods.player1.getGodCard().getGodNumber() == 2){
        		if(		SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX() ||
        				SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX()+2 || SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX()-2 &&
        				SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()||
        				SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()+2 || SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()-2 &&
        				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()) &&
        				//exclude other pawn positions
        				(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY()) && 
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p1.getPosition().getY()) &&
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p2.getPosition().getY()) &&
        				(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl1_p2.getPosition().getX()][moveINGods.pl1_p2.getPosition().getY()])) {
        			ifcmoveright = true;
        		}else {
        			System.out.println("Can't move here");
        		}
        	}else if(AddGods.player1.getGodCard().getGodNumber() == 3) {
        		if (	SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX() &&
        				SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY() &&
        				//exclude own Position
        				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()) &&
        				//exclude other pawn positions
        				(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY()) && 
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p1.getPosition().getY()) &&
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p2.getPosition().getY()) &&
        				//checks if new Position is at most one higher than the current one
        				(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl1_p2.getPosition().getX()][moveINGods.pl1_p2.getPosition().getY()])) {
        			ifcmoveright = true;
        		}else {
        			System.out.println("Can't move here");
        		}
        		
        		
        	}else if(AddGods.player1.getGodCard().getGodNumber() == 7){//can move freely if not up or down, else just normally
        		if(		(SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX() &&
        				SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY() &&
        	    		(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()) &&
        	    		(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY()) && 
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p1.getPosition().getY()) &&
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p2.getPosition().getY()) &&
        	    		(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl1_p2.getPosition().getX()][moveINGods.pl1_p2.getPosition().getY()])) || 
        				//checks if the height of the chosen field is the same as the one the pawn is on
        				(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] == SpielefieldGods.Field[moveINGods.pl1_p2.getPosition().getX()][moveINGods.pl1_p2.getPosition().getY()] &&
        				(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY()) && 
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p1.getPosition().getY()) &&
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p2.getPosition().getY()) )) {
        			ifcmoveright = true;
        		}else {
        			System.out.println("Can't move here");
        		}
        		
        	}else if(AddGods.player1.getGodCard().getGodNumber() == 8){//need to be readjusted(edit: still need the pawn check
        		if(		SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX() &&
        				SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY() &&
        				//exclude its own current position
                		(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY())&&
                		//only excludes own other Pawn because of Card effect
                		(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY())&&
                		//checks if the chosen Field has at most the same height as the current one
                		(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl1_p2.getPosition().getX()][moveINGods.pl1_p2.getPosition().getY()])) {
        			ifcmoveright = true;
        			//check to see if field is occupied by enemy
        			if(	((SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()) ||
            			(SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()))) {
        				//check to see if field behind enemy is free
        				if(SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX()-1) {
        					for (int i = (-1); i <= +1; i++) {
        						if(SpielefieldGods.a-1 == moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl2_p1.getPosition().getY() ||
        							SpielefieldGods.a-1 == moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl2_p2.getPosition().getY()	||
        							SpielefieldGods.a-1 == moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl1_p1.getPosition().getY()	||
        							SpielefieldGods.Field[(SpielefieldGods.a-1)][SpielefieldGods.b+(i*2)] == 4	) {
        							ifMinotaurConditionMetA = false;
        						}
        					}
        				}else if(SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX()) {
        					for (int i = (-1); i <= +1; i++) {
        						if(SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl2_p1.getPosition().getY() ||
        							SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl2_p2.getPosition().getY()	||
        							SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl1_p1.getPosition().getY()	||
        							SpielefieldGods.Field[(SpielefieldGods.a)][SpielefieldGods.b+(i*2)] == 4	) {
        							ifMinotaurConditionMetA = false;
        						}
        					}
        				}else if(SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX()+1) {
        					for (int i = (-1); i <= +1; i++) {
        						if(SpielefieldGods.a+1 == moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl2_p1.getPosition().getY() ||
        							SpielefieldGods.a+1 == moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl2_p2.getPosition().getY()	||
        							SpielefieldGods.a+1 == moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl1_p1.getPosition().getY()	||
        							SpielefieldGods.Field[(SpielefieldGods.a+1)][SpielefieldGods.b+(i*2)] == 4	) {
        							ifMinotaurConditionMetA = false;
        						}
        					}
        				}else {
        					ifMinotaurConditionMetA = true;
        				}
        				
        			}
        		}else {
        			System.out.println("Can't move here");
        		}
        		
        	}else if(AddGods.player1.getGodCard().getGodNumber() == 10) {
        		if(		//check the possible move squares
        				SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX() &&
        				SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY() &&
        	    		//exclude its own current position
        				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY()) &&
        				//exclude other pawn positions
        				(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY()) && 
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p1.getPosition().getY()) &&
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p2.getPosition().getY()) &&
        				//checks if the chosen Field has at most one higher than the current one
        				(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl1_p2.getPosition().getX()][moveINGods.pl1_p2.getPosition().getY()])){
        			ifcmoveright = true;
        			//condition is automatically met
        			ifPrometheusConditionMetA = true;
        			
        		}else {
        			System.out.println("Can't move here");
        		}
        	}else if (	SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX() &&
        				SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY() &&
        				//exclude own Position
        				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()) &&
        				//exclude other pawn positions
        				(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY()) && 
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p1.getPosition().getY()) &&
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p2.getPosition().getY()) &&
        				//checks if new Position is at most one higher than the current one
        				(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl1_p2.getPosition().getX()][moveINGods.pl1_p2.getPosition().getY()]+1)) {
        		ifcmoveright = true;
        	}
        	else {
        		ifcmoveright = false;
        	}
        	return ifcmoveright;
    	}else {
    		if(AddGods.player1.getGodCard().getGodNumber() == 1) {// have to see how exactly the point square is calculated(edit: a and b should calculate the array number already)
        		if(		//check the possible move squares
        				SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX() &&
        				SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY() &&
        	    		//exclude its own current position
        				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY())&&
        				//only excludes own other Pawn because of Card effect
        				(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY())&&
        				//checks if the chosen Field has at most one higher than the current one
        				(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl1_p2.getPosition().getX()][moveINGods.pl1_p2.getPosition().getY()]+1)){
        			ifcmoveright = true;
        		}else {
        			System.out.println("Can't move here");
        		}
        	}else if(AddGods.player1.getGodCard().getGodNumber() == 2){
        		if(		SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX() ||
        				SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX()+2 || SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX()-2 &&
        				SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()||
        				SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()+2 || SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()-2 &&
        				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()) &&
        				//exclude other pawn positions
        				(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY()) && 
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p1.getPosition().getY()) &&
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p2.getPosition().getY())) {
        			ifcmoveright = true;
        		}else {
        			System.out.println("Can't move here");
        		}
        		
        	}else if(AddGods.player1.getGodCard().getGodNumber() == 3) {
        		if (	SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX() &&
        				SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY() &&
        				//exclude own Position
        				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()) &&
        				//exclude other pawn positions
        				(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY()) && 
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p1.getPosition().getY()) &&
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p2.getPosition().getY()) &&
        				//checks if new Position is at most one higher than the current one
        				(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl1_p2.getPosition().getX()][moveINGods.pl1_p2.getPosition().getY()]+1)) {
        			ifcmoveright = true;
        			if ((SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] == SpielefieldGods.Field[moveINGods.pl1_p2.getPosition().getX()][moveINGods.pl1_p2.getPosition().getY()]+1)) {
        				ifAthenaConditionMetA = true;
        			}
        		}
        		
        		
        	}else if(AddGods.player1.getGodCard().getGodNumber() == 7){//can move freely if not up or down, else just normally
        		if(		(SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX() &&
        				SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY() &&
        	    		(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()) &&
        	    		(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY()) && 
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p1.getPosition().getY()) &&
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p2.getPosition().getY()) &&
        	    		(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl1_p2.getPosition().getX()][moveINGods.pl1_p2.getPosition().getY()]+1)) || 
        				//checks if the height of the chosen field is the same as the one the pawn is on
        				(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] == SpielefieldGods.Field[moveINGods.pl1_p2.getPosition().getX()][moveINGods.pl1_p2.getPosition().getY()] &&
        				(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY()) && 
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p1.getPosition().getY()) &&
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p2.getPosition().getY()) )) {
        			ifcmoveright = true;
        		}else {
        			System.out.println("Can't move here");
        		}
        		
        	}else if(AddGods.player1.getGodCard().getGodNumber() == 8){
        		if(		SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX() &&
        				SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY() &&
        				//exclude its own current position
                		(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY())&&
                		//only excludes own other Pawn because of Card effect
                		(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY())&&
                		//checks if the chosen Field has at most one more height than the current one
                		(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl1_p2.getPosition().getX()][moveINGods.pl1_p2.getPosition().getY()]+1)) {
        			ifcmoveright = true;
        			//check to see if field is occupied by enemy
        			if(	((SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()) ||
            			(SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()))) {
        				//check to see if field behind enemy is free
        				if(SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX()-1) {
        					for (int i = (-1); i <= +1; i++) {
        						if(SpielefieldGods.a-1 == moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl2_p1.getPosition().getY() ||
        							SpielefieldGods.a-1 == moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl2_p2.getPosition().getY()	||
        							SpielefieldGods.a-1 == moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl1_p1.getPosition().getY()	||
        							SpielefieldGods.Field[(SpielefieldGods.a-1)][SpielefieldGods.b+(i*2)] == 4	) {
        							ifMinotaurConditionMetA = false;
        						}
        					}
        				}else if(SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX()) {
        					for (int i = (-1); i <= +1; i++) {
        						if(SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl2_p1.getPosition().getY() ||
        							SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl2_p2.getPosition().getY()	||
        							SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl1_p1.getPosition().getY()	||
        							SpielefieldGods.Field[(SpielefieldGods.a)][SpielefieldGods.b+(i*2)] == 4	) {
        							ifMinotaurConditionMetA = false;
        						}
        					}
        				}else if(SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX()+1) {
        					for (int i = (-1); i <= +1; i++) {
        						if(SpielefieldGods.a+1 == moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl2_p1.getPosition().getY() ||
        							SpielefieldGods.a+1 == moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl2_p2.getPosition().getY()	||
        							SpielefieldGods.a+1 == moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl1_p1.getPosition().getY()	||
        							SpielefieldGods.Field[(SpielefieldGods.a+1)][SpielefieldGods.b+(i*2)] == 4	) {
        							ifMinotaurConditionMetA = false;
        						}
        					}
        				}else {
        					ifMinotaurConditionMetA = true;
        				}
        				
        			}
        		}else {
        			System.out.println("Can't move here");
        		}
        		
        	}else if(AddGods.player1.getGodCard().getGodNumber() == 10) {
        		if(		//check the possible move squares
        				SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX() &&
        				SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY() &&
        	    		//exclude its own current position
        				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY()) &&
        				//exclude other pawn positions
        				(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY()) && 
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p1.getPosition().getY()) &&
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p2.getPosition().getY()) &&
        				//checks if the chosen Field has at most one higher than the current one
        				(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl1_p2.getPosition().getX()][moveINGods.pl1_p2.getPosition().getY()]+1)){
        			ifcmoveright = true;
        			//checks to see if the condition is met
        			if((SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl1_p2.getPosition().getX()][moveINGods.pl1_p2.getPosition().getY()])) {
        				ifPrometheusConditionMetA = true;
        			}
        		}else {
        			System.out.println("Can't move here");
        		}
        	}else if (	SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX() &&
        				SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY() &&
        				//exclude own Position
        				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()) &&
        				//exclude other pawn positions
        				(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY()) && 
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p1.getPosition().getY()) &&
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p2.getPosition().getY()) &&
        				//checks if new Position is at most one higher than the current one
        				(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl1_p2.getPosition().getX()][moveINGods.pl1_p2.getPosition().getY()]+1)) {
        		ifcmoveright = true;
        	}
        	else {
        		System.out.println("Can't move here");
        		ifcmoveright = false;
        	}
    	}
    	
    	return ifcmoveright;
    }
    
    public static boolean ifDMoveRight() {
    	boolean ifdmoveright = false; 
    	if (ifAthenaConditionMetA = true) {
    		if(AddGods.player1.getGodCard().getGodNumber() == 1) {// have to see how exactly the point square is calculated(edit: a and b should calculate the array number already)
        		if(		//check the possible move squares
        				SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX() &&
        				SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY() &&
        	    		//exclude its own current position
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p2.getPosition().getY())&&
        				//only excludes own other Pawn because of Card effect
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p1.getPosition().getY())&&
        				//checks if the chosen Field has at most one higher than the current one
        				(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl2_p2.getPosition().getX()][moveINGods.pl2_p2.getPosition().getY()])){
        			ifdmoveright = true;
        		}else {
        			System.out.println("Can't move here");
        		}
        	}else if(AddGods.player1.getGodCard().getGodNumber() == 2){
        		if(		SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX() ||
        				SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX()+2 || SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX()-2 &&
        				SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()||
        				SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()+2 || SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()-2 &&
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()) &&
        				//exclude other pawn positions
        				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY()) && 
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p1.getPosition().getY()) &&
        				(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY()) &&
        				(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl2_p2.getPosition().getX()][moveINGods.pl2_p2.getPosition().getY()])) {
        			ifdmoveright = true;
        		}else {
        			System.out.println("Can't move here");
        		}
        	}else if(AddGods.player1.getGodCard().getGodNumber() == 3) {
        		if (	SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX() &&
        				SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY() &&
        				//exclude own Position
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()) &&
        				//exclude other pawn positions
        				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY()) && 
        				(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY()) &&
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p1.getPosition().getY()) &&
        				//checks if new Position is at most one higher than the current one
        				(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl2_p2.getPosition().getX()][moveINGods.pl2_p2.getPosition().getY()])) {
        			ifdmoveright = true;
        		}else {
        			System.out.println("Can't move here");
        		}
        		
        		
        	}else if(AddGods.player1.getGodCard().getGodNumber() == 7){//can move freely if not up or down, else just normally
        		if(		(SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX() &&
        				SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY() &&
        	    		(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()) &&
        	    		//exclude other pawn positions
        				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY()) && 
        				(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY()) &&
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p1.getPosition().getY()) &&
        	    		(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl2_p2.getPosition().getX()][moveINGods.pl2_p2.getPosition().getY()])) || 
        				//checks if the height of the chosen field is the same as the one the pawn is on
        				(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] == SpielefieldGods.Field[moveINGods.pl2_p2.getPosition().getX()][moveINGods.pl2_p2.getPosition().getY()] &&
        				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY()) && 
                		(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY()) &&
                		(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p1.getPosition().getY()))) {
        			ifdmoveright = true;
        		}else {
        			System.out.println("Can't move here");
        		}
        		
        	}else if(AddGods.player1.getGodCard().getGodNumber() == 8){//need to be readjusted(edit: still need the pawn check
        		if(		(SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX() &&
        				SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()) &&
        	    		//exclude its own current position
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()) &&
                		//only excludes own other Pawn because of Card effect
                		(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p1.getPosition().getY())&&
                		//checks if the chosen Field has at most the same height as the current one
                		(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl2_p2.getPosition().getX()][moveINGods.pl2_p2.getPosition().getY()])) {
        			ifdmoveright = true;
        			//check to see if field is occupied by enemy
        			if(	((SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()) ||
            			(SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()))) {
        				//check to see if field behind enemy is free
        				if(SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX()-1) {
        					for (int i = (-1); i <= +1; i++) {
        						if(SpielefieldGods.a-1 == moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl1_p1.getPosition().getY() ||
        							SpielefieldGods.a-1 == moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl2_p1.getPosition().getY()	||
        							SpielefieldGods.a-1 == moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl1_p2.getPosition().getY()	||
        							SpielefieldGods.Field[(SpielefieldGods.a-1)][SpielefieldGods.b+(i*2)] == 4	) {
        							ifMinotaurConditionMetB = false;
        						}
        					}
        				}else if(SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX()) {
        					for (int i = (-1); i <= +1; i++) {
        						if(SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl1_p1.getPosition().getY() ||
        							SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl2_p1.getPosition().getY()	||
        							SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl1_p2.getPosition().getY()	||
        							SpielefieldGods.Field[(SpielefieldGods.a)][SpielefieldGods.b+(i*2)] == 4	) {
        							ifMinotaurConditionMetB = false;
        						}
        					}
        				}else if(SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX()+1) {
        					for (int i = (-1); i <= +1; i++) {
        						if(SpielefieldGods.a+1 == moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl1_p1.getPosition().getY() ||
        							SpielefieldGods.a+1 == moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl2_p1.getPosition().getY()	||
        							SpielefieldGods.a+1 == moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl1_p2.getPosition().getY()	||
        							SpielefieldGods.Field[(SpielefieldGods.a+1)][SpielefieldGods.b+(i*2)] == 4	) {
        							ifMinotaurConditionMetB = false;
        						}
        					}
        				}else {
        					ifMinotaurConditionMetB = true;
        				}
        				
        			}
        		}else {
        			System.out.println("Can't move here");
        		}
        		
        	}else if(AddGods.player1.getGodCard().getGodNumber() == 10) {
        		if(		//check the possible move squares
        				SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX() &&
        				SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY() &&
        	    		//exclude its own current position
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p2.getPosition().getY()) &&
        				//exclude other pawn positions
        				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY()) && 
        				(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY()) &&
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p1.getPosition().getY()) &&
        				//checks if the chosen Field has at most same height as the current one
        				(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl2_p2.getPosition().getX()][moveINGods.pl2_p2.getPosition().getY()])){
        			ifdmoveright = true;
        			//condition is automatically met
        			ifPrometheusConditionMetB = true;
        			
        		}else {
        			System.out.println("Can't move here");
        		}
        	}else if (	SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX() &&
        				SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY() &&
        				//exclude own Position
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()) &&
        				//exclude other pawn positions
        				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY()) && 
        				(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY()) &&
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p1.getPosition().getY()) &&
        				//checks if new Position is at most one higher than the current one
        				(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl2_p2.getPosition().getX()][moveINGods.pl2_p2.getPosition().getY()])) {
        		ifdmoveright = true;
        	}
        	else {
        		ifdmoveright = false;
        	}
        	return ifdmoveright;
    	}else {
    		if(AddGods.player1.getGodCard().getGodNumber() == 1) {// have to see how exactly the point square is calculated(edit: a and b should calculate the array number already)
        		if(		//check the possible move squares
        				SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX() &&
        				SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY() &&
        				//exclude its own current position
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()) &&
                		//only excludes own other Pawn because of Card effect
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p1.getPosition().getY())&&
        				//checks if the chosen Field has at most one higher than the current one
        				(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl2_p2.getPosition().getX()][moveINGods.pl2_p2.getPosition().getY()]+1)){
        			ifdmoveright = true;
        		}else {
        			System.out.println("Can't move here");
        		}
        	}else if(AddGods.player1.getGodCard().getGodNumber() == 2){
        		if(		SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX() ||
        				SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX()+2 || SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX()-2 &&
        				SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()||
        				SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()+2 || SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()-2 &&
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()) &&
        				//exclude other pawn positions
        				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY()) && 
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p1.getPosition().getY()) &&
        				(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY()) &&
        				(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl2_p2.getPosition().getX()][moveINGods.pl2_p2.getPosition().getY()]+1)) {
        			ifdmoveright = true;
        		}else {
        			System.out.println("Can't move here");
        		}
        		
        	}else if(AddGods.player1.getGodCard().getGodNumber() == 3) {
        		if (	SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX() ||
        				SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX()+2 || SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX()-2 &&
        				SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()||
        				SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()+2 || SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()-2 &&
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()) &&
        				//exclude other pawn positions
        				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY()) && 
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p1.getPosition().getY()) &&
        				(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY()) &&
        				//checks if new Position is at most one higher than the current one
        				(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl2_p2.getPosition().getX()][moveINGods.pl2_p2.getPosition().getY()]+1)) {
        			ifdmoveright = true;
        			if ((SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] == SpielefieldGods.Field[moveINGods.pl2_p2.getPosition().getX()][moveINGods.pl2_p2.getPosition().getY()]+1)) {
        				ifAthenaConditionMetB = true;
        			}
        		}
        		
        		
        	}else if(AddGods.player1.getGodCard().getGodNumber() == 7){//can move freely if not up or down, else just normally
        		if(		(SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX() &&
        				SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY() &&
        	    		(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()) &&
        	    		//exclude other pawn positions
        				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY()) && 
        				(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY()) &&
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p1.getPosition().getY()) &&
        	    		(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl2_p2.getPosition().getX()][moveINGods.pl2_p2.getPosition().getY()])) || 
        				//checks if the height of the chosen field is the same as the one the pawn is on
        				(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] == SpielefieldGods.Field[moveINGods.pl2_p2.getPosition().getX()][moveINGods.pl2_p2.getPosition().getY()] &&
        				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY()) && 
                		(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY()) &&
                		(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p1.getPosition().getY()))) {
        			ifdmoveright = true;
        		}else {
        			System.out.println("Can't move here");
        		}
        		
        	}else if(AddGods.player1.getGodCard().getGodNumber() == 8){
        		if(		(SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX() &&
        				SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()) &&
        	    		//exclude its own current position
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()) &&
                		//only excludes own other Pawn because of Card effect
                		(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p1.getPosition().getY())&&
                		//checks if the chosen Field has at most the same height as the current one
                		(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl2_p2.getPosition().getX()][moveINGods.pl2_p2.getPosition().getY()+1])) {
        			ifdmoveright = true;
        			//check to see if field is occupied by enemy
        			if(	((SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()) ||
            			(SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()))) {
        				//check to see if field behind enemy is free
        				if(SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX()-1) {
        					for (int i = (-1); i <= +1; i++) {
        						if(SpielefieldGods.a-1 == moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl1_p1.getPosition().getY() ||
        							SpielefieldGods.a-1 == moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl2_p1.getPosition().getY()	||
        							SpielefieldGods.a-1 == moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl1_p2.getPosition().getY()	||
        							SpielefieldGods.Field[(SpielefieldGods.a-1)][SpielefieldGods.b+(i*2)] == 4	) {
        							ifMinotaurConditionMetB = false;
        						}
        					}
        				}else if(SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX()) {
        					for (int i = (-1); i <= +1; i++) {
        						if(SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl1_p1.getPosition().getY() ||
        							SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl2_p1.getPosition().getY()	||
        							SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl1_p2.getPosition().getY()	||
        							SpielefieldGods.Field[(SpielefieldGods.a)][SpielefieldGods.b+(i*2)] == 4	) {
        							ifMinotaurConditionMetB = false;
        						}
        					}
        				}else if(SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX()+1) {
        					for (int i = (-1); i <= +1; i++) {
        						if(SpielefieldGods.a+1 == moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl1_p1.getPosition().getY() ||
        							SpielefieldGods.a+1 == moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl2_p1.getPosition().getY()	||
        							SpielefieldGods.a+1 == moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b+(i*2) == moveINGods.pl1_p2.getPosition().getY()	||
        							SpielefieldGods.Field[(SpielefieldGods.a+1)][SpielefieldGods.b+(i*2)] == 4	) {
        							ifMinotaurConditionMetB = false;
        						}
        					}
        				}else {
        					ifMinotaurConditionMetB = true;
        				}
        				
        			}
        		}else {
        			System.out.println("Can't move here");
        		}
        		
        	}else if(AddGods.player1.getGodCard().getGodNumber() == 10) {
        		if(		//check the possible move squares
        				SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX() &&
        				SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY() &&
        	    		//exclude its own current position
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p2.getPosition().getY()) &&
        				//exclude other pawn positions
        				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY()) && 
        				(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY()) &&
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p1.getPosition().getY()) &&
        				//checks if the chosen Field has at most same height as the current one
        				(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl2_p2.getPosition().getX()][moveINGods.pl2_p2.getPosition().getY()+1])){
        			ifdmoveright = true;
        			//condition is automatically met
        			ifPrometheusConditionMetB = true;
        			
        		}else {
        			System.out.println("Can't move here");
        		}
        	}else if (	SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX() &&
        				SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY() &&
        				//exclude own Position
        				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()) &&
        				//exclude other pawn positions
        				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY()) && 
        				(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY()) &&
        				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p1.getPosition().getY()) &&
        				//checks if new Position is at most one higher than the current one
        				(SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] >= SpielefieldGods.Field[moveINGods.pl2_p2.getPosition().getX()][moveINGods.pl2_p2.getPosition().getY()]+1)) {
        		ifdmoveright = true;
        	}
        	else {
        		System.out.println("Can't move here");
        		ifdmoveright = false;
        	}
    	}
    	
    	return ifdmoveright;
    }

    public static boolean ifAPutRight(){
    	boolean ifaputright = false;
    	if(		SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl1_p1.getPosition().getX() &&
				SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY() &&
				//exclude own Position
				(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b == moveINGods.pl1_p1.getPosition().getY()) &&
				//exclude other pawn positions
				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY()) && 
				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p1.getPosition().getY()) &&
				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p2.getPosition().getY()) &&
				SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] < 3){
    		ifaputright = true;
    	}else {
    		System.out.println("Can't build here");
    		ifaputright = false;
    	}
    	return ifaputright;
    }
    
    public static boolean ifBPutRight(){
    	boolean ifbputright = false;
    	if(		SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl2_p1.getPosition().getX() &&
				SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY() &&
				//exclude own Position
				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b == moveINGods.pl2_p1.getPosition().getY()) &&
				//exclude other pawn positions
				(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY()) && 
				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p2.getPosition().getY()) &&
				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY()) &&
				SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] < 3){
    		ifbputright = true;
    	}else {
    		System.out.println("Can't build here");
    		ifbputright = false;
    	}
    	return ifbputright;
    }
    
    public static boolean ifCPutRight(){
    	boolean ifcputright = false;
    	if(		SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl1_p2.getPosition().getX() &&
				SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY() &&
				//exclude own Position
				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b == moveINGods.pl1_p2.getPosition().getY()) &&
				//exclude other pawn positions
				(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY()) && 
				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p1.getPosition().getY()) &&
				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p2.getPosition().getY()) &&
				SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] < 3){
    		ifcputright = true;
    	}else {
    		System.out.println("Can't build here");
    		ifcputright = false;
    	}
    	return ifcputright;
    }
    
    public static boolean ifDPutRight(){
    	boolean ifdputright = false;
    	if(		SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX()+1 || SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX()-1 || SpielefieldGods.a == moveINGods.pl2_p2.getPosition().getX() &&
				SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()+1 || SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()-1 || SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY() &&
				//exclude own Position
				(SpielefieldGods.a != moveINGods.pl2_p2.getPosition().getX() && SpielefieldGods.b == moveINGods.pl2_p2.getPosition().getY()) &&
				//exclude other pawn positions
				(SpielefieldGods.a != moveINGods.pl1_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p1.getPosition().getY()) && 
				(SpielefieldGods.a != moveINGods.pl2_p1.getPosition().getX() && SpielefieldGods.b != moveINGods.pl2_p1.getPosition().getY()) &&
				(SpielefieldGods.a != moveINGods.pl1_p2.getPosition().getX() && SpielefieldGods.b != moveINGods.pl1_p2.getPosition().getY()) &&
				SpielefieldGods.Field[SpielefieldGods.a][SpielefieldGods.b] < 3){
    		ifdputright = true;
    	}else {
    		System.out.println("Can't build here");
    		ifdputright = false;
    	}
    	return ifdputright;
    }

}
