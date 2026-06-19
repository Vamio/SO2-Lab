package duck3;

/* A class responsible for a duck's wing
 * 
 * Authors: Soinikov, Nikita, Onyewuenyi, Stephen
 * Date: 19.06.2026
 */

import java.awt.Color;

public class Wing {
	private int x, y, x1, y1, x2, y2;
	private Color color = Color.WHITE;
	
	public Wing(int x, int y, int x1, int y1, int x2, int y2) {
		this.x = x;
		this.y = y;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	public void setColor(Color c) {
		color = c;
	}
	
	public void draw() {
        int[] xArr = {x, x1, x2};
        int[] yArr = {y, y1, y2};
		
        Canvas.PEN.drawPolygon(xArr, yArr, 3);
        Canvas.PEN.setColor(color);
        Canvas.PEN.fillPolygon(xArr, yArr, 3);
        Canvas.PEN.setColor(Color.black); // resetting the color to the default
	}
}
