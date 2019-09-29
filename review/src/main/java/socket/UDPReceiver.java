package socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceiver {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(8090);
        DatagramPacket datagramPacket = new DatagramPacket(new byte[1024],1024);
        datagramSocket.receive(datagramPacket);
        datagramSocket.close();

        System.out.println(datagramPacket.getAddress());
        System.out.println(new String(datagramPacket.getData(),0,datagramPacket.getLength()));

    }
}
