package crazy.java.chap15.chap15_8;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2019-07-05
 **/
import java.io.*;

/**
 * Description:
 * <br/>Copyright (C), 2005-2008, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class ReadObject
{
    public static void main(String[] args)
    {
        ObjectInputStream ois = null;
        try
        {
            String path = System.getProperty("user.dir");
            String file = path + File.separator + "src/main/java/crazy/java/chap15/chap15_8/object.txt";
            System.out.println("file:" + file);

            //创建一个ObjectInputStream输出流
            ois = new ObjectInputStream(
                    new FileInputStream(file));
            //从输入流中读取一个Java对象，并将其强制类型转换为Person类
            Person p = (Person)ois.readObject();
            System.out.println("名字为：" + p.getName()
                    + "\n年龄为：" + p.getAge());
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                if (ois != null)
                    ois.close();
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }
}
