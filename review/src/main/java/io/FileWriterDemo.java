package io;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("/home/vettelx/a.txt");
        fileWriter.write("Hello");
        fileWriter.flush();
        fileWriter.close();
        fileWriter = null;
    }
}
