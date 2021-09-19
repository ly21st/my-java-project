package crazy.java.chap15.chap15_8.replace;

import java.io.*;
import java.util.*;
/**
 * Description:
 * <br/>Copyright (C), 2005-2008, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class ReplaceTest
{
	public static void main(String[] args) 
	{
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		try
		{
			String path = System.getProperty("user.dir");
			String file = path + File.separator + "src/main/java/crazy/java/chap15/chap15_8/replace/replace.txt";
			System.out.println("file:" + file);


			//创建一个ObjectOutputStream输入流
			oos = new ObjectOutputStream(
				new FileOutputStream(file));
			Person per = new Person("孙悟空", 500);
			//系统会将per对象转换字节序列并输出
			oos.writeObject(per);
			//创建一个ObjectInputStream输入流
			ois = new ObjectInputStream(
				new FileInputStream(file));
			ArrayList list = (ArrayList)ois.readObject();
			System.out.println(list);
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
