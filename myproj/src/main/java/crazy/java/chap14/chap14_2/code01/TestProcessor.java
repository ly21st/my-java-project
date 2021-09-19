package crazy.java.chap14.chap14_2.code01;

import java.lang.reflect.Method;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2019-05-29
 **/

public class TestProcessor
{
    public static void process(String clazz)
            throws ClassNotFoundException
    {
        int passed = 0;
        int failed = 0;

        for (Method m : Class.forName(clazz).getMethods())
        {
            //如果包含@Testable标记注释
            if (m.isAnnotationPresent(Testable.class))
            {
                try
                {

                    m.invoke(null);

                    passed++;
                }
                catch (Exception ex)
                {
                    System.out.printf("方法" + m + "运行失败，异常：" + ex.getCause() + "\n");
                    failed++;
                }
            }
        }
        //统计测试结果
        System.out.printf("共运行了:" + (passed + failed)+ "个方法，其中：\n" +
                "失败了:" + failed + "个，\n" +
                "成功了:" + passed + "个！\n");
    }
}
