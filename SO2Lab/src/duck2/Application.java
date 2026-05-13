package duck2;

import java.util.ArrayList;

public class Application {
	private ArrayList<Duck> ducks;
	private boolean canDraw = true;
	
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
		for (int i = 0; i < ducks.size(); i++) {
			for (int j = i + 1; j < ducks.size(); j++) {
				Duck alexey = ducks.get(i);
				Duck anton = ducks.get(j);
				
				System.out.println("Duck " + i + " intersects with duck " + j + ": " + alexey.intersects(anton));
				
				if (alexey.intersects(anton)) 
					canDraw = false;
			}
		}
		
		if (canDraw) {
			for (Duck duck : ducks) {
				duck.draw();
			}
		}
	}
}
