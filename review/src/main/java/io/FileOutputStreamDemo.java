package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("/home/vettelx/b.txt",true);
        fileOutputStream.write("你好".getBytes());
        fileOutputStream.flush();
        fileOutputStream.close();
        fileOutputStream = null;
    }
}
