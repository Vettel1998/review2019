package jvm;

import com.sun.crypto.provider.AESKeyGenerator;


/*
*
*       修改扩展类加载器的路径
*       java -Djava.ext.dirs=./
*
*
* */
public class MyTest18 {
    public static void main(String[] args) {
        AESKeyGenerator aesKeyGenerator = new AESKeyGenerator();
        System.out.println(aesKeyGenerator.getClass().getClassLoader());
        System.out.println(MyTest18.class.getClassLoader());
    }
}
