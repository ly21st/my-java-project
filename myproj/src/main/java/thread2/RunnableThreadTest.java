package thread2;

import org.junit.Test;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2021-12-09
 **/
public class RunnableThreadTest {
    // 目的是为了代码的重用
    public static void threadRunCode_Static() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    // 目的是为了代码的重用，非静态方法
    public void threadRunCode() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    @Test
    public void testStatic() throws Exception {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 2) {
                new Thread(RunnableThreadTest::threadRunCode_Static, "线程1").start();
                new Thread(RunnableThreadTest::threadRunCode_Static, "线程2").start();
            }
        }
        Thread.sleep(5000);
    }

    @Test
    public void testNoStatic() throws Exception {
        // 重用非静态方法中的代码，使用方法引用
        RunnableThreadTest temp = new RunnableThreadTest();
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 2) {
                new Thread(temp::threadRunCode, "线程1").start();
                new Thread(temp::threadRunCode, "线程2").start();
            }
        }
        Thread.sleep(5000);
    }


    @Test
    public void testLambda() throws Exception {
        // 重用静态方法中的代码【使用方法引用】
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 2) {
                new Thread(() -> {
                    for (int b = 0; b < 5; b++) {
                        System.out.println(Thread.currentThread().getName() + " " + b);
                    }
                },"线程1").start();
                new Thread(() -> {
                    for (int b = 0; b < 5; b++) {
                        System.out.println(Thread.currentThread().getName() + " " + b);
                    }
                },"线程2").start();
            }
        }
        Thread.sleep(5000);
    }


}

















