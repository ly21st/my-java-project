import java.util.Arrays;

/**
 * @description:
 * @auther: LiYuan liyuan@agree.com.cn
 * @version: 1.0
 * @ create: 2019-01-25 12:42
 **/
public class HelloWorld {
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    int x;
    int y;

    public static void main(String []argv) {
        System.out.println("hello,world");
        System.out.println("this is a 你好");

        test1();
    }

    public static void test1() {
        String []s = getString();
        System.out.println(Arrays.toString(s));
    }

    public static String[] getString() {
        return new String[] { "hellohaha" };
    }
}
