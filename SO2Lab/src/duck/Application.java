package duck;

public class Application {
	private Duck alexey;
	private Duck anton;
	
	public Application() {
		alexey = new Duck(200, 300, 10, 60); // x, y, width, height
		anton = new Duck(500, 300, 150, 60);
	}
	
	public void draw() {
		alexey.draw();
		anton.draw();
	}
}
