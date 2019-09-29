package socket;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("localhost",9002));
        FileInputStream fis = new FileInputStream("/home/vettelx/a.java");
        OutputStream outputStream = socket.getOutputStream();
        byte[] buffer = new byte[1024];
        int len = -1;
        while ((len = fis.read(buffer))!=-1){
            outputStream.write(buffer,0,len);
        }
        socket.shutdownOutput();
        socket.close();
        fis.close();
    }
}
