package io;

import java.io.*;
import java.nio.charset.Charset;

public class InputStreamReaderDemo {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/home/vettelx/a.txt"),"UTF-8"));

    }
}
