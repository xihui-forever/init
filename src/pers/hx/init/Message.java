package pers.hx.init;

import java.time.ZonedDateTime;
import java.util.EnumMap;
import java.util.Map;

public class Message {
    public String content;
    public Level level;
    public ZonedDateTime time;
    public String path;

    StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
    String loc = "[" + stackTrace[stackTrace.length -1 ].toString() + "]";
    public Message(Level level, String content) {
        this.content = content;
        this.level = level;
        this.time = ZonedDateTime.now();
        this.path = loc;
    }
}
