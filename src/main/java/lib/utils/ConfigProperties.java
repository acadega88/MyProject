package lib.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class ConfigProperties {
    private static final Properties prop = new Properties();

    static {
        try {
            ClassLoader classLoader = ConfigProperties.class.getClassLoader();
            File file = new File(Objects.requireNonNull(classLoader.getResource("config.properties")).getFile());
            FileInputStream input = new FileInputStream(file);
            prop.load(input);
        } catch (IOException var1) {
            var1.printStackTrace();
        }
    }

    public static String getURLDev() {
        return prop.getProperty("urlDev");
    }

    public static String getURLQa() {
        return prop.getProperty("urlQa");
    }

    public static String getURLProd() {
        return prop.getProperty("urlProd");
    }

    public static String getEnv() {
        return prop.getProperty("env");
    }

    public static String getDevice() {
        return prop.getProperty("device");
    }

    public static String getBrowser() {
        return prop.getProperty("browser");
    }

    public static boolean getHeadless() {
        return prop.getProperty("headless").equals("true");
    }
}