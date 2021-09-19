package crazy.java.chap9.chap9_2;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2019-05-29
 **/
public class TestRuntime
{
    public static void main(String[] args)
    {
        Runtime rt = Runtime.getRuntime();
        System.out.println("处理器数量：" + rt.availableProcessors());
        System.out.println("空闲内存数：" + rt.freeMemory());
        System.out.println("总内存数：" + rt.totalMemory());
        System.out.println("可用最大内存数：" + rt.maxMemory());
    }
}
