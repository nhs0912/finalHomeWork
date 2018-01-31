import java.io.*;
import java.util.Date;
import java.util.Random;
import java.util.zip.GZIPOutputStream;

public class HomeWork {

    Human[] humans;
    Random random = new Random();

    String makeHeader() {

        char[] headers = new char[50];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < headers.length; i++) {
            int num = 97 + random.nextInt(26);
            headers[i] = (char) num;
            sb.append(headers[i]);
        }
        return sb.toString();
    }

    String makeTrailer() {

        Date date = new Date();
        String currentTime = date.toString();
        return currentTime;
    }

    String makeName() {
        //random name 생성
        char[] names = new char[50];
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
        char[] addressArr = new char[250];
        for (int i = 0; i < addressArr.length; i++) {
            int num = 97 + random.nextInt(26);
            addressArr[i] = (char) num;
            sb.append(addressArr[i]);
        }


        return sb.toString();
    }

    void makeHuman() throws IOException {
        //사람 생성
        int humanCnt = 20430900;
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new GZIPOutputStream(
                new FileOutputStream("test.gz"))));

        for (int i = 1; i <= humanCnt; i++) {
            //데이터 입력

            out.write("header: " + makeHeader());
            out.newLine();
            out.write("number" + ":" + i);
            out.newLine();
            out.write("name : " + makeName());
            out.newLine();
            out.write("address : " + makeAddressName());
            out.newLine();
            out.write("trailer:" + makeTrailer());
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
