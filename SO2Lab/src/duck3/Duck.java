package duck3;

/* A class where a plain duck is assembled.
 *
 * Authors: Soinikov, Nikita, Onyewuenyi, Stephen
 * Date: 19.06.2026
 */

import java.awt.Point;
import java.awt.Color;

public class Duck implements DuckPlain {

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
    }

    @Override
    public void draw() {
        head.draw();
        body.draw();
    }
    
    @Override
    public void setBodyColor(Color c) {
    	body.setColor(c);
    }

    @Override
    public void setHeadColor(Color c) {
    	head.setColor(c);
    }

    @Override
    public void setEyeColor(Color c) {
    	head.setEyeColor(c);
    }


    @Override
    public void moveTo(int x, int y) {
        int headX = x - (width / 9);
        int headY = y - ((height / 3) * 2);
        int headWidth = width / 3;
        int headHeight = height - (height / 4);

        this.x = x;
        this.y = y;
        this.position = new Point(x - 2 * (width / 9), headY);
        body = new Body(x, y, width, height);
        head = new Head(headX, headY, headWidth, headHeight);
    }

    @Override
    public int getX() {
        return x - 2 * (width / 9);
    }

    @Override
    public int getY() {
        return y - ((height / 3) * 2);
    }

    @Override
    public int getHeadX() {
        return x - (width / 9);
    }

    @Override
    public int getHeadY() {
        return y - ((height / 3) * 2);
    }

    @Override
    public int getHeadWidth() {
        return width / 3;
    }

    @Override
    public int getHeadHeight() {
        return height - (height / 4);
    }

    @Override
    public Point address() {
        return position;
    }

    @Override
    public int width() {
        // left: beak tip at x - 2*(width/9), right: tail tip at x + width + width/4
        return 2 * (width / 9) + width + (width / 4);
    }

    @Override
    public int height() {
        // top: head at y - (height/3)*2, bottom: foot at y + 2*height + height/5
        return ((height / 3) * 2) + 2 * height + (height / 5);
    }
}
