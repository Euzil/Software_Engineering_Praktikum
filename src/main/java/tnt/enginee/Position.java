/**
 * modified by Youran Wang (719511)
 */
package tnt.enginee;

public class Position {
    public static int x;
    public int y;
    /**
     * Construct a new Position using the given components
     * @param x The x part
     * @param y The y part
     */
    public Position(int x, int y ){
        this.x=x;
        this.y=y;
    }
    /**
     * Use this method in order to retrieve the x component of this Player.
     * @return The x component.
     */
    public int getX() {
        return this.x;
    }
    /**
     * Use this method in order to retrieve the ycomponent of this Player.
     * @return The y component.
     */
    public int getY() {
        return this.y;
    }
    /**
     * Use this method in order to retrieve the z component of this Player.
     * @return The z component.
     */



}
