package jvm;

import sun.misc.Launcher;

public class MyTest22 {
    public static void main(String[] args) {

        // 通过java命令
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));

        //java -Dsun.boot.class.path=./ jvm.MyTest22
        /*
        *   Error occurred during initialization of VM
        *   java/lang/NoClassDefFoundError: java/lang/Object
        *
        * */
        System.out.println(ClassLoader.class.getClassLoader());
        System.out.println(Launcher.class.getClassLoader());
        System.out.println("-----------------------");

    }
}
