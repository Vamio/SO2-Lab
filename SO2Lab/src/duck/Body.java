package duck;

import java.awt.Color;

public class Body {
	private int x, y, width, height;
	private Leg legLeft;
	private Leg legRight;
	private Wing wing;
	private Tail tail;
	
	public Body(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		int leftFoot = width / 3;
		legLeft = new Leg(x + leftFoot, y + height, width, height);
		legRight = new Leg(x + leftFoot * 2, y + height, width, height);
		wing = new Wing(x, y, width, height);
		tail = new Tail(x + (width - width / 15), y + height / 3, x + width + (width / 4), y + height / 5, x + (width - (width / 15)), y + (height - height / 3));
	}
	
	public void draw() {
		// drawing tail under the body 
		tail.draw();
		// drawing the body
		Canvas.PEN.drawOval(x, y, width, height);
		Canvas.PEN.setColor(Color.white);
		Canvas.PEN.fillOval(x, y, width, height);
		//other parts
		legLeft.draw();
		legRight.draw();
		wing.draw();
		
	}
}
