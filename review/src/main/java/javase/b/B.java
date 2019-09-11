package javase.b;

import javase.a.A;

public class B extends A {

    public B() {

    }

    
    public static void m1(){
        System.out.println("B m1()");
    }


    public static void main(String[] args) {

       /* A a = new A();
        System.out.println(a.m);*/    //compile error
        A a =new B();
        a.m1();
    }
}
