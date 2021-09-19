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
public class Test
{
    //声明一个泛型方法，该泛型方法中带一个T形参
//	static <T> void test(Collection<T> a, Collection<T> c)
    static <T> void test(Collection<? extends T> a, Collection<T> c)

    {
        for (T o : a)
        {
            c.add(o);
        }
    }

    public static <T,S extends T> void copy(List<T> dest, List<S> src) {
        System.out.println("good");
    }

    public static <T,S extends T> void copy2(List<T> dest, List<? extends T> src) {
        System.out.println("good");
    }

    public static <T,S extends T> void copy3(List<T> dest, List<S> src) {
        System.out.println("good");
    }

    public static void main(String[] args)
    {
        List<Object> ao = new ArrayList<Object>();
        List<String> as = new ArrayList<String>();
        //下面代码将产生编译错误
        test(as , ao);
    }
}
