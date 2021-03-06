package generic.chap8_5;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2019-05-28
 **/
class Apple<T extends Number>
{
    T size;

    public Apple()
    {
    }

    public Apple(T size)
    {
        this.size = size;
    }

    public void setA(T size)
    {
        this.size = size;
    }
    public T getSize()
    {
        return this.size;
    }
}

public class TestErasure
{
    public static void main(String[] args)
    {
        Apple<Integer> a = new Apple<Integer>(6);
        //a的getSize方法返回Integer对象
        Integer as = a.getSize();
        //把a对象赋给Apple变量，会丢失尖括号里的类型信息
        Apple b = a;
        //b只知道size的类型是Number
        Number size1 = b.getSize();
        //下面代码引起编译错误
//        Integer size2 = b.getSize();
        Number size2 = b.getSize();
    }
}
