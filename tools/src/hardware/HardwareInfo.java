package hardware;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class HardwareInfo {

    public static void main(String[] args) {
        System.out.println("Current IP address: " + HardwareInfo.getIP());
        System.out.println("Current MAC address: " + HardwareInfo.getMAC());
        System.out.println("Current Host Name: " + HardwareInfo.getHostName());
        System.out.println("All IPs address: \n" + HardwareInfo.getAllIPs());
    }

    public static String getMAC() { // get MAC address
        try {
            InetAddress ip = InetAddress.getLocalHost();
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);

            byte[] mac = network.getHardwareAddress();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            return sb.toString();

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String getHostName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException ue) {
            ue.printStackTrace();
            return null;
        }
    }

    public static String getIP() { // get IP address
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getAllIPs() {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

            StringBuilder ipAddress = new StringBuilder();
            while (interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = interfaces.nextElement();
                // drop inactive
                if (!networkInterface.isUp())
                    continue;

                // smth we can explore
                Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress addr = addresses.nextElement();
                    ipAddress.append(String.format("NetInterface: name [%s], ip [%s]",
                            networkInterface.getDisplayName(), addr.getHostAddress()));
                    ipAddress.append("\n");
                }
            }

            return ipAddress.toString();
        } catch (SocketException e) {
            e.printStackTrace();
            return null;
        }
    }
}
