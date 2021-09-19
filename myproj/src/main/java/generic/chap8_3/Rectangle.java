package generic.chap8_3;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2019-05-28
 **/
public class Rectangle extends Shape {
    @Override
    public void draw(Canvas c) {
        System.out.println("把一个矩形画在画布" + c + "上");
    }
}
