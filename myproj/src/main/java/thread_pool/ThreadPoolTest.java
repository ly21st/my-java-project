package thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2021-12-09
 **/
public class ThreadPoolTest {
    public static void main(String[] args) {
        // 缓冲型线程池
//        cacheThreadTest();

        // 固定大小线程池
//        fixTheadPoolTest();

        // 单一线程池
//        singleTheadPoolTest();

        // 创建固定大小线程池，支持周期任务调度
        sceduleThreadPool();
    }

    public static void cacheThreadTest() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 1; i <= 10; i++) {
            final int ii = i;

            try {
                Thread.sleep(ii * 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            executorService.execute(() -> {
                System.out.println("执行线程:" + Thread.currentThread().getName() + " " + ii);
            });
        }
    }

    public static void fixTheadPoolTest() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int ii = i;
            fixedThreadPool.execute(() -> {
                System.out.println("线程名称：" + Thread.currentThread().getName() + "，执行" + ii);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }


    public static void singleTheadPoolTest() {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int ii = i;
            pool.execute(() -> System.out.println(Thread.currentThread().getName() + "=>" + ii));
        }
    }


    public static void sceduleThreadPool() {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        Runnable r1 = () -> System.out.println("线程名称：" + Thread.currentThread().getName() + "，执行:3秒后执行");
        scheduledThreadPool.schedule(r1, 3, TimeUnit.SECONDS);
        Runnable r2 = () -> System.out.println("线程名称：" + Thread.currentThread().getName() + "，执行:延迟2秒后每3秒执行一次");
        scheduledThreadPool.scheduleAtFixedRate(r2, 2, 3, TimeUnit.SECONDS);
        Runnable r3 = () -> System.out.println("线程名称：" + Thread.currentThread().getName() + "，执行:普通任务");
        for (int i = 0; i < 5; i++) {
            scheduledThreadPool.execute(r3);
        }
    }
}
