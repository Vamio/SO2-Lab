package duck;
import java.awt.Color;

public class Leg {
	private int x, y, x1, y1;
	
	public Leg (int x, int y, int x1, int y1) {
		this.x = x;
		this.y = y;
		this.x1 = x1;
		this.y1 = y1;
	}

	public void draw() {
		Canvas.PEN.setColor(Color.orange);
		Canvas.PEN.drawLine(x, y, x1, y1);
		Canvas.PEN.fillRect(x1-20, y1, 20, 10);
		Canvas.PEN.setColor(Color.black);	// resetting the color to the default
	}
}
