package duck;

public class Duck {
	private Body body;
	private Head head;
	
	public Duck(int x, int y, int width, int height) {
		body = new Body(x, y, width, height);
		head = new Head(x - (width / 9), y - (height / 3 * 2), width / 3, height - (height / 4));
	}
	
	public void draw() {
		head.draw();
		body.draw();
	}
}
