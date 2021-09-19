package crazy.java.chap9.chap9_2;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2019-05-28
 **/
public class TestIdentityHashCode {
    public static void main(String []args) {
        String s1 = new String("hello");
        String s2 = new String("hello");

        System.out.println(s1.hashCode() + "------" + s2.hashCode());
        System.out.println(System.identityHashCode(s1) + "-------" + System.identityHashCode(s2));

        String s3 = "hello";
        String s4 = "hello";
        System.out.println(System.identityHashCode(s3) + "-------" + System.identityHashCode(s4));

    }
}
