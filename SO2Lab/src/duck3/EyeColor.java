package duck3;

/* Enum of selectable eye colors, each carrying its awt Color.
 *
 * Authors: Soinikov, Nikita, Onyewuenyi, Stephen
 * Date: 19.06.2026
 */

import java.awt.Color;

public enum EyeColor {
    BLACK(Color.BLACK),
    GREEN(Color.GREEN),
    BLUE(Color.BLUE);

    private final Color color;

    private EyeColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
