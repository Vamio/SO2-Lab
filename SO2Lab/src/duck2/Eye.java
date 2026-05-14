package duck2;

/* A class responsible for a duck's eye
 * 
 * Authors: Soinikov, Nikita
 */

public class Eye {
	private int x, y, height, width;
	
	public Eye(int x, int y, int height, int width) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}
	
	public void draw() {
		Canvas.PEN.fillOval(x, y, width, height);
	}
}