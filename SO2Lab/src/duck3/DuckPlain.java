package duck3;

/* Interface of the duck decorator pattern.
 *
 * Authors: Soinikov, Nikita, Onyewuenyi, Stephen
 * Date: 19.06.2026
 */

import java.awt.Color;

public interface DuckPlain extends LocatedRectangle {
	public void moveTo(int x, int y);

	// bounding box top-left corner
	public int getX();
	public int getY();

	// head geometry, needed by decorators to position glasses and hats
	public int getHeadX();
	public int getHeadY();
	public int getHeadWidth();
	public int getHeadHeight();

	// color setters used by the color decorators
	public void setBodyColor(Color c);
	public void setHeadColor(Color c);
	public void setEyeColor(Color c);
}
