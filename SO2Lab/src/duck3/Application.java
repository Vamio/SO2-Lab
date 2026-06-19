package duck3;

/* A class where ducks are being drawn
 *
 * Authors: Soinikov, Nikita, Onyewuenyi, Stephen
 * Date: 19.06.2026
 */

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Point;

public class Application {

    private ArrayList<Duck> ducks;
    private ArrayList<Hat> hats;
    private ArrayList<Point> positions;
    private int width = 150;
    private int height = 60;
    private int x = 80;
    private int y = 300;
    private static final int NUMBER_OF_DUCKS = 20; // actually +1
    private static final Color[] BODY_COLORS = { Color.WHITE, Color.GRAY, Color.YELLOW };
    private int glassesType = 0;
    private int hatType = 0;
    private int bodyColorType = 0;

    public Application() {
        ducks = new ArrayList<Duck>();
        hats = new ArrayList<Hat>();
        positions = new ArrayList<Point>();

        buildDucks();
    }

    private void buildDucks() {
        ducks.clear();
        
        if (positions.isEmpty()) {
            positions.add(new Point(x, y));
            
            for (int newDuck = 1; newDuck <= NUMBER_OF_DUCKS; newDuck++) {
                Point pos;
                boolean overlaps;
                
                do {
                    pos = new Point(RandomNumber.between(0, 1920), RandomNumber.between(height, 1080)); // between duck and screen size
                    overlaps = false;
                    
                    for (Point existing : positions) {
                        Duck a = new Duck(pos.x, pos.y, width, height);
                        Duck b = new Duck(existing.x, existing.y, width, height);
                        if (a.intersects(b)) {
                            overlaps = true;
                        }
                    }
                } while (overlaps);
                
                positions.add(pos);
            }
        }
        
        for (Point pos : positions) {
            Duck newDuck = new Duck(pos.x, pos.y, width, height);
            boolean overlaps = false;
            
            for(Duck existing: ducks) {
            	if(newDuck.intersects(existing)) {
            		overlaps = true;
            	}
            }
            
            if(!overlaps) {
            	ducks.add(newDuck);
            }
        }

        for (Duck duck : ducks) {
            duck.setGlassesType(glassesType);
            duck.setBodyColor(BODY_COLORS[bodyColorType]);
            duck.setHeadColor(BODY_COLORS[bodyColorType]);
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
    	bodyColorType = (bodyColorType + 1) % 3;
    	
    	for (Duck duck : ducks) {
    		duck.setBodyColor(BODY_COLORS[bodyColorType]);
    		duck.setHeadColor(BODY_COLORS[bodyColorType]);
    	}
    }
}