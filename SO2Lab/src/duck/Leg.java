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
		Canvas.PEN.setColor(Color.orange);
		Canvas.PEN.drawLine(x, y, x, y + 50);
		Canvas.PEN.fillRect(x-29, y + 50, width / 5, height / 5);
		Canvas.PEN.setColor(Color.black);	// resetting the color to the default
	}
}
