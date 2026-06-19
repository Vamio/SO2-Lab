package duck3;

/* A superclass for glasses
 * 
 * Authors: Soinikov, Nikita, Onyewuenyi, Stephen
 * Date: 19.06.2026
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
		int lineX = x + width;
		int lineY = y;
		int lineX1 = x + width * 2;
		int lineY1 = y + (height / 6);
		
		Canvas.PEN.drawRect(x, y, width, height);
		Canvas.PEN.drawLine(lineX, lineY, lineX1, lineY1);
	}
}
