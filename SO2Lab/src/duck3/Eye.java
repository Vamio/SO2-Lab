package duck3;

/* A class responsible for a duck's eye
 * 
 * Authors: Soinikov, Nikita, Onyewuenyi, Stephen
 * Date: 19.06.2026
 */

import java.awt.Color;

public class Eye {
	private int x, y, height, width;
	private Color color = Color.BLACK;

	public Eye(int x, int y, int height, int width) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}

	public void setColor(Color c) {
		color = c;
	}

	public void draw() {
		Canvas.PEN.setColor(color);
		Canvas.PEN.fillOval(x, y, width, height);
		Canvas.PEN.setColor(Color.black);
	}
}