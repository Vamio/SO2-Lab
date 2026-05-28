package duck2;

/* A class where ducks are being drawn
 * 
 * Authors: Soinikov, Nikita
 */

import java.util.ArrayList;

public class Application {
	private ArrayList<Duck> ducks;
	private int width = 150;
	private int height = 60;
	private int x = 80;
	private int y = 300;
	private static final int NUMBER_OF_DUCKS = 5;
	
	public Application() {
		ducks = new ArrayList<Duck>();
		// Duck 0 is created
		ducks.add(new Duck(x, y, width, height));
		//ducks.add(new Duck(x, y - height, width, height)); // duck 1 is located so it intersects with duck 0 from above
		/*ducks.add(new Duck(x + width * 2, y, width, height));
		ducks.add(new Duck(x + width * 2, y - height, width, height));
		ducks.add(new Duck(x + width * 6, y, width, height));*/
		for (int newDuck = 1; newDuck <= NUMBER_OF_DUCKS; newDuck++) {
			int newX = x + width * newDuck * 2;
			ducks.add(new Duck(newX, y, width, height));
		}
	}
	
	public void draw() {
		ducks.get(0).draw(); // drawing the first duck 0
		
		for (int thisDuck = 1; thisDuck < ducks.size(); thisDuck++) {
			Duck previousDuck = ducks.get(thisDuck - 1);
			Duck currentDuck = ducks.get(thisDuck);
			// drawing a duck if it doesn't collide with the previous one
			if(!currentDuck.intersects(previousDuck)) {
				currentDuck.draw();
				System.out.println("Duck " + thisDuck + " is drawn");
			} else {
				System.out.println("Duck " + thisDuck + " is NOT drawn");
				// moved duck (i) where it should be in line
				currentDuck.moveTo(x + width * thisDuck * 2, y);
				System.out.println("Duck " + thisDuck + " is placed in correct location");
				
			}
		}
	}
}
