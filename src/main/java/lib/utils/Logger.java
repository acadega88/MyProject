package lib.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Logger {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    public Logger() {
    }

    public void debug(String message) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(sdf.format(timestamp) + ": [TEST] " + message);
    }

    public void info(String nameOfTest) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(sdf.format(timestamp) + ": [RUN TEST] " + nameOfTest);
    }

    public void error(String errorMsg) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(sdf.format(timestamp) + ": [ERROR] " + errorMsg);
    }
}
