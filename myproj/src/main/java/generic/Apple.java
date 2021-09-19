package generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @description: apple
 * @author: LiYuan
 * @version: 1.0
 * @create: 2019-05-27
 **/
public class Apple<T> {
    private T info;
    public Apple() {}
    public Apple(T info) {
        this.info = info;

    }

    public void setInfo(T info) {
        this.info = info;
    }

    public T getInfo() {
        return info;
    }

    public static void main(String []args) {
        Apple<String> a1 = new Apple<>("苹果");
        System.out.println(a1.getInfo());

        Apple<Double> a2 = new Apple<>(5.67);
        System.out.println(a2.getInfo());


        List<String> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        System.out.println(l1.getClass() == l2.getClass());

        Collection cs = new ArrayList<>();
        if (cs instanceof List) {
            System.out.println("cs instance test");
        }
    }
}
