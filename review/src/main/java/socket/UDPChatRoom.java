package socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UDPChatRoom {
    public static void main(String[] args) {
        new Thread(()->{
            Scanner scanner = new Scanner(System.in);
            DatagramSocket datagramSocket = null;
            try {
                datagramSocket = new DatagramSocket();
            } catch (SocketException e) {
                e.printStackTrace();
            }
            while (true){
                String s = scanner.nextLine();
                DatagramPacket datagramPacket = new DatagramPacket(s.getBytes(),0,s.getBytes().length,new InetSocketAddress("localhost",8090));
                try {
                    datagramSocket.send(datagramPacket);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        },"sender").start();
        new Thread(()->{
            DatagramSocket datagramSocket = null;
            try {
                datagramSocket = new DatagramSocket(8090);
            } catch (SocketException e) {
                e.printStackTrace();
            }
            while (true){
                DatagramPacket datagramPacket = new DatagramPacket(new byte[1024],1024);
                try {
                    datagramSocket.receive(datagramPacket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("receive message: "+new String(datagramPacket.getData(),0,datagramPacket.getLength())+"  from "+datagramPacket.getPort());
            }
        },"receiver").start();

    }
}
