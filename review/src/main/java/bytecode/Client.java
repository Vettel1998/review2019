package bytecode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        InvocationHandler ds =  new DynamicSubject(realSubject);
        Class<?> clazz = realSubject.getClass();
        Subject subject = (Subject) Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),ds);
        subject.request();
        System.out.println(subject.getClass());
        System.out.println(subject.getClass().getSuperclass());
    }
}
