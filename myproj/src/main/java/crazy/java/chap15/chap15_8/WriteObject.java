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
public class WriteObject
{
    public static void main(String[] args)
    {
        ObjectOutputStream oos = null;
        try
        {
            String path = System.getProperty("user.dir");
            String file = path + File.separator + "src/main/java/crazy/java/chap15/chap15_8/object.txt";
            System.out.println("file:" + file);

            //创建一个ObjectOutputStream输出流
            oos = new ObjectOutputStream(
                    new FileOutputStream(file));
            Person per = new Person("孙悟空", 500);
            //将per对象写入输出流
            oos.writeObject(per);
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                if (oos != null)
                    oos.close();
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }
}
