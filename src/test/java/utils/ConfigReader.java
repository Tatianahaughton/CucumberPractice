package utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    static Properties prop;

    public static Properties readProperties(String filePath) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            prop = new Properties();
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
    public static String getPropValue(String key) {
        //getProperty is a method that reads the value per key provided
        return prop.getProperty(key);
    }
}
