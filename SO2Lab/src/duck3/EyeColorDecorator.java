package duck3;

/* A concrete decorator which colors the eye of a duck.
 *
 * Authors: Soinikov, Nikita, Onyewuenyi, Stephen
 * Date: 19.06.2026
 */

import java.awt.Color;

public class EyeColorDecorator extends DuckDecorator {
	private Color color;

	public EyeColorDecorator(DuckPlain duck, Color color) {
		super(duck);
		this.color = color;
	}

	@Override
	public void draw() {
		duck.setEyeColor(color);
		duck.draw();
	}
}
