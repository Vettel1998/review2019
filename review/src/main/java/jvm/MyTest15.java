package jvm;

public class MyTest15 {
    public static void main(String[] args) throws Exception {
        MyTest14 myTest14 = new MyTest14("loader1");
        Class<?> clazz = myTest14.loadClass("jvm.MySample");
        System.out.println("clazz:"+clazz.hashCode());
//        Object obj  = clazz.newInstance();

    }
}
