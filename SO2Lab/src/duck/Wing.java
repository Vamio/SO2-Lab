package duck;
import java.awt.Color;

public class Wing {
	private int x, y, width, height;
	
	public Wing(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void draw() {
		int x0 = x + (width / 3);
        int x1 = x + width;
        int x2 = (int) (x + width /2);
        int y0 = y + 1;
        int y1 = y;
        int y2 = (int) (y + height /2);
        int xArr[] = {x0, x1, x2};
        int yArr[] = {y0, y1, y2};
		
        Canvas.PEN.drawPolygon(xArr, yArr, 3);
        Canvas.PEN.setColor(Color.white);
        Canvas.PEN.fillPolygon(xArr, yArr, 3);
        Canvas.PEN.setColor(Color.black); // resetting the color to the default
	}
}
