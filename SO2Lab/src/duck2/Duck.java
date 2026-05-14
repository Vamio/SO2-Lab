package duck2;

import java.awt.Point;

public class Duck implements LocatedRectangle {
	private Body body; // composition
	private Head head; // composition
	private Point position;
	private int width, height;
	
	public Duck(int x, int y, int width, int height) {
		this.width = width;
		this.height = height;
		this.position = new Point(x, y);
		
		body = new Body(x, y, width, height);
		head = new Head(x - (width / 9), y - (height / 3 * 2), width / 3, height - (height / 4));
	}
	
	public void draw() {
		head.draw();
		body.draw();
	}

	public Point address() { return position; }

	public int width() { return width; }

	public int height() { return height; }
}
