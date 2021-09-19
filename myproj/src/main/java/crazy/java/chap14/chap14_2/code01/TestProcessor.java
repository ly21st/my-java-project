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
            //�������@Testable���ע��
            if (m.isAnnotationPresent(Testable.class))
            {
                try
                {

                    m.invoke(null);

                    passed++;
                }
                catch (Exception ex)
                {
                    System.out.printf("����" + m + "����ʧ�ܣ��쳣��" + ex.getCause() + "\n");
                    failed++;
                }
            }
        }
        //ͳ�Ʋ��Խ��
        System.out.printf("��������:" + (passed + failed)+ "�����������У�\n" +
                "ʧ����:" + failed + "����\n" +
                "�ɹ���:" + passed + "����\n");
    }
}
