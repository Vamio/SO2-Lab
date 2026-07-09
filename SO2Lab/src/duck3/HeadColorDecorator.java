package duck3;

/* A concrete decorator which colors the head (and neck) of a duck.
 *
 * Authors: Soinikov, Nikita, Onyewuenyi, Stephen
 * Date: 19.06.2026
 */

import java.awt.Color;

public class HeadColorDecorator extends DuckDecorator {
	private Color color;

	public HeadColorDecorator(DuckPlain duck, Color color) {
		super(duck);
		this.color = color;
	}

	@Override
	public void draw() {
		duck.setHeadColor(color);
		duck.draw();
	}
}
