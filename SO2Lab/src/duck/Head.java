package duck;

import java.awt.Color;

public class Head {
	private int x, y, width, height;
	private Beak beak;
	private Neck neck;
	private Eye eye;
	
	public Head(int x, int y, int width, int height) {
		int headWidth = width/3;
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		beak = new Beak(x, y + 15, x - 15, y + 20, x ,y + 25);
		neck = new Neck(x + headWidth, y + (height - height / 3), width - (width / 3), height);
		eye = new Eye(x + ((width/4 ) / 10), y + (y / 20), width / 4, height / 4);
	}
	
	public void draw() {
		// drawing neck under the head and the body
		neck.draw();
		// drawing the head
		Canvas.PEN.drawOval(x, y, width, height);
		Canvas.PEN.setColor(Color.white);
		Canvas.PEN.fillOval(x, y, width, height);
		Canvas.PEN.setColor(Color.black);
		// adding a beak
		beak.draw();
		// drawing an eye
		eye.draw();
	}
}
