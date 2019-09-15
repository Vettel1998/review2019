package jvm;

/*
*
*           双亲委托模型
*           尝试分别删除MySample.class 和  MyCat.class  运行结果不同
*           类加载器命名空间
*
*
* */
public class MyTest16 {
    public static void main(String[] args) throws Exception {
        MyTest14 myTest14 = new MyTest14("loader1");
        myTest14.setPath("C:\\Users\\11056\\Desktop\\");
        Class<?> clazz = myTest14.loadClass("jvm.MySample");
        System.out.println("clazz:"+clazz.hashCode());
        Object obj  = clazz.newInstance();

    }
}
