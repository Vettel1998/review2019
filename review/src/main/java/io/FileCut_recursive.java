package io;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FileCut_recursive {

    public static void main(String[] args) {
        /*File file = new File("/home/vettelx/src");
        File newFile = new File("/home/vettelx/test1");
        renameFile(file,newFile);*/
//        AtomicInteger i = new AtomicInteger();
//        new Thread(()->{
//            i.incrementAndGet();
//        },"Thread1").start();
//
//        new Thread(()->{
//            i.decrementAndGet();
//        },"Thread2").start();
//
//        new Thread(()->{
//            i.incrementAndGet();
//        },"Thread3").start();
//
//        new Thread(()->{
//            i.decrementAndGet();
//        },"Thread4").start();

        float f = 0;
        float f1 =-10;


        //根据字典序排序
        List<String> strings = Arrays.asList("apple","grape","banana","pear","abb");
        for (int i = 0; i <strings.size()-1 ; i++) {
            for (int j = 0; j <strings.size()-i-1 ; j++) {
                if (strings.get(j).compareTo(strings.get(j+1))>0){
                    String tmp = strings.get(j);
                    strings.set(j,strings.get(j+1));
                    strings.set(j,tmp);
                }
            }
        }
        System.out.println(strings.get(strings.size()-1));
        System.out.println(strings.get(0));
        System.out.println(strings);

        long l = 9999999999L;
        int xxx = 0b1111;
        System.out.println(xxx);
        float f222=-12;
        long ssss = 10;
    }


  /*  public static void renameFile(File src,File dest){
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
    }*/
}
