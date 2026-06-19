package duck3;

/* A class responsible for a duck's neck
 * 
 * Authors: Soinikov, Nikita, Onyewuenyi, Stephen
 * Date: 19.06.2026
 */

import java.awt.Color;

public class Neck {
	private int x, y, height, width;
	private Color color = Color.WHITE;
	
	public Neck(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}
	
	public void setColor(Color c) {
		color = c;
	}
	
	public void draw() {
		Canvas.PEN.drawOval(x, y, width, height);
		Canvas.PEN.setColor(color);
		Canvas.PEN.fillOval(x, y, width, height);
		Canvas.PEN.setColor(Color.black);
	}
}
