package generic.chap8_3;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2019-05-28
 **/
public class Circle extends Shape {
    @Override
    public void draw(Canvas c) {
        System.out.println("在画布" + c + "画一个圆");
    }
}
