package fuze.game.level;

import org.newdawn.slick.Graphics;

public class Level {

    public static final int MAP_WIDTH      = 64;
    public static final int MAP_WIDTH_MASK = MAP_WIDTH - 1;

    public int[]            tiles          = null;

    public int              xOffset        = 0;
    public int              yOffset        = 0;

    public int              width          = 0;
    public int              height         = 0;

    public Level(int width, int height) {
        tiles = new int[MAP_WIDTH * MAP_WIDTH];
        this.width = width;
        this.height = height;

        for (int i = 0; i < tiles.length; i++) {
            tiles[i] = 0;
        }
    }

    public void render(Graphics g, int offset, int row) {

    }
}
