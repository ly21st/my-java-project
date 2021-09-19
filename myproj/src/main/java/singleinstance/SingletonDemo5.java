package singleinstance;

/**
 * @description: Double CheckLock实现单例：DCL也就是双重锁判断机制（由于JVM底层模型原因，偶尔会出问题，不建议使用）
 * @author: LiYuan
 * @version: 1.0
 * @create: 2019-07-19
 **/
public class SingletonDemo5 {
    private volatile static SingletonDemo5 instance;

    private SingletonDemo5() {
        System.out.println("SingletonDemo5");
    }

    public static SingletonDemo5 getInstance() {
        if (instance == null) {
            synchronized (SingletonDemo5.class) {
                if (instance == null) {
                    instance = new SingletonDemo5();
                }
            }
        }
        return instance;
    }
}
