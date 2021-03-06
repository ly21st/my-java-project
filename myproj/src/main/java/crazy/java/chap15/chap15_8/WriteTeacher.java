package crazy.java.chap15.chap15_8;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
/**
 * Description:
 * <br/>Copyright (C), 2005-2008, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class WriteTeacher
{
	public static void main(String[] args) 
	{
		ObjectOutputStream oos = null;
		try
		{

			String path = System.getProperty("user.dir");
			String file = path + File.separator + "src/main/java/crazy/java/chap15/chap15_8/teacher.txt";
			System.out.println("file:" + file);

			//创建一个ObjectOutputStream输出流
			oos = new ObjectOutputStream(
					new FileOutputStream(file));
			Person per = new Person("孙悟空", 500);
			Teacher t1 = new Teacher("唐僧" , per);
			Teacher t2 = new Teacher("菩提祖师" , per);
			//依次将四个对象写入输出流
			oos.writeObject(t1);
			oos.writeObject(t2);
			oos.writeObject(per);
			oos.writeObject(t2);

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
