
import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.zip.GZIPInputStream;


public class Client {

    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket();
            System.out.println("client 연결 요청");
            socket.connect(new InetSocketAddress("localhost", 5432));
            System.out.println("client 연결 성공");
            OutputStream out = socket.getOutputStream();

            String fileName = "./src/test.txt";
            System.out.println(fileName + "전송!");
            //File file = new File("./" + "test.txt");

            FileInputStream fis = new FileInputStream(fileName);
            BufferedInputStream bis = new BufferedInputStream(new GZIPInputStream(fis));

            //FileOutputStream fos = new FileOutputStream(d);
            DataOutputStream dos = new DataOutputStream(out);
            BufferedOutputStream bos = new BufferedOutputStream(dos);

            //DataInputStream dis = new DataOutputStream("test.gz");
            byte[] buffer = new byte[10];

            while (true) {
                int data = bis.read(buffer);
                if (data == -1) {
                    break;
                }

                bos.write(buffer, 0, data);
            }
            for (byte b : buffer) {
                System.out.print(b + " ");
            }
            System.out.println("\n데이터 보내기 성공");

            bos.flush();
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
