package duck2;

public class SunGlasses extends Glasses{
	public SunGlasses (int x, int y, int height, int width) {
		super(x, y, height, width);
	}
	
	public void draw() {
		super.draw();
		// shading the glasses
		Canvas.PEN.fillRect(x, y, width, height);
	}
}
