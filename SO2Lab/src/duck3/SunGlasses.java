package duck3;

/* A subclass of Glasses for cool sunglasses
 * 
 * Authors: Soinikov, Nikita, Onyewuenyi, Stephen
 * Date: 19.06.2026
 */

public class SunGlasses extends Glasses{
	public SunGlasses (int x, int y, int height, int width) {
		super(x, y, height, width);
	}
	
	@Override
	public void draw() {
		super.draw();
		// shading the glasses
		Canvas.PEN.fillRect(getX(), getY(), getWidth(), getHeight());
	}
}
