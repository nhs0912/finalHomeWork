import java.io.*;
import java.util.Random;
import java.util.zip.GZIPOutputStream;

public class HomeWork {

    Human[] humans;
    Random random = new Random();
    BufferedReader in;
    private static final int BSIZE = 16 * 1024;


    String makeName() {
        //random name 생성
        char[] names = new char[100];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < names.length; i++) {
            int num = 97 + random.nextInt(26);
            names[i] = (char) num;
            sb.append(names[i]);
        }
        return sb.toString();
    }

    String makeAddressName() {
        //random address 생성
        StringBuilder sb = new StringBuilder();
        char[] names = new char[250];
        for (int i = 0; i < names.length; i++) {
            int num = 97 + random.nextInt(26);
            names[i] = (char) num;
            sb.append(names[i]);
        }


        return sb.toString();
    }

    void makeHuman() throws IOException {
        //사람 생성, 4기가 넘으려면 10430900명이 필요하다.
        int humanCnt = 10430900;//10430900;
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new GZIPOutputStream(
                new FileOutputStream("test.gz"))));

        for (int i = 1; i <= humanCnt; i++) {
            //데이터 입력
            out.write("number" + ":" + i);
            out.newLine();
            out.write("name : " + makeName());
            out.newLine();
            out.write("address : " + makeAddressName());
            out.newLine();
        }
        out.close();
    }

    public void Solve() throws IOException {

        makeHuman();
    }


    public static void main(String[] args) throws IOException {
        new HomeWork().Solve();
    }
}
