package pageFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Properties;

public class Util {
    public static final String CONFIG_PATH = "src/main/resources/init.properties";

    public static Properties readConfig() {
        try {
            Properties properties = new Properties();
            properties.load(Files.newInputStream(Paths.get(CONFIG_PATH)));
            return properties;
        } catch (IOException e) {
            System.out.println("Can't read config file");
        }
        return null;
    }

    public static String readProperty(String value) {
        return Objects.requireNonNull(readConfig()).getProperty(value);
    }
    public static String VALID_USERNAME;

    static {
        if (Boolean.parseBoolean(System.getProperty("isRemote"))) {
            VALID_USERNAME = readProperty("username");
        } else {
            VALID_USERNAME = System.getProperty("username");
        }
    }
    public static String VALID_PASSWORD;

    static {
        if (Boolean.parseBoolean(System.getProperty("isRemote"))) {
            VALID_PASSWORD = readProperty("password");
        } else {
            VALID_PASSWORD = System.getProperty("password");
        }
    }
    public static String GRID_PASSWORD;

    static {
        if (Boolean.parseBoolean(System.getProperty("isRemote"))) {
            GRID_PASSWORD = readProperty("gridPassword");
        } else {
            GRID_PASSWORD = System.getProperty("gridPassword");
        }
    }


    public static String GRID_URL;

    static {
        if (Boolean.parseBoolean(System.getProperty("isRemote"))) {
            GRID_URL = readProperty("gridURL");
        } else {
            GRID_URL = System.getProperty("gridURL");
        }
    }

}