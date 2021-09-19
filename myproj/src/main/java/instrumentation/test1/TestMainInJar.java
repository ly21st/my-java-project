package instrumentation.test1;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2019-07-30
 **/
public class TestMainInJar {
    public static void main(String[] args) {
        System.out.println(new TransClass().getNumber());
    }
}