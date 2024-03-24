package pers.hx.init;



public class Log {
    Config cf = new Config();


    public void fatal(String s) {
        this.log(Level.FATAL, s, false);
    }
    public void error(String s) {
        this.log(Level.ERROR, s, false);
    }
    public void warn(String s) {
        this.log(Level.WARN, s, false);
    }
    public void info(String s) {
        this.log(Level.INFO, s, false);
    }
    public void debug(String s) {
        this.log(Level.DEBUG, s, false);
    }

    public void fatalToFile(String s) {
        this.log(Level.FATAL, s, true);
    }
    public void errorToFile(String s) {
        this.log(Level.ERROR, s, true);
    }
    public void warnToFile(String s) {
        this.log(Level.WARN, s, true);
    }
    public void infoToFile(String s) {
        this.log(Level.INFO, s, true);
    }
    public void debugToFile(String s) {
        this.log(Level.DEBUG, s, true);
    }


    private void log(Level level, String content, Boolean IsOutFile) {
        Message msg = new Message(level, content);
        cf.consoleOutput.output(cf.messageToString(msg));
        if (IsOutFile == true ) {
            cf.fileOutput.output(cf.messageToString(msg));
        }
    }
}
