package duck3;

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
		// Legs
		int leftFoot = width / 3;
		int legY = y + height;
		int legLeftX  = x + leftFoot;
		int legRightX = x + leftFoot * 2;
		int legWidth  = width;
		int legHeight = height;
		legLeft  = new Leg(legLeftX,  legY, legWidth, legHeight);
		legRight = new Leg(legRightX, legY, legWidth, legHeight);
		// Wing
		int wingX  = x + (width / 3);
		int wingY  = y + 1;
		int wingX1 = x + width;
		int wingY1 = y;
		int wingX2 = x + (width / 2);
		int wingY2 = y + (height / 2);
		wing = new Wing(wingX, wingY, wingX1, wingY1, wingX2, wingY2);
		// Tail
		int tailX  = x + (width - width / 15);
		int tailY  = y + height / 3;
		int tailX1 = x + width + (width / 4);
		int tailY1 = y + height / 5;
		int tailX2 = x + (width - (width / 15));
		int tailY2 = y + (height - height / 3);
		tail = new Tail(tailX, tailY, tailX1, tailY1, tailX2, tailY2);
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
