package fuze.game.lua;

import java.lang.reflect.Field;

import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;
import org.luaj.vm2.lib.TwoArgFunction;
import org.luaj.vm2.lib.ZeroArgFunction;
import org.newdawn.slick.Input;

import fuze.game.Game;

public class LuaGameAPI extends OneArgFunction {

    public LuaValue call(LuaValue env) {
        String apiName = "Game";
        LuaTable api = new LuaTable();

        // functions
        api.set("exit", new LuaFuncExit());

        api.set("info", new LuaFuncInfo());
        api.set("warning", new LuaFuncWarning());
        api.set("error", new LuaFuncError());

        // variables
        api.set("name", Game.NAME);
        api.set("version", Game.VERSION);
        api.set("input", getInput());

        { // sound
            LuaTable sound = new LuaTable();
            sound.set("muteSound", new LuaFuncMuteSound());
            api.set("sound", sound);
        }

        env.set(apiName, api);
        env.get("package").get("loaded").set(apiName, api);
        return api;
    }

    private LuaTable getInput() {
        LuaTable input = new LuaTable();

        // Get all fields in the Input class
        Field[] fields = Input.class.getFields();
        for (Field f : fields) {
            try {
                String fieldName = f.getName();
                int fieldVal = (int) f.get(Input.class);

                // Add add the field to a Lua table if it's one of the needed fields
                if (fieldName.startsWith("KEY_") || fieldName.startsWith("MOUSE_")) {
                    input.set(fieldName, fieldVal);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return input;
    }

    public static class LuaFuncExit extends ZeroArgFunction {
        public LuaValue call() {
            Game.app.exit();
            return NIL;
        }
    }

    public static class LuaFuncMuteSound extends ZeroArgFunction {
        public LuaValue call() {
            // Game.app.setSoundOn(false);
            Game.app.setSoundVolume(0);
            // Game.app.setMusicOn(false);
            Game.app.setMusicVolume(0);
            System.out.println("Muted sound");
            return NIL;
        }
    }

    /* Messages -f */
    public static class LuaFuncInfo extends TwoArgFunction {
        public LuaValue call(LuaValue arg1, LuaValue arg2) { Game.info(arg1.tojstring(), arg2.tojstring()); return NIL; }
    }

    public static class LuaFuncWarning extends TwoArgFunction {
        public LuaValue call(LuaValue arg1, LuaValue arg2) { Game.warning(arg1.tojstring(), arg2.tojstring()); return NIL; }
    }

    public static class LuaFuncError extends TwoArgFunction {
        public LuaValue call(LuaValue arg1, LuaValue arg2) { Game.error(arg1.tojstring(), arg2.tojstring()); return NIL; }
    }

    // +f

}
