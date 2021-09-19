package crazy.java.chap15.chap15_7;

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
public class RandomAccessFileTest
{
    public static void main(String[] args)
    {
        RandomAccessFile raf = null;
        try
        {
            String path = System.getProperty("user.dir");
            String file = path + File.separator + "src/main/java/crazy/java/chap15/chap15_7/RandomAccessFileTest.java";
            System.out.println("file:" + file);

            //以只读方式打开一个RandomAccessFile对象
            raf = new RandomAccessFile(file, "r");
            //获取RandomAccessFile对象文件指针的位置，初始位置是0
            System.out.println("RandomAccessFile的文件指针的初始位置：" + raf.getFilePointer());
            //移动raf的文件记录指针的位置
            raf.seek(300);
            byte[] bbuf = new byte[1024];
            //用于保存实际读取的字节数
            int hasRead = 0;
            //使用循环来重复“取水”过程
            while ((hasRead = raf.read(bbuf)) > 0 )
            {
                //取出“竹筒”中水滴（字节），将字节数组转换成字符串输出！
                System.out.print(new String(bbuf , 0 , hasRead ));
            }

            long size = raf.getFilePointer();
            System.out.println("--------long:" + size);
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                if (raf != null)
                {
                    raf.close();
                }
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }

    }
}
