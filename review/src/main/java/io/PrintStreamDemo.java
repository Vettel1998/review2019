package io;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class PrintStreamDemo {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream printStream = new PrintStream("/home/vettelx/test.txt");
        printStream.println("abc");
        printStream.close();
    }
}
