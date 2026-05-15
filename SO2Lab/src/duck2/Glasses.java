package duck2;

/* A superclass for glasses
 * 
 * Authors: Soinikov, Nikita
 */

public class Glasses {
	private int x, y, height, width; 
	
	public Glasses(int x, int y, int height, int width) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}
	
    public int getX() { return x; }
    public int getY() { return y; }
    public int getHeight() { return height; }
    public int getWidth() { return width; }
	
	public void draw() {
		Canvas.PEN.drawRect(x, y, width, height);
		Canvas.PEN.drawLine(x + width, y, x + width * 2, y + (height / 6));
	}
}
