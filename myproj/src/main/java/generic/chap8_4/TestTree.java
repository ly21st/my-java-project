package generic.chap8_4;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2019-05-28
 **/
public class TestTree {
    public static void main(String[] args) {
        TreeSet<String> ts1 = new TreeSet<String>(new Comparator<Object>() {
            @Override
            public int compare(Object fst, Object snd) {
                return fst.hashCode() - snd.hashCode();
            }
        });

        ts1.add("hello");
        ts1.add("wa");

        TreeSet<String> ts2 = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String fst, String snd) {
                return -(fst.length() - snd.length());
            }
        });

        ts2.add("hello");
        ts2.add("wa");

        System.out.println(ts1);
        System.out.println(ts2);
    }
}
