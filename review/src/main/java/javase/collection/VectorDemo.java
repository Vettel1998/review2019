package javase.collection;

import java.util.Vector;

public class VectorDemo {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        for (int i = 0; i <21 ; i++) {
            vector.add("a");
        }
        System.out.println(vector.capacity());
    }
}
