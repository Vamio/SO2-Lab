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
		int x1 = (int) (x + width * 0.367);
        int y1 = (int) (y + height * 0.017);
        int x2 = (int) (x + width * 1.033);
        int y2 = y;
        int x3 = (int) (x + width * 0.533);
        int y3 = (int) (y + height * 0.75);

		
        Canvas.PEN.drawPolygon(
                new int[] { x, x2, x3 },
                new int[] { y, y2, y3 },
                3
            );
            Canvas.PEN.setColor(Color.white);
            Canvas.PEN.fillPolygon(
                new int[] { x, x2, x3 },
                new int[] { y, y2, y3 },
                3
            );
            Canvas.PEN.setColor(Color.black); // resetting the color to the default
	}
}
