package CollectionsAndMap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("D:\\idea\\DataStructures\\javaSe\\src\\CollectionsAndMap\\jdbc.properties");
        properties.load(fileInputStream);
        String name = properties.getProperty("name");
        String age = properties.getProperty("age");
        System.out.println(name+"   "+age);
    }
}
