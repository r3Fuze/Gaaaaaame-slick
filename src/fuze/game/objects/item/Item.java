package fuze.game.objects.item;

import org.newdawn.slick.Graphics;

import fuze.game.Game;
import fuze.game.LuaConfig;
import fuze.game.gfx.Col;
import fuze.game.gfx.SimpleFont;

public class Item {

	public String		name	= "undefined";
	public ItemRarity	rarity	= ItemRarity.DEBUG;

	public String		lore	= "";

	// CFG stuff
	private float		tooltipOpacity;

	public Item(String name) {
		this.name = name;
		this.init();
	}

	private void init() {
		LuaConfig cfg = Game.luaCfg;
		tooltipOpacity = cfg.getFloat("item_tooltipOpacity", 0.65f);
	}

	public String getFullName() {
		return name;
	}

	public void drawOnGround(Graphics g, SimpleFont font, float x, float y) {
		String fullName = getFullName();
		int h = font.getHeight("X") + 7, w = font.getWidth(fullName) + 12;

		g.setColor(Col.black.setAlpha(tooltipOpacity).toSlick());
		g.fillRect(x, y, w, h);

		font.drawString(x + 6, y, fullName, rarity.color);
	}

}
