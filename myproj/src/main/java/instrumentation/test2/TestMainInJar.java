package instrumentation.test2;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2019-07-30
 **/

public class TestMainInJar {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(new TransClass().getNumber());
        int count = 0;
        while (true) {
            Thread.sleep(500);
            count++;
            int number = new TransClass().getNumber();
            System.out.println(number);
            if (3 == number || count >= 10) {
                break;
            }
        }
    }
}