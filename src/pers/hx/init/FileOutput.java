package pers.hx.init;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.ZonedDateTime;
import java.util.Timer;
import java.util.TimerTask;

public class FileOutput implements Output{
    int i = 0;
    ZonedDateTime time = null;
    String path = null;
    File file = null;

    public void output(String string) {
        ZonedDateTime cur = ZonedDateTime.now();

        if (time == null || time.plusHours(1).isBefore(cur)) {
            i++;
            time = cur;
            //当前目录
            path = getPath()+"\\log_" + i + ".txt";
            System.out.println(path);

            file = new File(path);
        }
        System.out.println(time);

        try {
            if (!(file.exists())) {
                if (file.createNewFile()) {
                    timeDelete(path);
                }else{
                    System.out.println("Create Error!");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //写入文件
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileWriter(file, true));
            writer.println(string);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void timeDelete(String path) {
        Timer timer = new Timer();
        int periodInMillis = 21600000; // 设置重复周期为6h

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                File fileToDelete = new File(path);
                if (fileToDelete.exists()) {
                    boolean isDeleted = fileToDelete.delete();

                    if (isDeleted) {
                        System.out.println("Delete successfully!");
                    } else {
                        System.err.println("Delete failed!");
                    }
                } else {
                    System.err.println("File not exists!");
                }
            }
        };

        // 定时删除
        timer.schedule(task, periodInMillis);
    }

    private String getPath() {
        String path = "";
        try {
            File directory = new File("");// 参数为空
            path = directory.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
}
