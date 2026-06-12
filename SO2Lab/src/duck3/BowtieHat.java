package duck3;

/* A subclass of Hat representing a pink bowtie
 *
 * Authors: Soinikov, Nikita
 */

import java.awt.Color;

public class BowtieHat extends Hat {

    public BowtieHat(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void draw() {
        int midX = getX() + getWidth() / 2;
        int midY = getY() + getHeight() / 2;

        Canvas.PEN.setColor(Color.pink);
        // left part
        int[] lx = { getX(), getX(), midX };
        int[] ly = { getY(), getY() + getHeight(), midY };
        Canvas.PEN.fillPolygon(lx, ly, 3);
        // right part
        int[] rx = { getX() + getWidth(), getX() + getWidth(), midX };
        int[] ry = { getY(), getY() + getHeight(), midY };
        Canvas.PEN.fillPolygon(rx, ry, 3);
        Canvas.PEN.setColor(Color.black);
    }
}
