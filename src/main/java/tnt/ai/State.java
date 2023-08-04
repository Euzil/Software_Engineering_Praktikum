package tnt.ai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class State implements Comparable<State> {
    private int table[][] = new int[5][5];
    private Coordinates posMaxA;
    private Coordinates posMaxB;
    private Coordinates posMinA;
    private Coordinates posMinB;
    public short estPoints = 0;
    State(Coordinates a, Coordinates b, Coordinates c, Coordinates d) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                table[i][j] = 0;
            }
        }
        posMaxA = a;
        posMaxB = b;
        posMinA = c;
        posMinB = d;
    }
    State(int[][] tab, Coordinates a, Coordinates b, Coordinates c, Coordinates d) {
        for (int i = 0; i < 5; i++) {
            System.arraycopy(tab[i], 0, this.table[i], 0, 5);
        }
        posMaxA = a;
        posMaxB = b;
        posMinA = c;
        posMinB = d;
    }
    State(int[][] tab, Coordinates a, Coordinates b, Coordinates c, Coordinates d, Coordinates construct,
            boolean player, boolean sube) {
        for (int i = 0; i < 5; i++) {
            System.arraycopy(tab[i], 0, this.table[i], 0, 5);
        }
        table[construct.getX()][construct.getY()]++;
        if (player) {
            if (table[a.getX()][a.getY()] == 3 || table[b.getX()][b.getY()] == 3)
                estPoints = 50;
            else {
                if (sube)
                    estPoints += 4;
                estPoints += table[a.getX()][a.getY()] * 10;
                if (a.getY() == 2)
                    estPoints += 5;
                else if (a.getY() == 1 || a.getY() == 3)
                    estPoints += 3;

                if (a.getX() == 2)
                    estPoints += 5;
                else if (a.getX() == 1 || a.getX() == 3)
                    estPoints += 3;

                estPoints += table[b.getX()][b.getY()] * 10;
                if (b.getY() == 2)
                    estPoints += 5;
                else if (b.getY() == 1 || b.getY() == 3)
                    estPoints += 3;

                if (b.getX() == 2)
                    estPoints += 5;
                else if (b.getX() == 1 || b.getX() == 3)
                    estPoints += 3;
            }
        } else {
            if (table[c.getX()][c.getY()] == 3 || table[c.getX()][c.getY()] == 3)
                estPoints = 50;
            else {
                if (sube)
                    estPoints += 4;
                estPoints += table[c.getX()][c.getY()] * 10;
                if (c.getY() == 2)
                    estPoints += 5;
                else if (c.getY() == 1 || c.getY() == 3)
                    estPoints += 3;

                if (c.getX() == 2)
                    estPoints += 5;
                else if (c.getX() == 1 || c.getX() == 3)
                    estPoints += 3;

                if (sube)
                    estPoints += 5;
                estPoints += table[d.getX()][d.getY()] * 10;
                if (d.getY() == 2)
                    estPoints += 5;
                else if (d.getY() == 1 || d.getY() == 3)
                    estPoints += 3;

                if (d.getX() == 2)
                    estPoints += 5;
                else if (d.getX() == 1 || d.getX() == 3)
                    estPoints += 3;
            }
        }
        posMaxA = a;
        posMaxB = b;
        posMinA = c;
        posMinB = d;
    }
    State(State e, Coordinates a, Coordinates b, Coordinates c, Coordinates d, Coordinates construct) {
        for (int i = 0; i < 5; i++) {
            System.arraycopy(e.table[i], 0, this.table[i], 0, 5);
        }
        table[construct.getX()][construct.getY()]++;
        posMaxA = a;
        posMaxB = b;
        posMinA = c;
        posMinB = d;
    }
    State(State e) {
        for (int i = 0; i < 5; i++) {
            System.arraycopy(e.table[i], 0, this.table[i], 0, 5);
        }
        this.posMaxA = e.posMaxA;
        this.posMaxB = e.posMaxB;
        this.posMinA = e.posMinA;
        this.posMinB = e.posMinB;

    }
    Coordinates getA() {
        return this.posMaxA;
    }
    Coordinates getB() {
        return this.posMaxB;
    }
    Coordinates getC() {
        return this.posMinA;
    }
    Coordinates getD() {
        return this.posMinB;
    }
    int evaluation() {
        int points = 0;
        int pointsA = 0;
        int pointsB = 0;
        int pointsC = 0;
        int pointsD = 0;
        boolean stuckA = true;
        boolean stuckB = true;
        boolean stuckC = true;
        boolean stuckD = true;
        for (Coordinates c : posMaxA.adjacent()) {
            if (this.legalMove(posMaxA, c)) {
                pointsA += pointsAdjacent(this.table[c.getX()][c.getY()]);
                stuckA = false;
            }
        }
        for (Coordinates c : posMaxB.adjacent()) {
            if (this.legalMove(posMaxB, c)) {
                pointsB += pointsAdjacent(this.table[c.getX()][c.getY()]);
                stuckB = false;
            }
        }
        if (stuckA && stuckB)
            return -10000; // derrota
        for (Coordinates c : posMinA.adjacent()) {
            if (this.legalMove(posMinA, c)) {
                pointsC -= pointsAdjacent(this.table[c.getX()][c.getY()]);
                stuckC = false;
            }
        }
        for (Coordinates c : posMinB.adjacent()) {
            if (this.legalMove(posMinB, c)) {
                pointsD -= pointsAdjacent(this.table[c.getX()][c.getY()]);
                stuckD = false;
            }
        }
        if (stuckC && stuckD)
            return 10000; // win
        if (this.table[posMaxA.getX()][posMaxA.getY()] == 3) {
            return 10000;
        } else if (this.table[posMaxB.getX()][posMaxB.getY()] == 3) {
            return 10000;
        } else if (this.table[posMinA.getX()][posMinA.getY()] == 3) {
            return -10000;
        } else if (this.table[posMinB.getX()][posMinB.getY()] == 3) {
            return -10000;
        } else {
            points += this.table[posMaxA.getX()][posMaxA.getY()] * 100;
            points += this.table[posMaxB.getX()][posMaxB.getY()] * 100;
            points -= this.table[posMinA.getX()][posMinA.getY()] * 100;
            points -= this.table[posMinB.getX()][posMinB.getY()] * 100;
        }
        if (stuckA || stuckB)
            points -= 300;
        if (stuckC || stuckD) {
            points += 300;
        }
        return points + pointsA + pointsB + pointsC + pointsD;
    }
    ArrayList<State> child(boolean playerMax) {
        ArrayList<State> ret = new ArrayList<State>();
        if (playerMax) {
            for (Coordinates c : posMaxA.adjacent()) {
                if (this.legalMove(posMaxA, c)) {
                    for (Coordinates d : c.adjacent()) {
                        if (this.legalConstruct(posMaxA, d)) {
                            ret.add(new State(this.table, c, posMaxB, posMinA, posMinB, d, true,
                                    this.table[c.getX()][c.getY()] > this.table[posMaxA.getX()][posMaxA.getX()]));
                        }
                    }
                }
            }
            for (Coordinates c : posMaxB.adjacent()) {
                if (this.legalMove(posMaxB, c)) {
                    for (Coordinates d : c.adjacent()) {
                        if (this.legalConstruct(posMaxB, d)) {
                            ret.add(new State(this.table, posMaxA, c, posMinA, posMinB, d, true,
                                    this.table[c.getX()][c.getY()] > this.table[posMaxB.getX()][posMaxB.getX()]));
                        }
                    }
                }
            }
        } else {
            for (Coordinates c : posMinA.adjacent()) {
                if (this.legalMove(posMinA, c)) {
                    for (Coordinates d : c.adjacent()) {
                        if (this.legalConstruct(posMinA, d)) {
                            ret.add(new State(this.table, posMaxA, posMaxB, c, posMinB, d, false,
                                    this.table[c.getX()][c.getY()] > this.table[posMinA.getX()][posMinA.getX()]));
                        }
                    }
                }
            }
            for (Coordinates c : posMinB.adjacent()) {
                if (this.legalMove(posMinB, c)) {
                    for (Coordinates d : c.adjacent()) {
                        if (this.legalConstruct(posMinB, d)) {
                            ret.add(new State(this.table, posMaxA, posMaxB, posMinA, c, d, false,
                                    this.table[c.getX()][c.getY()] > this.table[posMinB.getX()][posMinB.getX()]));
                        }
                    }
                }
            }
        }
        Collections.sort(ret);
        return ret;
    }
    boolean legalMove(Coordinates org, Coordinates dest) {
        if (this.table[dest.getX()][dest.getY()] <= this.table[org.getX()][org.getY()] + 1 && !tileOccupied(dest))
            return true;
        else
            return false;
    }
    boolean tileOccupied(Coordinates dest) {
        if (dest.equals(posMaxA) || dest.equals(posMaxB) || dest.equals(posMinA) || dest.equals(posMinB))
            return true;
        else
            return false;
    }
    boolean legalConstruct(Coordinates org, Coordinates dest) {
        if (table[dest.getX()][dest.getY()] < 4 && (dest.equals(org) || !tileOccupied(dest)))
            return true;
        else
            return false;
    }
    String showState() {
        StringBuilder ret = new StringBuilder();
        ret.append("------------------------------\n");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (posMaxA.equals(new Coordinates(i, j))) {
                    ret.append(String.format("%s%s   ", table[i][j], "A"));
                } else if (posMaxB.equals(new Coordinates(i, j))) {
                    ret.append(String.format("%s%s   ", table[i][j], "B"));
                } else if (posMinA.equals(new Coordinates(i, j))) {
                    ret.append(String.format("%s%s   ", table[i][j], "C"));
                } else if (posMinB.equals(new Coordinates(i, j))) {
                    ret.append(String.format("%s%s   ", table[i][j], "D"));
                } else {
                    ret.append(String.format("%s    ", table[i][j]));
                }
            }
            ret.append("\n");
        }
        ret.append("------------------------------");
        return ret.toString();
    }
    int pointsAdjacent(int tileValue) {
        // return (int) Math.pow(3, (1 + tileValue));
        return 5 * (++tileValue);
    }
    @Override
    public int compareTo(State o) {
        return o.estPoints
                - this.estPoints;
    }
}
