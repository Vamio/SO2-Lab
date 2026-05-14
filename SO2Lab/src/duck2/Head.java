package duck2;

/* A class where head of a duck is assembled
 * 
 * Authors: Soinikov, Nikita
 */

import java.awt.Color;

public class Head {
	private int x, y, width, height;
	private Beak beak; // composition
	private Neck neck; // composition
	private Eye eye; // composition
	private Glasses aPairOfGlasses; // aggregation
	
	public Head(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		int headWidth = width / 3;
		beak = new Beak(x + (width / 20), y + (height / 3), x - (width / 3), y + (height / 3), x, y + (width / 2));
		neck = new Neck(x + headWidth, y + (height - height / 3), width - (width / 3), height);
		eye = new Eye(x + (width / 4), y + (height / 4), width / 4, height / 4);
		aPairOfGlasses = randomGlasses(x + (width / 4), y + (height / 5), height / 3, headWidth);
	}
	
	private Glasses randomGlasses(int x, int y, int height, int width) {
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
		// wearing glasses
		aPairOfGlasses.draw();
	}
}
