/**
 * modified by  Youran Wang (719511)
 * and by Fin Hinrichs (712699)
 */
package tnt.enginee;
import tnt.enginee.GodCard;

public class PlayerGods {
    public String Name;
    public String Color;
    public Position position;
    public GodCard g;
    public Pawn p1;
    public Pawn p2;
    /**
     * Construct a new Player using the given components
     * @param name The name part
     * @param Color The Color part
     * @param Position The Position part
     */
    public PlayerGods(String Name, String Color, Position position, Pawn p1, Pawn p2, GodCard g){
        this.position=position;
        this.Name=Name;
        this.Color=Color;
        this.p1 = p1;
        this.p2 = p2;
        this.g = g;
    }
    /**
     * Use this method in order to set the Color component of this Player.
     */
    public void setColor(String color) {
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
    
    public void setGodCard(GodCard g) {
    	this.g = g;
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
    public String getColor() {
        return Color;
    }
    /**
     * Use this method in order to retrieve the Position component of this Player.
     * @return The Position component.
     */
    public Position getPosition() {
        return position;
    }
    
    public GodCard getGodCard() {
    	return g;
    }
    

    public void print(){
        System.out.println(getName());
        System.out.println(getColor());
        System.out.println(getPosition().getX()+","+getPosition().getY());
        System.out.println(getGodCard().getGodName());
    }

}
