package duck3;

/* The abstract decorator: wraps another DuckPlain and delegates
 * everything to it. Concrete decorators override draw() to add
 * their own decoration on top.
 *
 * Authors: Soinikov, Nikita, Onyewuenyi, Stephen
 * Date: 19.06.2026
 */

import java.awt.Color;
import java.awt.Point;

public abstract class DuckDecorator implements DuckPlain {
	protected DuckPlain duck; // the wrapped component

	public DuckDecorator(DuckPlain duck) {
		this.duck = duck;
	}

	@Override
	public void draw() {
		duck.draw();
	}

	@Override
	public void moveTo(int x, int y) {
		duck.moveTo(x, y);
	}

	@Override
	public Point address() {
		return duck.address();
	}

	@Override
	public int width() {
		return duck.width();
	}

	@Override
	public int height() {
		return duck.height();
	}

	@Override
	public int getX() {
		return duck.getX();
	}

	@Override
	public int getY() {
		return duck.getY();
	}

	@Override
	public int getHeadX() {
		return duck.getHeadX();
	}

	@Override
	public int getHeadY() {
		return duck.getHeadY();
	}

	@Override
	public int getHeadWidth() {
		return duck.getHeadWidth();
	}

	@Override
	public int getHeadHeight() {
		return duck.getHeadHeight();
	}

	@Override
	public void setBodyColor(Color c) {
		duck.setBodyColor(c);
	}

	@Override
	public void setHeadColor(Color c) {
		duck.setHeadColor(c);
	}

	@Override
	public void setEyeColor(Color c) {
		duck.setEyeColor(c);
	}
}
