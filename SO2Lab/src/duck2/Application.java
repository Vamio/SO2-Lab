package duck2;

/* A class where ducks are being drawn
 * 
 * Authors: Soinikov, Nikita
 */

import java.util.ArrayList;

public class Application {
	private ArrayList<Duck> ducks;
	
	public Application() {
		int width = 150;
		int height = 60;
		int x = 200;
		int y = 300;
		
		ducks = new ArrayList<Duck>();
		// !!! CHECK HEIGHT INTERSECTIONS
		ducks.add(new Duck(x, y, width, height));
		ducks.add(new Duck(x + width * 2, y, width, height));
		ducks.add(new Duck(x + width * 4, y, width, height));
		ducks.add(new Duck(x + width * 6, y, width, height));
	}
	
	public void draw() {
		ducks.get(0).draw(); // drawing the first duck
		
		for (int i = 1; i < ducks.size(); i++) {
			Duck previousDuck = ducks.get(i - 1);
			Duck currentDuck = ducks.get(i);
			// drawing a duck if it doesn't collide with the previous one
			if(currentDuck.intersects(previousDuck)) {
				currentDuck.draw();
				System.out.println("Duck " + i + " is drawn");
			} else {
				System.out.println("Duck " + i + " is NOT drawn");
			}
		}
	}
}
