package properties;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.put("key","value");
        properties.setProperty("key","value1");
        properties.setProperty("key2","value1");
        System.out.println(properties);
        properties.store(new FileOutputStream("/home/vettelx/p.properties"),"....");
        properties.list(System.out);
    }
}
