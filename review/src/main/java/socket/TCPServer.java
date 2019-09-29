package socket;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9002);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream("/home/vettelx/file.txt");
        byte[] buffer = new byte[1024];
        int len = -1;
        while ((len = inputStream.read(buffer))!=-1){
            fileOutputStream.write(buffer,0,len);
        }
        socket.shutdownInput();
        socket.close();
        serverSocket.close();
        fileOutputStream.close();

    }
}
