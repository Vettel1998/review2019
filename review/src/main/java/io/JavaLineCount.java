package io;

import java.io.*;

public class JavaLineCount {
    private static int count = 0;
    public static void main(String[] args) {
        String filePath = "/home/vettelx/src";
        File file = new File(filePath);
        countLine(file);
        System.out.println(count);

    }
    public static void countLine(File file){
        if (file.isDirectory()){
            File[] files = file.listFiles();
            for (File file1 : files)
                countLine(file1);
        }else if (file.getName().endsWith(".java")){
            System.out.println(file.getAbsolutePath());
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
                String str = null;
                while ((str=bufferedReader.readLine())!=null)
                    count++;

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
