package duck3;

/* A class where a duck is assembled
 *
 * Authors: Soinikov, Nikita, Onyewuenyi, Stephen
 * Date: 19.06.2026
 */

import java.awt.Point;
import java.awt.Color;

public class Duck implements LocatedRectangle {

    private Body body; // composition
    private Head head; // composition
    private Point position;
    private int x, y, width, height;

    public Duck(int x, int y, int width, int height) {
        int headX = x - (width / 9);
        int headY = y - ((height / 3) * 2);
        int headWidth = width / 3;
        int headHeight = height - (height / 4);

        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.position = new Point(x - 2 * (width / 9), headY);

        body = new Body(x, y, width, height);
        head = new Head(headX, headY, headWidth, headHeight);
        // Glasses
        int glassesX = headX + (headWidth / 4);
        int glassesY = headY + (headHeight / 5);
        int glassesWidth = headHeight / 3;
        int glassesHeight = headWidth / 3;
        head.setGlasses(
            giveRandomGlasses(glassesX, glassesY, glassesHeight, glassesWidth)
        );
    }
    
    private Glasses giveRandomGlasses(int x, int y, int height, int width) {
        return makeGlasses(0, x, y, height, width);
    }

    private Glasses makeGlasses(int type, int x, int y, int height, int width) {
        switch (type) {
            case 0:
                return new ReadingGlasses(x, y, width, height);
            case 1:
                return new SunGlasses(x, y, width, height);
            case 2:
                return new FancyGlasses(x, y, width, height);
            default:
                return new Glasses(x, y, width, height);
        }
    }

    public void setGlassesType(int type) {
        int headX = x - (width / 9);
        int headY = y - ((height / 3) * 2);
        int headWidth = width / 3;
        int headHeight = height - (height / 4);
        int glassesX = headX + (headWidth / 4);
        int glassesY = headY + (headHeight / 5);
        int glassesWidth = headHeight / 3;
        int glassesHeight = headWidth / 3;
        head.setGlasses(makeGlasses(type, glassesX, glassesY, glassesHeight, glassesWidth));
    }
    
    public void setBodyColor(Color c) {
    	body.setColor(c);
    }
    
    public void setHeadColor(Color c) {
    	head.setColor(c);
    }

    public void draw() {
        //Canvas.PEN.drawRect(getX(), getY(), width(), height());
        head.draw();
        body.draw();
    }

    public void moveTo(int x, int y) {
        int headX = x - (width / 9);
        int headY = y - ((height / 3) * 2);
        int headWidth = width / 3;
        int headHeight = height - (height / 4);

        this.position = new Point(x - 2 * (width / 9), headY);
        body = new Body(x, y, width, height);
        head = new Head(headX, headY, headWidth, headHeight);

        int glassesX = headX + (headWidth / 4);
        int glassesY = headY + (headHeight / 5);
        int glassesWidth = headHeight / 3;
        int glassesHeight = headWidth / 3;
        head.setGlasses(giveRandomGlasses(glassesX, glassesY, glassesHeight, glassesWidth));
    }

    public int getX() {
        return x - 2 * (width / 9);
    }

    public int getY() {
        return y - ((height / 3) * 2);
    }

    public int getHeadHeight() {
        return height - (height / 4);
    }

    @Override
    public Point address() {
        return position;
    }

    @Override
    public int width() {
        return 2 * (width / 9) + width + (width / 4);
    }

    @Override
    public int height() {
        return ((height / 3) * 2) + 2 * height + (height / 5);
    }
}
