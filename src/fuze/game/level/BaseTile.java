package fuze.game.level;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class BaseTile extends Tile {

	public Image sprite;

	public BaseTile(int id) {
		super(id);
		try {
			sprite = new Image("res/32t.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public void render(Graphics g, float x, float y) {
		sprite.draw(x, y);
	}

}
