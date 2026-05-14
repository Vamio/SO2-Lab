package duck2;

import java.awt.Color;

public class FancyGlasses extends Glasses{
	public FancyGlasses (int x, int y, int height, int width) {
		super(x, y, height, width);
	}
	public void draw() {
		Canvas.PEN.setColor(Color.pink);
		super.draw();
		Canvas.PEN.setColor(Color.black);
	}
}
