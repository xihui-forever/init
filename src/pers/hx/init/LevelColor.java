package pers.hx.init;

import java.util.EnumMap;

enum Level{
    FATAL, ERROR, WARN, INFO, DEBUG;
}


public class LevelColor {
    static EnumMap<Level, String> map = new EnumMap<>(Level.class);
    public static void init() {
        // RED("\u001B[31m"), YELLOW("\u001B[33m"), GREEN("\u001B[32m"), BLACK("\u001B[30m"), RESET("\u001B[0m");
        map.put(Level.FATAL,"\u001B[31m");
        map.put(Level.ERROR,"\u001B[31m");
        map.put(Level.WARN,"\u001B[33m");
        map.put(Level.INFO,"\u001B[32m");
        map.put(Level.DEBUG,"\u001B[30m");
    }


}