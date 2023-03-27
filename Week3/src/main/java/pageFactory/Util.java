package pageFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class Util {
    public static final String CONFIG_PATH = "src/main/resources/init.properties";

    public static Properties readConfig() {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(CONFIG_PATH));
            return properties;
        } catch (IOException e) {
            System.out.println("Can't read config file");
        }
        return null;
    }

    public static String readProperty(String value) {
        return Objects.requireNonNull(readConfig()).getProperty(value);
    }

    public static String VALID_USERNAME = readProperty("username");
    public static String VALID_PASSWORD = readProperty("password");
    public static String GRID_PASSWORD = readProperty("gridPassword");
    public static String loginURL = readProperty("loginURL");
}