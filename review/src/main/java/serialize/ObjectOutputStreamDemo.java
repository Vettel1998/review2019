package serialize;

import java.io.*;

public class ObjectOutputStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*Person person = new Person();
        person.setA(10);
        person.setName("vettelx");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/home/vettelx/person.data"));
        oos.writeObject(person);
        oos.close();*/

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/home/vettelx/person.data"));
        Person person1 = (Person) ois.readObject();
        System.out.println(person1);
    }
}
