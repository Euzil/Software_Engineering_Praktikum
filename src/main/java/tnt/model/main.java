package tnt.model;

import tnt.enginee.Player;
import tnt.enginee.Position;

import java.awt.*;

public class main {
    public static void main(String[] args){
        Player player = new Player("",null,new Position(2,2));
        System.out.println("Player 1 Name :");
        player.setColor(Color.GREEN);
        player.setBeginPosition(new Position(3,4));
        Position pos = new Position(6,6);
        System.out.println(pos.getX());


    }
}
