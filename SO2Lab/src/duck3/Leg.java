package duck3;

/* A class responsible for a duck's leg
 * 
 * Authors: Soinikov, Nikita, Onyewuenyi, Stephen
 * Date: 19.06.2026
 */

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
		int footX = x - (width/5); 
		int footY = y + height;
		int footWidth = width / 5;
		int footHeight = height / 5;
		
		Canvas.PEN.setColor(Color.orange);
		Canvas.PEN.drawLine(x, y, x, y + height);
		Canvas.PEN.fillRect(footX, footY, footWidth, footHeight); // Drawing feet
		Canvas.PEN.setColor(Color.black);	// Resetting the color to the default
	}
}
