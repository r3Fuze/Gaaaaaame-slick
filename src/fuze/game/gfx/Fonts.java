package fuze.game.gfx;

import org.newdawn.slick.SlickException;

import fuze.game.Game;

public class Fonts {

    public static SimpleFont basic       = null;
    public static SimpleFont basicItalic = null;
    public static SimpleFont basicThin   = null;

    public static void init() throws SlickException {
        String fnt = "fonts/" + Game.luaCfg.getString("font", "Fontin") + ".ttf";

        basic = new SimpleFont(fnt, 18, true, false, Col.white);
        basicItalic = new SimpleFont(fnt, 18, true, true, Col.white);
        basicThin = new SimpleFont(fnt, 18, false, false, Col.white);
    }

}
