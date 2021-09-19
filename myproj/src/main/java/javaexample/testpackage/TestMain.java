package javaexample.testpackage;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2019-06-09
 **/
//public class TestMain {
//    public static void main(String[] args) {
//        System.out.println(TestMain.class.getResource(""));
//        System.out.println(TestMain.class.getResource("/"));
//    }
//}


public class TestMain {

    public static void main(String[] args) {
        System.out.println(TestMain.class.getResource(""));
        System.out.println(TestMain.class.getResource("/"));

        System.out.println(TestMain.class.getResource("2.properties"));

        System.out.println(TestMain.class.getResource("subpackage/3.properties"));

        System.out.println(TestMain.class.getResource("/1.properties"));
    }
}