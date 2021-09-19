package crazy.java.chap15.chap15_6;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2019-07-05
 **/
import java.util.*;
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
public class WriteToProcess
{
    public static void main(String[] args)
    {
        PrintStream ps = null;
        try
        {
            //运行java ReadStandard命令，返回运行该命令的子进程
            Process p = Runtime.getRuntime().exec("java ReadStandard");
            //以p进程的输出流创建PrintStream对象
            //这个输出流对本程序是输出流，对p进程则是输入流）
            ps = new PrintStream(p.getOutputStream());
            //向ReadStandard程序写入内容，这些内容将被ReadStandard读取
            ps.println("普通字符串");
            ps.println(new WriteToProcess());
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            if (ps != null)
                ps.close();
        }
    }
}
//定义一个ReadStandard类，该类可以接受标准输入，
//并将标准输入写入out.txt文件。
class ReadStandard
{
    public static void main(String[] args) throws Exception
    {
        String path = System.getProperty("user.dir");
        String file = path + File.separator + "src/main/java/crazy/java/chap15/chap15_6/out.txt";
        System.out.println("file:" + file);

        //使用System.in创建Scanner对象，用于获取标准输入
        Scanner sc = new Scanner(System.in);
        PrintStream ps = new PrintStream(
                new FileOutputStream(file));
        //增加下面一行将只把回车作为分隔符
        sc.useDelimiter("\n");
        //判断是否还有下一个输入项
        while(sc.hasNext())
        {
            //输出输入项
            ps.print("键盘输入的内容是：" + sc.next());
        }
        ps.close();
    }
}
