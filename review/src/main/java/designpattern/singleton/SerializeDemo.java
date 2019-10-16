package designpattern.singleton;

import java.io.*;

public class SerializeDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src\\main\\resources\\tempFile"));
        oos.writeObject(Singleton.getInstance());
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src\\main\\resources\\tempFile"));
        Singleton singleton = (Singleton) ois.readObject();
        System.out.println(singleton == Singleton.getInstance());
    }
}