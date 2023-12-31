/**
 * modified by  Youran Wang (719511)
 */
package tnt.enginee;

public class Vector2D {
    private int x;
    private int y;

    /**
     * Construct a new Vector using the given components
     * @param x The x part
     * @param y The y part
     */
    public Vector2D(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Use this method in order to retrieve the X component of this vector.
     * @return The X component.
     */
    public int getX() {
        return x;
    }

    /**
     * Use this method in order to retrieve the Y component of this vector.
     * @return The Y component.
     */
    public int getY() {
        return y;
    }

    /**
     * Add another vector onto this one.
     * @param other The other vector to add.
     * @return a new Vec2 containing the sum of the two given vectors.
     */
    public Vector2D add(Vector2D other) {
        return new Vector2D(other.getX() + this.getX(), other.getY() + this.getY());
    }

    /**
     * Add another vector onto this one.
     * @param x The X component of the vector to add.
     * @param y The Y component of the vector to add.
     * @return a new Vec2 containing the sum of the two given vectors.
     */
    public Vector2D add(int x, int y) {
        return new Vector2D(this.getX() + x, this.getY() + y);
    }

    /**
     * Perform a scalar multiplication.
     * @param b The scalar to use.
     * @return A new scaled vector.
     */
    public Vector2D multiply(int b) {
        return new Vector2D(this.getX() * b, this.getY() * b);
    }

    @Override
    public String toString() {
        return "Vector2D: " + this.getX() + ", " + this.getY();
    }
}
