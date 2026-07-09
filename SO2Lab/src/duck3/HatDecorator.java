package duck3;

/* A concrete decorator which puts a hat on a duck.
 * The hat sits on top of the head, so this decorator also
 * enlarges the bounding box upwards by the hat height.
 * type: 0 = chef hat, 1 = cap, 2 = bowtie
 *
 * Authors: Soinikov, Nikita, Onyewuenyi, Stephen
 * Date: 19.06.2026
 */

import java.awt.Point;

public class HatDecorator extends DuckDecorator {
	private Hat hat;

	public HatDecorator(DuckPlain duck, int type) {
		super(duck);
		int hatX = duck.getHeadX();
		int hatY = duck.getHeadY() - duck.getHeadHeight();
		hat = makeHat(type, hatX, hatY, duck.getHeadWidth(), duck.getHeadHeight());
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

	@Override
	public void draw() {
		duck.draw();
		hat.draw();
	}

	@Override
	public Point address() {
		// the hat extends the bounding box upwards by the hat height
		Point p = duck.address();
		return new Point(p.x, p.y - duck.getHeadHeight());
	}

	@Override
	public int height() {
		return duck.height() + duck.getHeadHeight();
	}

	@Override
	public int getY() {
		return duck.getY() - duck.getHeadHeight();
	}
}
