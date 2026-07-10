package duck3;

/* Enum of selectable body/head colors, each carrying its awt Color.
 *
 * Authors: Soinikov, Nikita, Onyewuenyi, Stephen
 * Date: 19.06.2026
 */

import java.awt.Color;

public enum BodyColor {
    WHITE(Color.WHITE),
    GRAY(Color.GRAY),
    YELLOW(Color.YELLOW);

    private final Color color;

    private BodyColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
