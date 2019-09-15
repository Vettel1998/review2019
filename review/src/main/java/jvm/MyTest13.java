package jvm;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.Enumeration;

public class MyTest13 {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader =Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader);
        String s = "jvm/MyTest12.class";
        URL resource = classLoader.getResource(s);
        System.out.println(resource);

    }
}
