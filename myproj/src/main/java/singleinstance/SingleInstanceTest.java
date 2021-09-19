package singleinstance;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2019-07-19
 **/
public class SingleInstanceTest {
    public static void main(String[] args) {
        ImageLoader imageLoader = ImageLoader.getInstance();

        SingletonDemo2 singletonDemo2 = SingletonDemo2.getInstance();

        SingletonDemo5 singletonDemo5 = SingletonDemo5.getInstance();

        SingletonDemo3 singletonDemo3 = SingletonDemo3.getInstance();

    }
}


enum SingletonDemo4 {

    //枚举元素本身就是单例
    INSTANCE;

    //添加自己需要的操作
    public void singletonOperation(){
    }

}
