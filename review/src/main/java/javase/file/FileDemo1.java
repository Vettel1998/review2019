package javase.file;

import java.io.File;
import java.io.IOException;

public class FileDemo1 {
    public static void main(String[] args) throws IOException {
        File file = new File("/home/vettelx/a.txt");
        file.createNewFile();
    }
}
