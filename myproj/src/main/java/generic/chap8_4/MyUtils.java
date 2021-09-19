package generic.chap8_4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2019-05-28
 **/
public class MyUtils
{
    /*
    public static <T> void copy(Collection<T> dest , Collection< ? extends T> src)
    {
        for (T ele : src)
        {
            dest.add(ele);
        }
    }
    */
    public static <T> T copy(Collection<? super T> dest , Collection<T> src)
    {
        T last = null;
        for (T ele  : src)
        {
            last = ele;
            dest.add(ele);
        }
        return last;
    }

    public static void main(String[] args)
    {
        List<Number> ln = new ArrayList<Number>();
        List<Integer> li = new ArrayList<Integer>();
        li.add(5);
        Integer last = copy(ln , li);
        System.out.println(ln);

    }
}