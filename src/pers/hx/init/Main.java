package pers.hx.init;

public class Main {
    static Log log = new Log();

    public static void main(String[] args) {
        log.info("aaa");
        log.error("bbb");

        //文件输出
        log.infoToFile("abc");
    }

}
