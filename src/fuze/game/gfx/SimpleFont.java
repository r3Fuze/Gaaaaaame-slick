package fuze.game.gfx;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;

public class SimpleFont {

	private UnicodeFont	font;

	public SimpleFont(String fontPath, int size, Col color) throws SlickException {
		this(fontPath, size, false, false, color);
	}

	@SuppressWarnings("unchecked")
	public SimpleFont(String fontPath, int size, boolean bold, boolean italic, Col color) throws SlickException {
		this.font = new UnicodeFont(fontPath, size, bold, italic);
		ColorEffect colorEffect = new ColorEffect(color.toAWT());
		this.font.getEffects().add(colorEffect);
		this.font.addAsciiGlyphs();
		this.font.loadGlyphs();
	}

	@SuppressWarnings("unchecked")
	public void setColor(Col color) throws SlickException {
		font.getEffects().clear();
		font.getEffects().add(new ColorEffect(color.toAWT()));
		font.clearGlyphs();
		font.addAsciiGlyphs();
		font.loadGlyphs();
	}

	public UnicodeFont get() {
		return font;
	}

	public int getLineHeight() {
		return font.getLineHeight();
	}
	
	public int getHeight(String text) {
		return font.getHeight(text);
	}

	public int getWidth(String text) {
		return font.getWidth(text);
	}

	public void drawString(float x, float y, String text) {
		font.drawString(x, y, text);
	}

	public void drawString(float x, float y, String text, Col color) {
		font.drawString(x, y, text, color.toSlick());
	}
}
