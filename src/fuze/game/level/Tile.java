package fuze.game.level;

import org.newdawn.slick.Graphics;

public class Tile {

	public static final int SIZE = 32;

	public static Tile[]	tiles	= new Tile[512];

	public static Tile base = new BaseTile(0);

	public final byte		id;

	public Tile(int id) {
		this.id = (byte) id;
		if (tiles[id] != null) { throw new RuntimeException("Dupe tile IDs!"); }
		tiles[id] = this;
	}

	public void render(Graphics g, float x, float y) {

	}

}
