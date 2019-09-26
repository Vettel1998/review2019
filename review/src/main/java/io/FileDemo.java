package io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("/home/vettelx/src");
        File[] files = file.listFiles((f,name)->name.endsWith(".java"));
    }
}
