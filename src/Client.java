
import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

class readData extends Thread {

    @Override
    public void run() {

    }
}

class sendData extends Thread {
    @Override
    public void run() {

    }

}


public class Client {

    Queue<Thread> queue = new LinkedList<>();


    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket();
            System.out.println("client 연결 요청");
            socket.connect(new InetSocketAddress("localhost", 5432));
            System.out.println("client 연결 성공");
            OutputStream out = socket.getOutputStream();

            String fileName = "./src/test.gz";
            System.out.println(fileName + "전송!");
            //File file = new File("./" + "test.txt");

            FileInputStream fis = new FileInputStream(fileName);
            BufferedInputStream bis = new BufferedInputStream(new GZIPInputStream(fis));

            DataOutputStream dos = new DataOutputStream(out);
            BufferedOutputStream bos = new BufferedOutputStream(new GZIPOutputStream(dos));

            //DataInputStream dis = new DataOutputStream("test.gz");
            byte[] buffer = new byte[622];

            while (true) {
                int data = bis.read(buffer);
                if (data == -1) {
                    break;
                }
                bos.write(buffer, 0, data);
                bos.flush();
            }


            int cnt = 0;
            for (byte b : buffer) {
                cnt++;
                System.out.print(b + " ");
                if (cnt % 100 == 0) {
                    System.out.println();
                }
            }
            System.out.println("\n데이터 보내기 성공");


            bos.close();
            fis.close();
            out.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!socket.isClosed()) {
            try {
                socket.close();
            } catch (IOException e) {

            }
        }
    }
}
