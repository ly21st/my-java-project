package generic.chap8_3;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2019-05-28
 **/
public class Test {

//    public void test(List<Object> c) {
//        for (int i = 0; i < c.size(); i++) {
//            System.out.println(c.get(i));
//        }
//    }

//    public void test(List c) {
//        for (int i = 0; i < c.size(); i++) {
//            System.out.println(c.get(i));
//        }
//    }

    public void test(List<?> c) {
        for (int i = 0; i < c.size(); i++) {
            System.out.println(c.get(i));
        }
    }

    public static void main(String []args) {
        Test t = new Test();
        List<String> listStr = new ArrayList<>();
        t.test(listStr);
    }
}
