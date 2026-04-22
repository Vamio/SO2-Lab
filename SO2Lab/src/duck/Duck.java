package duck;

public class Duck {
	private Body body;
	private Head head;
	
	public Duck(int left, int top, int width, int height) {
		body = new Body(left, top, width, height);
		head = new Head(left-20, top-40, width/3, height-20);
	}
	
	public void draw() {
		head.draw();
		body.draw();
	}
}
