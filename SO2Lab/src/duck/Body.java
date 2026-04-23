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
		
		legLeft = new Leg(x + 40, y + 57, width, height);//x + 40 , y + 100);
		legRight = new Leg(x + 80, y + 60, width, height);
		//old wing = new Wing(x + 55, y + 1, x + 155, y, x + 80, y + 45);
		wing = new Wing(x + 55, y + 1, width, height);
		tail = new Tail(x + 145, y + 20, x + 180, y + 40, x + 140, y + 44);
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
