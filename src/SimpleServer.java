import java.io.*;
import java.net.*;

class Server extends Thread {

    public void run() {

        ServerSocket s = null;
        try {
            s = new ServerSocket(0);         // Register your service on port 5432
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Thread thread =
        while (true) {
            try {
                Socket s1 = s.accept();     // Wait here and listen for a connection
                OutputStream s1out = s1.getOutputStream();     // Get output stream associated with the socket
                DataOutputStream dout = new DataOutputStream(s1out);
                dout.writeUTF("Hello Net World!\n");     // Send your string!
                dout.close();     // Close the connection, but not the server socket
                s1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


public class SimpleServer {
    public static void main(String args[]) {

    }
}