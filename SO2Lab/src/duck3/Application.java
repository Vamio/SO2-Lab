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
    private int[][] positions = new int[NUMBER_OF_DUCKS + 1][2];
    private boolean positionsSet = false;
    private int width = 150;
    private int height = 60;
    private static final int INITIAL_WIDTH = 150;
    private static final int X = 80;
    private static final int Y = 300;
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

    private static final int CANVAS_WIDTH  = 1800;
    private static final int CANVAS_HEIGHT = 700;

    private void buildDucks() {
        ducks.clear();
        if (!positionsSet) {
            positions[0][0] = X;
            positions[0][1] = Y;
            for (int i = 1; i <= NUMBER_OF_DUCKS; i++) {
                boolean overlaps;
                do {
                    positions[i][0] = RandomNumber.between(0, CANVAS_WIDTH);
                    positions[i][1] = RandomNumber.between(height, CANVAS_HEIGHT);
                    overlaps = false;
                    for (int j = 0; j < i; j++) {
                        Duck a = new Duck(positions[i][0], positions[i][1], width, height);
                        Duck b = new Duck(positions[j][0], positions[j][1], width, height);
                        if (a.intersects(b)) {
                            overlaps = true;
                        }
                    }
                } while (overlaps);
            }
            positionsSet = true;
        }
        for (int i = 0; i <= NUMBER_OF_DUCKS; i++) {
            Duck candidate = new Duck(positions[i][0], positions[i][1], width, height);
            boolean overlaps = false;
            for (Duck existing : ducks) {
                if (candidate.intersects(existing)) {
                    overlaps = true;
                }
            }
            if (!overlaps) {
                ducks.add(candidate);
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
        buildDucks();
    }

    public void makeSmaller() {
        if (width > 5 && height > 2) {
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
