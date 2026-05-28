package duck2;

/* A class where a duck is assembled
 * 
 * Authors: Soinikov, Nikita
 */

import java.awt.Point;

public class Duck implements LocatedRectangle {
	private Body body; // composition
	private Head head; // composition
	private Point position;
	private int width, height;
	
	public Duck(int x, int y, int width, int height) {
		int headX = x - (width / 9);
		int headY = y - (height / 3 * 2);
		int headWidth = width / 3;
		int headHeight = height - (height / 4);
		
		this.width = width;
		this.height = height;
		this.position = new Point(headX, headY);
		
		body = new Body(x, y, width, height);
		head = new Head(headX, headY, headWidth, headHeight);
		
		// Glasses
		int glassesX      = headX + (headWidth / 4);
		int glassesY      = headY + (headHeight / 5);
		int glassesWidth  = headHeight / 3;
		int glassesHeight = headWidth / 3;
		head.setGlasses(giveRandomGlasses(glassesX, glassesY, glassesHeight, glassesWidth));
	}
	
	private Glasses giveRandomGlasses(int x, int y, int height, int width) {
		switch(RandomNumber.between(0, 2)) {
		case 0:
			return new ReadingGlasses(x, y, width, height);
		case 1:
			return new SunGlasses(x, y, width, height);
		case 2:
			return new FancyGlasses(x, y, width, height);
		default:
			return new Glasses(x, y, width, height);
		}
	}
	
	public void draw() {
		head.draw();
		body.draw();
	}
	
	public void moveTo(int x, int y) {
		int headX = x - (width / 9);
		int headY = y - (height / 3 * 2);
		int headWidth = width / 3;
		int headHeight = height - (height / 4);
		
		this.position = new Point(headX, headY);
		body = new Body(x, y, width, height);
		head = new Head(headX, headY, headWidth, headHeight);
		
		int glassesX      = headX + (headWidth / 4);
		int glassesY      = headY + (headHeight / 5);
		int glassesWidth  = headHeight / 3;
		int glassesHeight = headWidth / 3;
		head.setGlasses(giveRandomGlasses(glassesX, glassesY, glassesHeight, glassesWidth));
	}
	
	@Override
	public Point address() { 
		return position; 
	}
	
	@Override
	public int width() { 
		return width + (width / 9); // Body + head
	}

	@Override
	public int height() { 
		return height + (height / 3 * 2); // Body + head
	}
}
