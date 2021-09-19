package generic.chap8_3;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2019-05-28
 **/
public class Canvas
{
    //同时在画布上绘制多个形状
    public void drawAll(List<? extends Shape> shapes)
    {
        for (Shape s : shapes)
        {
            s.draw(this);
        }
    }
    public static void main(String[] args)
    {
        List<Circle> circleList = new ArrayList<Circle>();
        circleList.add(new Circle());
        Canvas c = new Canvas();
        c.drawAll(circleList);
    }
}
