package duck3;

/* A subclass of Hat representing a chef's hat
 *
 * Authors: Soinikov, Nikita
 */

import java.awt.Color;

public class ChefHat extends Hat {

    public ChefHat(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void draw() {
        int brimmH = getHeight() / 3;
        int brimmW = getWidth() / 2;
        int topX = getX();
        int brimmX = topX + brimmW / 2;
        int topW = getWidth();
        int topH = getHeight() - brimmH;

        // tall white top
        Canvas.PEN.setColor(Color.white);
        Canvas.PEN.fillRect(topX, getY(), topW, topH);
        Canvas.PEN.setColor(Color.black);
        Canvas.PEN.drawRect(topX, getY(), topW, topH);

        // brim at bottom
        Canvas.PEN.setColor(Color.white);
        Canvas.PEN.fillRect(brimmX, getY() + topH, brimmW, brimmH);
        Canvas.PEN.setColor(Color.black);
        Canvas.PEN.drawRect(brimmX, getY() + topH, brimmW, brimmH);
    }
}
