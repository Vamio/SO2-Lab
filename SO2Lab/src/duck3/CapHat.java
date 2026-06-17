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
        int brimH = getHeight() / 5;
        int brimW = getWidth() / 3;

        Canvas.PEN.setColor(Color.BLUE);
        // top of a cap
        Canvas.PEN.fillArc(getX(), getY() + brimH, getWidth(), getHeight() * 2, 0, 180);
        // brim 
        Canvas.PEN.fillRect(getX() - brimW, getY() + getHeight(), brimW, brimH);
        Canvas.PEN.setColor(Color.BLACK);
    }
}
