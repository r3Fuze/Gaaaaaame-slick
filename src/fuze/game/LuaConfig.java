package fuze.game;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaError;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.JsePlatform;

import fuze.game.lua.LuaHelper;

public class LuaConfig {

    private String  path    = "";
    private Globals globals = null;

    public LuaConfig(String path) {
        this.path = path;
        this.globals = JsePlatform.standardGlobals();
        LuaHelper.addFunctions(globals);

        try {
            globals.get("dofile").call(LuaValue.valueOf(path));
            System.out.println("Lua loaded");
        } catch (Exception e) {
            System.err.println("Something is wrong with your lua file!");
            System.err.println("Error: " + e.getLocalizedMessage());

            String msg = "Something is wrong with your lua file!\n" + "Error: " + e.getMessage();

            Game.error("Lua error!", msg);

            Game.app.exit();
        }
    }

    public void reload() {
        globals.get("dofile").call(LuaValue.valueOf(path));
    }

    public Globals getGlobals() {
        return globals;
    }

    public LuaValue call(String function) {
        try {
            return globals.get(function).call();
        } catch (LuaError e) {}
        return null;
    }

    public LuaValue call(String function, LuaValue arg1) {
        try {
            return globals.get(function).call(arg1);
        } catch (LuaError e) {}
        return null;
    }

    public LuaValue call(String function, LuaValue arg1, LuaValue arg2) {
        try {
            return globals.get(function).call(arg1, arg2);
        } catch (LuaError e) {}
        return null;
    }

    public LuaValue call(String function, LuaValue arg1, LuaValue arg2, LuaValue arg3) {
        try {
            return globals.get(function).call(arg1, arg2, arg3);
        } catch (LuaError e) {}
        return null;
    }

    public String getString(String key, String def) {
        LuaValue res = globals.get(key);
        if (res.tojstring().equals("nil")) {
            res = LuaValue.valueOf(def);
        }
        return res.tojstring();
    }

    public LuaValue get(String key, String def) {
        LuaValue res = globals.get(key);
        if (res.tojstring().equals("nil")) {
            res = LuaValue.valueOf(def);
        }
        return res;
    }

    public LuaValue get(String key, int def) {
        LuaValue res = globals.get(key);
        if (res.tojstring().equals("nil")) {
            res = LuaValue.valueOf(def);
        }
        return res;
    }

    public LuaValue get(String key, float def) {
        LuaValue res = globals.get(key);
        if (res.tojstring().equals("nil")) {
            res = LuaValue.valueOf(def);
        }
        return res;
    }

    public LuaValue get(String key, boolean def) {
        LuaValue res = globals.get(key);
        if (res.tojstring().equals("nil")) {
            res = LuaValue.valueOf(def);
        }
        return res;
    }

    public int getInt(String key, int def) {
        LuaValue res = globals.get(key);
        if (res.tojstring().equals("nil")) {
            res = LuaValue.valueOf(def);
        }
        return res.toint();
    }

    public float getFloat(String key, float def) {
        LuaValue res = globals.get(key);
        if (res.tojstring().equals("nil")) {
            res = LuaValue.valueOf(def);
        }
        return res.tofloat();
    }

    public LuaValue get(String key) {
        return globals.get(key);
    }

}
