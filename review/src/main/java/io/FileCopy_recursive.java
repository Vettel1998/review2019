package io;

import java.io.*;

public class FileCopy_recursive {
    public static void main(String[] args) throws IOException {
        File  src= new File("/home/vettelx/src");
        File  dest = new File("/home/vettelx/dest");
        copyFolder(src,dest);

    }

    public static void copyFolder(File src,File dest) throws IOException {
        if (src.isDirectory()){
            File newFolder = new File(dest,src.getName());
            newFolder.mkdirs();
            for (File f:src.listFiles())
                copyFolder(f,newFolder);
        }
        else {
            File newFile  = new File(dest,src.getName());
            copyFile(src, newFile);
        }
    }

    public static void copyFile(File src,File dest)throws IOException {
        FileInputStream inputStream= new FileInputStream(src);
        FileOutputStream outputStream = new FileOutputStream(dest);
        byte[] buffer = new byte[1024];
        int len = -1;
        while ((len = inputStream.read(buffer))!=-1){
            outputStream.write(buffer,0,len);
        }
        inputStream.close();
        outputStream.close();
    }
}
