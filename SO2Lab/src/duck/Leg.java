package duck;

import java.awt.Color;

public class Leg {
	private int x, y, width, height;
	
	public Leg (int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void draw() {
		int footWidth = x - (width/5); 
		int footHeight = y + height;
		Canvas.PEN.setColor(Color.orange);
		Canvas.PEN.drawLine(x, y, x, y + height);
		Canvas.PEN.fillRect(footWidth, footHeight, width / 5, height / 5);
		Canvas.PEN.setColor(Color.black);	// resetting the color to the default
	}
}
