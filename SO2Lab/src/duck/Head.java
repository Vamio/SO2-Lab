package duck;

import java.awt.Color;

public class Head {
	private int x, y, width, height;
	private Beak beak;
	private Neck neck;
	private Eye eye;
	
	public Head(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		beak = new Beak(x, y + 15, x - 15, y + 20, x ,y + 25);
		neck = new Neck(x + 20, y + 30, width , height - 10);
		eye = new Eye(x + 10, y + 10, width / 4, height / 4);
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
