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
        int x1 = x + width;
        int y1 = y;
        int x2 = (int) (x + width /2);
        System.out.println("orig x2: " + x2);
        System.out.println("x + width: " + (x + width));
        int y2 = (int) (y + height /2);
        System.out.println("orig y2: " + y2);
        System.out.println("x + height: " + (y + height));
		
        Canvas.PEN.drawPolygon(new int[] { x + (width / 3), x1, x2 }, new int[] { y + 1, y1, y2 }, 3);
        Canvas.PEN.setColor(Color.white);
        Canvas.PEN.fillPolygon(new int[] { x + (width / 3), x1, x2 }, new int[] { y + 1, y1, y2 }, 3);
        Canvas.PEN.setColor(Color.black); // resetting the color to the default
	}
}
