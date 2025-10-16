package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final Properties properties;

    static {
        properties=new Properties();
        try(FileInputStream fis=new FileInputStream("config.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String getProperty(String key){
       return properties.getProperty(key);
    }
}
