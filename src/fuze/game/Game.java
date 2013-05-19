package fuze.game;

import javax.swing.JOptionPane;

import org.luaj.vm2.LuaValue;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;

import fuze.game.gfx.Fonts;
import fuze.game.level.Level;
import fuze.game.lua.LuaEvent;
import fuze.game.objects.item.Item;
import fuze.game.objects.item.ItemRarity;

public class Game extends BasicGame {

    /* GAME INFO */
    public static final String     NAME       = "Gaaaaame";
    public static final String     VERSION    = "1.0.0.0";

    public static final int        SCALE      = 3;
    public static final int        WIDTH      = 240;
    public static final int        HEIGHT     = WIDTH / 12 * 9;
    public static final boolean    FULLSCREEN = false;

    public static boolean          LOCK_FPS   = false;
    public static boolean          SHOW_FPS   = true;
    public static final int        TARGET_FPS = 60;

    /* MISC */
    public static AppGameContainer app        = null;
    public static Game             INSTANCE   = null;

    private int                    cX         = 100, cY = 100;

    public static LuaConfig        luaCfg     = null;
    public static LuaConfig        lua        = null;

    private Music                  bgMusic    = null;
    public Level                   level      = null;

    public Game(String title) {
        super(title);
        INSTANCE = this;
    }

    public static void main(String[] args) throws SlickException {
        app = new AppGameContainer(new Game(NAME + " (" + VERSION + ")"));
        app.setDisplayMode(WIDTH * SCALE, HEIGHT * SCALE, FULLSCREEN);
        app.setAlwaysRender(true);
        app.setTargetFrameRate(LOCK_FPS ? TARGET_FPS : -1);
        app.setShowFPS(SHOW_FPS);
        app.setUpdateOnlyWhenVisible(false);
        app.start();
    }

    public void init(GameContainer container) throws SlickException {
        /* Load resources */
        luaCfg = new LuaConfig("res/config.lua"); // Load config first

        bgMusic = new Music("bg_drums.wav");

        Fonts.init();
        LuaEvent.init();
        LuaEvent.registerEvent(LuaEvent.KEY_PRESSED);

        /* Init */

        level = new Level(WIDTH, HEIGHT);

        bgMusic.loop(1, 0.3f);

        lua = new LuaConfig("res/script.lua");
    }

    public void update(GameContainer container, int delta) throws SlickException {}

    public void keyPressed(int key, char c) {
        // Call Lua event first or last??
        LuaEvent.callEvent(lua, LuaEvent.KEY_PRESSED, LuaValue.valueOf(key), LuaValue.valueOf(Character.toString(c)));

        if (key == Input.KEY_L) {

        }

        if (key == Input.KEY_R) {
            luaCfg.reload();
            lua.reload();
        }

        if (key == Input.KEY_ESCAPE) app.exit();
    }

    public void mousePressed(int button, int x, int y) {
        // Call Lua event first or last??
        LuaEvent.callEvent(lua, LuaEvent.MOUSE_PRESSED, LuaValue.valueOf(button), LuaValue.valueOf(x), LuaValue.valueOf(x));
        if (button == Input.MOUSE_LEFT_BUTTON) {
            cX = x;
            cY = y;
        }
    }

    public void render(GameContainer gc, Graphics g) throws SlickException {
        // int width = gc.getWidth(), height = gc.getHeight();

        Image bg = new Image("res/image.png");
        bg.draw(0, 0);

        level.render(g, 0, WIDTH);

        Item item = new Item("Infernal Touch");
        item.rarity = ItemRarity.UNIQUE;

        item.drawOnGround(g, item.rarity.font, cX, cY);
    }

    public static void setTitle(String s) {
        app.setTitle(s);
    }

    public static void info(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void warning(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.WARNING_MESSAGE);
    }

    public static void error(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }
}
