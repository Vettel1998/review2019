package jvm;

import java.lang.reflect.Method;

public class MyTest20 {
    public static void main(String[] args) throws Exception {
        MyTest14 loader1 = new MyTest14("loader1");
        MyTest14 loader2 = new MyTest14("loader2");
        loader1.setPath("C:\\Users\\11056\\Desktop\\");
        loader2.setPath("C:\\Users\\11056\\Desktop\\");
        Class<?> class1 = loader1.loadClass("jvm.MyPerson");
        Class<?> class2 = loader2.loadClass("jvm.MyPerson");

        System.out.println(class1 == class2);   //  true    都委托给同一个应用类加载器

        Object object1 = class1.newInstance();
        Object object2 = class2.newInstance();

        Method method = class1.getMethod("setMyPerson",Object.class);
        method.invoke(object1,object2);

        //Caused by: java.lang.ClassCastException: jvm.MyPerson cannot be cast to jvm.MyPerson
    }
}
