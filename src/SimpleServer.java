import java.io.*;
import java.net.*;
import java.util.zip.GZIPOutputStream;

class Server extends Thread {
    @Override
    public void run() {

        ServerSocket s = null;
        try {
            s = new ServerSocket(0);         // Register your service on port 5432
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try {

                String logFileName = "serverPortLog.txt";
                int localPortNumber = s.getLocalPort();
                File logFile = new File(logFileName);
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(logFile, true));

                bufferedWriter.write(Integer.toString(localPortNumber));
                bufferedWriter.flush();
                bufferedWriter.close();
                System.out.println("Server Port Number : " + localPortNumber);
                System.out.println("server 연결 기다림");
                Socket socket = s.accept();     // Wait here and listen for a connection
                System.out.println("연결 된 client 주소 : " + socket.getInetAddress());
                InputStream in = socket.getInputStream();
                DataInputStream dis = new DataInputStream(in);
                BufferedInputStream bis = new BufferedInputStream(dis);

                //OutputStream out = socket.getOutputStream();
                //DataOutput dos = new DataOutputStream(out);

                FileOutputStream fos = new FileOutputStream("test.txt");
                BufferedOutputStream bos = new BufferedOutputStream(new GZIPOutputStream(fos));

                byte[] buffer = new byte[10];
                while (true) {
                    int data = bis.read(buffer);
                    if (data == -1)
                        break;
                    bos.write(buffer);
                }

                bos.flush();
                bis.close();

                for (byte b : buffer) {
                    System.out.print(b + " ");
                }
                System.out.println("\ndata 받기 성공");
                dis.close();

                in.close();
                socket.close();
                fos.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}


public class SimpleServer {
    public static void main(String args[]) {
        Server server = new Server();
        server.run();
    }
}