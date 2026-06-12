package duck3;

/* Superclass for hat accessories
 *
 * Authors: Soinikov, Nikita
 */

public class Hat {

    private int x, y, width, height;

    public Hat(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void draw() {
        Canvas.PEN.drawRect(x, y, width, height);
    }
}
