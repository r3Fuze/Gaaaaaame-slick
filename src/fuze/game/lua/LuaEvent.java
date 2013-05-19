package fuze.game.lua;

import java.util.HashMap;

import org.luaj.vm2.LuaValue;

import fuze.game.LuaConfig;

public enum LuaEvent {

    KEY_PRESSED("keyPressed"), MOUSE_PRESSED("mousePressed");

    public String eventName;

    private LuaEvent(String eventName) {
        this.eventName = eventName;
    }

    private static HashMap<LuaEvent, Boolean> events = new HashMap<>();

    public static void init() {
        for (LuaEvent e : LuaEvent.values()) {
            events.put(e, false);
        }
    }

    public static void registerEvent(LuaEvent event) {
        events.put(event, true);
    }

    public void unregisterEvent(LuaEvent event) {
        events.put(event, false);
    }

    public static void callEvent(LuaConfig cfg, LuaEvent event, LuaValue arg1) {
        if (events.get(event)) {
            cfg.call(event.eventName, arg1);
        }
    }

    public static void callEvent(LuaConfig cfg, LuaEvent event, LuaValue arg1, LuaValue arg2) {
        if (events.get(event)) {
            cfg.call(event.eventName, arg1, arg2);
        }
    }

    public static void callEvent(LuaConfig cfg, LuaEvent event, LuaValue arg1, LuaValue arg2, LuaValue arg3) {
        if (events.get(event)) {
            cfg.call(event.eventName, arg1, arg2, arg3);
        }
    }

}
