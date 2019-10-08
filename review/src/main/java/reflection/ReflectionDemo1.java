package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionDemo1 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<String> stringClass = String.class;
        Method method = stringClass.getDeclaredMethod("charAt", int.class);
        char c = (char) method.invoke("abcd",1);
        System.out.println(c);

        Class<?>[] interfaces = stringClass.getInterfaces();
    }
}
