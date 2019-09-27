package io;

import java.io.*;

public class InputStreamReaderDemo {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("/home/vettelx/b.txt"));
        char[] buffer = new char[4];
        int len = -1;
        while ((len = isr.read(buffer))!=-1){
            System.out.print(new String(buffer,0,len));
        }
        isr.close();
    }
}
