package jvm;

import java.util.Random;

public class MyTest5 {
    public static void main(String[] args) {
        System.out.println(MyChild5.b);
    }
}


interface MyParent5{
    int a = new Random().nextInt();
    Inner in = new Inner("MyParent5");
}

interface MyChild5 extends MyParent5{
    int b = new Random().nextInt();
    Inner in = new Inner("MyChild5");
}


class Inner{
    public Inner(String s) {
        System.out.println(s+" invoke");
    }

}