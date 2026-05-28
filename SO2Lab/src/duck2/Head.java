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
		// Beak
		int beakX = x + (width / 20);
		int beakY = y + (height / 3);
		int beakX1 = x - (width / 3);
		int beakY1 = y + (height / 3);
		int beakX2 = x;
		int beakY2 = y + (width / 2);
		beak = new Beak(beakX, beakY, beakX1, beakY1, beakX2, beakY2);
		// Neck
		int neckX      = x + headWidth;
		int neckY      = y + (height - height / 3);
		int neckWidth  = width - (width / 3);
		int neckHeight = height;
		neck = new Neck(neckX, neckY, neckWidth, neckHeight);
		// Eye
		int eyeX      = x + (width / 4);
		int eyeY      = y + (height / 4);
		int eyeWidth  = width / 4;
		int eyeHeight = height / 4;
		eye = new Eye(eyeX, eyeY, eyeWidth, eyeHeight);
		// Glasses
		int glassesX      = x + (width / 4);
		int glassesY      = y + (height / 5);
		int glassesWidth  = height / 3;
		int glassesHeight = headWidth;
		aPairOfGlasses = randomGlasses(glassesX, glassesY, glassesWidth, glassesHeight);
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
