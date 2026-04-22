package duck;
import java.awt.Color;

public class Wing {
	private int x, y, x1, y1, x2, y2;
	
	public Wing(int x, int y, int x1, int y1, int x2, int y2) {
		this.x = x;
		this.y = y;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	public void draw() {
		Canvas.PEN.drawPolygon(new int[] {x, x1, x2}, new int[] {y, y1, y2}, 3);
		Canvas.PEN.setColor(Color.white);
		Canvas.PEN.fillPolygon(new int[] {x, x1, x2}, new int[] {y, y1, y2}, 3);
		Canvas.PEN.setColor(Color.black); // resetting the color to the default
	}
}
