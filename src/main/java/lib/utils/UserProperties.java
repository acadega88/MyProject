package lib.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class UserProperties {
    private static final Properties prop = new Properties();

    static {
        try {
            ClassLoader classLoader = ConfigProperties.class.getClassLoader();
            File file = new File(Objects.requireNonNull(classLoader.getResource("user.properties")).getFile());
            FileInputStream input = new FileInputStream(file);
            prop.load(input);
        } catch (IOException var1) {
            var1.printStackTrace();
        }
    }

    public static String getEmail() {
        return prop.getProperty("email");
    }

    public static String getPassword() {
        return prop.getProperty("password");
    }
}