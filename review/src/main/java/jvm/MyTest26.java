package jvm;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

/*
*       线程上下文类加载器的一般使用模式（获取-使用-还原）
*
*
*
* */
public class MyTest26 {

    public static void main(String[] args) {
        Thread.currentThread().setContextClassLoader(MyTest26.class.getClassLoader().getParent());
        ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = loader.iterator();
        while(iterator.hasNext()){
            Driver driver = iterator.next();
            System.out.println("driver:"+driver.getClass()+",classloader:"+driver.getClass().getClassLoader());
        }
    }
}
