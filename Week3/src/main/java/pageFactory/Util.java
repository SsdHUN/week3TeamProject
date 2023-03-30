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
            VALID_USERNAME = System.getProperty("username");
        } else {
            VALID_USERNAME = readProperty("username");
        }
    }
    public static String VALID_PASSWORD;

    static {
        if (Boolean.parseBoolean(System.getProperty("isRemote"))) {
            VALID_PASSWORD = System.getProperty("password");
        } else {
            VALID_PASSWORD = readProperty("password");
        }
    }
    public static String baseURL;

    static {
        if (Boolean.parseBoolean(System.getProperty("isRemote"))) {
            baseURL = System.getProperty("baseURL");
        } else {
            baseURL = readProperty("baseURL");
        }
    }

}