/**
 * Created by heeseoknoh on 30/01/2018.
 */

class Test extends Thread {

    public void run() {
        System.out.println(" is executing....");
    }

}

public class ThreadPractice {


    public static void main(String[] args) throws InterruptedException {


        for (int i = 0; i < 10; i++) {
            Test t = new Test();
            t.start();
            t.sleep(3000);
            System.out.println(i);
        }


    }
}
