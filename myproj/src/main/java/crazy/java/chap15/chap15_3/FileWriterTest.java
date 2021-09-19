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

            //创建字符输出流
            fw = new FileWriter(file);
            fw.write("锦瑟 - 李商隐\r\n");
            fw.write("锦瑟无端五十弦，一弦一柱思华年。\r\n");
            fw.write("庄生晓梦迷蝴蝶，望帝春心托杜鹃。\r\n");
            fw.write("沧海月明珠有泪，蓝田日暖玉生烟。\r\n");
            fw.write("此情可待成追忆，只是当时已惘然。\r\n");
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        finally
        {
            //使用finally块来关闭文件输出流
            if (fw != null)
            {
                fw.close();
            }
        }
    }
}
