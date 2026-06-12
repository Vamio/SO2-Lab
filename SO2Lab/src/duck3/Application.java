package duck3;

/* A class where ducks are being drawn
 *
 * Authors: Soinikov, Nikita
 */

import java.util.ArrayList;

public class Application {

    private ArrayList<Duck> ducks;
    private ArrayList<Hat> hats;
    private int width = 150;
    private int height = 60;
    private int x = 80;
    private int y = 300;
    private static final int NUMBER_OF_DUCKS = 5;

    public Application() {
        ducks = new ArrayList<Duck>();
        buildDucks();
        hats = new ArrayList<Hat>();
        hats.add(new ChefHat(ducks.get(0).getX(), ducks.get(0).getY() - ducks.get(0).height() / 2, 80, 80));
        hats.add(new CapHat(ducks.get(0).getX(), ducks.get(0).getY() - ducks.get(0).height() / 3, 80, 60));
        hats.add(new BowtieHat(ducks.get(0).getX(), ducks.get(0).getY() - ducks.get(0).height() / 6, 80, 50));
    }

    private void buildDucks() {
        ducks.clear();
        ducks.add(new Duck(x, y, width, height));
        for (int newDuck = 1; newDuck <= NUMBER_OF_DUCKS; newDuck++) {
            int newX = x + width * newDuck * 2;
            Duck next = new Duck(newX, y, width, height);
            Duck previous = ducks.get(ducks.size() - 1);
            
            if (!next.intersects(previous)) {
                ducks.add(next);
            }
        }
    }

    public void draw() {
        for (int i = 0; i < ducks.size(); i++) {
            ducks.get(i).draw();
        }
    }

    public void makeBigger() {
    	width += 5;
    	height += 2;
    	buildDucks();
    }
    
    public void makeSmaller() {
    	if(width != 0 || height != 0) {
	        width -= 5;
	        height -= 2;
	        buildDucks();
    	}
    }
    
    public void changeHats(int value) {
    	int currentHat = value;
    	
    	hats.get(currentHat).draw();
    	
    }
}
