package crazy.java.chap15.chap15_3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2019-07-04
 **/
/**
 * Description:
 * <br/>Copyright (C), 2005-2008, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class FileWriterTest
{
    public static void main(String[] args) throws IOException
    {
        FileWriter fw = null;
        try
        {
            String path = System.getProperty("user.dir");
            String file = path + File.separator + "src/main/java/crazy/java/chap15/chap15_3/poem.txt";
            System.out.println("file:" + file);

            //�����ַ������
            fw = new FileWriter(file);
            fw.write("��ɪ - ������\r\n");
            fw.write("��ɪ�޶���ʮ�ң�һ��һ��˼���ꡣ\r\n");
            fw.write("ׯ�������Ժ��������۴����жž顣\r\n");
            fw.write("�׺����������ᣬ������ů�����̡�\r\n");
            fw.write("����ɴ���׷�䣬ֻ�ǵ�ʱ���Ȼ��\r\n");
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        finally
        {
            //ʹ��finally�����ر��ļ������
            if (fw != null)
            {
                fw.close();
            }
        }
    }
}
