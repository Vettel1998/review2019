package jvm;

import java.io.*;

public class MyTest14 extends ClassLoader {
    private String classLoaderName;
    private final String fileExt = ".class";
    private String path;

    public void setPath(String path) {
        this.path = path;
    }

    public MyTest14(ClassLoader parent, String classLoaderName) {
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    public MyTest14(String classLoaderName) {
        super();
        this.classLoaderName = classLoaderName;
    }


    public MyTest14(ClassLoader parent){
        super(parent);
    }
    @Override
    public String toString() {
        return "MyTest14{" +
                "classLoaderName='" + classLoaderName + '\'' +
                '}';
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("My findClass");
        byte[] data = loadClassData(name);
        return defineClass(name,data,0,data.length);
    }

    private byte[] loadClassData(String name){
        InputStream in = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;

        name = name.replace(".","\\");
        try {
                in  = new FileInputStream(new File(path+name+fileExt));
                baos = new ByteArrayOutputStream();
                int ch;
                while (-1 != (ch = in.read())){
                    baos.write(ch);
                }
                data = baos.toByteArray();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                baos.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return data;
    }

    public static void main(String[] args) throws Exception {
        MyTest14 loader1 = new MyTest14("VettelX classloader1");
        loader1.setPath("C:\\Users\\11056\\Desktop\\");
        Class<?> clazz = loader1.loadClass("jvm.MyTest13");
        System.out.println("clazz1:"+clazz.hashCode());
        Object obj = clazz.newInstance();
        System.out.println(obj);
        System.out.println(clazz.getClassLoader());

        /*MyTest14 loader2 = new MyTest14(loader1,"VettelX classloader2");
        loader2.setPath("C:\\Users\\11056\\Desktop\\");
        Class<?> clazz2 = loader2.loadClass("jvm.MyTest13");
        System.out.println("clazz2:"+clazz2.hashCode());
        Object obj2 = clazz.newInstance();
        System.out.println(obj2);
        System.out.println(clazz2.getClassLoader());*/



    }


}
