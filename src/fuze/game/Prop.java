package fuze.game;

import java.util.HashMap;

import org.luaj.vm2.LuaValue;

public class Prop {

	private static HashMap<String, LuaValue>	props	= new HashMap<>();

	public static void init(LuaConfig cfg) {
		props.put("item_tooltipOpacity", cfg.get("item_tooltipOpacity", 0.65f));
	}

	public static LuaValue get(String key, String def) {
		LuaValue res = props.get(key);
		if (res.tojstring().equals("nil")) {
			res = LuaValue.valueOf(def);
		}
		return res;
	}

	public static LuaValue get(String key, int def) {
		LuaValue res = props.get(key);
		if (res.tojstring().equals("nil")) {
			res = LuaValue.valueOf(def);
		}
		return res;
	}

	public static LuaValue get(String key, float def) {
		LuaValue res = props.get(key);
		if (res.tojstring().equals("nil")) {
			res = LuaValue.valueOf(def);
		}
		return res;
	}

	public static LuaValue get(String key, boolean def) {
		LuaValue res = props.get(key);
		if (res.tojstring().equals("nil")) {
			res = LuaValue.valueOf(def);
		}
		return res;
	}

	public static String getString(String key, String def) {
		LuaValue res = props.get(key);
		if (res.tojstring().equals("nil")) {
			res = LuaValue.valueOf(def);
		}
		return res.tojstring();
	}

	public static int getInt(String key, int def) {
		LuaValue res = props.get(key);
		if (res.tojstring().equals("nil")) {
			res = LuaValue.valueOf(def);
		}
		return res.toint();
	}

	public static float getFloat(String key, float def) {
		LuaValue res = props.get(key);
		if (res.tojstring().equals("nil")) {
			res = LuaValue.valueOf(def);
		}
		return res.tofloat();
	}

}
