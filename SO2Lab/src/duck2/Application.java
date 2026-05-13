package duck2;

import java.util.ArrayList;

public class Application {
	private ArrayList<Duck> ducks;
	
	public Application() {
		int width = 150;
		int height = 60;
		int x = 200;
		int y = 300;
		
		ducks = new ArrayList<Duck>();
		
		ducks.add(new Duck(x, y, width, height));
		ducks.add(new Duck(x + width * 2, y, width, height));
		
		//(600, 300, 1500, 600) x, y, width, height, test large duck
	}
	
	public void draw() {
		for(Duck duck : ducks)
			duck.draw();
		
	}
}
