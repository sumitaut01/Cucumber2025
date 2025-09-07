package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static String readProperties(String key) {
        Properties properties=new Properties();
        try {
            properties.load(new FileInputStream(new File("Config/config.properties")));
        }
        catch (Exception e){
            System.out.println("Error while reading file  configuration file from path Config/config.properties");
            e.printStackTrace();
        }
        return (String) properties.get(key);
    }

    public static void main(String[] args) {
       String val= ConfigReader.readProperties("appurl");
        System.out.println(val);
    }
}
