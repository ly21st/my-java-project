package generic;

/**
 * @description: A2
 * @author: LiYuan
 * @version: 1.0
 * @create: 2019-05-27
 **/
public class A2 extends Apple {
    @Override
    public String getInfo() {
        return super.getInfo().toString();
    }

    public static void main(String []args) {
        A2 a2 = new A2();
        System.out.println(a2.getInfo());
    }
}
