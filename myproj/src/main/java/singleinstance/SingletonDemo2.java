package singleinstance;

/**
 * @description: 懒汉式，线程安全，但调用效率不高，但是能延时加载
 * @author: LiYuan
 * @version: 1.0
 * @create: 2019-07-19
 **/
public class SingletonDemo2 {
    private static SingletonDemo2 instance;

    private SingletonDemo2() {
        System.out.println("SingletonDemo2");
    }

    public static synchronized SingletonDemo2 getInstance() {
        if (instance == null) {
            instance = new SingletonDemo2();
        }
        return instance;
    }
}
