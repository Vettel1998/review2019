package io;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo2 {
    public static void main(String[] args) {
        FileWriter fileWriter = null;
        try {
           fileWriter = new FileWriter("/home/vettelx/b.txt");
           fileWriter.write("Hello,world");
           fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null!=fileWriter){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    fileWriter = null;
                }
            }
        }
    }
}
