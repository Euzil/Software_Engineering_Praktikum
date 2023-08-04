package tnt.ai;
import java.util.ArrayList;
public class Coordinates {
    private int x;
    private int y;
    Coordinates(int a, int b) {
        this.x = a;
        this.y = b;
    }
    int getX() {
        return this.x;
    }
    int getY() {
        return this.y;
    }
/*
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Coordinates)) {
            return false;
        }
        Coordinates = (Coordinates) o;
        if (c.getX() == this.getX() && c.getY() == this.getY())
            return true;
        return false;
    }
    */
    ArrayList<Coordinates> adjacent() {
        ArrayList<Coordinates> ret = new ArrayList<Coordinates>();
        for (int a = 0; a < 5; a++) {
            for (int b = 0; b < 5; b++) {
                if (a == x && (b == y + 1 || b == y - 1)) {
                    ret.add(new Coordinates(a, b));
                } else if (b == y && (a == x + 1 || a == x - 1)) {
                    ret.add(new Coordinates(a, b));
                } else if ((a == x + 1 || a == x - 1) && (b == y + 1 || b == y - 1)) { // diagonal
                    ret.add(new Coordinates(a, b));
                }
            }
        }
        return ret;
    }
    String showAdjacent(){
        return String.format("%s%s", x, y);
    }
    /**String (showAdjacent){
        String ret = "";
        for (Coordinates : this.adjacent()) {
            ret += "\n" + c.showAdjacent();
        }
        return ret;
    }
*/
}
