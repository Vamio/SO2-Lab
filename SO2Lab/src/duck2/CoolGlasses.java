package duck2;

public class CoolGlasses {
	private int x, y, height, width;
	
	public CoolGlasses(int x, int y, int height, int width) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}
	
	public void draw() {
		Canvas.PEN.drawRect(x, y, width, height);
		Canvas.PEN.drawLine(x + width, y, x + width * 2, y + (height / 6));
	}
}
