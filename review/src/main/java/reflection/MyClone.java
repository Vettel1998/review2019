package reflection;

import lombok.Data;
import lombok.ToString;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MyClone {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException {
        TestObject object = new TestObject("Test",1);
        TestObject object1 = (TestObject) clone(object);
        System.out.println(object1);
    }


    public static Object clone(Object obj) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        //获取字节码对象
        Class<Object> clz = (Class<Object>) obj.getClass();
        //生成实例对象
        Constructor<?> constructor = clz.getConstructors()[0];
        Class[] classes = constructor.getParameterTypes();
        Object[] os = new Object[classes.length];
        for (int i = 0; i <classes.length; i++) {
            Class c = classes[i];
            if (c.isPrimitive()){
                if (c == boolean.class)
                    os[i] = false;
                else if (c==char.class)
                    os[i] = '\u0000';
                else
                    os[i] = 0;
            }else
                os[i] = null;
        }
        Object object = constructor.newInstance(os);

        //获取原对象所有的属性
        Field[] fields = clz.getDeclaredFields();
        //把原对象的属性赋值给实例对象
        for (Field f :fields){
            f.setAccessible(true);
            Object value = f.get(obj);
            f.set(object,value);
        }
        return object;
    }
}

@Data
@ToString
class TestObject{
    private String name;
    private int age;

    public TestObject(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
