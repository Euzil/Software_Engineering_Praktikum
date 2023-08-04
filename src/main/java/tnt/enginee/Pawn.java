package tnt.enginee;

import java.util.Scanner;

//import break_out.model.Position;

public class Pawn {
    //Scanner sc = new Scanner(System.in);
    //private int pawnPlayer;
    //private int pawnNumber;
    private Position position;

    public void setPawnPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return this.position;
    }
    
    public Pawn(Position position) {
    	this.position = position;
    }

    /*public void setPawnPlayer(int pawnPlayer) {
        this.pawnPlayer = pawnPlayer;
    }

    public int getPawnPlayer() {
        return this.pawnPlayer;
    }

    public void setPawnNumber(int pawnNumber) {
        this.pawnNumber = pawnNumber;
    }

    public int getPawnNumber() {
        return this.pawnNumber;
    }*/

    /*public void setPawn(Field f, Pawn p) {
        boolean isSet = false;
        while(!isSet) {
            if(!isSet) {
                System.out.print("Enter the row you want to set your pawn "+p+" in.");
                int r = sc.nextInt();
                System.out.print("Enter the collumn you want to set your pawn "+p+" in.");
                int c = sc.nextInt();
                if (!f.getOccupied(r,c)) {
                    isSet = true;
                    f.setOccupied(r,c, true);
                    Position set = new Position(r,c,0);
                    p.setPawnPosition(set);
                }else {
                    System.out.println("The chosen Field is already occupied, please choose another.");
                }
            }
        }
    }*/


   /* public int canMove(Field f, Pawn p1, Pawn p2, GodCard g){
        // Checks which fields the pawn can move to, based on the Position of the pawns and the Godcard the player has
        int a = p1.position.getX();
        int b = p1.position.getY();
        int c = p1.position.getZ();
        int viableFieldCount = 0;

        if(g.getGodNumber() == 1){
            for (int i = (a-1); i < (a+1);i++){
                System.out.println();
                for (int j = (b-1); j < (b+1);i++){
                    if((!f.getOccupied(i,j)) && (f.getHeight(i,j) != 4) && (f.getHeight(i,j) <= (c+1)) ) {
                        System.out.print("The Pawn "+ p1 +" can Move to field "+ i +","+ j+ "; ");
                        viableFieldCount = viableFieldCount++;
                    }
                    if(f.getOccupied(i,j) && !(p2.position.getX() == i) && !(p2.position.getY() == j)){
                        System.out.println("The Pawn "+ p1 +" can change positions with the opponents Pawn, on Field "+ i+", "+j+";");
                        viableFieldCount = viableFieldCount++;
                    }
                }
            }
            return viableFieldCount;

        }else if((g.getGodNumber() == 2)){
            for (int i = (a-2); i < (a+2);i++){
                System.out.println();
                for (int j = (b-2); j < (b+2);i++){
                    if((!f.getOccupied(i,j)) && (f.getHeight(i,j) != 4) && (f.getHeight(i,j) <= (c+1)) ) {
                        System.out.print("The Pawn "+ p1+" can Move to field "+ i +","+ j+ "; ");
                        viableFieldCount = viableFieldCount++;
                    }
                }
            }
            return viableFieldCount;

        }else if((g.getGodNumber() == 8)){//Minotaur, muss noch die ganze Logik habe vonwegen wann wo ein hinteres Feld frei ist
            for (int i = (a-1); i < (a+1);i++){
                System.out.println();
                for (int j = (b-1); j < (b+1);i++){
                    if((!f.getOccupied(i,j)) && (f.getHeight(i,j) != 4) && (f.getHeight(i,j) <= (c+1)) ) {
                        System.out.print("The Pawn "+ p1+" can Move to field "+ i +","+ j+ "; ");
                        viableFieldCount = viableFieldCount++;
                    }
                    if(f.getOccupied(i,j) && !(p2.position.getX() == i) && !(p2.position.getY() == j)){
                        System.out.println("The Pawn "+ p1+" can change positions with the opponents Pawn, on Field "+ i+", "+j+";");
                        viableFieldCount = viableFieldCount++;
                    }
                }
                return viableFieldCount;

            }else{
                for (int i = (a-1); i < (a+1);i++){
                    System.out.println();
                    for (int j = (b-1); j < (b+1);i++){
                        if((!f.getOccupied(i,j)) && (f.getHeight(i,j) != 4) && (f.getHeight(i,j) <= (c+1)) ) {
                            System.out.print("The Pawn "+ p1+" can Move to field "+ i +","+ j+ "; ");
                            viableFieldCount = viableFieldCount++;
                        }
                        if(f.getOccupied(i,j) && !(p2.position.getX() == i) && !(p2.position.getY() == j)){
                            System.out.println("The Pawn "+ p1+" can Move to field "+ i +","+ j+ ", by pushing the opponents Pawn one tile back;");
                            viableFieldCount = viableFieldCount++;
                        }
                    }
                }
                return viableFieldCount;
            }

        }*/
		/*for (int i = (a-1); i < (a+1);i++){
			System.out.println();
			for (int j = (b-1); j < (b+1);i++){
				if((!f.getOccupied(i,j)) && (f.getHeight(i,j) != 4) && (f.getHeight(i,j) <= (c+1)) ) {
					System.out.print("The Pawn "+ p+" can Move to field "+ i +","+ j+ "; ");
					viableFieldCount = viableFieldCount++;
				}
			}
		}
		return viableFieldCount;
	}*/

       /* public void cannotMove(Field f, Pawn p1, Pawn p2, GodCard g) {
            if(canMove(f,p1,p2, g) == 0 && canMove(f, p2, p1, g) == 0) {
                //return true;
                System.out.println("You have lost. Better luck next time.");
            }/*else {
			return false;
		}
        }*/

       /* public int canBuild(Field f, Pawn p){
            //checks if a pawn can build, based on its position, the occupied fields and the fields with domes
            int a = p.position.getX();
            int b = p.position.getY();
            int c = p.position.getZ();
            int viableFieldCount = 0;

            for (int i = (a-1); i < (a+1);i++){
                System.out.println();
                for (int j = (b-1); j < (b+1);i++){
                    if((!f.getOccupied(i,j)) && (f.getHeight(i,j) != 4)) {
                        System.out.print("The Pawn "+ p+" can build in field "+ i +","+ j+ "; ");
                        viableFieldCount = viableFieldCount++;
                    }
                }
            }
            return viableFieldCount;
        }

        public void build(Field f, Pawn p) {
            //lets the seleced pawn build
            boolean hasMoved = false;
            while(!hasMoved) {
                if(!hasMoved) {
                    System.out.print("Enter the row you want to build in.");
                    int r = sc.nextInt();
                    System.out.print("Enter the column you want to build in.");
                    int c = sc.nextInt();
                    if((!f.getOccupied(r,c)) && (f.getHeight(r,c) != 4)) {
                        f.setHeight(r,c);
                        hasMoved = true;

                    }else {
                        System.out.println("The chosen Field is already occupied  or has a full tower, please choose another.");
                    }
                }
            }
        }

        public void cannotBuild(Field f, Pawn p1, Pawn p2) {
            if(canBuild(f,p1) == 0 && canBuild(f, p2) == 0) {
                //return true;
                System.out.println("What a shame, you have lost. Better luck nest time.");
            }/*else {
			return false;
		}*/
        }

	/*public void hasLost(Field f, Pawn p1, Pawn p2) {
		if(cannotMove(f, p1, p2) || cannotBuild(f, p1, p2)) {
			System.out.println("What a shame, you have lost. Better luck nest time.");
		}
	}*/


