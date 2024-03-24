package pers.hx.init;

public class Config {
    public ConsoleOutput consoleOutput;
    public FileOutput fileOutput;

    public Config() {
        LevelColor.init();
        this.consoleOutput = new ConsoleOutput();
        this.fileOutput = new FileOutput();
    }

    public String messageToString(Message msg) {
        return msg.time + LevelColor.map.get(msg.level) +" [" + msg.level + "] " + "\u001B[0m" + msg.content + " " + msg.path;
    }

}
