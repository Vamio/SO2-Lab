package duck3;

/* A subclass of Glasses for fancy pink glasses
 * 
 * Authors: Soinikov, Nikita
 */


import java.awt.Color;

public class FancyGlasses extends Glasses{
	public FancyGlasses (int x, int y, int height, int width) {
		super(x, y, height, width);
	}
	
	@Override
	public void draw() { 
		// making glasses pink, then resetting the colour
		Canvas.PEN.setColor(Color.pink);
		super.draw();
		Canvas.PEN.fillOval(getX(), getY() - (getHeight() / 4), getWidth() / 4, getHeight() / 4);
		Canvas.PEN.fillOval(getX() + (getWidth() / 3), getY() - (getHeight() / 4), getWidth() / 4, getHeight() / 4);
		Canvas.PEN.setColor(Color.black);
	}
}
