/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domaine;

/**
 *
 * @author Hachem
 */
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class NewClass {
    // Sends ping request to a provided IP address

    public static boolean sendPingRequest(String ipAddress) {
        try {
            InetAddress geek = null;
            geek = InetAddress.getByName(ipAddress);
            System.out.println("Sending Ping Request to " + ipAddress);
            if (geek.isReachable(5000)) {
                System.out.println("getHostAddress"+geek.getHostAddress());
                System.out.println("getCanonicalHostName"+geek.getCanonicalHostName());
                System.out.println("toString"+geek.toString());
                System.out.println("getHostName"+geek.getHostName());
                return true;
            } else {
                System.out.println("Sorry ! We can't reach to this host");
                return false;
            }
        } catch (UnknownHostException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         return false;
    }

    // Driver code
    public static void main(String[] args)
            throws UnknownHostException, IOException {
        String ipAddress = "51.68.47.58";
        sendPingRequest(ipAddress);

    }
}
