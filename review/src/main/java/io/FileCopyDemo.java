package io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyDemo {
    public static void main(String[] args) {
        String path1 = "/home/vettelx/FileWriterDemo2.java";
        String path2 = "/home/vettelx/a.txt";
        /*try (FileReader fileReader = new FileReader(path1); FileWriter fileWriter = new FileWriter(path2)){
            int c = 0;
               while ((c=fileReader.read())!=-1){
                   fileWriter.write((char)c);
               }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

       FileReader fileReader = null;
       FileWriter fileWriter = null;
       try {
            fileReader = new FileReader("/home/vettelx/a.java");
            fileWriter = new FileWriter("/home/vettelx/b.txt");
            char[] buffer = new char[1024];
            int len = -1;
            while ((len=fileReader.read(buffer))!=-1){
                fileWriter.write(buffer,0,len);
                fileWriter.flush();
            }
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }finally {
           if (fileReader!=null){
               try {
                   fileReader.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }finally {
                   fileReader = null;
               }
           }
           if (fileWriter!=null){
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
