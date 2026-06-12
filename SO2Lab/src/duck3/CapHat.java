package duck3;

/* A subclass of Hat representing a blue cap
 *
 * Authors: Soinikov, Nikita
 */

import java.awt.Color;

public class CapHat extends Hat {

    public CapHat(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void draw() {
        int brimmH = getHeight() / 5;
        int brimmW = getWidth() / 3;

        Canvas.PEN.setColor(Color.blue);
        // top of a cap
        Canvas.PEN.fillArc(getX(), getY(), getWidth(), getHeight() * 2, 0, 180);
        // brim 
        Canvas.PEN.fillRect(getX() - brimmW, getY() + getHeight() - brimmH, brimmW, brimmH);
        Canvas.PEN.setColor(Color.black);
    }
}
