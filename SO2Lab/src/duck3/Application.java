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
    private int glassesType = 0;

    public Application() {
        ducks = new ArrayList<Duck>();
        hats = new ArrayList<Hat>();
        buildDucks();
        //hats.add(new ChefHat(ducks.get(0).getX(), ducks.get(0).getY() - ducks.get(0).height() / 2, 80, 80));
        //hats.add(new CapHat(ducks.get(0).getX(), ducks.get(0).getY() - ducks.get(0).height() / 3, 80, 60));
        //hats.add(new BowtieHat(ducks.get(0).getX(), ducks.get(0).getY() - ducks.get(0).height() / 6, 80, 50));
    }

    private void buildDucks() {
        ducks.clear();
        ducks.add(new Duck(x, y, width, height));
        for (int newDuck = 1; newDuck <= NUMBER_OF_DUCKS; newDuck++) {
            int newX = x + width * newDuck * 2;
            int newY = y;

            Duck next = new Duck(newX, newY, width, height);
            Duck previous = ducks.get(ducks.size() - 1);

            if (!next.intersects(previous)) {
                ducks.add(next);
            }
        }
        int duckX = ducks.get(0).getX();
        
        for (Duck duck : ducks) {
            duck.setGlassesType(glassesType);
            hats.add(new ChefHat(duckX++,ducks.get(0).getY() - ducks.get(0).height() / 2, 80, 80));
            System.out.println("Hat added");
        }
    }

    public void draw() {
        for (int i = 0; i < ducks.size(); i++) {
            ducks.get(i).draw();
            hats.get(i).draw();
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
    
    public void changeGlasses() {
        glassesType = (glassesType + 1) % 3;
        
        for (Duck duck : ducks) {
            duck.setGlassesType(glassesType);
        }
    }
}
