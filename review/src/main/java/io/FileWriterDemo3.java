package io;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo3 {
    public static void main(String[] args) {
        try(FileWriter fileWriter = new FileWriter("/home/vettelx/b.txt")){
            fileWriter.write("Hello,world");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
