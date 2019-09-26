package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        String path1 = "/home/vettelx/a.java";
        String path2 = "/home/vettelx/b.txt";
        try(FileInputStream fin = new FileInputStream(path1);FileOutputStream fout = new FileOutputStream(path2,true)) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fin.read(buffer))!=-1){
                fout.write(buffer,0,len);
                fout.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
