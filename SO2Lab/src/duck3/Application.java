package duck3;

/* A class where ducks are being drawn
 *
 * Authors: Soinikov, Nikita, Onyewuenyi, Stephen
 * Date: 19.06.2026
 */

import java.util.ArrayList;
import java.awt.Color;

public class Application {

    private ArrayList<Duck> ducks;
    private ArrayList<Hat> hats;
    private int width = 150;
    private int height = 60;
    private int x = 80;
    private int y = 300;
    private static final int NUMBER_OF_DUCKS = 5;
    private static final Color[] BODY_COLORS = { Color.WHITE, Color.GRAY, Color.YELLOW };
    private int glassesType = 0;
    private int hatType = 0;
    private int bodyColorIndex = 0;

    public Application() {
        ducks = new ArrayList<Duck>();
        hats = new ArrayList<Hat>();

        buildDucks();
    }

    private void buildDucks() {
        ducks.clear();
        // Duck 0 is created
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

        for (Duck duck : ducks) {
            duck.setGlassesType(glassesType);
            duck.setBodyColor(BODY_COLORS[bodyColorIndex]);
            duck.setHeadColor(BODY_COLORS[bodyColorIndex]);
        }
        
        buildHats();
    }

    private Hat makeHat(int type, int x, int y, int width, int height) {
        switch (type) {
            case 0:
                return new ChefHat(x, y, width, height);
            case 1:
                return new CapHat(x, y, width, height);
            case 2:
                return new BowtieHat(x, y, width, height);
            default:
                return new ChefHat(x, y, width, height);
        }
    }

    private void buildHats() {
        hats.clear();
        int hatWidth = width / 3;
        int hatHeight = height - (height / 4);
        
        for (Duck duck : ducks) {
            int hatX = duck.getX() + hatWidth / 3;
            int hatY = duck.getY() - hatHeight;
            hats.add(makeHat(hatType, hatX, hatY, hatWidth, hatHeight));
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
        x -= 5;
        y -= 2;
        buildDucks();
    }

    public void makeSmaller() {
        if (width != 0 || height != 0) {
            width -= 5;
            height -= 2;
            x += 5;
            y += 2;
            buildDucks();
        }
    }

    public void changeGlasses() {
        glassesType = (glassesType + 1) % 3;

        for (Duck duck : ducks) {
            duck.setGlassesType(glassesType);
        }
    }

    public void changeHats() {
        hatType = (hatType + 1) % 3;
        buildHats();
    }
    
    public void changeBodyColor() {
    	bodyColorIndex = (bodyColorIndex + 1) % 3;
    	
    	for (Duck duck : ducks) {
    		duck.setBodyColor(BODY_COLORS[bodyColorIndex]);
    		duck.setHeadColor(BODY_COLORS[bodyColorIndex]);
    	}
    }
}
