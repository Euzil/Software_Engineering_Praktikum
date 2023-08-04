package tnt.ai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.*;

/*
input example: d28 (d moves down and builds up)
 */
public class AiInit {
    private static State result;
    static void player() throws IOException {
        Coordinates a = new Coordinates(1, 1);
        Coordinates b = new Coordinates(3, 3);
        Coordinates c = new Coordinates(3, 1);
        Coordinates d = new Coordinates(1, 2);
        int[][] tab = { { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0 },
        };
        State e = new State(tab, a, b, c, d);
        ArrayList<State> gameplay = new ArrayList<>();
        gameplay.add(e);
        System.out.println("----------------------->>>>>>>>>>>>>>>>>>>>>>>>>");
        int depth = 5;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println(e.showState());
            System.out.println("Nächster Zug? a b c d:");
            String inl = br.readLine();
            String player = inl.substring(0, 1);
            String pattern = "^([ab]|[cd][12346789][12346789][+-]?)$";
            if (!Pattern.matches(pattern, inl)) {
                System.out.println("Error: No Input");
            } else {
                if (player.equals("c") || player.equals("d")) {
                    String mov = inl.substring(1, 2);
                    String cons = inl.substring(2, 3);
                    if (inl.length() == 4) {
                        System.out.println(inl.substring(3, 4));
                        if (inl.substring(3, 4).equals("+"))
                            depth++;
                        else
                            depth--;
                    }
                    int x, y;
                    if (player.equals("c")) {
                        x = e.getC().getX();
                        y = e.getC().getY();
                    } else {
                        x = e.getD().getX();
                        y = e.getD().getY();
                    }
                    Coordinates n = null;
                    switch (mov) {
                        case "7":
                            n = new Coordinates(x - 1, y - 1);
                            break;
                        case "8":
                            n = new Coordinates(x - 1, y);
                            break;
                        case "9":
                            n = new Coordinates(x - 1, y + 1);
                            break;
                        case "4":
                            n = new Coordinates(x, y - 1);
                            break;
                        case "6":
                            n = new Coordinates(x, y + 1);
                            break;
                        case "1":
                            n = new Coordinates(x + 1, y - 1);
                            break;
                        case "2":
                            n = new Coordinates(x + 1, y);
                            break;
                        case "3":
                            n = new Coordinates(x + 1, y + 1);
                            break;
                    }
                    Coordinates cordCons = null;
                    x = n.getX();
                    y = n.getY();
                    switch (cons) {
                        case "7":
                            cordCons = new Coordinates(x - 1, y - 1);
                            break;
                        case "8":
                            cordCons = new Coordinates(x - 1, y);
                            break;
                        case "9":
                            cordCons = new Coordinates(x - 1, y + 1);
                            break;
                        case "4":
                            cordCons = new Coordinates(x, y - 1);
                            break;
                        case "6":
                            cordCons = new Coordinates(x, y + 1);
                            break;
                        case "1":
                            cordCons = new Coordinates(x + 1, y - 1);
                            break;
                        case "2":
                            cordCons = new Coordinates(x + 1, y);
                            break;
                        case "3":
                            cordCons = new Coordinates(x + 1, y + 1);
                            break;
                    }
                    if (player.equals("c")) {
                        e = new State(e, e.getA(), e.getB(), n, e.getD(), cordCons);
                    } else {
                        e = new State(e, e.getA(), e.getB(), e.getC(), n, cordCons);
                    }
                    System.out.println(e.showState());
                    gameplay.add(e);
                    System.out.println("Processing...");
                    System.out.println("Depth: " + depth);
                    long startTime = System.nanoTime();
                    System.out.println(minmax(e, depth, true, depth, -9999999, 9999999));
                    long endTime = System.nanoTime();
                    long timeElapsed = endTime - startTime;
                    System.out.println("Execution time in milliseconds : " +
                            timeElapsed / 1000000);
                    e = new State(result);
                    gameplay.add(e);
                } else {
                    System.out.println(minmax(e, depth, true, depth, -9999999, 999999));
                    e = new State(result);
                    gameplay.add(e);
                }
            }
        }

    }

    private static int minmax(State e, int depth, boolean playerMax, int depthInicial, int alpha, int beta) {
        int evaluation = e.evaluation();
        if (evaluation >= 10000 || evaluation <= -10000 || depth == 0) {
            if (evaluation >= 10000)
                return evaluation + depth;
            else if (evaluation <= -10000)
                return evaluation - depth;
            else
                return evaluation;
        }
        if (playerMax) {
            int maxEva = -9999999;
            for (State o : e.child(true)) {
                int eva = minmax(o, depth - 1, false, depthInicial, alpha, beta);
                // maxEva = Math.max(maxEva, eva);
                if (eva > maxEva) {
                    maxEva = eva;
                    if (depth == depthInicial) {
                        result = new State(o);
                    }
                }
                alpha = Math.max(alpha, eva);
                if (beta <= alpha)
                    break;

            }
            return maxEva;
        } else {
            int minEva = 999999;
            for (State o : e.child(false)) {
                int eva = minmax(o, depth - 1, true, depthInicial, alpha, beta);
                minEva = Math.min(minEva, eva);
                beta = Math.min(beta, eva);
                if (beta <= alpha)
                    break;
            }
            return minEva;
        }
    }
    static void test() {
        int[][] tab = { { 0, 0, 0, 0, 1 },
                { 0, 0, 0, 1, 1 },
                { 0, 0, 0, 1, 0 },
                { 0, 0, 2, 0, 1 },
                { 0, 0, 0, 2, 2 },
        };
        Coordinates a = new Coordinates(2, 2);
        Coordinates b = new Coordinates(3, 3);
        Coordinates c = new Coordinates(2, 1);
        Coordinates d = new Coordinates(2, 3);
        State e = new State(tab, a, b, c, d);
        int depth = 5;
        int iteraciones = 50;
        long startTime = System.nanoTime();
        for (int i = 0; i < iteraciones; i++) {
            minmax(e, depth, true, depth, -9999999, 9999999);
        }
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("Execution time in milliseconds : " + (timeElapsed / 1000000) / iteraciones);
    }
}
