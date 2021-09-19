package crazy.java.chap14.chap14_1;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2019-05-29
 **/
public class Fruit {
    public void foo() {
        System.out.println("水果的info方法...");
    }
}

class Apple extends Fruit {
    @Override
    public void foo() {
        System.out.println("苹果重写水果的info方法...");
    }
}
