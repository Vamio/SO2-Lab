package duck2;

import java.awt.Point;

public class Duck implements LocatedRectangle {
	private Body body; // composition
	private Head head; // composition
	
	private int x, y, width, height;
	
	public Duck(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		body = new Body(x, y, width, height);
		head = new Head(x - (width / 9), y - (height / 3 * 2), width / 3, height - (height / 4));
	}
	
	public void draw() {
		head.draw();
		body.draw();
	}

	@Override
	public Point address() {
		// TODO Auto-generated method stub
		Point location = new Point(x,y);
		return location;
	}

	@Override
	public int width() {
		// TODO Auto-generated method stub
		return width;
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		return height;
	}
}
