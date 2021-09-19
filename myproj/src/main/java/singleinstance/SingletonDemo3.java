package singleinstance;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2019-07-19
 **/
public class SingletonDemo3 {
    private static class SingletonClassInstance {
        private static final  SingletonDemo3 instance = new SingletonDemo3();
    }

    private SingletonDemo3() {
        System.out.println("SingletonDemo3");
    }

    public static SingletonDemo3 getInstance() {
        return SingletonClassInstance.instance;
    }
}
