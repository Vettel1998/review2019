package jvm;

public class MyTest7 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("java.lang.String");
        System.out.println(clazz.getClassLoader());
        Class<?> clazz1 = Class.forName("jvm.C");
        System.out.println(clazz1.getClassLoader());

    }
}

class C{

}
