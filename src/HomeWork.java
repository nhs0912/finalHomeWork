import java.util.Random;

public class HomeWork {

    Human[] humans;
    Random random = new Random();
    char[] tmpArr;

    char[] makeName() {
        //random name 생성
        char[] names = new char[100];
        for (int i = 0; i < names.length; i++) {
            int num = 97 + random.nextInt(26);
            names[i] = (char) num;
        }
        return names;
    }

    char[] makeAddressName() {
        //random address 생성

        char[] names = new char[250];
        for (int i = 0; i < names.length; i++) {
            int num = 97 + random.nextInt(26);
            names[i] = (char) num;
        }
        return names;
    }

    void makeHuman() {
        //사람 생성, 4기가 넘으려면 6430900명이 필요하다.

        int humanCnt = 6430900;
        humans = new Human[humanCnt];
        for (int i = 1; i <= humanCnt; i++) {
            humans[i] = new Human(i, makeName(), makeAddressName());
            if (i % 1000000 == 0)
                System.out.println(i);

        }
    }

    public void Solve() {
//        tmpArr = makeName();
//        for (char ch : tmpArr) {
//            System.out.print(ch);
//        }
//        System.out.println();
        makeHuman();

    }

    public static void main(String[] args) {
        new HomeWork().Solve();
    }
}
