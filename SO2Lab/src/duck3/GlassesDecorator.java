package duck3;

/* A decorator which puts a pair of glasses on a duck.
 *
 * Authors: Soinikov, Nikita, Onyewuenyi, Stephen
 * Date: 19.06.2026
 */

public class GlassesDecorator extends DuckDecorator {
	private Glasses glasses;

	public GlassesDecorator(DuckPlain duck, int type) {
		super(duck);
		int glassesX = duck.getHeadX() + (duck.getHeadWidth() / 4);
		int glassesY = duck.getHeadY() + (duck.getHeadHeight() / 5);
		int glassesWidth = duck.getHeadHeight() / 3;
		int glassesHeight = duck.getHeadWidth() / 3;
		glasses = makeGlasses(type, glassesX, glassesY, glassesHeight, glassesWidth);
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

	@Override
	public void draw() {
		duck.draw();
		glasses.draw();
	}
}
