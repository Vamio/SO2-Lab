package duck3;

/* A class where head of a duck is assembled
 * 
 * Authors: Soinikov, Nikita, Onyewuenyi, Stephen
 * Date: 19.06.2026
 */

import java.awt.Color;

public class Head {
	private int x, y, width, height;
	private Color color = Color.WHITE;
	private Beak beak; // composition
	private Neck neck; // composition
	private Eye eye; // composition
	
	public Head(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		// Beak
		int beakX = x + (width / 20);
		int beakY = y + (height / 3);
		int beakX1 = x - (width / 3);
		int beakY1 = y + (height / 3);
		int beakX2 = x;
		int beakY2 = y + (width / 2);
		beak = new Beak(beakX, beakY, beakX1, beakY1, beakX2, beakY2);
		// Neck
		int neckX = x + width / 3;
		int neckY = y + (height - height / 3);
		int neckWidth = width - (width / 3);
		int neckHeight = height;
		neck = new Neck(neckX, neckY, neckWidth, neckHeight);
		// Eye
		int eyeX = x + (width / 4);
		int eyeY = y + (height / 4);
		int eyeWidth = width / 4;
		int eyeHeight = height / 4;
		eye = new Eye(eyeX, eyeY, eyeWidth, eyeHeight);
	}
	
	public void setColor(Color c) {
		color = c;
		neck.setColor(c);
	}

	public void setEyeColor(Color c) {
		eye.setColor(c);
	}
	
	public void draw() {
		// drawing neck under the head and the body
		neck.draw();
		// drawing the head
		Canvas.PEN.drawOval(x, y, width, height);
		Canvas.PEN.setColor(color);
		Canvas.PEN.fillOval(x, y, width, height);
		Canvas.PEN.setColor(Color.black);
		// adding a beak
		beak.draw();
		// drawing an eye
		eye.draw();
	}
}
