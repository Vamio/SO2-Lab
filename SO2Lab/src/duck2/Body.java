package duck2;

/* A class which assembles the body of a duck
 * 
 * Authors: Soinikov, Nikita
 */

import java.awt.Color;

public class Body {
	private int x, y, width, height;
	private Leg legLeft; // composition
	private Leg legRight; // composition
	private Wing wing; // composition
	private Tail tail; // composition
	
	public Body(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		int leftFoot = width / 3;
		legLeft = new Leg(x + leftFoot, y + height, width, height);
		legRight = new Leg(x + leftFoot * 2, y + height, width, height);
		wing = new Wing(x + (width / 3), y + 1, x + width, y, x + (width / 2), y + (height / 2));
		tail = new Tail(x + (width - width / 15), 	y + height / 3,
						x + width + (width / 4), 	y + height / 5,
						x + (width - (width / 15)), y + (height - height / 3));
	}
	
	public void draw() {
		// drawing tail under the body 
		tail.draw();
		// drawing the body
		Canvas.PEN.drawOval(x, y, width, height);
		Canvas.PEN.setColor(Color.white);
		Canvas.PEN.fillOval(x, y, width, height);
		// other body parts
		legLeft.draw();
		legRight.draw();
		wing.draw();
		
	}
}
