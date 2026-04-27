package duck;

public class Application {
	private Duck alexey;
	private Duck anton;
	
	public Application() {
		int width = 150;
		int height = 60;
		int x = 200;
		int y = 300;
		
		alexey = new Duck(600, 300, 50, 20); // x, y, width, height
		anton = new Duck(x, y, width, height);
	}
	
	public void draw() {
		alexey.draw();
		anton.draw();
	}
}
