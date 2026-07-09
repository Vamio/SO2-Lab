package duck3;

/* A class where ducks are being drawn.
 * Plain ducks are wrapped into decorators (glasses, hat,
 * eye color, head color) according to the current types.
 *
 * Authors: Soinikov, Nikita, Onyewuenyi, Stephen
 * Date: 19.06.2026
 */

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Point;

public class Application {

    private static final boolean TEST_MODE = true; // true: show all decorator variations, false: run normal mode with buttons

    private ArrayList<Duck> plainDucks;
    private ArrayList<DuckPlain> ducks;
    private ArrayList<Point> positions;
    
    private int width = 150;
    private int height = 60;
    private int x = 80;
    private int y = 300;
    
    private static final int NUMBER_OF_DUCKS = 20; // actually +1
    
    private static final Color[] BODY_COLORS = { Color.WHITE, Color.GRAY, Color.YELLOW };
    private static final Color[] HEAD_COLORS = { Color.WHITE, Color.GRAY, Color.YELLOW };
    private static final Color[] EYE_COLORS = { Color.BLACK, Color.GREEN, Color.BLUE };
    
    private int glassesType = 0;
    private int hatType = 0;
    private int bodyColorType = 0;
    private int headColorType = 0;
    private int eyeColorType = 0;

    public Application() {
        plainDucks = new ArrayList<Duck>();
        ducks = new ArrayList<DuckPlain>();
        positions = new ArrayList<Point>();

        if (TEST_MODE) {
            DecoratorTest.fillScene(ducks);
        } else {
            buildDucks();
        }
    }

    private void buildDucks() {
        plainDucks.clear();

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

            for(Duck existing: plainDucks) {
            	if(newDuck.intersects(existing)) {
            		overlaps = true;
            	}
            }

            if(!overlaps) {
            	plainDucks.add(newDuck);
            }
        }

        decorateDucks();
    }

    // Wraps every plain duck into the decorator stack according to the currently selected types. 
    private void decorateDucks() {
        ducks.clear();
        for (Duck duck : plainDucks) {
            duck.setBodyColor(BODY_COLORS[bodyColorType]);
            ducks.add(
                new HatDecorator(
                    new GlassesDecorator(
                        new EyeColorDecorator(
                            new HeadColorDecorator(duck, HEAD_COLORS[headColorType]),
                            EYE_COLORS[eyeColorType]),
                        glassesType),
                    hatType));
        }
    }

    public void draw() {
        for (int i = 0; i < ducks.size(); i++) {
            ducks.get(i).draw();
        }
    }

    public void makeBigger() {
        if (TEST_MODE) return;
        width += 5;
        height += 2;
        buildDucks();
    }

    public void makeSmaller() {
        if (TEST_MODE) return;
        if (width > 5 && height > 2) {
            width -= 5;
            height -= 2;
            buildDucks();
        }
    }

    public void changeGlasses() {
        if (TEST_MODE) return;
        glassesType = (glassesType + 1) % 3;
        decorateDucks();
    }

    public void changeHats() {
        if (TEST_MODE) return;
        hatType = (hatType + 1) % 3;
        decorateDucks();
    }

    public void changeBodyColor() {
        if (TEST_MODE) return;
        bodyColorType = (bodyColorType + 1) % 3;
        decorateDucks();
    }

    public void changeHeadColor() {
        if (TEST_MODE) return;
        headColorType = (headColorType + 1) % 3;
        decorateDucks();
    }

    public void changeEyeColor() {
        if (TEST_MODE) return;
        eyeColorType = (eyeColorType + 1) % 3;
        decorateDucks();
    }
}
