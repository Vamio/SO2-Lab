package duck;

public class Duck {
	private Body body;
	private Head head;
	
	public Duck(int left, int top, int width, int height) {
		body = new Body(left, top, width, height);
		head = new Head(left - (width/9), top - height / 3 * 2 , width / 3, height - (height / 4));
	}
	
	public void draw() {
		head.draw();
		body.draw();
	}
}
