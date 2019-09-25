package io;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("/home/vettelx/1.doc");
        fos.write("hello".getBytes());
    }
}
