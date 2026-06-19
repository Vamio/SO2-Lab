package duck3;

/* A subclass of Hat representing a pink bowtie
 *
 * Authors: Soinikov, Nikita, Onyewuenyi, Stephen
 * Date: 19.06.2026
 */

import java.awt.Color;

public class BowtieHat extends Hat {

    public BowtieHat(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void draw() {
        int midX = getX() + getWidth() / 2;
        int midY = getY() + getHeight();

        Canvas.PEN.setColor(Color.PINK);
        // left part
        int[] lx = { getX(), getX(), midX };
        int[] ly = { getY() + getHeight() / 3, getY() + getHeight() + getHeight() / 3, midY };
        Canvas.PEN.fillPolygon(lx, ly, 3);
        // right part
        int[] rx = { getX() + getWidth(), getX() + getWidth(), midX };
        int[] ry = { getY() + getHeight() / 3, getY() + getHeight() + getHeight() / 3, midY };
        Canvas.PEN.fillPolygon(rx, ry, 3);
        // ball
        Canvas.PEN.drawOval(getX() + getWidth() / 2 - getWidth() / 6, getY() + getHeight() - getHeight() / 6, getWidth() / 4, getHeight() / 4);
        Canvas.PEN.setColor(Color.WHITE);
        Canvas.PEN.fillOval(getX() + getWidth() / 2 - getWidth() / 6, getY() + getHeight() - getHeight() / 6, getWidth() / 4, getHeight() / 4);
        Canvas.PEN.setColor(Color.BLACK);
    }
}
