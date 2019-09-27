package io;

import java.io.File;

public class FileCut_recursive {

    public static void main(String[] args) {
        File file = new File("/home/vettelx/src");
        File newFile = new File("/home/vettelx/test1");
        renameFile(file,newFile);
    }


    public static void renameFile(File src,File dest){
        if (!dest.exists()){
            dest.mkdirs();
        }
        if (src.isDirectory()){
            File newFolder = new File(dest,src.getName());
            newFolder.mkdirs();
            for(File f:src.listFiles()){
                renameFile(f,newFolder);
            }

        }else {
            src.renameTo(new File(dest,src.getName()));
        }
    }
}
