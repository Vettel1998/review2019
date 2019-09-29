package socket;

import java.io.IOException;
import java.net.*;

public class UDPSender {
    public static void main(String[] args) throws IOException {
        String s = "Hello world";
        DatagramSocket datagramSocket = new DatagramSocket();
        DatagramPacket datagramPacket = new DatagramPacket(s.getBytes(),0,s.getBytes().length,new InetSocketAddress("127.0.0.1",8090));
        datagramSocket.send(datagramPacket);
        datagramSocket.close();
    }
}
