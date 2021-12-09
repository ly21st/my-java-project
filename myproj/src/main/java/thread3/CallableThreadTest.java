package thread3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2021-12-09
 **/
public class CallableThreadTest {
    public static void main(String[] args) throws Exception {
        FutureTask<Integer> ft = new FutureTask<>(() -> {
            int i = 0;
            for (; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
            return i;
        });

        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " 的循环变量i的值" + i);
            if (i ==  2) {
                new Thread(ft, "有返回值的线程").start();
            }
        }
        try {
            System.out.println("子线程返回值:" + ft.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


    }
}
