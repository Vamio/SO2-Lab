package duck3;

/* A test program for the decorator pattern. Fills the scene with all kinds of variations of the ducks.
 *
 * Authors: Soinikov, Nikita, Onyewuenyi, Stephen
 * Date: 19.06.2026
 */

import java.util.ArrayList;
import java.awt.Color;

public class DecoratorTest {
    private static final int WIDTH = 100;
    private static final int HEIGHT = 40;
    private static final int START_X = 150;
    private static final int START_Y = 50;
    private static final int HORIZONTAL_GAP = 150;
    private static final int VERTICAL_GAP = 150;

    private static final Color[] EYE_COLORS = { Color.BLACK, Color.GREEN, Color.BLUE };
    private static final Color[] HEAD_COLORS = { Color.WHITE, Color.GRAY, Color.YELLOW };

    public static void fillScene(ArrayList<DuckPlain> ducks) {
        // row 1: plain duck, then the three glasses variations
        ducks.add(makePlain(0, 0));
        for (int type = 0; type < 3; type++) {
            ducks.add(new GlassesDecorator(makePlain(type + 1, 0), type));
        }

        // row 2: the three hat variations
        for (int type = 0; type < 3; type++) {
            ducks.add(new HatDecorator(makePlain(type, 1), type));
        }

        // row 3: the three eye colors
        for (int type = 0; type < 3; type++) {
            ducks.add(new EyeColorDecorator(makePlain(type, 2), EYE_COLORS[type]));
        }

        // row 4: the three head colors
        for (int type = 0; type < 3; type++) {
            ducks.add(new HeadColorDecorator(makePlain(type, 3), HEAD_COLORS[type]));
        }

        // row 5: fully customised ducks, four decorators combined
        for (int type = 0; type < 3; type++) {
            ducks.add(
                new HatDecorator(
                    new GlassesDecorator(
                        new EyeColorDecorator(
                            new HeadColorDecorator(makePlain(type, 4), HEAD_COLORS[type]),
                            EYE_COLORS[type]),
                        type),
                    type));
        }
    }

    private static Duck makePlain(int column, int row) {
        int x = START_X + column * HORIZONTAL_GAP;
        int y = START_Y + row * VERTICAL_GAP;
        return new Duck(x, y, WIDTH, HEIGHT);
    }
}
