package generic.chap8_3;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2019-05-28
 **/
public class Apple<T extends Number> {
    T col;
    public static void main(String[] args) {
        Apple<Integer> ai = new Apple<>();
        Apple<Double> ad = new Apple<>();
    }
}
