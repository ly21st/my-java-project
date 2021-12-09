package thread;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2021-12-09
 **/
public class FirstThreadTest extends Thread {
    int i = 0;

    public void run() {
        for (; i < 5; i++) {
            System.out.println(getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            if (i == 2) {
                new FirstThreadTest().start();
                new FirstThreadTest().start();
            }
        }
    }
}










