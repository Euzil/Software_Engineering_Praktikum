/**
 * modified by  Youran Wang (719511)
 */
package tnt.enginee;

import tnt.enginee.Position;
import tnt.enginee.MyColor;

import javax.swing.*;
import java.awt.*;

public class Player{
    public String Name;
    public Color Color;
    public Position position;
    /**
     * Construct a new Player using the given components
     * @param name The name part
     * @param Color The Color part
     * @param Position The Position part
     */
    public Player(String Name, java.awt.Color Color, Position position){
        this.position=position;
        this.Name=Name;
        this.Color=Color;
    }
    /**
     * Use this method in order to set the Color component of this Player.
     */
    public void setColor(Color color) {
        this.Color = color;
    }
    /**
     * Use this method in order to set the name component of this Player.
     */
    public void setName(String name) {
        this.Name = name;
    }
    /**
     * Use this method in order to set the BeginPosition component of this Player.
     */
    public void setBeginPosition(Position position) {
        this.position = position;
    }
    /**
     * Use this method in order to retrieve the name component of this Player.
     * @return The name component.
     */
    public String getName() {
        return Name;
    }
    /**
     * Use this method in order to retrieve the Color component of this Player.
     * @return The Color component.
     */
    public Color getColor() {
        return Color;
    }
    /**
     * Use this method in order to retrieve the Position component of this Player.
     * @return The Position component.
     */
    public Position getPosition() {
        return position;
    }

    public void print(){
        System.out.println(getName());
        System.out.println(getColor());
        System.out.println(getPosition().getX()+","+getPosition().getY());
    }

}
