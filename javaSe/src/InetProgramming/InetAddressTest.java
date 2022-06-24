package InetProgramming;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress inet1 = InetAddress.getByName("192.168.1.3");
        System.out.println(inet1);

        InetAddress inet2 = InetAddress.getByName("www.baidu.com");
        System.out.println(inet2);
        System.out.println(inet2.getHostName());
        System.out.println(inet2.getHostAddress());

        InetAddress inet3 = InetAddress.getByName("127.0.0.1");
        System.out.println(inet3);

        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);

    }
}
