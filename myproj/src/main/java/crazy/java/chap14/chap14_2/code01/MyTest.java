package crazy.java.chap14.chap14_2.code01;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2019-05-29
 **/
public class MyTest
{
    //ʹ��@Testable���ע��ָ���÷����ǿɲ��Ե�
    @Testable
    public static void m1()
    {
    }
    public static void m2()
    {
    }
    //ʹ��@Testable���ע��ָ���÷����ǿɲ��Ե�
    @Testable
    public static void m3()
    {
        throw new RuntimeException("Boom");
    }
    public static void m4()
    {
    }
    //ʹ��@Testable���ע��ָ���÷����ǿɲ��Ե�
    @Testable
    public static void m5()
    {
    }
    public static void m6()
    {
    }
    //ʹ��@Testable���ע��ָ���÷����ǿɲ��Ե�
    @Testable
    public static void m7()
    {
        throw new RuntimeException("Crash");
    }
    public static void m8()
    {
    }
}
